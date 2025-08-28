package com.salestax;

import com.salestax.model.Item;
import com.salestax.service.ShoppingCart;
import com.salestax.service.TaxCalculator;
import com.salestax.ui.ReceiptPrinter;

import java.util.Scanner;

public class SalesTaxApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaxCalculator calculator = new TaxCalculator();
        ReceiptPrinter printer = new ReceiptPrinter(calculator);

        System.out.println("Enter number of items in the cart:");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        ShoppingCart cart = new ShoppingCart(calculator);

        for (int i = 0; i < n; i++) {
            System.out.println("Enter item (format: name, price, quantity, imported(true/false), exempt(true/false)):");
            String[] parts = sc.nextLine().split(",");

            String name = parts[0].trim();
            double price = Double.parseDouble(parts[1].trim());
            int qty = Integer.parseInt(parts[2].trim());
            boolean imported = Boolean.parseBoolean(parts[3].trim());
            boolean exempt = Boolean.parseBoolean(parts[4].trim());

            cart.addItem(new Item(name, price, qty, imported, exempt));
        }

        System.out.println("\n===== Receipt =====");
        printer.printReceipt(cart);
    }
}
