import javafx.geometry.Orientation;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;
import javafx.scene.*;
import javafx.scene.control.*;

public class BattleScene extends FirstScene
{
    
    private Player player = new Player();
    private String playerName;
    public BattleScene(GUI gui, String name)
    {
        super(gui);
        this.playerName = name;
    }

    @Override
    public void setup()
    {
        TilePane root = new TilePane(Orientation.VERTICAL);
        root.setPrefRows(2);
        Label name = new Label("Player information: " + playerName);
        root.getChildren().add(name);

        setScene(new Scene(root, 1000,900));
        display();


        
    }
}