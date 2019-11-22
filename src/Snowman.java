import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;



public class Snowman extends Application
{
    public void start(Stage stage) {
        Ellipse base = new Ellipse(80, 210, 80, 60);
        base.setFill(Color.WHITE);
        
        Ellipse middle = new Ellipse(80, 130, 50, 40);
        middle.setFill(Color.WHITE);
        
        Circle head = new Circle(80, 70, 30);
        head.setFill(Color.WHITE);
        
        Line leftArm = new Line(110, 130, 160, 130);
        leftArm.setStrokeWidth(3);
        Line rightArm = new Line(50, 130, 0, 100);
        rightArm.setStrokeWidth(3);
        
        Rectangle stovepipe = new Rectangle(60, 0, 40, 50);
        Rectangle brim = new Rectangle(50, 45, 60, 5);
        
        Group hat = new Group(stovepipe, brim);
        hat.setTranslateX(10);
        hat.setRotate(15);
        
        Group snowman = new Group(base, middle, head, leftArm, rightArm, hat);
        snowman.setTranslateX(170);
        snowman.setTranslateY(50);
        
        Rectangle ground = new Rectangle(0, 250, 500, 100);
        ground.setFill(Color.STEELBLUE);
        
        Group root = new Group(ground, snowman);
        Scene scene = new Scene(root, 500, 350, Color.LIGHTBLUE);
        
        stage.setTitle("Snowman");
        stage.setScene(scene);
        stage.show();
        
    }
    
    public static void main(String[] args){
        launch(args);
    }
}
