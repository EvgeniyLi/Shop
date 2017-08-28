package com.project.lyzohubov.entity;

import java.math.BigDecimal;


public abstract class ElectronicDevice extends Product {

    private int volume;
    private String type;

    /**
     * Creates ElectronicDevice with given params
     *
     * @param id      electronicDevice's id
     * @param name    electronicDevice's name
     * @param price   electronicDevice's price
     * @param barCode electronicDevice's barCode
     */

    public ElectronicDevice(int id, String name, BigDecimal price, int barCode) {
        super(id, name, price, barCode);
            }

    /**
     * Default constructor
     */
    public ElectronicDevice() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ElectronicDevice that = (ElectronicDevice) o;

        if (volume != that.volume) return false;
        return type != null ? type.equals(that.type) : that.type == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + volume;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    /**
     * Returns volume of electronicDevice.
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Setting volume of electronicDevice.
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
