package lesson29;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class HashSetTest {
    private Order order1 = new Order(1, 125, "USD", "Book", "Amazon");   //
    private Order order2 = new Order(2, 235, "EUR", "Table", "IKEA");    // Retain
    private Order order3 = new Order(3, 512, "USD", "IPhone", "Rozetka");//
    private Order order4 = new Order(4, 125, "USD", "Book", "Amazon");   // Повтор
    private Order order5 = new Order(5, 15000, "USD", "Auto", "Mobile"); //
    private Order order6 = new Order(6, 12, "UAH", "Milk", "ATB");       //
    private Order order7 = new Order(7, 512, "USD", "IPhone", "Allo");   // Remove
    private Order order8 = new Order(8, 15001, "USD", "Auto", "Mobile"); //
    private Set<Order> orderSet = new HashSet<>();
    private Set<Order> orderSetRetain = new HashSet<>();

    public Set<Order> useHashSet(){
        orderSet.add(order1);
        orderSet.add(order2);
        orderSet.add(order3);
        orderSet.add(order4);
        orderSet.add(order5);
        orderSet.add(order6);
        orderSet.add(order7);
        orderSet.add(order8);
        System.out.println(orderSet);


        orderSetRetain.add(order1);
        orderSetRetain.add(order3);
        orderSetRetain.add(order4);
        orderSetRetain.add(order5);
        orderSetRetain.add(order6);
        orderSetRetain.add(order7);
        orderSetRetain.add(order8);

        Iterator<Order> iterator = orderSetRetain.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getItemName());
        }


        orderSet.remove(order7);
        System.out.println(orderSet);

        orderSet.retainAll(orderSetRetain);
        System.out.println(orderSet);

        Order[] orders = orderSet.toArray(new Order[orderSet.size()]);
        System.out.println(Arrays.toString(orders));

        System.out.println(orderSet.size());
        System.out.println(orderSet);
        return orderSet;

    }
}
