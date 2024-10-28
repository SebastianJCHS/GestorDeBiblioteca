public class Carnet {
    private String Id_carnet;
    private String estado; //Para el estado seran 3, activo, inactivo, bloqueado;

    public Carnet(String Id_carnet, String estado) {
        this.Id_carnet = Id_carnet;
        this.estado = estado;
    }
    
    public boolean isActivo(){
        return estado.equals("activo");
    }
    public boolean isbloqueado(){
        return estado.equals("bloqueado");
    }
    public boolean isinactivo(){
        return estado.equals("inactivo");
    }

    public String getId_carnet() {
        return Id_carnet;
    }

    public void setId_carnet(String Id_carnet) {
        this.Id_carnet = Id_carnet;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
