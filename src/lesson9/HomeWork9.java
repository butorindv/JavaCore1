package lesson9;

import java.util.*;
import java.util.stream.Collectors;

public class HomeWork9 {

    public static void main(String[] args) {

        Course course = new Predmet("AAA");
        Course course1 = new Predmet("BBB");
        Course course2 = new Predmet("CCC");
        Course course3 = new Predmet("DDD");
        Course course4 = new Predmet("EEE");
        Course course5 = new Predmet("FFF");
        Course course6 = new Predmet("JJJ");
        Course course7 = new Predmet("HHH");
        Course course8 = new Predmet("XXX");
        Course course9 = new Predmet("YYY");

        Student studentBob = new Human("Bob", Arrays.asList(course, course1, course2, course3));
        Student studentTom = new Human("Tom", Arrays.asList(course1, course5, course6));
        Student studentSam = new Human("Sam", Arrays.asList(course1, course5, course3, course8, course9));
        Student studentDin = new Human("Din", Arrays.asList(course, course2));
        System.out.println("--------------------У кого какие курсы--------------------");
        List<Student> students = Arrays.asList(studentBob, studentTom, studentSam, studentDin);
        System.out.println(students.toString());
        System.out.println("----------------------------------------------------------");
        System.out.println("1. Вывод всех уникальных курсов которые посещают студенты");
        System.out.println(streamCourses(students));
        System.out.println("----------------------------------------------------------");
        System.out.println("2. ТОП-3 любознательных студентов");
        System.out.println(inquisitive(students));
        System.out.println("----------------------------------------------------------");
        System.out.println("3. Список студентов которые посещают заданный курс");
        System.out.println(studentsThisCourse(students, course));
        System.out.println("-------------------------КОНЕЦ----------------------------");


    }


    public static Set<String> streamCourses(List<Student> students) {
        List<Course> uniqueCourse = new ArrayList<Course>();
        return students.stream()
                .map(Student::getAllCourses)
                .flatMap(List::stream)
                .map(Course::getPrName)
                .collect(Collectors.toSet());
    }

    //Задал тип String, что бы в консоль выводил только имена студентов без списка курсов
//    public static List<lesson9.Student> inquisitive(List<lesson9.Student> students) { //Так будет со списком курсов
    public static List<String> inquisitive(List<Student> students) { //Так просто имена

        return students.stream()
                .sorted(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o2.getAllCourses().size() - o1.getAllCourses().size();
                    }
                })
                .limit(3)
                .map(student -> student.getName())
                .collect(Collectors.toList());
    }

    //То же самое на счет <String>, а не <lesson9.Student>. Сделал, что бы только имена отображались
    public static List<String> studentsThisCourse(List<Student> students, Course course) {
        return students.stream()
                .filter(a -> a.getAllCourses().stream().anyMatch(course1 -> course1.equals(course)))
                .map(student -> student.getName())
                .collect(Collectors.toList());


    }


}

class Human implements Student {
    private String name;
    private List<Course> courses;


    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }


    public Human(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<Course> getAllCourses() {

        return this.courses.stream()
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "\nСтудент " + name + " посещает курсы: " + courses;
    }
}

class Predmet implements Course {
    private String namePred;

    public Predmet(String namePred) {
        this.namePred = namePred;
    }

    public String getNamePred() {
        return namePred;
    }

    public void setNamePred(String namePred) {
        this.namePred = namePred;
    }

    @Override
    public String getPrName() {
        return this.namePred;
    }

    @Override
    public String toString() {
        return getNamePred();
    }
}

interface Student {
    String getName();

    List<Course> getAllCourses();


}

interface Course {
    String getPrName();
}
