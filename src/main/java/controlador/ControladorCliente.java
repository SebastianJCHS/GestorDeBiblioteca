package controlador;

import vista.MenuCliente;
import vista.RegistroCliente;
import vista.VentanaClienteBuscarCarnet;
import vista.VentanaPrestamoLibro;
import vista.VentanaPagarMulta;
import vista.LoginAdminCliente;
import vista.VentanaBuscarLibro;
import Modelo.Administrador;
import Modelo.ArregloCarnet;
import Modelo.ArregloLibro;
import Modelo.ArregloMulta;
import Modelo.ArregloPersona;
import Modelo.ArregloPrestamo;
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
    private VentanaBuscarLibro ventana8;
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

    public ControladorCliente(VentanaPagarMulta2 ventana7, MenuCliente ventana1, RegistroCliente ventana2, VentanaClienteBuscarCarnet ventana3, VentanaPrestamoLibro ventana4, VentanaPagarMulta ventana5, VentanaBuscarLibro ventana8, ArregloPersona personas, Administrador administrador, ArregloCarnet carnets, ArregloLibro libros, ArregloMulta multas, ArregloPrestamo prestamos, Carnet carnet, Cliente cliente, Libro libro, Multa multa, PrestacionLibro prestamo, LoginAdminCliente ventana6) {
        this.ventana1 = ventana1;
        this.ventana2 = ventana2;
        this.ventana3 = ventana3;
        this.ventana4 = ventana4;
        this.ventana5 = ventana5;
        this.ventana7 = ventana7;
        this.ventana8 = ventana8;
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

        // Configurar listeners para los botones de las vistas
        configurarListeners();
    }

    private void configurarListeners() {
        this.ventana2.btnInicioCliente.addActionListener(e -> {
            iniciarSesion();
            limpiardatosInicio();
        });
        this.ventana2.btnVolverventanalogin.addActionListener(e -> {
            ventana2.setVisible(false);
            ventana6.setLocationRelativeTo(null);
            ventana6.setVisible(true);
        });
        this.ventana1.btnMenuRegistroLibro.addActionListener(e -> {
            ventana1.setVisible(false);
            ventana4.setLocationRelativeTo(null);
            ventana4.setVisible(true);
        });
        this.ventana1.btnMenuMulta.addActionListener(e -> {
            ventana1.setVisible(false);
            ventana5.setLocationRelativeTo(null);
            ventana5.setVisible(true);
            settableMulta();
            actualizarTabla();
        });
        this.ventana1.btnMenuCarnet.addActionListener(e -> {
            ventana1.setVisible(false);
            ventana3.setLocationRelativeTo(null);
            ventana3.setVisible(true);
            buscarCarnet();
        });
        this.ventana1.btnMenuPagarMulta.addActionListener(e -> {
            ventana1.setVisible(false);
            ventana7.setLocationRelativeTo(null);
            ventana7.setVisible(true);
        });
        this.ventana1.btnbuscarLibro.addActionListener(e -> {
            ventana1.setVisible(false);
            ventana8.setLocationRelativeTo(null);
            ventana8.setVisible(true);
            settableLibro();
        });
        this.ventana1.btnregresoInicio.addActionListener(e -> {
            ventana1.setVisible(false);
            ventana6.setLocationRelativeTo(null);
            ventana6.setVisible(true);
        });
        this.ventana3.btnregresoInicio.addActionListener(e -> {
            ventana3.setVisible(false);
            ventana1.setLocationRelativeTo(null);
            ventana1.setVisible(true);
        });
        this.ventana3.btnBusquedaCarnet1.addActionListener(e -> buscarCarnet());
        this.ventana4.btnregresoInicio.addActionListener(e -> {
            ventana4.setVisible(false);
            ventana1.setLocationRelativeTo(null);
            ventana1.setVisible(true);
        });
        this.ventana4.btnPrestamoLibro.addActionListener(e -> realizarPrestamo());
        this.ventana5.btnregresoInicio.addActionListener(e -> {
            ventana5.setVisible(false);
            ventana1.setLocationRelativeTo(null);
            ventana1.setVisible(true);
        });
        this.ventana7.btnVolverPagarMulta.addActionListener(e -> {
            ventana7.setVisible(false);
            ventana1.setLocationRelativeTo(null);
            ventana1.setVisible(true);
        });
        this.ventana7.btnPagar.addActionListener(e -> {
            pagarMulta();
            ventana7.TextPagarMulta.setText("");
        });
        this.ventana8.btnregresoInicio.addActionListener(e -> {
            ventana8.setVisible(false);
            ventana1.setLocationRelativeTo(null);
            ventana1.setVisible(true);
        });
        this.ventana8.btnbuscarLibro.addActionListener(e -> buscarLibroPorNombre());
    }

    public void setID(int id) {
        this.id_actual = id;
    }

    public int getID() {
        return this.id_actual;
    }

    public void settableMulta() {
        String[] cabeceras = multas.getcabecera();
        DefaultTableModel modelotabla = new DefaultTableModel(multas.getDatos(), cabeceras);
        this.ventana5.tbVisualizarMultas.setModel(modelotabla);
    }

    public void actualizarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) ventana5.tbVisualizarMultas.getModel();
        modeloTabla.setRowCount(0);
        Object[] fila = multas.cargarMultasPorCliente(id_actual);
        modeloTabla.addRow(fila);
    }

    public void settableLibro() {
        String[] cabeceras = {"Nombre", "Autor", "Editorial", "Genero", "Fecha de Publicacion", "Ejemplar", "Estado"};
        DefaultTableModel modelotabla = new DefaultTableModel(cabeceras, 0);
        this.ventana8.TablaResultados.setModel(modelotabla);
    }

    private void buscarLibroPorNombre() {
        try {
            String nombreLibro = ventana8.NombreLibroBuscar.getText().trim();

            if (nombreLibro.isEmpty()) {
                JOptionPane.showMessageDialog(ventana8, "Por favor, ingrese el nombre del libro.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Libro libroEncontrado = libros.buscarLibroPorNombre(nombreLibro);

            if (libroEncontrado != null) {
                DefaultTableModel modelo = (DefaultTableModel) ventana8.TablaResultados.getModel();
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

                JOptionPane.showMessageDialog(ventana8, "Libro encontrado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(ventana8, "No se encontró el libro con el nombre especificado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(ventana8, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void iniciarSesion() {
    try {
        int id = Integer.parseInt(ventana2.IdInicioSesionCliente.getText().trim());

        Carnet carnet = carnets.BuscarCarnet(id);
        if (carnet != null) {
            cliente = (Cliente) personas.buscarPersonaPorIdCarnet(carnet.getId_carnet());
            if (cliente != null) {
                JOptionPane.showMessageDialog(ventana2, "Inicio de sesión exitoso.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                ventana2.setVisible(false);
                ventana1.setLocationRelativeTo(null);
                ventana1.setVisible(true);
                setID(id);
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
    

    public void pagarMulta() {
        try {
            String idCliente = ventana7.TextPagarMulta.getText().trim();
            int id = Integer.parseInt(ventana7.TextPagarMulta.getText().trim());

            if (id == id_actual) {
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

                    } else {
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

    private void realizarPrestamo() {
    try {
        String fechaPrestamo = ventana4.textFechaPrestamo.getText().trim();
        String fechaDevolucion = ventana4.textFechaDevolucion.getText().trim();
        String tituloLibro = ventana4.textTituloSeleccionado.getText().trim();
        int numeroEjemplar = Integer.parseInt(ventana4.textNroEjemplar.getText().trim());

        if (fechaPrestamo.isEmpty() || fechaDevolucion.isEmpty() || tituloLibro.isEmpty() || numeroEjemplar <= 0) {
            JOptionPane.showMessageDialog(ventana4, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Libro libro = libros.buscarLibroPorNombre(tituloLibro);
        if (libro == null) {
            JOptionPane.showMessageDialog(ventana4, "No se encontró el libro ingresado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Ejemplar ejemplar = libro.buscarEjemplarPorId(numeroEjemplar);
        if (ejemplar == null) {
            JOptionPane.showMessageDialog(ventana4, "No se encontró el ejemplar ingresado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!ejemplar.getEstado().equalsIgnoreCase("disponible")) {
            JOptionPane.showMessageDialog(ventana4, "El ejemplar no está disponible.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar que el cliente esté correctamente inicializado
        if (cliente == null || cliente.getNombres() == null || cliente.getApellidos() == null || cliente.getDNI() == null) {
            JOptionPane.showMessageDialog(ventana4, "Error: Cliente no está correctamente inicializado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar el estado del carnet del cliente
        Carnet carnet = cliente.getCarnet();
        if (carnet == null || carnet.isinactivo() || carnet.isbloqueado()) {
            String mensajeError = carnet.isinactivo() ? "Su carnet está inactivo." : "Su carnet está bloqueado.";
            JOptionPane.showMessageDialog(ventana4, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PrestacionLibro prestamo = new PrestacionLibro(fechaPrestamo, fechaDevolucion, libro, cliente, ejemplar);
        if (prestamo.solicitarPrestamo()) {
            prestamos.AgregarPrestamo(prestamo);
            prestamo.guardarPrestamoEnArchivo("Prestamos.txt");
            libros.actualizarEstadoEjemplarEnArchivo("Libros.txt", libro, ejemplar); // Actualizar el estado del ejemplar en el archivo Libros.txt
            JOptionPane.showMessageDialog(ventana4, "Préstamo realizado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(ventana4, "No se pudo realizar el préstamo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(ventana4, "Error: Verifique que los campos numéricos sean correctos.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void limpiardatosInicio() {
        ventana2.IdInicioSesionCliente.setText("");
    }
}