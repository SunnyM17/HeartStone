import javafx.scene.Scene;


public abstract class FirstScene
{
    private Scene scene;
    private GUI gui;

    public FirstScene(GUI gui)
    {
        this.gui = gui;
    }
    public  void setScene(Scene scene)
    {
        this.scene = scene;
    }
    public void setGUI(GUI gui)
    {
        this.gui = gui;
    }
    public Scene getScene()
    {
        return scene;
    }
    public GUI getGUI()
    {
        return gui;
    }


    public abstract void setup();

    protected void display()
    {
        gui.setScene(this.scene);
    }

}