package co.edu.uniquindio.fx10.repositorio;

import co.edu.uniquindio.fx10.modelo.Inmueble;
import java.util.ArrayList;
import java.util.List;

public class InmuebleRepositorio {
    private static InmuebleRepositorio instancia;
    private final List<Inmueble> listaInmuebles;

    private InmuebleRepositorio() {
        listaInmuebles = new ArrayList<>();
    }

    public static InmuebleRepositorio getInstancia() {
        if (instancia == null) {
            instancia = new InmuebleRepositorio();
        }
        return instancia;
    }

    public void agregarInmueble(Inmueble inmueble) {
        listaInmuebles.add(inmueble);
    }

    public void eliminarInmueble(Inmueble inmueble) {
        listaInmuebles.remove(inmueble);
    }

    public List<Inmueble> getInmuebles() {
        return listaInmuebles;
    }
}
