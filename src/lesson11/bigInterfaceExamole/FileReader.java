package lesson11.bigInterfaceExamole;

/**
 * Created by MM on 13.12.2017.
 */
public class FileReader implements Readable {
    @Override
    public void readFileFromStorage(Storage storage) {

        printFile(findeMaxSizeFiles(storage.getFiles()));
    }

    private File findeMaxSizeFiles(File[] files){
        File maxSizeFile = files[0];

        for (File file : files){
            if (file.getSize() > maxSizeFile.getSize()){
                maxSizeFile = file;
            }
        }
        return maxSizeFile;
    }

    private void printFile(File file){
        System.out.println(file.getName());
        System.out.println(file.getExtension());
        System.out.println(file.getPath());
        System.out.println(file.getSize());
    }
}
