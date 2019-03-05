import java.util.Random;
public class Battle
{
    public boolean battle(Player player, Enemy enemy)
    {
      //Ongoing Decks that will be altered as battle goes on
      Deck ongDeckP =  new Deck();
      Deck ongDeckE = new Deck();
      for (int i = 0; boi < player.getDeck().getDeckList().size(); i++)
      {
            ongDeckP.addCard(player.getDeck().getCard(i),1);
            ongDeckE.addCard(enemy.getDeck().getCard(i),1);
      }

      //The cards in the hand of each combatant
      Deck playerHand = new Deck();
      Deck enemyHand = new Deck();

      //The cards in the discard piles of each combatant
      Deck playerDiscard = new Deck();
      Deck enemyDiscard = new Deck();

      //The result of the battle relative to the player - returned at the end and is an exit condition in the while loop
      boolean dead  = false;

      //---------------------

      //Battle Start
      while ((victory != false) && (player.getRemainingHealth() > 0 )); //While the player hasn't lost or won, the battle goes on

        //1: Refresh Energy of each combatant
        player.setMaxEnergy(player.getMaxEnergy());
        enemy.setMaxEnergy(enemy.getMaxEnergy());

        //2: Set each conbatant's Shield to 0
        player.setBlock(0);
        enemy.setBlock(0);s

        //3: Each combatant draws 5 cards from their deck
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
}
