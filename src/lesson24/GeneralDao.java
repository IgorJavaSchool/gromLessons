package lesson24;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class GeneralDao<T> {
    @SuppressWarnings("unchecked")
    private T[] ts = (T[]) new Object[5];


    public T[] save(T t){
        for (int i = 0; i < ts.length; i++) {
            if (ts[i] == null){
                ts[i] = t;
                return ts;
            }
        }
        return null;
    }

    public T[] getTs() {
        return ts;
    }
}
