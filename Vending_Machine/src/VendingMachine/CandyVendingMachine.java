package VendingMachine;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Locale;

/**
 *
 * @author mhc31
 */
public class CandyVendingMachine implements ICandyVendingMachine {

    /**
     * Fields
     */
    Queue myqueue = new LinkedList();
    Scanner userinput = new Scanner(System.in);
    HashMap<String, Queue<Candy>> vendingMachine = new HashMap<>();

    String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H"};

    private double money;

    public double getMoney() {
        return money;
    }

    public void setMoney(double moneyParam) {
        this.money = moneyParam;
    }
    /**
     * https://howtodoinjava.com/java/date-time/location-based-currency-formatting-in-java/#:~:text=Classes%20used%20in%20Currency%20Formatting%201%20java.util.Locale%20%3A,format%20and%20parse%20numbers%20for%20any%20locale.%20
     */
//Get current locale information
    Locale currentLocale = Locale.getDefault();

//Get currency instance from locale; This will have all currency related information
    Currency currentCurrency = Currency.getInstance(currentLocale);

//Currency Formatter specific to locale
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);

    /**
     * Constructors John helped with making the Hash map formating. This is the
     * Full constructor
     *
     * @param candies
     * @param counts
     */
    public CandyVendingMachine(Candy[] candies, int[] counts) {
        for (int i = 0; i < candies.length; i++) {
            String key = letters[i].toUpperCase();
            vendingMachine.putIfAbsent(key, new LinkedList());
            for (int c = counts[i]; c > 0; c--) {
                vendingMachine.get(key).add(candies[i]);
            }
        }
    }

    /**
     * Tutor helped with setting up the interaction methods, more so guided me
     * through it. Gives the user the options of what they can buy and then
     * helps them into the handleUserPurchase method. If user inputs invalid
     * input then the method will tell them so and allow them to correct.
     */
    public void handleUserInteraction() {
        while (true) {
            System.out.println(GetMachineInfo());
            System.out.println(DisplayContents());
            System.out.println("What candy would you like to purchase? Or enter Q to quit. ");
            Scanner myScanner = new Scanner(System.in);
            String input = myScanner.nextLine().toUpperCase();
            //Tutor helped with testing if the input contains a string
            if (vendingMachine.keySet().contains(input) && vendingMachine.get(input).size() > 0) {
                handleUserPurchase(input);
            } else if (input.equals("Q")) {
                break;
            } else {
                System.out.println("invlid input try again.");
            }
        }

    }

    /**
     * HandleUserPurchse Method Tutor helped with starting and formating some
     * errors made. Once the user chooses their candy then they go into this
     * method. They are instructed how much is needed for the candy they chose,
     * how much they have already paid, and how much is remaining. If user
     * inputs invalid input then the method will tell them so and allow them to
     * correct.
     *
     * @param key
     */
    public void handleUserPurchase(String key) {
        double balence = 0;
        double moneyNeeded = vendingMachine.get(key).peek().getprice();
        Scanner myScanner = new Scanner(System.in);

        while (true) {

            System.out.println("Enter Q, to quit and return balence, or enter amount of money needed to pay. " + currencyFormatter.format((moneyNeeded - balence))
                    + " amount alredy paid " + currencyFormatter.format(balence) + ".");
            System.out.println("You are trying to purchase "
                    + vendingMachine.get(key).peek().getName() + " for " + currencyFormatter.format(moneyNeeded) + ".");

            String input = myScanner.nextLine().toUpperCase();
            if (input.equals("Q")) {    //if the user decides to quit then this executes. 
                System.out.println("Returning " + currencyFormatter.format(balence) + ".");
                break;
            } else {    //if user inputs a value then this branch executes.
                double moneyIn = 0;
                try {   //converting string vlue into a double.
                    moneyIn = Double.parseDouble(input);
                    if (moneyIn >= 100) { //executes if value is higher than 100. Machine can't accept that amount. 
                        System.out.println("Invalid Input, Too much money vending mchine cannot hold amount of money.");
                        break;
                    } else if (moneyIn < 0) {
                        System.out.println("Input invalid. cannot accept negative values");
                         moneyIn=0;
                    }
                    balence = moneyIn + balence;

                } catch (NumberFormatException e) {
                    System.out.println("Input invlid press Q to quit and return balence or press the any key to continue.");
                    input = myScanner.nextLine();
                    if (input.equals("Q")) {    //if user decides to quit then this executes and returns what they have entered. 
                        System.out.println("Returning " + currencyFormatter.format(balence) + ".");
                        break;
                    }

                }

                if (balence >= moneyNeeded) {   //if they enter the right amount of money or greater, then this will execute. 
                    System.out.println("You purchased " + vendingMachine.get(key).peek().getName() + " for " + currencyFormatter.format(moneyNeeded) + ".");
                    double change = balence - moneyNeeded;
                    if (change > 0) {
                        System.out.println("Returning " + currencyFormatter.format(change) + ".");

                    }
                    VendItem(key);
                    break;

                } else {    //if they don't put enough money in the this will execute and send them back to the begining of the purchase method loop, with balence updated. 
                    System.out.println("Money insufficient");
                }

            }

        }

    }

    /**
     * TakeMoney I didn't want to use this method, as it is done properly
     * through my purchase method, and I would have to do a lot of refactoring
     * to implement it.
     *
     * @param amount
     */
    @Override
    public void TakeMoney(double amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    /**
     * ReturnMoney I didn't want to use this method, as it is done properly
     * through my purchase method, and I would have to do a lot of refactoring
     * to implement it.
     *
     * @param amount
     */
    @Override
    public void ReturnMoney(double amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    /**
     * VendItem Method This method dispenses the item to the user, and removes
     * it from the cueue.
     *
     * @param slotCode
     * @return
     */
    @Override
    public Object VendItem(String slotCode) {
        return vendingMachine.get(slotCode).remove();

    }

    /**
     * GetMchineInfo Shows you what type of Vending Machine this is and what
     * Class of items are in it.
     *
     * @return
     */
    @Override
    public String GetMachineInfo() {
        String y = ("This is a Candy Vending machine." + "\n" + "You are able to choose candy you would like to purchase and then have the machine vend the item.");
        return y;

    }

    /**
     * DisplayContents Displays to the user the contents of the Vending Machine.
     *
     * @return
     */
    @Override
    public String DisplayContents() {
        String x = ("You have chosen a candy machine. Here are your options\n");
        for (String key : vendingMachine.keySet()) {
            vendingMachine.get(key).size();
            if (vendingMachine.get(key).size() > 0) {
                x += key + ": ";
                vendingMachine.get(key).peek().getName();
                x += " " + vendingMachine.get(key).peek().getName() + " ";
                vendingMachine.get(key).size();
                x += " " + vendingMachine.get(key).size() + " ";
                vendingMachine.get(key).peek().getprice();
                x += " " + currencyFormatter.format(vendingMachine.get(key).peek().getprice()) + " ";
                x += "\n";
            }
        }

        return x;

    }

}
