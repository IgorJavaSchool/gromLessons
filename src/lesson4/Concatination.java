package lesson4;


/**
 * Created by MM on 15.12.2017.
 */
public class Concatination {
    public String concat(String s1, String s2, String s3){
        String result = "";
        if (s1 != null)
            result = result + s1;
        if (s2 != null)
            result = result + s2;
        if (s3 != null)
            result = result + s3;
        return result;
    }
}
