package com.project.lyzohubov.commands;

import com.project.lyzohubov.constants.CommandConstant;
import com.project.lyzohubov.services.ProductService;
import com.project.lyzohubov.interfaces.ICommand;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class CommandFindingNearestDateOder implements ICommand {
    private ProductService productService = new ProductService();
    private Scanner scanner=new Scanner(System.in);

    @Override
    public void execute() {
        DateTimeFormatter parsePattern = DateTimeFormatter.ofPattern(CommandConstant.YYYY_MM_DD_HH_MM);

        System.out.println(CommandConstant.ENTER_THE_FIRST_BORDER);
        String inputDate = scanner.nextLine();

        LocalDateTime dateTime = null;


        try {
            dateTime = LocalDateTime.parse(inputDate, parsePattern);
        } catch (DateTimeParseException ex) {
            ex.getMessage();
        }

        productService.showCurrentDate(dateTime);

    }

    public CommandFindingNearestDateOder(ProductService productService) {
        this.productService = productService;

    }
}
