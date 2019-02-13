import java.util.ArrayList;
public class Player
{
    //instance variables
    private int max_health = 80;
    private int shield = 0;
    private int max_energy = 3;
    private int health;
    private int energy;
    private String PlayerName = "";

    public Player(String PlayerName, int health, int energy)
    {
        this.PlayerName = PlayerName;
        this.health = health;
        this.energy = energy;
    }
    
    public int alt_health(int amount)
    {
        return health -= amount;     
    }
    
    public int alt_energy(int amount)
    {
        return energy -= amount;
    }
    
    public int alt_shield(int amount)
    {
        return shield -= amount;
    }
}
