package lesson24;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Sys {
    private String nameSys;
    private boolean validate;
    private int version;

    public Sys(String nameSys, boolean validate, int version) {
        this.nameSys = nameSys;
        this.validate = validate;
        this.version = version;
    }

    @Override
    public String toString() {
        return "Sys{" +
                "nameSys='" + nameSys + '\'' +
                ", validate=" + validate +
                ", version=" + version +
                '}';
    }
}
