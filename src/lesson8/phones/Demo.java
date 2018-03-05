package lesson8.phones;

/**
 * Created by MM on 10.12.2017.
 */
public class Demo {
    public static void main(String[] args) {
        IPhone iPhone = new IPhone(110, 10.0, "China", true);
        iPhone.deliteIphoneForDb();
        iPhone.orderPhone();

    }
}
