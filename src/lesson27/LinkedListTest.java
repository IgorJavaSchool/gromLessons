package lesson27;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by MM on 20.12.2017.
 */
public class LinkedListTest {
    public List<Order> useList(){
        LinkedList<Order> list = new LinkedList<>();
        Order order1 = new Order(1, 125, "USD", "Phone", "Amazon");
        Order order2 = new Order(2, 258, "EUR", "Refrigerator", "Ebay");
        Order order3 = new Order(3, 36, "UAH", "TV", "Rozetka");
        Order order4 = new Order(4, 888, "USD", "IPhone", "Amazon");
        Order order5 = new Order(5, 555, "UAH", "Phone2", "Amazon");
        Order order6 = new Order(6, 369, "USD", "Phone3", "Amazon");
        Order order7 = new Order(7, 879, "UAH", "Phone4", "Amazon");
        Order order8 = new Order(8, 23, "USD", "Phone5", "Amazon");
        Order order9 = new Order(9, 852, "UAH", "Phone6", "Amazon");
        Order order10 = new Order(10, 222, "EUR", "Phone7", "Amazon");

        LinkedList<Order> orderList = new LinkedList();
        orderList.add(order5);
        orderList.add(order6);
        orderList.add(order7);
        orderList.add(order8);
        orderList.add(order9);
        orderList.add(order10);

        List<Order> sublist;

        boolean containsElement;

        list.add(order1);
        System.out.println(list.toArray());
        list.add(1, order2);
        System.out.println(list.toArray());
        list.remove(0);
        System.out.println(list.toArray());
        list.remove(order2);
        System.out.println(list.toArray());
        list.addAll(orderList);
        System.out.println(list.toArray());
        sublist = list.subList(1,5);
        System.out.println(sublist.toArray());
        sublist.set(0, order3);
        System.out.println(sublist.toArray());
        containsElement = list.contains(order4);
        System.out.println(containsElement);
        System.out.println(list.toArray().toString());
        orderList.clear();
        System.out.println(orderList.toArray());

        return sublist;
    }
}
