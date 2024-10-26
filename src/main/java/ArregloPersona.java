public class ArregloPersona {
    private int indice;
    private TipoPersona[] personas;
    
    public ArregloPersona(int multitud){
        this.personas = new TipoPersona[multitud];
        this.indice = 0;
    }
    
    public void agregarPersona(TipoPersona persona){
        if(indice < personas.length){
            personas[indice] = persona;
            indice++;
        }
    }
    
    public TipoPersona buscarPersona(String DNI){
        for(int i = 0; i < indice; i++){
            if(personas[i].getDNI().equalsIgnoreCase(DNI)){
                return personas[i];
            }   
        }
        return null;
    }
    
    public TipoPersona[] mostrarPersonas() {
        TipoPersona[] listaPersonas = new TipoPersona[indice];
        System.arraycopy(personas, 0, listaPersonas, 0, indice);
        return listaPersonas;
    }
}
