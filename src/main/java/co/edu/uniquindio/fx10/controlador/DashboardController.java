package co.edu.uniquindio.fx10.controlador;

import co.edu.uniquindio.fx10.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class DashboardController {
    @FXML
    private VBox contenedorPrincipal;

    @FXML
    public void initialize() {

    }

    @FXML
    private void onCrearInmueble() throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/co/edu/uniquindio/fx10/vista/FormularioInmuebles.fxml"));
            Parent vista = loader.load();

            FormularioController controlador = loader.getController();
            controlador.setDashboardController(this);

            contenedorPrincipal.getChildren().clear();
            contenedorPrincipal.getChildren().add(vista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onVerListado() {
        cambiarVista("/co/edu/uniquindio/fx10/vista/ListadoInmuebles.fxml");
    }

    public void cambiarVista(String rutaFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(rutaFXML));
            Parent vista = loader.load();

            contenedorPrincipal.getChildren().clear();
            contenedorPrincipal.getChildren().add(vista);

        } catch (IOException e) {
            mostrarAlerta("Error", "No se pudo cargar la vista solicitada", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    public VBox getContenedorPrincipal() {
        return contenedorPrincipal;
    }
}


