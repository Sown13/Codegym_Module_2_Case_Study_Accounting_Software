package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

public class ReadMapData<K,T> {
    public Map<K, T> loadMapData(String pathName){
        Map<K, T> map = new HashMap<>();
        File saveFile = new File(pathName);
        try {
            FileInputStream fi = new FileInputStream(saveFile);
            if(fi.available() > 0) {
                ObjectInputStream reader = new ObjectInputStream(fi);
                map = (Map<K, T>) reader.readObject();
                reader.close();
            }
            fi.close();
            System.out.println("Data loaded");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

}
