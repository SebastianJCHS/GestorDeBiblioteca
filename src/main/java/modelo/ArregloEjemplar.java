package modelo;

public class ArregloEjemplar {
    private int indice;
    private Ejemplar[] ejemplares;
    
    public ArregloEjemplar(int capacidad){
        this.ejemplares = new Ejemplar[capacidad];
        this.indice = 0;
    }

    public void agregarEjemplar(Ejemplar ejemplar){
        if (indice < ejemplares.length){
            ejemplares[indice] = ejemplar;
            indice++;
        }
    }
    
    public Ejemplar buscarEjemplar(String idEjemplar){
        for (int i = 0; i < indice; i++) {
            if (ejemplares[i].getIdEjemplar().equalsIgnoreCase(idEjemplar)) {
                /* Explicacion pa q no vuelen de mi parte <3: 
                'getIdEjemplar' es un método de la clase "Ejemplar" que devuelve la ID del ejemplar, devuelve un String.
                Por ejemplo, si ejemplares[0] tiene un ID de "EJ123", entonces ejemplares[0].getIdEjemplar() devolvería "EJ123".
                'equalsIgnoreCase(idEjemplar)' Este método compara dos cadenas ignorando diferencias de mayúsculas y minúsculas.
                Por ejemplo, "EJ123".equalsIgnoreCase("ej123") devolvería true porque son iguales si ignoras las diferencias de mayúsculas y minúsculas.*/
                return ejemplares[i];
            }
        }
        return null;
    }
    
    public Ejemplar[] mostrarEjemplares() {
        Ejemplar[] listaEjemplares = new Ejemplar[indice];
        System.arraycopy(ejemplares, 0, listaEjemplares, 0, indice);
        /*Este método copia los elementos de un arreglo a otro, por eso se llama copy, pq copia
        y tiene 5 parámetros para que funcione como:
        (El arreglo origen, la posicion inicial, el arreglo destino, su posicion inicial del arreglo destino, la cantidad de elementos a copiar)*/
        return listaEjemplares;
    }
    
    // Estos métodos se replican para los demás arreglos
}
