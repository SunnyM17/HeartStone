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
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import users.*;
import utilities.*;


/**
* <h1>Main!</h1>
* The Main program brings together a functioning and engaging
* game by utilising the methods and objects of battle, player,
* enemy, card and deck classes.
*/
public class Gui extends Application{
    private static Player player = new Player();
    private static Enemy GiantRat;
    private static Enemy Mage;
    private static Enemy Minotaur;
    private boolean b = true;
    private static Pane pane = new Pane();
    private Image face;
    private ArrayList<ImageView> ivList = new ArrayList<>();
    private ImageView iv_preview = new ImageView();
    private static BATTLE1 battle;
    private static Scene scene = new Scene(pane , 1200, 800);
    private static Stage stage = new Stage();
    private static Text playerHealth = new Text();
    private static Text playerEnergy = new Text();
    private static Text playerBlock = new Text();
    private static Text enemyHealth = new Text();
    private static Text enemyBlock = new Text();

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
        GiantRatDeck.addCard(masterDeck.getCard("Slash"),3);
        GiantRatDeck.addCard(masterDeck.getCard("Guard"),3);
        GiantRatDeck.addCard(masterDeck.getCard("Claw"),3);

        //Enemy Deck(Mage)
        Deck MageDeck = new Deck();
        MageDeck.addCard(masterDeck.getCard("Slash"),3);
        MageDeck.addCard(masterDeck.getCard("Guard"),3);
        MageDeck.addCard(masterDeck.getCard("Fire_Ball"),3);
        MageDeck.addCard(masterDeck.getCard("Ice_Block"),3);
        MageDeck.addCard(masterDeck.getCard("Healing_Wave"),3);

        //Enemy Deck(Minotaur)
        Deck MinotaurDeck = new Deck();
        MinotaurDeck.addCard(masterDeck.getCard("Slash"),4);
        MinotaurDeck.addCard(masterDeck.getCard("Guard"),2);
        MinotaurDeck.addCard(masterDeck.getCard("Somp"),4);
        MinotaurDeck.addCard(masterDeck.getCard("Charge"),2);
        MinotaurDeck.addCard(masterDeck.getCard("Thick_Hide"),3);
        GiantRat = new Enemy("GiantRat", 45, 2, GiantRatDeck);
        Mage = new Enemy("Mage", 60 , 3, MageDeck);
        Minotaur = new Enemy("MINOTAUR", 90, 4, MinotaurDeck);
        battle = new BATTLE1(player, GiantRat);
        launch(args);
    }
    
    public void fillIvList()
    {
    	playerHealth.setText("Health: " + player.getRemainingHealth());
		playerEnergy.setText("Energy: " + player.getRemainingEnergy());
		playerBlock.setText("Block: " + player.getBlock());
		playerHealth.setLayoutX(40);
		playerHealth.setLayoutY(490);
		playerEnergy.setLayoutX(250);
		playerEnergy.setLayoutY(490);
		playerBlock.setLayoutX(450);
		playerBlock.setLayoutY(490);
		
		playerEnergy.setFont(Font.font(40));
		playerBlock.setFont(Font.font(40));
		playerHealth.setFont(Font.font(40));
		playerEnergy.setFill(Color.LIGHTGREEN);
		playerBlock.setFill(Color.LIGHTGREEN);
		playerHealth.setFill(Color.LIGHTGREEN);
		
		enemyHealth.setText("Health: " + GiantRat.getRemainingHealth());
		enemyBlock.setText("Block: " + GiantRat.getBlock());
		enemyHealth.setLayoutX(740);
		enemyHealth.setLayoutY(300);
		enemyBlock.setLayoutX(980);
		enemyBlock.setLayoutY(300);
		
		enemyBlock.setFont(Font.font(40));
		enemyHealth.setFont(Font.font(40));
		enemyBlock.setFill(Color.WHITE);
		enemyHealth.setFill(Color.WHITE);
    	
    	for(ImageView v : ivList)
    	{
    		pane.getChildren().remove(v);
    	}
    	
    	ivList.clear();
    	for(int i = 0; i < battle.getPlayerHand().getDeckList().size(); i++)
    	{
    		String cardName = (battle.getPlayerHand().getCard(i).getCardName());
    		face = new Image("file:sprites/"+ cardName +".png");
    		System.out.println(cardName);
    		ivList.add(new ImageView(face));
    		
    	}
    	
    	int xSize = 10;
    	for(ImageView i : ivList)
    	{
    		i.setLayoutX(xSize);
			i.setLayoutY(500);
			i.setPreserveRatio(true);
			i.setFitHeight(300);
			xSize += 230;
    	}
    }
    
    public void setPlayerListeners(int i)
    {   
    	//System.out.println(ivList);
		ivList.get(i).setOnMouseEntered(e ->
		{
			String cardName = battle.getPlayerHand().getCard(i).getCardName();
			face = new Image("file:sprites/"+ cardName +".png");
			iv_preview.setImage(face);
			iv_preview.setLayoutX(480); 
			iv_preview.setLayoutY(200);
			iv_preview.setPreserveRatio(true);
			iv_preview.setFitHeight(300);
		});
		
		ivList.get(i).setOnMouseExited(new EventHandler<MouseEvent>()
		{
					@Override
					public void handle(MouseEvent args)
					{
						iv_preview.setImage(null);
					}
		});
		
		if(GiantRat.getRemainingHealth() <= 0)
		{
			pane.getChildren().clear();
			Text end = new Text();
			if(GiantRat.getRemainingHealth() <= 0)
			{
				end.setText("Congrats you beat the game!");
				end.setLayoutX(100);
				end.setLayoutY(400);
				end.setFill(Color.LIGHTGREEN);
			}
			else
			{
				end.setText("YOU LOST!!");
				end.setLayoutX(400);
				end.setLayoutY(400);
			}
			
			end.setFont(Font.font(80));
			
			pane.getChildren().add(end);
			scene.setRoot(pane);
			stage.setScene(scene);
			stage.show();
		}
		
		ivList.get(i).setOnMouseClicked(e ->
		{	
			if(player.getRemainingHealth() > 0 && GiantRat.getRemainingHealth() > 0)
			{
				b = battle.playerTurn(i, player, GiantRat);
				if(b == false)
				{
					battle.refreshOngDeckP();
					battle.initializePHand(player);
					b = true;
					while(b)
					{
						b = battle.enemyTurn(player, GiantRat);
					}
					battle.refreshOngDeckE();
					battle.initializeEHand(GiantRat);
				}
				//updates pane and updates ivList
				fillIvList();
				
				for(ImageView x : ivList)
		    	{
		    		pane.getChildren().add(x);
		    		//System.out.println(x);
		    	}
				
				scene.setRoot(pane);
				stage.setScene(scene);
				stage.show();
				
				System.out.println(b);
				b = true;
				System.out.println(i);
				for(int s = 0; s < ivList.size(); s++)
				{
					setPlayerListeners(s);
				}
			}
		});
    }
    
    public void start(Stage stage) throws Exception
    {
    	stage = this.stage;
    	Button submit = new Button("Submit");
    	Pane Menu = new Pane();
    	submit.setLayoutX(570);
    	submit.setLayoutY(500);
    	TextField userName = new TextField();
    	userName.setLayoutX(550);
    	userName.setLayoutY(400);
    	userName.setPrefHeight(20);
    	userName.setPrefWidth(120);
    	Label user = new Label("Please enter your name.");
    	user.setLayoutX(500);
    	user.setLayoutY(100);
    	Scene scene0 = new Scene(Menu, 1200, 800);
    	Menu.getChildren().addAll(user, userName, submit);
    	stage.setScene(scene0);
    	stage.show();
    	submit.setOnAction(e ->
    	{
			player.setName(userName.getText());
			Text playerName = new Text(player.getName());
			if(player.getName().equals(""))
				playerName.setText("PLAYER1");
			
			playerName.setLayoutX(40);
			playerName.setLayoutY(450);
			playerName.setFont(Font.font(50));
			playerName.setFill(Color.BLUE);
			Text EnemyName = new Text("GiantRat");
			EnemyName.setLayoutX(940);
			EnemyName.setLayoutY(250);
			EnemyName.setFont(Font.font(50));
			EnemyName.setFill(Color.DARKRED);
			
			Menu.getChildren().clear();
			//loading images
			Image map_background = new Image("file:sprites/map_background.png");
			Image bacc1 = new Image("file:sprites/bacc.png");
			
			//loading image viewers
			ImageView iv_map_background = new ImageView(map_background);
	    	pane.getChildren().addAll(iv_map_background , EnemyName);
			ImageView iv_bacc1 = new ImageView(bacc1);
			ImageView iv_bacc2 = new ImageView(bacc1);
			ImageView iv_bacc3 = new ImageView(bacc1);
			ImageView iv_bacc4 = new ImageView(bacc1);
			ImageView iv_bacc5 = new ImageView(bacc1);
			
			fillIvList();
			for(int i = 0; i < battle.getPlayerHand().getDeckList().size(); i ++)
			{
				setPlayerListeners(i);
			}
			
			//customising the images through image viewer
			iv_map_background.setLayoutX(0);
			iv_map_background.setLayoutY(0);
			iv_map_background.setFitHeight(800);
			iv_map_background.setFitWidth(1200);
			
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
	    	pane.getChildren().addAll(iv_bacc1, iv_bacc2, iv_bacc3, iv_bacc4, iv_bacc5, playerName, iv_preview, playerHealth, playerEnergy, playerBlock, enemyHealth, enemyBlock);
	    	for(ImageView x : ivList)
	    	{
	    		pane.getChildren().add(x);
	    	}
	    	scene.setRoot(pane);
	    	this.stage.setScene(scene);
	    	this.stage.show();
    	});
    		
	    	
    
    }
}
