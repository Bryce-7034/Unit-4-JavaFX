import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.shape.*;


public class CircleRadius extends GridPane {
    private Label result;
    private TextField radius;

    public CircleRadius() {
        Font font = new Font(18);
        Label inputLabel = new Label("Radius:");
        inputLabel.setFont(font);
        GridPane.setHalignment(inputLabel,HPos.RIGHT);

        result = new Label("---");
        result.setFont(font);
        GridPane.setHalignment(result, HPos.CENTER);

        radius = new TextField();
        radius.setFont(font);
        radius.setPrefWidth(70);
        radius.setAlignment(Pos.CENTER);
        double circleRadius = Double.parseDouble(radius.getText());

        Circle circle = new Circle(150, 100, circleRadius);

        setAlignment(Pos.CENTER);
        setHgap(20);
        setVgap(10);
        setStyle("-fx-background-color: yellow");

        add(inputLabel, 0, 0);
        add(radius, 1,0);
        add(circle, 1, 0 );
        add(result, 1, 1);
    }



}
