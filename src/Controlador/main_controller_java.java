package Controlador;

//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
import conexionDB.conexion_db;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.AnchorPane;
import Main.Main;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Clase del cntrolador inicial de la aplicacion.
 */
public class main_controller_java implements Initializable {

    /**
     * aqui agrega cada uno de los controles que estan en la ventana
     **/
    @FXML     private TextField login_text_field;
    @FXML     private TextField pass_text_field;
    @FXML     private javafx.scene.control.Button boton_ingreso;
    @FXML     private javafx.scene.control.Button boton_salir;
    @FXML     private conexion_db db = new conexion_db(); //instancia la conexion a la base de datos.
    //@FXML private Connection con;
    @FXML     private boolean accede;
    @FXML     private int permiso;
    @FXML     private Pane panel;
    @FXML     private Stage stage;

    /**
     * Inicializa el controlador del JAVAFX que permite
     * iniciar sesión en la aplicacion
     *
     * @param location  ubicacion anteior JAVAFX
     * @param resources conjunto de recursos JAVAFX
     * @return
     */

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /** esta colocando valores de administrador por defecto */
        // todo temp setting to expedite login process.
        //this.user_text_field.setText("jose");  //doctor
        //this.user_text_field.setText("adm");   //admin
//
        // this.login_text_field.setText("sulpick");        //reception
        //this.pass_text_field.setText("hola");
    }

    /**
     * Verificar si el usuario esta reguistrado en el sistem,
     * y mostrar la interfaz que corresponda segun el rol del usuario
     *
     * @param event
     */


    //Accion del boton de iniciar sesion
    @FXML
    protected void handle_boton_ingreso_action(ActionEvent event) { //throws SQLException {
        try {

            accede = false;
            System.out.println("clicked Entrar");

            ResultSet rs = db.execute_query("SELECT Login, Contrasena, Permisos FROM Vendedor");
 /*
            String name = rs.getString("Login");
            String pass = rs.getString("Contrasena");
            permiso = rs.getInt("Permisos");
            System.out.println(name + " " + pass + " " + permiso);
*/

            while (rs.next()) {
                System.out.println("PRUEBA");

                String name = rs.getString("Login");
                //System.out.println(name);
                String pass = rs.getString("Contrasena");
                //System.out.println(pass);
                permiso = rs.getInt("Permisos");
                //System.out.println(permiso);

                //System.out.println(login_text_field.getText());


                if (login_text_field.getText().equals(name) && pass_text_field.getText().equals(pass)) {

                    System.out.println("User name registered");
                    accede = true;
                    permiso = (rs.getInt("Permisos"));

                    if (permiso == 1) {
                        System.out.println(" Entro sulpick al sistema ");

                        try {

                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Ventanas/Ventas2.fxml"));
                            System.out.println(" 6 ");
                            Parent root = fxmlLoader.load();
                            System.out.println(" 6 ");
                            controlador_ventas controller = fxmlLoader.<controlador_ventas>getController();
                            controller.initialize();

                            Main.primary_stage.setTitle("Claqueta tu tienda de cine");

                            //panel.autosize();
                            panel.getChildren().setAll(root);
                            System.out.println(" 9 ");


                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (permiso == 2) {
                        try {

                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(".../Ventanas/Ventas2.fxml"));
                            Parent root = (Parent)fxmlLoader.load();
                            controlador_ventas controller = fxmlLoader.<controlador_ventas>getController();
                            //controller.set_user_login(user_login);
                            controller.initialize();


                            Main.primary_stage.setTitle("Claqueta tu tienda de cine");
                            //panel.getChildren().setAll(root);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }


                }
            }
        } catch (SQLException err) {
            System.out.println(err);
        }
    }


    @FXML
    protected void handle_menu_item_exit_action(ActionEvent e) {
        System.exit(0);
    }

    @FXML
    protected void handle_boton_salir_action(ActionEvent event) {
        System.exit(0);
    }

}