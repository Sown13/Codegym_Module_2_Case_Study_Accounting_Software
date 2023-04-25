package io;

import java.io.*;
import java.util.List;

public class WriteData<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 6529685098267757690L;
    public void writeToSaveFile(List<T> exportList, String pathName){
        File saveFile = new File(pathName);
        try(FileOutputStream fileOutputStream = new FileOutputStream(saveFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream) ){
            objectOutputStream.writeObject(exportList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
