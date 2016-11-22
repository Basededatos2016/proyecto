
package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** esto llama a la ventana principal del inicio de sesion **/

public class Main extends Application {

    public static Stage primary_stage;

    @Override
    public void start(Stage primaryStage) throws Exception
    {

        Parent root = FXMLLoader.load(getClass().getResource("../Ventanas/BuscarProducto.fxml"));
        primaryStage.setTitle("Claqueta tu tienda de cine");
        primaryStage.setScene(new Scene(root, 630 , 640));
        primaryStage.show();
        primary_stage = primaryStage;

    }


    public static void main(String[] args) {
        launch(args);
    }

}
