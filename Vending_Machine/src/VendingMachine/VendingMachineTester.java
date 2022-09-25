package VendingMachine;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.HashMap;

/**
 *
 * @author mhc31
 */
public class VendingMachineTester {

    Scanner userinput = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Candy[] candy = new Candy[3];
        candy[0] = new Candy("Skittles", 4.20);
        candy[1] = new Candy("Snickers", 1.42);
        candy[2] = new Candy("M & M's", 42.42);

        Soda[] soda = new Soda[3];
        soda[0] = new Soda("Mtn. Dew", 1.50);
        soda[1] = new Soda("Sprite", 1.50);
        soda[2] = new Soda("Coke", 1.50);

        IVendable[] iVendable = new IVendable[7];

        int[] count = new int[3];
        count[0] = 2;
        count[1] = 5;
        count[2] = 1;
        
        /**
         * Creating the Vending Machines
         */
        CandyVendingMachine myCandyVendingMachine = new CandyVendingMachine(candy, count);
        SodaVendingMachine mySodaVendingMachine = new SodaVendingMachine(soda, count);
        VendingMachine myVendingMachine = new VendingMachine();

        /**
         * Creating the linked List for the queue of IVendables. creating all of
         * the items, including StarWarsCharacters
         * John helped with starting to populate this one, then I finished the rest of the lists. 
         */
        myVendingMachine.getVendingMachine().put("A", new LinkedList());
        myVendingMachine.getVendingMachine().put("B", new LinkedList());
        myVendingMachine.getVendingMachine().put("C", new LinkedList());
        ((LinkedList) myVendingMachine.getVendingMachine().get("A")).add(new Soda("Mtn. Dew", 1.50));
        ((LinkedList) myVendingMachine.getVendingMachine().get("B")).add(new Soda("Coke", 1.50));
        ((LinkedList) myVendingMachine.getVendingMachine().get("C")).add(new Soda("Sprite", 1.50));
        ((LinkedList) myVendingMachine.getVendingMachine().get("B")).add(new Candy("M & M's", 42.42));
        ((LinkedList) myVendingMachine.getVendingMachine().get("A")).add(new Candy("Snickers", 1.42));
        ((LinkedList) myVendingMachine.getVendingMachine().get("C")).add(new Candy("Skittles", 4.20));
        ((LinkedList) myVendingMachine.getVendingMachine().get("A")).add(new StarWarsCharacter("Yoda", " ", 4.20));
        ((LinkedList) myVendingMachine.getVendingMachine().get("C")).add(new StarWarsCharacter("Luke", " SkyWalker ", 5.00));
        ((LinkedList) myVendingMachine.getVendingMachine().get("B")).add(new StarWarsCharacter("Darth", " Vader ", 42.20));
       

        /**
         * The loop that runs the entire Machine and allows it not to fail if
         * someone inputs invalid value. If user inputs invalid input then the
         * method will tell them so and allow them to correct. It is also set up
         * to quit out of the hndleUserInteraction method and end the program if
         * there is "Q" entered.
         */
        while (true) {
            System.out.println("Press A to use Candy Vending Machine");
            System.out.println("Press B for Soda Vending Machine");
            System.out.println("Press C for General Vending Machine");
            System.out.println("or Q to quit.");

            Scanner myScanner = new Scanner(System.in);
            String input = myScanner.nextLine().toUpperCase();
            if (input.equals("Q")) {
                return;
            } else if (input.equals("A")) {
                myCandyVendingMachine.handleUserInteraction();
                return;
            } else if (input.equals("B")) {
                mySodaVendingMachine.handleUserInteraction();
                return;
            } else if (input.equals("C")) {
                myVendingMachine.handleUserInteraction();
                return;
            } else {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("Input invlid press Q to quit and return balence or press the A key to continue.");

                }

            }
        }
    }
}
