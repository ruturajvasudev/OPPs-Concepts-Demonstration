
/*
this method will provide the reciptof items
*/

package com.salestax.ui;

import com.salestax.service.ShoppingCart;
import com.salestax.model.Item;
import com.salestax.service.TaxCalculator;

public class ReceiptPrinter {
    private TaxCalculator taxCalculator;

    public ReceiptPrinter(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public void printReceipt(ShoppingCart cart) {
        for (Item item : cart.getItems()) {
            double finalPrice = item.getPriceWithTax(taxCalculator);
            System.out.printf("%d %s %s: %.2f%n",
                    item.getQuantity(),
                    item.isImported()?" Imported ":" Non Imported",
                    item.getName(),
                    finalPrice);
        }
        System.out.printf("Sales Taxes: %.2f%n", cart.getTotalTaxes());
        System.out.printf("Total: %.2f%n", cart.getTotalCost());
        System.out.println();
    }
}
