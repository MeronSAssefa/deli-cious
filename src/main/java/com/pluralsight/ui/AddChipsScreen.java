package com.pluralsight.ui;

import com.pluralsight.model.Chips;
import com.pluralsight.model.Order;

import java.util.Scanner;

public class AddChipsScreen {
    Scanner scanner = new Scanner(System.in);

    public void addChipsToOrder(Order currentOrder){

        String chipChoice = "";
        String chipType = "";

        boolean validChip = false;

        while (!validChip) {
            System.out.println("What type of chips would you like?");
            System.out.println("1) BBQ");
            System.out.println("2) Sour Cream");
            System.out.println("3) Salt and Vinegar");
            System.out.println("4) Plain");
            System.out.println("5) Jalapeño");
            System.out.print("Choose chips: ");

            chipChoice = scanner.nextLine().strip();

            if (chipChoice.equals("1") || chipChoice.equals("2") ||
                    chipChoice.equals("3") || chipChoice.equals("4") ||
                    chipChoice.equals("5")) {
                validChip = true;
            } else {
                System.out.println("Invalid chips option. Please choose 1, 2, 3, 4, or 5.");
            }
        }

        if (chipChoice.equals("1")) {
            chipType = "BBQ";
        } else if (chipChoice.equals("2")) {
            chipType = "Sour Cream";
        } else if (chipChoice.equals("3")) {
            chipType = "Salt and Vinegar";
        } else if (chipChoice.equals("4")) {
            chipType = "Plain";
        } else if (chipChoice.equals("5")) {
            chipType = "Jalapeño";
        }

        Chips chips = new Chips(chipType);

        currentOrder.addChip(chips);

        System.out.println(chipType + " chips added to your order.");
    }

}
