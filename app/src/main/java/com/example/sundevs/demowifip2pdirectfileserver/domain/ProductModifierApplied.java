package com.example.sundevs.demowifip2pdirectfileserver.domain;

import java.util.ArrayList;

/**
 * Created by SunDevs on 15/01/2018.
 */

public class ProductModifierApplied {
    String id;
    String name;
    private ArrayList<ModifierOption> options;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ModifierOption> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<ModifierOption> options) {
        this.options = options;
    }
}
