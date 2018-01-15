package com.example.sundevs.demowifip2pdirectfileserver.domain;

import com.google.gson.Gson;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by SunDevs on 15/01/2018.
 */

public class SaleOrder {
    private String localId;
    private String _id;
    private Date createdAt;
    private Date updatedAt;
    private String tag;
    private String notes;
    private ArrayList<SaleOrderLine> saleOrderLines;
    private String business;
    private String customerId;
    private String paymentMethod;
    private Double amountTendered;
    private Double change;
    private String currency;
    private Customer customer;
    private String cashier;
    private String server;
    private String recordStatus;
    private String status;
    private boolean transaction;
    private int attempts;
    private double total;
    private double totalTax;
    private double totalDiscount;
    private double totalGratuity;
    private ArrayList<SaleOrderPayment> payments;
    private ArrayList<SaleOrderRefund> saleOrderRefundsLines;

    public SaleOrder() {
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public ArrayList<SaleOrderLine> getSaleOrderLines() {
        return saleOrderLines;
    }

    public void setSaleOrderLines(ArrayList<SaleOrderLine> saleOrderLines) {
        this.saleOrderLines = saleOrderLines;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String businessId) {
        this.business = businessId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public double getTotalGratuity() {
        return totalGratuity;
    }

    public void setTotalGratuity(double totalGratuity) {
        this.totalGratuity = totalGratuity;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public double getTotal() {
        return total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isTransaction() {
        return transaction;
    }

    public void setTransaction(boolean transaction) {
        this.transaction = transaction;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public Double getAmountTendered() {
        return amountTendered;
    }

    public void setAmountTendered(Double amountTendered) {
        this.amountTendered = amountTendered;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public BigDecimal calculateSubTotal() {
        BigDecimal subTotal = new BigDecimal(0);
        for (SaleOrderLine saleOrderLine : saleOrderLines) {
            subTotal = subTotal.add(saleOrderLine.getSubTotal());
        }
        return subTotal;
    }

    public BigDecimal calculateTotal() {
        BigDecimal total = new BigDecimal(0);
        for (SaleOrderLine saleOrderLine : saleOrderLines) {
            total = total.add(saleOrderLine.getTotal());
        }
        return total;
    }

    public double calculateTotalDiscounts() {
        BigDecimal discounts = new BigDecimal(0);
        for (SaleOrderLine saleOrderLine : saleOrderLines) {
            if (saleOrderLine.getDiscounts() != null) {
                discounts = discounts.add(saleOrderLine.getDiscountsValue());
            }
        }
        return discounts.doubleValue();
    }

    public double calculateTotalTaxes() {
        BigDecimal totalTaxes = BigDecimal.ZERO;
        for (SaleOrderLine saleOrderLine : saleOrderLines) {
            totalTaxes = totalTaxes.add(saleOrderLine.computeTaxesValue());
        }
        return totalTaxes.doubleValue();
    }

    public int getTotalNumberItems() {
        int n = 0;
        for (SaleOrderLine saleOrderLine : saleOrderLines) {
            n = n + saleOrderLine.getQuantity();
        }
        return n;
    }

    public double calculateTotalGratuity() {
        // TODO: 23/10/2017 calculate total gratuity
        return 0;
    }

    public String getSimpleProductsDescription() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < saleOrderLines.size(); i++) {
            SaleOrderLine saleOrderLine = saleOrderLines.get(i);
            ProductVariant productVariant = saleOrderLine.getProductVariant();
            if (productVariant.getProducts().size() > 0) {
//                sb.append('(').append(saleOrderLine.getQuantity()).append(')');
//                sb.append(" ");
                //sb.append(productVariant.getProducts().first().getName());
                if (productVariant.getName() != null && !productVariant.getName().isEmpty()) {
                    sb.append(' ');
                    sb.append(productVariant.getName());
                }
            }
            if (i != saleOrderLines.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public ArrayList<SaleOrderPayment> getPayments() {
        return payments;
    }

    public void setPayments(ArrayList<SaleOrderPayment> payments) {
        this.payments = payments;
    }

    public void addPayments(List<SaleOrderPayment> payments) {
        this.payments.addAll(payments);
    }

    public ArrayList<SaleOrderRefund> getSaleOrderRefundsLines() {
        return saleOrderRefundsLines;
    }

    public void setSaleOrderRefundsLines(ArrayList<SaleOrderRefund> saleOrderRefundsLines) {
        this.saleOrderRefundsLines = saleOrderRefundsLines;
    }

    public static SaleOrder create(String serializedData) {
        Gson gson = new Gson();
        return gson.fromJson(serializedData, SaleOrder.class);
    }

    public String toString() {
        String result = "";
        if (localId != null) {
            result += "Pedido N0 " + localId + "\n";
        }
        if (createdAt != null) {
            DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
            result += "Hora: " + hourFormat.format(createdAt) + "\n";
        }
        if (saleOrderLines != null) {
            for (SaleOrderLine saleOrderLine : saleOrderLines) {
                if (saleOrderLine.getProductVariant() != null) {
                    result += "Producto: " + saleOrderLine.getProductName() +" "+ saleOrderLine.getProductVariant().getName() + "\n";
                }
                result += "Cantidad: " + saleOrderLine.getQuantity() + "\n";

                if(saleOrderLine.getModifiers() != null){
                    for (ProductModifierApplied productModifierApplied : saleOrderLine.getModifiers()) {
                        if(productModifierApplied != null){
                            if(productModifierApplied.getOptions() != null){
                                for (ModifierOption modifierOption : productModifierApplied.getOptions()) {
                                    if(modifierOption.getName() != null){
                                        result += "Adicion: " + modifierOption.getName() + "\n";
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
