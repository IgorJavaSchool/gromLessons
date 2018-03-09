package hotelOnlineBooking.demo;

import hotelOnlineBooking.controllers.RoomController;
import hotelOnlineBooking.models.Filter;
import hotelOnlineBooking.models.Hotel;
import hotelOnlineBooking.models.Room;
import hotelOnlineBooking.services.ServicesExceptions.CountGuestException;
import hotelOnlineBooking.services.ServicesExceptions.FindInstanceException;
import hotelOnlineBooking.services.ServicesExceptions.IncorrectDateException;
import hotelOnlineBooking.services.ServicesExceptions.PriceException;

import java.util.Collection;
import java.util.Date;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class RoomDemo {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Hilton", "USA", "Chicago", "23 avenues");
        hotel.setId(1);
        RoomController roomController = new RoomController();
        try {
            roomController.addRoom(new Room(2, 150.55, true, true, new Date(), hotel));
        } catch (IncorrectDateException e) {
            e.printStackTrace();
        } catch (FindInstanceException e) {
            e.printStackTrace();
        } catch (PriceException e) {
            e.printStackTrace();
        } catch (CountGuestException e) {
            e.printStackTrace();
        }
        try {
            roomController.addRoom(new Room(1, 250, false, true, new Date(118, 3, 25), hotel));
        } catch (IncorrectDateException e) {
            e.printStackTrace();
        } catch (FindInstanceException e) {
            e.printStackTrace();
        } catch (PriceException e) {
            e.printStackTrace();
        } catch (CountGuestException e) {
            e.printStackTrace();
        }
        try {
            roomController.addRoom(new Room(3, 350, true, false, new Date(118, 2, 15), hotel));
        } catch (IncorrectDateException e) {
            e.printStackTrace();
        } catch (FindInstanceException e) {
            e.printStackTrace();
        } catch (PriceException e) {
            e.printStackTrace();
        } catch (CountGuestException e) {
            e.printStackTrace();
        }
        try {
            roomController.addRoom(new Room(4, 520.0, false, false, new Date(118, 2, 10), hotel));
        } catch (IncorrectDateException e) {
            e.printStackTrace();
        } catch (FindInstanceException e) {
            e.printStackTrace();
        } catch (PriceException e) {
            e.printStackTrace();
        } catch (CountGuestException e) {
            e.printStackTrace();
        }

        /**
         * Delete room
         */
        try {
            roomController.deleteRoom(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            roomController.deleteRoom(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * Create roms with mistake
         */
        // Date before current
        try {
            roomController.addRoom(new Room(4, 520.0, false, false, new Date(118, 2, 1), hotel));
        } catch (IncorrectDateException e) {
            e.printStackTrace();
        } catch (FindInstanceException e) {
            e.printStackTrace();
        } catch (PriceException e) {
            e.printStackTrace();
        } catch (CountGuestException e) {
            e.printStackTrace();
        }

        // price = 0
        try {
            roomController.addRoom(new Room(4, 0, false, false, new Date(118, 2, 10), hotel));
        } catch (IncorrectDateException e) {
            e.printStackTrace();
        } catch (FindInstanceException e) {
            e.printStackTrace();
        } catch (PriceException e) {
            e.printStackTrace();
        } catch (CountGuestException e) {
            e.printStackTrace();
        }

        try {
            roomController.addRoom(new Room(1000, 520.0, false, false, new Date(118, 2, 10), hotel));
        } catch (IncorrectDateException e) {
            e.printStackTrace();
        } catch (FindInstanceException e) {
            e.printStackTrace();
        } catch (PriceException e) {
            e.printStackTrace();
        } catch (CountGuestException e) {
            e.printStackTrace();
        }

        try {
            roomController.addRoom(new Room(0, 520.0, false, false, new Date(118, 2, 10), hotel));
        } catch (IncorrectDateException e) {
            e.printStackTrace();
        } catch (FindInstanceException e) {
            e.printStackTrace();
        } catch (PriceException e) {
            e.printStackTrace();
        } catch (CountGuestException e) {
            e.printStackTrace();
        }

        Collection rooms = roomController.findRooms(new Filter(0, 350, false,false,
        null, null, null, null));
        System.out.println(rooms);
    }
}
