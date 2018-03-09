package hotelOnlineBooking.services;

import hotelOnlineBooking.models.Model;
import hotelOnlineBooking.services.ServicesExceptions.*;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public interface ValidatorFields <T extends Model> {
    void validateFields(T t) throws FindInstanceException, IncorrectDateException, FindInstanceException, PriceException, CountGuestException, IncorrectUserFieldException;
}
