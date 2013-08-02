package com.stockControl.db;

import com.stockControl.model.ItemType;
import com.stockControl.model.Item;

/**
 * @author GromHoll
 */
public class StockCriteria {

    private Long id = null;
    private ItemType type = null;
    private String name = null;

    private Condition priceCondition = null;
    private long price = 0;

    public void setId(long id) {
        this.id = id;
    }
    public void setType(ItemType type) {
        this.type = type;
    }
    public void setName(String name, boolean isStrong) {
        this.name = isStrong ? name : ".*" + name + ".*";
    }
    public void setPrice(long price, Condition condition) {
        this.priceCondition = condition;
        this.price = price;
    }

    public boolean matches(Item item) {
        return isValidId(item.getId()) &&
               isValidType(item.getType()) &&
               isValidPrice(item.getPrice()) &&
               isValidName(item.getName());
    }

    private boolean isValidId(long id) {
        if(this.id != null && this.id != id) {
            return false;
        }
        return true;
    }
    private boolean isValidType(ItemType type) {
        if(this.type != null && (type == null || this.type != type)) {
            return false;
        }
        return true;
    }
    private boolean isValidName(String name) {
        return (name != null) ? name.matches(this.name)
                              : true;
    }
    private boolean isValidPrice(long price) {
        return (priceCondition != null) ? priceCondition.compare(price, this.price)
                                        : true;
    }
}
