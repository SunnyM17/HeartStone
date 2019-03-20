import java.util.Random;

public class BATTLE1 {
    boolean victory = false;
    private int noCard = 0;
    private Enemy enemy;
    private Player player;
    public BATTLE1(Player player1, Enemy enemy1)
    {
        enemy = new Enemy(enemy1);
        player = new Player(player1);
        initializeOngDeckP(player1);
        initializeOngDeckE(enemy1);
        initializeEHand(enemy1);
        initializePHand(player1);
    }
    
    private int blockTurnP = 1;
    private int blockTurnE = 1;
    
    //Ongoing Decks that will be altered as battle goes on
    private Deck ongDeckP =  new Deck();
    private Deck ongDeckE = new Deck();
    
    //A deck for each combatant containing the cards in hand to be played during each turn
    private Deck playerHand = new Deck();
    private Deck enemyHand = new Deck();
    
    //A deck for each combatant containing the cards in the discard pile
    private Deck playerDiscard = new Deck();
    private Deck enemyDiscard = new Deck();

    //Integer that stores the index of card played during the turn from ongoing hand.
    private int indexEnemyHand;
    
    public Deck initializePHand(Player player)
    {
        //Randomly selects cards to draw from player deck
        while(playerHand.getDeckList().size() < 5)
        {
              Random rand = new Random();
              int randomDrawP = rand.nextInt(ongDeckP.getDeckList().size());

              //Adds drawn cards into player's hand
              playerHand.addCard((ongDeckP.getCard(randomDrawP)), 1);
              ongDeckP.getDeckList().remove(randomDrawP);
        }
        
        return playerHand;
    }
    
    public Deck initializeEHand(Enemy enemy)
    {
        //Randomly selects cards to draw from player deck
        
        while(enemyHand.getDeckList().size() < 5)
        {
              Random rand = new Random();
              int randomDrawE = rand.nextInt(ongDeckE.getDeckList().size());

              //Adds drawn cards into enemy's hand
              enemyHand.addCard((ongDeckE.getCard(randomDrawE)), 1);
              ongDeckE.getDeckList().remove(randomDrawE);
        }
        
        return enemyHand;
    }
    
    public Deck initializeOngDeckP(Player player)
    {
        //Copies player's starter deck into their ongoing deck
        for (int x = 0; x < player.getDeck().getDeckList().size(); x++)
        {
            ongDeckP.addCard(player.getDeck().getCard(x),1);
        }
        
        return ongDeckP;
    }
    
    public Deck initializeOngDeckE(Enemy enemy)
    {
        //Copies player's starter deck into their ongoing deck
        for (int x = 0; x < enemy.getDeck().getDeckList().size(); x++)
        {
            ongDeckE.addCard(enemy.getDeck().getCard(x),1);
        }
        
        return ongDeckE;
    }
    
    public boolean playerTurn(String card)
    {
        if (blockTurnP % 2 == 0)
        {
            player.setBlock(0);
        }
        

        //If the player selects a card they cannot afford to play
        if (playerHand.getCard(card).getEnergyCost() > player.getRemainingEnergy())
        {
              //i aint doing anything
        }

        //If a card is played, alters all relavant stats
        playerDiscard.addCard(playerHand.getCard(card), 1);
        player.altEnergy(playerHand.getCard(card).getEnergyCost());
        player.altBlock(playerHand.getCard(card).getBlockValue());
        if (playerHand.getCard(card).getBlockValue() > 0)
        {
              blockTurnP += 1;
        }
        if ((playerHand.getCard(card)).getDamageValue() < 0)
        {
              player.altHealth((playerHand.getCard(card)).getDamageValue());
              if (player.getRemainingHealth() > player.getMaxHealth())
              {
                    player.setHealth(player.getMaxHealth());
              }
        } else {
              enemy.altHealth((playerHand.getCard(card)).getDamageValue());
        }
        playerHand.getDeckList().remove(playerHand.getCard(card));

        if(player.getRemainingHealth() > 0 && playerHand.getDeckList().size() > 0 && player.getRemainingEnergy() > 0)
        {
            return false;
        }
        return true;
    }
    
    public boolean enemyTurn()
    {
        //Current "AI" just randomly selects cards from hand to play
        Random rand = new Random();
        int cardToPlay = rand.nextInt(enemyHand.getDeckList().size());
        //Keeps playing cards while player is not dead
        if (player.getRemainingHealth() > 0)
        {
              while(enemyHand.getCard(cardToPlay).getEnergyCost() > (enemy.getRemainingEnergy()))
              {
                    //Failsafe: If a card is randomly selected from the enemy's hand 999 times and the enemy still doesn't have enough energy to play the selected card, ends its turn.
                    if (noCard == 999)
                    {
                          enemy.setRemainingEnergy(0);
                          return false;
                    }
                    Random rando = new Random();
                    cardToPlay = rando.nextInt(enemyHand.getDeckList().size());
                    noCard += 1;
              }
              if (noCard != 999)
              {
                    //If the card is played alters all relavant stats by given amounts
                    indexEnemyHand = cardToPlay;
                    enemyDiscard.addCard(enemyHand.getCard(cardToPlay), 1);
                    enemy.altEnergy(enemyHand.getCard(cardToPlay).getEnergyCost());
                    enemy.altBlock(enemyHand.getCard(cardToPlay).getBlockValue());
                    //Sees if enemy intends to deal damage to player or heal itself
                    if ((enemyHand.getCard(cardToPlay)).getDamageValue() < 0)
                    {
                          //Makes sure the enemy does not overheal when using a healing card
                          enemy.altHealth((enemyHand.getCard(cardToPlay)).getDamageValue());
                          if (enemy.getRemainingHealth() > enemy.getMaxHealth())
                          {
                               enemy.setHealth(enemy.getMaxHealth());
                          }
                    } else {
                          //Deals damage to player if enemy played a damage card
                          player.altHealth((enemyHand.getCard(cardToPlay)).getDamageValue());
                    }
                    enemyHand.getDeckList().remove(enemyHand.getCard(cardToPlay));
              }
              noCard = 0;
        } 
        else
        {
              victory = true;
              return false;
              //player lost
        }
      
      if(enemy.getRemainingHealth() > 0 && enemyHand.getDeckList().size() > 0 && enemy.getRemainingEnergy() > 0 && !victory)
      {
          return true;
      }   
      else
      {
          return false;
      }
        
      
      
  }
    
    public void swichTurn(boolean turnp, boolean turne)
    {
        while(turnp == true && victory == false)
        {
            turnp = enemyTurn();
        }
        
        while(turne == true && victory == false)
        {
            turne = playerTurn("");
        }
        
        blockTurnE += 1;
    }
    public int getenemyCardIndex()
    {
        return indexEnemyHand;
    }
}
