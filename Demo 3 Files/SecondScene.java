import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.*;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SecondScene extends FirstScene {
    
    public SecondScene(GUI gui) {
        super(gui);
    }



    @Override
    public void setup() {
        

        HBox textfield = new HBox();
        Label name = new Label("Enter your name:                                                          ");
        name.setTextFill(Color.BLACK);
        name.setFont(Font.font(24));

        TextField box = new TextField();
        box.setMaxWidth(200);
        textfield.getChildren().add(name);
        textfield.getChildren().add(box);
        textfield.setAlignment(Pos.CENTER_RIGHT);

        HBox button = new HBox();
        Button setName = new Button("Set Name!");
        Button exit = new Button("Quit");
        button.getChildren().add(setName);
        button.getChildren().add(exit);
        button.setAlignment(Pos.BOTTOM_CENTER);

        StackPane pane = new StackPane();
        pane.getChildren().add(name);
        pane.getChildren().add(button);
        pane.getChildren().add(box);
        pane.setAlignment(Pos.CENTER);
    

        //exits the program
        BtnQuitHandler qHandle = new BtnQuitHandler();
        exit.setOnAction(qHandle);

        //Set's up name and starts the program.
        setName.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                String playerName = box.getText();    
                BattleScene scene1 = new BattleScene(getGUI(), playerName);
                scene1.setup();
                
            }
        });
        setScene(new Scene(pane,600,600));
        display();





    }
    
}