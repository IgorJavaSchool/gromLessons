package hotelOnlineBooking.services;

import hotelOnlineBooking.models.Model;
import hotelOnlineBooking.models.User;
import hotelOnlineBooking.repository.UserRepository;
import hotelOnlineBooking.services.ServicesExceptions.FindInstanceException;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class UserService implements ValidatorFields{
    private UserRepository userRepository = new UserRepository();


    /**
     * Проверяет бизнес правила. Поля объекта не могут быть пустые и другие проверки согласно заданию
     *
     * @param user
     * @return
     */
    public User registerUser(User user) throws FindInstanceException {
        validateFields(user);
        // Check business logic
        // TODO: 27.02.2018
        return userRepository.registerUser(user);
    }

    @Override
    public void validateFields(Model model) throws FindInstanceException {
        User user = (User) model;
        if (user == null) {
            throw new NullPointerException("User should not be null");
        }
        if (user.getUserName() == null || user.getUserName().isEmpty()){
            throw new NullPointerException("User's field UserName should not be null or empty");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()){
            throw new NullPointerException("User's field Password should not be null or empty");
        }
        if (user.getCountry() == null || user.getCountry().isEmpty()){
            throw new NullPointerException("User's field Country should not be null or empty");
        }
        if (user.getUserType() == null || user.getUserType().name().isEmpty()){
            throw new NullPointerException("User's field UserTape should not be null or empty");
        }
        if (userRepository.getModels().contains(user)) throw new FindInstanceException("Repository contain the model", user);
    }
}
