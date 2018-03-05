package lesson8.phones;

/**
 * Created by MM on 10.12.2017.
 */
public class Phone {
    int price;
    double weight;
    String countryProduced;

    public Phone(int price, double weeght, String countryProdoced) {
        System.out.println("Phone constructor was invoked ");
        this.price = price;
        this.weight = weeght;
        this.countryProduced = countryProdoced;
    }

    void orderPhone(){
        System.out.println("Order phone invoked...");
    }
}
