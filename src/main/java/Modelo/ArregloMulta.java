package Modelo;

public class ArregloMulta {
    private Multa[] multa;
    private int indice;

    public ArregloMulta(int tamaño) {
        this.multa = new Multa[tamaño];
        this.indice = 0;
    }
    
    public void AgregarMulta(Multa multa){
        for(int i = 0; i<this.multa.length; i++){
            if(multa != null && this.multa[i] == null){
                this.multa[i] = multa;
                break;
            }
        }
    }
    
    public Multa BuscarMulta(Cliente cliente){
        for(int i = 0; i<this.multa.length; i++){
            if(cliente != null && this.multa[i].getCliente() == cliente){
                return this.multa[i];
            }
        }
        return null;
    }
    
    public void EliminarMulta(Multa multa){
        for(int i = 0; i<this.multa.length; i++){
            if(multa != null && this.multa[i] == multa){
                this.multa[i] = null;
                break;
            }
        }
    }
}


