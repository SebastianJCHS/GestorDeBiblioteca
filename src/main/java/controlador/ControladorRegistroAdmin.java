/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Modelo.Administrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.LoginAdminCliente;
import vista.VentanaRegistroAdmin;
import vista.VentanaRegistroLibros;
import Modelo.ArregloPersona;

public class ControladorRegistroAdmin {
    private Administrador administrador;
    private VentanaRegistroAdmin vista1;
    private VentanaRegistroLibros vista2;
    private LoginAdminCliente vista3;
    private ArregloPersona persona;

    public ControladorRegistroAdmin(Administrador administrador, VentanaRegistroAdmin vista1, VentanaRegistroLibros vista2, LoginAdminCliente vista3, ArregloPersona persona) {
        this.administrador = administrador;
        this.vista1 = vista1;
        this.vista2 = vista2;
        this.vista3 = vista3;
        this.persona = persona;
        this.vista1.btnRgistroAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombres = vista1.NombreAdmin.getText();
                String apellidos = vista1.ApellidoAdmin.getText();
                String DNI = vista1.DniAdmin.getText();
                String Correo = vista1.CorreoAdmin.getText();
                String Telefono = vista1.TelefonoAdmin.getText();
                String Edad = vista1.EdadAdmin.getText();
                    if (!nombres.isEmpty() || !apellidos.isEmpty() || !DNI.isEmpty() || !Correo.isEmpty() || !Telefono.isEmpty() || !Edad.isEmpty()) {
                       administrador.setNombres(nombres);
                       administrador.setApellidos(apellidos);
                       administrador.setDNI(DNI);
                       administrador.setCorreoElectronico(Correo);
                       administrador.setTelefono(Telefono);
                       administrador.setEdad(Integer.parseInt(Edad));
                       administrador.setRol("Administrador");
                       administrador.makeid();
                       persona.agregarPersona(administrador);
                       JOptionPane.showMessageDialog(vista1, "Registro exitoso, su codigo de ingreso es " + administrador.getID_admin());
                       vista1.setVisible(false);
                       vista2.setLocationRelativeTo(null);
                       vista2.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(vista1, "No ha ingresado alguno de los parametros pedidos, intente de nuevo");
                    }
            }
        });
        this.vista1.btnInicioAdmin1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String ID = vista1.IdInicioSesionAdmin.getText();
                    if(!ID.isEmpty() && administrador.getRol().equals("administrador")){
                        JOptionPane.showMessageDialog(vista1, "Inicio exitoso");
                        vista1.setVisible(false);
                        vista2.setLocationRelativeTo(null);
                        vista2.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(vista1, "Fallo al iniciar sesion, el id no cuenta con los permisos necesarios");
                        
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(vista1, "Error al ingresar la id");
                }
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.vista1.btnVolverventanalogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista1.setVisible(false);
                vista3.setLocationRelativeTo(null);
                vista3.setVisible(true);
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
    }

    public ControladorRegistroAdmin() {
        this.vista1.btnRgistroAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombres = vista1.NombreAdmin.getText();
                String apellidos = vista1.ApellidoAdmin.getText();
                String DNI = vista1.DniAdmin.getText();
                String Correo = vista1.CorreoAdmin.getText();
                String Telefono = vista1.TelefonoAdmin.getText();
                String Edad = vista1.EdadAdmin.getText();
                    if (!nombres.isEmpty() || !apellidos.isEmpty() || !DNI.isEmpty() || !Correo.isEmpty() || !Telefono.isEmpty() || !Edad.isEmpty()) {
                       administrador.setNombres(nombres);
                       administrador.setApellidos(apellidos);
                       administrador.setDNI(DNI);
                       administrador.setCorreoElectronico(Correo);
                       administrador.setTelefono(Telefono);
                       administrador.setEdad(Integer.parseInt(Edad));
                       administrador.setRol("Administrador");
                       administrador.makeid();
                       JOptionPane.showMessageDialog(vista1, "Registro exitoso, su codigo de ingreso es " + administrador.getID_admin());
                       vista1.setVisible(false);
                       vista2.setLocationRelativeTo(null);
                       vista2.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(vista1, "No ha ingresado alguno de los parametros pedidos, intente de nuevo");
                    }
            }
        });
        this.vista1.btnInicioAdmin1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String ID = vista1.IdInicioSesionAdmin.getText();
                    if(!ID.isEmpty() && administrador.getRol().equals("administrador")){
                        JOptionPane.showMessageDialog(vista1, "Inicio exitoso");
                        vista1.setVisible(false);
                        vista2.setLocationRelativeTo(null);
                        vista2.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(vista1, "Fallo al iniciar sesion, el id no cuenta con los permisos necesarios");
                        
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(vista1, "Error al ingresar la id");
                }
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.vista1.btnVolverventanalogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista1.setVisible(false);
                vista3.setLocationRelativeTo(null);
                vista3.setVisible(true);
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
    }
    
    
    
    
}
