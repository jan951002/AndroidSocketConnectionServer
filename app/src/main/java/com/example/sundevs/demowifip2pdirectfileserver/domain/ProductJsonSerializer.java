package com.example.sundevs.demowifip2pdirectfileserver.domain;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * Created by SunDevs on 15/01/2018.
 */

public class ProductJsonSerializer implements JsonSerializer<Product> {
    @Override
    public JsonElement serialize(Product src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = (JsonObject) new GsonBuilder().create().toJsonTree(src);
        jsonObject.remove("primaryCategory");
        jsonObject.remove("modifiers");
        if (src.getPrimaryCategory() != null) {
            jsonObject.addProperty("primaryCategory", src.getPrimaryCategory().getId());
        }
        JsonArray jsonModifiers = new JsonArray();
        if (src.getModifiers() != null) {
            for (ProductModifier modifier : src.getModifiers()) {
                JsonPrimitive jsonModifier = new JsonPrimitive(modifier.getId());
                jsonModifiers.add(jsonModifier);
            }
            jsonObject.add("modifiers", jsonModifiers);
        }

        if (src.getTaxes() != null) {
            JsonArray jsonTaxes = new JsonArray();
            for (Tax tax : src.getTaxes()) {
                JsonPrimitive jsonTax = new JsonPrimitive(tax.getId());
                jsonTaxes.add(jsonTax);
            }
            jsonObject.add("taxes", jsonTaxes);
        }

        return jsonObject;
    }
}
