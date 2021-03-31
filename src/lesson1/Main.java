package lesson1;

public class Main {

    public static void main(String[] args) {
        //----------------Задание 1-------------------------------------------------------------------------------------
        System.out.println("----------------Задание 1--------------");
        Human human = new Human("Bob", 20, 1.5);
        Cat cat = new Cat("Tom", 30, 2);
        Robot robot = new Robot("Vally", 10, 0.3);
        human.run();
        human.jump();
        cat.run();
        cat.jump();
        robot.run();
        robot.jump();

        //----------------Задание 2-------------------------------------------------------------------------------------
        System.out.println("\n----------------Задание 2--------------");
        TreadMill treadMill = new TreadMill(15);
        Wall wall = new Wall(1.6);
        treadMill.overcomingObstacles(human);
        treadMill.overcomingObstacles(cat);
        treadMill.overcomingObstacles(robot);
        wall.overcomingObstacles(human);
        wall.overcomingObstacles(cat);
        wall.overcomingObstacles(robot);

        //----------------Задание 3 и 4*--------------------------------------------------------------------------------
        System.out.println("\n----------------Задание 3 и 4*-----------");
        Skills[] athletes = {human, cat, robot};
        Obstacle[] obstacles = {treadMill, wall};
        for (int i = 0; i < athletes.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                if (obstacles[j].overcomingObstacles(athletes[i])) continue;
                else System.out.println(athletes[i].getName() + " снят с соревнований!");
                break;
            }
        }
        System.out.println("\n----------------КОНЕЦ--------------------");
    }
}
