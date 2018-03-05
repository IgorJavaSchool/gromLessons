package lesson34.a;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class Solution {
    /**
     * Copies text into first file to the second file.
     * @param fileFromPath
     * @param fileToPath
     * @throws Exception
     */
    public void copyFileContent(String fileFromPath, String fileToPath) throws Exception {
        validateFiles(fileFromPath, fileToPath);
        validateFiles(fileFromPath, fileToPath);
        writeToFile(fileToPath, readeFile(fileFromPath));

    }

    /**
     * Transfers text into first file to the second file.
     * @param fileFromPath
     * @param fileToPath
     * @throws Exception
     */
    public void transferFileContent(String fileFromPath, String fileToPath) throws Exception {
        copyFileContent(fileFromPath, fileToPath);
        new FileWriter(fileFromPath);
    }

    /**
     * Transfers sentence which contains word into first file to the second file.
     * @param fileFromPath
     * @param fileToPath
     * @param word
     */
    public void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception {
        validateFiles(fileFromPath, fileToPath);
        StringBuilder stringBuilder = readeFile(fileFromPath);
        List<String> strings = new ArrayList<>();
        int startIndex = 0;
        int finishIndex = 1;
        while (finishIndex > 0){
            finishIndex = stringBuilder.indexOf(".", startIndex) + 1;
            if (finishIndex > 0) {
                strings.add(stringBuilder.substring(startIndex, finishIndex));
                startIndex = finishIndex;
            }

        }
        StringBuilder stringFileFrom = new StringBuilder();
        StringBuilder stringFileTo = new StringBuilder();
        for (String sentence : strings) {
            if (sentence.contains(word) && sentence.length() > 10){
                stringFileTo.append(sentence);
            } else {
                stringFileFrom.append(sentence);
            }
        }
        new FileWriter(fileToPath);
        new FileWriter(fileFromPath);
        writeToFile(fileToPath, stringFileTo);
        writeToFile(fileFromPath, stringFileFrom);
    }


    /**
     * Check on validate files.
     * @param fileFromPath
     * @param fileToPath
     * @throws Exception
     */
    private void validateFiles(String fileFromPath, String fileToPath) throws Exception {
        if (!new File(fileFromPath).exists()){
            throw new FileNotFoundException("File with path " + fileFromPath + " is not found");
        }
        if (!new File(fileFromPath).canRead()){
            throw new Exception("File with path" + fileFromPath + " is can't read");
        }
        if (!new File(fileToPath).exists()){
            throw new FileNotFoundException("File with path " + fileToPath + " is not found");
        }
        if (!new File(fileToPath).canWrite()){
            throw new Exception("File with path" + fileToPath + " is can't read");
        }
    }

    /**
     * Reads text from file.
     * @param pathFileFrom
     * @return
     */
    private StringBuilder readeFile(String pathFileFrom) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathFileFrom))) {
            while (reader.ready()) {
                stringBuilder.append(reader.readLine());
                stringBuilder.append("\r\n");
            }
            if (!stringBuilder.toString().isEmpty()) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        } catch (IOException e) {
            System.out.println("Can't read from file with path " + pathFileFrom);
        }
        return stringBuilder;
    }

    /**
     * Writes to file.
     * @param pathFileTo
     * @param text
     */
    private void writeToFile(String pathFileTo, StringBuilder text){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathFileTo, true))){
            writer.append(text);
        } catch (IOException e) {
            System.out.println("Can't write to file with path " + pathFileTo);
        }
    }
}
