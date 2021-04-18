package com.streamliners.models;

public class WeightBasedProduct extends Product {
    float minQty;
    float pricePerKg;

    public WeightBasedProduct(String name, String imageURL, float minQty, float pricePerKg) {
        super(name, imageURL);

        this.minQty = minQty;
        this.pricePerKg = pricePerKg;
    }

    @Override
    public  String toString(){
        return "WeightBasedProduct{" +
                "name='" + name + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", minQty=" + minQty + '\'' +
                ", pricePerKg=" + pricePerKg +
                '}';

    }
}
