 package Modelo;

public class ArregloPrestamo {
    private PrestacionLibro[] Prestamo;
    private int indice;

    public ArregloPrestamo() {
        this.Prestamo = new PrestacionLibro[5];
        this.indice = 0;
    }
    
    public void AgregarPrestamo(PrestacionLibro Prestamo){
        for (int i = 0; i < this.Prestamo.length; i++) {
            if(Prestamo != null && this.Prestamo[i] == null){
                this.Prestamo[i] = Prestamo;
                break;
            }
        }
    }
    
    public PrestacionLibro BuscarPrestamo(Cliente cliente, Libro libro){
        for (int i = 0; i < this.Prestamo.length; i++) {
            if(this.Prestamo[i] != null && this.Prestamo[i].getCliente().equals(cliente) && this.Prestamo[i].getLibro().equals(libro)){
                return this.Prestamo[i];
            }
        }
        return null;
    } 
    
    public boolean EliminarPrestamo(PrestacionLibro Prestamo){
        boolean result = false;
        for (int i = 0; i < this.Prestamo.length; i++) {
            if(Prestamo != null && this.Prestamo[i] == Prestamo){
                this.Prestamo[i] = null;
                result = true;
                return result;
            }
        }
        return result;
    } 

    public void mostrarPrestamos(){
        for (PrestacionLibro prestacionLibro : Prestamo) {
            if (prestacionLibro != null) {  // Verificar si el elemento no es null
                System.out.println("");
                prestacionLibro.mostrarPrestacion();
            }
        }
    }
    
}
