package hotelOnlineBooking.services;

import hotelOnlineBooking.models.Model;
import hotelOnlineBooking.models.Room;
import hotelOnlineBooking.repository.HotelRepository;
import hotelOnlineBooking.repository.RoomRepository;
import hotelOnlineBooking.services.ServicesExceptions.CountGuestException;
import hotelOnlineBooking.services.ServicesExceptions.FindInstanceException;
import hotelOnlineBooking.services.ServicesExceptions.IncorrectDateException;
import hotelOnlineBooking.services.ServicesExceptions.PriceException;

import java.util.Collection;
import java.util.Date;
import java.util.logging.Filter;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class RoomService implements ValidatorFields{
    private RoomRepository roomRepository = new RoomRepository();
    private HotelRepository hotelRepository = new HotelRepository();

    /**
     *  The method use only admin
     * @param room
     */
    public void addRoom(Room room) throws FindInstanceException, IncorrectDateException, PriceException, CountGuestException {
        validateFields(room);
        roomRepository.addRoom(room);
    }


    /**
     * Checks if roon not null.
     *  The method use only admin.
     * @param roomId
     */
    public void deleteRoom(long roomId){
        Room room = (Room) roomRepository.getById(roomId);
        if (room == null) throw new NullPointerException("The room not find into DB and can't delete");
        roomRepository.deleteRoom(room.getId());
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

    @Override
    public void validateFields(Model model) throws FindInstanceException, IncorrectDateException, PriceException, CountGuestException {
        Room room = (Room) model;
        if (room == null) {
            throw new NullPointerException("Room should not null");
        }
        if (room.getNumberOfGuests() < 1 || room.getNumberOfGuests() > 15){
            throw new CountGuestException(room.getNumberOfGuests());
        }
        if (room.getPrice() < 1) throw new PriceException("Price should more 0", room.getPrice());

        if (room.getDateAvailableFrom() == null)
            throw new NullPointerException("Date available should not null");
        if (room.getDateAvailableFrom().before(new Date()))
            throw new IncorrectDateException("Date available should not be less then the current date", room.getDateAvailableFrom());
        if (room.getHotel() == null) throw new NullPointerException("Room's field \"Hotel\" should not be null");
        if (!hotelRepository.getModels().contains(room.getHotel())){
            throw new FindInstanceException(room.getHotel());
        }
        if (roomRepository.getModels().contains(room)) throw new FindInstanceException("Repository contain the model", room);
    }
}
