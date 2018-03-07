package hotelOnlineBooking.services;

import hotelOnlineBooking.models.Filter;
import hotelOnlineBooking.models.Model;
import hotelOnlineBooking.models.Room;
import hotelOnlineBooking.repository.HotelRepository;
import hotelOnlineBooking.repository.RoomRepository;
import hotelOnlineBooking.services.ServicesExceptions.CountGuestException;
import hotelOnlineBooking.services.ServicesExceptions.FindInstanceException;
import hotelOnlineBooking.services.ServicesExceptions.IncorrectDateException;
import hotelOnlineBooking.services.ServicesExceptions.PriceException;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class RoomService implements ValidatorFields{
    private RoomRepository roomRepository = new RoomRepository();
    private HotelRepository hotelRepository = new HotelRepository();

    /**
     *  The method use only admin
     * @param room
     */
    public void addRoom(Room room) throws FindInstanceException, IncorrectDateException, PriceException, CountGuestException {
        validateFields(room);
        roomRepository.addRoom(room);
    }


    /**
     * Checks if roon not null.
     *  The method use only admin.
     * @param roomId
     */
    public void deleteRoom(long roomId){
        Room room = (Room) roomRepository.getById(roomId);
        if (room == null) throw new NullPointerException("The room not find into DB and can't delete");
        roomRepository.deleteRoom(room.getId());
    }


    /**
     * Finds and returns rooms by filter
     * @param filter
     * @return
     */
    public Collection<Room> findRooms(Filter filter){
        Collection<Room> rooms = roomRepository.getModels();
        int numberOfGuests;
        if (filter.getNumberOfGuests() > 0){
            Collection<Room> filterRooms = numberOfGuestFilter(filter.getNumberOfGuests(), rooms);
            if (!filterRooms.isEmpty()) rooms = filterRooms;
        }
        double price;
        if (filter.getPrice() > 0){
            Collection<Room> filterRooms = rooms.stream().filter(room ->
                    room.getPrice() <= filter.getPrice()).collect(Collectors.toCollection(HashSet::new));
            if (!filterRooms.isEmpty()) rooms = filterRooms;
        }

        boolean breakfastIncluded;
        boolean petsAllowed;
        Collection<Room> filterRooms = rooms.stream().filter(room ->
                room.isBreakfastIncluded() == filter.isBreakfastIncluded() &&
                        room.isPetsAllowed() == filter.isPetsAllowed()).collect(Collectors.toCollection(HashSet::new));
        if (!filterRooms.isEmpty()) rooms = filterRooms;
        Date dateAvailableFrom;
        if (!filter.getDateAvailableFrom().before(new Date())){
            filterRooms = rooms.stream().filter(room ->
                    room.getPrice() <= filter.getPrice()).collect(Collectors.toCollection(HashSet::new));
            if (!filterRooms.isEmpty()) rooms = filterRooms;
        }
        String hotelName;
        String country;
        String city;
        // TODO: 27.02.2018
        return null;
    }

    private Collection<Room> numberOfGuestFilter(int numberOfGuests, Collection<Room> rooms){
        if (numberOfGuests > 0) {
            return rooms.stream().filter(room ->
                    room.getNumberOfGuests() == numberOfGuests).collect(Collectors.toCollection(HashSet::new));
        } else return rooms;
    }

    private Collection<Room> priceFilter(double price, Collection<Room> rooms){
            return price > 0 ? rooms.stream().filter(room ->
                    room.getPrice() <= price).collect(Collectors.toCollection(HashSet::new)) : rooms;
    }

    private Collection<Room> breakfastIncludedFilter(boolean breakfastIncluded, Collection<Room> rooms){
            return breakfastIncluded ?
                    rooms.stream().filter(Room::isBreakfastIncluded).collect(Collectors.toCollection(HashSet::new))
                    : rooms;
    }

    private Collection<Room> petsAllowedFilter(boolean petsAllowed, Collection<Room> rooms){
        return petsAllowed ? rooms.stream().filter(Room::isPetsAllowed).collect(Collectors.toCollection(HashSet::new))
                : rooms;
    }

    private Collection<Room> dateAvailableFromFilter(Date dateAvailableFrom, Collection<Room> rooms){

        return dateAvailableFrom.after(new Date()) ? rooms.stream().filter(room ->
                room.getDateAvailableFrom().compareTo(dateAvailableFrom) == 0).collect(Collectors.toCollection(HashSet::new))
                : rooms;
    }

    private Collection<Room> hotelNameFilter(String hotelName, Collection<Room> rooms){
        return hotelName != null && !hotelName.isEmpty() ? rooms.stream().filter(room ->
                room.getHotel().getName().equals(hotelName)).collect(Collectors.toCollection(HashSet::new)) : rooms;
    }

    private Collection<Room> countryFilter(String country, Collection<Room> rooms){
        return country != null && !country.isEmpty() ? rooms.stream().filter(room ->
                room.getHotel().getCountry().equals(country)).collect(Collectors.toCollection(HashSet::new)) : rooms;
    }

    private Collection<Room> cityFilter(String city, Collection<Room> rooms){
        return city != null && !city.isEmpty() ? rooms.stream().filter(room ->
                room.getHotel().getCity().equals(city)).collect(Collectors.toCollection(HashSet::new)) : rooms;
    }

    @Override
    public void validateFields(Model model) throws FindInstanceException, IncorrectDateException, PriceException, CountGuestException {
        Room room = (Room) model;
        if (room == null) {
            throw new NullPointerException("Room should not null");
        }
        if (room.getNumberOfGuests() < 1 || room.getNumberOfGuests() > 15){
            throw new CountGuestException(room.getNumberOfGuests());
        }
        if (room.getPrice() < 1) throw new PriceException("Price should more 0", room.getPrice());

        if (room.getDateAvailableFrom() == null)
            throw new NullPointerException("Date available should not null");
        if (room.getDateAvailableFrom().before(new Date()))
            throw new IncorrectDateException("Date available should not be less then the current date", room.getDateAvailableFrom());
        if (room.getHotel() == null) throw new NullPointerException("Room's field \"Hotel\" should not be null");
        if (!hotelRepository.getModels().contains(room.getHotel())){
            throw new FindInstanceException(room.getHotel());
        }
        if (roomRepository.getModels().contains(room)) throw new FindInstanceException("Repository contain the model", room);
    }


}
