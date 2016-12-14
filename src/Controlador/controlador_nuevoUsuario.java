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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TabPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by sulpickb on 11/12/16.
 */
public class controlador_nuevoUsuario implements Initializable  {

    @FXML     private TabPane creaUsuario;
    @FXML     private TextField CedulaUsuario;
    @FXML     private TextField TelefonoPrimero;
    @FXML     private TextField TelefonoSegundo;
    @FXML     private TextField NombreUsuario;
    @FXML     private TextField ApellidoUsuario;
    @FXML     private TextField DireccionUsuario;
    @FXML     private TextField loginUsuario;
    @FXML     private TextField contrasenaUsuario;
    @FXML     private String Nombre;
    @FXML     private String Apellido;
    @FXML     private String Telefono;
    @FXML     private String Direccion;
    @FXML     private String Usuario;
    @FXML     private String Contrasena;
    @FXML     private String Cedula;
    @FXML     private conexion_db db = new conexion_db();
    @FXML     private Pane pane;
    @FXML     private ComboBox lista;
    @FXML     private String tipoCedula;


    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<String> type_list = FXCollections.observableArrayList("V","E");

        this.lista.getItems().clear();
        this.lista.setItems(type_list);
        this.lista.getSelectionModel().selectFirst();


    }


    @FXML protected void combo_cedula(ActionEvent event){

          }


    @FXML protected void handle_boton_guardar(ActionEvent event){
        try {

            tipoCedula = lista.getSelectionModel().getSelectedItem().toString();
            Cedula = tipoCedula + "-"+ CedulaUsuario.getText();
            Nombre = NombreUsuario.getText();
            Apellido = ApellidoUsuario.getText();
            Telefono = TelefonoPrimero.getText() + TelefonoSegundo.getText();
            Direccion = DireccionUsuario.getText();
            Usuario = loginUsuario.getText();
            Contrasena = contrasenaUsuario.getText();


            String query = "INSERT INTO Persona (Cedula, Nombre, Apellido, Telefono, Direccion)" +
                "VALUES('" + Cedula + "'" + ",'" + Nombre + "'" + ",'" + Apellido + "'" + ",'" +Telefono + "'" +
                ",'" + Direccion  +"')" ;

            db.execute_update(query);


        }
        catch(Exception e){
            e.printStackTrace();
        }

    }


    @FXML protected void handle_boton_nuevoUsuario(ActionEvent event){
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Ventanas/PruebaUsuario.fxml"));
            Parent root = fxmlLoader.load();
            controlador_nuevoUsuario controller = fxmlLoader.<controlador_nuevoUsuario>getController();

            Main.primary_stage.setTitle("Claqueta tu tienda de cine");
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

            Main.primary_stage.setTitle("Busqueda de Productos en Claqueta");
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
            Main.primary_stage.setTitle("Reportes de Productos en Claqueta");
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
            Main.primary_stage.setTitle("Inventario de Productos en Claqueta");
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
            Main.primary_stage.setTitle("Cambio de Productos en Claqueta");
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
            Main.primary_stage.setTitle("Nuevo usuario en Claqueta");
            pane.getChildren().setAll(root);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }





}








