package lesson27;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class TestPerformance {

    public static void main(String[] args) {
    TestPerformance.add();
    TestPerformance.remove();
        TestPerformance.get();

    }
    private static void add(){
        ArrayList<String> arrayList = new ArrayList<String>();

        Date startArray = new Date();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(String.valueOf(i));
        }
        Date finishArray = new Date();

        LinkedList<String> linkedList = new LinkedList<>();

        Date linkedstart = new Date();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(String.valueOf(i));
        }
        Date linkedfinish = new Date();
        System.out.println("Speed linked add = " + (linkedfinish.getTime() - linkedstart.getTime()));
        System.out.println("Speed array add = " + (finishArray.getTime() - startArray.getTime()));
    }

    private static void remove() {

        ArrayList<String> arrayList = new ArrayList<String>();
        LinkedList<String> linkedList = new LinkedList<>();

        for (int i = 0; i < 100000; i++) {
            arrayList.add(String.valueOf(i));
        }

        for (int i = 0; i < 100000; i++) {
            linkedList.add(String.valueOf(i));
        }


        Date startArray = new Date();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.remove(0);
        }
        Date finishArray = new Date();
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.remove(0);
        }
        Date linkedstart = new Date();

        Date linkedfinish = new Date();
        System.out.println("Speed linked remove = " + (linkedfinish.getTime() - linkedstart.getTime()));
        System.out.println("Speed array remove = " + (finishArray.getTime() - startArray.getTime()));

    }

    private static void get() {

        ArrayList<String> arrayList = new ArrayList<String>();
        LinkedList<String> linkedList = new LinkedList<>();

        for (int i = 0; i < 100000; i++) {
            arrayList.add(String.valueOf(i));
        }

        for (int i = 0; i < 100000; i++) {
            linkedList.add(String.valueOf(i));
        }


        Date startArray = new Date();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }
        Date finishArray = new Date();
        System.out.println("Speed array get = " + (finishArray.getTime() - startArray.getTime()));

        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.get(i);
        }
        Date linkedstart = new Date();

        Date linkedfinish = new Date();
        System.out.println("Speed linked get = " + (linkedfinish.getTime() - linkedstart.getTime()));

    }
}
