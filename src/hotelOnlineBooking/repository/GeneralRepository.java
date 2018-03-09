package hotelOnlineBooking.repository;

import hotelOnlineBooking.models.Model;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class GeneralRepository <T extends Model> {
    private Collection<T> models = new HashSet<>();
    private String path;
    private final SimpleDateFormat DATAFORMAT = new SimpleDateFormat("dd.MM.yyyy");


    /**
     * Generator new ID
     * @return
     */
    long generateId(){
        long newID = 0;
        for (T t: models){
            newID = newID < t.getId() ? t.getId() : newID;
        }
        return ++newID;
    }


    /**
     * Finds model by ID.
     * @param id
     * @return
     */
    public T getById(long id){
        for (T t : models){
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public T addToRepository(T t, String[] fields){
        writeModelToFile(fields);

        getModels().add(t);

        return t;
    }

    /**
     * Removes model from file.
     * @param t
     */
    void removeModelFromFile(T t){
        List<String[]> modelsFieldList = readModelsFields(path);
        for (String[] modelFields : modelsFieldList){
            if (String.valueOf(t.getId()).equals(modelFields[0])){
                modelsFieldList.remove(modelFields);
                break;
            }
        }
        try (FileWriter fileWriter = new FileWriter(path)){
            for (String[] modelFields : modelsFieldList){
                writeModelToFile(modelFields);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Writes model to file.
     * @param fields
     */
    void writeModelToFile(String[] fields){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))){
            StringBuilder lineBD = new StringBuilder();
            for (int i = 0; i < fields.length - 1; i++) {
                lineBD.append(fields[i]).append(", ");
            }
            lineBD.append(fields[fields.length - 1]);
            lineBD.append("\n");
            writer.append(lineBD);
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

    /**
     *
     * @param fields Object's fields from file's DB.
     * @return true is all fields are not empty.
     */
    boolean isEmptyFields(String[] fields){
        for (String field : fields){
            if (field.isEmpty()|| Objects.equals(field, " ")) return true;
        }
        return false;
    }



    String getPath() {
        return path;
    }

    void setPath(String path) {
        this.path = path;
    }

    public Collection<T> getModels() {
        return models;
    }

    public void setModels(Collection<T> models) {
        this.models = models;
    }

    SimpleDateFormat getDATAFORMAT() {
        return DATAFORMAT;
    }
}
