import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;


public class FahrenheitPane extends GridPane {
    private Label result;
    private TextField fahrenheit;

    public FahrenheitPane() {
        Font font = new Font(18);
        Label inputLabel = new Label("Fahrenheit:");
        inputLabel.setFont(font);
        GridPane.setHalignment(inputLabel,HPos.RIGHT);

        Label outputLabel = new Label("Celsius");
        outputLabel.setFont(font);
        GridPane.setHalignment(outputLabel,HPos.RIGHT);

        result = new Label("---");
        result.setFont(font);
        GridPane.setHalignment(result, HPos.CENTER);

        fahrenheit = new TextField();
        fahrenheit.setFont(font);
        fahrenheit.setPrefWidth(70);
        fahrenheit.setAlignment(Pos.CENTER);
        fahrenheit.setOnAction(this::processReturn);

        setAlignment(Pos.CENTER);
        setHgap(20);
        setVgap(10);
        setStyle("-fx-background-color: yellow");

        add(inputLabel, 0, 0);
        add(fahrenheit, 1,0);
        add(outputLabel, 0, 1);
        add(result, 1, 1);
    }

    public void processReturn(ActionEvent event) {
        double fahrenheitTemp = Double.parseDouble(fahrenheit.getText());
        double celsiusTemp = (fahrenheitTemp - 32) * 5.0/9;
        result.setText(Math.round(celsiusTemp) + "");
    }

}
