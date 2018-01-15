package com.example.sundevs.demowifip2pdirectfileserver.domain;

import java.math.BigDecimal;
import java.util.Date;

import static android.R.attr.max;

/**
 * Created by SunDevs on 15/01/2018.
 */

public class ProductStock {
    private String _id;
    private Integer quantity;
    private Double avgCost;
    private int status;
    private Date createdAt;
    private Date updatedAt;
    private String recordStatus;

    public ProductStock() {

    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public int getMax() {
        return max;
    }

    public BigDecimal getAvgCost() {
        if (avgCost != null) {
            return new BigDecimal(avgCost);
        } else {
            return null;
        }
    }

    public void setAvgCost(double avgCost) {
        this.avgCost = avgCost;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
