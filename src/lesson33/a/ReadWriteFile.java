package lesson33.a;


import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class ReadWriteFile {
    public void readeFile(String path){
        BufferedReader reader = null;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
            reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(fileReader);
        }
    }
    public void writeFile(String path, String content){
        BufferedWriter writer = null;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path, true);
            writer = new BufferedWriter(fileWriter);
            writer.append(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(writer);
            IOUtils.closeQuietly(fileWriter);
        }
    }
}
