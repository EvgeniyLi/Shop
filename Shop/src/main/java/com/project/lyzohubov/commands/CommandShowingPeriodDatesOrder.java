package com.project.lyzohubov.commands;

import com.project.lyzohubov.constants.CommandConstant;
import com.project.lyzohubov.services.ProductService;
import com.project.lyzohubov.interfaces.ICommand;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CommandShowingPeriodDatesOrder implements ICommand {
    private ProductService productService;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        DateTimeFormatter parsePattern = DateTimeFormatter.ofPattern(CommandConstant.YYYY_MM_DD_HH_MM);

        System.out.println(CommandConstant.ENTER_THE_FIRST_BORDER);
        String firstBorder = scanner.nextLine();
        System.out.println(CommandConstant.ENTER_THE_SECOND_BORDER);
        String secondBorder = scanner.nextLine();

        LocalDateTime dateTime = null;
        LocalDateTime dateTime2 = null;


        try {
            dateTime = LocalDateTime.parse(firstBorder, parsePattern);
            dateTime2 = LocalDateTime.parse(secondBorder, parsePattern);
        } catch (DateTimeParseException ex) {
            ex.getMessage();
        }


     productService.showPeriodTime(dateTime, dateTime2);
    }

    public CommandShowingPeriodDatesOrder(ProductService productService) {
        this.productService = productService;
    }
}
