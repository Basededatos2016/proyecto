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

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import conexionDB.conexion_db;

import javax.swing.*;



/**
 * Created by Evely on 21/11/2016.
 */
public class controlador_buscar implements  Initializable {

    //@FXML private Button ventas;
    @FXML
    private conexion_db db = new conexion_db();
    @FXML
    private Pane pane;
    @FXML
    private Button ventas;
    @FXML
    private Button limpiar;
    @FXML
    private ComboBox TipoProducto;
    @FXML
    private TextField nombre;
    @FXML
    private TextField anio;
    @FXML
    private TextField temp;
    @FXML
    private TextField precio;
    @FXML
    private TextField idioma;
    @FXML
    private TextField duracion;
    @FXML
    private TextField director;
    @FXML
    private TextField nexistencias;
    @FXML
    private TextField genero;
    @FXML
    private TextField ncap;


    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void Seleccionar_Producto() throws Exception {

        if (TipoProducto.getValue() == TipoProducto.getItems().get(0)) {
            temp.setEditable(false);
            precio.setEditable(false);
            idioma.setEditable(false);
            duracion.setEditable(false);
            director.setEditable(false);
            nexistencias.setEditable(false);
            genero.setEditable(false);
            ncap.setEditable(false);
            anio.setEditable(true);

        } else {
            if (TipoProducto.getValue() == TipoProducto.getItems().get(1)) {
                anio.setEditable(false);
                precio.setEditable(false);
                idioma.setEditable(false);
                duracion.setEditable(false);
                director.setEditable(false);
                nexistencias.setEditable(false);
                genero.setEditable(false);
                ncap.setEditable(false);
                temp.setEditable(true);
            }
        }


    }

    @FXML    void Buscar() {

        //populate doctors combo box from DB

        precio.setEditable(false);
        idioma.setEditable(false);
        duracion.setEditable(false);
        director.setEditable(false);
        nexistencias.setEditable(false);
        genero.setEditable(false);
        ncap.setEditable(false);

        String nomb = nombre.getText();
        String Temp = temp.getText();
        String Annio = anio.getText();

        if (TipoProducto.getValue() == TipoProducto.getItems().get(0)) {

            String q = "SELECT p.Nombre, p.Anio, p.Precio, p.Existencia, p.Genero, ip.Idioma, peli.Duracion, peli.Director FROM Producto p JOIN Pelicula peli ON p.Id_Producto = peli.Id_pelicula " +
                    " JOIN Idioma_Producto idp ON idp.Id_Producto = p.Id_Producto " +
                    " JOIN iProducto ip ON ip.Id_idioma = idp.Id_idioma " +
                    " WHERE p.Nombre = '" + nomb + "' AND " +
                    "p.Anio = '" + Annio + "'";
            ResultSet rs = db.execute_query(q);


            try {
                while (rs.next()) {

                    idioma.setText(rs.getString("Idioma"));
                    System.out.println(idioma.getText());


                    precio.setText(rs.getString("Precio"));
                    director.setText(rs.getString("Director"));
                    duracion.setText(rs.getString("Duracion"));
                    nexistencias.setText(rs.getString("Existencia"));
                    genero.setText(rs.getString("Genero"));
                    anio.setText(rs.getString("Anio"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            if (TipoProducto.getValue() == TipoProducto.getItems().get(1)) {
                String q = "SELECT p.Nombre, p.Anio, p.Precio, p.Existencia, p.Genero, ip.Idioma, s.N_cap, s.N_temporadas FROM Producto p JOIN Serie s ON p.Id_Producto = s.Id_serie " +
                        " JOIN idioma_producto idp ON idp.Id_Producto = p.Id_Producto " +
                        " JOIN iproducto ip ON ip.Id_idioma = idp.Id_idioma " +
                        " WHERE p.Nombre = '" + nomb + "' AND " +
                        "s.N_temporadas = '" + Temp + "'";

                ResultSet rs = db.execute_query(q);

                try {
                    while (rs.next()) {

                        idioma.setText(rs.getString("Idioma"));
                        precio.setText(rs.getString("Precio"));
                        //director.setText(rs.getString("Director"));
                        //duracion.setText(rs.getString("Duracion"));
                        nexistencias.setText(rs.getString("Existencia"));
                        genero.setText(rs.getString("Genero"));
                        anio.setText(rs.getString("Anio"));
                        ncap.setText(rs.getString("N_cap"));

                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @FXML  void Limpiar() throws Exception {
        ncap.clear();
        nombre.clear();
        temp.clear();
        anio.clear();
        precio.clear();
        idioma.clear();
        duracion.clear();
        director.clear();
        nexistencias.clear();
        genero.clear();

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

}
