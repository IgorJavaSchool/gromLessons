package lesson30.test;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by MM on 29.01.2018.
 */
public class Controller {
    public User[] createUsers(){
        User[] users = new User[10000];
        for (int i = 0; i < 10000; i++) {
            users[i] = new User("User" + i, createProject());
        }
        return users;
    }
    public Collection<Progect> createProject(){
        Collection<Progect> projects = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            projects.add(new Progect("Project" + i));
        }
        return projects;
    }
}
