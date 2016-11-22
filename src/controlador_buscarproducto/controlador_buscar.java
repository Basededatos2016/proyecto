package controlador_buscarproducto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 * Created by Evely on 21/11/2016.
 */
public class controlador_buscar implements Initializable {

    //@FXML private Button ventas;

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
}
