package Modelo;
import Interfaces.Interface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArregloLibro implements Interface{
    private Libro[] libros;
    private int capacidad, indice;
    private String[] cabecera = {"Nombre","Autor", "Editorial", "Genero", "Fecha de Publicacion", "Nro_Ejemplares"};

    public ArregloLibro() {
        this.capacidad = 50;
        this.libros = new Libro[capacidad];
        this.indice = 0;
    }

    public void agregarLibro(Libro libro) {
        if (this.indice < this.libros.length) {
            this.libros[indice] = libro;
            indice++;
        }
    }

    public void eliminarLibro(int IdEjemplar) {
        for (int i = 0; i < this.libros.length; i++) {
            if (this.libros[i] != null && this.libros[i].buscarLibroporIdEjemplar(IdEjemplar) == true) {
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
            if (this.libros[i] != null && this.libros[i].buscarLibroporIdEjemplar(IdEjemplar) == true) {
                this.libros[i].cambiarDisponible(IdEjemplar);
            }
        }
    }

    public void cambiarEstadoPrestado(int IdEjemplar) {
        for (int i = 0; i < this.libros.length; i++) {
            if (this.libros[i] != null && this.libros[i].buscarLibroporIdEjemplar(IdEjemplar) == true) {
                this.libros[i].cambiarPrestado(IdEjemplar);
            }
        }
    }

    public void mostrarLibros() {

        for (Libro libro : libros) {
            if (libro != null) {  // Verificar si el elemento no es null
                System.out.println("");
                libro.mostrarLibroyEjemplares();
            } 
        }
    }
    
    
    // Estos métodos se replican para los demás arreglos

    @Override
    public String[] getcabecera() {
        return cabecera;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean islleno() {
        boolean resultado = false;
        if(this.indice == this.capacidad){
            resultado = true;
            aumentar();
        }
        return resultado;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void aumentar() {
        int capacidad = this.capacidad*2;
        Libro[] nuevoArreglo = new Libro[capacidad];
        for(int i=0; i<this.indice; i++){
            nuevoArreglo[i] = this.libros[i];
        }
        this.libros = nuevoArreglo;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object[][] getDatos() {
    Object[][] resultado = new Object[this.indice][6];

    int fila = 0;
    for (Libro libro : this.libros) {
            resultado[fila][0] = libro.getNombre();
            resultado[fila][1] = libro.getAutor();
            resultado[fila][2] = libro.getEditorial();
            resultado[fila][3] = libro.getGenero();
            resultado[fila][4] = libro.getFechaPublicacion();
            resultado[fila][5] = libro.getNrjemeplares();
            fila++;
    }
    return resultado;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void guardarArchivo(String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Libro libro : this.libros) {
                writer.write(libro.getNombre() + "," +
                             libro.getAutor() + "," +
                             libro.getEditorial() + "," +
                             libro.getGenero() + "," +
                             libro.getFechaPublicacion() + "," +
                             libro.getNrjemeplares());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar en el archivo: " + e.getMessage());
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cargarArchivo(String rutaArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 5) {
                    String nombre = partes[0].trim();
                    String Autor = partes[1].trim();
                    String Editorial = partes[2].trim();
                    String Genero = partes[3].trim();
                    String fechaPublicacion = partes[4].trim();
                    int nroEjemplares = Integer.parseInt(partes[5].trim());
                    Libro libro = new Libro(nombre, Autor, Editorial, Genero, fechaPublicacion, nroEjemplares);
                    agregarLibro(libro);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer del archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir datos numéricos: " + e.getMessage());
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void EliminarArchivo(String rutaArchivo) {
        File archivo;
       try {
           archivo = new File(rutaArchivo);
           if(!archivo.exists()){
               System.out.println("El archivo no existe");
           }else{
               archivo.delete();
               System.out.println("Archivo eliminado con exito");
           }
       } catch (Exception e) {
           System.out.println("Error al leer el archivo: " + e.getMessage());
       }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
