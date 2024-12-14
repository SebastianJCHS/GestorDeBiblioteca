package Modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PrestacionLibro {
    private String fechaPrestamo;
    private String fechaDevolucion;
    private Cliente cliente;
    private Libro libro;
    private Multa multa;

    public PrestacionLibro(String fechaPrestamo, String fechaDevolucion,Libro libro, Cliente cliente) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.libro=libro;
        this.cliente = cliente;
        this.multa = null;
    }

    public PrestacionLibro() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean estaPendiente() {
        try {
            LocalDate fechaDevol = LocalDate.parse(fechaDevolucion, DateTimeFormatter.ISO_DATE);
            LocalDate fechaActual = LocalDate.now();
            return fechaActual.isAfter(fechaDevol);
        } catch (Exception e) {
            return false;
        }
    }

    public void generarMulta() {
        if (estaPendiente() && multa == null) {
            float montoMulta = calcularMontoMulta();
            this.multa = new Multa(montoMulta, cliente, "pendiente");
        }
    }

    private float calcularMontoMulta() {
        LocalDate fechaDevol = LocalDate.parse(fechaDevolucion, DateTimeFormatter.ISO_DATE);
        LocalDate fechaActual = LocalDate.now();
        long diasRetraso = fechaActual.toEpochDay() - fechaDevol.toEpochDay();
        return diasRetraso * 10.0f;
    }

    public boolean solicitarPrestamo() {
            boolean result=false;
            if (libro.hayEjemplaresDisponibles()) {
                libro.cambiarEstadoEjemplarDisponibleAPrestado();
                result= true; 
            } 
            return result;
    }
    
    public void mostrarPrestacion (){
        System.out.println(cliente);
        libro.mostrarLibroyEjemplares();
    }

    public Multa getMulta() {
        return multa;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
    
}
