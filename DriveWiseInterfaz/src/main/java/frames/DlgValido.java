
package frames;

import daos.conexion.IConexionDAO;

/**
 *
 * @author Enrique Rodriguez
 */
public class DlgValido extends javax.swing.JDialog {

    /**
     * Creates new form DlgValido
     * @param parent
     * @param modal
     */

    public DlgValido(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnProcesado = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnProcesado.setBorderPainted(false);
        btnProcesado.setContentAreaFilled(false);
        btnProcesado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnProcesado, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 100, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Exito.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcesadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesadoActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnProcesadoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcesado;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
