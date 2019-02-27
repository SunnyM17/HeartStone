import java.util.ArrayList;
import java.util.Random;

public static boolean Battle(Player, Enemy) {

  //Ongoing Decks that will be altered as battle goes on
  Deck ongDeckP = Player.playerDeck;
  Deck ongDeckE = Enemy.enemyDeck;

  //The cards in the hand of each combatant
  ArrayList<Card> playerHand = new ArrayList<Card>();
  ArrayList<Card> enemyHand = new ArrayList<Card>();

  //The cards in the discard piles of each combatant
  ArrayList<Card> playerDiscard = new ArrayList<Card>();
  ArrayList<Card> enemyDiscard = new ArrayList<Card>();

  //The result of the battle relative to the player - returned at the end and is an exit condition in the while loop
  boolean victory = false;
  while ((victory != false) && (Player.remainingHealth > 0 )); //While the player hasn't lost or won, the battle goes on

    //Step 0: Announce relevant stats for each combatant
    System.out.println(Player.getPlayerInformation())
    System.out.println(Enemy.getEnemyInformation())

    //Step 1: Refresh Energy of each combatant
    Player.remainingEnergy = Player.maxEnergy;
    Enemy.remainingHealth = Enemy.maxEnergy;

    //Step 2: Each combatant draws 5 cards from their deck
    for (int x = 0; x = 4; x++)

      //If any of the decks are empty while attempting to draw, shuffles the discard pile into the deck
      if (ongDeckP.length = 0) {
        for (int x = 0; x = playerDiscard.length; x++)
          ongDeckP.deck.add(playerDiscard[x]);
          playerDiscard.remove(x);
      }
      if (ongDeckE.length = 0) {
        for (int x = 0; x = enemyDiscard.length; x++)
          ongDeckE.deck.add(enemyDiscard[x]);
          enemyDiscard.remove(x);
      }

      //Randomly selects a cards to draw from decks
      int randomDrawP = rand.nextInt(Player.ongDeckP.length);
      int randomDrawE = rand.nextInt(Enemy.ongDeckE.length);

      //Adds said cards to respective combatants' hands
      playerHand.add(ongDeckP.deck[randomDrawP]);
      ongDeckP.deck.remove(randomDrawP);

      enemyHand.add(ongDeckE.deck[randomDrawE]);
      ongDeckE.deck.remove(randomDrawE);

    //Step 3: Enemy randomly chooses cards from hand to play, while energy is available
     while (Enemy.remainingEnergy > 0 && enemyHand.length > 0 (&& failSafe != 15)); //Enemy keeps playing cards while energy and cards remain
      cardToPlay = rand.nextInt(enemyHand.length); //Random card from hand is selected
      int failSafe = 0; //As the "AI" cannot yet determine if it doesn't have enough energy to play any of it's remaining cards, if it randomly selects a card in its hand 15 times and cannot play any of those, it ends its turn
      while (cardToPlay.energyCost > Enemy.remainingEnergy);
        cardToPlay = rand.nextInt(enemyHand.length);
        failSafe += 1
        if (failSafe = 15)
          break
      if (failSafe != 15)
        System.out.println(enemyName+" plays "+cardToPlay.showCardDescription())
        Enemy.altEnergy(cardToPlay.energyCost);
        Enemy.altBlock(-cardToPlay.blockValue);
        //Deals damage to block first
        remainingDamage = cardToPlay.damageValue - Player.block;
        Player.block = 0;
        Player.altHealth(cardToPlay.remainingDamage);
      if (Player.remainingHealth <= 0);
        victory = false;
      System.out.println(Player.getPlayerInformation())
      System.out.println(Enemy.getEnemyInformation())

      //
