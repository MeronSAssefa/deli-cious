package com.pluralsight.data;
import com.pluralsight.model.Chips;
import com.pluralsight.model.Drink;
import com.pluralsight.model.Order;
import com.pluralsight.model.Sandwich;
import com.pluralsight.model.Topping;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class ReceiptFileManager {
    public void saveReceipt(Order currentOrder) {

        try {
            FileWriter writer = new FileWriter("receipts.csv", true);

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String dateTime = now.format(formatter);

            writer.write("Receipt Date," + dateTime + "\n");

            for (Sandwich sandwich : currentOrder.getSandwiches()) {
                writer.write("Sandwich," + sandwich.getSize() + " inch," + sandwich.getBread() + ",$" + sandwich.getPrice() + "\n");

                for (Topping topping : sandwich.getToppings()) {
                    if (topping.isExtra()) {
                        writer.write("Topping,Extra " + topping.getName() + "," + topping.getCategory() + ",$" + topping.getPrice() + "\n");
                    } else {
                        writer.write("Topping," + topping.getName() + "," + topping.getCategory() + ",$" + topping.getPrice() + "\n");
                    }
                }

                if (sandwich.isToasted()) {
                    writer.write("Toasted,Yes\n");
                } else {
                    writer.write("Toasted,No\n");
                }
            }

            for (Drink drink : currentOrder.getDrinks()) {
                writer.write("Drink," + drink.getSize() + "," + drink.getFlavor() + ",$" + drink.getPrice() + "\n");
            }

            for (Chips chips : currentOrder.getChips()) {
                writer.write("Chips," + chips.getType() + ",$" + chips.getPrice() + "\n");
            }

            writer.write("Total,$" + currentOrder.getTotal() + "\n");
            writer.write("-----------------------------\n");

            writer.close();

            System.out.println("Receipt saved to receipts.csv");

        } catch (IOException e) {
            System.out.println("Error saving receipt.");
        }
    }
}
