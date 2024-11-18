/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author ARIAN BEJAR
 */
import Modelo.ArregloLibro;
import Modelo.Libro;
import vista.VentanaVerificarLibro;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVerificarLibro {

    private ArregloLibro arregloLibro;
    private VentanaVerificarLibro vista;

    public ControladorVerificarLibro(ArregloLibro arregloLibro, VentanaVerificarLibro vista) {
        this.arregloLibro = arregloLibro;
        this.vista = vista;

        // Agregar listeners a los botones
        this.vista.btnVerificarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarLibro();
            }
        });

        this.vista.btnVolverventanalibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volver();
            }
        });
    }

    public void iniciar() {
        vista.setVisible(true);
    }

    private void verificarLibro() {
        String nombreLibro = vista.NombreLibroVerificar.getText().trim();

        if (nombreLibro.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Por favor, ingrese el nombre del libro.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Buscar el libro en el arreglo
        Libro libroEncontrado = arregloLibro.buscarLibroPorNombre(nombreLibro);

        if (libroEncontrado != null) {
            if (libroEncontrado.hayEjemplaresDisponibles()) {
                JOptionPane.showMessageDialog(vista, "El libro '" + nombreLibro + "' está disponible y tiene ejemplares disponibles.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(vista, "El libro '" + nombreLibro + "' no tiene ejemplares disponibles.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(vista, "No se encontró el libro en el sistema.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void volver() {
        vista.dispose();
    }
}
