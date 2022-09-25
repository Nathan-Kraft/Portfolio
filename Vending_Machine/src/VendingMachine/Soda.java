/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine;

/**
 *
 * @author mhc31
 */
public class Soda implements IVendable {

    private String name;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String nameParam) {
        this.name = nameParam;
    }

    private double price = 0;

    @Override
    public double getprice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Constructors
     */
    /**
     * 
     * Name Constructor
     *
     * @param name
     */
    public Soda(String name) {
        setName(name);
    }

    /**
     * Full Constructor
     *
     * @param name
     * @param price
     */
    public Soda(String name, double price) {
        setName(name);
        setPrice(price);
    }

    @Override
    public Soda clone() throws CloneNotSupportedException {
        return (Soda) super.clone();
    }
}
