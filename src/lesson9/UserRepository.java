package lesson9;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MM on 11.12.2017.
 */
public class UserRepository {
    private ArrayList<User> users;

    public UserRepository(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public List<String> getUserNames(){
        if (!users.isEmpty())
            return new ArrayList<>();

        List<String> listName = new ArrayList<>();

        for (int i = 0; i < getUsers().size(); i++) {
            if (users.get(i) != null) {
                listName.add(users.get(i).getName());
            }
        }
        return listName;
    }
    public List<Long> getUserIds(){
        if (!users.isEmpty()) {
            List<Long> listId = new ArrayList<Long>();
            for (User user : getUsers()) {
                if (user != null) {
                    listId.add(user.getId());
                }
            }
        }
        return new ArrayList<>();
    }
    public String getUserNameById(long id){
        if (!users.isEmpty()) {
            for (User user : users) {
                if (user != null) {
                    if (user.getId() == id) {
                        return user.getName();
                    }
                }
            }
        }
        return null;
    }


    public User getUserByName(String name){
        if (!users.isEmpty()) {
            for (User person : users) {
                if (person != null) {
                    if (person.getName().equals(name)) {
                        return person;
                    }
                }
            }
        }
        return null;
    }
    public User findById(long id){
        return getUserByName(getUserNameById(id));
    }
    public User getUserBySessionId(String sessionId){
        if (!users.isEmpty()) {
            for (User person : getUsers()) {
                if (person != null) {
                    if (person.getSessionId().equals(sessionId)) {
                        return person;
                    }
                }
            }
        }
        return null;

    }

    public User save(User user) {
        if (user != null) {
            if (!users.contains(user))
                users.add(user);
            return user;
        }
            return null;
    }

   public User update(User user){    //- будет обновлять текущего юзера в массиве (перезаписывать) и возвращать его. Если юзера нет, результат метода null
       if (user != null) {
           User userFind = findById(user.getId());
           if (userFind != null) {
               int idUser = users.indexOf(userFind);
               users.set(idUser, user);
               return user;
           }
       }
       return null;
    }

    public void delete(long id){
        users.removeIf(x -> x.getId() == id);
    }

}
