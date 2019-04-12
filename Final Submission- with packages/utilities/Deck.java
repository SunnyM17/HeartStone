package utilities;

import java.util.ArrayList;

/**
* <h1>Create A Deck!</h1>
* The Deck program creates an object that is able
* to store information in an array list of type card.
* Cards will be added to the array list to complete the deck.
*/
public class Deck {


  // Instance Variable

  private ArrayList<Card> deck = new ArrayList<Card>();


  //Constructor

  /**
  * This method creates an empty array list of type card for the deck.
  */
  public Deck()
  {
        this.deck = new ArrayList<Card>();
  }


  //Accesor Methods

  /**
  * A method to obtain a specific card from the deck.
  * @param cardToGet The card name in type string.
  * @return Card This returns the card if there is such a card in
  * the deck.
  * @return Card This returns the first card in the deck when the
  * card specified is not in the deck. Or the card name does not match.
  */
  public Card getCard(String cardToGet)
  {
    for(int i = 0; i < deck.size(); i++)
    {
        if (cardToGet.equals(deck.get(i).getCardName()))
        {
            return deck.get(i);
        }
    }
    return deck.get(0);
  }

  /**
  * A method to obtain a specific card from the deck.
  * @param cardToGet An index number to the card in the array.
  * @return Card This returns the card from the deck.
  */
  public Card getCard(int cardToGet)
  {
    return this.deck.get(cardToGet);
  }

  /**
  * A method to obtain the entire deck array.
  * @return ArrayList This returns the deck array.
  */
  public ArrayList getDeckList()
  {
      return this.deck;
  }


  //Mutator Method

  /**
  * Adds a specific card, according to param card, to the deck a specific
  * amount of times, according to param amount.
  * @param card A card from the card class to add to the deck.
  * @param amount The amount of times the card is added to the deck.
  */
  public void addCard(Card card, int amount)
  {
    for(int i = 0; i < amount; i++)
    {
        deck.add(card);
    }
  }
}
