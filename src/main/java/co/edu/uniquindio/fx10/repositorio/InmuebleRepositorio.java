package co.edu.uniquindio.fx10.repositorio;

import co.edu.uniquindio.fx10.modelo.Inmueble;
import co.edu.uniquindio.fx10.modelo.Inmueble;

import java.util.ArrayList;

public class InmuebleRepositorio {
    private static InmuebleRepositorio instancia;
    private ArrayList<Inmueble> inmuebles;

    private InmuebleRepositorio() {
        inmuebles = new ArrayList<>();
        cargarDatosEjemplo();
    }

    public static InmuebleRepositorio getInstancia() {
        if (instancia == null) {
            instancia = new InmuebleRepositorio();
        }
        return instancia;
    }

    private void cargarDatosEjemplo() {
        inmuebles.add(new Inmueble("Casa", "Armenia", "4", "2", "20000000"));
        inmuebles.add(new Inmueble("Finca", "choco", "1", "1", "10000000"));
        inmuebles.add(new Inmueble("apto", "Medellin", "2", "1", "10000000"));
    }

    public Inmueble getInmuebles() {


        return null;
    }

    public void eliminarInmueble(Inmueble inmuebleSeleccionado) {

    }

    public void agregarInmueble(Inmueble nuevoInmueble) {
    }
}