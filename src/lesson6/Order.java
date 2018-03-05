package lesson6;

import java.util.Date;

/**
 * Created by MM on 10.12.2017.
 */
public class Order {
    long id;
    int price;
    Date dateCreated;
    boolean isConfirmed;
    Date dateConfirmed;
    String city;
    String country;
    String type;

    public Order() {
    }

    public Order(int price, Date dateCreated, boolean isConfirmed, Date dateConfirmed, String city, String country, String type) {
        this.price = price;
        this.dateCreated = dateCreated;
        this.isConfirmed = isConfirmed;
        this.dateConfirmed = dateConfirmed;
        this.city = city;
        this.country = country;
        this.type = type;
    }

    public void confirmOrder(){
        if (!isConfirmed) {
            this.isConfirmed = true;
            this.dateConfirmed = new Date();
        }
    }

    public boolean checkPrice(){
        if (this.price > 1000)
            return true;
        else return false;
    }

    public boolean isValidType(){
        if (this.type == null)
            return false;
        if (this.type.equals("Buy") || this.type.equals("Sale"))
            return true;
        else return false;
    }




}
