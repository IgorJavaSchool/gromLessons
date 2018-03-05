package lesson24;

/**
 * Created by MM on 19.12.2017.
 */
public class SysDao {
    Sys[] syses = new Sys[5];

    public Sys save(Sys sys){
        for (int i = 0; i < syses.length; i++) {
            if (syses[i] == null){
                syses[i] = sys;
                return sys;
            }
        }
        return null;
    }
}
