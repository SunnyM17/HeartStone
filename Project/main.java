import java.util.Scanner;
import java.util.Random;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
public class main extends Application
{
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage)
    {
        Stage boi0 = new Stage();
        GridPane boi1 = new GridPane();
        boi1.setHgap(10);
        boi1.setPadding(new Insets(500,500,500,500));
        boi0.setMaxHeight(600);
        boi0.setMaxWidth(800);
        Label title = new Label("SLAY THE SPIRE");
        boi1.add(title, 0, 0);
        boi1.setHalignment(title, HPos.CENTER);
        
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
        masterDeck.addCard(new Card("pass", 0 ,0 ,0 ,0),1);
        
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
        System.out.println();
        Player Player1 = new Player(playerName);
        Scene boi2 = new Scene(boi1, 600,800);
        boi0.setScene(boi2);
        boi0.show();
        // intro or whatever
        boolean victory = true;
        while (victory == true)
        {
        Battle battle0 = new Battle();
        victory = battle0.battle(Player1, GiantRat);
        
        Battle battle1 = new Battle();
        victory = battle1.battle(Player1, Mage);  
        
        Battle battle2 = new Battle();
        victory = battle2.battle(Player1, Minotaur);
        break;
        }
        
        if (victory == true)
        {
            System.out.println("YAAAAY YOU BEAT THE GAME GOOD JOB");
        }else
        {
            System.out.println("AWWWW, YOU'RE DEAD. TRY AGAIN!");
        }
        
    }
    
}
