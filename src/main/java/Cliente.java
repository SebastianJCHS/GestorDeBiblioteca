import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    private String Id_cliente;
    private List<PrestacionLibro> prestamos; 

    public Cliente(String Id_cliente, String nombres, String apellidos, int edad, String correoElectronico, String telefono, String DNI, String rol) {
        super(nombres, apellidos, edad, correoElectronico, telefono, DNI, rol);
        this.Id_cliente = Id_cliente;
        this.prestamos = new ArrayList<>();
    }

    public String getID_Cliente() {
        return Id_cliente;
    }

    public String mostrarCliente() {
        return "Cliente ID: " + Id_cliente +
               "\nNombre: " + getNombres() +
               "\nApellido: " + getApellidos() +
               "\nEdad: " + getEdad() +
               "\nCorreo: " + getCorreoElectronico();
    }

    public void agregarPrestamo(PrestacionLibro prestamo) {
        prestamos.add(prestamo);
    }

    public boolean VerificarPrestamo() {
        for (PrestacionLibro prestamo : prestamos) {
            if (prestamo.estaPendiente()) {
                return true;
            }
        }
        return false; 
    }
}
