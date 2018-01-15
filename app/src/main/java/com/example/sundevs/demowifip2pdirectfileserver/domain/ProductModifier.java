package com.example.sundevs.demowifip2pdirectfileserver.domain;

import java.util.ArrayList;

/**
 * Created by SunDevs on 15/01/2018.
 */

public class ProductModifier {
    private String _id;
    private String name;
    private String business;
    private ArrayList<ModifierOption> options;
    private String recordStatus;

    public ProductModifier() {
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public ArrayList<ModifierOption> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<ModifierOption> options) {
        this.options = options;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getOptionsSummary() {
        String summary = "";
        for (ModifierOption op : options) {
            summary += op.getName() + ", ";
        }
        return summary;
    }
}
