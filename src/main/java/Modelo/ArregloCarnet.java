package Modelo;
import Interfaces.Interface;

public class ArregloCarnet implements Interface{
    private Carnet[] carnet;
    private int indice, tamaño;
    private String[] cabeceras = {"ID", "ESTADO"};

    public ArregloCarnet() {
        this.tamaño = 30;
        this.carnet = new Carnet[tamaño];
        this.indice = 0;
    }
    
    

    public void AgregarCarnet(Carnet carnet) {
        if (indice<this.carnet.length) {
            this.carnet[indice] = carnet;
            indice++;
        }

    }

    public boolean Eliminarcarnet(int id) {
        for (int i = 0; i < this.carnet.length; i++) {
            if (id >= 0 && id < this.carnet.length && this.carnet[i] != null && this.carnet[i].getId_carnet() == id) {
                this.carnet[i] = null;
                return true;
            }
        }
        return false;
    }

    public Carnet BuscarCarnet(int id) {
        for (int i = 0; i < this.carnet.length; i++) {
            if (this.carnet[i] != null && this.carnet[i].getId_carnet() == id) {
                return this.carnet[i];
            }
        }
        return null;
    }

    public boolean CambiarActivo(int id) {
        boolean result = false;
        for (int i = 0; i < this.carnet.length; i++) {
            if (this.carnet[i] != null && this.carnet[i].getId_carnet() == id) {
                if (!this.carnet[i].isActivo()) {
                    this.carnet[i].setEstado("Activo");
                    result = true;
                    return result;
                }
            }
        }
        return result;
    }

    public boolean CambiarInactivo(int id) {
        boolean result = false;
        for (int i = 0; i < this.carnet.length; i++) {
            if (this.carnet[i] != null && this.carnet[i].getId_carnet() == id) {
                if (!this.carnet[i].isinactivo()) {
                    result = true;
                    return result;
                }
            }
        }
        return result;
    }

    public boolean CambiarBloqueado(int id) {
        boolean result = false;
        for (int i = 0; i < this.carnet.length; i++) {
            if (this.carnet[i] != null && this.carnet[i].getId_carnet() == id) {
                if (!this.carnet[i].isbloqueado()) {
                    result = true;
                    return result;
                }
            }
        }
        return result;
    }

    // Método para obtener el arreglo de carnets
    public Carnet[] getCarnet() {
        return this.carnet;
    }

    @Override
    public String[] getcabecera() {
        return cabeceras;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean islleno() {
        boolean resultado = false;
        if(this.indice == this.tamaño){
            resultado = true;
            aumentar();
        }
        return resultado;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void aumentar() {
        int tamaño = this.tamaño*2;
        Carnet[] nuevoArreglo = new Carnet[tamaño];
        for(int i=0; i<this.indice; i++){
            nuevoArreglo[i] = this.carnet[i];
        }
        this.carnet = nuevoArreglo;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}