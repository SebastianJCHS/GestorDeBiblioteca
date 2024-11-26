package Modelo;
import Interfaces.Interface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;
public class ArregloPersona implements Interface, Serializable {
    private int indice, multitud;
    private Persona[] personas;
    private String[] cabecera = {"NOMBRES", "APELLIDOS", "EDAD", "CORREO ELECTRONICO", "DNI", "ROL", "ID", "ESTADO"};

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

    @Override
    public Object[][] getDatos() {
    Object[][] resultado = new Object[this.indice][8];

    int fila = 0;
    for (Persona persona : this.personas) {
        if (persona instanceof Cliente cliente) {
            // Datos del cliente
            resultado[fila][0] = cliente.getNombres();
            resultado[fila][1] = cliente.getApellidos();
            resultado[fila][2] = cliente.getEdad();
            resultado[fila][3] = cliente.getCorreoElectronico();
            resultado[fila][4] = cliente.getDNI();
            resultado[fila][5] = cliente.getRol();

            Carnet carnet = cliente.getCarnet(); 
            if (carnet != null) {
                resultado[fila][6] = carnet.getId_carnet();
                resultado[fila][7] = carnet.getEstado();
            } else {
                resultado[fila][6] = "Sin ID";
                resultado[fila][7] = "Sin estado";
            }
            fila++;
        }
    }
    return resultado;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void guardarClientesEnArchivo(String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Persona persona : this.personas) {
                if (persona instanceof Cliente cliente) {
                // Guardar datos del cliente
                writer.write(cliente.getNombres() + "," +
                             cliente.getApellidos() + "," +
                             cliente.getEdad() + "," +
                             cliente.getCorreoElectronico() + "," +
                             cliente.getTelefono() + "," +
                             cliente.getDNI() + "," +
                             cliente.getRol() + ",");

                // Guardar datos del carnet asociado
                Carnet carnet = cliente.getCarnet();
                if (carnet != null) {
                    writer.write(carnet.getId_carnet() + "," + carnet.getEstado());
                } else {
                    writer.write("Sin ID,Sin estado");
                }
                writer.newLine(); // Salto de línea para el siguiente cliente
            }
        }
    } catch (IOException e) {
        System.out.println("Error al guardar en el archivo: " + e.getMessage());
    }
}


    public void cargarClientesDesdeArchivo(String rutaArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");

                // Validar si la línea tiene los campos esperados
                if (partes.length == 9) {
                    // Crear un nuevo objeto Cliente a partir de los datos del archivo
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
                    Cliente cliente = new Cliente(nombres, apellidos, edad, correoElectronico, telefono, dni, rol, carnet);

                // Agregar el cliente al arreglo de personas
                agregarPersona(cliente);
            }
        }
    } catch (IOException e) {
        System.out.println("Error al leer del archivo: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.out.println("Error al convertir datos numéricos: " + e.getMessage());
    }
}

    public void guardarAdminsEnArchivo(String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Persona persona : this.personas) {
                if (persona instanceof Administrador administrador) {
                // Guardar datos del cliente
                writer.write(administrador.getID_admin() + "," +
                             administrador.getNombres() + "," +
                             administrador.getApellidos() + "," +
                             administrador.getEdad() + "," +
                             administrador.getCorreoElectronico() + "," +
                             administrador.getTelefono() + "," +
                             administrador.getRol() + "," +
                             administrador.getID_admin());
                writer.newLine(); // Salto de línea para el siguiente cliente
            }
        }
    } catch (IOException e) {
        System.out.println("Error al guardar en el archivo: " + e.getMessage());
    }
}
    
    public void cargarAdminsDesdeArchivo(String rutaArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");

                // Validar si la línea tiene los campos esperados
                if (partes.length == 8) {
                    // Crear un nuevo objeto Cliente a partir de los datos del archivo
                    String id = partes[0].trim();
                    String nombres = partes[1].trim();
                    String apellidos = partes[2].trim();
                    int edad = Integer.parseInt(partes[3].trim());
                    String correoElectronico = partes[4].trim();
                    String Telefono = partes[5].trim();
                    String dni = partes[6].trim();
                    String rol = partes[7].trim();

                    Administrador administrador = new Administrador(id,nombres, apellidos, edad, correoElectronico, Telefono, dni, rol);
                // Agregar el cliente al arreglo de personas
                agregarPersona(administrador);
            }
        }
    } catch (IOException e) {
        System.out.println("Error al leer del archivo: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.out.println("Error al convertir datos numéricos: " + e.getMessage());
    }
}
}
