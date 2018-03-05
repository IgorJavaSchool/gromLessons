package lesson11.hotel;

/**
 * Created by MM on 13.12.2017.
 */
public class TripAdvisorAPI implements API {

    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room[] findsRooms = new Room[]{};
        if (persons <= 0)
            return findsRooms;

        int minPersons = persons < 2 ? 1 : persons - 1;
        int maxPersons = persons + 1;

        for (Room room : rooms) {
            if (!room.getCityName().equals(city))
                continue;
            if (!room.getHotelName().equals(hotel))
                continue;
            if (room.getPrice() != price)
                continue;
            if (persons >= minPersons && persons <= maxPersons) {
                findsRooms = newArrayRoom(findsRooms, room);
            }
        }
        return findsRooms;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }

    private Room[] newArrayRoom(Room[] rooms, Room room){
        Room[] newRooms = new Room[rooms.length + 1];
        for (int i = 0; i < rooms.length; i++) {
            newRooms[i] = rooms[i];
        }
        newRooms[rooms.length] = room;
        return newRooms;
    }
}
