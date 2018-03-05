package lesson10.polyexample;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class User extends Human {

    public User(String name) {
        super(name);
    }

    @Override
    void run() {
        System.out.println("User class is coled");
        super.run();
    }
}
