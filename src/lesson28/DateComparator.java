package lesson28;

import java.util.Comparator;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class DateComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        if (o1.getDateCreate() == null && o2.getDateCreate() != null)
            return 1;
        if (o1.getDateCreate() != null && o2.getDateCreate() == null)
            return -1;
        if (o1.getDateCreate() == null && o2.getDateCreate() == null)
            return 0;
            if (o1.getDateCreate().getTime() != o2.getDateCreate().getTime()){
            return o1.getDateCreate().compareTo(o2.getDateCreate());
        } else return 0;
    }
}
