import javafx.geometry.Orientation;
import javafx.scene.layout.TilePane;
import javafx.scene.*;
import javafx.scene.control.*;

public class BattleScene extends FirstScene
{
    
    
    private String playerName;
    private Player player = new Player();
    
    public BattleScene(GUI gui, String name)
    {
        super(gui);
        this.playerName = name;
    }

    
    
    @Override
    public void setup()
    {
        player.setName(playerName);
        TilePane root = new TilePane(Orientation.VERTICAL);
        root.setPrefColumns(2);
        
        TilePane firstRow = new TilePane(Orientation.HORIZONTAL);
        firstRow.setPrefRows(2);
        Label playerInfo = new Label(player.getPlayerInformation());
        firstRow.getChildren().add(playerInfo); // Top Left

        //firstRow.getChildren().add(); // Top Right

        TilePane secondRow = new TilePane(Orientation.HORIZONTAL);
        secondRow.setPrefRows(1);



        root.getChildren().add(firstRow);
        


        setScene(new Scene(root, 1000,900));
        display();


        
    }
}