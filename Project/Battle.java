

import java.util.Random;
import java.util.Scanner;

public class Battle 
{
    public void battle(Player player, Enemy enemy)
    {
      int noCard = 0;
      int blockTurnP = 0;
      int blockTurnE = 1;
        
      //Ongoing Decks that will be altered as battle goes on
      Deck ongDeckP =  new Deck();
      Deck ongDeckE = new Deck();
      for (int boi = 0; boi < player.getDeck().getDeckList().size(); boi++)
      {
            ongDeckP.addCard(player.getDeck().getCard(boi),1);
      }
      
      for (int boi = 0; boi < enemy.getDeck().getDeckList().size(); boi++)
      {
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
      while ((!victory) && (player.getRemainingHealth() > 0 )) //While the player hasn't lost or won, the battle goes on
      {
        //Step 0: Announce relevant stats for each combatant
        System.out.println(player.getPlayerInformation());
        System.out.println(enemy.getEnemyInformation());
        System.out.println();
        
        //Step 1: Refresh Energy of each combatant
        
        if (blockTurnP == 0)
        {
            player.setBlock(0);
        }
        if (blockTurnE % 2 == 0)
        {
            enemy.setBlock(0);
        }
        
        player.setMaxEnergy(player.getMaxEnergy());
        enemy.setMaxEnergy(enemy.getMaxEnergy());

        //Step 2: Each combatant draws 5 cards from their deck 
        for (int x = 0; x < 6; x++)
        {
          //If any of the decks are empty while attempting to draw, shuffles the discard pile into the deck
          if (ongDeckP.getDeckList().size() < 5)
          {
            for (int i = 0; i < playerDiscard.getDeckList().size(); i++)
            { 
                ongDeckP.addCard((playerDiscard.getCard(i)),1);
                playerDiscard.getDeckList().remove(i);
              
            }
          }
          if (ongDeckE.getDeckList().size() < 10) 
          {
            for (int z = 0; z < enemyDiscard.getDeckList().size(); z++)
            {
                ongDeckE.addCard((enemyDiscard.getCard(z)),1);
                enemyDiscard.getDeckList().remove(z);
            }
          }

          //Randomly selects a cards to draw from decks
          while(playerHand.getDeckList().size() < 5)
          {
            Random rand = new Random();
            int randomDrawP = rand.nextInt(ongDeckP.getDeckList().size());
           
            //Adds said cards to respective combatants' hands
            playerHand.addCard((ongDeckP.getCard(randomDrawP)), 1);
            ongDeckP.getDeckList().remove(randomDrawP);
          }
          while(enemyHand.getDeckList().size() < 5)
          {
            Random rand = new Random();
            int randomDrawE = rand.nextInt(ongDeckE.getDeckList().size());     
            //Adds said cards to respective combatants' hands
            enemyHand.addCard((ongDeckE.getCard(randomDrawE)), 1);
            ongDeckE.getDeckList().remove(randomDrawE);
          }     
        }
        //Step 3: Enemy randomly chooses cards from hand to play, while energy is available
        while(enemy.getRemainingEnergy() > 0 && enemyHand.getDeckList().size() > 0 && enemy.getRemainingEnergy() > 0 && victory == false)//Enemy keeps playing cards while energy and cards remain
        {
            Random rand = new Random();
            int cardToPlay = rand.nextInt(enemyHand.getDeckList().size());
            if (player.getRemainingHealth() > 0)
            {
                while(enemyHand.getCard(cardToPlay).getEnergyCost() > (enemy.getRemainingEnergy()))
                {
                    if(noCard == 999)
                    {
                        //System.out.println("Enemy passed");
                        enemy.setMaxEnergy(0);
                        break;
                    }
                    Random rando = new Random();
                    cardToPlay = rando.nextInt(enemyHand.getDeckList().size());
                    noCard += 1;
                }
                
                if (noCard != 999)
                {
                    System.out.println("Enemy played "+(enemyHand.getCard(cardToPlay).showCardDescription()));
                    enemyDiscard.addCard(enemyHand.getCard(cardToPlay), 1);
                    enemy.altEnergy(enemyHand.getCard(cardToPlay).getEnergyCost());
                    enemy.altBlock(enemyHand.getCard(cardToPlay).getBlockValue());
                    player.altHealth((enemyHand.getCard(cardToPlay)).getDamageValue());
                    enemyHand.getDeckList().remove(enemyHand.getCard(cardToPlay));
                }   
                noCard = 0;
                System.out.println(player.getPlayerInformation());
                System.out.println(enemy.getEnemyInformation());
                System.out.println();
                System.out.println();
                System.out.println();               
            }
            else
            {
                System.out.println("YOU HAVE BEEN SLAIN BY A " + enemy.getName()+ " what a noob");
                victory = true;
                break;
            }
        } 
        blockTurnE += 1;
        blockTurnP = 0;
        System.out.println("------------------------------------------------------------------------------------------------------------");
        
        while(player.getRemainingEnergy() > 0 && playerHand.getDeckList().size() > 0 && player.getRemainingEnergy() > 0 && victory == false)
        {
            System.out.print("you have the following cards in your hands ");
            System.out.println("Make sure to type the card name in all caps as shown or we will pick the first card in the deck. type 'pass' to skip your turn |");
            // shows you your cards.
            for(int i = 0; i < playerHand.getDeckList().size(); i++)
            {
                System.out.print(playerHand.getCard(i).getCardName() + " | ");
            }
            //
            System.out.println();
            Scanner x = new Scanner(System.in);
            String card = x.nextLine();
            if (card.equals("pass"))
            {
                System.out.println("YOU PASSED");
                break;
            }
            
            if (playerHand.getCard(card).getEnergyCost() > player.getRemainingEnergy())
            {
                System.out.println("NOT ENOUGH ENERGY");
                card = x.nextLine();
            }
            System.out.println("YOU played "+(playerHand.getCard(card).showCardDescription()));
            playerDiscard.addCard(playerHand.getCard(card), 1);
            player.altEnergy(playerHand.getCard(card).getEnergyCost());
            player.altBlock(playerHand.getCard(card).getBlockValue()); 
            if (playerHand.getCard(card).getBlockValue() > 0)
            {
                blockTurnP += 1;
            }
            enemy.altHealth((playerHand.getCard(card)).getDamageValue());
            playerHand.getDeckList().remove(playerHand.getCard(card));
            if (enemy.getRemainingHealth() <= 0 )
            {
                enemy.setHealth(0);
                victory = true;
                System.out.println("YOU WIIIIIIN yay");
                break;
            }
            System.out.println(player.getPlayerInformation());
            System.out.println(enemy.getEnemyInformation());
            System.out.println();
            System.out.println();
            System.out.println();        
        }
        System.out.println("------------------------------------------------------------------------------------------------------------");
      }  
    }
}
