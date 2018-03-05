package lesson4;

/**
 * Created by MM on 15.12.2017.
 */
public class QuantityFinder {
    public int findDivCount(short a, short b, int n){
        if (n < 1 || a < 0)
            return 0;
        if (a > b )
            return 0;
        int index = 0;
        for (short i = a; i <= b; i++) {
            if (i%n == 0)
                index++;
        }
        return index;
    }
}
