package hotelOnlineBooking.demo;

import hotelOnlineBooking.controllers.HotelController;
import hotelOnlineBooking.models.Hotel;
import hotelOnlineBooking.services.ServicesExceptions.FindInstanceException;


/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class HotelDemo {
    public static void main(String[] args) {
        try {
            new HotelController().addHotel(new Hotel("Hilton", "USA", "Chicago", "23 avenues"));

        } catch (FindInstanceException e) {
            e.printStackTrace();
        }
        try {
            new HotelController().addHotel(new Hotel("Kempinsky", "Netherlands", "Amsterdam", "Red lights"));
        } catch (FindInstanceException e) {
            e.printStackTrace();
        }
        try {
            new HotelController().addHotel(new Hotel("Londonskaya", "Ukraine", "Odessa", "Primorsky bulvar"));
        } catch (FindInstanceException e) {
            e.printStackTrace();
        }
        try {
            new HotelController().addHotel(new Hotel("International", "Ukraine", "Kiev", "Aleksandrovskaya"));
        } catch (FindInstanceException e) {
            e.printStackTrace();
        }
        try {
            new HotelController().addHotel(new Hotel("Hutorok", "Ukraine", "Zhitomir", "Lesnaya"));
        } catch (FindInstanceException e) {
            e.printStackTrace();
        }
        new HotelController().deleteHotel(3);



        // TODO: 27.02.2018
    }
}
