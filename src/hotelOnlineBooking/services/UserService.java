package hotelOnlineBooking.services;

import hotelOnlineBooking.models.Model;
import hotelOnlineBooking.models.User;
import hotelOnlineBooking.repository.UserRepository;
import hotelOnlineBooking.services.ServicesExceptions.FindInstanceException;
import hotelOnlineBooking.services.ServicesExceptions.IncorrectUserFieldException;

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
    public User registerUser(User user) throws FindInstanceException, IncorrectUserFieldException {
        validateFields(user);
        return userRepository.registerUser(user);
    }

    @Override
    public void validateFields(Model model) throws FindInstanceException, IncorrectUserFieldException {
        User user = (User) model;
        if (user == null) {
            throw new NullPointerException("User should not be null");
        }
        if (user.getUserName() == null || user.getUserName().isEmpty()){
            throw new IncorrectUserFieldException("User's field UserName should not be null or empty");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()){
            throw new IncorrectUserFieldException("User's field Password should not be null or empty");
        }
        if (user.getCountry() == null || user.getCountry().isEmpty()){
            throw new IncorrectUserFieldException("User's field Country should not be null or empty");
        }
        if (user.getUserType() == null || user.getUserType().name().isEmpty()){
            throw new IncorrectUserFieldException("User's field UserTape should not be null or empty");
        }
        if (userRepository.contains(user)) throw new FindInstanceException("Repository contain the model", user);
    }
}
