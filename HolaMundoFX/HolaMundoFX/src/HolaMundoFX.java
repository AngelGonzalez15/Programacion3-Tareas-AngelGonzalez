import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HolaMundoFX extends Application {
    public static void main(String[] args){
       launch(args);
    }

    @Override
    public void start(javafx.stage.Stage primaryStage) throws Exception {
        
       Label label = new Label("Hola Mundo");

        Button boton = new Button("Saludar");
        boton.setOnAction(e -> label.setText("¡Hola, JEAN!"));

        VBox root = new VBox(label, boton);

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Hola Mundo FX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
