package lesson13;

/**
 * Created by MM on 19.12.2017.
 */
public interface InterfaceWithNoAbstractMethod {
    void printMessage(int integer);
    default int addNumber(int a, int b){
        return a + b;
    }
}
