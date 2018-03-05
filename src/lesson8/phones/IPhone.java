package lesson8.phones;

import lesson8.phones.Phone;

/**
 * Created by MM on 10.12.2017.
 */
public class IPhone extends Phone {

    boolean fingerPrint;

    public IPhone(int price, double weight, String countryProduced, boolean fingerPrint) {
//        this.price = price;
//        this.weight = weight;
//        this.countryProduced = countryProdoced;
        super(price, weight, countryProduced);
        System.out.println("IPhone constructor was invoked ");
        this.fingerPrint = fingerPrint;
    }


    void deliteIphoneForDb(){
        System.out.println("Delete Iphone fromDb invoked...");
    }
}
