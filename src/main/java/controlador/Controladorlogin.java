
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.LoginAdminCliente;
import vista.RegistroCliente;
import vista.VentanaRegistroAdmin;

public class Controladorlogin {
    private VentanaRegistroAdmin vista1;
    private LoginAdminCliente vista2;
    private VentanaRegistroAdmin vista3;

    public Controladorlogin(VentanaRegistroAdmin vista1, LoginAdminCliente vista2, VentanaRegistroAdmin vista3) {
        this.vista1 = vista1;
        this.vista2 = vista2;
        this.vista3 = vista3;
        this.vista2.btnAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista2.setVisible(false);
                vista1.setLocationRelativeTo(null);
                vista1.setVisible(true);
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.vista2.btnCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista2.setVisible(false);
                vista3.setLocationRelativeTo(null);
                vista3.setVisible(true);
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
    }

    public Controladorlogin() {
        this.vista2.btnAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista1.setLocationRelativeTo(null);
                vista1.setVisible(true);
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        this.vista2.btnCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista3.setLocationRelativeTo(null);
                vista3.setVisible(true);
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
    }
    
    
}
