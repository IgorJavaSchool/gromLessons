package hotelOnlineBooking.repository;

import hotelOnlineBooking.models.Hotel;
import hotelOnlineBooking.models.Model;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class HotelRepository extends GeneralRepository implements ActionsRepository {

    {
        setPath("./src/hotelOnlineBooking/resources/Hotels");
    }

    /**
     * The method use only admin
     * @param hotel
     */
    public void addHotel(Hotel hotel){
        hotel.setId(generateId());
        addToRepository(hotel, getModelFields(hotel));
    }


    /**
     *  The method use only admin
     * @param hotelId
     */
    public void deleteHotel(long hotelId){
        Hotel hotel = (Hotel) parseField(getById(hotelId));
        removeModelFromFile(hotel);
    }

    /**
     * Returns all values fields received object in array strings.
     * @param model
     * @return
     */
    @Override
    public String[] getModelFields(Model model) {
        Hotel hotel = (Hotel) model;
        return new String[]{String.valueOf(hotel.getId()), hotel.getName(), hotel.getCountry(),
                hotel.getCity(), hotel.getStreet()};
    }

    /**
     * Parses and checks all fields before create instance.
     *
     * @param orderFields
     *
     * @return
     */
    @Override
    public Model parseField(String[] orderFields) {
        long ID;
        try {
            ID = parseID(orderFields[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        Hotel hotel = new Hotel(orderFields[1], orderFields[2], orderFields[3], orderFields[4]);
        hotel.setId(ID);
        return hotel;
    }

}
