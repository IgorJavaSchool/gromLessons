package hotelOnlineBooking.repository;

import hotelOnlineBooking.models.Hotel;
import hotelOnlineBooking.models.Model;
import hotelOnlineBooking.models.Room;

import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Filter;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class RoomRepository extends GeneralRepository implements RepositoryFills{
    private HotelRepository hotelRepository = new HotelRepository();
    {
        setPath("src\\hotelOnlineBooking\\resources\\Rooms");
        fillRepository(readModelsFields(getPath()));
    }
//"src\\hotelOnlineBooking\\resources\\Rooms"
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
        removeModelFromFile(getById(roomId));
        fillRepository(readModelsFields(getPath()));
    }

    /**
     * Finds and returns rooms by filter
     * @param filter
     * @return
     */
    public Collection<Room> findRooms(Filter filter){
        // TODO: 27.02.2018
        return null;
    }

    /**
     * Fills local repository from file's repository.
     * @param fields
     */
    @Override
    public void fillRepository(List fields) {
        setModels(new HashSet<>());
        Room room;
        for (String[] roomFields : (List<String[]>) fields){
            if (roomFields.length != 7 || isEmptyFields(roomFields)) continue;
            room = (Room) parseFieldOrder(roomFields);
            if (room == null) continue;
            getModels().add(room);
        }
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
    public Model parseFieldOrder(String[] orderFields) {
        long ID = parseID(orderFields[0]);
        int numberOfGuests;
        double price;
        boolean breakfastIncluded;
        boolean petsAllowed;
        Date dateAvailableFrom;
        try {
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
        Hotel hotel = (Hotel) hotelRepository.getById(Long.parseLong(orderFields[6]));
        if (hotel == null) return null;
        Room room = new Room(numberOfGuests,price,breakfastIncluded, petsAllowed,dateAvailableFrom, hotel);
        room.setId(ID);
        return room;
    }

}
