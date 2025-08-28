package com.salestax.model;

import com.salestax.service.TaxCalculator;

public class Item {
    private String name;
    private double price;
    private int quantity;
    private boolean isImported;
    private boolean isExempt;

    public Item(String name, double price, int quantity, boolean isImported, boolean isExempt) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isImported = isImported;
        this.isExempt = isExempt;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isImported() {
        return isImported;
    }

    public boolean isExempt() {
        return isExempt;
    }

    // method to calculate price with tax
    public double getPriceWithTax(TaxCalculator calculator) {
        double tax = calculator.calculateTax(this);
        return (price + tax) * quantity;
    }
}
