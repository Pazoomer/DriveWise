/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import dtos.persona.PersonaConsultableDTO;

/**
 *
 * @author lv1821
 */
public class FrmResumenDatos extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    private PersonaConsultableDTO personaConsultableDTO;
    public FrmResumenDatos(PersonaConsultableDTO personaConsultableDTO) {
        this.personaConsultableDTO = personaConsultableDTO;
        txtNombreCompleto.setText(personaConsultableDTO.getNombre()+" "+ personaConsultableDTO.getApellidopaterno() + " " + personaConsultableDTO.getApellidoMaterno());
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCosto = new javax.swing.JLabel();
        txtFechaEmision = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JLabel();
        txtNombreCompleto = new javax.swing.JLabel();
        txtFechaNacimiento = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        txtRFC = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCosto.setText("c");
        getContentPane().add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, 150, 20));

        txtFechaEmision.setText("f");
        getContentPane().add(txtFechaEmision, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 420, 120, 30));

        txtTelefono.setText("a");
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 380, 20));

        txtNombreCompleto.setText("n");
        getContentPane().add(txtNombreCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 380, 20));

        txtFechaNacimiento.setText("t");
        getContentPane().add(txtFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 350, 20));

        btnConfirmar.setBackground(new java.awt.Color(255, 153, 204));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 470, 140, 50));

        txtRFC.setText("t");
        getContentPane().add(txtRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 350, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ResumenDatos.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmarActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel txtCosto;
    private javax.swing.JLabel txtFechaEmision;
    private javax.swing.JLabel txtFechaNacimiento;
    private javax.swing.JLabel txtNombreCompleto;
    private javax.swing.JLabel txtRFC;
    private javax.swing.JLabel txtTelefono;
    // End of variables declaration//GEN-END:variables
}
