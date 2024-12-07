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

    public ControladorAdmin(LoginAdminCliente ventana1, VentanaRegistroAdmin ventana2, RegistroMulta ventana4, VentanaAdminCarnet ventana5, VentanaAgragarMulta ventana6, VentanaAgregarLibro ventana7, VentanaBuscarCarnet ventana8, VentanaRegistroCarnet ventana12, VentanaRegistroLibros ventana13, VentanaVerificarLibro ventana14, MenuAdmin ventana15, ArregloPersona personas, Administrador administrador, ArregloCarnet carnets, ArregloLibro libros, ArregloMulta multas, ArregloPrestamo prestamos, Carnet carnet, Cliente cliente, Libro libro, Multa multa, PrestacionLibro prestamo) {
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
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana15.btnMenuRegistroLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana15.setVisible(false);
                ventana13.setLocationRelativeTo(null);
                ventana13.setVisible(true);
                settableLibro();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana15.btnMenuVerificarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana15.setVisible(false);
                ventana14.setLocationRelativeTo(null);
                ventana14.setVisible(true);
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
                settable();
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
        this.ventana8.btnVolverventanaCarnetAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana8.setVisible(false);
                limpiarBuscarCarnet();
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
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana7.btnVolverVentanalibro.addActionListener(new ActionListener() {
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
                ventana14.setVisible(false);
                limpiarVerificarLibro();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.ventana4.btnActualizarTabla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settableMulta();
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
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });

        this.ventana6.btnVolverventanaMulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarMulta();
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
    }
    

    public void settable(){
        String[] cabeceras = personas.getcabecera();
        DefaultTableModel modelotabla = new DefaultTableModel(personas.getDatos(), cabeceras);
        this.ventana5.TablaCarnet.setModel(modelotabla);
    }
    
    public void settableLibro(){
        String[] cabeceras = libros.getcabecera();
        DefaultTableModel modelotabla = new DefaultTableModel(libros.getDatos(), cabeceras);
        this.ventana13.TablaLibros.setModel(modelotabla);
    }
     
    public void settableMulta(){
        String[] cabeceras = multas.getcabecera();
        DefaultTableModel modelotabla = new DefaultTableModel(multas.getDatos(), cabeceras);
        this.ventana4.TablaMulta.setModel(modelotabla);
    }
    
    public void iniciar(){
        ventana1.setLocationRelativeTo(null);
        ventana1.setVisible(true);
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
                    multas.guardarMultasEnArchivo("Multas.txt");
                    settableMulta();
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
                personas.guardarAdminsEnArchivo("Administrador.txt");
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
                Cliente cliente = buscarClientePorCarnet(carnet);
                if (cliente != null) {
                    ventana8.ClienteCarnet1.setText(cliente.getNombres() + " " + cliente.getApellidos());
                    Multa multa = multas.BuscarMulta(cliente);
                    if (multa != null && multa.getEstado().equals("pendiente")) {
                        ventana8.DeudasClientes.setText("Sí, pendiente: " + multa.getMonto() + "$.");
                    } else {
                        ventana8.DeudasClientes.setText("No");
                    }
                } else {
                    ventana8.ClienteCarnet1.setText("Cliente no encontrado");
                    ventana8.DeudasClientes.setText("No aplica");
                }
                ventana8.EstadoCarnet.setText(carnet.getEstado());
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
    
    private void bloquearCarnet() {
        try {
            int id = Integer.parseInt(ventana8.IdCarnet1.getText().trim());
            boolean resultado = carnets.CambiarBloqueado(id);

            if (resultado) {
                ventana8.EstadoCarnet.setText("bloqueado");
                multas.EliminarArchivoMulta("Multas.txt");
                personas.EliminarArchivoPersona("Clientes.txt");
                personas.guardarClientesEnArchivo("Clientes.txt");
                multas.guardarMultasEnArchivo("Multas.txt");
                settable();
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
                ventana8.EstadoCarnet.setText("inactivo");
                multas.EliminarArchivoMulta("Multas.txt");
                multas.guardarMultasEnArchivo("Multas.txt");
                personas.EliminarArchivoPersona("Clientes.txt");
                personas.guardarClientesEnArchivo("Clientes.txt");
                settable();
                JOptionPane.showMessageDialog(ventana8, "Carnet desactivado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(ventana8, "No se pudo desactivar el carnet. Verifique el ID.", "Error", JOptionPane.ERROR_MESSAGE);
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
            libros.guardarLibrosEnArchivo("Libros.txt");
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

        // Buscar el libro en el arreglo
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
    private void limpiarCamposCarnet() {
        ventana12.DniCliente.setText("");
        ventana12.NombreCliente.setText("");
        ventana12.ApellidoCliente.setText("");
        ventana12.CorreoCliente.setText("");
        ventana12.TelefonoCliente.setText("");
        ventana12.EdadCliente.setText("");
    }
     
    private void limpiarCamposLibro() {
        ventana7.NombreLibro.setText("");
        ventana7.AutorLibro.setText("");
        ventana7.EditorialLibro.setText("");
        ventana7.GeneroLibro.setText("");
        ventana7.FechaPublicacionLibro.setText("");
        ventana7.NroEjemplares.setText("");
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
    
    private void limpiarBuscarCarnet(){
        ventana8.ClienteCarnet1.setText("");
        ventana8.DeudasClientes.setText("");
        ventana8.EstadoCarnet.setText("");
        ventana8.IdCarnet1.setText("");
    }
    
    private void limpiarMulta(){
        ventana6.ClienteCarnet.setText("");
        ventana6.IdCarnet.setText("");
    }
    
    private void  limpiarVerificarLibro(){
        ventana14.Ejemplar_Libro_Verificar.setText("");
        ventana14.NombreLibroVerificar.setText("");
    }
     
}
