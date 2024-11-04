public class ArregloLibro {
    private int indice;
    private Libro[] libros;
    
    public ArregloLibro(int capacidad){
        this.libros  = new Libro[capacidad];
        this.indice = 0;
    }

    public void agregarEjemplar(Libro libro, int nroejemplares){
        for(int i = 0; i < this.libros.length; i++){
            if(nroejemplares > 0 && libros[i] == null){
                this.libros[i]= libro;
                nroejemplares--;
            }   
        }
    }
    
    public Libro buscarEjemplar(int idEjemplar){
        for (int i = 0; i <this.libros.length; i++) {
            if (this.libros[i] != null && this.libros[i].buscarLibroporIdEjemplar(idEjemplar) == true){
                return this.libros[i];
            }
        }
        return null;
    }
    public void eliminarLibro(int IdEjemplar){
        for (int i = 0; i <this.libros.length; i++) {
            if (this.libros[i] != null && this.libros[i].buscarLibroporIdEjemplar(IdEjemplar) == true){
                this.libros[i] = null;
            }
        }
    }
    
    // Estos métodos se replican para los demás arreglos
}
