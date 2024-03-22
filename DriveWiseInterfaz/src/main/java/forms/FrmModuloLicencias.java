package forms;

import daos.conexion.IConexionDAO;
import daos.licencia.ILicenciasDAO;
import daos.licencia.LicenciasDAO;
import daos.persona.IPersonasDAO;
import daos.persona.PersonasDAO;
import dtos.persona.PersonaConsultableDTO;
import excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import negocio.insercionMasiva.IInsercionMasivaBO;
import negocio.insercionMasiva.InsercionMasivaBO;
import negocio.licencia.RegistroLicenciasBO;

/**
 *
 * @author Enrique Rodriguez
 */
public class FrmModuloLicencias extends javax.swing.JFrame {

    IConexionDAO conexion;

    /**
     * Constructor que recibe la conexion
     *
     * @param conexion Conexion de la base de datos
     */
    public FrmModuloLicencias(IConexionDAO conexion) {
        this.setResizable(false);
        initComponents();
        this.conexion = conexion;

    }

    /**
     * Verifica que los campos no esten vacios
     *
     * @return true si ningun campo esta vacio, false en caso contrario
     */
    private boolean verificarRFC() {
        if (txtRFC.getText().isEmpty()) {
            return false;
        }
        return true;
    }
    
    private void buscar() {
        if (verificarRFC()) {
            PersonaConsultableDTO personaConsultada = new PersonaConsultableDTO(txtRFC.getText());

            RegistroLicenciasBO buscar = new RegistroLicenciasBO(conexion);

            try {
                PersonaConsultableDTO i = buscar.buscarPersonaRfc(personaConsultada);
                
                //Se establcen los valores en los labels
                txtNombre.setText(i.getNombre());
                txtApaterno.setText(i.getApellidopaterno());
                txtAmaterno.setText(i.getApellidoMaterno());
                txtTelefono.setText(i.getTelefono());
                txtFechaNac.setText(i.getCadenaNacimiento());
            } catch (PersistenciaException ex) {
                Logger.getLogger(FrmModuloLicencias.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane s = new JOptionPane("Indique un RFC", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Abre la pantalla principal y cierra esta
     */
    private void volver() {
        FrmPantallaPrincipal on = new FrmPantallaPrincipal(conexion);
        on.setVisible(true);
        this.dispose();
    }

    /**
     * Muestra la pantalla de licencia agregada con exito
     */
    private void mensajeExito() {
        DlgValido on = new DlgValido(this, true);
        on.setVisible(true);
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        txtApaterno = new javax.swing.JTextField();
        txtAmaterno = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtRFC = new javax.swing.JTextField();
        cmbVigencia = new javax.swing.JComboBox<>();
        btnVolver = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtFechaNac = new javax.swing.JTextField();
        btnBuscar1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setOpaque(true);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 290, 30));

        txtApaterno.setOpaque(true);
        txtApaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApaternoActionPerformed(evt);
            }
        });
        getContentPane().add(txtApaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 290, 30));

        txtAmaterno.setOpaque(true);
        txtAmaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmaternoActionPerformed(evt);
            }
        });
        getContentPane().add(txtAmaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, 290, 30));

        txtTelefono.setOpaque(true);
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, 290, 30));

        txtRFC.setOpaque(true);
        txtRFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRFCActionPerformed(evt);
            }
        });
        getContentPane().add(txtRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 230, 30));

        cmbVigencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        getContentPane().add(cmbVigencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 472, 200, 30));

        btnVolver.setContentAreaFilled(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 140, 60));

        btnBuscar.setContentAreaFilled(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 140, 60));

        txtFechaNac.setText("jTextField1");
        getContentPane().add(txtFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 382, 290, 30));

        btnBuscar1.setContentAreaFilled(false);
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, 140, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modulo de licencia.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed

    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApaternoActionPerformed

    private void txtAmaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmaternoActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtRFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRFCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRFCActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        volver();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        FrmPantallaPrincipal on = new FrmPantallaPrincipal(conexion);
        on.insercionMasivaConsulta();
        buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbVigencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtAmaterno;
    private javax.swing.JTextField txtApaterno;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRFC;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
