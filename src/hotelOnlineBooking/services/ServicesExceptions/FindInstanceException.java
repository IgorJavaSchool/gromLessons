package hotelOnlineBooking.services.ServicesExceptions;

import hotelOnlineBooking.models.Model;

public class FindInstanceException extends Exception {
    private Model model;

    public FindInstanceException(Model model) {
        this.model = model;
    }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()}
     *                method.
     */
    public FindInstanceException(String message, Model model) {
        super(message);
        this.model = model;
    }

    @Override
    public String toString() {
        return "FindInstanceException{" +
                "model=" + model + " " + getMessage() +
                '}';
    }
}