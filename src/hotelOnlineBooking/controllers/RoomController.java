package hotelOnlineBooking.controllers;

import hotelOnlineBooking.models.Room;
import hotelOnlineBooking.services.RoomService;
import hotelOnlineBooking.services.ServicesExceptions.CountGuestException;
import hotelOnlineBooking.services.ServicesExceptions.FindInstanceException;
import hotelOnlineBooking.services.ServicesExceptions.IncorrectDateException;
import hotelOnlineBooking.services.ServicesExceptions.PriceException;

import java.util.Collection;
import java.util.logging.Filter;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class RoomController {
    private RoomService roomService = new RoomService();

    /**
     *  The method use only admin
     * @param room
     */
    public void addRoom(Room room) throws IncorrectDateException, FindInstanceException, PriceException, CountGuestException {
        roomService.addRoom(room);
    }

    /**
     *  The method use only admin
     * @param roomId
     */
    public void deleteRoom(long roomId){
        roomService.deleteRoom(roomId);
    }


    /**
     * Finds and returns rooms by filter
     * @param filter
     * @return
     */
    public Collection<Room> findRooms(Filter filter){
        return roomService.findRooms(filter);
    }

}
