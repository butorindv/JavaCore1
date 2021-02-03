package lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        System.out.println("------------------------Задание 1-----------------------");
        System.out.println("\n--------------------Тест вывода на экран----------------");
        Something testSomething = new Something(1, 2.5, 3.2, "Четыре", "Пять");
        System.out.println(Arrays.toString(testSomething.getObjArr()));
        System.out.println("\n------Тест метода замены элементов массива Something----");
        Something.reversArray(testSomething, 1, 4);
        System.out.println(Arrays.toString(testSomething.getObjArr()));
        System.out.println("\n---------Вариант 2: метод для массива Object------------");
        Integer[] test1 = {1, 2, 3, 4, 5};
        String[] test2 = {"1", "2", "3", "4", "5"};
        Object[] test3 = {1, 2.5, 3.2, "Четыре", "Пять"};
        reversArray(test1, 1, 3);
        reversArray(test2, 1, 3);
        reversArray(test3, 1, 3);
        System.out.println(Arrays.toString(test1) + "\n" + Arrays.toString(test2) + "\n" + Arrays.toString(test3));
        System.out.println("--------------------------------------------------------");

        System.out.println("\n------------------------Задание 2-----------------------");
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Apple apple5 = new Apple();
        Apple apple6 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Box<Apple> appleBox = new Box<>();//Создал коробку для яблок
        Box<Apple> appleBox1 = new Box<>();
        Box<Orange> orangeBox = new Box<>();//Создал коробку для апельсинов
        Collections.addAll(orangeBox, orange1, orange2, orange3);//Добавил апельсины в коробку
        Collections.addAll(appleBox, apple1, apple2, apple3);//Добавил яблоки в коробку
        Collections.addAll(appleBox1, apple4, apple5, apple6);
        Box.getInfoBox(appleBox);//Данный метод выводит информацию о содержимом коробки и ее вес
        Box.getInfoBox(orangeBox);//Данный метод выводит информацию о содержимом коробки и ее вес
        System.out.println("Сравнение коробок с разным весом - " + appleBox.compare(orangeBox));//Сравнение коробок с разным весом
        System.out.println("Сравнение коробок с одинаковым весом - " + appleBox.compare(appleBox1));//Сравнение коробок с одинаковым весом

        appleBox.movingFruits(appleBox1);//Пересыпаем яблоки в другую коробку, в которой всего 3 яблока
        System.out.print("\nПересыпаем яблоки в другую коробку, в которой всего 3 яблока\nТеперь эта пустая:    ");
        Box.getInfoBox(appleBox);
        System.out.print("А в этой увеличилось количество яблок:    ");
        Box.getInfoBox(appleBox1);
        appleBox1.movingFruits(appleBox);
        System.out.print("\nТеперь пересыпаем обратно\nТеперь эта полная:    ");
        Box.getInfoBox(appleBox);
        System.out.print("А эта пустая:    ");
        Box.getInfoBox(appleBox1);
        System.out.println("-------------------- К О Н Е Ц -------------------------");



    }

    public static void reversArray(Object[] arr, int elem1, int elem2) {
        try {
            Object[] temp = new Object[1];
            temp[0] = arr[elem1];
            arr[elem1] = arr[elem2];
            arr[elem2] = temp[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nВыход за пределы массива!" + arr.getClass().getName());
        }
    }
}
