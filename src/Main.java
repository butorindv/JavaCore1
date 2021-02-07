import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(" ---Задание 1---");
        String[] stringsArray = {"кот", "олень", "волк", "собака", "лиса", "олень", "лиса", "кот", "собака", "лев",
                "клоп", "лиса", "кот", "собака", "олень", "клоп", "олень", "волк"};
        System.out.println(" a) Созданный массив:");
        System.out.println(" " + Arrays.toString(stringsArray));
        Set<String> stringsSet = new HashSet<>(Arrays.asList(stringsArray));
        System.out.println(" \n b) Список уникальных элементов:");
        System.out.println(" " + Arrays.asList(stringsSet));
        System.out.println(" \n c) Количество повторений:");
        duplicateWords(stringsArray, stringsSet);
        System.out.println(" ---------------\n");
        System.out.println(" ---Задание 2---");

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "8-999-999-99-99");
        phoneBook.add("Петров", "8-888-999-99-88");
        phoneBook.add("Иванов", "8-777-999-99-77");
        phoneBook.add("Сидоров", "8-333-999-99-66");
        phoneBook.add("Петров", "8-555-999-99-55");
        System.out.println("a) Мой get:");
        System.out.println(phoneBook.get("Иванов"));
        System.out.println("\nb) Стандартный get :");
        System.out.println(phoneBook.getMapPhoneBook());
        System.out.println(" \n-----КОНЕЦ-----\n");

    }

    public static void duplicateWords(String[] stringsArray, Set<String> stringsSet) {
        for (String tempString : stringsSet) {
            int sum = 0;
            for (String tempString2 : stringsArray) {
                if (tempString.equals(tempString2)) {
                    sum += 1;
                }
            }
            System.out.println(" " + sum + " - " + tempString);

        }
    }
}
