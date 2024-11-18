package Modelo;

public class Carnet {
    private int Id_carnet;
    private Multa multa;
    private String estado; // Para el estado serán 3: activo, inactivo, bloqueado

    public Carnet(int Id_carnet, String estado) {
        this.Id_carnet = Id_carnet;
        this.estado = estado;
    }

    public boolean isActivo() {
        return estado.equals("activo");
    }

    public boolean isbloqueado() {
        return estado.equals("bloqueado");
    }

    public boolean isinactivo() {
        return estado.equals("inactivo");
    }

    public int getId_carnet() {
        return Id_carnet;
    }

    public void setId_carnet(int Id_carnet) {
        this.Id_carnet = Id_carnet;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    @Override
    public String toString() {
        return "Carnet{" + "Id_carnet=" + Id_carnet + ", estado=" + estado + '}';
    }
}