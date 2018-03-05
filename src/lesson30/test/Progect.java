package lesson30.test;

/**
 * Created by MM on 29.01.2018.
 */
public class Progect {
    String name;

    public Progect(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Progect)) return false;

        Progect progect = (Progect) o;

        if (name != null ? !name.equals(progect.name) : progect.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Progect{" +
                "name='" + name + '\'' +
                '}';
    }
}
