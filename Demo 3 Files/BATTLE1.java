import java.util.Random;

public class BATTLE1 {
    boolean victory = false;
    private int noCard = 0;
    private Enemy enemyo;
    private Player playero;
    
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
    private int blockEnemy = 0;
	private int blockPlayer = 0;
    
    
    public BATTLE1(Player player1, Enemy enemy1)
    {
        enemyo = new Enemy(enemy1);
        playero = new Player(player1);
        initializeOngDeckP(player1);
        initializeOngDeckE(enemy1);
        initializeEHand(enemy1);
        initializePHand(player1);
    }
    
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
    
    public Deck initializeEHand(Enemy enemy1)
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
    
    public void refreshOngDeckP()
    {
    	if (ongDeckP.getDeckList().size() < 5)
        {
          for (int i = 0; i < playerDiscard.getDeckList().size(); i++)
          { 
              ongDeckP.addCard((playerDiscard.getCard(i)),1);
              playerDiscard.getDeckList().remove(i);        
          }
        }
    }
    
    public void refreshOngDeckE()
    {
    	if (ongDeckE.getDeckList().size() < 5)
        {
          for (int z = 0; z < enemyDiscard.getDeckList().size(); z++)
          {
              ongDeckE.addCard((enemyDiscard.getCard(z)),1);
              enemyDiscard.getDeckList().remove(z);
          }
        }
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
    
    public boolean playerTurn(int card, Player player, Enemy enemy)
    {

        //If the player selects a card they cannot afford to play
        if (playerHand.getCard(card).getEnergyCost() > player.getRemainingEnergy())
        {
              //i aint doing anything
        }

        //If a card is played, alters all relavant stats
        playerDiscard.addCard(playerHand.getCard(card), 1);
        player.altEnergy(playerHand.getCard(card).getEnergyCost());
        player.altBlock(playerHand.getCard(card).getBlockValue());

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
        playerHand.getDeckList().remove(card);
        
        if(player.getRemainingHealth() > 0 && playerHand.getDeckList().size() > 0 && player.getRemainingEnergy() > 0 && enemy.getRemainingHealth() > 0)
        {
            return true;
        }
        else
        {
	        player.setRemainingEnergy(player.getMaxEnergy());
	        if(enemy.getRemainingHealth() < 0)
	        {
	        	enemy.setHealth(0);
	        }
	        return false;
        }
        
    }
    

    
    public boolean enemyTurn(Player player, Enemy enemy)
    {
        //Current "AI" just randomly selects cards from hand to play
        Random rand = new Random();
        int cardToPlay = rand.nextInt(enemyHand.getDeckList().size());
        //Keeps playing cards while player is not dead
        if (player.getRemainingHealth() > 0)
        {
              while( enemyHand.getCard(cardToPlay).getEnergyCost() > (enemy.getRemainingEnergy()) )
              {
                    //Fail safe: If a card is randomly selected from the enemy's hand 999 times and the enemy still doesn't have enough energy to play the selected card, ends its turn.
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
                    //If the card is played alters all relevant stats by given amounts
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
                    } 
                    else 
                    {
                          //Deals damage to player if enemy played a damage card
                          player.altHealth((enemyHand.getCard(cardToPlay)).getDamageValue());
                    }
                    System.out.println("Enemy played " + getEnemyHand().getCard(getenemyCardIndex()).showCardDescription());
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
      
      if(enemy.getRemainingHealth() > 0 && enemyHand.getDeckList().size() > 0 && enemy.getRemainingEnergy() > 0 && !victory && player.getRemainingHealth() > 0)
      {
    	  return true;
      }
      else
      {
          enemy.setRemainingEnergy(enemy.getMaxEnergy());
          if(player.getRemainingHealth() < 0)
          {
        	  player.setHealth(0);
          }
          return false;
      }
        
      
      
  }

    public void setBlockPlayer(int amount)
    {
    	blockPlayer = amount;
    }
    
    public void setBlockEnemy(int amount)
    {
    	blockEnemy = amount;
    }
    
    public int getBlockPlayer()
    {
    	return blockPlayer;
    }
    
    public int getBlockEnemy()
    {
    	return blockEnemy;
    }
    
    public Player getPlayer()
    {
    	return playero;
    }
    
    public Enemy getEnemy()
    {
    	return enemyo;
    }
    
    public Deck getPlayerHand()
    {
    	return playerHand;
    }
    
    public Deck getEnemyHand()
    {
    	return enemyHand;
    }
    
    public int getenemyCardIndex()
    {
        return indexEnemyHand;
    }
    
}
