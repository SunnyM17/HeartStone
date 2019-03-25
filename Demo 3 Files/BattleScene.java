import javafx.geometry.Orientation;
import javafx.scene.layout.TilePane;

public class BattleScene extends FirstScene
{
    public BattleScene(GUI gui)
    {
        super(gui);
    }

    @Override
    public void setup()
    {
        TilePane root = new TilePane(Orientation.VERTICAL);
        root.setPrefRows(2);


        
    }
}