package Controlador;

import java.net.URL;
import java.util.ResourceBundle;

import Main.Main;
import conexionDB.conexion_db;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * Created by Evely on 21/11/2016.
 */
public class controlador_buscar implements  Initializable{

    //@FXML private Button ventas;
   // @FXML     private conexion_db db = new conexion_db();
    @FXML     private Pane pane;


    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML protected void handle_boton_nuevoUsuario(ActionEvent event){
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Ventanas/CrearUsuario.fxml"));
            Parent root = fxmlLoader.load();
            controlador_nuevoUsuario controller = fxmlLoader.<controlador_nuevoUsuario>getController();

            Main.primary_stage.setTitle("Crear usuario nuevo");
            pane.getChildren().setAll(root);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }


    @FXML protected void handle_boton_busqueda(ActionEvent event){
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Ventanas/BuscarProducto.fxml"));
            Parent root = fxmlLoader.load();
            controlador_buscar controller = fxmlLoader.<controlador_buscar>getController();

            Main.primary_stage.setTitle("Busqueda de Productos");
            pane.getChildren().setAll(root);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    @FXML protected void handle_botonReporte(ActionEvent event){
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Ventanas/Reportes.fxml"));
            Parent root = fxmlLoader.load();
            controlador_reporte controller = fxmlLoader.<controlador_reporte>getController();
            Main.primary_stage.setTitle("Reportes de Productos");
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
            Main.primary_stage.setTitle("Inventario de Productos");
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
            Main.primary_stage.setTitle("Cambio de Productos");
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
            Main.primary_stage.setTitle("Cambio de Productos");
            pane.getChildren().setAll(root);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }



    /**
    @FXML
    void Mostrar_Inventario() throws Exception {

        Stage primary_stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Ventanas/inventario.fxml"));
        primary_stage.setTitle("Inventario");
        primary_stage.setScene(new Scene(root, 630 , 640));
        primary_stage.show();

    }

    @FXML
    void Mostrar_CrearUsuario() throws Exception {

        Stage primary_stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Ventanas/CrearUsuario.fxml"));
        primary_stage.setTitle("Crear usuario");
        primary_stage.setScene(new Scene(root, 630 , 640));
        primary_stage.show();

    }


    @FXML
    void Mostrar_Cambios() throws Exception {

        Stage primary_stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Ventanas/Cambios.fxml"));
        primary_stage.setTitle("Cambios");
        primary_stage.setScene(new Scene(root, 630 , 640));
        primary_stage.show();

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    **/
}
