package com.streamliners.models;

public class Variant {
    float price = 0F ;
    public static String name;

    public Variant(String name, float price){
        this.name = name;
        this.price = price;
    }


    @Override
    public  String toString(){
        return "Variant{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
