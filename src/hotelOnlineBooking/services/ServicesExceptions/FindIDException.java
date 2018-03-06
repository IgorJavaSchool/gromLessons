package hotelOnlineBooking.services.ServicesExceptions;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class FindIDException extends Exception {
    private long ID;

    public FindIDException(long ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "FindIDException{" +
                "ID=" + ID + " not find " + getMessage() +
                '}';
    }
}
