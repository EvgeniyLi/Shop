package com.project.lyzohubov.productscollection;
import com.project.lyzohubov.commands.*;
import com.project.lyzohubov.services.ProductService;


import java.util.TreeMap;

public class CommandContainer {
    private TreeMap<Integer, Object> map = new TreeMap<>();
    private ProductService productService = new ProductService();

    public CommandContainer() {
        map.put(1, new CommandShowingAllProduct(productService));
        map.put(2, new CommandAddingProducts(productService));
        map.put(3, new CommandBuyingProduct(productService));
        map.put(4, new CommandShowingBasket(productService));
        map.put(5, new CommandShowingLastFiveProduct(productService));
        map.put(6, new CommandShowingPurchaseHistory(productService));
        map.put(7, new CommandShowingPeriodDatesOrder(productService));
        map.put(8, new CommandFindingNearestDateOder(productService));
    }
    public Object getCommand(int key) {
        return map.get(key);
    }
}
