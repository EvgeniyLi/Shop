package com.project.lyzohubov;

import com.project.lyzohubov.constants.CommandConstant;
import com.project.lyzohubov.productscollection.CommandContainer;
import com.project.lyzohubov.services.RegexShop;
import com.project.lyzohubov.interfaces.ICommand;

import java.util.Scanner;

public class Main {
    private static int chooseCommand = 0;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        CommandContainer commandContainer = new CommandContainer();
        RegexShop regexShop = new RegexShop();
        while (true) {
            System.out.println("Menu command:");
            System.out.println(CommandConstant.HOW_TO_EXIT + "\n" + CommandConstant.SHOW_AVAILABLE_PRODUCT + "\n" + CommandConstant.ADD_PRODUCT_IN_BASKET +
                    "\n" + CommandConstant.BUY_PRODUCT + "\n" + CommandConstant.SHOW_BASKET + "\n" + CommandConstant.SHOW_FIVE_PURCHASED + "\n" +
                    CommandConstant.SHOW_PURCHASE_HISTORY_PRODUCTS + "\n" + CommandConstant.SHOW_PERIOD_TIME + "\n" + CommandConstant.SHOW_NEAREST_TIME);

            validInputCommand();
            if (regexShop.checkInputCommand(chooseCommand)) {
                ICommand c = (ICommand) commandContainer.getCommand(chooseCommand);
                c.execute();
            } else {
                System.err.println(CommandConstant.INPUT_INVALID);
            }
        }
    }

    private static void validInputCommand() {
        do {
            while (!sc.hasNextInt()) {
                sc.next();
                System.err.println(CommandConstant.INPUT_INVALID);
            }
            chooseCommand = sc.nextInt();

        } while (chooseCommand <= 0);
    }
}







