package lesson10.onlineStore;

import java.util.Date;

/**
 * Created by MM on 12.12.2017.
 */
public class ElectronicsOrder extends Order{
    private int guaranteeMonths;
    private String[] citiesValidate = new String[]{"Киев", "Одесса", "Днепр", "Харьков"};

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }


    @Override
    public void validateOrder() {
        double minSum = 100;
        String customerGender = "Женский";
        if (!checkValidate())
            return;
        if (getBasePrice() < minSum || !(getCustomerOwned().getGender().equals(customerGender)))
            return;

        if (!checkContainCities(citiesValidate, getShipFromCity()))
            return;

        if (!checkContainCities(citiesValidate, getShipToCity()))
            return;

        if (getDateConfirmed() == null) {
            setDateConfirmed(new Date());
        }

    }


    @Override
   public void calculatePrice() {

        if (!checkValidate())
            return;
        double priceShipping = calculatePriseShipping();
        setTotalPrice(getBasePrice() + priceShipping - calculateSale(priceShipping));
    }

    /**
     * Calculates sum shipping depending of city
     * @return
     */
    private double calculatePriseShipping(){
        if (getShipToCity() == null)
            return 0;
        if (getShipToCity().equals("Киев") || getShipToCity().equals("Одесса"))
            return getBasePrice() * 0.1;
        else return getBasePrice() * 0.15;
    }

    /**
     * Calculates sum sale depending of sum
     * @param priceShipping
     * @return
     */
    private double calculateSale(double priceShipping){
        double salePercent = getBasePrice() > 1000 ? 0.05 : 0;
        return (getBasePrice() + priceShipping) * salePercent;
    }
}
