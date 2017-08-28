package com.project.lyzohubov.entity;

import java.math.BigDecimal;

public class Fridge extends Appliance {
    private boolean haveEnergyConsumption;
    private int numberCompressors;

    /**
     * Creates Fridge with given params
     *
     * @param id                    fridge's id
     * @param name                  fridge's name
     * @param price                 fridge's price
     * @param barCode               fridge's barCode
     * @param haveEnergyConsumption fridge's numberCompressors
     * @param numberCompressors     fridge's numberCompressors
     */
    public Fridge(int id, String name, BigDecimal price, int barCode, int power, int volume, String type, boolean haveEnergyConsumption, int numberCompressors) {
        super(id, name, price, barCode, power, volume, type);
        this.haveEnergyConsumption = haveEnergyConsumption;
        this.numberCompressors = numberCompressors;
    }

    /**
     * Default constructor
     */
    public Fridge() {
    }

    /**
     * Returns haveEnergyConsumption of fridge
     */
    public boolean isHaveEnergyConsumption() {
        return haveEnergyConsumption;
    }

    /**
     * Setting haveEnergyConsumption of fridge
     */
    public void setHaveEnergyConsumption(boolean haveEnergyConsumption) {
        this.haveEnergyConsumption = haveEnergyConsumption;
    }

    /**
     * Returns numberCompressors of fridge
     */
    public int getNumberCompressors() {
        return numberCompressors;
    }

    /**
     * Setting numberCompressors of fridge
     */
    public void setNumberCompressors(int numberCompressors) {
        this.numberCompressors = numberCompressors;
    }

    @Override
    public String toString() {
        return super.toString() + " numberCompressors: " + numberCompressors + " haveEnergyConsumption: " + haveEnergyConsumption;
    }
}
