package com.example.sundevs.demowifip2pdirectfileserver.domain;

import java.util.Date;

/**
 * Created by SunDevs on 15/01/2018.
 */

public class Tax {
    private String _id;
    private String name;
    private Double value;
    private String business;
    private boolean isPercentage;
    private Date createdAt;
    private Date updatedAt;
    private String recordStatus;

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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public boolean isPercentage() {
        return isPercentage;
    }

    public void setIsPercentage(boolean percentage) {
        isPercentage = percentage;
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
}
