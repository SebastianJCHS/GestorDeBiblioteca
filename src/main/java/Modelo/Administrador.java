package Modelo;

import java.util.Random;
public class Administrador extends Persona{
    private String ID_admin;
    
    public Administrador(String ID_admin, String nombres, String apellidos, int edad, String correoElectronico, String telefono, String DNI, String rol) {
        super(nombres, apellidos, edad, correoElectronico, telefono, DNI, rol);
        this.ID_admin = ID_admin;
    }
    
    public void makeid(){
        String var1 = getNombres().trim().toLowerCase().substring(0,3);
        String var2 = getApellidos().trim().toLowerCase().substring(0, 3);
        Random var3 = new Random();
        setID_admin(var1 + var2 + (var3.nextInt(9999)+1)); 
    }
    
    
    public String getID_admin() {
        return ID_admin;
    }

    public void setID_admin(String ID_admin) {
        this.ID_admin = ID_admin;
    }
    
}
