/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import Modelo.ArregloCarnet;
import Modelo.ArregloPersona;
import Modelo.Carnet;
import Modelo.Cliente;
import vista.VentanaClienteBuscarCarnet;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Luis Fernando
 */
public class ControladorClienteBuscarCarnet {
    private ArregloCarnet arregloCarnet;
    private ArregloPersona arregloPersona;
    private VentanaClienteBuscarCarnet vista;

    public ControladorClienteBuscarCarnet(ArregloCarnet arregloCarnet, ArregloPersona arregloPersona, VentanaClienteBuscarCarnet vista) {
        this.arregloCarnet = arregloCarnet;
        this.arregloPersona = arregloPersona;
        this.vista = vista;

        this.vista.btnBusquedaCarnet1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarCarnet();
            }
        });
    }

    public void iniciar() {
        vista.setVisible(true);
    }

    private void buscarCarnet() {
        try {
            int idCarnet = Integer.parseInt(vista.IdCarnet1.getText().trim());

            Carnet carnet = arregloCarnet.BuscarCarnet(idCarnet);
            if (carnet != null) {
                Cliente cliente = (Cliente) arregloPersona.buscarPersonaPorIdCarnet(idCarnet);
                if (cliente != null) {
                    vista.ClienteCarnet1.setText(cliente.getNombres() + " " + cliente.getApellidos());
                    vista.EstadoCarnet.setText(carnet.getEstado());

                    // Verificar si el cliente tiene deudas
                    if (cliente.getCarnet().getMulta() != null && "pendiente".equals(cliente.getCarnet().getMulta().getEstado())) {
                        vista.DeudasClientes.setText("Sí");
                    } else {
                        vista.DeudasClientes.setText("No");
                    }
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
    
}
