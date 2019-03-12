
public class Player
{
    //instance variables
    private String playerName;
    private int maxHealth;
    private int maxEnergy;
    private int remainingHealth;
    private int remainingEnergy;
    private int block;
    private Deck playerDeck = new Deck();

    public Player()
    {
        this.maxHealth = 80;
        this.remainingHealth = 80;
        this.maxEnergy = 3;
        this.remainingEnergy = 3;
        this.block = 0;
        playerDeck.addCard(new Card("SLASH", 1, 6, 0, 0),5);
        playerDeck.addCard(new Card("GUARD", 1, 0, 5, 0),5);
    }
    public Player(String playerName)
    {
        this.playerName = playerName;
        this.maxHealth = 80;
        this.remainingHealth = 80;
        this.maxEnergy = 3;
        this.remainingEnergy = 3;
        this.block = 0;
        this.playerDeck.addCard(new Card("SLASH", 1, 6, 0, 0),5);
        this.playerDeck.addCard(new Card("GUARD", 1, 0, 5, 0),4);
    }
    
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

    public void altEnergy(int amount)
    {
        remainingEnergy -= amount;
    }

    public void altBlock(int amount)
    {
        block += amount;
    }
    
    public int getBlock()
    {
        return block;
    } 
    
    public void setBlock(int amount)
    {
        this.block = amount;
    }
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
    public void setHealth(int x)
    {
        remainingHealth = x;
    }
    
    public void setMaxEnergy(int amount)
    {
        remainingEnergy = amount;
    }
      
    public void setMaxHealth(int amount)
    {
        remainingHealth = amount;
    }
    
    public int getRemainingEnergy()
    {
        return remainingEnergy;
    }
    
    public int getMaxEnergy()
    {
        return maxEnergy;
    }
    
    public int getMaxHealth()
    {
        return maxHealth;
    }   
    
    public Deck getDeck()
    {
        return playerDeck;
    }
    public String getPlayerInformation() {
        return (playerName + ": "+getRemainingHealth() +"/"+maxHealth+", " + " block: "+ block + ", " + "ENERGY: " + remainingEnergy + "/"+maxEnergy);
    }
}
