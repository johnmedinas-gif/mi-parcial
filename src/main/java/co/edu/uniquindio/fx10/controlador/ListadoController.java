package co.edu.uniquindio.fx10.controlador;

import co.edu.uniquindio.fx10.App;
import co.edu.uniquindio.fx10.modelo.Inmueble;
import co.edu.uniquindio.fx10.modelo.Inmueble;
import co.edu.uniquindio.fx10.repositorio.InmuebleRepositorio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;

public class ListadoController {

    @FXML
    private VBox contenedorPrincipal;

    @FXML
    private Label lblTitulo;

    @FXML
    private TableView<Inmueble> tablaInmuebles;

    @FXML
    private TableColumn<Inmueble, String> colTipo;

    @FXML
    private TableColumn<Inmueble, String> colCiudad;

    @FXML
    private TableColumn<Inmueble, String> colHabitaciones;

    @FXML
    private TableColumn<Inmueble, String> colPisos;

    @FXML
    private TableColumn<Inmueble, String> colPrecio;


    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnVolver;

    private InmuebleRepositorio inmuebleRepositorio;
    private ObservableList<Inmueble> listaInmuebles;

    @FXML
    public void initialize() {
        inmuebleRepositorio = InmuebleRepositorio.getInstancia();
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colCiudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        colHabitaciones.setCellValueFactory(new PropertyValueFactory<>("habitaciones"));
        colPisos.setCellValueFactory(new PropertyValueFactory<>("pisos"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        cargarInmuebles();
    }

    public void cargarInmuebles() {
        listaInmuebles = FXCollections.observableArrayList(inmuebleRepositorio.getInmuebles());
        tablaInmuebles.setItems(listaInmuebles);
    }

    @FXML
    private void onEliminarInmueble() {
        Inmueble inmuebleSeleccionado = tablaInmuebles.getSelectionModel().getSelectedItem();
        if (inmuebleSeleccionado == null) {
            mostrarAlerta("Advertencia", "Por favor seleccione un inmueble para eliminar", Alert.AlertType.WARNING);
            return;
        }

        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmar eliminación");
        confirmacion.setHeaderText("¿Está seguro de eliminar el inmueble?");
        confirmacion.setContentText("Moto: " + inmuebleSeleccionado.getCiudad());

        confirmacion.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                inmuebleRepositorio.eliminarInmueble(inmuebleSeleccionado);
                cargarInmuebles();
                mostrarAlerta("Éxito", "Inmueble eliminado correctamente", Alert.AlertType.INFORMATION);
            }
        });
    }

    @FXML
    private void onVolver() {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/co/edu/uniquindio/fx10/vista/Dashboard.fxml"));
            Parent dashboard = loader.load();
            Stage stage = (Stage) contenedorPrincipal.getScene().getWindow();
            double ancho = stage.getWidth();
            double alto = stage.getHeight();
            Scene escena = new Scene(dashboard);
            stage.setScene(escena);
            stage.setWidth(ancho);
            stage.setHeight(alto);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo volver al Dashboard", Alert.AlertType.ERROR);
        }
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}