package lesson13;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by MM on 19.12.2017.
 */
public class Demo  {
    public static void main(String[] args) {
        Sumer sumer = new Sumer();
        sumer.printMessage(sumer.addNumber(2,5));

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, ( a, b) -> a.compareTo(b));
        for (String name : names){
            System.out.println(name);
        }


    }
}
