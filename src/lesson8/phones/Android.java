package lesson8.phones;

import lesson8.phones.Phone;

/**
 * Created by MM on 10.12.2017.
 */
public class Android extends Phone {


    String androidVersion;
    int screenSize;
    String secretDeviseCode;

    public Android(int price, double weight, String countryProdoced, String androidVersion, int screenSize, String secretDeviseCode) {
//        this.price = price;
//        this.weight = weight;
//        this.countryProduced = countryProdoced;
        super(price, weight, countryProdoced);
        this.androidVersion = androidVersion;
        this.screenSize = screenSize;
        this.secretDeviseCode = secretDeviseCode;
    }


    void installNewAndroidVersion(){
        System.out.println("Install New Android Version invoked...");
    }
}
