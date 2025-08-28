/*
in this file we calculate the tax as per its import status , exemption status
*/

package com.salestax.service;

import com.salestax.model.Item;

public class TaxCalculator {
    private static final double BASIC_TAX_RATE = 0.10;
    private static final double IMPORT_DUTY_RATE = 0.05;

    public double calculateTax(Item item) {
        double taxRate = 0.0;

        if (!item.isExempt()) {
            taxRate += BASIC_TAX_RATE;
        }
        if (item.isImported()) {
            taxRate += IMPORT_DUTY_RATE;
        }

        double tax = item.getBasePrice() * taxRate;
        return roundUpToNearestFiveCents(tax);
    }

    private double roundUpToNearestFiveCents(double amount) {
        return Math.ceil(amount * 20.0) / 20.0; // round up to nearest 0.05
    }
}
