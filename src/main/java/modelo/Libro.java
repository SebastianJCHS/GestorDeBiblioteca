package modelo;


import modelo.ArregloEjemplar;

public class Libro {
    private String nombre;
    private String autor;
    private String editorial;
    private String genero;
    private String fechaPublicacion;
    private ArregloEjemplar ejemplares;
    
    Libro(String nombre, String autor, String editorial, String genero, String fechaPublicacion, int capacidad){
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.genero = genero;
        this.fechaPublicacion = fechaPublicacion;
        this.ejemplares = new ArregloEjemplar(capacidad);
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

    public ArregloEjemplar getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(ArregloEjemplar ejemplares) {
        this.ejemplares = ejemplares;
    }
    
    
}
