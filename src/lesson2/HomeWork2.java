package lesson2;
public class HomeWork2 {

    public static void main(String[] args) {
        String[][] test1 = {{"1", "1", "1", "1"}, {"2", "2", "2", "2"}, {"3", "3", "3", "3"}, {"4", "4", "4", "4"}};
        String[][] test2 = {{"1", "1", "1", "1"}, {"2", "2", "2", "2"}, {"3", "3", "3", "3"}, {"3", "3", "3", "3"}, {"3", "3", "3", "3"}};
        String[][] test3 = {{"1"}, {"2", "2", "2", "2"}, {"3", "3", "3", "3"}, {"4", "4", "4", "4"}};
        String[][] test4 = {{"1", "1", "k", "1"}, {"2", "2", "2", "2"}, {"3", "3", "3", "3"}, {"4", "4", "4", "4"}};

        //Зднсь наглядней будет закомментировать все 5 вызовов метода и раскомментирывать по-одному.
        System.out.println("\n------------------\n      test1");
        arrayInfo(test1);// Нормальный массив
        System.out.println("\n------------------\n      test2");
        arrayInfo(test2);//5 строк
        System.out.println("\n------------------\n      test3");
        arrayInfo(test3);// 1 элемент в строке
        System.out.println("\n------------------\n      test4");
        arrayInfo(test4);// буква вместо цыфры
        System.out.println("\n------------------\n      END");
    }

    public static void arrayInfo(String[][] arr4x4) {
        int y = 0;
        int x = 0;
        try {
            if (arr4x4.length != 4) throw new MyArraySizeException();
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                y = i;
                try {
                    if (arr4x4[i].length != 4) throw new MyArraySizeException();
                    System.out.print("[");
                    for (int j = 0; j < 4; j++) {
                        x = j;
                        System.out.print(" \"" + arr4x4[i][j] + "\" ");
                        sum += Integer.parseInt(arr4x4[i][j]);
                    }
                    System.out.println("]");
                } catch (MyArraySizeException e) {
                    System.out.println("Это исключение MyArraySizeException относится к несоответствию количеству ВТОРОГО измерения массива");
                    return; //Выход из метода, что бы он не продолжал выводить оставшиеся элементы массива.
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException();
                }
            }
            System.out.println("Сумма равна: " + sum);
        } catch (MyArraySizeException e) {
            System.out.println("Это исключение MyArraySizeException относится к несоответствию количеству ПЕРВОГО измерения массива");
        } catch (MyArrayDataException e) {
            e.geiInfo(y, x, arr4x4[y][x]);
        }
    }
}
