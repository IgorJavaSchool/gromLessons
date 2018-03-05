package lesson24;

import java.util.Arrays;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Demo {
    public static void main(String[] args) {
        Order order = new Order("Phone", 1500, "Jon");
        Sys sys = new Sys("Operation", true, 123);
        Tool tool = new Tool("Bosh", 123, 520);

        GeneralDao<Order> orderGeneralDao = new GeneralDao<Order>();
        orderGeneralDao.save(order);

        GeneralDao<Sys> sysGeneralDao = new GeneralDao<Sys>();
        sysGeneralDao.save(sys);

        GeneralDao<Tool> toolGeneralDao = new GeneralDao<Tool>();
        toolGeneralDao.save(tool);

        GeneralDao[] generalDao = new GeneralDao[]{orderGeneralDao, sysGeneralDao, toolGeneralDao};

        for (GeneralDao dao : generalDao) {
            System.out.println(Arrays.toString(dao.getTs()));
        }
    }
}
