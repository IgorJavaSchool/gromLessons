package lesson11.hotel;

/**
 * Created by MM on 13.12.2017.
 */
public interface API {

    Room[] findRooms(int price, int persons, String city, String hotel);
    Room[] getAll();
}
