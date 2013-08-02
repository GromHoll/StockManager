package com.stockControl.db;

import com.stockControl.model.Item;

import java.util.*;

/**
 * @author GromHoll
 */
public class StockDB {

    private String filename;
    private Serializer serializer = new JavaSerializer();

    private long lastIndex = 0;
    private Map<Long, Item> db = new TreeMap<Long, Item>();

    public StockDB(String filename) {
        this.filename = filename;
    }

    public void load() throws DBException {
        db = serializer.loadFromFile(filename);
        for(long index : db.keySet()) {
            lastIndex = Math.max(lastIndex, index);
        }
    }

    private void save() {
        try {
            serializer.saveToFile(db, filename);
        } catch(DBException ex) {
            System.out.print(ex.getMessage());
        }
    }

    public void add(Item item) throws DBException {
        if(!validate(item)) {
            throw new DBException("Invalid item");
        }
        db.put(lastIndex, new Item(++lastIndex, item));
        save();
    }

    public void drop(long id) {
        db.remove(id);
        save();
    }
    public void drop(StockCriteria criteria) {
        boolean needSave = false;
        for(Item i : db.values()) {
            if(criteria.matches(i)) {
                db.remove(i.getId());
                needSave = true;
            }
        }
        if(needSave) {
            save();
        }
    }

    public void alter(Item item) {
        Item alterItem = db.get(item.getId());
        if(alterItem != null) {
            alterItem.setName(item.getName());
            alterItem.setPrice(item.getPrice());
            alterItem.setType(item.getType());
            save();
        }
    }

    public Item select(long id) {
        return db.get(id);
    }
    public List<Item> select(StockCriteria criteria) {
        LinkedList<Item> list = new LinkedList<Item>();
        for(Item i : db.values()) {
            if(criteria.matches(i)) {
                list.addLast(i);
            }
        }
        return list;
    }

    private boolean validate(Item item) {
        return item.getType() != null &&
               item.getName() != null;
    }
}
