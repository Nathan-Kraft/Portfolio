package VendingMachine;

/**
 *
 * @author mhc31
 */
public class Candy implements IVendable {

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
     * Name Constructor
     *
     * @param name
     */
    public Candy(String name) {
        setName(name);
    }

    /**
     * Full Constructor
     *
     * @param name
     * @param price
     */
    public Candy(String name, double price) {
        setName(name);
        setPrice(price);
    }

    @Override
    public Candy clone() throws CloneNotSupportedException {
        return (Candy) super.clone();
    }
}
