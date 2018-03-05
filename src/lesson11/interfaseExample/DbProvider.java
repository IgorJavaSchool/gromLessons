package lesson11.interfaseExample;

/**
 * Created by MM on 12.12.2017.
 */
public interface DbProvider {

    void connectToDb();

    void disconnectFromDb();

    void encryptData();
}
