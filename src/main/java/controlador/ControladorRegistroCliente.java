/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import Modelo.ArregloCarnet;
import Modelo.ArregloPersona;
import Modelo.Carnet;
import Modelo.Cliente;
import vista.RegistroCliente;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Luis Fernando
 */

public class ControladorRegistroCliente {

    private ArregloCarnet arregloCarnet;
    private ArregloPersona arregloPersona;
    private RegistroCliente vista;

    public ControladorRegistroCliente(ArregloCarnet arregloCarnet, ArregloPersona arregloPersona, RegistroCliente vista) {
        this.arregloCarnet = arregloCarnet;
        this.arregloPersona = arregloPersona;
        this.vista = vista;

        this.vista.btnRgistroCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarCliente();
            }
        });

        this.vista.btnInicioCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion();
            }
        });

        this.vista.btnVolverventanalogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volver();
            }
        });
    }

    public void iniciar() {
        vista.setVisible(true);
    }

    private void registrarCliente() {
        try {
            String nombres = vista.NombreCliente.getText().trim();
            String apellidos = vista.ApellidoCliente.getText().trim();
            int edad = Integer.parseInt(vista.EdadCliente.getText().trim());
            String correo = vista.CorreoCliente.getText().trim();
            String telefono = vista.TelefonoCliente.getText().trim();
            String dni = vista.DniCliente.getText().trim();

            if (nombres.isEmpty() || apellidos.isEmpty() || correo.isEmpty() || telefono.isEmpty() || dni.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int idCarnet = arregloCarnet.getCarnet().length + 1; // Generar un ID de carnet único
            Carnet nuevoCarnet = new Carnet(idCarnet, "activo");
            Cliente nuevoCliente = new Cliente(nombres, apellidos, edad, correo, telefono, dni, "Cliente", nuevoCarnet);

            arregloCarnet.AgregarCarnet(nuevoCarnet);
            arregloPersona.agregarPersona(nuevoCliente);

            JOptionPane.showMessageDialog(vista, "Cliente registrado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Error: Verifique que los campos numéricos sean correctos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void iniciarSesion() {
        try {
            int id = Integer.parseInt(vista.IdInicioSesionCliente.getText().trim());

            Carnet carnet = arregloCarnet.BuscarCarnet(id);
            if (carnet != null) {
                Cliente cliente = (Cliente) arregloPersona.buscarPersonaPorIdCarnet(carnet.getId_carnet());
                if (cliente != null) {
                    JOptionPane.showMessageDialog(vista, "Inicio de sesión exitoso.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    // Aquí puedes agregar el código para redirigir a la siguiente vista después de iniciar sesión
                } else {
                    JOptionPane.showMessageDialog(vista, "Cliente no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(vista, "ID de carnet no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Error: Verifique que el ID sea correcto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void volver() {
        vista.dispose();
    }

    private void limpiarCampos() {
        vista.NombreCliente.setText("");
        vista.ApellidoCliente.setText("");
        vista.EdadCliente.setText("");
        vista.CorreoCliente.setText("");
        vista.TelefonoCliente.setText("");
        vista.DniCliente.setText("");
        vista.IdInicioSesionCliente.setText("");
    }
}