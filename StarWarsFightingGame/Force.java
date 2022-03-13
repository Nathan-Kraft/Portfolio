package StarWarsFightingGame;
import StarWarsFightingGame.StarWarsCharacter;
import java.lang.Cloneable;


/**
 *
 * @author mhc31
 */
public class Force implements Cloneable
{
     
   //------------------------------------------------------------
  //Properties 
 //--------------------------------------------------------------  
    
protected int forceStrength = 1; // Character strenght with the force
public int getForceStrength(){return forceStrength;}
public void setForceStrength(int forceStrength) 
{this.forceStrength=forceStrength;

if( forceStrength<1)
    { 
        this.forceStrength=1;
    }
else if(forceStrength>100)
{
    this.forceStrength=100;
}

}

public static final boolean lightSide =true;
public static final boolean darkSide =false;
protected boolean forceType;//@param forceType WHat side of the force the character belongs to. (true/false=light/dark)
public boolean getForceType(){return forceType;}
public void setForceType(boolean forceType) {this.forceType=forceType;}

   //------------------------------------------------------------
  //constructors
 //--------------------------------------------------------------  
    /**
     * basic constructor
     */
    
    public Force(){};
    
    /**
     * Full constructor
     * @param forceStrength
     * @param forceType 
     */
    public Force(int forceStrength,boolean forceType) 
    {
        setForceStrength(forceStrength);
        setForceType(forceType);
    }
    
   //------------------------------------------------------------
  //Methods 
 //--------------------------------------------------------------  
    /**
     * Influence Method - decides if the character is strong enough to influence the target.
     * @param character
     * @param target 
     */
    public static void influence(StarWarsCharacter character, String target)
    {
        if(character.getForce().getForceStrength()>=60)
        {
            System.out.println(character + " ensures "+ target + " these aren't droids they're looking for.");
        }
        else
        {
            System.out.println(character + " fails to influence " + target + ".");
        }
    }
    /**
     * Move method - decides whether the character is strong enough to move the target. 
     * @param character
     * @param target 
     */
    public static void move(StarWarsCharacter character, String target)
    {
        if(character.getForce().getForceStrength()>=60)
        {
            System.out.println(character +" flings " + target + " across the room!"); 

        }
        else
        {
            System.out.println(target +" is unmoved by " + character  + "."); 
        }
    }
    
    /**
     * Allows for a clone of the Force class to be created. 
     * @return
     * @throws CloneNotSupportedException 
     */
    @Override 
    public Force clone() throws CloneNotSupportedException 
    {
        return (Force) super.clone();
    }
    
}
