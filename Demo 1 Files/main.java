import java.util.Scanner;
import java.util.Random;
public class main
{
    public static boolean Battle(Player player, Enemy enemy)
    {
      //Ongoing Decks that will be altered as battle goes on
      Deck ongDeckP =  new Deck();
      Deck ongDeckE = new Deck();
      for (int boi = 0; boi < player.getDeck().getDeckList().size(); boi++)
      {
            ongDeckP.addCard(player.getDeck().getCard(boi),1);
            ongDeckE.addCard(enemy.getDeck().getCard(boi),1);
      }

      //The cards in the hand of each combatant
      Deck playerHand = new Deck();
      Deck enemyHand = new Deck();

      //The cards in the discard piles of each combatant
      Deck playerDiscard = new Deck();
      Deck enemyDiscard = new Deck();

      //The result of the battle relative to the player - returned at the end and is an exit condition in the while loop
      boolean victory = false;
      while ((victory != false) && (player.getRemainingHealth() > 0 )); //While the player hasn't lost or won, the battle goes on

        //Step 0: Announce relevant stats for each combatant
        System.out.println(player.getPlayerInformation());
        System.out.println(enemy.getEnemyInformation());

        //Step 1: Refresh Energy of each combatant
        player.setBlock(0);
        enemy.setBlock(0);
        player.setMaxEnergy(player.getMaxEnergy());
        enemy.setMaxEnergy(enemy.getMaxEnergy());

        //Step 2: Each combatant draws 5 cards from their deck 
        for (int x = 0; x < 6; x++)
        {
          //If any of the decks are empty while attempting to draw, shuffles the discard pile into the deck
          if (ongDeckP.getDeckList().size() == 0)
          {
            for (int i = 0; i < playerDiscard.getDeckList().size(); i++)
            { 
                ongDeckP.addCard((playerDiscard.getCard(i)),1);
                playerDiscard.getDeckList().remove(i);
              
            }
          }
          if (ongDeckE.getDeckList().size() == 0) 
          {
            for (int z = 0; z < enemyDiscard.getDeckList().size(); z++)
            {
                ongDeckE.addCard((enemyDiscard.getCard(z)),1);
                enemyDiscard.getDeckList().remove(z);
            }
          }

          //Randomly selects a cards to draw from decks
          Random rand = new Random();
          int randomDrawP = rand.nextInt(ongDeckP.getDeckList().size());
          int randomDrawE = rand.nextInt(ongDeckE.getDeckList().size());

          //Adds said cards to respective combatants' hands
          playerHand.addCard((ongDeckP.getCard(randomDrawP)), 1);
          ongDeckP.getDeckList().remove(randomDrawP);

          enemyHand.addCard((ongDeckE.getCard(randomDrawE)), 1);
          ongDeckE.getDeckList().remove(randomDrawE);
        }
        //Step 3: Enemy randomly chooses cards from hand to play, while energy is available
         while(enemy.getRemainingEnergy() > 0 && enemyHand.getDeckList().size() > 0)//Enemy keeps playing cards while energy and cards remain
         {
            Random rand = new Random();
            int cardToPlay = rand.nextInt(enemyHand.getDeckList().size());
            if (player.getRemainingHealth() > 0)
            {
                System.out.println("Enemy played "+(enemyHand.getCard(cardToPlay).showCardDescription()));
                player.altHealth((enemyHand.getCard(cardToPlay)).getDamageValue());
                System.out.println(player.getPlayerInformation());  
            }
         }
         return true;
         
    }
    public static void main(String[] args) {
        //DIS IS DE MASTER CARD DECC UWU (has all the cards)
        Deck masterDeck = new Deck();
        masterDeck.addCard(new Card("SLASH", 1, 6, 0, 0),1);
        masterDeck.addCard(new Card("GUARD", 1, 0, 5, 0),1);
        masterDeck.addCard(new Card("CLAW", 1, 3, 3, 0),1);
        masterDeck.addCard(new Card("FIRE BALL", 2, 13, 0, 0),1);
        masterDeck.addCard(new Card("ICE BLOCK", 2, 0, 11, 0),1);
        masterDeck.addCard(new Card("STOMP", 2, 5, 5, 1),1);
        masterDeck.addCard(new Card("CHARGE", 3, 28, 0, 0),1);
        masterDeck.addCard(new Card("THICK HIDE", 0, 0, 4, 0),1);
        
        //Enemy Decks
        Deck GiantRatDeck = new Deck();
        GiantRatDeck.addCard(masterDeck.getCard("SLASH"),3);
        GiantRatDeck.addCard(masterDeck.getCard("GUARD"),3);
        GiantRatDeck.addCard(masterDeck.getCard("CLAW"),3);
        
        Deck MageDeck = new Deck();
        MageDeck.addCard(masterDeck.getCard("SLASH"),3);
        MageDeck.addCard(masterDeck.getCard("GUARD"),5);
        MageDeck.addCard(masterDeck.getCard("FIRE BALL"),4);
        MageDeck.addCard(masterDeck.getCard("ICE BLOCK"),3);
        
        Deck MinotaurDeck = new Deck();
        MinotaurDeck.addCard(masterDeck.getCard("SLASH"),4);
        MinotaurDeck.addCard(masterDeck.getCard("GUARD"),2);
        MinotaurDeck.addCard(masterDeck.getCard("STOMP"),4);
        MinotaurDeck.addCard(masterDeck.getCard("CHARGE"),2);
        MinotaurDeck.addCard(masterDeck.getCard("THICK HIDE"),3);
        
        //birthing the bad bois you will face
        Enemy GiantRat = new Enemy("Giant Rat", 45, 2, GiantRatDeck); 
        Enemy Mage = new Enemy("Mage", 60 , 3, MageDeck);
        Enemy Minotaur = new Enemy("MINOTAUR", 90, 4, MinotaurDeck);
        
        //BIGBOIGame EMBARK!
        System.out.println("Please input your name.");
        Scanner keyboard = new Scanner(System.in);
        String playerName = keyboard.nextLine();

        Player Player1 = new Player(playerName);
        
        boolean dead = false;
        while (Player1.getRemainingHealth() > 0)
        {
            Battle(Player1, Mage); 
        }
    }
}
