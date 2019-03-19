/**
* <h1>Create An Enemy!</h1>
* The Enemy program creates an object that is able
* to store information on the name, max health,
* remaining health, max energy, remaining energy,
* block value, and card deck for the enemy.
*/
public class Enemy extends Combatant{

   /**
   * A method to obtain the enemy information, such as name, max and
   * remaining health, and current block value.
   * @return String This returns the enemy's current information.
   */
   public String getEnemyInformation()
   {
        return (super.name + ": "+super.emainingHealth+"/"+super.maxHealth+", " + "block: "+ super.block);
   }
