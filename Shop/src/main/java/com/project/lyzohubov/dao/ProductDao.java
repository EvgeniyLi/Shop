package com.project.lyzohubov.dao;

import com.project.lyzohubov.entity.Laptop;
import com.project.lyzohubov.entity.Repository;
import com.project.lyzohubov.productscollection.ProductsCollection;

public class ProductDao {
    private Repository rep = new Repository();

    public boolean checkExistProduct(String idName) {
        for (Laptop laptop : rep.getProduct()) {
            if (idName.equals(laptop.getName())) {
                return true;
            }
        }
        return false;
    }

    public ProductsCollection<Laptop> getAllProduct() {
        return rep.getProduct();
    }
}
