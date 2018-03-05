package hotelOnlineBooking.controllers;

import hotelOnlineBooking.services.OrderService;
import hotelOnlineBooking.services.ServicesExceptions.FindIDException;
import hotelOnlineBooking.services.ServicesExceptions.FindInstanceException;
import hotelOnlineBooking.services.ServicesExceptions.IncorrectDateException;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class OrderController {
    private OrderService orderService = new OrderService();

    /**
     * Reserves room in hotel.
     * @param roomId
     * @param userId
     * @param hotelId
     */
    public void bookRoom(long roomId, long userId, long hotelId) throws FindInstanceException, FindIDException, IncorrectDateException {
        orderService.bookRoom(roomId, userId, hotelId);
        // TODO: 27.02.2018
    }

    /**
     * Cancels reserve in hotel.
     * @param roomId
     * @param userId
     */
    public void cancelReservation(long roomId, long userId) throws FindInstanceException, FindIDException {
        orderService.cancelReservation(roomId, userId);
    }
}
