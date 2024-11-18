/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import Modelo.Carnet;
import Modelo.ArregloCarnet;
import Modelo.Cliente;
import vista.VentanaRegistroCarnet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author ARIAN BEJAR
 */
public class ControladorRegistroCarnet {
    private ArregloCarnet arregloCarnet;
    private VentanaRegistroCarnet vista;

    public ControladorRegistroCarnet(ArregloCarnet arregloCarnet, VentanaRegistroCarnet vista) {
        this.arregloCarnet = arregloCarnet;
        this.vista = vista;
        this.vista.btnRegistroCarnet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarCarnet();
            }
        });
        this.vista.btnVolverventanaCarnet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volver();
            }
        });
    }

    public void iniciar() {
        vista.setVisible(true);
    }

    private void registrarCarnet() {
        try {
            int id = Integer.parseInt(vista.DniCliente.getText().trim());
            String nombres = vista.NombreCliente.getText().trim();
            String apellidos = vista.ApellidoCliente.getText().trim();
            String correo = vista.CorreoCliente.getText().trim();
            String telefono = vista.TelefonoCliente.getText().trim();
            String dni=vista.DniCliente.getText().trim();
            int edad = Integer.parseInt(vista.EdadCliente.getText().trim());

            if (nombres.isEmpty() || apellidos.isEmpty() || correo.isEmpty() || telefono.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Carnet nuevoCarnet = new Carnet(id, "activo"); 
            Cliente nuevoCliente = new Cliente( nombres, apellidos,edad,correo,telefono,dni,"Cliente", nuevoCarnet);
            arregloCarnet.AgregarCarnet(nuevoCarnet);

            JOptionPane.showMessageDialog(vista, "Carnet registrado correctamente para " + nombres + " " + apellidos, "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Error: Verifique que todos los campos numéricos sean correctos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void volver() {
        vista.dispose();
    }

    private void limpiarCampos() {
        vista.DniCliente.setText("");
        vista.NombreCliente.setText("");
        vista.ApellidoCliente.setText("");
        vista.CorreoCliente.setText("");
        vista.TelefonoCliente.setText("");
        vista.EdadCliente.setText("");
    }
}
