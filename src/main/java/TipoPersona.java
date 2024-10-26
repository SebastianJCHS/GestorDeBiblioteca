public abstract class TipoPersona extends Persona{
    private String correoElectronico;
    private String telefono;
    private String DNI;
    private String rol;

    TipoPersona(String nombres, String apellidos, int edad, String correoElectronico, String telefono, String DNI, String rol){
        super(nombres, apellidos, edad);
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.DNI = DNI;
        this.rol = rol;
    }
    
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
