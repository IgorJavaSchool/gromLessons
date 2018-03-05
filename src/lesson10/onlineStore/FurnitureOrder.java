package lesson10.onlineStore;

import java.util.Date;

/**
 * Created by MM on 12.12.2017.
 */
public class FurnitureOrder extends Order {
    private String furnitureCode;
    private String[] citiesValidateFrom = new String[]{"Киев", "Львов"};

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }


    @Override
    public void validateOrder() {
        if (getBasePrice() < 500)
            return;
        if (!checkValidate())
            return;
        if (getCustomerOwned().getName().equals("Тест"))
            return;
        if (!checkContainCities(citiesValidateFrom, getShipFromCity()))
            return;
        if (getDateConfirmed() == null) {
            setDateConfirmed(new Date());
        }
    }

    @Override
    public void calculatePrice() {
        double priceShipping = getBasePrice() < 5000 ? getBasePrice() * 0.05 : getBasePrice() * 0.02;
        setTotalPrice(getBasePrice() + priceShipping);
    }
}
