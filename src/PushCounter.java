import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class PushCounter extends Application
{
    // We keep track of the count, and label displaying the count:
    private int count;
    private Text countText;

    @Override
    public void start(Stage stage)
    {
        count = 0;
        countText = new Text("Pushes: 0");
        
        Button push = new Button("Push Me!");
        push.setOnAction(this::processButtonPress);
        
        FlowPane pane = new FlowPane(push, countText);
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(20);
        pane.setStyle("-fx-background-color: cyan");
        
        Scene scene = new Scene(pane, 300, 100);
        
        stage.setTitle("Push Counter");
        stage.setScene(scene);
        stage.show();
        
    }

    /**
     * This will be executed when the button is clicked
     * It increments the count by 1
     */
    private void processButtonPress(ActionEvent event)
    {
        // Counts number of button clicks and shows the result on a label
        count++;
        countText.setText("Pushes: " + count);
    }
}
