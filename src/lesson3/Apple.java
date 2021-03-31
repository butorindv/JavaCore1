package lesson3;

public class Apple extends Fruit {
    private static int counter = 0;
    public Apple() {
        counter++;
        this.setWeight(1.0F);
        setName("Apple"+counter);
    }


}
