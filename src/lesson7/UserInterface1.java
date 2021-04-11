package lesson7;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface1 {
    public UserInterface1() {
    }

    public void runTerminal() throws IOException {
        ParseMethods1.initStringJsonCityList();
        ParseMethods1.cityKeysList();
        String tempCityName;
        String tempCityKey;
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Введите:\n1 - Узнать погоду;\n2 - Выйти из программы.");
                switch (sc.nextInt()) {
                    case 1:
                        break;
                    case 2:
                        System.out.println("Выход из программы .......");
                        sc.close();
                        System.exit(0);
                    default:
                        System.out.println("Не верный ввод!");
                        continue;
                }
                while (true) {
                    System.out.println("Введите название города на английском!");
                    tempCityName = sc.next();
                    tempCityKey = ParseMethods1.searchKey(tempCityName);
                    if (tempCityKey == null) {
                        continue;
                    } else
                        ParseMethods1.voidInfo(ParseMethods1.listWeatherResponse(tempCityName));
                    break;
                }
                System.out.println("Хотите продолжить?");
            }
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели букву вместо цифры\nВыход из программы.........");
            System.exit(0);
        }


    }

}