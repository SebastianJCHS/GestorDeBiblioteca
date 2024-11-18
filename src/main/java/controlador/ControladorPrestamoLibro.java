/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import Modelo.Cliente;
import Modelo.Carnet;
import Modelo.Libro;
import Modelo.ArregloLibro;
import Modelo.PrestacionLibro;
import Modelo.ArregloPrestamo;
import vista.VentanaPrestamoLibro;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPrestamoLibro {

    private ArregloLibro arregloLibro;
    private ArregloPrestamo arregloPrestamo;
    private VentanaPrestamoLibro vista;
    private Cliente cliente; // Cliente registrado que se pasa desde ControladorRegistroCarnet

    public ControladorPrestamoLibro(ArregloLibro arregloLibro, ArregloPrestamo arregloPrestamo, VentanaPrestamoLibro vista, Cliente cliente) {
        this.arregloLibro = arregloLibro;
        this.arregloPrestamo = arregloPrestamo;
        this.vista = vista;
        this.cliente = cliente; // Cliente existente que se reutiliza

        this.vista.btnPrestamoLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarPrestamo();
            }
        });

        this.vista.btnregresoInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volver();
            }
        });
    }

    public void iniciar() {
        vista.setVisible(true);
    }

    private void realizarPrestamo() {
        try {
            String fechaPrestamo = vista.textFechaPrestamo.getText().trim();
            String fechaDevolucion= vista.textFechaDevolucion.getText().trim();
            String nombreLibro = vista.NombreLibroPrestamo.getText().trim();

            if (nombreLibro.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Por favor, ingrese el nombre del libro.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Buscar el libro
            Libro libroEncontrado = arregloLibro.buscarLibroPorNombre(nombreLibro);

            if (libroEncontrado != null) {
                // Utilizar el cliente existente con su carnet
                Carnet carnet = cliente.getCarnet();

                if ("activo".equalsIgnoreCase(carnet.getEstado())) {
                    PrestacionLibro prestamo = new PrestacionLibro(fechaPrestamo, fechaDevolucion, libroEncontrado, cliente);

                    System.out.println("\nSOLICITAR PRÉSTAMO");
                    if (prestamo.solicitarPrestamo()) {
                        arregloPrestamo.AgregarPrestamo(prestamo);
                        System.out.println("PRÉSTAMO EXITOSO");
                        JOptionPane.showMessageDialog(vista, "Préstamo realizado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        System.out.println("NO HAY EJEMPLARES");
                        JOptionPane.showMessageDialog(vista, "No hay ejemplares disponibles para este libro.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    System.out.println("\nARREGLO DE PRÉSTAMOS");
                    arregloPrestamo.mostrarPrestamos();

                } else {
                    JOptionPane.showMessageDialog(vista, "El carnet no está activo.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                System.out.println("NO SE ENCONTRÓ EL LIBRO");
                JOptionPane.showMessageDialog(vista, "No se encontró el libro en el sistema.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Error: Verifique que los campos numéricos sean correctos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void volver() {
        vista.dispose();
    }
}

