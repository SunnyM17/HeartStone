import javafx.geometry.Orientation;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;
import javafx.scene.*;
import javafx.scene.control.*;

public class BattleScene extends FirstScene
{
    private Combatant player;
    public BattleScene(GUI gui)
    {
        super(gui);
    }

    @Override
    public void setup()
    {
        TilePane root = new TilePane(Orientation.VERTICAL);
        root.setPrefRows(2);
        Label name = new Label("Player information: " + player.getName() );
        root.getChildren().add(name);

        setScene(new Scene(root, 600,600));
        display();


        
    }
}