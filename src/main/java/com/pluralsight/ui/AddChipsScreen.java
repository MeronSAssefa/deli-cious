package com.pluralsight.ui;

import com.pluralsight.model.Chips;
import com.pluralsight.model.Order;

import java.util.Scanner;

public class AddChipsScreen {
    Scanner scanner = new Scanner(System.in);

    public void addChipsToOrder(Order currnetOrder){

        System.out.println("What type of chips would you like?");

        String chipsChoice = scanner.nextLine();

        Chips chips = new Chips(chipsChoice);

        currnetOrder.addChip(chips);

        System.out.println(chipsChoice + " Chips added to your order");
    }

}
