package controlador_ventas;

/**
 * Created by Usuario on 17/11/2016.
 */

import java.net.URL;
        import java.util.ResourceBundle;
        import javafx.fxml.FXML;
        import javafx.scene.layout.AnchorPane;


public class controlador_ventas {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane ventana_ventas;


    @FXML
    public void initialize() {
        assert ventana_ventas != null : "fx:id=\"ventana_ventas\" was not injected: check your FXML file 'Ventas.fxml'.";


    }

}