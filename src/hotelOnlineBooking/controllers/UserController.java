package hotelOnlineBooking.controllers;

import hotelOnlineBooking.models.User;
import hotelOnlineBooking.services.ServicesExceptions.FindInstanceException;
import hotelOnlineBooking.services.ServicesExceptions.IncorrectUserFieldException;
import hotelOnlineBooking.services.UserService;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class UserController {
    private UserService userService = new UserService();

    /**
     * Registers new users
     * @param user
     * @return
     */
    public User registerUser(User user) throws FindInstanceException, IncorrectUserFieldException {
        return userService.registerUser(user);
    }


    /**
     * Authorization users
     * @param userName
     * @param password
     */
    public void login(String userName, String password){

    }

    /**
     * Logout
     */
    public void logout(){

    }

}
