import javafx.application.Platform;
import javafx.event.*;

public class BtnQuitHandler implements EventHandler<ActionEvent>
{
    @Override
    public void handle(ActionEvent event)
    {
        Platform.exit();
    }
}