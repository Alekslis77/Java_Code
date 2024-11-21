public class Main {
    public static void main(String[] args) {
        // Создаем HashMap для хранения номеров паспортов и фамилий сотруников
        Map<String, String> passportData = new HashMap<>;

        // Добавляем данные
        passportData.put("123456", "ivanov");
        passportData.put("321456", "ivanov");
        passportData.put("234561", "ivanov");
        passportData.put("234432", "susanin");
        passportData.put("654321", "Петрова");
        passportData.put("345678", "alekseev");

        // Выводим данные по сотрудникам с фамилией "Иванов"
        String targetLastName = "ivanov";
        for (Map.Entry<String>, String) entry : passportData.entrySet()) {
            if (entry.getValue().equals(targetLastName)) {
                System.out.println("passport num: " + entry.getKey()) + ", last name: " + entry.getValue());
            }
        }
    }
}
