package hotelOnlineBooking.repository;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */

import hotelOnlineBooking.models.Model;
import hotelOnlineBooking.models.User;
import hotelOnlineBooking.models.UserType;

import java.util.Objects;

/**
 * Считывание данных - считывание файла
 * Обработка данных пользователи - маппинг данных - из исходных данных файла создавать объект
 * Need use one repository by generics.
 */
public class UserRepository extends GeneralRepository implements ActionsRepository {
    {
        setPath("./src/hotelOnlineBooking/resources/Users");
    }

    /**
     * Save user to file.
     * @param user
     * @return
     */
    public User registerUser(User user){
        user.setId(generateId());
        return (User) addToRepository(user, getModelFields(user));
    }

    public void deleteUser(User user){
        removeModelFromFile(user);
    }

    /**
     * Returns all values fields received object in array strings.
     * @param model
     * @return
     */
    @Override
    public String[] getModelFields(Model model) {
        User user = (User) model;
        return new String[]{String.valueOf(user.getId()), user.getUserName(), user.getPassword(),
                user.getCountry(), user.getUserType().toString()};
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
        for (String field : orderFields){
            if (field.isEmpty()|| Objects.equals(field, " ")) return null;
        }
        long ID;
        try {
            ID = parseID(orderFields[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        User user;
        try {
            user = new User(orderFields[1], orderFields[2], orderFields[3], UserType.valueOf(orderFields[4]));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
        user.setId(ID);
        return user;
    }


}
