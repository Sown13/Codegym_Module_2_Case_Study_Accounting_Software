package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class WriteData<T> {
    public void writeToSaveFile(List<T> exportList){
        String pathName = "";
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
