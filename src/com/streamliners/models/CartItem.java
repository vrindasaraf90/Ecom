package com.streamliners.models;

public class CartItem {

    public  String name;
    public Float UnitPerPrice;
    public Float qty;

    public CartItem(String name, Float unitPerPrice, Float qty) {
        this.name = name;
        this.UnitPerPrice = unitPerPrice;
        this.qty = qty;
    }

    public  Float cost(){
        return UnitPerPrice * qty;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "name='" + name + '\'' +
                String.format("\n,cost= %f X %f = %f",UnitPerPrice,qty,cost())
                +'}';
    }
}