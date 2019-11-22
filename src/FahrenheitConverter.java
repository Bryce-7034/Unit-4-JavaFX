import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FahrenheitConverter extends Application {
    public void start(Stage stage) {
        Scene scene = new Scene(new FahrenheitPane(), 300, 150);

        stage.setTitle("Fahrenheit Converter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[]args) {
        launch(args);
    }
}
