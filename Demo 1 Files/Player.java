public class Player
{
    //instance variables
    private String PlayerName;
    private int maxHealth;
    private int maxEnergy;
    private int remainingHealth;
    private int remainingEnergy;
    private int block;
    private Deck playerDeck;

    public Player(String PlayerName)
    {
        this.PlayerName = PlayerName;
        this.maxHealth = 80;
        this.remainingHealth = 80;
        this.maxEnergy = 3;
        this.remainingEnergy = 3;
        this.block = 0;
        Deck startingDeck = new Deck();
        for (int x = 1; x <= 5; x++)
        {
          startingDeck.deck.add(new Card("Slash", 1, 6, 0, 0));
          startingDeck.deck.add(new Card("Guard", 1, 0, 5, 0));
        }
        this.playerDeck = startingDeck;
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

    public String getPlayerInformation() {
      return (playerName + ": "+remainingHealth+"/"+maxHealth+", "+block+"block, "+remainingEnergy+"/"+maxEnergy)
    }
}
