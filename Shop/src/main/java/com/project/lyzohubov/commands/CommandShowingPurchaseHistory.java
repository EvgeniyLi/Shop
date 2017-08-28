package com.project.lyzohubov.commands;


import com.project.lyzohubov.interfaces.ICommand;
import com.project.lyzohubov.services.ProductService;

public class CommandShowingPurchaseHistory implements ICommand {
    private ProductService productService;
     @Override
    public void execute() {
        productService.showPurchaseProduct();
    }

    public CommandShowingPurchaseHistory(ProductService productService) {
        this.productService = productService;
    }
}
