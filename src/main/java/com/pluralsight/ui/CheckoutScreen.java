package com.pluralsight.ui;
import com.pluralsight.model.Order;
import com.pluralsight.model.Chips;
import com.pluralsight.model.Drink;
import com.pluralsight.model.Sandwich;
import com.pluralsight.model.Topping;
import com.pluralsight.data.ReceiptFileManager;

public class CheckoutScreen {
    public void displayCheckoutScreen(Order currentOrder) {

        System.out.println("=========================");
        System.out.println("        CHECKOUT         ");
        System.out.println("=========================");

        System.out.println("Sandwiches:");
        for (Sandwich sandwich : currentOrder.getSandwiches()) {
            System.out.println("- " + sandwich.getSize() + " inch " + sandwich.getBread());

            for (Topping topping : sandwich.getToppings()) {
                if (topping.isExtra()) {
                    System.out.println("   Extra " + topping.getName() + " (" + topping.getCategory() + ")");
                } else {
                    System.out.println("   " + topping.getName() + " (" + topping.getCategory() + ")");
                }
            }

            if (sandwich.isToasted()) {
                System.out.println("   Toasted");
            } else {
                System.out.println("   Not toasted");
            }

            System.out.println("   Price: $" + sandwich.getPrice());
        }

        System.out.println();

        System.out.println("Drinks:");
        for (Drink drink : currentOrder.getDrinks()) {
            System.out.println("- " + drink.getSize() + " " + drink.getFlavor() + " $" + drink.getPrice());
        }

        System.out.println();

        System.out.println("Chips:");
        for (Chips chips : currentOrder.getChips()) {
            System.out.println("- " + chips.getType() + " $" + chips.getPrice());
        }

        System.out.println("-------------------------");
        System.out.println("Total: $" + currentOrder.getTotal());
        System.out.println("=========================");

        ReceiptFileManager receiptFileManager = new ReceiptFileManager();
        receiptFileManager.saveReceipt(currentOrder);
    }
}
