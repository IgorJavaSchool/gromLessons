package lesson33.c;

import lesson33.a.ReadWriteFile;
import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class WriteFromFile {
    void readFileByConsolePath() throws Exception {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);
        String path = "";
        System.out.println("Please, enter file path to read:");
        try {
            path = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(streamReader);
            IOUtils.closeQuietly(reader);
        }
        validateFile(path);
        new ReadWriteFile().readeFile(path);
    }

    private void validateFile(String path) throws Exception {
        if (!new File(path).exists()){
            throw new FileNotFoundException("File with path " + path +" not found");
        }
        if (!new File(path).canWrite()){
            throw new Exception("File with path" + path + " is can't read");
        }
    }
}
