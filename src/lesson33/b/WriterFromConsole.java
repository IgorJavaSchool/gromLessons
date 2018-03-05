package lesson33.b;

import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class WriterFromConsole {
    void writeToFileFromConsole(String path) throws Exception {
        validateFile(path);

        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);
        BufferedWriter writer = null;
        FileWriter fileWriter = null;
        System.out.println("Enter file content to write in the file:");
        String lineConsole;

        try {
            fileWriter = new FileWriter(path, true);
            writer = new BufferedWriter(fileWriter);
            while (true) {
                lineConsole = reader.readLine();
                if (lineConsole.equals("wr"))
                    break;
                writer.append(lineConsole).append("\r\n");
            }
        } catch (IOException e) {
            System.out.println("Can't write to file with path " + path);

        } finally {
            IOUtils.closeQuietly(streamReader);
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(writer);
            IOUtils.closeQuietly(fileWriter);
        }
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
