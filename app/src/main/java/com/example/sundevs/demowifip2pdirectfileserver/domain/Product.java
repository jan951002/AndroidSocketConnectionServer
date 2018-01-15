package com.example.sundevs.demowifip2pdirectfileserver.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by SunDevs on 15/01/2018.
 */

public class Product {
    private String _id;
    private String masterId;
    private ProductCategory primaryCategory;
    private ProductImage image;
    private String name;
    private String description;
    private ArrayList<ProductModifier> modifiers;
    private ArrayList<ProductVariant> variants;
    private ArrayList<Tax> taxes;
    private Date createdAt;
    private Date updatedAt;
    private String recordStatus;
    private boolean isIngredient;

    public Product() {
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public ProductCategory getPrimaryCategory() {
        return primaryCategory;
    }

    public void setPrimaryCategory(ProductCategory primaryCategory) {
        this.primaryCategory = primaryCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<ProductModifier> getModifiers() {
        return modifiers;
    }

    public void setModifiers(ArrayList<ProductModifier> modifiers) {
        this.modifiers = modifiers;
    }

    public ArrayList<ProductVariant> getVariants() {
        return variants;
    }

    public void setVariants(ArrayList<ProductVariant> variants) {
        this.variants = variants;
    }

    public ArrayList<Tax> getTaxes() {
        return taxes;
    }

    public void setTaxes(ArrayList<Tax> taxes) {
        this.taxes = taxes;
    }

    public ArrayList<TaxApplied> getTaxesApplieds() {
        ArrayList<TaxApplied> taxApplieds = new ArrayList<>();
        for (Tax tax : taxes) {
            TaxApplied taxApplied = new TaxApplied();
            taxApplied.set_id(tax.getId());
            taxApplied.setName(tax.getName());
            taxApplied.setValue(tax.getValue());
            taxApplied.setPercentage(tax.isPercentage());
            taxApplieds.add(taxApplied);
        }
        return taxApplieds;
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

    public boolean isIngredient() {
        return isIngredient;
    }

    public void setIngredient(boolean ingredient) {
        isIngredient = ingredient;
    }

    public ProductImage getImage() {
        return image;
    }

    public void setImage(ProductImage image) {
        this.image = image;
    }

    public boolean hasVariantsWithRecipe() {
        for (ProductVariant variant : this.variants) {
            if (variant.hasIngredients()) {
                return true;
            }
        }

        return false;
    }

    public String serializeToJson() {
        // Serialize this class into a JSON string using GSON
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Product.class, new ProductJsonSerializer()).create();
        return gson.toJson(this);
    }
}
