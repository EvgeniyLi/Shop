package com.project.lyzohubov.commands;

import com.project.lyzohubov.services.ProductService;
import com.project.lyzohubov.interfaces.ICommand;

public class CommandBuyingProduct implements ICommand {
   private ProductService productService;
      @Override
    public void execute() {
        productService.buySelectedProduct();
    }

    public CommandBuyingProduct(ProductService productService) {
        this.productService = productService;
       }
}
