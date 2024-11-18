package Modelo;

public class Ejemplar {
    private int ID_Ejemplar;
    private String estado; 

    public Ejemplar(int idEjemplar, String estado) {
        this.ID_Ejemplar = idEjemplar;
        this.estado = estado;
    } 

    public int getID_Ejemplar() {
        return ID_Ejemplar;
    }

    public void setID_Ejemplar(int ID_Ejemplar) {
        this.ID_Ejemplar = ID_Ejemplar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Ejemplar{" + "ID_Ejemplar=" + ID_Ejemplar + ", estado=" + estado + '}';
    }

    
    
}
