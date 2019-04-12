package utilities;

/**
* <h1>Create An Enemy!</h1>
* The Enemy program creates an object that is able
* to store information on the name, max health,
* remaining health, max energy, remaining energy,
* block value, and card deck for the enemy.
*/
public class Enemy extends Combatant{

   
   //Constructor methods
   /**
    * This method creates an Enemy object to store the enemy name, max
    * health, max energy, block value, and a card deck unique to the enemy.
    * @param name The Enemy's name.
    * @param maxHealth Sets the max health to this value.
    * @param maxEnergy Sets the max energy to this value.
    * @param deck Adds a deck unique to the enemy.
    */
   public Enemy (String name, int maxHealth, int maxEnergy, Deck deck)
   {
     super(name, maxHealth, maxEnergy, deck);
   }
   
   /**
   * This methods creates an exact copy of the enemy object
   * from param toCopy.
   * @param toCopy The enemy info to copy.
   */
   public Enemy(Enemy toCopy)
   {
       super(toCopy);
   }
   
   //Accesor method
   /**
   * A method to obtain the enemy information, such as name, max and
   * remaining health, and current block value.
   * @return String This returns the enemy's current information.
   */
   public String getEnemyInformation()
   {
        return (super.getName() + ": "+super.getRemainingHealth()+"/"+super.getMaxHealth()+", " + "block: "+ super.getBlock());
   }
}
