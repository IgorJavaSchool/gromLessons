package hotelOnlineBooking.services.ServicesExceptions;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class CountGuestException extends Exception{
    int guests;

    public CountGuestException(String message, int guests) {
        super(message);
        this.guests = guests;
    }

    @Override
    public String toString() {
        return "CountGuestException{" +
                "guests=" + guests +
                '}';
    }
}
