package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;

public class WriteMapData<K,T> {
    public void writeToSaveFile(Map<K,T> exportList, String pathName){
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
