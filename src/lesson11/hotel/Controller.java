package lesson11.hotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by MM on 13.12.2017.
 */
public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }
    public Room[] requestRooms(int price, int persons, String city, String hotel){
        List<Room> rooms = new ArrayList<Room>();
        Room[] findsRooms;
        if (price < 0 || persons < 1 || city == null || hotel == null)
            return rooms.toArray(new Room[0]);

        for (API api : apis){
            findsRooms = api.findRooms(price, persons, city, hotel);
            if (findsRooms.length == 0)
                continue;
            rooms.addAll(Arrays.asList(findsRooms));
        }
        return rooms.toArray(new Room[0]);
    }

    public Room[] check(API api1, API api2){
        List<Room> checkRooms = new ArrayList<Room>();
        Room[] rooms1 = api1.getAll();
        Room[] rooms2 = api2.getAll();
        for (int i = 0; i < rooms1.length; i++) {
            if (rooms1[i] == null)
                continue;
            for (int j = 0; j < rooms2.length; j++) {
                if (rooms1[i].equals(rooms2[j]))
                    if (!checkRooms.contains(rooms1[i]))
                        checkRooms.add(rooms1[i]);
            }
        }
        return checkRooms.toArray(new Room[0]);
    }
}
