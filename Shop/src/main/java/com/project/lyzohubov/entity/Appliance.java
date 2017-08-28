package com.project.lyzohubov.entity;


import java.math.BigDecimal;

public abstract class Appliance extends Product {
    private int power;
    private int volume;
    private String type;

    /**
     * Creates Appliance with given params
     *
     * @param id      appliance's id
     * @param name    appliance's name
     * @param price   appliance's price
     * @param barCode appliance's barCode
     * @param power   appliance's power
     * @param volume  appliance's volume
     * @param type    appliance's type
     */
    public Appliance(int id, String name, BigDecimal price, int barCode, int power, int volume, String type) {
        super(id, name, price, barCode);
        this.power = power;
        this.volume = volume;
        this.type = type;
    }

    /**
     * Default constructor
     */
    public Appliance() {
    }

    /**
     * Returns power of appliance
     */
    public int getPower() {
        return power;
    }

    /**
     * Setting power of appliance
     */
    public void setPower(int power) {
        this.power = power;
    }

    /**
     * Returns volume of appliance
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Setting volume of appliance
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Returns type of appliance
     */
    public String getType() {
        return type;
    }

    /**
     * Setting type of appliance
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        Appliance that = (Appliance) object;

        return power == that.power;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + power;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "power :" + power + " volume: " + volume + "type: " + type;
    }
}
