package com.example.sundevs.demowifip2pdirectfileserver.domain;

/**
 * Created by SunDevs on 15/01/2018.
 */

public class ProductCategory {
    private String _id;
    private String name;
    private boolean isIngredientCategory;

    public ProductCategory() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public boolean isIngredientCategory() {
        return isIngredientCategory;
    }

    public void setIngredientCategory(boolean ingredientCategory) {
        isIngredientCategory = ingredientCategory;
    }

    @Override
    public String toString() {
        return name;
    }
}
