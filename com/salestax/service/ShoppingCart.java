package com.salestax.service;

import com.salestax.model.Item;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> items = new ArrayList<>();
    private TaxCalculator taxCalculator;

    public ShoppingCart(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotalTaxes() {
        double totalTax = 0.0;
        for (Item item : items) {
            totalTax += taxCalculator.calculateTax(item) * item.getQuantity();
        }
        return totalTax;
    }

    public double getTotalCost() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPriceWithTax(taxCalculator);
        }
        return total;
    }
}
