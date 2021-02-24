package lesson1;

public class Wall implements Obstacle {
    private double height;

    public Wall(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public boolean overcomingObstacles(Skills skills) {
        String res = "";
        if (this.height <= skills.getHeightJump()) {
            res = skills.getName() + " перепрыгнул.";
            System.out.println(res);
            return true;
        } else {
            res += skills.getName() + " не перепрыгнул.";
            System.out.println(res);
            return false;
        }
    }
}
