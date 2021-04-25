package com.streamliners.models;

import java.util.ArrayList;
import java.util.List;
public class Product {

    //COMMON..
    public String name;
    public String imageURL;
    public int type;

    //WEIGHT BASED PRODUCT..
    public Float minQty;
    public  Float pricePerKg = 0F;

    //VARIANT BASED PRODUCT..
    public List<Variant> VariantList = new ArrayList<>();

    //WB..
    public Product(String name, String imageURL, Float minQut, Float pricePerKg) {
        type = ProductType.TYPE_WB;
        this.name = name;
        this.imageURL = imageURL;
        this.minQty = minQut;
        this.pricePerKg = pricePerKg;
    }

    //VB..
    public Product(String name, String imageURL, List<Variant> variants) {

        type = ProductType.TYPE_VB;
        this.name = name;
        this.imageURL = imageURL;
        this.VariantList = variants;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        if (type == ProductType.TYPE_WB)
            builder.append("WeightBased { ");
        else
            builder.append("VariantBased { ");

        builder.append("name = ").append(name);

        if (type == ProductType.TYPE_VB) {
            builder.append("minQty = ").append(minQty);
            builder.append("pricePerKg = ").append(pricePerKg);
        } else {
            builder.append("VariantBased { ");
            builder.append(",variant = ").append(VariantList);
        }
        builder.append(" } ");

        return builder.toString();
    }
}


