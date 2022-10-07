package com.stanrehor.model.save;

import java.io.*;

public class Save<T> implements Serializable{

    public void serialize(T object, String name){
        try{
            FileOutputStream file = new FileOutputStream(name);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(object);
            out.close();
            file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T deserialize(String name){
        T object = null;
        try{
            FileInputStream file = new FileInputStream(name);
            ObjectInputStream in = new ObjectInputStream(file);

            object = (T) in.readObject();

            in.close();
            file.close();

            return object;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
}
