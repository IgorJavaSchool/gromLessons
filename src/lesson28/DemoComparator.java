package lesson28;

import java.util.*;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class DemoComparator {
    public static void main(String[] args) {
        Capability capability1 = new Capability(1001, "test9", "ddd", true, new Date());   //9
        Capability capability2 = new Capability(1005, "test6", "eee", false, new Date());  //6
        Capability capability3 = new Capability(900, "test8", "iii", true, new Date());    //8
        Capability capability4 = new Capability(901, "test7", "iii", false, new Date());   //7
        Capability capability5 = new Capability(902, "test5", "iii", false, new Date());   //5
        Capability capability6 = new Capability(903, null, "iii1", false, new Date());  // 1
        Capability capability7 = new Capability(904, "test2", "iii", false, new Date());   //3
        Capability capability8 = new Capability(905, "test2", "iii", false, new Date());   //4
        Capability capability9 = new Capability(906, "test1", "iii2", false, new Date());  // 2

        ArrayList<Capability> capabilities = new ArrayList<>();
        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(capability3);
        capabilities.add(capability4);
        capabilities.add(capability5);
        capabilities.add(capability6);
        capabilities.add(capability7);
        capabilities.add(capability8);
        capabilities.add(capability9);

        System.out.println(capabilities.toString());

        capabilities.sort(new IsActiveComparator());

        System.out.println(capabilities.toString());

        FullComparator fullComparator = new FullComparator();
        capabilities.sort(fullComparator);

        System.out.println(capabilities);
    }

}
