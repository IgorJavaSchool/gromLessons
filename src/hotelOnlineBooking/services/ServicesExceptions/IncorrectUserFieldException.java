package hotelOnlineBooking.services.ServicesExceptions;

public class IncorrectUserFieldException extends Exception{
    public IncorrectUserFieldException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "IncorrectUserFieldException{} " + getMessage();
    }
}
