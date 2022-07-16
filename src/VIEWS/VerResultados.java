package VIEWS;

import DAO.Conexion;
import DAO.PartidosDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VerResultados extends javax.swing.JFrame {
    
    int usu = IniciarSesion.tipo;
    PartidosDAO pd = new PartidosDAO();
    
    public VerResultados() {
        initComponents();
        this.setLocationRelativeTo(null);
        pd.listar(taResultados);
        if (usu == 1) { //si es 1 es Adminitrador
            btnAtrasA.setVisible(true);
            btnCerrarSesionU.setVisible(false);
        } else {
            btnAtrasA.setVisible(false);
            btnCerrarSesionU.setVisible(true);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnAtrasA = new javax.swing.JButton();
        btnCerrarSesionU = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        taResultados = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Resultados");

        jLabel1.setText("RESULTADOS");

        btnAtrasA.setText("Atras");
        btnAtrasA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasAActionPerformed(evt);
            }
        });

        btnCerrarSesionU.setText("Cerrar sesión");
        btnCerrarSesionU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionUActionPerformed(evt);
            }
        });

        taResultados.setColumns(20);
        taResultados.setRows(5);
        jScrollPane2.setViewportView(taResultados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(btnCerrarSesionU)
                .addGap(219, 219, 219)
                .addComponent(btnAtrasA)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtrasA)
                    .addComponent(btnCerrarSesionU))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionUActionPerformed
        try {
            Conexion.getConnection().close();
            IniciarSesion is = new IniciarSesion();
            is.setVisible(true);
            this.setVisible(false);            
        } catch (SQLException ex) {
            Logger.getLogger(VerResultados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCerrarSesionUActionPerformed

    private void btnAtrasAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasAActionPerformed
        Menu m = new Menu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAtrasAActionPerformed
//    public void mostrarTabla() {
//        DefaultTableModel dtm = new DefaultTableModel(0, 0);
//
//        String colums[] = new String[]{"ID", "EQUIPO", "ENTRENADOR"};
//
//        dtm.setColumnIdentifiers(colums);
//        //set model into the table object
//
//        ArrayList<Equipo> q = eqd.listar();
//        for (int i = 0; i < q.size(); i++) {
//            //Como dato nivel es de nivo nivel2, este puede acceder a los métodos get y set
//            dtm.addRow(new Object[]{
//                q.get(i).getId(),
//                q.get(i).getNombre_equipo(),
//                q.get(i).getEntrenador(),});
//        }
//        tbEquipos.setModel(dtm);
//    }

    /**
     * @param args the command line arguments //
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
            java.util.logging.Logger.getLogger(VerResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerResultados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtrasA;
    private javax.swing.JButton btnCerrarSesionU;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea taResultados;
    // End of variables declaration//GEN-END:variables
}
