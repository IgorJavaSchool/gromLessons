package lesson9;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by MM on 11.12.2017.
 */
public class Demo {
    public static void main(String[] args) {
        User user = new User(1l, "user", "qwerty");
        User user1 = new User(2l, "user1", "qwerty");
        User user2 = new User(3l, "user2", "qwerty");
        User user3 = new User(0, null, null);
        User user4 = new User(5l, "user4", "qwerty");
        User user5 = new User(6l, "user5", "qwertyy");

        ArrayList<User> users = new ArrayList<>(Arrays.asList(new User[]{user, user1, user2, user3, user4})) ;
        ArrayList<User> users2 = new ArrayList<>(Arrays.asList(new User[]{user, user1, user2, user3, user4}));
        ArrayList<User> users3 = new ArrayList<>(Arrays.asList(new User[]{user, user1, null, user3, user4}));

        UserRepository userRepository = new UserRepository(users);
        UserRepository userRepository2 = new UserRepository(users2);
        UserRepository userRepository3 = new UserRepository(users3);


        /**
         * Tests method getUserNames().
         */
        for (String userName : userRepository.getUserNames()){
            System.out.println(userName);
        }

        for (String userName : userRepository2.getUserNames()){
            System.out.println(userName);
        }

        for (String userName : userRepository3.getUserNames()){
            System.out.println(userName);
        }

        /**
         * Tests method getUserIds().
         */

        for (long id : userRepository.getUserIds()){
            System.out.println(id);
        }

        for (long id : userRepository2.getUserIds()){
            System.out.println(id);
        }

        for (long id : userRepository3.getUserIds()){
            System.out.println(id);
        }

        /**
         * Tests method getUserNameById().
         */
        System.out.println(userRepository.getUserNameById(3l));
        System.out.println(userRepository2.getUserNameById(3l));
        System.out.println(userRepository3.getUserNameById(3l));

        /**
         * Tests method getUserNameById().
         */
        System.out.println(userRepository.getUserByName("user2").getName());
        System.out.println(userRepository2.getUserByName("user2").getName());
        try {
            System.out.println(userRepository3.getUserByName("user2").getName());
        } catch (Exception e) {
            System.err.println("User is not find");
        }

        /**
         * Tests method getUserBySessionId().
         */
        System.out.println(userRepository.getUserBySessionId("qwerty").getName());
        System.out.println(userRepository2.getUserBySessionId("qwerty").getName());
        System.out.println(userRepository3.getUserBySessionId("qwerty").getName());

        /**
         * Tests method save(User user).
         */
        try {
            System.out.println(userRepository.save(user5).getName());
        } catch (Exception e) {
            System.err.println("Returns NULL");
        }
        userRepository = new UserRepository(users2);
        try {
            System.out.println(userRepository.save(user).getName());
        } catch (Exception e) {
            System.err.println("Returns NULL");
        }
        userRepository = new UserRepository(users3);
        try {
            System.out.println(userRepository.save(user5).getName());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
