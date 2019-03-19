/**
* <h1>Create A Card!</h1>
* The Card program creates an object that is able
* to store information on the card name, energy cost,
* damage value, block value, and draw value associated
* with the card.
*/
public class Card {


  //Instance Variables

  private String cardName;
  private int energyCost;
  private int damageValue;
  private int blockValue;


  //Constructor

  /**
  * This method creates a Card object to store the card name, energy
  * cost requirment, damage value, block value, and draw value.
  * @param cardName A unique card name.
  * @param energyCost The energy cost of the card to be able to be used.
  * @param damageValue The damage value of the card when used on the enemy.
  * @param blockValue The defence value of the card to block against
  * incoming enemy attacks.
  */
  public Card (String cardName, int energyCost, int damageValue, int blockValue) {
    this.cardName = cardName;
    this.energyCost = energyCost;
    this.damageValue = damageValue;
    this.blockValue = blockValue;
  }


  // Setter Methods

  /**
  * Sets a new name to the card.
  * @param cardName A new name for the card.
  */
  public void setCardName(String cardName)
  {
    this.cardName = cardName;
  }

  /**
  * Sets a new energy cost requirment to the card.
  * @param energyCost A value to update the energy cost.
  */
  public void setEnergyCost(int energyCost)
  {
    this.energyCost = energyCost;
  }

  /**
  * Sets a new damage value to the card.
  * @param damageValue A value to update the damage value.
  */
  public void setDamageValue(int damageValue)
  {
    this.damageValue = damageValue;
  }

  /**
  * Sets a new block value to the card.
  * @param blockValue A value to update the block value.
  */
  public void setBlockValue(int blockValue)
  {
    this.blockValue = blockValue;
  }



  //Accesor Methods

  /**
  * A method to obtain the card name.
  * @return String This returns the card name.
  */
  public String getCardName()
  {
    return cardName;
  }

  /**
  * A method to obtain the energy cost.
  * @return int This returns the energy cost.
  */
  public int getEnergyCost()
  {
    return energyCost;
  }

  /**
  * A method to obtain the damage value.
  * @return int This returns the damage value.
  */
  public int getDamageValue()
  {
    return damageValue;
  }

  /**
  * A method to obtain the block value.
  * @return int This returns the block value.
  */
  public int getBlockValue()
  {
    return blockValue;
  }


  /**
  * A method to obtain all the information on the card. Such as the
  * card name, energy cost, damage value, block value, and draw value.
  * @return String This returns the complete card description.
  */
  public String showCardDescription()
  {
    String cardDescription = (cardName + ": "+"Energy Cost: " + energyCost);
    if (damageValue > 0) {
      cardDescription += (", Deals "+damageValue+" damage");
    }
    if (blockValue > 0) {
      cardDescription += (", Blocks "+blockValue+" damage");
    }
    if (damageValue < 0) {
      cardDescription += (", Heals "+(-damageValue)+" damage");
    }
    cardDescription += ".";
    System.out.println();
    return cardDescription;
  }
}
