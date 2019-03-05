public class Card {

  //Instance Variables
  private String cardName;
  private int energyCost;
  private int damageValue;

  //Constructors
  public Card (String cardName, int energyCost, int damageValue) {
    this.cardName = cardName;
    this.energyCost = energyCost;
    this.damageValue = damageValue;
  }
  
  //Accesor Methods
  public String getCardName()
  {
    return cardName;
  }

  public int getEnergyCost()
  {
    return energyCost;
  }

  public int getDamageValue()
  {
    return damageValue;
  }
  
  public String showCardDescription() {
    String cardDescription = (cardName + ": "+"Energy Cost: " + energyCost);
    if (damageValue > 0) {
      cardDescription += (", Deals "+damageValue+" damage");
    }
    if (blockValue > 0) {
      cardDescription += (", Blocks "+blockValue+" damage");
    }

    cardDescription += ".";
    return cardDescription;
  }
}
