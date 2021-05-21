package lesson1;

public class Cat implements Skills {
    private String name;
    private int speedRun;
    private double heightJump;

    public Cat(String name, int speedRun, double heightJump) {
        this.name = name;
        this.speedRun = speedRun;
        this.heightJump = heightJump;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSpeedRun() {
        return speedRun;
    }

    @Override
    public double getHeightJump() {
        return heightJump;
    }

    @Override
    public int run() {
        System.out.println("Кот " + name + " может бежать со скоростью " + getSpeedRun() + " км/ч.");
        return speedRun;
    }

    @Override
    public double jump() {
        System.out.println("Кот " + name + " может прыгнуть на высоту " + heightJump + " метров.");
        return heightJump;
    }
}
