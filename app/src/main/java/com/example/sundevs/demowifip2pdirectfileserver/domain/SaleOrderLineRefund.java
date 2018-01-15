package com.example.sundevs.demowifip2pdirectfileserver.domain;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by SunDevs on 15/01/2018.
 */

public class SaleOrderLineRefund {
    private String _id;
    private int quantity;
    private Double price;
    private ProductVariant productVariant;
    private ArrayList<ProductModifierApplied> modifiersApplied;
    private ArrayList<Discount> discounts;
    private ArrayList<TaxApplied> taxes;

    public SaleOrderLineRefund() {
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ArrayList<TaxApplied> getTaxes() {
        return taxes;
    }

    public void setTaxes(ArrayList<TaxApplied> taxes) {
        this.taxes = taxes;
    }

    public ProductVariant getProductVariant() {
        return productVariant;
    }

    public void setProductVariant(ProductVariant productVariant) {
        this.productVariant = productVariant;
    }

    public ArrayList<ProductModifierApplied> getModifiersApplied() {
        return modifiersApplied;
    }

    public void setModifiersApplieds(ArrayList<ProductModifierApplied> modifiersApplied) {
        this.modifiersApplied = modifiersApplied;
    }

    public ArrayList<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(ArrayList<Discount> discounts) {
        this.discounts = discounts;
    }

    public BigDecimal getModifiersPrice() {
        BigDecimal price = BigDecimal.ZERO;
        if (getModifiersApplied() != null) {
            for (int i = 0; i < getModifiersApplied().size(); i++) {
                for (ModifierOption option : getModifiersApplied().get(i).getOptions()) {
                    if (option.getPrice().intValue() > 0) {
                        price = price.add(option.getPrice());
                    }
                }
            }
        }
        return price;
    }

    public BigDecimal getDiscountsValue() {

        BigDecimal basePrice = getUnitPrice().add(getModifiersPrice());
        BigDecimal discountPrice = BigDecimal.ZERO;

        for (Discount discount : getDiscounts()) {
            if (discount.isPercentage()) {
                discountPrice = discountPrice.add(basePrice.multiply(new BigDecimal(discount.getValue() / 100)).multiply(new BigDecimal(quantity)));
            } else {
                discountPrice = discountPrice.add(new BigDecimal(discount.getValue()).multiply(new BigDecimal(quantity)));
            }
        }

        return discountPrice;
    }

    public BigDecimal computeTaxesValue() {
        BigDecimal totalTaxes = BigDecimal.ZERO;

        ArrayList<TaxApplied> taxes = getTaxes();
        BigDecimal basePrice = new BigDecimal(getPrice()).setScale(2, BigDecimal.ROUND_HALF_UP).add(getModifiersPrice());

        for (TaxApplied tax : taxes) {
            if (tax.isPercentage()) {
                totalTaxes = totalTaxes.add(basePrice.multiply(new BigDecimal(tax.getValue() / 100)).multiply(new BigDecimal(quantity).setScale(2, BigDecimal.ROUND_HALF_UP)));
            } else {
                totalTaxes = totalTaxes.add(new BigDecimal(tax.getValue()));
            }
        }
        return totalTaxes;
    }

    public BigDecimal getTotal() {

        BigDecimal basePrice = getUnitPrice().add(getModifiersPrice());
        BigDecimal discountPrice = BigDecimal.ZERO;
        BigDecimal totalTaxes = computeTaxesValue();

        for (Discount discount : getDiscounts()) {
            if (discount.isPercentage()) {
                discountPrice = discountPrice.add(basePrice.multiply(new BigDecimal(discount.getValue() / 100)));
            } else {
                discountPrice = discountPrice.add(new BigDecimal(discount.getValue()));
            }
        }

        if (discountPrice.compareTo(basePrice) == 1 || discountPrice.compareTo(basePrice) == 0) {//discount greater or equal than base price
            return BigDecimal.ZERO;
        } else {
            return (basePrice.subtract(discountPrice)).multiply(new BigDecimal(quantity)).setScale(2, BigDecimal.ROUND_HALF_UP).add(totalTaxes);
        }
    }

    private BigDecimal getUnitPrice() {
        return new BigDecimal(price);
    }
}
