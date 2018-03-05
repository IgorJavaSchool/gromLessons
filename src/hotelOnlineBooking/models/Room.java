package hotelOnlineBooking.models;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Room extends Model {
    private int numberOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAvailableFrom;
    private Hotel hotel;

    public Room(int numberOfGuests, double price, boolean breakfastIncluded, boolean petsAllowed, Date dateAvailableFrom, Hotel hotel) {
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotel = hotel;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public Hotel getHotel() {
        return hotel;
    }

    @Override
    public String toString() {
        return "Room{" +
                "numberOfGuests=" + numberOfGuests +
                ", price=" + price +
                ", breakfastIncluded=" + breakfastIncluded +
                ", petsAllowed=" + petsAllowed +
                ", dateAvailableFrom=" + dateAvailableFrom +
                ", hotel=" + hotel +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        LocalDate dateAvailableThis = new Timestamp(getDateAvailableFrom().getTime()).toLocalDateTime().toLocalDate();
        LocalDate dateAvailableObject = new Timestamp(room.getDateAvailableFrom().getTime()).toLocalDateTime().toLocalDate();
        return numberOfGuests == room.numberOfGuests &&
                Double.compare(room.price, price) == 0 &&
                breakfastIncluded == room.breakfastIncluded &&
                petsAllowed == room.petsAllowed &&
                Objects.equals(dateAvailableThis, dateAvailableObject) &&
                Objects.equals(hotel, room.hotel);
    }

    @Override
    public int hashCode() {
        LocalDate dateAvailableThis = new Timestamp(getDateAvailableFrom().getTime()).toLocalDateTime().toLocalDate();
        return Objects.hash(numberOfGuests, price, breakfastIncluded, petsAllowed, dateAvailableThis, hotel);
    }
}
