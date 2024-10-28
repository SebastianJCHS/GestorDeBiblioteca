
import java.awt.datatransfer.FlavorListener;

public class Administrador extends Persona{
    private String ID_admin;
    private Libro libro;
    private Carnet carnet;
    private ArregloCarnet CarnetN;

    public Administrador(String ID_admin, Libro libro, Carnet carnet, String nombres, String apellidos, int edad, String correoElectronico, String telefono, String DNI, String rol) {
        super(nombres, apellidos, edad, correoElectronico, telefono, DNI, rol);
        this.ID_admin = ID_admin;
        this.libro = new Libro();
        this.carnet = carnet;
    }
    
    public boolean Registrarlibro(Libro libro){
        boolean result = false;
        if(libro != null){
            this.libro = libro;
            result = true;
        }
        return result;
    }
    
    public boolean agregarCarnet(Carnet carnet){
        boolean result = false;
        if(carnet != null){
            this.carnet = carnet;
            this.CarnetN.AgregarCarnet(carnet);
            result = true;
        }
        return result;
    }
    
    public void EliminarCarnet(int indice){
        this.CarnetN.Eliminarcarnet(indice);
    }
    
    public void CambiarCarnetInactivo(Carnet carnet){
        if(carnet != null){
            carnet.isinactivo();
        }
    }
    
    public void BloquearCarnet(Carnet carnet){
        if( carnet != null){
            carnet.isbloqueado();
        }
    }

}
