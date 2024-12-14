/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import vista.LoginAdminCliente;
import vista.RegistroCliente;
import vista.VentanaRegistroAdmin;
import vista.MenuAdmin;
import vista.MenuCliente;
import vista.RegistroMulta;
import vista.VentanaAdminCarnet;
import vista.VentanaAgragarMulta;
import vista.VentanaAgregarLibro;
import vista.VentanaBuscarCarnet;
import vista.VentanaClienteBuscarCarnet;
import vista.VentanaPagarMulta;
import vista.VentanaPrestamoLibro;
import vista.VentanaRegistroCarnet;
import vista.VentanaRegistroLibros;
import vista.VentanaVerificarLibro;
import vista.VentanaBuscarLibroAdmin;
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
import vista.VentanaEliminarLibro;
import vista.VentanaModificarLibro;
import vista.VentanaVerPrestamos;

public class ControladorAdmin {
    private LoginAdminCliente ventana1;
    private VentanaRegistroAdmin ventana2;
    private RegistroMulta ventana4;
    private VentanaAdminCarnet ventana5;
    private VentanaAgragarMulta ventana6;
    private VentanaAgregarLibro ventana7;
    private VentanaBuscarCarnet ventana8;
    private VentanaRegistroCarnet ventana12;
    private VentanaRegistroLibros ventana13;
    private VentanaVerificarLibro ventana14;
    private MenuAdmin ventana15;
    private VentanaEliminarLibro ventana16;
    private VentanaModificarLibro ventana17;
    private VentanaBuscarLibroAdmin ventana18;
    private VentanaVerPrestamos ventana19;
    private ArregloPersona personas;
    private ArregloCarnet carnets;
    private ArregloLibro libros;
    private ArregloMulta multas;
    private ArregloPrestamo prestamos;
    private Carnet carnet;
    private Cliente cliente;
    private Libro libro;
    private Multa multa;
    private PrestacionLibro prestamo;

    public ControladorAdmin(LoginAdminCliente ventana1, VentanaRegistroAdmin ventana2, RegistroMulta ventana4, VentanaAdminCarnet ventana5, VentanaAgragarMulta ventana6, VentanaAgregarLibro ventana7, VentanaBuscarCarnet ventana8, VentanaRegistroCarnet ventana12, VentanaRegistroLibros ventana13, VentanaVerificarLibro ventana14, MenuAdmin ventana15, VentanaEliminarLibro ventana16, VentanaModificarLibro ventana17, VentanaBuscarLibroAdmin ventana18, VentanaVerPrestamos ventana19, ArregloPersona personas, Administrador administrador, ArregloCarnet carnets, ArregloLibro libros, ArregloMulta multas, ArregloPrestamo prestamos, Carnet carnet, Cliente cliente, Libro libro, Multa multa, PrestacionLibro prestamo) {
        this.ventana1 = ventana1;
        this.ventana2 = ventana2;
        this.ventana4 = ventana4;
        this.ventana5 = ventana5;
        this.ventana6 = ventana6;
        this.ventana7 = ventana7;
        this.ventana8 = ventana8;
        this.ventana12 = ventana12;
        this.ventana13 = ventana13;
        this.ventana14 = ventana14;
        this.ventana15 = ventana15;
        this.ventana16 = ventana16;
        this.ventana17 = ventana17;
        this.ventana18 = ventana18;
        this.ventana19 = ventana19;
        this.personas = personas;
        this.carnets = carnets;
        this.libros = libros;
        this.multas = multas;
        this.prestamos = prestamos;
        
        this.ventana2.btnRgistroAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registroAdmin();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana2.btnInicioAdmin1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesionAdmin();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana2.btnVolverventanalogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana2.setVisible(false);
                ventana1.setLocationRelativeTo(null);
                ventana1.setVisible(true);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana15.btnRegreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana15.setVisible(false);
                ventana1.setLocationRelativeTo(null);
                ventana1.setVisible(true);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana15.btnMenuCarnet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana15.setVisible(false);
                ventana5.setLocationRelativeTo(null);
                ventana5.setVisible(true);
                settable();
                actualizarTabla();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana15.btnMenuMulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana15.setVisible(false);
                ventana4.setLocationRelativeTo(null);
                ventana4.setVisible(true);
                settableMulta();
                actualizarTablaMultas();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana15.btnMenuRegistroLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana15.setVisible(false);
                settableLibro();
                ventana13.setLocationRelativeTo(null);
                ventana13.setVisible(true);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana15.btnMenuVerificarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana15.setVisible(false);
                ventana18.setLocationRelativeTo(null);
                ventana18.setVisible(true);
                limpiarBuscarLibro();
                settableBuscarLibro();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana15.btnVerPrestamos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana15.setVisible(false);
                ventana19.setLocationRelativeTo(null);
                ventana19.setVisible(true);
                settablePrestamo();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana5.btnAñadirCarnet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana12.setLocationRelativeTo(null);
                ventana12.setVisible(true);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana5.btnCambiarEstadoCarnet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana8.setLocationRelativeTo(null);
                ventana8.setVisible(true);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana5.btnActualizarTabla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarTabla();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana5.btnregresoInicio.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana5.setVisible(false);
                ventana15.setLocationRelativeTo(null);
                ventana15.setVisible(true);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana12.btnVolverventanaCarnet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana12.setVisible(false);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana12.btnRegistroCarnet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistroCarnet();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana8.btnBusquedaCarnet1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarCarnet();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana8.btnBloquearCarnet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bloquearCarnet();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana8.btnDesactivarCarnet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desactivarCarnet();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana8.btnActivarCarnet.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActivarCarnet();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana8.btnVolverventanaCarnetAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarBuscarCarnet();
                ventana8.setVisible(false);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana13.btnAñadirLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana7.setLocationRelativeTo(null);
                ventana7.setVisible(true);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana13.btnRegreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana13.setVisible(false);
                ventana15.setLocationRelativeTo(null);
                ventana15.setVisible(true);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana13.btnVerificarLibroEjemplar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana14.setLocationRelativeTo(null);
                ventana14.setVisible(true);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana13.btnActualizartabla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settableLibro();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana7.btnRegistrarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                añadirLibro();
                ventana7.setVisible(true);
                ventana7.setVisible(false);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana7.btnVolverVentanaLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana7.setVisible(false);
                
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana14.btnVerificarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarLibro();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana14.btnVolverventanalibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarVerificarLibro();
                ventana14.setVisible(false);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana4.btnActualizarTabla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarTablaMultas();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana4.btnAgregarMulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana6.setLocationRelativeTo(null);
                ventana6.setVisible(true);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana4.btnregresoInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana4.setVisible(false);
                ventana15.setLocationRelativeTo(null);
                ventana15.setVisible(true);
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });

        this.ventana6.btnVolverventanaMulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarDatosMulta();
                ventana6.setVisible(false);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
        this.ventana6.bnañadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                añadirMulta();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
        this.ventana13.btnEliminarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana16.setLocationRelativeTo(null);
                ventana16.setVisible(true);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
        this.ventana16.btnVolverEliminarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarEliminarLibro();
                ventana16.setVisible(false);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
        this.ventana13.btnModificarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana17.setLocationRelativeTo(null);
                ventana17.setVisible(true);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
        this.ventana17.btnVolverModificarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarModificarLibro();
                ventana17.setVisible(false);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
        this.ventana16.btnEliminarLibroPorEjemplar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            eliminarLibroEjemplar();
            }
        });
        
        this.ventana17.btnModificarLosEjemplares.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            modificarLibro();
            }
        });
        this.ventana18.btnregresoInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana18.setVisible(false);
                ventana15.setLocationRelativeTo(null);
                ventana15.setVisible(true);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana18.btnbuscarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarLibroPorNombre();
                limpiarBuscarLibro();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana19.btnregresoInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana19.setVisible(false);
                ventana15.setLocationRelativeTo(null);
                ventana15.setVisible(true);
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana19.btnActualizarTablaPrestamos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settablePrestamo();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
    }
    
    public void iniciar(){
        ventana1.setLocationRelativeTo(null);
        ventana1.setVisible(true);
    }
    
    private void vincularCarnetsYMultas() {
        for (Multa multa : multas.mostrarMultas()) {
            if (multa != null && multa.getCliente() != null) {
                int idCarnet = multa.getCliente().getCarnet().getId_carnet();
                Carnet carnet = carnets.BuscarCarnet(idCarnet);
                if (carnet != null) {
                    carnet.setMulta(multa);
                    multa.getCliente().setCarnet(carnet);
                }
            }
        }
    }
    
    
    public void settable(){
        String[] cabeceras = personas.getcabecera();
        DefaultTableModel modelotabla = new DefaultTableModel(personas.getDatos(), cabeceras);
        this.ventana5.TablaCarnet.setModel(modelotabla);
    }
    private void actualizarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) ventana5.TablaCarnet.getModel();
        modelo.setRowCount(0);

        for (Persona persona : personas.mostrarPersonas()) {
            if (persona instanceof Cliente) {
                Cliente cliente = (Cliente) persona;

                Object[] fila = {
                    cliente.getNombres(),
                    cliente.getApellidos(),
                    cliente.getEdad(),
                    cliente.getCorreoElectronico(),
                    cliente.getDNI(),
                    cliente.getRol(),
                    cliente.getCarnet().getId_carnet(),
                    cliente.getCarnet().getEstado()
                };
            modelo.addRow(fila);
            }
        }
    }
    
    
    public void settableLibro(){
        String[] cabeceras = libros.getcabecera();
        Object[][] datos = libros.getDatos();
        DefaultTableModel modelotabla = new DefaultTableModel(libros.getDatos(), cabeceras);
        this.ventana13.TablaLibros.setModel(modelotabla);
    }
     
    public void settableMulta(){
        String[] cabeceras = multas.getcabecera();
        DefaultTableModel modelotabla = new DefaultTableModel(multas.getDatos(), cabeceras);
        this.ventana4.TablaMulta.setModel(modelotabla);
    }
    private void actualizarTablaMultas() {
        DefaultTableModel modelo = (DefaultTableModel) ventana4.TablaMulta.getModel();
        modelo.setRowCount(0);
        Multa[] todasLasMultas = multas.mostrarMultas();
        for (Multa multa : todasLasMultas) {
            if (multa != null) { 
                Object[] fila = {
                    multa.getMonto(),
                    multa.getFecha(), 
                    multa.getCliente().getNombres() + " " + multa.getCliente().getApellidos(), 
                    multa.getEstado()
                };
                modelo.addRow(fila);
            }
        }
    }

    public void settableBuscarLibro(){
        String[] cabeceras = {"Nombre", "Autor", "Editorial", "Genero", "Fecha de Publicacion", "Ejemplar", "Estado"};
        DefaultTableModel modelotabla = new DefaultTableModel(cabeceras,0);
        this.ventana18.TablaResultados.setModel(modelotabla);
    }
    
    private void buscarLibroPorNombre() {
    try {
        String nombreLibro = ventana18.NombreLibroBuscar.getText().trim();

        if (nombreLibro.isEmpty()) {
            JOptionPane.showMessageDialog(ventana18, "Por favor, ingrese el nombre del libro.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Libro libroEncontrado = libros.buscarLibroPorNombre(nombreLibro);

        if (libroEncontrado != null) {
            DefaultTableModel modelo = (DefaultTableModel) ventana18.TablaResultados.getModel();
            modelo.setRowCount(0); 
            for (Ejemplar ejemplar : libroEncontrado.getEjemplares()) {
                if (ejemplar != null) {
                    Object[] fila = {
                        libroEncontrado.getNombre(),
                        libroEncontrado.getAutor(),
                        libroEncontrado.getEditorial(),
                        libroEncontrado.getGenero(),
                        libroEncontrado.getFechaPublicacion(),
                        ejemplar.getID_Ejemplar(),
                        ejemplar.getEstado()
                    };
                    modelo.addRow(fila);
                }
            }

            JOptionPane.showMessageDialog(ventana18, "Libro encontrado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(ventana18, "No se encontró el libro con el nombre especificado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(ventana18, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void settablePrestamo(){
        String[] cabeceras = prestamos.getCabecera();
        DefaultTableModel modeloTabla = new DefaultTableModel(prestamos.getDatos(), cabeceras);
        ventana19.TablaResultados.setModel(modeloTabla);
    }   
    
    private void añadirMulta() {
        try {
            int idCarnet = Integer.parseInt(ventana6.IdCarnet.getText().trim());
            Carnet carnet = carnets.BuscarCarnet(idCarnet);

            if (carnet != null) {
                Cliente cliente = (Cliente) personas.buscarPersonaPorIdCarnet(idCarnet);
                if (cliente != null) {
                    Multa nuevaMulta = new Multa(100.0f, cliente, "pendiente"); // Puedes ajustar el monto de la multa según sea necesario
                    multas.AgregarMulta(nuevaMulta);
                    carnet.setMulta(nuevaMulta);
                    multas.guardarArchivo("Multas.txt");                   
                    settableMulta();
                    actualizarTablaMultas();
                    vincularCarnetsYMultas();
                    JOptionPane.showMessageDialog(ventana6, "Multa añadida correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(ventana6, "Cliente no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(ventana6, "ID de carnet no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(ventana6, "Error: Verifique que el ID sea correcto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void registroAdmin(){
        String nombres = ventana2.NombreAdmin.getText().trim();
        String apellidos = ventana2.ApellidoAdmin.getText().trim();
        String DNI = ventana2.DniAdmin.getText().trim();
        String Correo = ventana2.CorreoAdmin.getText().trim();
        String Telefono = ventana2.TelefonoAdmin.getText().trim();
        String Edad = ventana2.EdadAdmin.getText().trim();
            if (!nombres.isEmpty() || !apellidos.isEmpty() || !DNI.isEmpty() || !Correo.isEmpty() || !Telefono.isEmpty() || !Edad.isEmpty()) {
                int edad = Integer.parseInt(Edad);
                Administrador administrador = new Administrador(DNI,nombres, apellidos, edad, Correo, Telefono, DNI, "sin_rol");
                administrador.setRol("Administrador");
                personas.agregarPersona(administrador);
                JOptionPane.showMessageDialog(ventana2, "Registro exitoso, su codigo de ingreso es " + administrador.getID_admin());
                personas.guardarArchivo("Administrador.txt");
                limpiarRegistroAdmin();
                ventana2.setVisible(false);
                ventana15.setLocationRelativeTo(null);
                ventana15.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(ventana2, "No ha ingresado alguno de los parametros pedidos, intente de nuevo");
            }
    }
    
    public void iniciarSesionAdmin(){
        try {
            String ID = ventana2.IdInicioSesionAdmin.getText().trim();
                if(!ID.isEmpty()){
                    Administrador administrador = (Administrador) personas.buscarAdminPorID(ID);
                    if(administrador != null){
                        JOptionPane.showMessageDialog(ventana2, "Inicio exitoso");
                        ventana2.setVisible(false);
                        ventana15.setLocationRelativeTo(null);
                        ventana15.setVisible(true);
                        limpiarRegistroAdmin();
                    }else {
                        JOptionPane.showMessageDialog(ventana2, "Fallo al iniciar sesion, el id no cuenta con los permisos necesarios");    
                    }
                } else {
                    JOptionPane.showMessageDialog(ventana2, "No deje los espacios en blanco");    
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ventana2, "Error al ingresar la id");
                }
    }
    
    public void RegistroCarnet(){
        try {
            int id = Integer.parseInt(ventana12.DniCliente.getText().trim());
            String nombres = ventana12.NombreCliente.getText().trim();
            String apellidos = ventana12.ApellidoCliente.getText().trim();
            String correo = ventana12.CorreoCliente.getText().trim();
            String telefono = ventana12.TelefonoCliente.getText().trim();
            String dni=ventana12.DniCliente.getText().trim();
            int edad = Integer.parseInt(ventana12.EdadCliente.getText().trim());

            if (nombres.isEmpty() || apellidos.isEmpty() || correo.isEmpty() || telefono.isEmpty()) {
                JOptionPane.showMessageDialog(ventana12, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Carnet nuevoCarnet = new Carnet(id, "activo"); 
            Cliente nuevoCliente = new Cliente(nombres, apellidos,edad,correo,telefono,dni,"Cliente", nuevoCarnet);
            carnets.AgregarCarnet(nuevoCarnet);
            personas.agregarPersona(nuevoCliente);
            personas.guardarClientesEnArchivo("Clientes.txt");
            settable();
            actualizarTabla();
            JOptionPane.showMessageDialog(ventana12, "Carnet registrado correctamente para " + nombres + " " + apellidos, "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCamposCarnet();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(ventana12, "Error: Verifique que todos los campos numéricos sean correctos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private void buscarCarnet() {
        try {
            int id = Integer.parseInt(ventana8.IdCarnet1.getText().trim());
            Carnet carnet = carnets.BuscarCarnet(id);
            if (carnet != null) {
                ventana8.EstadoCarnet.setText(carnet.getEstado());
                Cliente cliente = buscarClientePorCarnet(carnet);
                if (cliente != null) {
                    ventana8.ClienteCarnet1.setText(cliente.getNombres() + " " + cliente.getApellidos());
                    Multa multa = buscarMultaPorCliente(cliente);
                    if (multa != null && multa.getEstado().equals("pendiente")) {
                       ventana8.DeudasClientes.setText("Sí, pendiente: " + multa.getMonto() + "$.");
                    } else {
                        ventana8.DeudasClientes.setText("No");
                    }
                } else {
                    ventana8.ClienteCarnet1.setText("Cliente no encontrado");
                    ventana8.DeudasClientes.setText("No aplica");
                }
                JOptionPane.showMessageDialog(ventana8, "Carnet encontrado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(ventana8, "Carnet no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(ventana8, "Por favor, ingrese un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
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

    private void bloquearCarnet() {
        try {
            int id = Integer.parseInt(ventana8.IdCarnet1.getText().trim());
            boolean resultado = carnets.CambiarBloqueado(id);
            if (resultado) {
                personas.CambiarCarnetCliente(id, "bloqueado");
                ventana8.EstadoCarnet.setText("bloqueado");
                personas.ActualizarArchivo("Clientes.txt", id, "bloqueado");
                multas.ActualizarArchivo("Multas.txt", id, "bloqueado");
                actualizarTabla();
                actualizarTablaMultas();
                JOptionPane.showMessageDialog(ventana8, "Carnet bloqueado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(ventana8, "No se pudo bloquear el carnet. Verifique el ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(ventana8, "Por favor, ingrese un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void desactivarCarnet() {
        try {
            int id = Integer.parseInt(ventana8.IdCarnet1.getText().trim());
            boolean resultado = carnets.CambiarInactivo(id);
            if (resultado) {
                personas.CambiarCarnetCliente(id, "inactivo");
                ventana8.EstadoCarnet.setText("inactivo");
                personas.ActualizarArchivo("Clientes.txt", id, "inactivo");
                multas.ActualizarArchivo("Multas.txt", id, "inactivo");
                actualizarTabla();
                actualizarTablaMultas();
                JOptionPane.showMessageDialog(ventana8, "Carnet desactivado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(ventana8, "No se pudo desactivar el carnet. Verifique el ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(ventana8, "Por favor, ingrese un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void ActivarCarnet() {
        try {
            int id = Integer.parseInt(ventana8.IdCarnet1.getText().trim());
            boolean resultado = carnets.CambiarActivo(id);
            if (resultado) {
                personas.CambiarCarnetCliente(id, "activo");
                ventana8.EstadoCarnet.setText("activo");
                personas.ActualizarArchivo("Clientes.txt", id, "activo");
                multas.ActualizarArchivo("Multas.txt", id, "activo");
                actualizarTabla();
                actualizarTablaMultas();
                JOptionPane.showMessageDialog(ventana8, "Carnet activado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(ventana8, "No se pudo activar el carnet. Verifique el ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(ventana8, "Por favor, ingrese un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void añadirLibro(){
        try {
            String Nombre = ventana7.NombreLibro.getText().trim();
            String autor = ventana7.AutorLibro.getText().trim();
            String editorial = ventana7.EditorialLibro.getText().trim();
            String Publicacion = ventana7.FechaPublicacionLibro.getText().trim();
            String Genero = ventana7.GeneroLibro.getText().trim();
            int Ejemplares = Integer.parseInt(ventana7.NroEjemplares.getText().trim());
            
            if(Nombre.isEmpty() || autor.isEmpty() || editorial.isEmpty() || Publicacion.isEmpty() || Genero.isEmpty()){
                JOptionPane.showMessageDialog(ventana7, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            Libro libro = new Libro(Nombre, autor, editorial, Genero, Publicacion, Ejemplares);
            libros.agregarLibro(libro);
            libros.guardarArchivo("Libros.txt");
            settableLibro();
            JOptionPane.showMessageDialog(ventana7, "Registro exitoso del libro" );
            limpiarCamposLibro();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(ventana7, "Error: Verifique que todos los campos numéricos sean correctos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private void verificarLibro() {
        String nombreLibro = ventana14.NombreLibroVerificar.getText().trim();

        if (nombreLibro.isEmpty()) {
            JOptionPane.showMessageDialog(ventana14, "Por favor, ingrese el nombre del libro.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Libro libroEncontrado = libros.buscarLibroPorNombre(nombreLibro);

        if (libroEncontrado != null) {
            if (libroEncontrado.hayEjemplaresDisponibles()) {
                JOptionPane.showMessageDialog(ventana14, "El libro '" + nombreLibro + "' está disponible y tiene ejemplares disponibles.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(ventana14, "El libro '" + nombreLibro + "' no tiene ejemplares disponibles.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(ventana14, "No se encontró el libro en el sistema.", "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    private void eliminarLibroEjemplar() {
        try {
            String nombreLibro = ventana16.NombreLibroEliminar.getText().trim();
        
            if (nombreLibro.isEmpty()) {
                JOptionPane.showMessageDialog(ventana16, "Por favor, ingrese el nombre del libro a eliminar un ejemplar.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            libros.eliminarEjemplarDeLibro(nombreLibro);

            settableLibro();

            JOptionPane.showMessageDialog(ventana16, "Ejemplar eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(ventana16, "Error al eliminar el ejemplar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void modificarLibro() {
        try {
            String nombre = ventana17.NombreLibroModificar.getText().trim();
            String autor = ventana17.AutorLibroModificar.getText().trim();
            String genero = ventana17.GeneroLibroModificar.getText().trim();
            String fechaPublicacion = ventana17.PublicacionLibroModificar.getText().trim();
            String editorial = ventana17.EditorialLibroModificar.getText().trim();
            int nroEjemplares = Integer.parseInt(ventana17.NEjemplaresLibroModificar.getText().trim());
            
            // Buscar el libro a modificar por nombre 
            Libro libro = libros.buscarLibroPorNombre(nombre);

            if (libro != null) {
                libro.setNombre(nombre);
                libro.setAutor(autor);
                libro.setGenero(genero);
                libro.setFechaPublicacion(fechaPublicacion);
                libro.setEditorial(editorial);
                libro.setNrjemeplares(nroEjemplares);

                libros.guardarArchivo("Libros.txt");
                JOptionPane.showMessageDialog(ventana17, "Libro modificado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                ventana17.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(ventana17, "El libro no fue encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(ventana17, "Error: Verifique los campos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    private void limpiarCamposCarnet() {
        ventana12.DniCliente.setText("");
        ventana12.NombreCliente.setText("");
        ventana12.ApellidoCliente.setText("");
        ventana12.CorreoCliente.setText("");
        ventana12.TelefonoCliente.setText("");
        ventana12.EdadCliente.setText("");
    }
    
    private void limpiarRegistroAdmin(){
        ventana2.NombreAdmin.setText("");
        ventana2.ApellidoAdmin.setText("");
        ventana2.CorreoAdmin.setText("");
        ventana2.DniAdmin.setText("");
        ventana2.EdadAdmin.setText("");
        ventana2.TelefonoAdmin.setText("");
        ventana2.IdInicioSesionAdmin.setText("");
    }
    
    private void limpiarCamposLibro() {
        ventana7.NombreLibro.setText("");
        ventana7.AutorLibro.setText("");
        ventana7.EditorialLibro.setText("");
        ventana7.GeneroLibro.setText("");
        ventana7.FechaPublicacionLibro.setText("");
        ventana7.NroEjemplares.setText("");
    }
    
    private void limpiarBuscarCarnet(){
        ventana8.ClienteCarnet1.setText("");
        ventana8.DeudasClientes.setText("");
        ventana8.EstadoCarnet.setText("");
        ventana8.IdCarnet1.setText("");
    }
    
    private void limpiarDatosMulta(){
        ventana6.ClienteCarnet.setText("");
        ventana6.IdCarnet.setText("");
    }
    
    private void limpiarVerificarLibro(){
        ventana14.NombreLibroVerificar.setText("");
    }
    
    private void limpiarEliminarLibro(){
        ventana16.NombreLibroEliminar.setText("");
    }
    
    private void limpiarModificarLibro(){
        ventana17.NombreLibroModificar.setText("");
        ventana17.AutorLibroModificar.setText("");
        ventana17.EditorialLibroModificar.setText("");
        ventana17.GeneroLibroModificar.setText("");
        ventana17.PublicacionLibroModificar.setText("");
        ventana17.NEjemplaresLibroModificar.setText("");
    }
    private void limpiarBuscarLibro(){
        ventana18.NombreLibroBuscar.setText("");
    }
}
