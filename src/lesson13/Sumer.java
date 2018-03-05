package lesson13;

import java.util.Map;
import java.util.function.Predicate;

/**
 * Created by MM on 19.12.2017.
 */
public class Sumer implements InterfaceWithNoAbstractMethod {
    @Override
    public void printMessage(int integer) {
        System.out.println(integer);
    }

    private Predicate<Map<String, Object>> getPredicate(String pId) {
        return x-> (Boolean)x.get(pId);
    }
}
