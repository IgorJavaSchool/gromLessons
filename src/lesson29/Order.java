package lesson29;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Order {
    private long id;
    private int price;
    private String currency;
    private String itemName;
    private String shopIdentificator;

    public Order(long id, int price, String currency, String itemName, String shopIdentificator) {
        this.id = id;
        this.price = price;
        this.currency = currency;
        this.itemName = itemName;
        this.shopIdentificator = shopIdentificator;
    }

    public long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public String getItemName() {
        return itemName;
    }

    public String getShopIdentificator() {
        return shopIdentificator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (price != order.price) return false;
        if (!currency.equals(order.currency)) return false;
        if (!itemName.equals(order.itemName)) return false;
        if (!shopIdentificator.equals(order.shopIdentificator)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = price;
        result = 31 * result + currency.hashCode();
        result = 31 * result + itemName.hashCode();
        result = 31 * result + shopIdentificator.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                '}';
    }
}
