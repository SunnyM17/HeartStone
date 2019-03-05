public class Card {

  //Instance Variables
  private String cardName;
  private int energyCost;
  private int damageValue;
  private int blockValue;

  //Constructors
  public Card (String cardName, int energyCost, int damageValue, int blockValue) {
    setCardName(cardName);
    setEnergyCost(energyCost);
    setDamageValue(damageValue);
    setBlockValue(blockValue);
  }
  public void setCardName(String cardName)
  {
    this.cardName = cardName;
  }
  public void setEnergyCost(int energyCost)
  {
    this.energyCost = energyCost;
  }
  public void setDamageValue(int damageValue)
  {
    this.damageValue = damageValue;
  }
  public void setBlockValue(int blockValue)
  {
    this.blockValue = blockValue;
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
