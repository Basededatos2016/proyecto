package Controlador;

import conexionDB.conexion_db;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.AnchorPane;
import Main.Main;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.AcceptPendingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.control.Label;


/**
 * Created by sulpickb on 12/12/16.
 */
public class controlador_ventas {



     @FXML     private javafx.scene.control.Button botonNuevoUsuario;
     @FXML     private javafx.scene.control.Button boton_salir;
     @FXML     private conexion_db db = new conexion_db(); //instancia la conexion a la base de datos.
     @FXML     private boolean accede;
     @FXML     private int permiso;
     @FXML     private Pane pane;
     @FXML     private Stage stage;
     @FXML     private Label UsuarioIncorrecto;


    /** Muestra la ventana para la creacion del usuario **/

    @FXML protected void handle_boton_NuevoUsuario(ActionEvent event){
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Ventanas/CrearUsuario.fxml"));
            Parent root = fxmlLoader.load();
            controlador_nuevoUsuario controller = fxmlLoader.<controlador_nuevoUsuario>getController();

            Main.primary_stage.setTitle("Claqueta tu tienda de cine");
            Main.primary_stage.setScene(new Scene(root, 800, 680));
            pane.getChildren().setAll(root);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }


    @FXML protected void handle_boton_salir(ActionEvent event) {
        System.exit(0);
    }

    @FXML protected void handle_boton_busqueda(ActionEvent event){
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Ventanas/BuscarProducto.fxml"));
            Parent root = fxmlLoader.load();
            controlador_buscar controller = fxmlLoader.<controlador_buscar>getController();

            Main.primary_stage.setTitle("Busqueda de Productos");
            Main.primary_stage.setScene(new Scene(root, 800, 680));
            pane.getChildren().setAll(root);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }


    //Parent root = FXMLLoader.load(getClass().getResource("../Ventanas/CrearUsuario.fxml"));
    //primary_stage.setTitle("Crear usuario");
    //primary_stage.setScene(new Scene(root, 630 , 640));
    //primary_stage.show();

        /**
         * try {

         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Ventanas/Ventas.fxml"));
         Parent root = fxmlLoader.load();
         controlador_ventas controller = fxmlLoader.<controlador_ventas>getController();


         Main.primary_stage.setTitle("Claqueta tu tienda de cine");
         Main.primary_stage.setScene(new Scene(root, 1000 , 680));
         pane.getChildren().setAll(root);


         } catch (IOException e) {
         e.printStackTrace();
         *
         */

    }





