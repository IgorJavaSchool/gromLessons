package lesson11.bigInterfaceExamole;

/**
 * Created by MM on 13.12.2017.
 */
public class SimpleReader implements Readable {


    @Override
    public void readFileFromStorage(Storage storage) {
        for (File file: storage.getFiles()){
            if (file != null) {
                System.out.println(file.getName());
            } else
                System.out.println(file);
        }
    }
}
