package hotelOnlineBooking.repository;

import hotelOnlineBooking.models.Model;

import java.util.List;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public interface RepositoryFills <T extends Model> {

    /**
     * Fills local repository from file's repository.
     * @param fields
     */
    void fillRepository(List<String[]> fields);

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
    Model parseFieldOrder(String[] orderFields);
}
