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
 * @FXML     private TextField login_text_field;
 @FXML     private TextField pass_text_field;
 @FXML     private javafx.scene.control.Button boton_ingreso;
 @FXML     private javafx.scene.control.Button boton_salir;
 @FXML     private conexion_db db = new conexion_db(); //instancia la conexion a la base de datos.
 //@FXML private Connection con;
 @FXML     private boolean accede;
 @FXML     private int permiso;
 @FXML     private Pane pane;
 @FXML     private Stage stage;
 @FXML     private Label UsuarioIncorrecto;
 *
 */
/**
 * Created by sulpickb on 11/12/16.
 */
public class controlador_nuevoUsuario {

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

    @FXML    protected void handle_boton_guardar(ActionEvent event) throws IOException {
        try {
            Cedula = CedulaUsuario.getText();
            Nombre = NombreUsuario.getText();
            Apellido = ApellidoUsuario.getText();
            Telefono = TelefonoPrimero.getText() + "-" + TelefonoSegundo.getText();
            Direccion = DireccionUsuario.getText();
            Usuario = loginUsuario.getText();
            Contrasena = contrasenaUsuario.getText();

            String query = "INSERT INTO Persona (Cedula, Nombre, Apellido, Telefono, Direccion) " +
                    "VALUES ( '" + Cedula + "'"+ "'" + Nombre + "'" + Apellido + "'" + "'" +Telefono + "'" +
                    "'" + Direccion  +"'" + "'" + Usuario + "'" + "'" + Contrasena + "')" ;
            db.execute_query(query);


        } catch (Exception e){  /** Excepcion general **/

            e.printStackTrace();
        }


    }





}








