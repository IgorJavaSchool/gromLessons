package lesson1;


import java.util.Date;

/**
 * Created by MM on 10.12.2017.
 */
public class Abc {

    private int a;
    private  final int b;

    public Abc(int a, int b) {
        this.a = a;
        this.b = b;
    }

    private void setA(int x){
        this.a = x;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public static void main(String[] args) {
        Date date1 = new Date();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date date2 = new Date();
        System.out.println(date1.compareTo(date2));
    }
}
