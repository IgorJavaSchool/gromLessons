package lesson30.test;

import java.util.Collection;

/**
 * Created by MM on 29.01.2018.
 */
public class User {
    String username;
    Collection<Progect> progects;

    public User(String username, Collection<Progect> progects) {
        this.username = username;
        this.progects = progects;
    }

    public String getUsername() {
        return username;
    }

    public Collection<Progect> getProgects() {
        return progects;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", progects=" + progects +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (progects != null ? !progects.equals(user.progects) : user.progects != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (progects != null ? progects.hashCode() : 0);
        return result;
    }
}
