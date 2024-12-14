package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArregloPrestamo {
    private PrestacionLibro[] Prestamo;
    private int indice;
    private String[] cabecera = {"Fecha_Prestamo", "Fecha_Devolucion", "Cliente", "Libro", "Ejemplar", "Estado"};

    public ArregloPrestamo() {
        this.Prestamo = new PrestacionLibro[5];
        this.indice = 0;
    }

    public void AgregarPrestamo(PrestacionLibro Prestamo) {
        if (Prestamo != null && this.indice < this.Prestamo.length) {
            this.Prestamo[indice] = Prestamo;
            indice++;
        }
    }

    public PrestacionLibro BuscarPrestamo(Cliente cliente, Libro libro) {
        for (int i = 0; i < this.Prestamo.length; i++) {
            if (this.Prestamo[i] != null && this.Prestamo[i].getCliente().equals(cliente) && this.Prestamo[i].getLibro().equals(libro)) {
                return this.Prestamo[i];
            }
        }
        return null;
    }

    public boolean EliminarPrestamo(PrestacionLibro Prestamo) {
        boolean result = false;
        for (int i = 0; i < this.Prestamo.length; i++) {
            if (Prestamo != null && this.Prestamo[i] == Prestamo) {
                this.Prestamo[i] = null;
                result = true;
                return result;
            }
        }
        return result;
    }

    public void mostrarPrestamos() {
        for (PrestacionLibro prestacionLibro : Prestamo) {
            if (prestacionLibro != null) {
                System.out.println("");
                prestacionLibro.mostrarPrestacion();
            }
        }
    }

    public String[] getCabecera() {
        return cabecera;
    }

    public Object[][] getDatos() {
        Object[][] resultado = new Object[this.indice][6];
        int fila = 0;
        for (PrestacionLibro Prestamo : this.Prestamo) {
            if (Prestamo != null) {
                resultado[fila][0] = Prestamo.getFechaPrestamo();
                resultado[fila][1] = Prestamo.getFechaDevolucion();
                resultado[fila][2] = Prestamo.getCliente().getNombres();
                resultado[fila][3] = Prestamo.getLibro().getNombre();
                resultado[fila][4] = Prestamo.getEjemplar().getID_Ejemplar();
                resultado[fila][5] = Prestamo.getEstado();
                fila++;
            }
        }
        return resultado;
    }

    public void guardarPrestamosEnArchivo(String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (PrestacionLibro prestamo : this.Prestamo) {
                if (prestamo != null) {
                    writer.write(prestamo.getFechaPrestamo() + "," +
                                 prestamo.getFechaDevolucion() + "," +
                                 prestamo.getCliente().getNombres() + "," +
                                 prestamo.getCliente().getApellidos() + "," +
                                 prestamo.getCliente().getDNI() + "," +
                                 prestamo.getLibro().getNombre() + "," +
                                 prestamo.getEjemplar().getID_Ejemplar() + "," +
                                 prestamo.getEstado());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los préstamos en el archivo: " + e.getMessage());
        }
    }

    public void cargarPrestamosDesdeArchivo(String rutaArchivo, ArregloPersona personas, ArregloLibro libros) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 8) {
                    String fechaPrestamo = partes[0].trim();
                    String fechaDevolucion = partes[1].trim();
                    String nombreCliente = partes[2].trim();
                    String apellidosCliente = partes[3].trim();
                    String dniCliente = partes[4].trim();
                    String nombreLibro = partes[5].trim();
                    int idEjemplar = Integer.parseInt(partes[6].trim());
                    String estado = partes[7].trim();

                    Cliente cliente = (Cliente) personas.buscarPersona(dniCliente);
                    Libro libro = libros.buscarLibroPorNombre(nombreLibro);
                    Ejemplar ejemplar = libro != null ? libro.buscarEjemplarPorId(idEjemplar) : null;

                    if (cliente != null && libro != null && ejemplar != null) {
                        PrestacionLibro prestamo = new PrestacionLibro(fechaPrestamo, fechaDevolucion, libro, cliente, ejemplar);
                        prestamo.setEstado(estado);
                        this.AgregarPrestamo(prestamo);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los préstamos desde el archivo: " + e.getMessage());
        }
    }
}