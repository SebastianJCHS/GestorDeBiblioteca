package Controlador;

import vista.VentanaAdminCarnet;
import vista.VentanaRegistroLibros;
import vista.VentanaAgragarMulta;
import vista.VentanaVerificarLibro;
import vista.VentanaRegistroCarnet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ControladorAdminCarnet {

    private VentanaAdminCarnet vistaAdminCarnet;
    private VentanaRegistroLibros ventanaLibros;
    private VentanaAgragarMulta ventanaMulta;
    private VentanaVerificarLibro ventanaVerificar;
    private VentanaRegistroCarnet ventanaRegistroCarnet;

    public ControladorAdminCarnet(VentanaAdminCarnet vistaAdminCarnet) {
        this.vistaAdminCarnet = vistaAdminCarnet;

        // Configuración de los botones y sus acciones
        this.vistaAdminCarnet.btnMenuRegistroLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarVentana("registroLibros");
            }
        });

        this.vistaAdminCarnet.btnMenuMulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarVentana("agregarMulta");
            }
        });

        this.vistaAdminCarnet.btnMenuVerificarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarVentana("verificarLibro");
            }
        });

        this.vistaAdminCarnet.btnAñadirCarnet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarVentana("registroCarnet");
            }
        });

        this.vistaAdminCarnet.btnregresoInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salir();
            }
        });
    }

    public void iniciar() {
        vistaAdminCarnet.setVisible(true);
    }

    private void mostrarVentana(String ventana) {
        if (ventanaLibros != null) ventanaLibros.setVisible(false);
        if (ventanaMulta != null) ventanaMulta.setVisible(false);
        if (ventanaVerificar != null) ventanaVerificar.setVisible(false);
        if (ventanaRegistroCarnet != null) ventanaRegistroCarnet.setVisible(false);

        switch (ventana) {
            case "registroLibros":
                if (ventanaLibros == null) ventanaLibros = new VentanaRegistroLibros();
                ventanaLibros.setVisible(true);
                break;

            case "agregarMulta":
                if (ventanaMulta == null) ventanaMulta = new VentanaAgragarMulta();
                ventanaMulta.setVisible(true);
                break;

            case "verificarLibro":
                if (ventanaVerificar == null) ventanaVerificar = new VentanaVerificarLibro();
                ventanaVerificar.setVisible(true);
                break;

            case "registroCarnet":
                if (ventanaRegistroCarnet == null) ventanaRegistroCarnet = new VentanaRegistroCarnet();
                ventanaRegistroCarnet.setVisible(true);
                break;

            default:
                throw new IllegalArgumentException("Ventana no reconocida: " + ventana);
        }
    }

    private void salir() {
        vistaAdminCarnet.dispose();
    }
}

