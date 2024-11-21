import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;

// import static jdk.internal.org.jline.utils.Colors.s;

public class PhoneBook {
    // Метод, который добавляет номера в книгу
    public static void addNumber(String key, int value, Map<String, ArrayList<Integer>> map){
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }
    // Метод, который печатает список контактов
    public static void printBook(Map<String, ArrayList<Integer>> map){
//        for (var item : map.entrySet()) {
//            String phones = "";
//            for(int el: item.getValue()){
//                phones = phones + el + ", ";
//            }
//            System.out.printf("%s: %s \n", item.getKey(), phones);
        System.out.println("Before " + map);
        Map<String, ArrayList<Integer>> sorted = map.entrySet().stream()
                .peek( e -> e.getValue().sort( (a, b) -> map.get(b).size() - map.get(a).size() ) )      // sort values descending
                .sorted( (a, b) -> b.getValue().size() - a.getValue().size() )    // sort keys descending
                .collect( LinkedHashMap:: new, (m, e) -> m.put(e.getKey(), e.getValue() ), (m0, m1) -> m0.putAll(m1) );
        System.out.println("After  " + sorted);
    }



    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> bookPhone = new HashMap<>();
        addNumber("Ivanov", 123, bookPhone);
        addNumber("Ivanov", 1234, bookPhone);
        addNumber("Petrov", 546585, bookPhone);
        addNumber("Sidorov", 8956477, bookPhone);
        addNumber("Ivanov", 12356233, bookPhone);
        addNumber("Petrov", 787897, bookPhone);
        printBook(bookPhone);
    }
}