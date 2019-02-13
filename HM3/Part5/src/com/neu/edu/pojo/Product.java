package com.neu.edu.pojo;

public class Product {
    private String productName;
    private double price;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj){
        Product p = (Product) obj;
        if(this.productName.equals(p.getProductName()) && this.price == p.getPrice())
            return true;
        else
            return false;
    }
}
