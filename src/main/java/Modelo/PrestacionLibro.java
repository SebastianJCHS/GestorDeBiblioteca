package Modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PrestacionLibro {
    private String fechaPrestamo;
    private String fechaDevolucion;
    private Cliente cliente;
    private Libro libro;
    private Ejemplar ejemplar;
    private String estado;

    public PrestacionLibro(String fechaPrestamo, String fechaDevolucion, Libro libro, Cliente cliente, Ejemplar ejemplar) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.libro = libro;
        this.cliente = cliente;
        this.ejemplar = ejemplar;
        this.estado = "prestado";
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

    public boolean solicitarPrestamo() {
        if (ejemplar.getEstado().equalsIgnoreCase("disponible")) {
            ejemplar.setEstado("prestado");
            return true;
        }
        return false;
    }
    
    public boolean DevolverLibro() {
        if (ejemplar.getEstado().equalsIgnoreCase("prestado")) {
            ejemplar.setEstado("disponible");
            return true;
        }
        return false;
    }

    public void guardarPrestamoEnArchivo(String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            writer.write(cliente.getNombres() + "," +
                         cliente.getApellidos() + "," +
                         cliente.getDNI() + "," +
                         libro.getNombre() + "," +
                         ejemplar.getID_Ejemplar() + "," +
                         fechaPrestamo + "," +
                         fechaDevolucion + "," +
                         estado);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar el préstamo en el archivo: " + e.getMessage());
        }
    }

    public void mostrarPrestacion() {
        System.out.println("Cliente: " + cliente.getNombres() + " " + cliente.getApellidos());
        System.out.println("Libro: " + libro.getNombre());
        System.out.println("Ejemplar: " + ejemplar.getID_Ejemplar());
        System.out.println("Fecha de Préstamo: " + fechaPrestamo);
        System.out.println("Fecha de Devolución: " + fechaDevolucion);
        System.out.println("Estado: " + estado);
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

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "PrestacionLibro{" + "fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion + ", cliente=" + cliente + ", libro=" + libro + ", ejemplar=" + ejemplar + ", estado=" + estado + '}';
    }
    
}
