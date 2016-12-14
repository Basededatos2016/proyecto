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
import Producto.Producto;
import javafx.scene.control.TextArea;
import sun.reflect.generics.tree.Tree;

import javax.management.Query;


/**
 * Created by sulpickb on 12/12/16.
 */
public class controlador_ventas implements Initializable  {


     @FXML     private Pane pane;
     @FXML     private Label UsuarioIncorrecto;
     @FXML     private TextField agregar_pelicula;
     @FXML     private conexion_db db = new conexion_db();
     @FXML     private TextArea ventas;
     @FXML     private Label total1;


    public void initialize(URL location, ResourceBundle resources) {

        ventas.setEditable(false);

    }


    @ FXML protected void boton_facturar(ActionEvent event){



    }


    @FXML protected void boton_agregar(ActionEvent event){

        try {

            Producto producto = new Producto();
            String codigo_peli = agregar_pelicula.getText();
            int codigo = Integer.parseInt(codigo_peli);

            String query= "SELECT Producto.Nombre ," +  "Producto.Precio " + " FROM Producto " + " WHERE Producto.Id_Producto = " + "'" + codigo + "'";
            ResultSet rs = db.execute_query(query);

            if(rs.next()) {

                Float precio = rs.getFloat("Precio");
                String nombre = rs.getString("Nombre");
                producto.setNombre(nombre);
                producto.setPrecio(precio);

                // va agregando valores en la lista
                ventas.appendText(producto.get_Nombre() + "                    " + producto.getPrecio() + "Bs.F" + "\n");
            }

            //limpio el textfield
            agregar_pelicula.clear();

            //sumo precio

            String totalAnterior = total1.getText();
            Float acumulado = Float.parseFloat(totalAnterior);
            Float total_actual = producto.getPrecio() + acumulado;
            total1.setText(total_actual.toString());

        }
                catch(Exception e){
            e.printStackTrace();
        }

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






