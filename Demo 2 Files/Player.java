/**
* <h1>Create Player Status!</h1>
* The Player program creates an object that is able
* to store information on the name, max health,
* remaining health, max energy, remaining energy,
* block value, and card deck for the player.
*/
public class Player {


    //instance variables

    private String playerName;
    private int maxHealth;
    private int maxEnergy;
    private int remainingHealth;
    private int remainingEnergy;
    private int block;
    private Deck playerDeck = new Deck();


    //Constructors

    /**
    * This method creates a Player object to store the max
    * and reamining health, max and remaining energy, block value, and
    * a card deck unique to the player.
    * <p>
    * <b>Note:</b> The max and remaining health is initiated to 80, the
    * max and remaining energy is initiated to 3, block value is
    * initiated to 0, while the player deck is initiated with 5 SLASH
    * and 5 GUARD cards.
    */
    public Player()
    {
        this.maxHealth = 80;
        this.remainingHealth = 80;
        this.maxEnergy = 3;
        this.remainingEnergy = 3;
        this.block = 0;
        playerDeck.addCard(new Card("SLASH", 1, 6, 0),5);
        playerDeck.addCard(new Card("GUARD", 1, 0, 5),5);
    }

    /**
    * This method creates a Player object to store the player name, max
    * and reamining health, max and remaining energy, block value, and
    * a card deck unique to the player.
    * @param playerName The player's name.
    * <p>
    * <b>Note:</b> The max and remaining health is initiated to 80, the
    * max and remaining energy is initiated to 3, block value is
    * initiated to 0, while the player deck is initiated with 5 SLASH
    * and 5 GUARD cards.
    */
    public Player(String playerName)
    {
        this.playerName = playerName;
        this.maxHealth = 80;
        this.remainingHealth = 80;
        this.maxEnergy = 3;
        this.remainingEnergy = 3;
        this.block = 0;
        this.playerDeck.addCard(new Card("SLASH", 1, 6, 0),5);
        this.playerDeck.addCard(new Card("GUARD", 1, 0, 5),4);
    }


    // Setter Methods

    /**
   * Sets a new current block value for the player.
   * @param blockValue A value to update the block value.
   */
    public void setBlock(int blockValue)
    {
        this.block = blockValue;
    }

    /**
   * Sets a new max energy value for the player.
   * @param energyValue A value to update the max energy.
   */
    public void setMaxEnergy(int maxEn)
    {
        this.maxEnergy = maxEn;
    }

    public void setRemainingEnergy(int amount)
    {
        this.remainingEnergy = amount;
    }
    
    /**
   * Sets a new max health value for the player.
   * @param maxHP A value to update the max health.
   */
    public void setMaxHealth(int maxHP)
    {
        this.maxHealth = maxHP;
    }

    /**
   * Sets a new health value for the player.
   * @param maxHP A value to update health.
   */
    public void setHealth(int HP)
    {
        this.remainingHealth = HP;
    }


    //Accesor methods

       /**
      * A method to obtain the player information, such as name, max and
      * remaining health, current block value, as well as max and
      * remaining energy.
      * @return String This returns the player's current information.
      */
       public String getPlayerInformation()
       {
           return (playerName + ": "+getRemainingHealth() +"/"+maxHealth+", " + " block: "+ block + ", " + "ENERGY: " + remainingEnergy + "/"+maxEnergy);
       }

       /**
      * A method to obtain max health value.
      * @return int This returns the player's max health.
      */
       public int getMaxHealth()
       {
           return maxHealth;
       }

       /**
       * A method to obtain max energy value.
       * @return int This returns the player's max energy.
       */
       public int getMaxEnergy()
       {
           return maxEnergy;
       }

       /**
       * A method to obtain remaining health value, if remaining
       * health is zero, returns 0.
       * @return int This returns the player's remaining health.
       */
       public int getRemainingHealth()
       {
             if (remainingHealth > 0)
             {
                 return remainingHealth;
             }
             else
             {
                 return 0;
             }
       }

       /**
       * A method to obtain remaining energy value.
       * @return int This returns the player's remaining energy.
       */
       public int getRemainingEnergy()
       {
           return remainingEnergy;
       }

       /**
       * A method to obtain remaining block value.
       * @return int This returns the player's remaining block.
       */
       public int getBlock()
       {
           return block;
       }

       /**
      * A method to obtain the player's card deck.
      * @return Deck This returns the player's deck.
      */
       public Deck getDeck()
       {
           return playerDeck;
       }


       //Mutator Methods

       /**
       * Sets a new remaining health value for the player.
       * @param amount A value to update remaining health.
       */
       public void altHealth(int amount)
       {
             if (amount > block)
            {
                 remainingHealth -= (amount - block);
                 block = 0;
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
       * Sets a new remaining energy value for the player.
       * @param amount A value to update remaining energy.
       */
       public void altEnergy(int amount)
       {
            remainingEnergy -= amount;
       }

       /**
       * Sets a new remaining block value for the player.
       * @param amount A value to update remaining block.
       */
       public void altBlock(int amount)
       {
            block += amount;
       }
}
