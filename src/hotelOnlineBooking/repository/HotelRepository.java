package hotelOnlineBooking.repository;

import hotelOnlineBooking.models.Hotel;
import hotelOnlineBooking.models.Model;

import java.util.HashSet;
import java.util.List;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class HotelRepository extends GeneralRepository implements RepositoryFills{

    {
        setPath("src\\hotelOnlineBooking\\resources\\Hotels");
        fillRepository(readModelsFields(getPath()));
    }
//"src\\hotelOnlineBooking\\resources\\Hotels"

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
        removeModelFromFile(getById(hotelId));
        fillRepository(readModelsFields(getPath()));
    }

    /**
     * Fills local repository from file's repository.
     * @param fields
     */
    @Override
    public void fillRepository(List fields) {
        setModels(new HashSet<>());
        Hotel hotel;
        for (String[] hotelFields  : (List<String[]>) fields){
            if (hotelFields.length != 5 || isEmptyFields(hotelFields)) continue;
            hotel = (Hotel) parseFieldOrder(hotelFields);
            if (hotel == null) continue;
            getModels().add(hotel);
        }
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
    public Model parseFieldOrder(String[] orderFields) {
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
