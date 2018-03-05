package hotelOnlineBooking.repository;

import hotelOnlineBooking.models.Model;
import hotelOnlineBooking.models.Order;
import hotelOnlineBooking.models.Room;
import hotelOnlineBooking.models.User;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class OrderRepository extends GeneralRepository implements RepositoryFills{
    private UserRepository userRepository = new UserRepository();
    private RoomRepository roomRepository = new RoomRepository();
    {
        setPath("src\\hotelOnlineBooking\\resources\\Orders");
        fillRepository(readModelsFields(getPath()));
    }
//"src\\hotelOnlineBooking\\resources\\Orders"

    public void bookRoom(Order order){
        order.setId(generateId());
        addToRepository(order, getModelFields(order));
    }

    /**
     * Cancels reserve in hotel.
     */
    public void cancelReservation(Order order){
        removeModelFromFile(order);
        fillRepository(readModelsFields(getPath()));
    }

    /**
     * Fills local repository from file's repository.
     * @param fields
     */
    @Override
    public void fillRepository(List fields) {
        setModels(new HashSet<>());
        Order order;
        for (String[] orderFields : (List<String[]>) fields){
            if (orderFields.length != 6 || isEmptyFields(orderFields)) continue;
            order = (Order) parseFieldOrder(orderFields);
            if (order == null) continue;
            getModels().add(order);
        }
    }

    /**
     * Returns all values fields received object in array strings.
     * @param model
     * @return
     */
    @Override
    public String[] getModelFields(Model model) {
        Order order = (Order) model;
        return new String[]{String.valueOf(order.getId()), String.valueOf(order.getUser().getId()),
                String.valueOf(order.getRoom().getId()), getDATAFORMAT().format(order.getDateFrom()),
                getDATAFORMAT().format(order.getDateTo()), String.valueOf(order.getMoneyPaid())};
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
        long ID;
        User user = (User) userRepository.getById(Long.parseLong(orderFields[1]));
        if (user == null) return null;
        Room room = (Room) roomRepository.getById(Long.parseLong(orderFields[2]));
        if (room == null) return null;
        Date dateFrom;
        Date dateTo;
        double moneyPaid;
        try {
            ID = parseID(orderFields[0]);
            dateFrom = getDATAFORMAT().parse(orderFields[3]);
            dateTo = getDATAFORMAT().parse(orderFields[4]);
            moneyPaid = Double.parseDouble(orderFields[5]);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
        Order order = new Order(user, room, dateFrom, dateTo, moneyPaid);
        order.setId(ID);
        return order;
    }

}
