import javafx.geometry.Orientation;
import javafx.scene.layout.TilePane;
import javafx.scene.*;
import javafx.scene.control.*;

public class BattleScene extends FirstScene
{
    
    
    private String playerName;
    private Player player = new Player(playerName);
    public BattleScene(GUI gui, String name)
    {
        super(gui);
        this.playerName = name;
    }

    @Override
    public void setup()
    {
        TilePane root = new TilePane(Orientation.VERTICAL);
        root.setPrefColumns(2);
        
        TilePane firstRow = new TilePane(Orientation.HORIZONTAL);
        firstRow.setPrefRows(2);
        firstRow.getChildren().add(sceneA()); // Top Left
        firstRow.getChildren().add(sceneB()); // Top Right

        TilePane secondRow = new TilePane(Orientation.HORIZONTAL);
        secondRow.setPrefRows(1);
        root.getChildren().add(firstRow);
        


        setScene(new Scene(root, 1000,900));
        display();


        
    }

    public Node sceneA(Player player)
    {


    }
}