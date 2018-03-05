package lesson11.bigInterfaceExamole;

/**
 * Created by MM on 13.12.2017.
 */
public class Storage {
    private File[] files = new File[5];


    public Storage(File[] files) {
        this.files = files;
    }

    public File[] getFiles() {
        return files;
    }
}
