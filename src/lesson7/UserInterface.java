package lesson7;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    public UserInterface() {
    }

    public void runTerminal() throws IOException {
        ParseMethods.initStringJsonCityList();
        ParseMethods.cityKeysList();
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
                    tempCityKey = ParseMethods.searchKey(tempCityName);
                    if (tempCityKey == null) {
                        continue;
                    } else
                        ParseMethods.voidInfo(ParseMethods.listWeatherResponse(tempCityName));
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
