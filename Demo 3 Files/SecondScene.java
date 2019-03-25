import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class SecondScene extends FirstScene {

    public SecondScene(GUI gui) {
        super(gui);
    }

    @Override
    public void setup() {
        

        HBox textfield = new HBox();
        Label name = new Label("Enter your name: ");
        name.setTextFill(Color.BLACK);

        TextField box = new TextField();
        box.setMaxWidth(200);
        textfield.setAlignment(Pos.CENTER);
        name.setAlignment(Pos.CENTER_LEFT);
        textfield.getChildren().add(name);
        textfield.getChildren().add(box);

        HBox button = new HBox();
        Button start = new Button("Set Name!");
        Button exit = new Button("Quit");
        button.getChildren().add(start);
        button.getChildren().add(exit);
        button.setAlignment(Pos.BOTTOM_CENTER);

        StackPane pane = new StackPane();
        pane.getChildren().add(button);
        pane.getChildren().add(box);
        pane.setAlignment(Pos.CENTER);


        BtnQuitHandler qHandle = new BtnQuitHandler();
        exit.setOnAction(qHandle);

        setScene(new Scene(pane,600,600));
        display();





    }
    
}