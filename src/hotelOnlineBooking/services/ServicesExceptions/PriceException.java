package hotelOnlineBooking.services.ServicesExceptions;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class PriceException extends Exception{
    double money;

    public PriceException(String message, double money) {
        super(message);
        this.money = money;
    }

    @Override
    public String toString() {
        return "PriceException{" +
                "money=" + money +
                '}';
    }
}
