package hotelOnlineBooking.models;

import java.util.Objects;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class User extends Model {
    private String userName;
    private String password;
    private String country;
    private UserType userType;

    public User(String userName, String password, String country, UserType userType) {
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

    public UserType getUserType() {
        return userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName = '" + userName + '\'' +
                ", password = '" + password + '\'' +
                ", country = '" + country + '\'' +
                ", userType = " + userType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return  Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password) &&
                Objects.equals(country, user.country) &&
                userType == user.userType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password, country, userType);
    }
}
