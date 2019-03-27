import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;


/**
* <h1>Main!</h1>
* The Main program brings together a functioning and engaging
* game by utilising the methods and objects of battle, player,
* enemy, card and deck classes.
*/
public class main{
    

    public static void startBattle(String playerName, Player Player1, Enemy enemy)
    {
    	BATTLE1 battle = new BATTLE1(Player1, enemy);
    	boolean b = true;
        Scanner keyboard = new Scanner(System.in);
        while (Player1.getRemainingHealth() > 0 && enemy.getRemainingHealth() > 0)
        {		
            while(b)
            {
            	b = battle.enemyTurn(Player1, enemy);                
	            System.out.println();
	            System.out.println(Player1.getPlayerInformation());
	            System.out.println(enemy.getEnemyInformation());
	            System.out.println();
	            System.out.println();
	            System.out.println();	            
            }
            
            battle.refreshOngDeckE();
            battle.initializeEHand(enemy);
            
            if(Player1.getRemainingHealth() > 0)
            {
            	b = true;
            }
            
            if (battle.getBlockPlayer() == 1)
        	{
        		Player1.setBlock(0);
        		battle.setBlockPlayer(0);
        	}
            
            if (enemy.getBlock() > 0)
        	{
        		battle.setBlockEnemy(1);
        	}
            
            while(b)
            {
            	
	            //battle.swichTurn(true, false);
	            System.out.print("You have the following cards in your hand: ");
	            System.out.print("Enter the name of the card to play it. \n|");
	            for(int i = 0; i < battle.getPlayerHand().getDeckList().size(); i++)
	            {
	                System.out.print(battle.getPlayerHand().getCard(i).getCardName() + " | ");
	            }
	            System.out.println();
	            String card = keyboard.nextLine().toUpperCase();
	            int cardToPlay = 0;
	            for(int r = 1; r <= battle.getPlayerHand().getDeckList().size(); r++)
	            {
	                if( card.equals("" + r) || card.equals(battle.getPlayerHand().getCard(r-1).getCardName()) )
	                {
	                    cardToPlay = (r-1);
	                    
	                    break;
	                }
	            }
	            
	            System.out.println(playerName + " played " + battle.getPlayerHand().getCard(cardToPlay).showCardDescription());
	            b = battle.playerTurn(cardToPlay, Player1, enemy);
	            
	            System.out.println();
	            System.out.println(Player1.getPlayerInformation());
	            System.out.println(enemy.getEnemyInformation());
	            System.out.println();
            }
            
            battle.refreshOngDeckP();
            battle.initializePHand(Player1);
            
            if (battle.getBlockEnemy() == 1)
        	{
        		enemy.setBlock(0);
        		battle.setBlockEnemy(0);
        	}
        	
            if (Player1.getBlock() > 0)
        	{
        		battle.setBlockPlayer(1);
        	}
            
            if(enemy.getRemainingHealth() > 0)
            {
            	b = true;
            }
            
            if (enemy.getRemainingHealth() <= 0)
            {
                Random rand1 = new Random();
                int randomCard1 = rand1.nextInt(enemy.getDeck().getDeckList().size());
                Random rand2 = new Random();
                int randomCard2 = rand2.nextInt(enemy.getDeck().getDeckList().size());
                Random rand3 = new Random();
                int randomCard3 = rand3.nextInt(enemy.getDeck().getDeckList().size());

                System.out.println(enemy.getDeck().getCard(randomCard1).showCardDescription());
                System.out.println(enemy.getDeck().getCard(randomCard2).showCardDescription());
                System.out.println(enemy.getDeck().getCard(randomCard3).showCardDescription());
                System.out.println();
                System.out.println("Select a new card to add to your deck (1, 2 or 3 - if an invalid command is input, the first card will be selected.)");

                //Checks for which card you would like to add
                Scanner x2 = new Scanner(System.in);
                    
                String cardToAdd = x2.nextLine();

                if (cardToAdd.equals("1"))
                {
                      Player1.getDeck().getDeckList().add( (enemy.getDeck().getDeckList().get(randomCard1)) );
                } else if (cardToAdd.equals("2")) {
                      Player1.getDeck().getDeckList().add( (enemy.getDeck().getDeckList().get(randomCard2)) );
                } else if (cardToAdd.equals("3")) {
                    Player1.getDeck().getDeckList().add( (enemy.getDeck().getDeckList().get(randomCard3)) );
                } 
                else{
                    Player1.getDeck().getDeckList().add( (enemy.getDeck().getDeckList().get(randomCard1)) );
                }
                System.out.println();
                System.out.println("------------------------------------------------------------------------------------------------------------");
            }
        }


            

             
    }



    public static void main(String[] args) throws FileNotFoundException {
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
        
        while (Player1.getRemainingHealth() > 0)
        {
            startBattle(playerName,Player1, GiantRat);
            startBattle(playerName, Player1, Mage);
            startBattle(playerName, Player1, Minotaur);
        }
        System.out.println();
        System.out.println();
        System.out.println("You lost. Try again");
        
    }
}
