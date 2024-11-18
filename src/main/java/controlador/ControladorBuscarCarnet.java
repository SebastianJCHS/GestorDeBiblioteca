/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ArregloCarnet;
import Modelo.Carnet;
import Modelo.Cliente;
import Modelo.Multa;
import Modelo.ArregloMulta;
import Modelo.ArregloPersona;
import Modelo.Persona;
import vista.VentanaBuscarCarnet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorBuscarCarnet {

    private ArregloCarnet arregloCarnet;
    private ArregloMulta arregloMulta;
    private ArregloPersona arregloPersona;
    private VentanaBuscarCarnet vista;

    public ControladorBuscarCarnet(ArregloCarnet arregloCarnet, ArregloMulta arregloMulta, ArregloPersona arregloPersona, VentanaBuscarCarnet vista) {
        this.arregloCarnet = arregloCarnet;
        this.arregloMulta = arregloMulta;
        this.arregloPersona = arregloPersona;
        this.vista = vista;
        this.vista.btnBusquedaCarnet1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarCarnet();
            }
        });
        this.vista.btnBloquearCarnet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bloquearCarnet();
            }
        });
        this.vista.btnDesactivarCarnet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desactivarCarnet();
            }
        });
        this.vista.btnVolverventanaCarnetAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volver();
            }
        });
    }

    public void iniciar() {
        vista.setVisible(true);
    }

    private void buscarCarnet() {
        try {
            int id = Integer.parseInt(vista.IdCarnet1.getText().trim());
            Carnet carnet = arregloCarnet.BuscarCarnet(id);

            if (carnet != null) {
                Cliente cliente = buscarClientePorCarnet(carnet);
                if (cliente != null) {
                    vista.ClienteCarnet1.setText(cliente.getNombres() + " " + cliente.getApellidos());
                    Multa multa = arregloMulta.BuscarMulta(cliente);
                    if (multa != null && multa.getEstado().equals("pendiente")) {
                        vista.DeudasClientes.setText("Sí, pendiente: " + multa.getMonto() + "$.");
                    } else {
                        vista.DeudasClientes.setText("No");
                    }
                } else {
                    vista.ClienteCarnet1.setText("Cliente no encontrado");
                    vista.DeudasClientes.setText("No aplica");
                }
                vista.EstadoCarnet.setText(carnet.getEstado());
                JOptionPane.showMessageDialog(vista, "Carnet encontrado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(vista, "Carnet no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Por favor, ingrese un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Cliente buscarClientePorCarnet(Carnet carnet) {
        for (Persona persona : arregloPersona.mostrarPersonas()) {
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
            int id = Integer.parseInt(vista.IdCarnet1.getText().trim());
            boolean resultado = arregloCarnet.CambiarBloqueado(id);

            if (resultado) {
                vista.EstadoCarnet.setText("bloqueado");
                JOptionPane.showMessageDialog(vista, "Carnet bloqueado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(vista, "No se pudo bloquear el carnet. Verifique el ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Por favor, ingrese un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void desactivarCarnet() {
        try {
            int id = Integer.parseInt(vista.IdCarnet1.getText().trim());
            boolean resultado = arregloCarnet.CambiarInactivo(id);

            if (resultado) {
                vista.EstadoCarnet.setText("inactivo");
                JOptionPane.showMessageDialog(vista, "Carnet desactivado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(vista, "No se pudo desactivar el carnet. Verifique el ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Por favor, ingrese un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void volver() {
        vista.dispose();
    }
}
