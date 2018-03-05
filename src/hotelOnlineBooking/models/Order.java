package hotelOnlineBooking.models;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Order extends Model {
    /**
     * DB- ORDERS
     *  111, 2222, 33, 10.02.2018 (DD.MM.YYYY), 20.02.2018 (DD.MM.YYYY), 1000.50
     *  111, 2222, 33, 10.02.2018 (DD.MM.YYYY), 20.02.2018 (DD.MM.YYYY), 1000.50
     *  111, 2222, 33, 10.02.2018 (DD.MM.YYYY), 20.02.2018 (DD.MM.YYYY), 1000.50
     *  SGSFGDFGHDFGHDF     В такой строке выбросить ошибку
     *  111, 2222, 33, 10.02.2018 (DD.MM.YYYY), 20.02.2018 (DD.MM.YYYY), 1000.50
     */
    private User user;
    private Room room;
    private Date dateFrom;
    private Date dateTo;
    private double moneyPaid;

    public Order(User user, Room room, Date dateFrom, Date dateTo, double moneyPaid) {
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.moneyPaid = moneyPaid;
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public double getMoneyPaid() {
        return moneyPaid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "userID = " + user.getId() +
                ", roomID = " + room.getId() +
                ", dateFrom = " + new SimpleDateFormat("dd.MM.yyyy").format(dateFrom) +
                ", dateTo = " + new SimpleDateFormat("dd.MM.yyyy").format(dateTo) +
                ", moneyPaid = " + moneyPaid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.moneyPaid, moneyPaid) == 0 &&
                Objects.equals(user, order.user) &&
                Objects.equals(room, order.room) &&
                Objects.equals(dateFrom, order.dateFrom) &&
                Objects.equals(dateTo, order.dateTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, room, dateFrom, dateTo, moneyPaid);
    }
}
