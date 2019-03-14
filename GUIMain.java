import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.text.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import com.sun.javafx.geom.Rectangle;
import com.sun.media.jfxmediaimpl.platform.Platform;
import org.w3c.dom.events.Event;
import javafx.scene.layout.StackPane;


public class GUIMain extends Application{

    private Card card = new Card("cardName", 1,6,0);
    private Deck playerDeck = new Deck();
    private Deck enemyDeck = new Deck();
    private Player player = new Player();
    private Enemy enemy = new Enemy("Enemy Name ", 80, 3, enemyDeck);
    private Battle battle = new Battle();

    public static void main(String[] args)
    {
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

        Player Player1 = new Player("Sunny");

        /*
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
        }*/
        launch(args);
    }

    @Override
    public void start(Stage primarysStage) throws Exception
    {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800,800);
        primarysStage.setScene(scene);
        primarysStage.setTitle("Ascension");
        scene.setFill(Color.WHITESMOKE);

        HBox playerInfo = new HBox();
        Label playerNameLabel = new Label("Player Name: " + player.getPlayerName());
        Label playerHealthLabel = new Label("Player Health:" + player.getRemainingHealth());
        Label playerEnergyLabel = new Label("Player Energy:" + player.getRemainingEnergy());
        playerInfo.setAlignment(Pos.TOP_LEFT);
        playerInfo.getChildren().add(playerNameLabel);
        playerInfo.getChildren().add(playerHealthLabel);
        playerInfo.getChildren().add(playerEnergyLabel);

        HBox enemyInfo = new HBox();
        Label enemyNameLabel = new Label("Enemy Name:" + enemy.getName());
        Label enemyHealthLabel = new Label("Enemy Health: " + enemy.getRemainingHealth());
        Label enemyEnergyLabel = new Label("Enemy Energy: " + enemy.getRemainingEnergy());
        enemyInfo.setAlignment(Pos.TOP_RIGHT);
        enemyInfo.getChildren().add(enemyNameLabel);
        enemyInfo.getChildren().add(enemyHealthLabel);
        enemyInfo.getChildren().add(enemyEnergyLabel);

        VBox buttons = new VBox();
        buttons.setAlignment(Pos.BASELINE_CENTER);
        battle.battle(Player1, GiantRat);
        Button card1 = new Button(playerDeck.getCard(0).showCardDescription());
        Button card2 = new Button(playerDeck.getCard(1).showCardDescription());
        Button card3 = new Button(playerDeck.getCard(2).showCardDescription());
        Button card4 = new Button(playerDeck.getCard(3).showCardDescription());
        Button card5 = new Button(playerDeck.getCard(4).showCardDescription());
        buttons.getChildren().add(card1);
        buttons.getChildren().add(card2);
        buttons.getChildren().add(card3);
        buttons.getChildren().add(card4);
        buttons.getChildren().add(card5);


        root.setLeft(playerInfo);
        root.setRight(enemyInfo);
        root.setBottom(buttons);
        primarysStage.setScene(scene);
        primarysStage.show();
        

    }
}
