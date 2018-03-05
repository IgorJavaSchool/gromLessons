package lesson10.polyexample;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Human {
    private String name;

    public Human(String name) {
        this.name = name;
    }

    void run(){
        System.out.println("Human class is coled");
        System.out.println(name + " is running");
    }
}
