package Modelo;

public class Libro {
    private String nombre;
    private String autor;
    private String editorial;
    private String genero;
    private String fechaPublicacion;
    private Ejemplar[] ejemplares;
    
    public Libro(String nombre, String autor, String editorial, String genero, String fechaPublicacion, int numEjemplares){
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.genero = genero;
        this.fechaPublicacion = fechaPublicacion;
        this.ejemplares = new Ejemplar[numEjemplares];
        
        for (int i = 0; i < numEjemplares; i++) {
            ejemplares[i] = new Ejemplar(i + 1, "Disponible");
        }
    }

    public Libro() {
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Ejemplar[] getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Ejemplar[] ejemplares) {
        this.ejemplares = ejemplares;
    }
    
    public boolean buscarLibroporIdEjemplar(int IdEjemplar) {
        for (Ejemplar ejemplar : this.ejemplares) {
            if (ejemplar.getID_Ejemplar() == IdEjemplar) {
                return true;
            }
        }
        return false;
    }
    
    public boolean cambiarEstadoEjemplar(int IdEjemplar, String nuevoEstado) {
        for (Ejemplar ejemplar : this.ejemplares) {
            if (ejemplar.getID_Ejemplar() == IdEjemplar) {
                ejemplar.setEstado(nuevoEstado);
                return true;
            }
        }
        return false;
    }

    public boolean cambiarDisponible(int IdEjemplar) {
        return cambiarEstadoEjemplar(IdEjemplar, "Disponible");
    }

    public boolean cambiarPrestado(int IdEjemplar) {
        return cambiarEstadoEjemplar(IdEjemplar, "Prestado");
    }
   
    
    public boolean hayEjemplaresDisponibles() {
        for (Ejemplar ejemplar : ejemplares) {
            if (ejemplar != null && ejemplar.getEstado().equalsIgnoreCase("Disponible")) {
                return true; // Hay al menos un ejemplar disponible
            }
        }
        return false; // No hay ejemplares disponibles
    }

    public void cambiarEstadoEjemplarDisponibleAPrestado() {
        for (Ejemplar ejemplar : ejemplares) {
            if (ejemplar != null && ejemplar.getEstado().equalsIgnoreCase("Disponible")) {
                ejemplar.setEstado("Prestado");
                break; // Cambia solo el primer ejemplar disponible
            }
        }
    }
    
    public void mostrarLibroyEjemplares (){
        System.out.println("Libro{ "+ "nombre=" + nombre + ", autor=" + autor + ", editorial=" + editorial + ", genero=" + genero +", fechaPublicacion=" + fechaPublicacion);
        for (Ejemplar ejemplare : ejemplares) {
            System.out.println(ejemplare);
        }
    }

    
}
