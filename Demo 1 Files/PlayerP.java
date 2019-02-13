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

    startingDeck = new Deck();
    for (int i = 1; i <= 5; x++)
    {
      startingDeck.deck.add(new Card("Slash", 1, 6, 0, 0));
      startingDeck.deck.add(new Card("Guard", 1, 0, 5, 0));
    }
        
    public Player(String PlayerName)
    {
        this.PlayerName = PlayerName;
        this.maxHealth = 80;
        this.remainingHealth = 80;
        this.maxEnergy = 3;
        this.remainingEnergy = 3;
        this.block = 0;
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
}
