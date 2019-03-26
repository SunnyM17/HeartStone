import javafx.application.Platform;
import javafx.event.*;

public class BtnStartHandler implements EventHandler<ActionEvent>
{
    GUI gui;
    SecondScene session;

    public BtnStartHandler(GUI gui)
    {
        this.gui = gui;
    }

    @Override
    public void handle(ActionEvent event)
    {
        BattleScene scene = new BattleScene(gui);
        scene.setup();  
    }
}