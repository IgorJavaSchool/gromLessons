package lesson34.b;

import org.apache.commons.io.FileUtils;

import java.io.*;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Solution {

    void copyFileContent(String fileFromPath, String fileToPath) {
        try (InputStream in = new BufferedInputStream(new FileInputStream(fileFromPath));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(fileToPath))) {

            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void copyFileContentApacheIO(String fileFromPath, String fileToPath){
        try {
            FileUtils.copyFile(new File(fileFromPath), new File(fileToPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
