package com.example.sundevs.demowifip2pdirectfileserver.domain;

import java.util.Date;

/**
 * Created by SunDevs on 15/01/2018.
 */

public class SaleOrderPayment {
    private Double amount;
    private String notes;
    private String paymentMethod;
    private Date createdAt;
    private String recordStatus;

    public SaleOrderPayment() {
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }
}
