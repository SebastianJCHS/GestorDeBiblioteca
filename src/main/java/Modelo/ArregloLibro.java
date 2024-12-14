package Modelo;

import Interfaces.Interface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class ArregloLibro implements Interface {
    private Libro[] libros;
    private int capacidad, indice;
    private String[] cabecera = {"Nombre", "Autor", "Editorial", "Genero", "Fecha de Publicacion", "Nro_Ejemplares"};

    public ArregloLibro() {
        this.capacidad = 50;
        this.libros = new Libro[capacidad];
        this.indice = 0;
    }

    public void agregarLibro(Libro libro) {
        if (this.indice == this.libros.length) {
            aumentar();  // Si el arreglo está lleno, aumentamos la capacidad
        }
        this.libros[indice] = libro;
        indice++;
    }

    public void eliminarLibro(int IdEjemplar) {
        for (int i = 0; i < this.libros.length; i++) {
            if (this.libros[i] != null && this.libros[i].buscarLibroporIdEjemplar(IdEjemplar)) {
                this.libros[i] = null;
                return;
            }
        }
    }

    public Libro buscarLibroPorNombre(String nombre) {
        for (Libro libro : libros) {
            if (libro != null && libro.getNombre().equalsIgnoreCase(nombre)) {
                return libro; // Retorna el libro si lo encuentra
            }
        }
        return null; // Retorna null si no se encuentra el libro
    }

    public void cambiarEstadoDisponible(int IdEjemplar) {
        for (int i = 0; i < this.libros.length; i++) {
            if (this.libros[i] != null && this.libros[i].buscarLibroporIdEjemplar(IdEjemplar)) {
                this.libros[i].cambiarDisponible(IdEjemplar);
            }
        }
    }

    public void cambiarEstadoPrestado(int IdEjemplar) {
        for (int i = 0; i < this.libros.length; i++) {
            if (this.libros[i] != null && this.libros[i].buscarLibroporIdEjemplar(IdEjemplar)) {
                this.libros[i].cambiarPrestado(IdEjemplar);
            }
        }
    }

    public void mostrarLibros() {
        for (Libro libro : libros) {
            if (libro != null) {  // Verificar si el elemento no es null
                libro.mostrarLibroyEjemplares();
            }
        }
    }

    @Override
    public String[] getcabecera() {
        return cabecera;
    }

    @Override
    public boolean islleno() {
        return this.indice == this.capacidad;
    }

    @Override
    public void aumentar() {
        int nuevaCapacidad = this.capacidad * 2;
        Libro[] nuevoArreglo = new Libro[nuevaCapacidad];
        System.arraycopy(this.libros, 0, nuevoArreglo, 0, this.libros.length);
        this.libros = nuevoArreglo;
        this.capacidad = nuevaCapacidad;
    }

    @Override
    public Object[][] getDatos() {
        Object[][] resultado = new Object[this.indice][6];
        int fila = 0;
        for (int i = 0; i < this.indice; i++) {
            Libro libro = this.libros[i];
            if (libro != null) {
                resultado[fila][0] = libro.getNombre();
                resultado[fila][1] = libro.getAutor();
                resultado[fila][2] = libro.getEditorial();
                resultado[fila][3] = libro.getGenero();
                resultado[fila][4] = libro.getFechaPublicacion();
                resultado[fila][5] = libro.getNrjemeplares();
                fila++;
            }
        }
        return resultado;
    }

    @Override
    public void guardarArchivo(String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (int i = 0; i < this.indice; i++) {  // Solo guardamos los libros hasta el índice actual
                if (this.libros[i] != null) {
                    for(int j = 0; j< this.libros[i].getNrjemeplares(); j++){
                        writer.write(this.libros[i].getNombre() + "," +
                            this.libros[i].getAutor() + "," +
                            this.libros[i].getEditorial() + "," +
                            this.libros[i].getGenero() + "," +
                            this.libros[i].getFechaPublicacion() + "," +
                            this.libros[i].getNrjemeplares() + "," +
                            this.libros[i].getEjemplares()[j].getID_Ejemplar()+ "," +
                            this.libros[i].getEjemplares()[j].getEstado());
                        writer.newLine();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al guardar en el archivo: " + e.getMessage());
        }
    }

    @Override
    public void cargarArchivo(String rutaArchivo) {
       try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
        String linea;
        Map<String, Libro> librosTemporales = new HashMap<>(); 
        while ((linea = reader.readLine()) != null) {
            String[] partes = linea.split(",");
            if (partes.length == 8) { 
                String nombre = partes[0].trim();
                String autor = partes[1].trim();
                String editorial = partes[2].trim();
                String genero = partes[3].trim();
                String fechaPublicacion = partes[4].trim();
                int nroEjemplares = Integer.parseInt(partes[5].trim());
                int idEjemplar = Integer.parseInt(partes[6].trim());
                String estadoEjemplar = partes[7].trim();

                Libro libro = librosTemporales.get(nombre);
                if (libro == null) {
                    libro = new Libro(nombre, autor, editorial, genero, fechaPublicacion, nroEjemplares);
                    librosTemporales.put(nombre, libro);
                }
                Ejemplar[] ejemplares = libro.getEjemplares();
                if (idEjemplar > 0 && idEjemplar <= ejemplares.length) {
                    ejemplares[idEjemplar - 1] = new Ejemplar(idEjemplar, estadoEjemplar);
                }
            }
        }
        for (Libro libro : librosTemporales.values()) {
            agregarLibro(libro);
        }
        } catch (IOException | NumberFormatException e) {
        System.out.println("Error al cargar desde el archivo: " + e.getMessage());
        }
    }

    @Override
    public void EliminarArchivo(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        try {
            if (archivo.exists()) {
                archivo.delete();
                System.out.println("Archivo eliminado con éxito");
            } else {
                System.out.println("El archivo no existe");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el archivo: " + e.getMessage());
        }
    }

    @Override
    public void ActualizarArchivo(String rutaArchivo, int id, String nuevoEstado) {
    }
    
    public void eliminarEjemplarDeLibro(String nombreLibro) {
    for (int i = 0; i < this.libros.length; i++) {
        if (this.libros[i] != null && this.libros[i].getNombre().equalsIgnoreCase(nombreLibro)) {
            if (this.libros[i].getNrjemeplares() > 0) {
                this.libros[i].setNrjemeplares(this.libros[i].getNrjemeplares() - 1);
                this.libros[i].getEjemplares()[this.libros[i].getNrjemeplares()] = null;
                if (this.libros[i].getNrjemeplares() == 0) {
                    this.libros[i] = null;
                    JOptionPane.showMessageDialog(null, "El libro ha sido eliminado porque no quedan ejemplares.", "Libro Eliminado", JOptionPane.INFORMATION_MESSAGE);
                }
                guardarArchivo("Libros.txt");
                return;
            } else {
                JOptionPane.showMessageDialog(null, "No hay ejemplares para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }
        JOptionPane.showMessageDialog(null, "Libro no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void actualizarEstadoMulta(String nombreArchivo, int idCarnet, String nuevoEstadoMulta) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}