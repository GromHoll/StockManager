package com.stockControl.db;

import com.stockControl.model.Item;

import java.io.*;
import java.util.Map;

/**
 * @author GromHoll
 * Use java defaul serializing for saving database
 */
public class JavaSerializer implements Serializer {

    @Override
    public Map<Long, Item> loadFromFile(String filename) throws DBException {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(filename));
            return (Map<Long, Item>) in.readObject();
        } catch(FileNotFoundException ex) {
            throw new DBException("File " + filename + " not found");
        } catch (IOException ex) {
            throw new DBException("Failed reading database from " + filename);
        } catch (ClassNotFoundException ex) {
            throw new DBException("Database format fail");
        } finally {
            try {
                in.close();
            } catch(IOException ex) { }
        }
    }

    @Override
    public void saveToFile(Map<Long, Item> data, String filename) throws DBException {
        if(data == null) {
            return;
        }
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(data);
        } catch(FileNotFoundException ex) {
            throw new DBException("File " + filename + " not found");
        } catch(IOException ex) {
            throw new DBException("Failed saving database to " + filename);
        } finally {
            try {
                out.close();
            } catch(Exception ex) {}
        }
    }
}
