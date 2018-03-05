package lesson28;

import java.util.Date;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Capability implements Comparable<Capability> {
    private long id;
    private String channelName;
    private String fingerprint;
    private boolean isActive;
    private Date dateCreate;

    public Capability(long id, String channelName, String fingerprint, boolean isActive, Date dateCreate) {
        this.id = id;
        this.channelName = channelName;
        this.fingerprint = fingerprint;
        this.isActive = isActive;
        this.dateCreate = dateCreate;
    }

    public long getId() {
        return id;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public boolean isActive() {
        return isActive;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    @Override
    public int compareTo(Capability o) {
        return (int) (getId() - o.getId());
    }

    @Override
    public String toString() {
        return "Capability{" +
                "id=" + id +
                ", channelName='" + channelName + '\'' +
                ", fingerprint='" + fingerprint + '\'' +
                ", isActive=" + isActive +
                ", dateCreate=" + dateCreate +
                '}';
    }
}
