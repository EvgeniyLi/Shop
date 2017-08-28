package com.project.lyzohubov.entity;

import java.math.BigDecimal;

public abstract class Product {
    private String name;
    private BigDecimal price;
    private int id;
    private int barCode;

    /**
     * Creates product with given params
     *
     * @param id      product's id
     * @param name    product's name
     * @param price   product's price
     * @param barCode product's barCode
     */
    public Product(int id, String name, BigDecimal price, int barCode) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.barCode = barCode;
    }

    public Product(String name) {
        this.name = name;
    }

    /**
     * Default constructor
     */
    public Product() {
    }

    /**
     * Returns name of product
     */
    public String getName() {
        return name;
    }

    /**
     * Setting name of product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns price of product
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Setting price of product
     **/
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Returns id of product
     */
    public int getId() {
        return id;
    }

    /**
     * Setting id of product
     **/

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns barCode of product
     */
    public int getBarCode() {
        return barCode;
    }

    /**
     * Setting barCode of product
     **/
    public void setBarCode(int barCode) {
        this.barCode = barCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (barCode != product.barCode) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        return price != null ? price.equals(product.price) : product.price == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + barCode;
        return result;
    }

    @Override
    public String toString() {
        return " id= " +id +", name='" + name + '\'' + ", price=" + price +  ", barCode=" + barCode;
    }
}
