package com.project.lyzohubov.commands;

import com.project.lyzohubov.constants.CommandConstant;
import com.project.lyzohubov.services.ProductService;
import com.project.lyzohubov.services.RegexShop;
import com.project.lyzohubov.interfaces.ICommand;

import java.util.Scanner;

public class CommandAddingProducts implements ICommand {
    private ProductService productService;
    private Scanner sc = new Scanner(System.in);
    private RegexShop regexShop = new RegexShop();
    private String idName;
    private int quantity = 0;
    private boolean isNumber;

    @Override
    public void execute() {
        System.out.println(CommandConstant.CHOOSE_THE_PRODUCT);
        idName = sc.next();
        while (!regexShop.checkInputCommand(idName)) {
            System.err.println(CommandConstant.INVALID_INPUT_PRODUCT);
            System.out.println(CommandConstant.CHOOSE_THE_PRODUCT);
            idName = sc.next();
        }
        do {
            System.out.println(CommandConstant.ADD_QUANTITY);
            if (sc.hasNextInt()) {
                quantity = sc.nextInt();
                isNumber = true;
            } else {
                System.err.println(CommandConstant.INVALID_INPUT);
                isNumber = false;
                sc.next();
            }
        } while (!isNumber);

        productService.addProductToBasket(idName, quantity);

    }

    public CommandAddingProducts(ProductService productService) {
        this.productService = productService;
    }
}
