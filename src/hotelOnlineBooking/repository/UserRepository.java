package hotelOnlineBooking.repository;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */

import hotelOnlineBooking.models.Model;
import hotelOnlineBooking.models.User;
import hotelOnlineBooking.models.UserType;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * Считывание данных - считывание файла
 * Обработка данных пользователи - маппинг данных - из исходных данных файла создавать объект
 * Need use one repository by generics.
 */
public class UserRepository extends GeneralRepository implements RepositoryFills{
    {
        setPath("src\\hotelOnlineBooking\\resources\\Users");
        fillRepository(readModelsFields(getPath()));
    }
//"src\\hotelOnlineBooking\\resources\\Users"

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
        fillRepository(readModelsFields(getPath()));
    }

    public void updateUser(User user){
        if (getModels().contains(user)){
            deleteUser(user);
            registerUser(user);
        }
    }

    /**
     * Fills local repository from file's repository.
     * @param fields
     */
    @Override
    public void fillRepository(List fields){
        setModels(new HashSet<>());
        User user;
        for (String[] userFields : (List<String[]>) fields){
            if (userFields.length != 5 || isEmptyFields(userFields)) continue;
            user = (User) parseFieldOrder(userFields);
            if (user == null) continue;
            getModels().add(user);
            }
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
    public Model parseFieldOrder(String[] orderFields) {
        if (orderFields.length != 5) return null;
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
