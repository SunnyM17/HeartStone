/**
* <h1>Create An Enemy!</h1>
* The Enemy program creates an object that is able
* to store information on the name, max health,
* remaining health, max energy, remaining energy,
* block value, and card deck for the enemy.
*/
public class Enemy {


   //Instance Variables

   private String enemyName;
   private int maxHealth;
   private int maxEnergy;
   private int remainingHealth;
   private int remainingEnergy;
   private int block;
   private Deck enemyDeck;


   //Constructor

   /**
   * This method creates an Enemy object to store the enemy name, max
   * and reamining health, max and remaining energy, block value, and
   * a card deck unique to the enemy.
   * @param enemyName The enemy name.
   * @param maxHealth A value the max and remaining health is initiated to.
   * @param maxEnergy A value the max and remaining energy is initiated to.
   * @param enemyDeck A deck to be made into the enemy's unique deck.
   * <p>
   * <b>Note:</b> The block value is initiated to 0.
   */
   public Enemy (String enemyName, int maxHealth, int maxEnergy, Deck enemyDeck){
     this.enemyName = enemyName;
     this.maxHealth = maxHealth;
     this.remainingHealth = maxHealth;
     this.maxEnergy = maxEnergy;
     this.remainingEnergy = maxEnergy;
     this.block = 0;
     this.enemyDeck = enemyDeck;
   }


   // Setter Methods

   /**
   * Sets a new current block value for the enemy.
   * @param blockValue A value to update the block value.
   */
   public void setRemainingEnergy(int amount)
   {
        remainingEnergy = amount;
   }
   
   public void setBlock(int blockValue)
   {
       this.block = blockValue;
   }

   /**
   * Sets a new max energy value for the enemy.
   * @param energyValue A value to update the max energy.
   */
   public void setMaxEnergy(int maxEn)
   {
      this.maxEnergy = maxEn;
   }

   /**
   * Sets a new max health value for the enemy.
   * @param maxHP A value to update the max health.
   */
   public void setMaxHealth(int maxHP)
   {
      this.maxHealth = maxHP;
   }

   /**
   * Sets a new health value for the enemy.
   * @param healthValue A value to update health.
   */
   public void setHealth(int HP)
   {
      this.remainingHealth = HP;
   }


   //Accesor methods

   /**
   * A method to obtain the enemy information, such as name, max and
   * remaining health, and current block value.
   * @return String This returns the enemy's current information.
   */
   public String getEnemyInformation()
   {
        return (enemyName + ": "+remainingHealth+"/"+maxHealth+", " + "block: "+ block);
   }

   /**
   * A method to obtain the enemy name.
   * @return String This returns the enemy's name.
   */
   public String getName()
   {
       return enemyName;
   }

   /**
   * A method to obtain remaining health value.
   * @return int This returns the enemy's remaining health.
   */
   public int getRemainingHealth()
   {
      return remainingHealth;
   }

   /**
   * A method to obtain remaining energy value.
   * @return int This returns the enemy's remaining energy.
   */
   public int getRemainingEnergy()
   {
      return remainingEnergy;
   }

   /**
   * A method to obtain max health value.
   * @return int This returns the enemy's max health.
   */
   public int getMaxHealth()
   {
         return maxHealth;
   }

   /**
   * A method to obtain max energy value.
   * @return int This returns the enemy's max energy.
   */
   public int getMaxEnergy()
   {
      return maxEnergy;
   }

   /**
   * A method to obtain remaining block value.
   * @return int This returns the enemy's remaining block.
   */
   public int getBlock()
   {
        return block;
   }

   /**
   * A method to obtain the enemy's card deck.
   * @return Deck This returns the enemy's deck.
   */
   public Deck getDeck()
   {
         return enemyDeck;
   }


   //Mutator Methods

   /**
   * Sets a new remaining health value for the enemy.
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
         remainingHealth -= (amount);
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
   * Sets a new remaining energy value for the enemy.
   * @param amount A value to update remaining energy.
   */
   public void altEnergy(int amount)
   {
        remainingEnergy -= amount;
   }

   /**
   * Sets a new remaining block value for the enemy.
   * @param amount A value to update remaining block.
   */
   public void altBlock(int amount)
   {
        block += amount;
   }
}
