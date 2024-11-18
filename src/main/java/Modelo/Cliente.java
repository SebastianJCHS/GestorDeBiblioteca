package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    private Carnet carnet;

    public Cliente(String nombres, String apellidos, int edad, String correoElectronico, String telefono, String DNI,String rol, Carnet carnet) {
        super(nombres, apellidos, edad, correoElectronico, telefono, DNI,rol);
        this.carnet = carnet;
    }


    public Carnet getCarnet() {
        return carnet;
    }

    public void setCarnet(Carnet carnet) {
        this.carnet = carnet;
    }

    @Override
    public String toString() {
        return "Cliente{" + "carnet=" + carnet + '}';
    }
    
    
}

