package lesson24;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Order {
    private String nameOrder;
    private int priceTotal;
    private String nameCustomer;

    public Order(String nameOrder, int priceTotal, String nameCustomer) {
        this.nameOrder = nameOrder;
        this.priceTotal = priceTotal;
        this.nameCustomer = nameCustomer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "nameOrder='" + nameOrder + '\'' +
                ", priceTotal='" + priceTotal + '\'' +
                ", nameCustomer='" + nameCustomer + '\'' +
                '}';
    }
}
