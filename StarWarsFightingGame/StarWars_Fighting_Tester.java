
package StarWarsFightingGame;
import StarWarsFightingGame.StarWarsCharacter;

/**
 * @author mhc31
 */
public class StarWars_Fighting_Tester {
    
    /**
     * @param args the command line arguments
     * @throws java.lang.CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException, Exception
    {    
      //------------------------------------------------------------
     //constructors 
    //-------------------------------------------------------------- 
     
     StarWarsCharacter lukeSkywalker= new StarWarsCharacter("Luke", "SkyWalker", new Force(97,true), 19, "M", "May the force be with you." );
     StarWarsCharacter asajjVentress = new StarWarsCharacter ("Asajj", "Ventress", new Force (85,false), 30, "F", "I will kill you for my master.");
     StarWarsCharacter barissOffee = new StarWarsCharacter ("Bariss", "Offee", new Force (85,true), 30, "M", "You must tain more.");
     StarWarsCharacter darthVader = new StarWarsCharacter ("Darth", "Vader", new Force (100,false), 40, "M", "I am your Father");
     StarWarsCharacter emperorPalpatine = new StarWarsCharacter ("Emperor", "Palpatine", new Force (97,false), 82, "M", "Do it");
     StarWarsCharacter kyloRen = new StarWarsCharacter ("Kylo", "Ren", new Force (95,false), 20, "M", "I will defeat you.");
     StarWarsCharacter obiWanKenobi = new StarWarsCharacter ("Obi", "Wan Kenobi", new Force (85,true), 57, "M", "These are not the droids your looking for.");
     StarWarsCharacter princessLeia = new StarWarsCharacter ("Princess", "Leia", new Force (75,true), 19, "F", "We will win, no matter what.");
     StarWarsCharacter rey = new StarWarsCharacter ("Rey","", new Force (96,true), 20, "F", "I must save the Force.");
     StarWarsCharacter yoda = new StarWarsCharacter ("Yoda","", new Force (99,true), 896, "M", "Strong with the force. You are not.");
     StarWarsCharacter stormTrooper = new StarWarsCharacter ("Storm", "Trooper", new Force (1,false), 25, "M", "Show me your credentials.");
     
     
      //--------------------------
     //Cloning some Storm Troopers
    //----------------------------
     StarWarsCharacter stormTrooper2 =stormTrooper.clone();
     stormTrooper2.setTauntPhrase("These are not the droids I am looking for.");
     StarWarsCharacter stormTrooper3 =stormTrooper.clone();
     stormTrooper3.setTauntPhrase("Move along.");
     StarWarsCharacter stormTrooper4 =stormTrooper.clone();
     stormTrooper4.setTauntPhrase("Blast them.");
     StarWarsCharacter stormTrooper5 =stormTrooper.clone();
     stormTrooper5.setTauntPhrase("Hold it right there.");
     
      //--------------------------
     //Storm Trooper's Taunts
    //----------------------------
    stormTrooper.taunt();
    System.out.println("");
    stormTrooper3.taunt();
    System.out.println("");
    stormTrooper4.taunt();
    System.out.println("");
    stormTrooper5.taunt();
    System.out.println("");
       
      //--------------------------
     //Fighting insues
    //----------------------------
     StarWarsCharacter.fight(lukeSkywalker, darthVader);
        System.out.println("");
     StarWarsCharacter.fight(yoda, asajjVentress);
        System.out.println("");
     StarWarsCharacter.fight(barissOffee, asajjVentress);
        System.out.println("");
     StarWarsCharacter.fight(yoda, lukeSkywalker);
        System.out.println("");
     StarWarsCharacter.fight(barissOffee, obiWanKenobi);
        System.out.println("");
        
      //--------------------------
     //Influence's and move's of the Force Class
    //----------------------------
     Force.influence(stormTrooper, "civilian");
     System.out.println("");
     Force.influence (obiWanKenobi, "Storm Trooper");
     stormTrooper2.taunt();
     System.out.println("");
     Force.move(lukeSkywalker, "X-Wing");
     System.out.println("");
     
    }
    
}