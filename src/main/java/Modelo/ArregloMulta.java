package Modelo;
import Interfaces.Interface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArregloMulta implements Interface {
    private Multa[] multa;
    private int indice, tamaño;
    private String[] cabecera = {"Monto","Fecha","cliente","Estado"};

    public ArregloMulta() {
        this.tamaño = 30;
        this.multa = new Multa[tamaño];
        this.indice = 0;
    }

    public void AgregarMulta(Multa multa){
        if(this.indice < this.multa.length){
           this.multa[this.indice] = multa;
           indice++;
        }
    }
    
    public Multa BuscarMulta(Cliente cliente){
        for(int i = 0; i<this.multa.length; i++){
            if(cliente != null && this.multa[i].getCliente() == cliente){
                return this.multa[i];
            }
        }
        return null;
    }
    
    public void EliminarMulta(Multa multa){
        for(int i = 0; i<this.multa.length; i++){
            if(multa != null && this.multa[i] == multa){
                this.multa[i] = null;
                break;
            }
        }
    }

    @Override
    public String[] getcabecera() {
        return cabecera;
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
        int tamaño= this.tamaño*2;
        Multa[] nuevoArreglo = new Multa[tamaño];
        for(int i=0; i<this.indice; i++){
            nuevoArreglo[i] = this.multa[i];
        }
        this.multa = nuevoArreglo;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object[][] getDatos() {
     Object[][] resultado = new Object[this.indice][4];

    int fila = 0;
    for (Multa multa: this.multa) {
        if(multa!=null){
          resultado[fila][0] = multa.getMonto();
            resultado[fila][1] = multa.getFecha();
            resultado[fila][2] = multa.getCliente().getNombres();
            resultado[fila][3] = multa.getEstado();
            fila++;  
        }
    }
    return resultado;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void guardarArchivo(String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Multa multa : this.multa) {
                if(multa!=null && multa.getCliente() != null && multa.getCliente().getCarnet() != null){
                 writer.write(multa.getMonto() + "," +
                             multa.getFecha() + "," +
                             multa.getCliente().getNombres() + "," +
                             multa.getCliente().getApellidos() + "," +
                             multa.getCliente().getEdad() + "," +
                             multa.getCliente().getCorreoElectronico() + "," +
                             multa.getCliente().getTelefono() + "," +
                             multa.getCliente().getDNI() + "," +
                             multa.getCliente().getRol() + "," +
                             multa.getCliente().getCarnet().getId_carnet() + "," +
                             multa.getCliente().getCarnet().getEstado() + "," +
                             multa.getEstado());
                 writer.newLine();   
                }
            }
        } catch (IOException e) {
            System.out.println("Error al guardar en el archivo: " + e.getMessage());
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cargarArchivo(String rutaArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 12) {
                    float monto = Float.parseFloat(partes[0].trim());
                    String fecha = partes[1].trim();
                    String Nombres = partes[2].trim();
                    String Apellido = partes[3].trim();
                    int edad = Integer.parseInt(partes[4].trim());
                    String correo = partes[5].trim();
                    String telefono = partes[6].trim();
                    String DNI = partes[7].trim();
                    String rol = partes[8].trim();
                    int id = Integer.parseInt(partes[9].trim());
                    String EstadoCarnet = partes[10].trim();
                    String EstadoMulta = partes[11].trim();
                    Carnet carnet = new Carnet(id, EstadoCarnet);
                    Cliente cliente = new Cliente(Nombres, Apellido, edad, correo, telefono, DNI, rol, carnet);
                    Multa multa =new Multa(monto, cliente, EstadoMulta);
                    AgregarMulta(multa);
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
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


