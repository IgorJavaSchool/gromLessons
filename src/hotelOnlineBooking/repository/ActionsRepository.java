package hotelOnlineBooking.repository;

import hotelOnlineBooking.models.Model;


/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public interface ActionsRepository<T extends Model> {

    /**
     * Returns all values fields received object in array strings.
     * @param t
     * @return
     */
    String[] getModelFields(T t);

    /**
     * Parses and checks all fields before create instance.
     * @param orderFields
     * @return
     */
    Model parseField(String[] orderFields);

}
