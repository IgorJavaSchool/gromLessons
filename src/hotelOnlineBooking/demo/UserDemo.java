package hotelOnlineBooking.demo;

import hotelOnlineBooking.controllers.UserController;
import hotelOnlineBooking.models.User;
import hotelOnlineBooking.models.UserType;
import hotelOnlineBooking.services.ServicesExceptions.FindInstanceException;

import java.io.IOException;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class UserDemo {
    public static void main(String[] args) throws IOException {


        try {
            new UserController().registerUser(new User("Jon", "pass", "Canada", UserType.USER));
        } catch (FindInstanceException e) {
            e.printStackTrace();
        }
        try {
            new UserController().registerUser(new User("Ted", "pass123", "USA", UserType.ADMIN));
        } catch (FindInstanceException e) {
            e.printStackTrace();
        }
        try {
            new UserController().registerUser(new User(null, "pass123", "USA", UserType.ADMIN));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            new UserController().registerUser(new User("Ted", "", "USA", UserType.ADMIN));
        } catch (Exception e) {
            e.printStackTrace();
        }        try {
            new UserController().registerUser(new User("Ted", "pass123", "", UserType.ADMIN));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            new UserController().registerUser(new User("Ted", "pass123", "USA", null));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            new UserController().registerUser(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
