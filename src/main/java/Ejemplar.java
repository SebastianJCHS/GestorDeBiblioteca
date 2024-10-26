public class Ejemplar {
    private String ID_Ejemplar;
    private String estado; 

    public Ejemplar(String idEjemplar, String estado) {
        this.ID_Ejemplar = idEjemplar;
        this.estado = estado;
    } 

    public String getIdEjemplar() {
        return ID_Ejemplar;
    }

    public void setIdEjemplar(String idEjemplar) {
        this.ID_Ejemplar = idEjemplar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
