package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    private String Id_cliente;
    private Carnet carnet;

    public Cliente(String Id_cliente, String nombres, String apellidos, int edad, String correoElectronico, String telefono, String DNI, String rol, Carnet carnet) {
        super(nombres, apellidos, edad, correoElectronico, telefono, DNI, rol);
        this.Id_cliente = Id_cliente;
        this.carnet = carnet;
    }


    public String getId_cliente() {
        return Id_cliente;
    }

    public void setId_cliente(String Id_cliente) {
        this.Id_cliente = Id_cliente;
    }

    public Carnet getCarnet() {
        return carnet;
    }

    public void setCarnet(Carnet carnet) {
        this.carnet = carnet;
    }
     
}

