package com.example.sundevs.demowifip2pdirectfileserver.domain;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by SunDevs on 15/01/2018.
 */

public class ModifierOption {
    private String _id;
    private String name;
    private String price;

    private final ArrayList<ProductModifier> productModifier = null;

    public ModifierOption() {
    }

    public ModifierOption(String _id, String name, String price) {
        this._id = _id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return new BigDecimal(price);
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ArrayList<ProductModifier> getProductModifier() {
        return productModifier;
    }
}
