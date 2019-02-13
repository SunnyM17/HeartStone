public class Card {

  //Instance Variables
  private String cardName;
  private int energyCost;
  private int damageValue;
  private int blockValue;
  private int drawValue;

  //Constructors
  public Card (String cardName, int energyCost, int damageValue, int blockValue, int drawValue) {
    this.cardName = cardName;
    this.energyCost = energyCost;
    this.damageValue = damageValue;
    this.blockValue = blockValue;
    this.drawValue = drawValue;
  }
  
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

  public int getBlockValue()
  {
    return blockValue;
  }  
  
  public int getDrawValue()
  {
    return drawValue;
  }
  //Accessor Method
  public String showCardDescription() {
    String cardDescription = (cardName + ": "+"Energy Cost: " + energyCost);
    if (damageValue > 0) {
      cardDescription += (", Deals "+damageValue+" damage");
    }
    if (blockValue > 0) {
      cardDescription += (", Blocks "+blockValue+" damage");
    }
    if (drawValue == 1) {
      cardDescription += (", Draws "+drawValue+" card");
    } else if (drawValue > 0) {
      cardDescription += (", Draws "+drawValue+" cards");
    }
    cardDescription += ".";
    return cardDescription;
  }
}
