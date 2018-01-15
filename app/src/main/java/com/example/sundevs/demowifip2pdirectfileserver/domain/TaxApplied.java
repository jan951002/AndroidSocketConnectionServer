package com.example.sundevs.demowifip2pdirectfileserver.domain;

/**
 * Created by SunDevs on 15/01/2018.
 */

public class TaxApplied {
    private String _id;
    private String name;
    private Double value;
    private boolean isPercentage;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public boolean isPercentage() {
        return isPercentage;
    }

    public void setPercentage(boolean percentage) {
        isPercentage = percentage;
    }
}
