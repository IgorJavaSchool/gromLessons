package hotelOnlineBooking.controllers;

import hotelOnlineBooking.models.Hotel;
import hotelOnlineBooking.services.HotelService;
import hotelOnlineBooking.services.ServicesExceptions.FindInstanceException;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class HotelController {
    private HotelService hotelService = new HotelService();

    /**
     *  The method use only admin
     * @param hotelId
     */
    public void deleteHotel(long hotelId){
        hotelService.deleteHotel(hotelId);
    }


    /**
     * The method use only admin
     * @param hotel
     */
    public void addHotel(Hotel hotel) throws FindInstanceException {
        hotelService.addHotel(hotel);
    }

}
