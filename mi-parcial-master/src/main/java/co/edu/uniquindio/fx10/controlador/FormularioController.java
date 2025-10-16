package co.edu.uniquindio.fx10.controlador;

import co.edu.uniquindio.fx10.modelo.Inmueble;
import co.edu.uniquindio.fx10.modelo.Inmueble;
import co.edu.uniquindio.fx10.repositorio.InmuebleRepositorio;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class FormularioController {

    @FXML
    private TextField txtTipo;

    @FXML
    private TextField txtCiudad;

    @FXML
    private TextField txtHabitaciones;

    @FXML
    private TextField txtPisos;

    @FXML
    private TextField txtPrecio;


    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnCancelar;
    private InmuebleRepositorio inmuebleRepositorio;
    private DashboardController dashboardController;
    private VBox contenedorPrincipal;

    @FXML
    public void initialize() {
        inmuebleRepositorio = InmuebleRepositorio.getInstancia();
    }
    public void setDashboardController(DashboardController dashboardController) {
        this.dashboardController = dashboardController;
        this.contenedorPrincipal = dashboardController.getContenedorPrincipal();
    }
    @FXML
    private void onGuardarInmueble() {
        if (!validarCampos()) {
            return;
        }

        try {
            String tipo = txtTipo.getText().trim();
            String ciudad = txtCiudad.getText().trim();
            String habitaciones = txtHabitaciones.getText().trim();
            String pisos = txtPisos.getText().trim();
            String precio = txtPrecio.getText().trim();


            Inmueble nuevoInmueble = new Inmueble(tipo, ciudad, habitaciones, pisos, precio);
            inmuebleRepositorio.agregarInmueble(nuevoInmueble);
            mostrarAlerta("Éxito", "Inmueble registrado correctamente", Alert.AlertType.INFORMATION);

            volverAlDashboard();
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El precio y stock deben ser valores numéricos válidos", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void onCancelar() {
        volverAlDashboard();
    }

    private void volverAlDashboard() {
        if (dashboardController != null) {
            dashboardController.cambiarVista("/co/edu/uniquindio/fx10/vista/Dashboard.fxml");
        } else {
            mostrarAlerta("Error", "No se pudo volver al dashboard (controlador no asignado)", Alert.AlertType.ERROR);
        }
    }

    private boolean validarCampos() {
        if (txtTipo.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "El tipo es obligatorio", Alert.AlertType.WARNING);
            return false;
        }
        if (txtHabitaciones.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "Las habitaciones son obligatorias", Alert.AlertType.WARNING);
            return false;
        }
        if (txtCiudad.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "La ciudad es obligatoria", Alert.AlertType.WARNING);
            return false;
        }
        if (txtPisos.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "Los pisos son obligatorios", Alert.AlertType.WARNING);
            return false;
        }
        if (txtPrecio.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "El precio es obligatorio", Alert.AlertType.WARNING);
            return false;

        }
        return true;
    }
    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}

