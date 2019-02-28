public class Enemy {

   //Instance Variables
   private String enemyName;
   private int maxHealth;
   private int maxEnergy;
   private int remainingHealth;
   private int remainingEnergy;
   private int block;
   private Deck enemyDeck;

   //Constructors
   public Enemy (String enemyName, int maxHealth, int maxEnergy, Deck enemyDeck){
     this.enemyName = enemyName;
     this.maxHealth = maxHealth;
     this.remainingHealth = maxHealth;
     this.maxEnergy = maxEnergy;
     this.remainingEnergy = maxEnergy;
     this.block = 0;
     this.enemyDeck = new enemyDeck();
   }

   //Accesor methods
   public String getEnemyInformation() {
        return (enemyName + ": "+remainingHealth+"/"+maxHealth+", "+block+" block");
   }

   //Mutator Methods
   public void setBlock(int amount)
   {
       this.block = amount;
   }
   
   public void altHealth(int amount) {
        remainingHealth -= amount;
   }
   public void altEnergy(int amount) {
        remainingEnergy -= amount;
   }
   public void altBlock(int amount) {
        block -= amount;
   }
       
    public int getRemainingHealth()
    {
        return remainingHealth;
    }
    
    public int getRemainingEnergy()
    {
        return remainingEnergy;
    }
    
    public void setMaxEnergy(int amount)
    {
        remainingEnergy = amount;
    }
      
    public void setMaxHealth(int amount)
    {
        remainingHealth = amount;
    }
    
    public int getMaxEnergy()
    {
        return maxEnergy;
    }
    
    public int getMaxHealth()
    {
        return maxHealth;
    }   
    
   public Deck getDeck()
   {
       return enemyDeck;
   }
}
