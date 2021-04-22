package lesson3;


import java.util.ArrayList;
import java.util.Collection;

public class Box<T extends Fruit> extends ArrayList<T> {
    private float weight;
    private T[] fruit;

    public Box(T... fruit) {

        this.fruit = fruit;
    }

    public Box(int initialCapacity) {
        super(initialCapacity);
    }

    public Box() {
    }

    public Box(Collection c) {
        super(c);
    }

    public static void getInfoBox(Box<?> box) {
        System.out.print("[ ");
        for (Fruit i : box) {
            System.out.print("(" + i.getName() + ": вес-" + i.getWeight() + ") ");
        }
        System.out.println("]");
        System.out.println("Вес коробки: " + box.getWeight() + "\n");
    }

    public float getWeight() {
        float sum = 0;
        for (int i = 0; i < toArray().length; i++) {
            sum += get(i).getWeight();
        }
        return sum;
    }

    public boolean compare(Box box) {
        if (Math.abs(this.getWeight()- box.getWeight())<0.0001) {
            return true;
        } else return false;
    }
    public void movingFruits(Box<T> box){
        for (int i=this.size()-1; i>=0 ; i--) {
            box.add(this.get(i));
            this.remove(i);
        }

    }
}
