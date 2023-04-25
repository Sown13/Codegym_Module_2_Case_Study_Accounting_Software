package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadMapData<K,T> {
    public Map<K, T> loadMapData(String pathName){
        Map<K, T> map = new HashMap<>();
        File saveFile = new File(pathName);
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(saveFile))){
            map = (Map<K, T>) reader.readObject();
            System.out.println("Read success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

}
