package hotelOnlineBooking.services.ServicesExceptions;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class CountGuestException extends Exception{
    private int guests;

    public CountGuestException(int guests) {
        this.guests = guests;
    }

    @Override
    public String toString() {
        return "CountGuestException{" +
                "guests=" + guests + " number of guests should from 1 to 15 persons" +
                '}';
    }
}
