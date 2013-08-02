package com.stockControl.db;

import com.stockControl.model.Item;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 * @author GromHoll
 */
public interface Serializer {
    public Map<Long, Item> loadFromFile(String filename) throws DBException;
    public void saveToFile(Map<Long, Item> data, String filename) throws DBException;
}
