
import javax.naming.ldap.PagedResultsControl;

public class ArregloCarnet {
    private Carnet[] carnet;
    private int indice;

    public ArregloCarnet(int tamaño) {
        this.carnet = new Carnet [tamaño];
        this.indice = 0;
    }
    
    public boolean AgregarCarnet(Carnet carnet){
        if( indice < this.carnet.length){
            this.carnet[indice++] = carnet;
            return true;
        }
        return false;
    }
    
    public boolean Eliminarcarnet(int indice){
        if(indice >= 0 && indice < this.carnet.length && this.carnet[indice] != null){
           this.carnet[indice] = null;
           return true;
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
                this.carnet[i].isActivo();
                result = true;
            }
        }
        return result;
    }
    
    public boolean CambiarInactivo(int id){
        boolean result = false;
        for (int i = 0; i < this.carnet.length; i++) {
            if(this.carnet[i] != null && this.carnet[i].getId_carnet() == id){
                this.carnet[i].isinactivo();
                result = true;
            }
        }
        return result;
    }
    
    public boolean CambiarBloqueado(int id){
        boolean result = false;
        for (int i = 0; i < this.carnet.length; i++) {
            if(this.carnet[i] != null && this.carnet[i].getId_carnet() == id){
                this.carnet[i].isbloqueado();
                result = true;
            }
        }
        return result;
    }
}
