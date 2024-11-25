/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

/**
 *
 * @author Luis
 */
public class VentanaBuscarCarnet extends javax.swing.JFrame {

    /**
     * Creates new form VentanaBuscarCarnet
     */
    public VentanaBuscarCarnet() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ClienteCarnet1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        IdCarnet1 = new javax.swing.JTextField();
        btnBusquedaCarnet1 = new javax.swing.JButton();
        EstadoCarnet = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        DeudasClientes = new javax.swing.JTextField();
        btnBloquearCarnet = new javax.swing.JButton();
        btnDesactivarCarnet = new javax.swing.JButton();
        btnVolverventanaCarnetAdmin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Buscar Carnet");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Nombre del cliente:");

        ClienteCarnet1.setBackground(new java.awt.Color(255, 255, 255));
        ClienteCarnet1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Id del Carnet:");

        IdCarnet1.setBackground(new java.awt.Color(255, 255, 255));
        IdCarnet1.setForeground(new java.awt.Color(0, 0, 0));

        btnBusquedaCarnet1.setBackground(new java.awt.Color(0, 102, 102));
        btnBusquedaCarnet1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBusquedaCarnet1.setForeground(new java.awt.Color(255, 255, 255));
        btnBusquedaCarnet1.setText("Buscar");
        btnBusquedaCarnet1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaCarnet1ActionPerformed(evt);
            }
        });

        EstadoCarnet.setBackground(new java.awt.Color(255, 255, 255));
        EstadoCarnet.setForeground(new java.awt.Color(0, 0, 0));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Estado del carnet");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("¿Tiene deudas?");

        DeudasClientes.setBackground(new java.awt.Color(255, 255, 255));
        DeudasClientes.setForeground(new java.awt.Color(0, 0, 0));

        btnBloquearCarnet.setBackground(new java.awt.Color(0, 102, 102));
        btnBloquearCarnet.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBloquearCarnet.setForeground(new java.awt.Color(255, 255, 255));
        btnBloquearCarnet.setText("Bloquear carnet");
        btnBloquearCarnet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBloquearCarnetActionPerformed(evt);
            }
        });

        btnDesactivarCarnet.setBackground(new java.awt.Color(0, 102, 102));
        btnDesactivarCarnet.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDesactivarCarnet.setForeground(new java.awt.Color(255, 255, 255));
        btnDesactivarCarnet.setText("Desactivar carnet");
        btnDesactivarCarnet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarCarnetActionPerformed(evt);
            }
        });

        btnVolverventanaCarnetAdmin.setBackground(new java.awt.Color(0, 102, 102));
        btnVolverventanaCarnetAdmin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVolverventanaCarnetAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnVolverventanaCarnetAdmin.setText("Volver");
        btnVolverventanaCarnetAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverventanaCarnetAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(18, 18, 18)
                                    .addComponent(DeudasClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(18, 18, 18)
                                    .addComponent(EstadoCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(53, 53, 53))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(126, 126, 126)
                            .addComponent(jLabel5)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ClienteCarnet1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnVolverventanaCarnetAdmin)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(IdCarnet1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnBusquedaCarnet1))))))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnBloquearCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDesactivarCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(btnVolverventanaCarnetAdmin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(IdCarnet1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBusquedaCarnet1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(ClienteCarnet1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(EstadoCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(DeudasClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBloquearCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesactivarCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBusquedaCarnet1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaCarnet1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBusquedaCarnet1ActionPerformed

    private void btnBloquearCarnetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBloquearCarnetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBloquearCarnetActionPerformed

    private void btnDesactivarCarnetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarCarnetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDesactivarCarnetActionPerformed

    private void btnVolverventanaCarnetAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverventanaCarnetAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverventanaCarnetAdminActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField ClienteCarnet1;
    public javax.swing.JTextField DeudasClientes;
    public javax.swing.JTextField EstadoCarnet;
    public javax.swing.JTextField IdCarnet1;
    public javax.swing.JButton btnBloquearCarnet;
    public javax.swing.JButton btnBusquedaCarnet1;
    public javax.swing.JButton btnDesactivarCarnet;
    public javax.swing.JButton btnVolverventanaCarnetAdmin;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
