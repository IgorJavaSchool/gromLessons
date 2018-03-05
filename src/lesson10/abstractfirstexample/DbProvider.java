package lesson10.abstractfirstexample;

/**
 * Created by MM on 12.12.2017.
 */
public abstract class DbProvider {
    private String dbHost;

    abstract void connectToDb();

    abstract void disconnectFromDb();


    void printDbHost(String dbHost){
        System.out.println("Db host is " + dbHost);
    }
}
