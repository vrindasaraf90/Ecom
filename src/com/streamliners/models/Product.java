package com.streamliners.models;

import jdk.internal.access.JavaIOFileDescriptorAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Product {

    //COMMON..
    public String name;
    public String imageURL;
    public int type;
    public com.streamliners.models.Variant[] variantList;

    // public JavaIOFileDescriptorAccess variantsList;
    //WEIGHT BASED PRODUCT..
    Float minQut;
    public  Float pricePerKg;

    //VARIANT BASED PRODUCT..
    public List<Variant> VariantList;

    //WB..
    public Product(String name, String imageURL, Float minQut, Float pricePerKg) {
        type = ProductType.TYPE_WB;
        this.name = name;
        this.imageURL = imageURL;
        this.minQut = minQut;
        this.pricePerKg = pricePerKg;
    }

    public Product(String name, String imageUrl, List<com.streamliners.models.Variant> variants) {
    }

    public Product(String orange, String s) {

    }

    // public Product(String productName, String imageURL, List<Variants> var) {
    //}

    //VB..
    public void Products(String name, String imageURL, List<Variant> variant) {

        type = ProductType.TYPE_VB;
        this.name = name;
        this.imageURL = imageURL;
        this.VariantList = variant;
    }

    //public Product(String productName, String imageURL, List<com.company.Assignment4_1.Model.Variant> var) {
    //}

    //public Product(String productName, String imageURL, List<com.company.Assignment4_1.Model.Variant> var) {
    //}

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        if (type == ProductType.TYPE_WB)
            builder.append("WeightBased { ");
        else
            builder.append("VariantBased { ");

        builder.append("name = ").append(name);

        if (type == ProductType.TYPE_VB) {
            builder.append("minQty = ").append(minQut);
            builder.append("pricePerKg = ").append(pricePerKg);
        } else {
            builder.append("VariantBased { ");
            builder.append(",variant = ").append(VariantList);
        }
        builder.append(" } ");

        return builder.toString();


    }
}


