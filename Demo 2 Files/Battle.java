import java.util.Random;
import java.util.Scanner;
import javax.sound.sampled.BooleanControl;

/**
* <h1>Battle!</h1>
* The Battle program brings together a fascinating and engaging
* battle experience by simulating the battle between the player
* and the enemy.
*/
public class Battle {

      /**
      * A method which initializes a battle between param player
      * and param enemy.
      * @param player The player to fight against an enemy.
      * @param enemy An enemy to battle against the player.
      * @return boolean This returns false if the player has not
      * yet lost or won. This returns true if otherwise.
      */
      public boolean battle(Player player, Enemy enemy)
      {
            int noCard = 0;
            int blockTurnP = 0;
            int blockTurnE = 1;

            //Ongoing Decks that will be altered as battle goes on
            Deck ongDeckP =  new Deck();
            Deck ongDeckE = new Deck();

            //Copies player's starter deck into their ongoing deck
            for (int x = 0; x < player.getDeck().getDeckList().size(); x++)
            {
                  ongDeckP.addCard(player.getDeck().getCard(x),1);
            }

            //Copies enemy's starter deck into their ongoing deck
            for (int x = 0; x < enemy.getDeck().getDeckList().size(); x++)
            {
                  ongDeckE.addCard(enemy.getDeck().getCard(x),1);
            }

            //A deck for each combatant containing the cards in hand to be played during each turn
            Deck playerHand = new Deck();
            Deck enemyHand = new Deck();

            //A deck for each combatant containing the cards in the discard pile
            Deck playerDiscard = new Deck();
            Deck enemyDiscard = new Deck();

            //The result of the battle relative to the player - returned at the end and is an exit condition in the while loop
            boolean victory = false;

            //While the player hasn't lost or won, the battle goes on
            while ((!victory) && (player.getRemainingHealth() > 0 ))
            {
                    //Announce relevant stats for each combatant
                    System.out.println(player.getPlayerInformation());
                    System.out.println(enemy.getEnemyInformation());
                    System.out.println();

                    //Refresh Block of each combatant to 0
                    if (blockTurnP == 0)
                    {
                        player.setBlock(0);
                    }
                    if (blockTurnE % 2 == 0)
                    {
                        enemy.setBlock(0);
                    }

                    //Refresh Energy of each combatant to full
                    player.setRemainingEnergy(player.getMaxEnergy());
                    enemy.setRemainingEnergy(enemy.getMaxEnergy());

                    //Each combatant draws 5 cards from their deck
                    for (int x = 0; x < 6; x++)
                    {
                          //If player ongoing deck is empty while attempting to draw, shuffles the discard pile into the deck
                          if (ongDeckP.getDeckList().size() < 5)
                          {
                                for (int i = 0; i < playerDiscard.getDeckList().size(); i++)
                                {
                                      ongDeckP.addCard((playerDiscard.getCard(i)),1);
                                      playerDiscard.getDeckList().remove(i);
                                }
                          }
                          //If enemy ongoing deck is empty while attempting to draw, shuffles the discard pile into the deck
                          if (ongDeckE.getDeckList().size() < 5)
                          {
                                for (int z = 0; z < enemyDiscard.getDeckList().size(); z++)
                                {
                                      ongDeckE.addCard((enemyDiscard.getCard(z)),1);
                                      enemyDiscard.getDeckList().remove(z);
                                }
                          }

                          //Randomly selects cards to draw from player deck
                          while(playerHand.getDeckList().size() < 5)
                          {
                                Random rand = new Random();
                                int randomDrawP = rand.nextInt(ongDeckP.getDeckList().size());

                                //Adds drawn cards into player's hand
                                playerHand.addCard((ongDeckP.getCard(randomDrawP)), 1);
                                ongDeckP.getDeckList().remove(randomDrawP);
                          }
                          //Randomly selects cards to draw from enemy deck
                          while(enemyHand.getDeckList().size() < 5)
                          {
                                Random rand = new Random();
                                int randomDrawE = rand.nextInt(ongDeckE.getDeckList().size());

                                //Adds drawn cards into enemy's hand
                                enemyHand.addCard((ongDeckE.getCard(randomDrawE)), 1);
                                ongDeckE.getDeckList().remove(randomDrawE);
                          }
                    }

                    //Enemy randomly chooses cards from hand to play, while enough energy is available
                    while(enemy.getRemainingHealth() > 0 && enemyHand.getDeckList().size() > 0 && enemy.getRemainingEnergy() > 0 && !victory)//Enemy keeps playing cards while energy and cards remain
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

                                //Re-establishes the current info of both combatants
                                System.out.println(player.getPlayerInformation());
                                System.out.println(enemy.getEnemyInformation());
                                System.out.println();
                                System.out.println();
                                System.out.println();
                          } else {
                                System.out.println("You have been slain by " + enemy.getName());
                                victory = true;
                                break;
                          }
                    }
                    blockTurnE += 1;
                    blockTurnP = 0;
                    System.out.println("------------------------------------------------------------------------------------------------------------");

                    //Player's turn begins
                    while (player.getRemainingHealth() > 0 && playerHand.getDeckList().size() > 0 && player.getRemainingEnergy() > 0 && !victory)
                    {
                          //Shows you your cards
                          System.out.print("You have the following cards in your hand: ");
                          System.out.println("Enter the name of the card, or it's numerical position in your hand to play it. Type 'pass' to end your turn. |");
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

              //If you win, after the battle you get to select a card to add to your deck, choose from 3 random cards of your opponent's deck.
              if (victory == true)
              {
                    //Randomly generates 3 cards from enemy deck
                    Random rand1 = new Random();
                    int randomCard1 = rand1.nextInt(enemy.getDeck().getDeckList().size());
                    Random rand2 = new Random();
                    int randomCard2 = rand2.nextInt(enemy.getDeck().getDeckList().size());
                    Random rand3 = new Random();
                    int randomCard3 = rand3.nextInt(enemy.getDeck().getDeckList().size());

                    //Prints the descriptions of all 3 cards
                    System.out.println(enemy.getDeck().getDeckList().getCard(randomCard1).showCardDescription());
                    System.out.println(enemy.getDeck().getDeckList().getCard(randomCard2).showCardDescription());
                    System.out.println(enemy.getDeck().getDeckList().getCard(randomCard3).showCardDescription());
                    System.out.println("Select a new card to add to your deck (1, 2 or 3 - if an invalid command is input, the first card will be selected.)");

                    //Checks for which card you would like to add
                    Scanner x2 = new Scanner(System.in);
                    String cardToAdd = x2.nextLine();

                    if (cardToAdd == "1")
                    {
                          player.getDeck().getDeckList().addCard(enemy.getDeck().getDeckList().getCard(randomCard1), 1);
                    } else if (cardToAdd == "2") {
                          player.getDeck().getDeckList().addCard(enemy.getDeck().getDeckList().getCard(randomCard2), 1);
                    } else if (cardToAdd == "3") {
                          player.getDeck().getDeckList().addCard(enemy.getDeck().getDeckList().getCard(randomCard3), 1);
                    } else {
                          player.getDeck().getDeckList().addCard(enemy.getDeck().getDeckList().getCard(randomCard1), 1);
                    }
              }
              return victory;
        }
}
