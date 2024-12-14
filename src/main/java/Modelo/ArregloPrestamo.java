 package Modelo;

public class ArregloPrestamo {
    private PrestacionLibro[] Prestamo;
    private int indice;
    private String[] cabecera = {"Fecha_Prestamo", "Fecha_Devolucion", "Cliente","Libro"};

    public ArregloPrestamo() {
        this.Prestamo = new PrestacionLibro[5];
        this.indice = 0;
    }
    
    public void AgregarPrestamo(PrestacionLibro Prestamo){
        if(Prestamo != null && this.Prestamo[indice] == null){
            this.Prestamo[indice] = Prestamo;
            indice++;
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
            if (prestacionLibro != null) {
                System.out.println("");
                prestacionLibro.mostrarPrestacion();
            }
        }
    }
    public String[] getCabecera(){
        return cabecera;
    }
    
    public Object[][] getDatos() {
    Object[][] resultado = new Object[this.indice][4];
    int fila = 0;
    for (PrestacionLibro Prestamo : this.Prestamo) {
            resultado[fila][0] = Prestamo.getFechaPrestamo();
            resultado[fila][1] = Prestamo.getFechaDevolucion();
            resultado[fila][2] = Prestamo.getCliente().getNombres();
            resultado[fila][3] = Prestamo.getLibro().getNombre();
            fila++;
        }
        return resultado;
    } 
}
