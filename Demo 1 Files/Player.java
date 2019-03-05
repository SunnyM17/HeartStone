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
        this.playerDeck.addCard(new Card("GUARD", 1, 0, 5, 0),5);
    }
    void altHealth(int amount)
    {
        remainingHealth -= amount;
    }

    void altEnergy(int amount)
    {
        remainingEnergy -= amount;
    }

    void altBlock(int amount)
    {
        block -= amount;
    }
    
    public void setBlock(int amount)
    {
        this.block = amount;
    }
    public int getRemainingHealth()
    {
        return remainingHealth;
    }
    
    public void setMaxEnergy(int amount)
    {
        remainingEnergy = amount;
    }
      
    public void setMaxHealth(int amount)
    {
        remainingHealth = amount;
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
        return (playerName + ": "+remainingHealth+"/"+maxHealth+", "+block+" block, "+remainingEnergy+"/"+maxEnergy);
    }
}
