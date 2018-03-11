package hotelOnlineBooking.repository;

import hotelOnlineBooking.models.Model;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class GeneralRepository <T extends Model> {
    private String path;
    private final SimpleDateFormat DATAFORMAT = new SimpleDateFormat("dd.MM.yyyy");


    /**
     * Generator new ID
     * @return
     */
    long generateId(){
        long newID = 0;
        List<String[]> models = readModelsFields(path);
        for (String[] line: models){
            newID = newID < Integer.parseInt(line[0]) ? Integer.parseInt(line[0]) : newID;
        }
        return ++newID;
    }


    /**
     * Finds model by ID.
     * @param id
     * @return
     */
    public String[] getById(long id){
        List<String[]> models = readModelsFields(path);
        for (String[] line : models){
            if (Integer.parseInt(line[0]) == id) {
                return line;
            }
        }
        return null;
    }

     T addToRepository(T t, String[] fields){
        writeToFile(createBuilder(fields));
        return t;
    }

    /**
     * Removes model from file.
     * @param t
     */
    void removeModelFromFile(T t){
        List<String[]> modelsFieldList = readModelsFields(path);
        StringBuilder lineBD = new StringBuilder();
        for (String[] modelFields : modelsFieldList){
            if (String.valueOf(t.getId()).equals(modelFields[0])){
                modelsFieldList.remove(modelFields);
                try {
                    new FileWriter(path);
                    for (String[] strings : modelsFieldList){
                        lineBD.append(createBuilder(strings));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                writeToFile(lineBD);
                break;
            }
        }
    }


    /**
     * Writes model to file.
     * @param fields
     */
    private StringBuilder createBuilder(String[] fields){
            StringBuilder lineBD = new StringBuilder();
            for (int i = 0; i < fields.length - 1; i++) {
                lineBD.append(fields[i]).append(", ");
            }
            lineBD.append(fields[fields.length - 1]);
            lineBD.append("\n");
        return lineBD;
    }
    private void writeToFile(StringBuilder builder){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))){
            writer.append(builder);
        } catch (IOException e) {
            e.printStackTrace();
        }
        }


    /**
     * @return array fields all models from file data base in format String.
     */
    List<String[]> readModelsFields(String path){
        List<String[]> modelsField = new ArrayList<>();
        String fields;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            while ((fields = reader.readLine()) != null) {
                modelsField.add(fields.split(", "));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return modelsField;
    }

    /**
     * Parses ID
     */
    long parseID(String fieldID){
        long ID;
        try {
            ID = Long.parseLong(fieldID);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
        if (ID < 1) return 0;
        return ID;
    }

    String getPath() {
        return path;
    }

    void setPath(String path) {
        this.path = path;
    }

    SimpleDateFormat getDATAFORMAT() {
        return DATAFORMAT;
    }

    public Collection<T> getModels(){
        Collection<T> collection = new HashSet<>();
        List<String[]> rooms = readModelsFields(getPath());
        ActionsRepository<T> actionsRepository = (ActionsRepository<T>) this;
        for (Object line : rooms){
            collection.add((T) actionsRepository.parseField((String[]) line));
        }
        return collection;
    }

    public boolean contains(Model model){
        ActionsRepository<T> actionsRepository = (ActionsRepository<T>) this;
        String[] modelFields = actionsRepository.getModelFields((T) model);
        List<String[]> models = readModelsFields(getPath());
        for (String[] fields : models){
            if (Arrays.equals(fields, modelFields)) return true;
        }
        return false;
    }
}
