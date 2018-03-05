package lesson4;



/**
 * Created by MM on 20.11.2017.
 */
public class checkSum {

    public boolean compareSums(int a, int b, int c, int d){
        long sum1 = sum(a, b);
        long sum2 = sum(c, d);
        return sum1 > sum2;
    }

    public  long sum(long from, long to){
        long result = 0;
        for (long i = from; i <= to ; i++) {
            result  = result + i;
        }
        return result;
    }
}
