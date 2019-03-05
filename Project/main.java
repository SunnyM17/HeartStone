import java.util.Scanner;
import java.util.Random;
public class main
{
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
        while (dead != true)
        {
            dead = battle(Player1, Mage);
        }
        //If dead = true, sorry you lost
        //If dead = false, congarts you won 😊
    }
}
