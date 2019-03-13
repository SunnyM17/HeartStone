import java.util.Scanner;
import java.util.Random;


/**
* <h1>Main!</h1>
* The Main program brings together a functioning and engaging
* game by utilizing the methods and objects of battle, player,
* enemy, card and deck classes.
*/
public class main extends Application {

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
        boolean victory = true;
        while (victory)
        {
             //First Battle : Player vs GiantRat
             Battle battle0 = new Battle();
             victory = battle0.battle(Player1, GiantRat);

             //Second Battle : Player vs Mage
             Battle battle1 = new Battle();
             victory = battle1.battle(Player1, Mage);

             //Third Battle : Player vs Minotaur
             Battle battle2 = new Battle();
             victory = battle2.battle(Player1, Minotaur);
             break;
        }

        //Determines if player is defeated or victorious
        if (victory = true)
        {
            System.out.println("Congratulations, you won!");
        }
        else
        {
            System.out.println("Sorry, you lost. Try again?");
        }
    }

    
}
