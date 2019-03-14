import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.text.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import com.sun.javafx.geom.Rectangle;
import com.sun.media.jfxmediaimpl.platform.Platform;
import org.w3c.dom.events.Event;
import javafx.scene.layout.StackPane;

public class GUI extends Application
{
    private Card card = new Card("cardName", 1, 6, 0, 1);
    private Deck deck = new Deck();
    private Player player = new Player();
    private Enemy enemy = new Enemy("Enemy Name", 80, 3,deck );
    private Battle battle = new Battle();

    

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root,800,800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ascension");
        
        HBox textField = new HBox();
        Label name = new Label("Enter your Name: ");
        
        TextField box = new TextField();
        textField.setAlignment(Pos.CENTER);
        textField.getChildren().add(name);
        textField.getChildren().add(box);

        HBox button = new HBox();
        button.setAlignment(Pos.CENTER);
        Button setName = new Button("Set Name!");
        button.getChildren().add(setName);

        VBox label = new VBox();
        Label playerName = new Label("Player Name:" + player.getPlayerName());
        label.setAlignment(Pos.CENTER);
        label.getChildren().add(playerName);
        

        setName.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                String name = box.getText();
                player.setPlayerName(name);
                playerName.setText("Player Name: "+player.getPlayerName());
                
            }
                    
        });

        root.setTop(label);
        root.setCenter(textField);
        root.setBottom(button);
        primaryStage.setScene(scene);
        
        
        

        BorderPane root2 = new BorderPane();
        Scene scene3 = new Scene(root2, 800,800);
        primaryStage.setScene(scene3);
        primaryStage.setTitle("Ascension");

        HBox playerInfo = new HBox();
        Label playerNameLabel = new Label("Player Name: " + player.getPlayerName());
        Label playerHealthLabel = new Label("Player Health:" + player.getRemainingHealth());
        Label playerEnergyLabel = new Label("Player Energy:" + player.getRemainingEnergy());
        playerInfo.setAlignment(Pos.TOP_LEFT);
        playerInfo.getChildren().add(playerNameLabel);
        playerInfo.getChildren().add(playerHealthLabel);
        playerInfo.getChildren().add(playerEnergyLabel);

         
       
        primaryStage.show();

        





    }
}