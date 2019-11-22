import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BankAccountGUI extends Application {
    public void start(Stage stage) {
        Scene scene = new Scene(new BankAccountPane(), 1000, 400);

        stage.setTitle("Bank Account");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[]args) {
        launch(args);
    }
}
