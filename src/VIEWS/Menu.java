package VIEWS;

import DAO.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGestionEquipos = new javax.swing.JButton();
        btnRegistrarPartidos = new javax.swing.JButton();
        btnVerResultadosA = new javax.swing.JButton();
        btnCerrarSesionA = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");

        btnGestionEquipos.setText("Gestionar equipos");
        btnGestionEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionEquiposActionPerformed(evt);
            }
        });

        btnRegistrarPartidos.setText("Registrar partidos");
        btnRegistrarPartidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPartidosActionPerformed(evt);
            }
        });

        btnVerResultadosA.setText("Ver resultados");
        btnVerResultadosA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerResultadosAActionPerformed(evt);
            }
        });

        btnCerrarSesionA.setText("Cerrar sesión");
        btnCerrarSesionA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionAActionPerformed(evt);
            }
        });

        jLabel1.setText("MENÚ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnRegistrarPartidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGestionEquipos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVerResultadosA, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btnCerrarSesionA)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGestionEquipos)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarPartidos)
                .addGap(18, 18, 18)
                .addComponent(btnVerResultadosA)
                .addGap(18, 18, 18)
                .addComponent(btnCerrarSesionA)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionAActionPerformed
        try {
            Conexion.getConnection().close();
            IniciarSesion is = new IniciarSesion();
            is.setVisible(true);
            this.setVisible(false);            
        } catch (SQLException ex) {
            Logger.getLogger(VerResultados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCerrarSesionAActionPerformed

    private void btnGestionEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionEquiposActionPerformed
        GestionEquipos ge = new GestionEquipos();
        ge.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnGestionEquiposActionPerformed

    private void btnRegistrarPartidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPartidosActionPerformed
        Partidos p = new Partidos();
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegistrarPartidosActionPerformed

    private void btnVerResultadosAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerResultadosAActionPerformed
        VerResultados vr = new VerResultados();
        vr.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVerResultadosAActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesionA;
    private javax.swing.JButton btnGestionEquipos;
    private javax.swing.JButton btnRegistrarPartidos;
    private javax.swing.JButton btnVerResultadosA;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
