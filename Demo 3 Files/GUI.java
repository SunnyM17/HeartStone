import java.util.Scanner;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;


/**
* <h1>Main!</h1>
* The Main program brings together a functioning and engaging
* game by utilising the methods and objects of battle, player,
* enemy, card and deck classes.
*/
public class Gui extends Application{
    private Player player;
    private static Enemy GiantRat;
    private static Enemy Mage;
    private static Enemy Minotaur;
    private boolean b = false;
    private Pane pane = new Pane();

    public static void main(String[] args) throws FileNotFoundException
    {
    	//The master deck is a collection of all the cards in the game
        Deck masterDeck = new Deck();
        Scanner input = new Scanner(new File("cardList.txt"));
        while(input.hasNext())
        {
        	
        	masterDeck.addCard(new Card(input.next(), Integer.parseInt(input.next()), Integer.parseInt(input.next()), Integer.parseInt(input.next())) , 1);
        }
        
    	input.close();
    		
        //Enemy Deck(GiantRat)
        Deck GiantRatDeck = new Deck();
        GiantRatDeck.addCard(masterDeck.getCard("SLASH"),3);
        GiantRatDeck.addCard(masterDeck.getCard("GUARD"),3);
        GiantRatDeck.addCard(masterDeck.getCard("CLAW"),3);

        //Enemy Deck(Mage)
        Deck MageDeck = new Deck();
        MageDeck.addCard(masterDeck.getCard("SLASH"),3);
        MageDeck.addCard(masterDeck.getCard("GUARD"),3);
        MageDeck.addCard(masterDeck.getCard("FIRE_BALL"),3);
        MageDeck.addCard(masterDeck.getCard("ICE_BLOCK"),3);
        MageDeck.addCard(masterDeck.getCard("HEALING_WAVE"),3);

        //Enemy Deck(Minotaur)
        Deck MinotaurDeck = new Deck();
        MinotaurDeck.addCard(masterDeck.getCard("SLASH"),4);
        MinotaurDeck.addCard(masterDeck.getCard("GUARD"),2);
        MinotaurDeck.addCard(masterDeck.getCard("STOMP"),4);
        MinotaurDeck.addCard(masterDeck.getCard("CHARGE"),2);
        MinotaurDeck.addCard(masterDeck.getCard("THICK_HIDE"),3);
        GiantRat = new Enemy("GiantRat", 45, 2, GiantRatDeck);
        Mage = new Enemy("Mage", 60 , 3, MageDeck);
        Minotaur = new Enemy("MINOTAUR", 90, 4, MinotaurDeck);
        launch(args);
    }
    
    public void start(Stage stage) throws Exception
    {
    	player = new Player();
    	Button submit = new Button("SUBMIT!");
    	Pane Menu = new Pane();
    	submit.setLayoutX(570);
    	submit.setLayoutY(500);
    	TextField userName = new TextField();
    	userName.setLayoutX(550);
    	userName.setLayoutY(400);
    	userName.setPrefHeight(20);
    	userName.setPrefWidth(120);
    	Label user = new Label("PLEASE ENTER YOUR USERNAME!!");
    	user.setLayoutX(500);
    	user.setLayoutY(100);
    	Scene scene0 = new Scene(Menu, 1200, 800);
    	Menu.getChildren().addAll(user, userName, submit);
    	stage.setScene(scene0);
    	stage.show();
    	submit.setOnAction(e ->
    	{
			player.setName(userName.getText());
			Label playerName = new Label(player.getName());
			playerName.setLayoutX(50);
			playerName.setLayoutY(450);
			playerName.setPrefHeight(50);
			BATTLE1 battle = new BATTLE1(player, GiantRat);
			Menu.getChildren().clear();
			//loading images
			Image map_background = new Image("file:sprites/map_background.png");
			Image face1 = new Image("file:sprites/marin.png");
			Image face2 = new Image("file:sprites/Gold.png");
			Image face3 = new Image("file:sprites/rare-spear.png");
			Image face4 = new Image("file:sprites/Zerek.png");
			Image face5 = new Image("file:sprites/boi.png");
			Image bacc1 = new Image("file:sprites/bacc.png");
			
			
			
			//loading image viewers
			ImageView iv_map_background = new ImageView(map_background);
			ImageView iv_face1 = new ImageView(face1);
			ImageView iv_face2 = new ImageView(face2);
			ImageView iv_face3 = new ImageView(face3);
			ImageView iv_face4 = new ImageView(face4);
			ImageView iv_face5 = new ImageView(face5);
			ImageView iv_preview = new ImageView();
			ImageView iv_bacc1 = new ImageView(bacc1);
			ImageView iv_bacc2 = new ImageView(bacc1);
			ImageView iv_bacc3 = new ImageView(bacc1);
			ImageView iv_bacc4 = new ImageView(bacc1);
			ImageView iv_bacc5 = new ImageView(bacc1);
			
			
			//customising the images through image viewer
			iv_map_background.setLayoutX(0);
			iv_map_background.setLayoutY(0);
			iv_map_background.setFitHeight(800);
			iv_map_background.setFitWidth(1200);
			
			iv_face1.setLayoutX(10);
			iv_face1.setLayoutY(500);
			iv_face1.setPreserveRatio(true);
			iv_face1.setFitHeight(300);
			
			iv_face2.setLayoutX(240); 
			iv_face2.setLayoutY(500); 
			iv_face2.setPreserveRatio(true);
			iv_face2.setFitHeight(300); 
			
			iv_face3.setLayoutX(480); 
			iv_face3.setLayoutY(500); 
			iv_face3.setPreserveRatio(true);
			iv_face3.setFitHeight(300);
			
			iv_face4.setLayoutX(720); 
			iv_face4.setLayoutY(500); 
			iv_face4.setPreserveRatio(true);
			iv_face4.setFitHeight(300);
			
			iv_face5.setLayoutX(960); 
			iv_face5.setLayoutY(500); 
			iv_face5.setPreserveRatio(true);
			iv_face5.setFitHeight(300);
			
			//enemy cards
			iv_bacc1.setLayoutX(40); 
			iv_bacc1.setLayoutY(5); 
			iv_bacc1.setPreserveRatio(true);
			iv_bacc1.setFitHeight(200);
			
			iv_bacc2.setLayoutX(250); 
			iv_bacc2.setLayoutY(5); 
			iv_bacc2.setPreserveRatio(true);
			iv_bacc2.setFitHeight(200);
			
			iv_bacc3.setLayoutX(490); 
			iv_bacc3.setLayoutY(5); 
			iv_bacc3.setPreserveRatio(true);
			iv_bacc3.setFitHeight(200);
			
			iv_bacc4.setLayoutX(730); 
			iv_bacc4.setLayoutY(5); 
			iv_bacc4.setPreserveRatio(true);
			iv_bacc4.setFitHeight(200);
			
			iv_bacc5.setLayoutX(970); 
			iv_bacc5.setLayoutY(5); 
			iv_bacc5.setPreserveRatio(true);
			iv_bacc5.setFitHeight(200);
			
			//action listeners and event handlers (preview)
			iv_face1.setOnMouseEntered(new EventHandler<MouseEvent>()
			{
						@Override
						public void handle(MouseEvent args)
						{
							iv_preview.setImage(face1);
							iv_preview.setLayoutX(480); 
							iv_preview.setLayoutY(200);
							iv_preview.setPreserveRatio(true);
							iv_preview.setFitHeight(300);
						}
			});
			
			
			iv_face1.setOnMouseExited(new EventHandler<MouseEvent>()
			{
						@Override
						public void handle(MouseEvent args)
						{
							iv_preview.setImage(null);
						}
			});
			
			iv_face2.setOnMouseEntered(new EventHandler<MouseEvent>()
			{
						@Override
						public void handle(MouseEvent args)
						{
							iv_preview.setImage(face2);
							iv_preview.setLayoutX(480); 
							iv_preview.setLayoutY(200);
							iv_preview.setPreserveRatio(true);
							iv_preview.setFitHeight(300);
						}
			});
			
			iv_face2.setOnMouseExited(new EventHandler<MouseEvent>()
			{
						@Override
						public void handle(MouseEvent args)
						{
							iv_preview.setImage(null);
						}
			});
			
			iv_face3.setOnMouseEntered(new EventHandler<MouseEvent>()
			{
						@Override
						public void handle(MouseEvent args)
						{
							iv_preview.setImage(face3);
							iv_preview.setLayoutX(480); 
							iv_preview.setLayoutY(200);
							iv_preview.setPreserveRatio(true);
							iv_preview.setFitHeight(300);
						}
			});
			
			iv_face3.setOnMouseExited(new EventHandler<MouseEvent>()
			{
						@Override
						public void handle(MouseEvent args)
						{
							iv_preview.setImage(null);
						}
			});
			
			iv_face4.setOnMouseEntered(new EventHandler<MouseEvent>()
			{
						@Override
						public void handle(MouseEvent args)
						{
							iv_preview.setImage(face4);
							iv_preview.setLayoutX(480); 
							iv_preview.setLayoutY(200);
							iv_preview.setPreserveRatio(true);
							iv_preview.setFitHeight(300);
						}
			});
			
			iv_face4.setOnMouseExited(new EventHandler<MouseEvent>()
			{
						@Override
						public void handle(MouseEvent args)
						{
							iv_preview.setImage(null);
						}
			});
			
			iv_face5.setOnMouseEntered(new EventHandler<MouseEvent>()
			{
						@Override
						public void handle(MouseEvent args)
						{
							iv_preview.setImage(face5);
							iv_preview.setLayoutX(480); 
							iv_preview.setLayoutY(200);
							iv_preview.setPreserveRatio(true);
							iv_preview.setFitHeight(300);
						}
			});
			
			iv_face5.setOnMouseExited(new EventHandler<MouseEvent>()
			{
						@Override
						public void handle(MouseEvent args)
						{
							iv_preview.setImage(null);
						}
			});
	
			iv_bacc1.setOnMouseEntered(new EventHandler<MouseEvent>()
			{
						@Override
						public void handle(MouseEvent args)
						{
							iv_preview.setImage(bacc1);
							iv_preview.setLayoutX(480); 
							iv_preview.setLayoutY(210);
							iv_preview.setPreserveRatio(true);
							iv_preview.setFitHeight(300);
						}
			});
			
			
			iv_bacc1.setOnMouseExited(new EventHandler<MouseEvent>()
			{
						@Override
						public void handle(MouseEvent args)
						{
							iv_preview.setImage(null);
						}
			});
			
			iv_bacc2.setOnMouseEntered(new EventHandler<MouseEvent>()
			{
						@Override
						public void handle(MouseEvent args)
						{
							iv_preview.setImage(bacc1);
							iv_preview.setLayoutX(480); 
							iv_preview.setLayoutY(210);
							iv_preview.setPreserveRatio(true);
							iv_preview.setFitHeight(300);
						}
			});
			
			iv_bacc2.setOnMouseExited(new EventHandler<MouseEvent>()
			{
						@Override
						public void handle(MouseEvent args)
						{
							iv_preview.setImage(null);
						}
			});
			
			iv_bacc3.setOnMouseEntered(new EventHandler<MouseEvent>()
			{
						@Override
						public void handle(MouseEvent args)
						{
							iv_preview.setImage(bacc1);
							iv_preview.setLayoutX(480); 
							iv_preview.setLayoutY(210);
							iv_preview.setPreserveRatio(true);
							iv_preview.setFitHeight(300);
						}
			});
			
			iv_bacc3.setOnMouseExited(new EventHandler<MouseEvent>()
			{
						@Override
						public void handle(MouseEvent args)
						{
							iv_preview.setImage(null);
						}
			});
			
			iv_bacc4.setOnMouseEntered(new EventHandler<MouseEvent>()
			{
						@Override
						public void handle(MouseEvent args)
						{
							iv_preview.setImage(bacc1);
							iv_preview.setLayoutX(480); 
							iv_preview.setLayoutY(210);
							iv_preview.setPreserveRatio(true);
							iv_preview.setFitHeight(300);
						}
			});
			
			iv_bacc4.setOnMouseExited(new EventHandler<MouseEvent>()
			{
						@Override
						public void handle(MouseEvent args)
						{
							iv_preview.setImage(null);
						}
			});
			
			iv_bacc5.setOnMouseEntered(new EventHandler<MouseEvent>()
			{
						@Override
						public void handle(MouseEvent args)
						{
							iv_preview.setImage(bacc1);
							iv_preview.setLayoutX(480); 
							iv_preview.setLayoutY(210);
							iv_preview.setPreserveRatio(true);
							iv_preview.setFitHeight(300);
						}
			});
			
			iv_bacc5.setOnMouseExited(new EventHandler<MouseEvent>()
			{
						@Override
						public void handle(MouseEvent args)
						{
							iv_preview.setImage(null);
						}
			});
			
			//mouse clicked function-----------------------------------------------------
			iv_face1.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent args)
				{
					//initiate battle if previous enemy health <= 0
					
					player.altEnergy(battle.getPlayerHand().getCard(0).getEnergyCost());
			        player.altBlock(battle.getPlayerHand().getCard(0).getBlockValue());
			        battle.getPlayerDiscard().getDeckList().add(battle.getPlayerHand().getCard(0));
			        pane.getChildren().remove(iv_face1);

			        if ((battle.getPlayerHand().getCard(0)).getDamageValue() < 0)
			        {
			              player.altHealth((battle.getPlayerHand().getCard(0)).getDamageValue());
			              if (player.getRemainingHealth() > player.getMaxHealth())
			              {
			                    player.setHealth(player.getMaxHealth());
			              }
			              
			        } else {
			              GiantRat.altHealth((battle.getPlayerHand().getCard(0)).getDamageValue());
			        }
					System.out.println(player.getPlayerInformation());
					System.out.println(GiantRat.getEnemyInformation());
					
					
				}
				
			});
			
			iv_face2.setOnMouseClicked(new EventHandler<MouseEvent>()
			{		
				@Override
				public void handle(MouseEvent args)
				{
					player.altEnergy(battle.getPlayerHand().getCard(1).getEnergyCost());
			        player.altBlock(battle.getPlayerHand().getCard(1).getBlockValue());
			        battle.getPlayerDiscard().getDeckList().add(battle.getPlayerHand().getCard(1));
			        pane.getChildren().remove(iv_face2);
			        
			        if ((battle.getPlayerHand().getCard(1)).getDamageValue() < 0)
			        {
			              player.altHealth((battle.getPlayerHand().getCard(1)).getDamageValue());
			              if (player.getRemainingHealth() > player.getMaxHealth())
			              {
			                    player.setHealth(player.getMaxHealth());
			              }
			              
			        } else {
			              GiantRat.altHealth((battle.getPlayerHand().getCard(1)).getDamageValue());
			        }
					System.out.println(player.getPlayerInformation());
					System.out.println(GiantRat.getEnemyInformation());
					
				}
			});
			
			
			iv_face3.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent args)
				{
					player.altEnergy(battle.getPlayerHand().getCard(2).getEnergyCost());
			        player.altBlock(battle.getPlayerHand().getCard(2).getBlockValue());
			        battle.getPlayerDiscard().getDeckList().add(battle.getPlayerHand().getCard(2));
			        pane.getChildren().remove(iv_face3);
			        
			        if ((battle.getPlayerHand().getCard(2)).getDamageValue() < 0)
			        {
			              player.altHealth((battle.getPlayerHand().getCard(2)).getDamageValue());
			              if (player.getRemainingHealth() > player.getMaxHealth())
			              {
			                    player.setHealth(player.getMaxHealth());
			              }
			              
			        } else {
			              GiantRat.altHealth((battle.getPlayerHand().getCard(2)).getDamageValue());
			        }
					System.out.println(player.getPlayerInformation());
					System.out.println(GiantRat.getEnemyInformation());
				}
			});
			
			iv_face4.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent args)
				{
					player.altEnergy(battle.getPlayerHand().getCard(3).getEnergyCost());
			        player.altBlock(battle.getPlayerHand().getCard(3).getBlockValue());
			        battle.getPlayerDiscard().getDeckList().add(battle.getPlayerHand().getCard(3));
			        pane.getChildren().remove(iv_face4);
			        
			        if ((battle.getPlayerHand().getCard(3)).getDamageValue() < 0)
			        {
			              player.altHealth((battle.getPlayerHand().getCard(3)).getDamageValue());
			              if (player.getRemainingHealth() > player.getMaxHealth())
			              {
			                    player.setHealth(player.getMaxHealth());
			              }
			              
			        } else {
			              GiantRat.altHealth((battle.getPlayerHand().getCard(3)).getDamageValue());
			        }
					System.out.println(player.getPlayerInformation());
					System.out.println(GiantRat.getEnemyInformation());
				}
			});
			
			iv_face5.setOnMouseClicked(new EventHandler<MouseEvent>()
			{
				@Override
				public void handle(MouseEvent args)
				{
					player.altEnergy(battle.getPlayerHand().getCard(4).getEnergyCost());
			        player.altBlock(battle.getPlayerHand().getCard(4).getBlockValue());
			        battle.getPlayerDiscard().getDeckList().add(battle.getPlayerHand().getCard(4));
			        pane.getChildren().remove(iv_face5);
			        
			        if ((battle.getPlayerHand().getCard(4)).getDamageValue() < 0)
			        {
			              player.altHealth((battle.getPlayerHand().getCard(4)).getDamageValue());
			              if (player.getRemainingHealth() > player.getMaxHealth())
			              {
			                    player.setHealth(player.getMaxHealth());
			              }
			              
			        } else {
			              GiantRat.altHealth((battle.getPlayerHand().getCard(4)).getDamageValue());
			        }
					System.out.println(player.getPlayerInformation());
					System.out.println(GiantRat.getEnemyInformation());
				}
			});
	
	    	pane.getChildren().addAll(iv_map_background , iv_face1, iv_face2, iv_face3, iv_face4, iv_face5,
	    			iv_preview, iv_bacc1, iv_bacc2, iv_bacc3, iv_bacc4, iv_bacc5, playerName);
			Scene scene = new Scene(pane , 1200, 800);
	    	stage.setScene(scene);
	    	stage.show();
			
    	});
    		
	    	
    
    }
}
