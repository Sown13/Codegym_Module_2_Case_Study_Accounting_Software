package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadData<T> {
    public List<T> loadListData(String pathName) {
        List<T> list = new ArrayList<>();
        File saveFile = new File(pathName);
        try {
            FileInputStream fi = new FileInputStream(saveFile);
            if (fi.available() > 0) {
                ObjectInputStream reader = new ObjectInputStream(fi);
                list = (List<T>) reader.readObject();
                System.out.println("Read success");
                reader.close();
            }
            fi.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
