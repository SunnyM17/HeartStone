import java.util.Scanner;
import java.util.Random;


/**
* <h1>Main!</h1>
* The Main program brings together a functioning and engaging
* game by utilizing the methods and objects of battle, player,
* enemy, card and deck classes.
*/
public class main{

    

    public static void main(String[] args) {
         //The master deck is a collection of all the cards in the game
        Deck masterDeck = new Deck();
        masterDeck.addCard(new Card("SLASH", 1, 6, 0),1);
        masterDeck.addCard(new Card("GUARD", 1, 0, 5),1);
        masterDeck.addCard(new Card("CLAW", 1, 3, 3),1);
        masterDeck.addCard(new Card("FIRE BALL", 2, 13, 0),1);
        masterDeck.addCard(new Card("ICE BLOCK", 2, 0, 11),1);
        masterDeck.addCard(new Card("HEALING WAVE", 1, -5, 0),1);
        masterDeck.addCard(new Card("STOMP", 2, 5, 5),1);
        masterDeck.addCard(new Card("CHARGE", 3, 28, 0),1);
        masterDeck.addCard(new Card("THICK HIDE", 0, 0, 4),1);
        masterDeck.addCard(new Card("pass", 0 ,0 ,0),1);

        //Enemy Deck(GiantRat)
        Deck GiantRatDeck = new Deck();
        GiantRatDeck.addCard(masterDeck.getCard("SLASH"),3);
        GiantRatDeck.addCard(masterDeck.getCard("GUARD"),3);
        GiantRatDeck.addCard(masterDeck.getCard("CLAW"),3);

        //Enemy Deck(Mage)
        Deck MageDeck = new Deck();
        MageDeck.addCard(masterDeck.getCard("SLASH"),3);
        MageDeck.addCard(masterDeck.getCard("GUARD"),3);
        MageDeck.addCard(masterDeck.getCard("FIRE BALL"),3);
        MageDeck.addCard(masterDeck.getCard("ICE BLOCK"),3);
        MageDeck.addCard(masterDeck.getCard("HEALING WAVE"),3);

        //Enemy Deck(Minotaur)
        Deck MinotaurDeck = new Deck();
        MinotaurDeck.addCard(masterDeck.getCard("SLASH"),4);
        MinotaurDeck.addCard(masterDeck.getCard("GUARD"),2);
        MinotaurDeck.addCard(masterDeck.getCard("STOMP"),4);
        MinotaurDeck.addCard(masterDeck.getCard("CHARGE"),2);
        MinotaurDeck.addCard(masterDeck.getCard("THICK HIDE"),3);

        //Initializing the enemies
        Enemy GiantRat = new Enemy("Giant Rat", 45, 2, GiantRatDeck);
        Enemy Mage = new Enemy("Mage", 60 , 3, MageDeck);
        Enemy Minotaur = new Enemy("MINOTAUR", 90, 4, MinotaurDeck);


        //Begins
        System.out.println("Please input your name.");
        Scanner keyboard = new Scanner(System.in);
        String playerName = keyboard.nextLine();
        System.out.println();

        //Initializing the player
        Player Player1 = new Player(playerName);

        
        //Player undergoes one battle against each enemy
        

        while(Player1.getRemainingHealth() > 0)
        {
            // Boss 1
            while (Player1.getRemainingHealth() > 0 && GiantRat.getRemainingHealth() > 0)
            {
            BATTLE1 battle = new BATTLE1(Player1, GiantRat);
            battle.enemyTurn(Player1, GiantRat);
            System.out.println("Enemy played " + battle.initializeEHand(GiantRat).getCard(battle.getenemyCardIndex()).showCardDescription());
            System.out.println();
            System.out.println(Player1.getPlayerInformation());
            System.out.println(GiantRat.getEnemyInformation());
            System.out.println();
            System.out.println();
            System.out.println();
            battle.swichTurn(true, false);
            System.out.print("You have the following cards in your hand: ");
            System.out.println("Enter the name of the card to play it. |");
            for(int i = 0; i < battle.initializePHand(Player1).getDeckList().size(); i++)
            {
                System.out.print(battle.initializePHand(Player1).getCard(i).getCardName() + " | ");
            }
            System.out.println();
            String card = keyboard.nextLine().toUpperCase();
            for(int r = 1; r <= battle.initializePHand(Player1).getDeckList().size(); r++)
            {
                if(card.equals("" + r))
                {
                    card = battle.initializePHand(Player1).getCard(r-1).getCardName();
                    break;
                }
            }
            
            System.out.println(playerName + " played " + battle.initializePHand(Player1).getCard(card).showCardDescription());
            battle.playerTurn(card, Player1, GiantRat);
            System.out.println();
            System.out.println(Player1.getPlayerInformation());
            System.out.println(GiantRat.getEnemyInformation());
            System.out.println();
           
            battle.swichTurn(false, true);
            }

            // Boss 2
            while (Player1.getRemainingHealth() > 0 && Mage.getRemainingHealth() > 0)
            {
            BATTLE1 battle = new BATTLE1(Player1, Mage);
            battle.enemyTurn(Player1, Mage);
            System.out.println("Enemy played " + battle.initializeEHand(Mage).getCard(battle.getenemyCardIndex()).showCardDescription());
            System.out.println();
            System.out.println(Player1.getPlayerInformation());
            System.out.println(Mage.getEnemyInformation());
            System.out.println();
            System.out.println();
            System.out.println();
            battle.swichTurn(true, false);
            System.out.print("You have the following cards in your hand: ");
            System.out.println("Enter the name of the card to play it. |");
            for(int i = 0; i < battle.initializePHand(Player1).getDeckList().size(); i++)
            {
                System.out.print(battle.initializePHand(Player1).getCard(i).getCardName() + " | ");
            }
            System.out.println();
            String card = keyboard.nextLine().toUpperCase();
            for(int r = 1; r <= battle.initializePHand(Player1).getDeckList().size(); r++)
            {
                if(card.equals("" + r))
                {
                    card = battle.initializePHand(Player1).getCard(r-1).getCardName();
                    break;
                }
            }
            
            System.out.println(playerName + " played " + battle.initializePHand(Player1).getCard(card).showCardDescription());
            battle.playerTurn(card, Player1, Mage);
            System.out.println();
            System.out.println(Player1.getPlayerInformation());
            System.out.println(Mage.getEnemyInformation());
            System.out.println();
            
            battle.swichTurn(false, true);
            }

            // Boss 3
            while (Player1.getRemainingHealth() > 0 && Minotaur.getRemainingHealth() > 0)
            {
            BATTLE1 battle = new BATTLE1(Player1, Minotaur);
            battle.enemyTurn(Player1, Minotaur);
            System.out.println("Enemy played " + battle.initializeEHand(Minotaur).getCard(battle.getenemyCardIndex()).showCardDescription());
            System.out.println();
            System.out.println(Player1.getPlayerInformation());
            System.out.println(Minotaur.getEnemyInformation());
            System.out.println();
            System.out.println();
            System.out.println();
            battle.swichTurn(true, false);
            System.out.print("You have the following cards in your hand: ");
            System.out.println("Enter the name of the card to play it. |");
            for(int i = 0; i < battle.initializePHand(Player1).getDeckList().size(); i++)
            {
                System.out.print(battle.initializePHand(Player1).getCard(i).getCardName() + " | ");
            }
            System.out.println();
            String card = keyboard.nextLine().toUpperCase();
            for(int r = 1; r <= battle.initializePHand(Player1).getDeckList().size(); r++)
            {
                if(card.equals("" + r))
                {
                    card = battle.initializePHand(Player1).getCard(r-1).getCardName();
                    break;
                }
            }
            
            System.out.println(playerName + " played " + battle.initializePHand(Player1).getCard(card).showCardDescription());
            battle.playerTurn(card, Player1, Minotaur);
            System.out.println();
            System.out.println(Player1.getPlayerInformation());
            System.out.println(Minotaur.getEnemyInformation());
            System.out.println();
            
            battle.swichTurn(false, true);
            }  
        }
        System.out.println();
        System.out.println();
        System.out.println("You lost. Try again");
        
    }

    
}
