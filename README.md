Overview

This project demonstrates Object-Oriented Programming (OOP) concepts in Java by simulating a simple sales tax calculation system. It calculates basic sales tax, import duty, and prints a receipt for purchased items.

Features

Encapsulation: Item class holds item details (name, price, imported, exempted).

Inheritance: Different types of items (exempted, imported, etc.) use common behavior.

Polymorphism: Tax calculation applies different rules depending on item type.

Abstraction: TaxCalculator hides the logic for applying tax rules.

Separation of Concerns:

Item → Represents a product.

TaxCalculator → Handles tax computation.

ReceiptPrinter → Responsible for displaying the final receipt.

MainApp → Runs the program with sample input.

Input

Items are defined in code with their:

Name
Price
Quantity
Whether imported or not
Whether exempted or not

DEMO:
Enter number of items in the cart:
1
Enter item (format: name, price, quantity, imported(true/false), exempt(true/false)):
book,1000,3,fasle,false

===== Receipt =====
3  Non Imported book: 3300.00
Sales Taxes: 300.00
Total: 3300.00
