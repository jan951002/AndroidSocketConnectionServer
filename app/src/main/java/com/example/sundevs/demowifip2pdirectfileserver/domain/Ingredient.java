package com.example.sundevs.demowifip2pdirectfileserver.domain;

/**
 * Created by SunDevs on 15/01/2018.
 */

public class Ingredient {
    private String _id;

    private Double quantity;
    private ProductVariant productVariant;

    private Product product;

    public Ingredient() {
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public ProductVariant getProductVariant() {
        return productVariant;
    }

    public void setProductVariant(ProductVariant productVariant) {
        this.productVariant = productVariant;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
