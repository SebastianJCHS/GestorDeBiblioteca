package Modelo;

public class ArregloPersona {
    private int indice;
    private Persona[] personas;

    public ArregloPersona(int multitud) {
        this.personas = new Persona[multitud];
        this.indice = 0;
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

    public Persona[] mostrarPersonas() {
        Persona[] listaPersonas = new Persona[indice];
        System.arraycopy(this.personas, 0, listaPersonas, 0, indice);
        return listaPersonas;
    }
}
