/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import daos.conexion.IConexionDAO;
import dtos.persona.PersonaConsultableDTO;
import excepciones.PersistenciaException;
import excepciones.ValidacionException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import negocio.consulta.ConsultarHistorialBO;
import negocio.consulta.IConsultarHistorialBO;
import negocio.licencia.RegistroLicenciasBO;
import negocio.tramite.ConsultarTramitesBO;
import negocio.tramite.IConsultarTramitesBO;

/**
 *
 * @author Enrique Rodriguez
 */
public class FrmModuloReportes extends javax.swing.JFrame {

    IConexionDAO conexion;

    public FrmModuloReportes(IConexionDAO conexion) {
        initComponents();
        this.conexion = conexion;
        jdateDesde.getDateEditor().setEnabled(false);
        jdateHasta.getDateEditor().setEnabled(false);

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbOperacion = new javax.swing.JComboBox<>();
        jdateDesde = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jdateHasta = new com.toedter.calendar.JDateChooser();
        txtNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Historial de operaciones");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(127, 0, 0));
        jLabel4.setText("Filtrar por operacion:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(127, 0, 0));
        jLabel5.setText("desde");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(127, 0, 0));
        jLabel6.setText("Filtrar por nombre:");

        cmbOperacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No especifico", "Licencias", "Placas" }));
        cmbOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOperacionActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(127, 0, 0));
        jLabel7.setText("Filtrar por periodo:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(127, 0, 0));
        jLabel8.setText("hasta");

        btnBuscar.setBackground(new java.awt.Color(204, 0, 0));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnVolver.setBackground(new java.awt.Color(204, 0, 0));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(97, 97, 97)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cmbOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jdateDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(45, 45, 45)
                                                    .addComponent(jLabel5)))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jdateHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(81, 81, 81)
                                                    .addComponent(jLabel8)
                                                    .addGap(0, 0, Short.MAX_VALUE)))))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdateDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jdateHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(86, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

            buscar(cmbOperacion.getSelectedIndex());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        pantallaPrincipal();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void cmbOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOperacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbOperacionActionPerformed

    /**
     * Método que nos ayuda a realizar la busqueda de la persona a partir de un
     * rango de fechas y el RFC de una persona vigente, si el RFC no es vigente
     * lanzará unJOPtionPane que indicará dicho error, recibe un filtro,
     * dependiendo del tipo de tramite, se hará la busqueda.
     *
     * @param filtro Tramite
     * @param desde fecha comienzo
     * @param hasta fecha final
     */
    private void buscar(int filtro) {
        PersonaConsultableDTO personaConsultada = new PersonaConsultableDTO();
        List<PersonaConsultableDTO> personas;
        if (!(txtNombre.getText().isBlank())) {
            personaConsultada.setNombre(txtNombre.getText());

            try {

                IConsultarHistorialBO consultarHistorial = new ConsultarHistorialBO(conexion);
                personas = consultarHistorial.consultarPersonaPorFiltros(personaConsultada);

                if (personas == null) {
//                    JOptionPane.showMessageDialog(this, "Persona no encontrada", "Persona desconocida", JOptionPane.ERROR_MESSAGE);

                } else {

                    if (jdateDesde.getDate() != null || jdateHasta.getDate() != null) {
                        Calendar calDesde = Calendar.getInstance();
                        calDesde.setTime(jdateDesde.getDate());
                        calDesde.set(Calendar.HOUR_OF_DAY, 0);
                        calDesde.set(Calendar.MINUTE, 0);
                        calDesde.set(Calendar.SECOND, 0);
                        calDesde.set(Calendar.MILLISECOND, 0);
                        Calendar calHasta = Calendar.getInstance();
                        calHasta.setTime(jdateHasta.getDate());
                        calHasta.set(Calendar.HOUR_OF_DAY, 0);
                        calHasta.set(Calendar.MINUTE, 0);
                        calHasta.set(Calendar.SECOND, 0);
                        calHasta.set(Calendar.MILLISECOND, 0);
                        DlgReporte reporte = new DlgReporte(conexion, personas, filtro, calHasta, calDesde);
                        reporte.llenarTabla(personas);
                        reporte.setVisible(true);
                        
                    } else {
                        DlgReporte reporte = new DlgReporte(conexion, personas, filtro, null, null);
                        reporte.llenarTabla(personas);
                        reporte.setVisible(true);
                    }
                    
                }
            } catch (PersistenciaException ex) {
                Logger.getLogger(FrmModuloReportes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ValidacionException ex) {
                DlgReporte reporte = new DlgReporte(conexion, null, filtro, null, null);
                reporte.llenarTabla(null);
                reporte.setVisible(true);
                Logger.getLogger(FrmModuloReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (jdateDesde.getDate() != null || jdateHasta.getDate() != null) {
            Calendar calDesde = Calendar.getInstance();
            calDesde.setTime(jdateDesde.getDate());
            calDesde.set(Calendar.HOUR_OF_DAY, 0);
            calDesde.set(Calendar.MINUTE, 0);
            calDesde.set(Calendar.SECOND, 0);
            calDesde.set(Calendar.MILLISECOND, 0);
            Calendar calHasta = Calendar.getInstance();
            calHasta.setTime(jdateHasta.getDate());
            calHasta.set(Calendar.HOUR_OF_DAY, 0);
            calHasta.set(Calendar.MINUTE, 0);
            calHasta.set(Calendar.SECOND, 0);
            calHasta.set(Calendar.MILLISECOND, 0);
            IConsultarTramitesBO ctBO = new ConsultarTramitesBO(conexion);
            ctBO.consultarTramites();
            DlgReporte reporte = new DlgReporte(conexion, null, filtro, calHasta, calDesde);
            reporte.llenarTablaTodo();
            reporte.setVisible(true);

        }
        
        else if(txtNombre.getText().isBlank() && (jdateDesde.getDate() == null || jdateHasta.getDate() == null)){
            IConsultarTramitesBO ctBO = new ConsultarTramitesBO(conexion);
            ctBO.consultarTramites();
            DlgReporte reporte = new DlgReporte(conexion, null, filtro, null, null);
            reporte.llenarTablaTodo();
            reporte.setVisible(true);
        }

    }

    /**
     * Abre la pantalla principal y cierra esta.
     */
    private void pantallaPrincipal() {
        FrmPantallaPrincipal on = new FrmPantallaPrincipal(conexion);
        on.setVisible(true);
        this.dispose();
    }

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbOperacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser jdateDesde;
    private com.toedter.calendar.JDateChooser jdateHasta;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
