package lesson6;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by MM on 10.12.2017.
 */
public class Demo {
    public static void main(String[] args) {
        User user = new User();
        User user1 = new User();
        User user2 = new User();
        User user3 = new User("Jack");
        Car car = new Car(1000, 2015, "Anton");
        DbConnector dbConnector = new DbConnector();




        /**
         * Tests three methods of class Order.
         */

        Order order = new Order(100, new Date(), false, null, "Dnepr", "Ukraine", "Buy");
        Order order1 = new Order(0, null, false, null, null, null, null);
        Order order2 = new Order(1500, new GregorianCalendar(2017,12,30).getTime(), false, new GregorianCalendar(2017,11,30).getTime(), "Dnepr", "Ukraine", "buy");
        Order order3 = new Order();

        System.out.println(order.dateConfirmed); //before
        order.confirmOrder();
        System.out.println(order.dateConfirmed); //tests 1-method
        System.out.println(order.checkPrice());  //tests 2-method
        System.out.println(order.isValidType()); //tests 3-method
        System.out.println();

        System.out.println(order1.dateConfirmed); //before
        order1.confirmOrder();
        System.out.println(order1.dateConfirmed); //tests 1-method
        System.out.println(order1.checkPrice());  //tests 2-method
        System.out.println(order1.isValidType()); //tests 3-method
        System.out.println();

        System.out.println(order2.dateConfirmed); //before
        order2.confirmOrder();
        System.out.println(order2.dateConfirmed); //tests 1-method
        System.out.println(order2.checkPrice());  //tests 2-method
        System.out.println(order2.isValidType()); //tests 3-method
        System.out.println();

        System.out.println(order3.dateConfirmed); //before
        order3.confirmOrder();
        System.out.println(order3.dateConfirmed); //tests 1-method
        System.out.println(order3.checkPrice());  //tests 2-method
        System.out.println(order3.isValidType()); //tests 3-method
        System.out.println();
    }
}
