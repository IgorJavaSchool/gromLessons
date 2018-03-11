package hotelOnlineBooking.services;

import hotelOnlineBooking.models.*;
import hotelOnlineBooking.repository.HotelRepository;
import hotelOnlineBooking.repository.OrderRepository;
import hotelOnlineBooking.repository.RoomRepository;
import hotelOnlineBooking.repository.UserRepository;
import hotelOnlineBooking.services.ServicesExceptions.FindIDException;
import hotelOnlineBooking.services.ServicesExceptions.FindInstanceException;
import hotelOnlineBooking.services.ServicesExceptions.IncorrectDateException;
import hotelOnlineBooking.services.ServicesExceptions.PriceException;

import java.util.Collection;
import java.util.Date;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class OrderService implements ValidatorFields{
    private OrderRepository orderRepository = new OrderRepository();
    private RoomRepository roomRepository = new RoomRepository();
    private UserRepository userRepository = new UserRepository();
    private HotelRepository hotelRepository = new HotelRepository();
    private final int ONEDAY = 86400000;
    private final int PERIOD_RESERVE = 3;

    public void bookRoom(long roomId, long userId, long hotelId) throws FindInstanceException, FindIDException, IncorrectDateException {
        validateID(roomId, userId, hotelId);
        Order order = createOrder(roomId, userId);
        checkOrdersRooms(order);
        orderRepository.bookRoom(order);
    }

    /**
     * Create new order.
     * @param roomId
     * @param userId
     * @return
     * @throws IncorrectDateException
     */
    private Order createOrder(long roomId, long userId) throws IncorrectDateException {
        User user = (User) userRepository.parseField(userRepository.getById(userId));
        Room room = (Room) roomRepository.parseField(roomRepository.getById(roomId));
        Date dateFrom = takeAvailableDate(room.getDateAvailableFrom());
        Date dateTo = addSomeDay(dateFrom, PERIOD_RESERVE);
        double moneyPaid = totalMoneyPaid(dateFrom, dateTo, room.getPrice());
        return new Order(user, room, dateFrom, dateTo, moneyPaid);
    }

    /**
     * Checks if room's date available. If the date less current date then returns current date.
     * @param date
     * @return
     */
    private Date takeAvailableDate(Date date){
        Date currentDate = new Date();
        if (date.before(currentDate)) return currentDate;
        return date;
    }

    /**
     * Checks all orders and compare there live's periods with order's period.
     * @param order
     * @throws IncorrectDateException
     */
    private void checkOrdersRooms(Order order) throws IncorrectDateException, FindInstanceException {
        if (orderRepository.contains(order))
            throw new FindInstanceException("Repository contain the model", order);
        Collection<Order> orders =  orderRepository.getModels();
        for (Order orderInDB : orders){
            if (orderInDB.getRoom().getId() == order.getRoom().getId()){
                if (checkIntersectionDates(orderInDB.getDateFrom(), orderInDB.getDateTo(),
                        order.getDateFrom(), order.getDateTo()))
                    throw new IncorrectDateException("Selected period itersection with other period in other order");
            }
        }
    }

    /**
     * Checks that period since dateFof1 to dateTo1 wouldn't intersection with period since dateFrom2 to dateTo2.
     * If this happens, returns true.
     * @param dateFrom1
     * @param dateTo1
     * @param dateFrom2
     * @param dateTo2
     * @return
     */
    private boolean checkIntersectionDates(Date dateFrom1, Date dateTo1, Date dateFrom2, Date dateTo2){
        if (dateFrom1.before(dateFrom2) && dateTo1.before(dateFrom2)) return false;
        else
        if (dateFrom1.after(dateFrom2) && dateTo1.after(dateTo2)) return false;
        else
        return true;
    }

    /**
     * Takes date, adds to it one or more days and return result.
     * Count days can't be less 1 and more 30 days.
     * @param date
     * @return
     */
    private Date addSomeDay(Date date, int countDays) throws IncorrectDateException {
        if (countDays < 1 || countDays > 30)
            throw new IncorrectDateException("Count add days can be only more then one and less thirty", date);
        Date newDate = new Date();
        newDate.setTime(date.getTime() + ONEDAY * countDays);
        return newDate;
    }

    /**
     * Counts order's total sum.
     * @param dateFrom
     * @param dateTo
     * @param price
     * @return
     */
    private double totalMoneyPaid(Date dateFrom, Date dateTo, double price){
        double amountDays = Math.ceil((dateTo.getTime() - dateFrom.getTime()) / ONEDAY);
        return (amountDays * price);
    }


    /**
     * Cancels reserve in hotel.
     * @param roomId
     * @param userId
     */
    public void cancelReservation(long roomId, long userId) throws FindInstanceException, FindIDException {
        validateID(roomId, userId);
        for (Order order : (Collection<Order>) orderRepository.getModels()){
            if (order.getRoom().getId() == roomId &&
                    order.getUser().getId() == userId) orderRepository.cancelReservation(order);
        }
    }


    /**
     * This method you can use only other version. Then method void bookRoom takes parameter Order.
     * @param model
     * @throws FindInstanceException
     * @throws IncorrectDateException
     * @throws PriceException
     */
    @Override
    public void validateFields(Model model) throws FindInstanceException, IncorrectDateException, PriceException {
        Order order = (Order) model;
        if (order == null) {
            throw new NullPointerException("Order should not null");
        }
        if (!userRepository.contains(order.getUser()))throw new FindInstanceException(order.getUser());
        if (!roomRepository.contains(order.getRoom()))throw new FindInstanceException(order.getRoom());

        if (order.getDateFrom().before(new Date()))
            throw new IncorrectDateException("Order's date visit should not be less then the current date", order.getDateFrom());
        if (!order.getDateTo().after(order.getDateFrom()))
            throw new IncorrectDateException("DateTo would be after dateFrom", order.getDateTo());
        checkOrdersRooms(order);
        if (order.getMoneyPaid() < totalMoneyPaid(order.getDateFrom(), order.getDateTo(), order.getRoom().getPrice())){
            throw new PriceException("Sum paid less total cost.", order.getMoneyPaid());
        }
        if (orderRepository.contains(order)) throw new FindInstanceException("Repository contain the model", order);
    }

    private void validateID(long roomId, long userId, long hotelId) throws FindIDException {
        if (roomRepository.getById(roomId) == null)throw new FindIDException(roomId);
        if (userRepository.getById(userId) == null)throw new FindIDException(userId);
        if (hotelRepository.getById(hotelId) == null)throw new FindIDException(roomId);
    }

    private void validateID(long roomId, long userId) throws FindIDException {
        if (roomRepository.getById(roomId) == null)throw new FindIDException(roomId);
        if (userRepository.getById(userId) == null)throw new FindIDException(userId);
    }
}
