package Modelo;

import java.io.Serializable;
import java.util.Random;
public class Administrador extends Persona implements Serializable{
    private String ID_admin;
    
    public Administrador(String ID_admin, String nombres, String apellidos, int edad, String correoElectronico, String telefono, String DNI, String rol) {
        super(nombres, apellidos, edad, correoElectronico, telefono, DNI, rol);
        this.ID_admin = ID_admin;
    }
    
    
    
    public String getID_admin() {
        return ID_admin;
    }

    public void setID_admin(String ID_admin) {
        this.ID_admin = ID_admin;
    }

    public Administrador() {
    }

    
}
