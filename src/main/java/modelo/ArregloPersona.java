package modelo;

public class ArregloPersona {
    private int indice;
    private final Persona[] personas;
    
    public ArregloPersona(int multitud){
        this.personas = new Persona[multitud];
        this.indice = 0;
    }
    
    public void agregarPersona(Persona persona){
        if(indice < this.personas.length){
            this.personas[indice] = persona;
            indice++;
        }
    }
    
    public Persona buscarPersona(String DNI){
        for(int i = 0; i < indice; i++){
            if(this.personas[i].getDNI().equalsIgnoreCase(DNI)){
                return this.personas[i];
            }   
        }
        return null;
    }
    
    public Persona[] mostrarPersonas() {
        Persona[] listaPersonas = new Persona[indice];
        System.arraycopy(this.personas, 0, listaPersonas, 0, indice);
        return listaPersonas;
    }
}
