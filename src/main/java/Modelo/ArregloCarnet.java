package Modelo;
import Interfaces.Interface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class ArregloCarnet implements Interface,Serializable{
    private Carnet[] carnet;
    private int indice, tamaño;
    private String[] cabeceras = {"ID", "ESTADO"};

    public ArregloCarnet() {
        this.tamaño = 30;
        this.carnet = new Carnet[tamaño];
        this.indice = 0;
    }
    
    

    public void AgregarCarnet(Carnet carnet) {
        if (indice<this.carnet.length) {
            this.carnet[indice] = carnet;
            indice++;
        }
    }

    public boolean Eliminarcarnet(int id) {
        for (int i = 0; i < this.carnet.length; i++) {
            if (id >= 0 && id < this.carnet.length && this.carnet[i] != null && this.carnet[i].getId_carnet() == id) {
                this.carnet[i] = null;
                return true;
            }
        }
        return false;
    }

    public Carnet BuscarCarnet(int id) {
        for (int i = 0; i < this.carnet.length; i++) {
            if (this.carnet[i] != null && this.carnet[i].getId_carnet() == id) {
                return this.carnet[i];
            }
        }
        return null;
    }

    public boolean CambiarActivo(int id) {
        boolean result = false;
        for (int i = 0; i < this.carnet.length; i++) {
            if (this.carnet[i] != null && this.carnet[i].getId_carnet() == id) {
                if (!this.carnet[i].isActivo()) {
                    this.carnet[i].setEstado("activo");
                    result = true;
                    return result;
                }
            }
        }
        return result;
    }

    public boolean CambiarInactivo(int id) {
        boolean result = false;
        for (int i = 0; i < this.carnet.length; i++) {
            if (this.carnet[i] != null && this.carnet[i].getId_carnet() == id) {
                if (!this.carnet[i].isinactivo()) {
                    result = true;
                    this.carnet[i].setEstado("inactivo");
                    return result;
                }
            }
        }
        return result;
    }

    public boolean CambiarBloqueado(int id) {
        boolean result = false;
        for (int i = 0; i < this.carnet.length; i++) {
            if (this.carnet[i] != null && this.carnet[i].getId_carnet() == id) {
                if (!this.carnet[i].isbloqueado()) {
                    result = true;
                    this.carnet[i].setEstado("bloqueado");
                    return result;
                }
            }
        }
        return result;
    }

    // Método para obtener el arreglo de carnets
    public Carnet[] getCarnet() {
        return this.carnet;
    }

    @Override
    public String[] getcabecera() {
        return cabeceras;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean islleno() {
        boolean resultado = false;
        if(this.indice == this.tamaño){
            resultado = true;
            aumentar();
        }
        return resultado;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void aumentar() {
        int tamaño = this.tamaño*2;
        Carnet[] nuevoArreglo = new Carnet[tamaño];
        for(int i=0; i<this.indice; i++){
            nuevoArreglo[i] = this.carnet[i];
        }
        this.carnet = nuevoArreglo;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object[][] getDatos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 

    @Override
    public void guardarArchivo(String rutaArchivo) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cargarArchivo(String rutaArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 9) {
                    String nombres = partes[0].trim();
                    String apellidos = partes[1].trim();
                    int edad = Integer.parseInt(partes[2].trim());
                    String correoElectronico = partes[3].trim();
                    String telefono = partes[4].trim();
                    String dni = partes[5].trim();
                    String rol = partes[6].trim();

                    int idCarnet = Integer.parseInt(partes[7].trim());
                    String estadoCarnet = partes[8].trim();

                    Carnet carnet = new Carnet(idCarnet, estadoCarnet);
                    AgregarCarnet(carnet);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer del archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir datos numéricos: " + e.getMessage());
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void EliminarArchivo(String rutaArchivo) {
       File archivo;
       try {
           archivo = new File(rutaArchivo);
           if(!archivo.exists()){
               System.out.println("El archivo no existe");
           }else{
               archivo.delete();
               System.out.println("Archivo eliminado con exito");
           }
       } catch (Exception e) {
           System.out.println("Error al leer el archivo: " + e.getMessage());
       }
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void ActualizarArchivo(String rutaArchivo, int id, String nuevoEstado) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}