package com.stockControl.model;

import java.io.Serializable;

/**
 * @author GromHoll
 *
 */
public enum ItemType implements Serializable {
    SHOVEL("Shovel"),
    BUCKET("Bucket"),
    BROOM("Broom");

    private final String name;

    ItemType(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}
