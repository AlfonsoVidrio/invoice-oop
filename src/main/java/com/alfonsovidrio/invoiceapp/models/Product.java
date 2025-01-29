package com.alfonsovidrio.invoiceapp.models;

public class Product {
    private int code;
    private String name;
    private float price;
    private static int lastCode;

    public Product() {
        this.code = ++lastCode;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return code +
                "\t'" + name +
                "\t" + price;
    }
}
