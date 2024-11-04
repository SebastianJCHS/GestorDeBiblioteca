package Modelo;

public class ArregloCarnet {
    private Carnet[] carnet;
    private int indice;

    public ArregloCarnet(int tamaño) {
        this.carnet = new Carnet [tamaño];
        this.indice = 0;
    }
    
    public void AgregarCarnet(Carnet carnet){
        for (int i = 0; i < this.carnet.length; i++) {
            if(carnet != null && this.carnet[i] == null){
                this.carnet[i] = carnet;
                break;
            }
        }
    }
    
    public boolean Eliminarcarnet(int id){
        for (int i = 0; i < this.carnet.length; i++) {
            if(id >= 0 && id < this.carnet.length && this.carnet[i] != null && this.carnet[i].getId_carnet() == id){
                this.carnet[i] = null;
                return true;
            }
        }
        return false;   
    }
    
    public Carnet BuscarCarnet(int id){
        for (int i = 0; i < this.carnet.length; i++) {
            if(this.carnet[i] != null && this.carnet[i].getId_carnet() == id){
                return this.carnet[i];
            }
        }
        return null;
    }
    
    public boolean CambiarActivo(int id){
        boolean result = false;
        for (int i = 0; i < this.carnet.length; i++) {
            if(this.carnet[i] != null && this.carnet[i].getId_carnet() == id){
                if(!this.carnet[i].isActivo()){
                    this.carnet[i].setEstado("Activo");
                    result = true;
                    return result;
                }
                
            }
        }
        return result;
    }
    
    public boolean CambiarInactivo(int id){
        boolean result = false;
        for (int i = 0; i < this.carnet.length; i++) {
            if(this.carnet[i] != null && this.carnet[i].getId_carnet() == id){
                if(!this.carnet[i].isinactivo()){
                    result = true;
                    return result;
                }
               
            }
        }
        return result;
    }
    
    public boolean CambiarBloqueado(int id){
        boolean result = false;
        for (int i = 0; i < this.carnet.length; i++) {
            if(this.carnet[i] != null && this.carnet[i].getId_carnet() == id){
                if(!this.carnet[i].isbloqueado()){
                    result = true;
                    return result;
                }
                
            }
        }
        return result;
    }
}
