package lesson10.onlineStore;

/**
 * Created by MM on 12.12.2017.
 */
public class Customer {
    private String name;
    private String city;
    private String gender;

    public Customer(String name, String city, String gender) {
        this.name = name;
        this.city = city;
        this.gender = gender;
    }

    public String getName() {
        if (name == null)
            return "";
        return name;
    }

    public String getCity() {
        if (city == null)
            return "";
        return city;
    }

    public String getGender() {
        if (gender == null)
            return "";
        return gender;
    }
}
