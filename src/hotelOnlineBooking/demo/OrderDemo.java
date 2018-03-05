package hotelOnlineBooking.demo;

import hotelOnlineBooking.controllers.OrderController;
import hotelOnlineBooking.services.ServicesExceptions.FindIDException;
import hotelOnlineBooking.services.ServicesExceptions.FindInstanceException;
import hotelOnlineBooking.services.ServicesExceptions.IncorrectDateException;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class OrderDemo {
    public static void main(String[] args) {
        OrderController orderController = new OrderController();
        /**
         * Add orders.
         */
        try {
            orderController.bookRoom(2, 1, 1);
        } catch (FindInstanceException e) {
            e.printStackTrace();
        } catch (FindIDException e) {
            e.printStackTrace();
        } catch (IncorrectDateException e) {
            e.printStackTrace();
        }

        try {
            orderController.bookRoom(3, 1, 1);
        } catch (FindInstanceException e) {
            e.printStackTrace();
        } catch (FindIDException e) {
            e.printStackTrace();
        } catch (IncorrectDateException e) {
            e.printStackTrace();
        }
        /**
         * Canceled order.
         */
        try {
            orderController.cancelReservation(2, 1);
        } catch (FindInstanceException e) {
            e.printStackTrace();
        } catch (FindIDException e) {
            e.printStackTrace();
        }

        // TODO: 27.02.2018
    }
}
