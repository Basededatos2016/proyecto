package conexionDB;

//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import Main.Main;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import controlador_ventas.controlador_ventas;
/**
 * Clase del cntrolador inicial de la aplicacion.
 */
public class main_controller_java implements Initializable
{

    /** aqui agrega cada uno de los controles que estan en la ventana **/
    @FXML private TextField login_text_field;
    @FXML private TextField pass_text_field;
    @FXML private javafx.scene.control.Button boton_ingreso;
    @FXML private javafx.scene.control.Button boton_salir;
    @FXML private conexion_db db = new conexion_db(); //instancia la conexion a la base de datos.
    //@FXML private Connection con;
    @FXML private boolean accede;
    @FXML private int permiso;
    @FXML private Pane pane;

    /**
     * Inicializa el controlador del JAVAFX que permite
     * iniciar sesión en la aplicacion
     * @param location ubicacion anteior JAVAFX
     * @param resources conjunto de recursos JAVAFX
     * @return
     */

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

        /** esta colocando valores de administrador por defecto */
        // todo temp setting to expedite login process.
        //this.user_text_field.setText("jose");  //doctor
        //this.user_text_field.setText("adm");   //admin
//        this.login_text_field.setText("admin");        //reception
 //       this.pass_text_field.setText("admin");
    }

    /**
     * Verificar si el usuario esta reguistrado en el sistem,
     * y mostrar la interfaz que corresponda segun el rol del usuario
     * @param event
     */


    //Accion del boton de iniciar sesion

    @FXML
    protected void handle_boton_ingreso_action(ActionEvent event)
    { //throws SQLException {
        try
        {
            accede = false;
            //System.out.println("clicked Entrar");
            //con = db.get_connection();
            //Statement st = con.createStatement();
            //ResultSet rs = st.executeQuery("select name,pass,rol from Person p, User u where p.id=u.id");
            ResultSet rs = db.execute_query("SELECT login, pass, permiso FROM Persona p, Vendedor v WHERE  p.cedula =v.cedula  AND  v.login =" + login_text_field + "v.contraseña= " + pass_text_field); /** ver que consulta se hara en esta parte */
            //COMO RECIBO INFORMACION DEL TEXT DEL JAVAFX.. LA IDEA ES CONECTAR LA VENTANA..

            //    ResultSet ps = st.executeQuery("select pass from User");


            while (rs.next()) /** mientras exista una proximafila*/
            {
                String login = rs.getString("login");
                String pass = rs.getString("contraseña");
                //int permiso = rs.getInt("permiso");

                System.out.println("login: " + login);
                //System.out.println("permiso " + permiso);



                if (login_text_field.getText().equals(login) && pass_text_field.getText().equals(pass))
                {
                    System.out.println("User name registered");
                    accede = true;
                    permiso = rs.getInt("permiso");   /** Tipo de usuario*/
                    System.out.println("El permiso del usuario es " + permiso);

                    //Stage stage = (Stage) user_text_field.getScene().getWindow();
                    //stage.close();
                    //Parent root = null;


                    if (permiso == 1)
                    {
                        try {

                            //root = FXMLLoader.load(getClass().getResource("/ui/reception_ui.fxml"));
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Ventanas/Ventas.fxml"));

                            Parent root = (Parent)fxmlLoader.load();

                            controlador_ventas controller = fxmlLoader.<controlador_ventas>getController();
                          //  controller.set_user_login(user_login);
                            controller.initialize();
                            //Scene scene = new Scene(root);

                            Main.primary_stage.setTitle("Claqueta tu tienda de cine");


                            pane.getChildren().setAll(root);

                            //Stage stage = (Stage) root.getScene().getWindow();
                            //stage.setScene(scene);
                            //stage.show();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //System.out.println("before stage");
                        //stage.setScene(new Scene(root, 600, 400));
                        //Scene scene =  new Scene(root);
                        //stage.setScene(scene);
                        //stage.show();
                    }

                    /**
                    else if (permiso == 2)
                    {
                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Ventanas/Ventas_Empleado.fxml"));

                            Parent root = (Parent)fxmlLoader.load();
                            controlador_ventas_empleado controller = fxmlLoader.<controlador_ventas_empleado>getController();
                            //controller.set_user_id(user_id);
                            controller.initialize(null, null);

                            Timer timer = new Timer();
                            TimerTask task = new TimerTask()
                            {
                                @Override
                                public void run()
                                {
                                    controller.handle_search_button_action(new ActionEvent());
                                    //System.out.println("TIMEEEER");
                                }
                            };

                            timer.schedule(task,0,1000);

                            Timeline time = new Timeline(new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>()
                            {
                                @Override
                                public void handle(ActionEvent event)
                                {
                                    controller.test();
                                }
                            }));

                            time.setCycleCount(Timeline.INDEFINITE);
                            //time.play();

                            Main.primary_stage.setTitle("Ventas Empleado | Galeno (C) 2016");

                            pane.getChildren().setAll(root);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else if (permiso == 3)
                    {
                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/admin_ui.fxml"));

                            Parent root = (Parent)fxmlLoader.load();
                            Admin_controller controller = fxmlLoader.<Admin_controller>getController();
                            controller.set_user_id(user_id);
                            //controller.initialize(null, null);

                            Main.primary_stage.setTitle("Admin | Galeno (C) 2016");


                            pane.getChildren().setAll(root);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } **/

                }
            }
//    Stage stage = (Stage) user_text_field.getScene().getWindow();
        } catch (SQLException err) {
            System.out.println(err);
        }
        //user_text_field.getText()
        //pass_text_field.getText()
    }

    @FXML    protected void handle_menu_item_exit_action(ActionEvent e)
    {
        System.exit(0);
    }

           }

