package hotelOnlineBooking.services.ServicesExceptions;

import java.util.Date;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class IncorrectDateException extends Exception {
    Date date;

    public IncorrectDateException(String message, Date date) {
        super(message);
        this.date = date;
    }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()}
     *                method.
     */
    public IncorrectDateException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "IncorrectDateException{" +
                "date=" + date +
                '}';
    }
}
