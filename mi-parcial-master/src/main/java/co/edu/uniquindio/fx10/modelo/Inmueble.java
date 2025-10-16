package co.edu.uniquindio.fx10.modelo;

public class Inmueble {
    private String tipo;
    private String ciudad;
    private String habitaciones;
    private String pisos;
    private String precio;
    public Inmueble() {
    }
    public Inmueble(String tipo, String ciudad, String habitaciones , String pisos, String precio) {
        this.tipo = tipo ;
        this.ciudad = ciudad;
        this.habitaciones = habitaciones;
        this.pisos = pisos;
        this.precio = precio;

    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getHabitaciones() {
        return habitaciones;
    }
    public void setHabitaciones(String habitaciones) {
        this.habitaciones = habitaciones;
    }
    public String getPisos() {return pisos;}
    public void setPisos(String pisos) {this.pisos = pisos;}
    public String getPrecio() {return precio;}
    public void setPrecio(String precio) {this.precio = precio;}

    @Override
    public String toString() {
        return "Producto{" +
                "tipo='" + tipo + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", habitaciones='" + habitaciones + '\'' +
                ", pisos='" + pisos + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }
}

