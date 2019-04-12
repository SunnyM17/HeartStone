package users;
import utilities.*;
import java.util.*;

/**
* <h1>Create Combatant Status!</h1>
* The Combatant program creates an object that is able
* to store information on the name, max health,
* remaining health, max energy, remaining energy,
* block value, and card deck for the combatant.
*/
public class Combatant 
{

  private String name;
  private int maxHealth;
  private int maxEnergy;
  private int remainingHealth;
  private int remainingEnergy;
  private int block;
  private Deck deck;

	
  //Constructors

  /**
  * This method creates an empty Combatant object.
  */
  public Combatant() 
  {
  }
  
  /**
  * This method creates a Combatant object to store the name, max
  * and reamining health, max and remaining energy, block value, and
  * a card deck unique to the combatant.
  * @param name The combatant name.
  * @param maxHealth A value the max and remaining health is initiated to.
  * @param maxEnergy A value the max and remaining energy is initiated to.
  * @param deck A deck to be made into the combatant's unique deck.
  * <p>
  * <b>Note:</b> The block value is initiated to 0.
  */
  public Combatant (String name, int maxHealth, int maxEnergy, Deck deck)
  {
    this.name = name;
    setMaxHealth(maxHealth);
    setHealth(maxHealth);
    setMaxEnergy(maxEnergy);
    setRemainingEnergy(maxEnergy);
    this.block = 0;
    setDeck(deck);
  }

  /**
  * This methods creates an exact copy of the combatant object
  * from param toCopy.
  * @param toCopy The combatant info to copy.
  */
  public Combatant(Combatant toCopy)
  {
    this.name = toCopy.name;
    this.maxHealth = toCopy.maxHealth;
    this.remainingHealth = toCopy.maxHealth;
    this.maxEnergy = toCopy.maxEnergy;
    this.remainingEnergy = toCopy.maxEnergy;
    this.block = 0;
    this.deck = toCopy.deck;
  }
  
	
  // Setter Methods

  /**
  * Sets a new current energy value for the combatant.
  * @param amount A value to update the energy value.
  */
  public void setRemainingEnergy(int amount)
  {
       remainingEnergy = amount;
  }
	
  /**
  * Sets a new current block value for the combatant.
  * @param blockValue A value to update the block value.
  */
  public void setBlock(int blockValue)
  {
      this.block = blockValue;
  }

  /**
  * Sets a new max energy value for the combatant.
  * @param maxEn A value to update the max energy.
  */
  public void setMaxEnergy(int maxEn)
  {
     this.maxEnergy = maxEn;
  }

  /**
  * Sets a new max health value for the combatant.
  * @param maxHP A value to update the max health.
  */
  public void setMaxHealth(int maxHP)
  {
     this.maxHealth = maxHP;
  }

  /**
  * Sets a new health value for the combatant.
  * @param HP A value to update health.
  */
  public void setHealth(int HP)
  {
     this.remainingHealth = HP;
  }

  /**
  * Sets a new card deck for the combatant.
  * @param deck A new unique deck for the combatant.
  */
  public void setDeck(Deck deck)
  {
     this.deck = deck;
  }

  /**
  * Sets a new name for the combatant.
  * @param name A new name for the combatant.
  */
  public void setName(String name)
  {
	  this.name = name;
  }
  
	
  //Accesor methods

  /**
  * A method to obtain the combatant name.
  * @return String This returns the combatant's name.
  */
  public String getName()
  {
      return name;
  }

  /**
  * A method to obtain remaining health value.
  * @return int This returns the combatant's remaining health.
  */
  public int getRemainingHealth()
  {
     return remainingHealth;
  }

  /**
  * A method to obtain remaining energy value.
  * @return int This returns the combatant's remaining energy.
  */
  public int getRemainingEnergy()
  {
     return remainingEnergy;
  }

  /**
  * A method to obtain max health value.
  * @return int This returns the combatant's max health.
  */
  public int getMaxHealth()
  {
        return maxHealth;
  }

  /**
  * A method to obtain max energy value.
  * @return int This returns the combatant's max energy.
  */
  public int getMaxEnergy()
  {
     return maxEnergy;
  }

  /**
  * A method to obtain remaining block value.
  * @return int This returns the combatant's remaining block.
  */
  public int getBlock()
  {
       return block;
  }

  /**
  * A method to obtain the combatant's card deck.
  * @return Deck This returns the combatant's deck.
  */
  public Deck getDeck()
  {
        return deck;
  }


  //Mutator Methods

  /**
  * Sets a new remaining health value for the combatant.
  * @param amount A value to update remaining health.
  */
  public void altHealth(int amount)
  {
      if (amount > block)
      {
           remainingHealth -= (amount - block);
           block = 0;
      }
      else if (amount < 0)
      {
        remainingHealth -= amount;
      }
      else
      {
          if(block >= amount)
          {
               block -= amount;
          }
      }
  }

  /**
  * Sets a new remaining energy value for the combatant.
  * @param amount A value to update remaining energy.
  */
  public void altEnergy(int amount)
  {
       remainingEnergy -= amount;
  }

  /**
  * Sets a new remaining block value for the combatant.
  * @param amount A value to update remaining block.
  */
  public void altBlock(int amount)
  {
      if ((block + amount) <= 30)
      {
          block += amount;
      } 
      else if ((block + amount) > 30)
      {
          block = 30;
      }
  }
}
