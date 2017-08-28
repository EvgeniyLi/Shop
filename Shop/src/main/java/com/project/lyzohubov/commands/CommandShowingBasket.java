package com.project.lyzohubov.commands;

import com.project.lyzohubov.interfaces.ICommand;
import com.project.lyzohubov.services.ProductService;


public class CommandShowingBasket implements ICommand {
    private ProductService productService;
    @Override
    public void execute() {
        productService.showBasket();
    }

    public CommandShowingBasket(ProductService productService) {
        this.productService=productService;
    }
}
