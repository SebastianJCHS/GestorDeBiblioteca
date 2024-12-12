/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.MenuCliente;
import vista.RegistroCliente;
import vista.VentanaClienteBuscarCarnet;
import vista.VentanaPrestamoLibro;
import vista.VentanaPagarMulta;
import vista.LoginAdminCliente;
import Modelo.Administrador;
import Modelo.ArregloCarnet;
import Modelo.ArregloLibro;
import Modelo.ArregloMulta;
import Modelo.ArregloPersona;
import Modelo.ArregloPersona;
import Modelo.ArregloPrestamo;
import Modelo.Biblioteca;
import Modelo.Carnet;
import Modelo.Cliente;
import Modelo.Ejemplar;
import Modelo.Libro;
import Modelo.Multa;
import Modelo.Persona;
import Modelo.PrestacionLibro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.VentanaPagarMulta2;

public class ControladorCliente {
    private MenuCliente ventana1;
    private RegistroCliente ventana2;
    private VentanaClienteBuscarCarnet ventana3;
    private VentanaPrestamoLibro ventana4;
    private VentanaPagarMulta ventana5;
    private VentanaPagarMulta2 ventana7;
    private ArregloPersona personas;
    private Administrador administrador;
    private ArregloCarnet carnets;
    private ArregloLibro libros;
    private ArregloMulta multas;
    private ArregloPrestamo prestamos;
    private Carnet carnet;
    private Cliente cliente;
    private Libro libro;
    private Multa multa;
    private PrestacionLibro prestamo;
    private LoginAdminCliente ventana6;
    private int id_actual;

    public ControladorCliente(VentanaPagarMulta2 ventana7,MenuCliente ventana1, RegistroCliente ventana2, VentanaClienteBuscarCarnet ventana3, VentanaPrestamoLibro ventana4, VentanaPagarMulta ventana5, ArregloPersona personas, Administrador administrador, ArregloCarnet carnets, ArregloLibro libros, ArregloMulta multas, ArregloPrestamo prestamos, Carnet carnet, Cliente cliente, Libro libro, Multa multa, PrestacionLibro prestamo, LoginAdminCliente ventana6) {
        this.ventana1 = ventana1;
        this.ventana2 = ventana2;
        this.ventana3 = ventana3;
        this.ventana4 = ventana4;
        this.ventana5 = ventana5;
        this.ventana7 = ventana7;
        this.personas = personas;
        this.administrador = administrador;
        this.carnets = carnets;
        this.libros = libros;
        this.multas = multas;
        this.prestamos = prestamos;
        this.carnet = carnet;
        this.cliente = cliente;
        this.libro = libro;
        this.multa = multa;
        this.prestamo = prestamo;
        this.ventana6 = ventana6;
        this.ventana2.btnInicioCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana2.btnVolverventanalogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana2.setVisible(false);
                ventana6.setLocationRelativeTo(null);
                ventana6.setVisible(true);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana1.btnMenuRegistroLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana1.setVisible(false);
                ventana4.setLocationRelativeTo(null);
                ventana4.setVisible(true);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana1.btnMenuMulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana1.setVisible(false);
                ventana5.setLocationRelativeTo(null);
                ventana5.setVisible(true);
                settableMulta();
                actualizarTabla();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana1.btnMenuCarnet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana1.setVisible(false);
                ventana3.setLocationRelativeTo(null);
                ventana3.setVisible(true);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana1.btnregresoInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana1.setVisible(false);
                ventana6.setLocationRelativeTo(null);
                ventana6.setVisible(true);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana1.btnMenuMulta1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana1.setVisible(false);
                ventana7.setLocationRelativeTo(null);
                ventana7.setVisible(true);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana3.btnregresoInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana3.setVisible(false);
                ventana1.setLocationRelativeTo(null);
                ventana1.setVisible(true);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana3.btnBusquedaCarnet1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarCarnet();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana4.btnregresoInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana4.setVisible(false);
                ventana1.setLocationRelativeTo(null);
                ventana1.setVisible(true);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana4.btnPrestamoLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarPrestamo();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana5.btnregresoInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana5.setVisible(false);
                ventana1.setLocationRelativeTo(null);
                ventana1.setVisible(true);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana7.btnVolverPagarMulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana7.setVisible(false);
                ventana1.setLocationRelativeTo(null);
                ventana1.setVisible(true);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
        this.ventana7.btnPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagarMulta();
                ventana7.TextPagarMulta.setText("");
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
    }
    
    private Cliente buscarClientePorCarnet(Carnet carnet) {
        for (Persona persona : personas.mostrarPersonas()) {
            if (persona instanceof Cliente) {
                Cliente cliente = (Cliente) persona;
                if (cliente.getCarnet() != null && cliente.getCarnet().getId_carnet() == carnet.getId_carnet()) {
                    return cliente;
                }
            }
        }
        return null;
    }
    
    private Multa buscarMultaPorCliente(Cliente cliente) {
        for (Multa multa : multas.mostrarMultas()) {
            if (multa != null && multa.getCliente() != null 
                && multa.getCliente().getCarnet().getId_carnet() == cliente.getCarnet().getId_carnet()) {
            return multa;
            }
        }
        return null;
    }
    
    public void setID(int id){
        this.id_actual = id;
    }
    public int getID(){
        return this.id_actual;
    }
    
    public void settableMulta(){
        String[] cabeceras = multas.getcabecera();
        DefaultTableModel modelotabla = new DefaultTableModel(multas.getDatos(), cabeceras);
        this.ventana5.tbVisualizarMultas.setModel(modelotabla);
    }
    
    public void actualizarTabla(){
        DefaultTableModel modeloTabla = (DefaultTableModel) ventana5.tbVisualizarMultas.getModel();
        modeloTabla.setRowCount(0);
        Object[] fila = multas.cargarMultasPorCliente(id_actual);
        modeloTabla.addRow(fila);
    }  
    
    private void iniciarSesion() {
        try {
            int id = Integer.parseInt(ventana2.IdInicioSesionCliente.getText().trim());

            Carnet carnet = carnets.BuscarCarnet(id);
            if (carnet != null) {
                Cliente cliente = (Cliente) personas.buscarPersonaPorIdCarnet(carnet.getId_carnet());
                if (cliente != null) {
                    JOptionPane.showMessageDialog(ventana2, "Inicio de sesión exitoso.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    ventana2.setVisible(false);
                    ventana1.setLocationRelativeTo(null);
                    ventana1.setVisible(true);
                    setID(id);
                    id_actual = carnet.getId_carnet();
                } else {
                    JOptionPane.showMessageDialog(ventana2, "Cliente no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(ventana2, "ID de carnet no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(ventana2, "Error: Verifique que el ID sea correcto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void pagarMulta(){
        try {
            String idCliente = ventana7.TextPagarMulta.getText().trim();
            int id = Integer.parseInt(ventana7.TextPagarMulta.getText().trim());
           
            if(id == id_actual){
                JOptionPane.showMessageDialog(ventana7, "Cliente verificado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                Cliente cliente = (Cliente) personas.buscarPersonaPorIdCliente(idCliente);
                if (cliente != null) {
                    Multa multa = buscarMultaPorCliente(cliente);
                    
                    // Verificar si el cliente tiene deudas
                    if (multa != null && multa.getEstado().equals("pendiente")) {
                        JOptionPane.showMessageDialog(ventana7, "Pago exitoso.", "Boucher", JOptionPane.INFORMATION_MESSAGE);
                        multa.pagarMulta();
                        System.out.println(multa.getEstado());
                        multas.actualizarEstadoMulta("Multas.txt", id, multa.getEstado());
                        
                    }else{
                         JOptionPane.showMessageDialog(ventana7, "Usted no tiene multa", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                JOptionPane.showMessageDialog(ventana7, "Cliente no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(ventana7, "Error: su id no corresponde.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(ventana7, "Error: Verifique que su ID sea correcto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void buscarCarnet() {
        try {
            int idCarnet = id_actual;
            ventana3.IdCarnet1.setText(String.valueOf(idCarnet));
            Carnet carnet = carnets.BuscarCarnet(idCarnet);
            if (carnet != null) {
                Cliente cliente = buscarClientePorCarnet(carnet);
                if (cliente != null) {
                    ventana3.ClienteCarnet1.setText(cliente.getNombres() + " " + cliente.getApellidos());
                    ventana3.EstadoCarnet.setText(carnet.getEstado());
                    Multa multa = buscarMultaPorCliente(cliente);
                    if (multa != null && multa.getEstado().equals("pendiente")) {
                        ventana3.DeudasClientes.setText("Sí");
                    } else {
                        ventana3.DeudasClientes.setText("No");
                    }
                } else {
                    JOptionPane.showMessageDialog(ventana3, "Cliente no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(ventana3, "ID de carnet no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(ventana3, "Error: Verifique que el ID sea correcto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void realizarPrestamo() {
        try {
            String fechaPrestamo = ventana4.textFechaPrestamo.getText().trim();
            String fechaDevolucion= ventana4.textFechaDevolucion.getText().trim();
            String nombreLibro = ventana4.NombreLibroPrestamo.getText().trim();

            if (nombreLibro.isEmpty()) {
                JOptionPane.showMessageDialog(ventana4, "Por favor, ingrese el nombre del libro.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Buscar el libro
            Libro libroEncontrado = libros.buscarLibroPorNombre(nombreLibro);

            if (libroEncontrado != null) {
                // Utilizar el cliente existente con su carnet
                Carnet carnet = cliente.getCarnet();

                if ("activo".equalsIgnoreCase(carnet.getEstado())) {
                    PrestacionLibro prestamo = new PrestacionLibro(fechaPrestamo, fechaDevolucion, libroEncontrado, cliente);

                    System.out.println("\nSOLICITAR PRÉSTAMO");
                    if (prestamo.solicitarPrestamo()) {
                        prestamos.AgregarPrestamo(prestamo);
                        System.out.println("PRÉSTAMO EXITOSO");
                        JOptionPane.showMessageDialog(ventana4, "Préstamo realizado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        System.out.println("NO HAY EJEMPLARES");
                        JOptionPane.showMessageDialog(ventana4, "No hay ejemplares disponibles para este libro.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    System.out.println("\nARREGLO DE PRÉSTAMOS");
                    prestamos.mostrarPrestamos();

                } else {
                    JOptionPane.showMessageDialog(ventana4, "El carnet no está activo.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                System.out.println("NO SE ENCONTRÓ EL LIBRO");
                JOptionPane.showMessageDialog(ventana4, "No se encontró el libro en el sistema.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(ventana4, "Error: Verifique que los campos numéricos sean correctos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
