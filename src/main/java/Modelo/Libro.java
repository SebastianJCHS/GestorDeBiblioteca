package Modelo;

public class Libro {
    private String nombre;
    private String autor;
    private String editorial;
    private String genero;
    private String fechaPublicacion;
    private Ejemplar[] ejemplares;
    private int nroejemplares;
    
    Libro(String nombre, String autor, String editorial, String genero, String fechaPublicacion, int nroejemplares){
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.genero = genero;
        this.fechaPublicacion = fechaPublicacion;
        this.nroejemplares = nroejemplares;
        this.ejemplares = new Ejemplar[nroejemplares];
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
    

    public int getNroejemplares() {
        return nroejemplares;
    }

    public void setNroejemplares(int nroejemplares) {
        this.nroejemplares = nroejemplares;
    }
    
    public void AsignarEjemplar(Ejemplar ejemplar){
        for(int i = 0; i<this.ejemplares.length; i++){
            this.ejemplares[i] = ejemplar;
        }
    }

    public Ejemplar[] getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Ejemplar[] ejemplares) {
        this.ejemplares = ejemplares;
    }
    
    public boolean buscarLibroporIdEjemplar(int IdEjemplar){
        boolean result = false;
        for(int i = 0; i<this.ejemplares.length; i++){
            if(this.ejemplares[i].getID_Ejemplar() == IdEjemplar){
                result = true;
                return result;
            }
        }
        return result;
    }
    
    public boolean cambiarDisponible(int IdEjemplar){
        boolean result = false;
        for(int i = 0; i<this.ejemplares.length; i++){
            if(this.ejemplares[i].getID_Ejemplar() == IdEjemplar){
                if(!this.ejemplares[i].isDisponible()){
                    this.ejemplares[i].setEstado("Disponible");
                    result = true;
                    return result;
                }
            }
        }
        return result;
    }
    public boolean cambiarPrestado(int IdEjemplar){
        boolean result = false;
        for(int i = 0; i<this.ejemplares.length; i++){
            if(this.ejemplares[i].getID_Ejemplar() == IdEjemplar){
                if(!this.ejemplares[i].isPrestado()){
                    this.ejemplares[i].setEstado("Prestado");
                    result = true;
                    return result;
                }
            }
        }
        return result;
    }
    public boolean cambiarPerdido(int IdEjemplar){
        boolean result = false;
        for(int i = 0; i<this.ejemplares.length; i++){
            if(this.ejemplares[i].getID_Ejemplar() == IdEjemplar){
                if(!this.ejemplares[i].isPerdido()){
                    this.ejemplares[i].setEstado("Perdido");
                    result = true;
                    return result;
                }
            }
        }
        return result;
    }
}
