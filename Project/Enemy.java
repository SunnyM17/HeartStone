
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
     this.enemyDeck = enemyDeck;
   }

   //Accesor methods
   public String getEnemyInformation() {
        return (enemyName + ": "+remainingHealth+"/"+maxHealth+", " + "block: "+ block);
   }

   public int getBlock()
   {
        return block;
   }
   //Mutator Methods
   public void setBlock(int amount)
   {
       this.block = amount;
   }
   
   public void altHealth(int amount)
    {
       if (amount > block)
       {
            remainingHealth -= (amount - block);
            block = 0;
       }
       else
       {
           if(block >= amount)
           {
                block -= amount;
           }
       }
    }
   public void altEnergy(int amount) {
        remainingEnergy -= amount;
   }
   public void altBlock(int amount) {
        block += amount;
   }
       
   public String getName()
   {
       return enemyName;
   }
    public int getRemainingHealth()
    {
        return remainingHealth;
    }
    
    public int getRemainingEnergy()
    {
        return remainingEnergy;
    }
    
    public void setHealth(int x)
    {
        this.remainingHealth = x;
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
