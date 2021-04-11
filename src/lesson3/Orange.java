package lesson3;

public class Orange extends Fruit{
private static int counter=0;
    public Orange() {
        counter++;
        this.setWeight(1.5F);
        setName("Orange"+counter);
    }



}
