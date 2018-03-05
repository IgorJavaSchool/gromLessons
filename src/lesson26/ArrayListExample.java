package lesson26;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MM on 20.12.2017.
 */
public class ArrayListExample {
    public static void main(String[] args) {
        int[] numders = {1,2,3,4,5,6,7,8,9};
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(11);
        arrayList.add(12);
        arrayList.add(13);
        System.out.println(arrayList.toString());
        arrayList.remove(2);
        System.out.println(arrayList.toString());
        arrayList.add(13);
        arrayList.add(13);
        System.out.println(arrayList.toString());
        arrayList.add(2, 15);
        System.out.println(arrayList.toString());

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(0);

        arrayList.addAll(list);
        System.out.println(arrayList.toString());
        arrayList.set(3, 555);
        System.out.println(arrayList.toString());
        arrayList.clear();
        System.out.println(arrayList.toString());


    }
}
