package lesson5;

import java.io.*;
import java.util.Arrays;

public class MainLesson5 {

    public static void main(String[] args) throws IOException {
        System.out.println("---Домашняя работа №5---\n");
        AppData appData = new AppData("Val1,Val2,Val3");//Создали готовые заголовки
        appData.setData(new int[][]{{100, 200, 300}, {400, 500, 600}, {700, 800, 900}});
        FileWriter fileWriterHeader = new FileWriter("file1.csv", false);
        fileWriterHeader.write(appData.getHeaderString());//записали в файл заголовок
        fileWriterHeader.write(appData.stringData());//записали в файл данные
        fileWriterHeader.close();//закрыли поток вывода

        AppData appDataRead = new AppData(new FileReader("file1.csv"));
        appDataRead.readAll();//Этим методом читаем из файла и инициализируем все поля класса
        System.out.println(Arrays.toString(appDataRead.getHeader()));//проверка поля заголовки
        AppData.show2dArray(appDataRead.getData());//Проверка поля данных


    }

}
