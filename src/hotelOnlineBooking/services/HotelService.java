package hotelOnlineBooking.services;

import hotelOnlineBooking.models.Hotel;
import hotelOnlineBooking.models.Model;
import hotelOnlineBooking.repository.HotelActionsRepository;
import hotelOnlineBooking.services.ServicesExceptions.FindInstanceException;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class HotelService implements ValidatorFields{

    private HotelActionsRepository hotelRepository = new HotelActionsRepository();

    public void addHotel(Hotel hotel) throws FindInstanceException {
        validateFields(hotel);
        hotelRepository.addHotel(hotel);
    }

    public void deleteHotel(long hotelId){
        Hotel hotel = (Hotel) hotelRepository.getById(hotelId);
        if (hotel == null) throw new NullPointerException("The hotel not find into DB and can't delete");
        hotelRepository.deleteHotel(hotelId);
    }


    @Override
    public void validateFields(Model model) throws FindInstanceException {
        Hotel hotel = (Hotel) model;
        if (hotel == null) {
            throw new NullPointerException("Hotel should not be null");
        }
        if (hotel.getName() == null || hotel.getName().isEmpty()){
            throw new NullPointerException("Hotel's field Name should not be null or empty");
        }
        if (hotel.getCity() == null || hotel.getCity().isEmpty()){
            throw new NullPointerException("Hotel's field City should not be null or empty");
        }
        if (hotel.getCountry() == null || hotel.getCountry().isEmpty()){
            throw new NullPointerException("Hotel's field Country should not be null or empty");
        }
        if (hotel.getStreet() == null || hotel.getStreet().isEmpty()){
            throw new NullPointerException("Hotel's field Street should not be null or empty");
        }
        if (hotelRepository.getModels().contains(model)){
            throw new FindInstanceException("Repository contain the model", model);
        }
    }
}
