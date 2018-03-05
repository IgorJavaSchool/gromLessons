package lesson28;

import java.util.Comparator;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class FullComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        if (checkChannelName(o1, o2)) {
            return compareChannelName(o1, o2);
        }
        if (!o1.getChannelName().equals(o2.getChannelName())){
            return o1.getChannelName().compareTo(o2.getChannelName());
        } else {
            if (checkFingerprint(o1, o2)){
                return compareFingerprint(o1, o2);
            }
            if (!o1.getFingerprint().equals(o2.getFingerprint())){
                return o1.getFingerprint().compareTo(o2.getFingerprint());
            }
            return new DateComparator().compare(o1,o2);
        }
    }

    /**
     * Checked if field ChannelName have value Null
     * @param o1
     * @param o2
     * @return
     */
    private boolean checkChannelName(Capability o1, Capability o2){
        return o1.getChannelName() == null || o2.getChannelName() == null;

    }

    /**
     * Comparator if field ChannelName have value Null
     * @param o1
     * @param o2
     * @return
     */
    private int compareChannelName(Capability o1, Capability o2){
        if (o1.getChannelName() == null && o2.getChannelName() != null)
            return 1;
        if (o1.getChannelName() != null && o2.getChannelName() == null)
            return -1;
        return 0;
    }

    /**
     * Checked if field Fingerprint have value Null
     * @param o1
     * @param o2
     * @return
     */
    private boolean checkFingerprint(Capability o1, Capability o2){
        return o1.getFingerprint() == null || o2.getFingerprint() == null;

    }

    /**
     * Comparator if field Fingerprint have value Null
     * @param o1
     * @param o2
     * @return
     */
    private int compareFingerprint(Capability o1, Capability o2){
        if (o1.getFingerprint() == null && o2.getFingerprint() != null)
            return 1;
        if (o1.getFingerprint() != null && o2.getFingerprint() == null)
            return -1;
        return 0;
    }


}
