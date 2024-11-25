package Modelo;

public class ArregloLibro {
    private Libro[] libros;

    public ArregloLibro(int capacidad) {
        this.libros = new Libro[capacidad];
    }

    public ArregloLibro() {
    }
    
    
    public void agregarLibro(Libro libro) {
        for (int i = 0; i < libros.length; i++) {
            if (this.libros[i] == null) {
                this.libros[i] = libro;
                return;
            }
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
}
