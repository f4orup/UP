package com.example.test2;

import javafx.beans.property.*;

public class Product {

    String ProductName;
    int ProductQuantity;
    double ProductPrice;

    public Product(String productName, int productQuantity, double productPrice) {
        ProductName = productName;
        ProductQuantity = productQuantity;
        ProductPrice = productPrice;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getProductQuantity() {
        return ProductQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        ProductQuantity = productQuantity;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(double productPrice) {
        ProductPrice = productPrice;
    }
}

