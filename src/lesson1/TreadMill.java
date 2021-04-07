package lesson1;

public class TreadMill implements Obstacle {
    private int speed;

    public TreadMill(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public boolean overcomingObstacles(Skills skills) {
        if (this.speed <= skills.getSpeedRun()) {
            System.out.println(skills.getName() + " пробежал.");
            return true;
        } else {
            System.out.println(skills.getName() + " не пробежал.");
            return false;
        }
    }
}
