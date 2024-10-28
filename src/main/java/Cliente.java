public class Cliente extends Persona{
    private String Id_cliente;

    public Cliente(String Id_cliente, String nombres, String apellidos, int edad, String correoElectronico, String telefono, String DNI, String rol) {
        super(nombres, apellidos, edad, correoElectronico, telefono, DNI, rol);
        this.Id_cliente = Id_cliente;
    }
    
}
