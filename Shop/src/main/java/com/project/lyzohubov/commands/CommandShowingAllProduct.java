package com.project.lyzohubov.commands;

import com.project.lyzohubov.interfaces.ICommand;
import com.project.lyzohubov.services.ProductService;

public class CommandShowingAllProduct implements ICommand {
    private ProductService productService;

    public CommandShowingAllProduct(ProductService productService) {
        this.productService=productService;
    }

    @Override
    public void execute() {
        productService.showAllProduct();
    }
}
