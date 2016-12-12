package Controlador;

/**
 * Created by Usuario on 17/11/2016.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

import conexionDB.conexion_db;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.AnchorPane;
import Main.Main;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.control.Label;


public class controlador_ventas implements Initializable {

    @FXML    private ResourceBundle resources;

    @FXML     private URL location;

    @FXML     private AnchorPane ventana_ventas;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }



}