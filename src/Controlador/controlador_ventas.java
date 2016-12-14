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
public class controlador_ventas implements Initializable  {


     @FXML     private Pane pane;
     @FXML     private Label UsuarioIncorrecto;
     @FXML     private TextField agregar_pelicula;



    public void initialize(URL location, ResourceBundle resources) {

    }


    @ FXML protected void boton_facturar(ActionEvent event){



    }


    @FXML protected void boton_agregar(ActionEvent event){



    }


    /** Muestra la ventana para la creacion del usuario **/

    @FXML protected void handle_boton_NuevoUsuario(ActionEvent event){
        try {

            //Pane mainPane = FXMLLoader.load(getClass().getResource("../Ventanas/CrearUsuario.fxml"));


            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Ventanas/CrearUsuario.fxml"));

            Parent root = (Parent)fxmlLoader.load();
            controlador_nuevoUsuario controller = fxmlLoader.<controlador_nuevoUsuario>getController();
            controller.initialize(null, null);
            Main.primary_stage.setTitle("Area de Usuarios | Claqueta tu tienda de cine");
            pane.getChildren().setAll(root);


        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    @FXML protected void boton_salir(ActionEvent event)
        {
            System.exit(0);
        }


    @FXML protected void handle_boton_busqueda(ActionEvent event){
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Ventanas/BuscarProducto.fxml"));
            Parent root = (Parent)fxmlLoader.load();
            controlador_buscar controller = fxmlLoader.<controlador_buscar>getController();
            controller.initialize(null, null);

            Main.primary_stage.setTitle("Busqueda de productos | Claqueta tu tienda de cine");
            pane.getChildren().setAll(root);


        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    @FXML protected void handle_boton_reporte(ActionEvent event){
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Ventanas/Reportes.fxml"));
            Parent root = fxmlLoader.load();
            controlador_reporte controller = fxmlLoader.<controlador_reporte>getController();
            Main.primary_stage.setTitle("Reporte de ventas | Claqueta tu tienda de cine");
            pane.getChildren().setAll(root);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    @FXML protected void handle_boton_inventario(ActionEvent event){
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Ventanas/inventario.fxml"));
            Parent root = fxmlLoader.load();
            controlador_inventario controller = fxmlLoader.<controlador_inventario>getController();
            Main.primary_stage.setTitle("Inventario de productos | Claqueta tu tienda de cine");
            pane.getChildren().setAll(root);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }


    @FXML protected void handle_boton_cambios(ActionEvent event){
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Ventanas/Cambios.fxml"));
            Parent root = fxmlLoader.load();
            controlador_cambios controller = fxmlLoader.<controlador_cambios>getController();
            Main.primary_stage.setTitle("Cambio de productos | Claqueta tu tienda de cine");
            pane.getChildren().setAll(root);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }


    @FXML protected void handle_boton_ventas(ActionEvent event){
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Ventanas/Ventas.fxml"));
            Parent root = fxmlLoader.load();
            controlador_ventas controller = fxmlLoader.<controlador_ventas>getController();
            Main.primary_stage.setTitle("Ventas | Claqueta tu tienda de cine");
            pane.getChildren().setAll(root);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }


}






