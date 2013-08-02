package com.stockControl.model;

import com.stockControl.db.Serializer;

import java.io.Serializable;

/**
 * @author GromHoll
 * Item stored on warehouse
 */
public class Item implements Serializable {

    private final long id;

    private ItemType type;
    private String name;
    /** In cents. Can't be negative */
    private long price = 0;

    public Item() {
        this.id = -1;
    }

    public Item(long id, Item source) {
        this.id = id;
        this.type = source.type;
        this.name = source.name;
        this.price = source.price;
    }

    public void setType(ItemType type) {
        this.type = type;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(long price) {
        this.price = (price >= 0) ? price : 0;
    }

    public ItemType getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public long getPrice() {
        return price;
    }
    public long getId() {
        return id;
    }
}
