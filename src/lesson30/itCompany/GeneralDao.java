package lesson30.itCompany;

import java.util.Collection;

/**
 * Created by MM on 31.01.2018.
 */
public class GeneralDao<T> {
    Collection<T> collection;

    public GeneralDao(Collection<T> collection) {
        this.collection = collection;
    }

    public void add(T t){
        this.collection.add(t);
    }

    public void remove(T t){
        this.collection.remove(t);
    }

    public void update(T t){
        if (this.collection.contains(t)){
            collection.remove(t);
            collection.add(t);
        }
    }

    public Collection<T> getCollection() {
        return collection;
    }
}
