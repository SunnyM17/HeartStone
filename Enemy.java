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
     this.enemyname = enemynam e;
     this.maxHealth = maxHealth;
     this.remainingHealth = maxHealth
     this.maxEnergy = maxEnergy;
     this.remainingEnergy = maxEnergy;
     this.block = 0;
     this.enemyDeck = enemyDeck;
   }

   //Accesor methods
   public String getEnemyInformation() {
     return (enemyName + ": "+remainingHealth+"/"+maxHealth+", "+block+" block")
   }

   //Mutator Methods
   void alterRemainingHealth(int amount) {
     remainingHealth -= amount;
   }
   void alterRemainingEnergy(int amount) {
     remainingEnergy -= amount;
   }
   void alterBlock(int amount) {
     block -= amount;
   }
}
