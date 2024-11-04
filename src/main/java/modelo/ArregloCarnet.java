package modelo;

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
}
