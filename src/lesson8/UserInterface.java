package lesson8;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    public UserInterface() {
    }

    public void runTerminal() throws IOException {
        RepositoryDB repositoryDB = new RepositoryDB();
        ParseMethods.initStringJsonCityList();
        ParseMethods.cityKeysList();
        String tempCityName;
        String tempCityKey;
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Введите:\n1 - Узнать погоду;\n2 - Посмотреть базу данных\n3 - Выйти из программы.");
                switch (sc.nextInt()) {
                    case 1:
                        break;
                    case 2:
                        repositoryDB.showDateBase();
                        continue;
                    case 3:
                        System.out.println("Выход из программы .......");
                        sc.close();
                        System.exit(0);
                    default:
                        System.out.println("Неверный ввод!");
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

                    repositoryDB.addToDB(ParseMethods.listWeatherResponse(tempCityName));
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
