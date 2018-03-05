package lesson1;


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
}
