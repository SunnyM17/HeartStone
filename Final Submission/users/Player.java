package users;

import utilities.*;
/**
* <h1>Create Player Status!</h1>
* The Player program creates an object that is able
* to store information on the name, max health,
* remaining health, max energy, remaining energy,
* block value, and card deck for the player.
*/
public class Player extends Combatant 
{

    
    //Constructors

    /**
    * This method creates a Player object to store the max
    * and remining health, max and remaining energy, block value, and
    * a card deck unique to the player.
    * <p>
    * <b>Note:</b> The max and remaining health is initiated to 80, the
    * max and remaining energy is initiated to 3, block value is
    * initiated to 0, while the player deck is initiated with 5 SLASH,
    * 5 GUARD cards and 5 HEAL cards.
    */
    public Player()
    {
        super("", 80, 3, new Deck());
        super.getDeck().addCard(new Card("SLASH", 1, 6, 0),5);
        super.getDeck().addCard(new Card("GUARD", 1, 0, 5),5);
        super.getDeck().addCard(new Card("HEALING_WAVE", 1, -3, 0),5);
    }

    /**
    * This method creates a Player object to store the player name, max
    * and reamining health, max and remaining energy, block value, and
    * a card deck unique to the player.
    * @param playerName The player's name.
    * <p>
    * <b>Note:</b> The max and remaining health is initiated to 80, the
    * max and remaining energy is initiated to 3, block value is
    * initiated to 0, while the player deck is initiated with 5 SLASH,
    * 5 GUARD cards and 5 HEAL cards.
    */
    public Player(String playerName)
    {
        super(playerName, 80, 3, new Deck());
        super.getDeck().addCard(new Card("SLASH", 1, 6, 0),5);
        super.getDeck().addCard(new Card("GUARD", 1, 0, 5),5);
        super.getDeck().addCard(new Card("HEALING_WAVE", 1, -3, 0),5);
    }
    
    /**
    * This methods creates an exact copy of the player object
    * from param toCopy.
    * @param toCopy The player info to copy.
    */
    public Player(Player toCopy)
    {
        super(toCopy);
    }
       
    
    //Accesor methods

    /**
    * A method to obtain the player information, such as name, max and
    * remaining health, current block value, as well as max and
    * remaining energy.
    * @return String This returns the player's current information.
    */
    public String getPlayerInformation()
    {
        return (super.getName() + ": "+super.getRemainingHealth() +"/"+super.getMaxHealth()+", " + " block: "+ super.getBlock()+"/10" + ", " + "ENERGY: " + super.getRemainingEnergy() + "/"+super.getMaxEnergy());
    }
}
