package StarWarsFightingGame;
import java.lang.Cloneable;
/**
 *
 * @author mhc31
 */
public class StarWarsCharacter implements Cloneable
{
   //------------------------------------------------------------
  //Properties 
 //--------------------------------------------------------------  
    
    private String firstName="";
    public String getFirstName(){return this.firstName;}
    public void setFirstName(String firstNameParam) {this.firstName=firstNameParam;}
    
    private String lastName="";
    public String getLastName(){return this.lastName;}
    public void setLastName(String lastNameParam) {this.lastName=lastNameParam;}
   
    private String gender=""; //@param gender What gender the character is. (on/off=Male(M)/Female(F)).
    public String getGender(){return gender;}
    public void setGender(String gender) {this.gender=gender;}
    public static final String Male="M";
    public static final String Female="F";
    
    private String tauntPhrase=""; //what is the characters taunt phrase for the end of the battle. 
    public String getTauntPhrase(){return this.tauntPhrase;}
    public void setTauntPhrase(String tauntPhraseParam) {this.tauntPhrase=tauntPhraseParam;}
    
    private int age=0; 
    public int getAge(){return age;}
    public void setAge(int age){this.age=age;}
    
    protected Force force;
    public Force getForce(){return this.force;}
    public void setForce(Force forceparam) {this.force=forceparam;}

   //------------------------------------------------------------
  //Constructors
 //--------------------------------------------------------------  
/**
 * Default Constructor
 */
    public StarWarsCharacter(){}
  /**
   * Name Constructor
   * @param firstName
   * @param lastName 
   */  
    public StarWarsCharacter(String firstName, String lastName)
    {
        setFirstName(firstName);
        setLastName(lastName);
    }
    /**
     * Full Name and Force constructor
     * @param firstName
     * @param lastName
     * @param force 
     */
    public StarWarsCharacter (String firstName, String lastName, Force force)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setForce(force);
    }
     /**
      * Full constructor
      * @param firstName
      * @param lastName
      * @param force
      * @param tauntPhrase what the character will say if they win the fight. 
      */
    public StarWarsCharacter (String firstName, String lastName, Force force, int age, String gender, String tauntPhrase) throws Exception
    {
        setFirstName(firstName);
        setLastName(lastName);
        setForce(force);
        setAge(age);
        setGender(gender);
        setTauntPhrase(tauntPhrase);
         /**
     * Nolan helped me code this part of the code. 
     */   
    if (getForce().getForceStrength()==100 && !firstName.equals("Darth"))
    {
        System.out.println(firstName + " " +lastName +" cannot have a force value of 100!" + "Restart program." + "Only Darth Vader can have a value of 100.");
        throw new Exception("Defies Darth Law");
    }
   
    }
    
   //------------------------------------------------------------
  //Methods
 //--------------------------------------------------------------  
    
    @Override
    public String toString()
    {
        
        return firstName + " " +lastName;
    }
     
    public void taunt() //prints out a characters special taunt phrase.
  {
        
        System.out.println(tauntPhrase);   
  }
    
  /**
   * the fight method
   * decides the victor of each fight, based on their ForceStrength. 
   * it has cases for if they are opposite forceType, they would fight, and if they had equal forceStrenghth, as well as when they are of the same ForceType. 
   * @param character1
   * @param character2 
   */
  public static void fight(StarWarsCharacter character1, StarWarsCharacter character2)
          {
           if(character1.getForce().getForceType()!=character2.getForce().getForceType()) //If the force types of each character are different then go into this branch of code. 
           {
               System.out.println(character1 + " fights " + character2);
               if(character1.getForce().getForceStrength()>character2.getForce().getForceStrength())//If character 1 force strength is larger than character 2, then character 1 wins. 
               {
                   System.out.println("Winner is " + character1);
                   character1.taunt(); 
               }
               else if(character1.getForce().getForceStrength()<character2.getForce().getForceStrength())//If character 2 force strength is larger than character 1, then character 2 wins. 
               {
                   System.out.println("Winner is " + character2);
                   character2.taunt();
               }
               else//if they are the same strength then print phrase saying so. 
               {
                   System.out.println("They are of equal strength with the force and combat ability, the battle ends in a draw.");//clever phrase saying they are of equal strength.
               }
           }
            if(character1.getForce().getForceType()==character2.getForce().getForceType())//If the force types of each character are the same go into this branch of code. 
            {
            
                String side="";
                if(character1.getForce().getForceType()==Force.darkSide)//decides what side to you for later statement. 
                {
                     side = "Dark";
                }
                else
                {
                     side = "Light";
                }
                if(character1.getForce().getForceStrength()>character2.getForce().getForceStrength())//If character 1 force strength is larger than character 2, then character 1 is stronger on that side of the force. 
                {
                    System.out.println(character1 + " fights " + character2);                  
                    System.out.println(character1 + " is stronger in the " + side + "side of the force than " + character2);
                }
                else if(character1.getForce().getForceStrength()<character2.getForce().getForceStrength())//If character 2 force strength is larger than character 1, then character 2 is stronger on that side of the force.. 
                {
                      System.out.println(character1 + " fights " + character2);                  
                    System.out.println(character2 + " is stronger in the " + side + "side of the force than " + character1);
                }
                else// if they have the same strength then print clever phrase. 
                {
                    System.out.println(character1 + " fights " + character2);
                    
                    System.out.println("They are of equal strength with the force. They decide to spar in their minds.");//clever phrase saying they are of equal strength
                }
                
            }
                
           }
           /**
            * allows us to make clones of StarWarsCharacters.
            * @return
            * @throws CloneNotSupportedException 
            */
        @Override
    public StarWarsCharacter clone() throws CloneNotSupportedException  
    {
        return (StarWarsCharacter) super.clone();
    }
    
}

