
package frames;

import daos.conexion.IConexionDAO;
import dtos.persona.PersonaConsultableDTO;
import excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mapas.personas.Persona;
import negocio.insercionMasiva.IInsercionMasivaBO;
import negocio.insercionMasiva.InsercionMasivaBO;

/**
 *
 * @author Enrique Rodriguez
 */
public class FrmPantallaPrincipal extends javax.swing.JFrame {

    IConexionDAO conexion;
    
    /**
     * Constructor que recibe la conexion 
     * @param conexion Conexion con la base de datos
     */
    public FrmPantallaPrincipal(IConexionDAO conexion) {
        this.setResizable(false);
        initComponents();
        this.conexion=conexion;
         
    }

    /**
     * Inserta 20 datos de persona a la base de datos, SOLO PARA PRUEBAS
     */
    public void insercionMasiva() {
        IInsercionMasivaBO insercionMasivaBO = new InsercionMasivaBO(conexion);
        PersonaConsultableDTO[] personas;
        try {
            personas=insercionMasivaBO.insercionMasiva();

        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, "No se puede volver a insertar de forma masiva", "Error al insertar masivamente", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Personas agregadas con exito", "Exito en la operacion", JOptionPane.INFORMATION_MESSAGE);
        tablaPersonas(personas);
    }
    
    /**
     * Abre el frame de la tabla de personas
     * @param personas Lista de personas a mostrar en la tabla
     */
    private void tablaPersonas(PersonaConsultableDTO[] personas){
        FrmInsercionMasiva on=new FrmInsercionMasiva(personas);
        on.setVisible(true);
    }
    /**
     * Abre la pantalla modulo de licencias y cierra esta
     */
    private void moduloLicencias(){
        FrmModuloLicencias on = new FrmModuloLicencias(conexion);
        on.setVisible(true);
        this.dispose();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnModulodeReportes = new javax.swing.JButton();
        btnModuloLicencias = new javax.swing.JButton();
        btnModuloPlacas = new javax.swing.JButton();
        btnCambioPlacas = new javax.swing.JButton();
        btnModuloConsultas = new javax.swing.JButton();
        btnInsercionMasiva = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnModulodeReportes.setBorder(null);
        btnModulodeReportes.setContentAreaFilled(false);
        btnModulodeReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModulodeReportesActionPerformed(evt);
            }
        });
        getContentPane().add(btnModulodeReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 400, 60));

        btnModuloLicencias.setBorder(null);
        btnModuloLicencias.setContentAreaFilled(false);
        btnModuloLicencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModuloLicenciasActionPerformed(evt);
            }
        });
        getContentPane().add(btnModuloLicencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 400, 50));

        btnModuloPlacas.setBorder(null);
        btnModuloPlacas.setContentAreaFilled(false);
        btnModuloPlacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModuloPlacasActionPerformed(evt);
            }
        });
        getContentPane().add(btnModuloPlacas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 400, 60));

        btnCambioPlacas.setBorder(null);
        btnCambioPlacas.setContentAreaFilled(false);
        btnCambioPlacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambioPlacasActionPerformed(evt);
            }
        });
        getContentPane().add(btnCambioPlacas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 400, 60));

        btnModuloConsultas.setBorder(null);
        btnModuloConsultas.setContentAreaFilled(false);
        btnModuloConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModuloConsultasActionPerformed(evt);
            }
        });
        getContentPane().add(btnModuloConsultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 400, 60));

        btnInsercionMasiva.setBorder(null);
        btnInsercionMasiva.setContentAreaFilled(false);
        btnInsercionMasiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsercionMasivaActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsercionMasiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, 210, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PantallaPrincipa.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnModulodeReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModulodeReportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModulodeReportesActionPerformed

    private void btnModuloLicenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModuloLicenciasActionPerformed
        moduloLicencias();
    }//GEN-LAST:event_btnModuloLicenciasActionPerformed

    private void btnModuloPlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModuloPlacasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModuloPlacasActionPerformed

    private void btnCambioPlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambioPlacasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCambioPlacasActionPerformed

    private void btnModuloConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModuloConsultasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModuloConsultasActionPerformed

    private void btnInsercionMasivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsercionMasivaActionPerformed
        insercionMasiva();
    }//GEN-LAST:event_btnInsercionMasivaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambioPlacas;
    private javax.swing.JButton btnInsercionMasiva;
    private javax.swing.JButton btnModuloConsultas;
    private javax.swing.JButton btnModuloLicencias;
    private javax.swing.JButton btnModuloPlacas;
    private javax.swing.JButton btnModulodeReportes;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
