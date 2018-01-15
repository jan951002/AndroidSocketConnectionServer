package com.example.sundevs.demowifip2pdirectfileserver.domain;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by SunDevs on 15/01/2018.
 */

public class ProductVariant {
    private String _id;
    private String name;
    private Double price;
    private String sku;
    private boolean isTrackingInventory;
    private boolean isTrackingAlert;
    private boolean isTrackingCost;
    private Double quantity;
    private Double avgCost;
    private String hasA;
    private String unitMeasure;
    private boolean isShowInStore;
    private Double minThreshold;
    private ArrayList<ProductStock> productStocks;
    private ArrayList<Ingredient> ingredients;
    private String recordStatus;
    private Date createdAt;
    private Date updatedAt;
    private final ArrayList<Product> products = null;

    private ProductStock productStock;

    public ProductVariant() {
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

    public String getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(String unitMeasure) {
        this.unitMeasure = unitMeasure;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isTrackingInventory() {
        return isTrackingInventory;
    }

    public void setTrackingInventory(boolean trackingInventory) {
        isTrackingInventory = trackingInventory;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getAvgCost() {
        return avgCost;
    }

    public void setAvgCost(Double avgCost) {
        this.avgCost = avgCost;
    }

    public boolean isShowInStore() {
        return isShowInStore;
    }

    public void setShowInStore(boolean showInStore) {
        isShowInStore = showInStore;
    }

    public boolean isTrackingAlert() {
        return isTrackingAlert;
    }

    public void setTrackingAlert(boolean trackingAlert) {
        isTrackingAlert = trackingAlert;
    }

    public boolean isTrackingCost() {
        return isTrackingCost;
    }

    public void setTrackingCost(boolean trackingCost) {
        isTrackingCost = trackingCost;
    }

    public String getHasA() {
        return hasA;
    }

    public void setHasA(String hasA) {
        this.hasA = hasA;
    }

    public Double getMinThreshold() {
        return minThreshold;
    }

    public void setMinThreshold(Double minThreshold) {
        this.minThreshold = minThreshold;
    }

    public ArrayList<ProductStock> getProductStocks() {
        return productStocks;
    }

    public void setProductStocks(ArrayList<ProductStock> productStocks) {
        this.productStocks = productStocks;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public ProductStock getProductStock() {
        return productStock;
    }

    public void setProductStock(ProductStock productStock) {
        this.productStock = productStock;
    }

    public void setProductQuantity(Double quantity) {
        if (quantity != null) {
            this.quantity = quantity.doubleValue();
        } else {
            this.quantity = null;
        }
    }

    public Integer getProductQuantity() {
        if (quantity == null) {
            return null;
        } else {
            return this.quantity.intValue();
        }
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public boolean hasIngredients() {
        if (this.ingredients == null) {
            return false;
        } else if (ingredients.size() == 0) {
            return false;
        } else {
            return true;
        }
    }
}
