package lesson2;

public class MyArrayDataException extends NumberFormatException {

    public void geiInfo(int y, int x, String text) {
        System.out.println("\nЭто исключение MyArrayDataException: символ \"" + text + "\" вместо цифры по адресу [" + y + "][" + x + "]");
    }


}
