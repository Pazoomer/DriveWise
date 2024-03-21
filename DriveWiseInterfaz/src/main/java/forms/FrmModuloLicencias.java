
package forms;

import daos.conexion.IConexionDAO;
import dtos.licencia.LicenciaNuevaDTO;
import dtos.persona.PersonaConsultableDTO;
import excepciones.PersistenciaException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import negocio.licencia.IRegistroLicenciasBO;
import negocio.licencia.RegistroLicenciasBO;

/**
 *
 * @author Enrique Rodriguez
 */
public class FrmModuloLicencias extends javax.swing.JFrame {
    
    IConexionDAO conexion;
    
    /**
     * Constructor que recibe la conexion
     * @param conexion Conexion de la base de datos
     */
    public FrmModuloLicencias(IConexionDAO conexion) {
        this.setResizable(false);
        initComponents();
        this.conexion = conexion;
        
    }

    /**
     * Verifica que los campos no esten vacios
     * @return true si ningun campo esta vacio, false en caso contrario
     */
    private boolean verificarDatos() {
        if (jCalendarFechaNacimiento.getSelectedDate() == null || txtNombre.getText().isEmpty() || txtAmaterno.getText().isEmpty() || txtApaterno.getText().isEmpty() || txtRFC.getText().isEmpty() || txtTelefono.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Toma los campos del formulario, busca la persona que le correspondan y le
     * agrega una licencia con la vigencia, haciendo el tramite correspondiente
     */
    private void buscar() {
        if (!verificarDatos()) {
            JOptionPane.showMessageDialog(this, "Uno de los campos esta vacio", "Error al agregar la licencia", JOptionPane.ERROR_MESSAGE);
            return; 
        }

        Calendar calendarPersona=Calendar.getInstance();
        calendarPersona.set(jCalendarFechaNacimiento.getSelectedDate().getDayOfYear(),
                jCalendarFechaNacimiento.getSelectedDate().getDayOfMonth(),
                jCalendarFechaNacimiento.getSelectedDate().getYear());
        
        //Creamos un objeto de personaConsultableDTO
        PersonaConsultableDTO personaConsultableDTO = new PersonaConsultableDTO(
                 txtNombre.getText(),
                 txtAmaterno.getText(),
                 txtApaterno.getText(),
                 txtRFC.getText(),
                 txtTelefono.getText(),
                 calendarPersona);
        
        Calendar calendarLicencia=Calendar.getInstance();
        LicenciaNuevaDTO licenciaNuevaDTO = new LicenciaNuevaDTO(calendarLicencia, cmbVigencia.getSelectedIndex());
        IRegistroLicenciasBO registrarLicencias = new RegistroLicenciasBO(conexion);
        try {
            if (registrarLicencias.registrarLicencia(personaConsultableDTO, licenciaNuevaDTO) == false) {
                JOptionPane.showMessageDialog(this, "No exite una persona con esos datos", "Error al agregar la licencia", JOptionPane.ERROR_MESSAGE);
                return;
            }

        } catch (NoSuchAlgorithmException | PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, ex, "Error al agregar la licencia", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FrmModuloLicencias.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        mensajeExito();
        FrmResumenDatos datos = new FrmResumenDatos(personaConsultableDTO);
    }
    
    /**
     * Abre la pantalla principal y cierra esta
     */
    private void volver(){
        FrmPantallaPrincipal on = new FrmPantallaPrincipal(conexion);
        on.setVisible(true);
        this.dispose();
    }
    
    /**
     * Muestra la pantalla de licencia agregada con exito
     */
    private void mensajeExito(){
        DlgValido on = new DlgValido(this,true);
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
        jCalendarFechaNacimiento = new com.github.lgooddatepicker.components.CalendarPanel();
        btnVolver = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
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
        getContentPane().add(txtRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 290, 30));

        cmbVigencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        getContentPane().add(cmbVigencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 510, 200, -1));
        getContentPane().add(jCalendarFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

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
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, 140, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modulo de licencias.jpg"))); // NOI18N
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
        buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbVigencia;
    private com.github.lgooddatepicker.components.CalendarPanel jCalendarFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtAmaterno;
    private javax.swing.JTextField txtApaterno;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRFC;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
