package lesson10.polyexample;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Child extends Human {

    public Child(String name) {
        super(name);
    }

    @Override
    void run() {
        System.out.println("Child class is coled");
        super.run();
    }
}
