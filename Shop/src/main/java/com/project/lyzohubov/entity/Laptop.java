package com.project.lyzohubov.entity;


import java.math.BigDecimal;

public class Laptop extends ElectronicDevice {
    private int hdd;

    /**
     * Creates Laptop with given params
     *
     * @param id      laptop's id
     * @param name    laptop's name
     * @param price   laptop's price
     * @param barCode laptop's barCode
     * @param hdd     laptop's hdd
     */

    public Laptop(int id, String name, BigDecimal price, int barCode, int hdd) {
        super(id, name, price, barCode);
        this.hdd = hdd;
    }

    /**
     * Default constructor
     */
    public Laptop() {
    }

    /**
     * Returns hdd of laptop
     */
    public int getHdd() {
        return hdd;
    }

    /**
     * Setting hdd of laptop
     */
    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Laptop laptop = (Laptop) o;

        return hdd == laptop.hdd;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + hdd;
        return result;
    }

    @Override
    public String toString() {
        return "Laptop:  " + super.toString() + " hdd: " + hdd;
    }
}
