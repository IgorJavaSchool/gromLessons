package lesson25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class GeneralDao <T>{
    @SuppressWarnings("unchecked")
    T[] ts = (T[]) new Object[10];

    public T save(T t) throws Exception {
        if (t == null){
            throw new Exception("Can't add to arrays");
            }
        for (int i = 0; i < ts.length; i++) {
            if (ts[i] == null){
                ts[i] = t;
                return t;
            }
        }
        throw new Exception("Can't add to arrays");
    }

    public T[] getAll(){
        List<T> list = new ArrayList<>();
        for (T t : ts){
            if (t != null){
                list.add(t);
            }
        }
        return (T[])list.toArray();
    }

}
