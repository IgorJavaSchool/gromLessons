package lesson10.onlineStore;

import java.util.Date;

/**
 * Created by MM on 12.12.2017.
 */
public class Demo {
    public static void main(String[] args) {
        String city = "Киев";
        String city1 = "Одесса";
        String city2 = "Днепр";
        String city3 = "Харьков";
        String city4 = "Львов";

        String men = "Мужской";
        String women = "Женский";

        Customer customer = new Customer("Peter", city, men);
        Customer customer2 = new Customer("Maria", city1, women);
        Customer customer3 = new Customer("Test", city4, men);

        Order order1 = new ElectronicsOrder("Phone", new Date(), city, city1, 100, customer2,10);      // isCorrect
        Order order2 = new ElectronicsOrder("Phone", new Date(), city, city4, 10000, customer,10);   // isNotCorrect
        Order order3 = new ElectronicsOrder("Phone", new Date(), city4, city, 1000, customer,10);   // isNotCorrect
        Order order4 = new ElectronicsOrder("Phone", new Date(), city, city1, 99, customer,10);      // isNotCorrect
        Order order5 = new ElectronicsOrder("Phone", new Date(), city, city1, 100, customer2,10);    // isNotCorrect

        Order order6 = new FurnitureOrder("Sofa", new Date(), city, city3, 5000, customer, "WW");     // isCorrect
        Order order7 = new FurnitureOrder("Sofa", new Date(), city2, city3, 500, customer, "WW");    // isNotCorrect
        Order order8 = new FurnitureOrder("Sofa", new Date(), city, city3, 499, customer, "WW");     // isNotCorrect
        Order order9 = new FurnitureOrder("Sofa", new Date(), city, city3, 500, customer3, "WW");    // isNotCorrect
        Order order10 = new ElectronicsOrder("Phone", new Date(), city, city1, 10000, customer,10);   // isNotCorrect
        Order order11 = new ElectronicsOrder(null, new Date(), city, city1, 10000, customer,10);   // isNotCorrect
        Order order12 = new ElectronicsOrder("Phone", null, city, city1, 10000, customer,10);   // isNotCorrect
        Order order13 = new ElectronicsOrder("Phone", new Date(), null, city1, 10000, customer,10);   // isNotCorrect
        Order order14 = new ElectronicsOrder("Phone", new Date(), city, null, 10000, customer,10);   // isNotCorrect
        Order order15 = new ElectronicsOrder("Phone", new Date(), city, city1, 10000, null,10);   // isNotCorrect
        Order order16 = new ElectronicsOrder(null, null, null, null, -1, null,-1);   // isNotCorrect


        Order[] orders = new Order[]{order1, order2, order3, order4, order5, order6, order7, order8, order9, order10,
                order11, order12, order13, order14, order15, order16};

        /**
         * Tests all methods.
         */
        int index = 1;
        for (Order orderExample : orders){
            orderExample.confirmShipping();
            orderExample.validateOrder();
            orderExample.calculatePrice();
            System.out.println("Order" + index + " Date confirm " + orderExample.getDateConfirmed() +
                    " Total price - " + orderExample.getTotalPrice());
            System.out.println();
            index++;
        }

    }






}
