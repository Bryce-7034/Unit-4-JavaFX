import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IncreaseDecrease extends Application
{
    // We keep track of the count, and label displaying the count:
    private int count;
    private Text countText;

    @Override
    public void start(Stage stage)
    {
        count = 0;
        countText = new Text("Number: 50");

        Button increase = new Button("Increase");
        increase.setOnAction(this::processIncreasePress);

        Button decrease = new Button("Decrease");
        decrease.setOnAction(this::processDecreasePress);

        FlowPane pane = new FlowPane(increase, countText, decrease);
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(20);
        pane.setStyle("-fx-background-color: cyan");

        Scene scene = new Scene(pane, 300, 100);

        stage.setTitle("Tails of Minecraftia 2 - essentric bungaloo");
        stage.setScene(scene);
        stage.show();

    }

    private void processIncreasePress(ActionEvent event){
        count ++;
        countText.setText("Number " + (count+50));
    }
    private void processDecreasePress(ActionEvent event){
        count --;
        countText.setText("Number " + (count+50));
    }
}
