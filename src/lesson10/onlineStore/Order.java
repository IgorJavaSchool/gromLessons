package lesson10.onlineStore;

import java.util.Date;

/**
 * Created by MM on 12.12.2017.
 */
public abstract class Order {
    private String itemName;
    private Date dateCreated;
    private Date dateConfirmed;
    private Date dateShipped;
    private String shipFromCity;
    private String shipToCity;
    private int basePrice;
    private double totalPrice;
    private Customer customerOwned;

    public Order(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned) {
        this.itemName = itemName;
        this.dateCreated = dateCreated;
        this.shipFromCity = shipFromCity;
        this.shipToCity = shipToCity;
        this.basePrice = basePrice;
        this.customerOwned = customerOwned;
    }

    public abstract void validateOrder();
    public abstract void calculatePrice();

    public void confirmShipping(){
        if (dateShipped == null)
            dateShipped = new Date();
    }

    public String getItemName() {
        return itemName;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Date getDateConfirmed() {
        return dateConfirmed;
    }

    public Date getDateShipped() {
        return dateShipped;
    }

    public String getShipFromCity() {
        return shipFromCity;
    }

    public String getShipToCity() {
        return shipToCity;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Customer getCustomerOwned() {
        return customerOwned;
    }

    public void setDateConfirmed(Date dateConfirmed) {
        this.dateConfirmed = dateConfirmed;
    }

    public void setDateShipped(Date dateShipped) {
        this.dateShipped = dateShipped;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    protected boolean checkContainCities(String[] cities, String city){
        if (cities == null || city == null)
            return false;
        for (String cityName : cities){
            if (cityName.equals(city))
                return true;
        }
        return false;
    }

    protected boolean checkValidate(){
        if (getCustomerOwned() == null || getItemName() == null)
            return false;
        if (getShipFromCity() == null || getShipToCity() ==null)
            return false;
        return true;
    }
}
