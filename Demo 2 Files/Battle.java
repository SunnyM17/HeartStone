

import java.util.Random;
import java.util.Scanner;

import javax.sound.sampled.BooleanControl;

public class Battle 
{
    public boolean battle(Player player, Enemy enemy)
    {
      int noCard = 0;
      int blockTurnP = 0;
      int blockTurnE = 1;
      //Ongoing Decks that will be altered as battle goes on
      Deck ongDeckP =  new Deck();
      Deck ongDeckE = new Deck();
      for (int x = 0; x < player.getDeck().getDeckList().size(); x++)
      {
            ongDeckP.addCard(player.getDeck().getCard(x),1);
      }
      
      for (int x = 0; x < enemy.getDeck().getDeckList().size(); x++)
      {
            ongDeckE.addCard(enemy.getDeck().getCard(x),1);
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
        //Announce relevant stats for each combatant
        System.out.println(player.getPlayerInformation());
        System.out.println(enemy.getEnemyInformation());
        System.out.println();
        
        //Refresh Energy of each combatant
        
        if (blockTurnP == 0)
        {
            player.setBlock(0);
        }
        if (blockTurnE % 2 == 0)
        {
            enemy.setBlock(0);
        }
        
        player.setRemainingEnergy(player.getMaxEnergy());
        enemy.setRemainingEnergy(enemy.getMaxEnergy());

        //Each combatant draws 5 cards from their deck 
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
          if (ongDeckE.getDeckList().size() < 5)
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
        //Enemy randomly chooses cards from hand to play, while energy is available
        while(enemy.getRemainingHealth() > 0 && enemyHand.getDeckList().size() > 0 && enemy.getRemainingEnergy() > 0 && !victory)//Enemy keeps playing cards while energy and cards remain
        {
            //Current "AI" just randomly selects cards from hand to play
            Random rand = new Random();
            int cardToPlay = rand.nextInt(enemyHand.getDeckList().size());
            if (player.getRemainingHealth() > 0) //Only keeps playing cards while player is not dead
            {
                while(enemyHand.getCard(cardToPlay).getEnergyCost() > (enemy.getRemainingEnergy()))
                {
                    if(noCard == 999)//Failsafe: If a card is randomly selected from the enemy's hand 999 times and the enemy still doesn't have enough energy to play the selected card, ends its turn.
                    {
                        //System.out.println("Enemy passed");
                        enemy.setRemainingEnergy(0);
                        break;
                    }
                    Random rando = new Random();
                    cardToPlay = rando.nextInt(enemyHand.getDeckList().size());
                    noCard += 1;
                }
                
                if (noCard != 999)
                {   
                    //If the card is played alters all relavant stats by given amounts
                    System.out.println("Enemy played "+(enemyHand.getCard(cardToPlay).showCardDescription()));
                    enemyDiscard.addCard(enemyHand.getCard(cardToPlay), 1);
                    enemy.altEnergy(enemyHand.getCard(cardToPlay).getEnergyCost());
                    enemy.altBlock(enemyHand.getCard(cardToPlay).getBlockValue());
                    if ((enemyHand.getCard(cardToPlay)).getDamageValue() < 0) {
                        enemy.altHealth((enemyHand.getCard(cardToPlay)).getDamageValue());
                        if (enemy.getRemainingHealth() > enemy.getMaxHealth()) {
                            enemy.setHealth(enemy.getMaxHealth());
                        }
                    } else {
                        player.altHealth((enemyHand.getCard(cardToPlay)).getDamageValue());
                    }
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
                System.out.println("You have been slain by " + enemy.getName());
                victory = true;
                break;
            }
        } 
        blockTurnE += 1;
        blockTurnP = 0;
        System.out.println("------------------------------------------------------------------------------------------------------------");

        //Player's turn begins
        while(player.getRemainingHealth() > 0 && playerHand.getDeckList().size() > 0 && player.getRemainingEnergy() > 0 && !victory)
        {
            System.out.print("You have the following cards in your hand: ");
            System.out.println("Enter the name of the card, or it's numerical position in your hand to play it. Type 'pass' to end your turn. |");
            // shows you your cards.
            for(int i = 0; i < playerHand.getDeckList().size(); i++)
            {
                System.out.print(playerHand.getCard(i).getCardName() + " | ");
            }
            System.out.println();
            Scanner x = new Scanner(System.in);
            String card = x.nextLine();
            card = card.toUpperCase();
            
            //If the player enters "pass", they end their turn
            if (card.equals("PASS"))
            {
                System.out.println("You ended your turn.");
                break;
            }
            
            //Plays the card specified by the player
            for(int r = 1; r <= playerHand.getDeckList().size(); r++)
            {
                if(card.equals("" + r))
                {
                    card = playerHand.getCard(r-1).getCardName();
                    break;
                }
            }

            //If the player selects a card they cannot afford to play
            if (playerHand.getCard(card).getEnergyCost() > player.getRemainingEnergy())
            {
                System.out.println("You don't have enough energy to play that!");
                card = x.nextLine();
            }
            //If a card is played, alters all relavant stats
            System.out.println("You played "+(playerHand.getCard(card).showCardDescription()));
            playerDiscard.addCard(playerHand.getCard(card), 1);
            player.altEnergy(playerHand.getCard(card).getEnergyCost());
            player.altBlock(playerHand.getCard(card).getBlockValue()); 
            if (playerHand.getCard(card).getBlockValue() > 0)
            {
                blockTurnP += 1;
            }
            if ((playerHand.getCard(cardToPlay)).getDamageValue() < 0) {
                player.altHealth((playerHand.getCard(cardToPlay)).getDamageValue());
                if (player.getRemainingHealth() > player.getMaxHealth()) {
                    player.setHealth(player.getMaxHealth());
                }
            } else {
                enemy.altHealth((playerHand.getCard(cardToPlay)).getDamageValue());
            }
            playerHand.getDeckList().remove(playerHand.getCard(card));
            
            //If the enemy's health goes to 0 or less, ends the battle and sets victory to true.
            if (enemy.getRemainingHealth() <= 0 )
            {
                enemy.setHealth(0);
                victory = true;
                System.out.println(enemy.getName()+" has been defeated!");
                break;
            }
            //Outputs all relavant stats again at the end
            System.out.println(player.getPlayerInformation());
            System.out.println(enemy.getEnemyInformation());
            System.out.println();
            System.out.println();
            System.out.println();        
        }
        System.out.println("------------------------------------------------------------------------------------------------------------");
      }
    //If you won, after the battle you get to select a card to add to your deck, from 3 random cards from your opponent's deck.
    if (victory == true) {
        Random rand1 = new Random();
        int randomCard1 = rand1.nextInt(enemy.getDeck().getDeckList().size());
        Random rand2 = new Random();
        int randomCard2 = rand2.nextInt(enemy.getDeck().getDeckList().size());
        Random rand3 = new Random();
        int randomCard3 = rand3.nextInt(enemy.getDeck().getDeckList().size());
        
        System.out.println(enemy.getDeckList().getCard(randomCard1).showCardDescription());
        System.out.println(enemy.getDeckList().getCard(randomCard2).showCardDescription());
        System.out.println(enemy.getDeckList().getCard(randomCard3).showCardDescription());
        System.out.println("Select a new card to add to your deck (1, 2 or 3 - if an invalid command is input, the first card will be selected.)")
        
        Scanner x2 = new Scanner(System.in);
        String cardToAdd = x2.nextLine();
        
        if (cardToAdd == "1") {
            player.getDeckList().addCard(enemy.getDeckList().getCard(randomCard1), 1)
        } else if (cardToAdd == "2") {
            player.getDeckList().addCard(enemy.getDeckList().getCard(randomCard2), 1)
        } else if (cardToAdd == "3") {
            player.getDeckList().addCard(enemy.getDeckList().getCard(randomCard3), 1)
        } else {
            player.getDeckList().addCard(enemy.getDeckList().getCard(randomCard1), 1)
        }
    }
    return victory;
    }
}
