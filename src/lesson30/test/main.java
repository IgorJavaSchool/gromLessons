package lesson30.test;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * Created by MM on 29.01.2018.
 */
public class main {
    public static void main(String[] args) {
        if (true) {
            throw new IllegalArgumentException("Parameter customer can't is null");
        }
        User[] users;
        Collection<Progect> progects;
        Controller controller = new Controller();

        users = controller.createUsers();
        progects = controller.createProject();

        Date dateStart = new Date();
        for (int i = 1; i < users.length; i++) {
            Collections.disjoint(users[0].getProgects(), users[i].getProgects());
        }
        Date dateFinish = new Date();

        System.out.println(dateFinish.getTime() - dateStart.getTime());

        dateStart = new Date();
        for (Progect progect : progects){
            for (int i = 0; i < users.length; i++) {
                users[i].getProgects().contains(progect);
            }
        }
        dateFinish = new Date();
        System.out.println(dateFinish.getTime() - dateStart.getTime());

    }
}
