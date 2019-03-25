import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class GUI extends Application
{
    Stage stage;

    public void setScene(Scene scene)
    {
        stage.setScene(scene);
    }

    public void start(Stage stage)
    {
        this.stage = stage;
        stage.setTitle("Ascension");
        stage.show();

        //SecondScene scene = new SecondScene(this);
        BattleScene scene = new BattleScene(this);
        scene.setup();

    


    }

    public static void main(String[] args)
    {
        launch(args);
    }
}



/*
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
*/