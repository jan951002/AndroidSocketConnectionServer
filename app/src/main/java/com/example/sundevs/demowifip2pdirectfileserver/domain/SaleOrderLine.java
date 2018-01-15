package com.example.sundevs.demowifip2pdirectfileserver.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by SunDevs on 15/01/2018.
 */

public class SaleOrderLine {
    private String _id;
    private ProductVariant productVariant;
    private Date createdAt;
    private Date updatedAt;
    private String price;
    private int quantity;
    private String productName;
    private ArrayList<ProductModifierApplied> modifiers;
    private ArrayList<Discount> discounts;
    private ArrayList<TaxApplied> taxes;
    private String notes;

    public SaleOrderLine() {
    }

    public ProductVariant getProductVariant() {
        return productVariant;
    }

    public void setProductVariant(ProductVariant productVariant) {
        this.productVariant = productVariant;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubTotal() {
        return (getPrice().add(getModifiersPrice())).multiply(new BigDecimal(quantity).setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    public BigDecimal getDiscountsValue() {

        BigDecimal basePrice = getPrice().add(getModifiersPrice());
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
        if (getTaxes() != null) {
            ArrayList<TaxApplied> taxes = getTaxes();
            BigDecimal basePrice = new BigDecimal(productVariant.getPrice()).setScale(2, BigDecimal.ROUND_HALF_UP).add(getModifiersPrice());

            for (TaxApplied tax : taxes) {
                if (tax.isPercentage()) {
                    totalTaxes = totalTaxes.add(basePrice.multiply(new BigDecimal(tax.getValue() / 100)).multiply(new BigDecimal(quantity).setScale(2, BigDecimal.ROUND_HALF_UP)));
                } else {
                    totalTaxes = totalTaxes.add(new BigDecimal(tax.getValue()));
                }
            }
        }
        return totalTaxes;
    }

    public BigDecimal getTotal() {

        BigDecimal basePrice = getPrice().add(getModifiersPrice());
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

    public BigDecimal getPrice() {
        return new BigDecimal(price).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ArrayList<ProductModifierApplied> getModifiers() {
        return modifiers;
    }

    public void setModifiers(ArrayList<ProductModifierApplied> modifiers) {
        this.modifiers = modifiers;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ArrayList<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(ArrayList<Discount> discounts) {
        this.discounts = discounts;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public ArrayList<TaxApplied> getTaxes() {
        return taxes;
    }

    public void setTaxes(ArrayList<TaxApplied> taxes) {
        this.taxes = taxes;
    }

    public BigDecimal getModifiersPrice() {
        BigDecimal price = BigDecimal.ZERO;
        if (getModifiers() != null) {
            for (int i = 0; i < getModifiers().size(); i++) {
                for (ModifierOption option : modifiers.get(i).getOptions()) {
                    if (option.getPrice().intValue() > 0) {
                        price = price.add(option.getPrice());
                    }
                }
            }
        }
        return price;
    }

    public String getModifiersReadableStrings() {
        StringBuffer builder = new StringBuffer();
        if (getModifiers() != null) {

            int n = 0;
            for (int i = 0; i < getModifiers().size(); i++) {
                ProductModifierApplied productModifier = getModifiers().get(i);
                n = n + productModifier.getOptions().size();
            }
            int ni = 0;
            for (int i = 0; i < getModifiers().size(); i++) {
                ProductModifierApplied productModifier = getModifiers().get(i);
                for (int j = 0; j < productModifier.getOptions().size(); j++) {
                    ModifierOption option = productModifier.getOptions().get(j);
                    if (option.getPrice().intValue() > 0) {
                        builder.append(option.getName())
                                .append(" $")
                                .append(option.getPrice().toString());
                    } else {
                        builder.append(option.getName());
                    }
                    ni++;
                    if (ni != n) {
                        builder.append(", ");
                    }
                }
            }
        }
        return builder.toString();
    }


    public String getDiscountsReadableStrings() {
        StringBuilder builder = new StringBuilder();
        if (getDiscounts() != null) {
            for (int i = 0; i < discounts.size(); i++) {
                if (i > 0)
                    builder.append("\n");
                builder.append(discounts.get(i).getName())
                        .append(" (");
                if (discounts.get(i).isPercentage()) {
                    builder.append(discounts.get(i).getValue())
                            .append("%)");
                } else {
                    builder.append("$")
                            .append(discounts.get(i).getValue())
                            .append(")");
                }
            }
        }
        return builder.toString();
    }


    public boolean compareSaleOrderLine(SaleOrderLine saleOrderLine) {

        if (productVariant.getId().equals(saleOrderLine.getProductVariant().getId())) {
            if (compareModifiersApplied(saleOrderLine.getModifiers())) {
                if (compareDiscounts(saleOrderLine.getDiscounts())) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean compareModifiersApplied(ArrayList<ProductModifierApplied> modifierApplieds) {

        if (this.modifiers.size() == modifierApplieds.size()) {
            ArrayList<ModifierOption> modifierOptions = new ArrayList<>();
            ArrayList<ModifierOption> compareOptions = new ArrayList<>();

            for (ProductModifierApplied modifierApplied : this.modifiers) {
                modifierOptions.addAll(modifierApplied.getOptions());
            }
            for (ProductModifierApplied modifierApplied : modifierApplieds) {
                compareOptions.addAll(modifierApplied.getOptions());
            }

            if (modifierOptions.size() == compareOptions.size()) {
                for (int i = 0; i < modifierOptions.size(); i++) {
                    for (int j = 0; j < compareOptions.size(); j++) {
                        if (modifierOptions.get(i).getId().equals(compareOptions.get(j).getId())) {
                            compareOptions.remove(j);
                            break;
                        }
                    }
                }
                return compareOptions.isEmpty();
            } else {
                return false;
            }

        } else {
            return false;
        }

    }

    private boolean compareDiscounts(ArrayList<Discount> compareDiscounts) {
        if (compareDiscounts.size() == discounts.size()) {
            List<Discount> copyCompareDiscounts = new ArrayList<>(compareDiscounts);
            for (int i = 0; i < discounts.size(); i++) {
                for (int j = 0; j < copyCompareDiscounts.size(); j++) {
                    if (discounts.get(i).getId().equals(copyCompareDiscounts.get(j).getId())) {
                        copyCompareDiscounts.remove(copyCompareDiscounts.get(j));
                        break;
                    }
                }
            }
            return copyCompareDiscounts.isEmpty();
        } else {
            return false;
        }
    }
}
