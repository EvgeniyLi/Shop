package com.project.lyzohubov.commands;

import com.project.lyzohubov.interfaces.ICommand;
import com.project.lyzohubov.services.ProductService;

public class CommandShowingLastFiveProduct implements ICommand {
    private ProductService productService;

    @Override
    public void execute() {
        productService.showLastFiveProducts();
    }

    public CommandShowingLastFiveProduct(ProductService productService) {
        this.productService=productService;
    }
}
