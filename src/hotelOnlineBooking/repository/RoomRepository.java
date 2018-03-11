package hotelOnlineBooking.repository;

import hotelOnlineBooking.models.Hotel;
import hotelOnlineBooking.models.Model;
import hotelOnlineBooking.models.Room;

import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class RoomRepository extends GeneralRepository implements ActionsRepository {
    private HotelRepository hotelRepository = new HotelRepository();
    {
        setPath("./src/hotelOnlineBooking/resources/Rooms");
    }
    /**
     *  The method use only admin
     * @param RoomId
     */


    /**
     *  The method use only admin
     * @param room
     */
    public void addRoom(Room room){
        room.setId(generateId());
        addToRepository(room, getModelFields(room));
    }

    public void deleteRoom(long roomId){
        removeModelFromFile(parseField(getById(roomId)));
    }

    /**
     * Finds and returns rooms by filter
     * @return
     */
    public Collection<Room> findRooms(){
        Collection<Room> roomCollection = new HashSet<>();
        List rooms = readModelsFields(getPath());
        for (Object line : rooms){
            roomCollection.add((Room) parseField((String[]) line));
        }
        return roomCollection;
    }

    /**
     * Returns all values fields received object in array strings.
     * @param model
     * @return
     */
    @Override
    public String[] getModelFields(Model model) {
        Room room = (Room) model;
        return new String[]{String.valueOf(room.getId()), String.valueOf(room.getNumberOfGuests()),
                String.valueOf(room.getPrice()), String.valueOf(room.isBreakfastIncluded()),
                String.valueOf(room.isPetsAllowed()), getDATAFORMAT().format(room.getDateAvailableFrom()),
                String.valueOf(room.getHotel().getId())};
    }

    /**
     * Parses and checks all fields before create instance.
     *
     * @param orderFields
     *
     * @return
     */
    @Override
    public Model parseField(String[] orderFields) {
        long ID;
        int numberOfGuests;
        double price;
        boolean breakfastIncluded;
        boolean petsAllowed;
        Date dateAvailableFrom;
        try {
            ID = parseID(orderFields[0]);
            numberOfGuests = Integer.parseInt(orderFields[1]);
            price = Double.parseDouble(orderFields[2]);
            breakfastIncluded = Boolean.parseBoolean(orderFields[3]);
            petsAllowed = Boolean.parseBoolean(orderFields[4]);
            dateAvailableFrom = getDATAFORMAT().parse(orderFields[5]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        Hotel hotel = (Hotel) hotelRepository.parseField(getById(Long.parseLong(orderFields[6])));
        if (hotel == null) return null;
        Room room = new Room(numberOfGuests,price,breakfastIncluded, petsAllowed,dateAvailableFrom, hotel);
        room.setId(ID);
        return room;
    }

}
