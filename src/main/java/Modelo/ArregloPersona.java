package Modelo;
import Interfaces.Interface;
public class ArregloPersona implements Interface {
    private int indice, multitud;
    private Persona[] personas;
    private String[] cabecera = {"NOMBRES", "APELLIDOS", "EDAD", "CORREO ELECTRONICO", "DNI", "ROL"};

    public ArregloPersona() {
        this.multitud = 30;
        this.personas = new Persona[multitud];
        this.indice = 0;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public int getMultitud() {
        return multitud;
    }

    public void setMultitud(int multitud) {
        this.multitud = multitud;
    }

    public Persona[] getPersonas() {
        return personas;
    }

    public void setPersonas(Persona[] personas) {
        this.personas = personas;
    }

    
    
    public void agregarPersona(Persona persona) {
        if (indice < this.personas.length) {
            this.personas[indice] = persona;
            indice++;
        }
    }

    public Persona buscarPersona(String DNI) {
        for (int i = 0; i < indice; i++) {
            if (this.personas[i].getDNI().equalsIgnoreCase(DNI)) {
                return this.personas[i];
            }
        }
        return null;
    }

    // Nuevo método para buscar por ID de carnet
    public Persona buscarPersonaPorIdCarnet(int idCarnet) {
        for (int i = 0; i < indice; i++) {
            if (this.personas[i] instanceof Cliente) {
                Cliente cliente = (Cliente) this.personas[i];
                if (cliente.getCarnet().getId_carnet() == idCarnet) {
                    return cliente;
                }
            }
        }
        return null;
    }
    
    public Persona buscarAdminPorID(String Id){
        for (int i = 0; i < indice; i++) {
            if(this.personas[i] instanceof Administrador){
                Administrador administrador = (Administrador) this.personas[i];
                if(administrador.getID_admin().equals(Id)){
                    return administrador;
                }
            }
        }
        return null;
    }

    public Persona[] mostrarPersonas() {
        Persona[] listaPersonas = new Persona[indice];
        System.arraycopy(this.personas, 0, listaPersonas, 0, indice);
        return listaPersonas;
    }

    @Override
    public String[] getcabecera() {
        return cabecera;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean islleno() {
        boolean resultado = false;
        if(this.indice == this.multitud){
            resultado = true;
            aumentar();
        }
        return resultado;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void aumentar() {
        int multitud = this.multitud*2;
        Persona[] nuevoArreglo = new Persona[multitud];
        for(int i=0; i<this.indice; i++){
            nuevoArreglo[i] = this.personas[i];
        }
        this.personas = nuevoArreglo;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
