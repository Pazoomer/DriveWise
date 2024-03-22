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
    private PersonaConsultableDTO persona;
    
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
        if (txtRFC.getText().isEmpty()||txtRFC.getText().isBlank()) {
            return false;
        }
        return true;
    }

    private boolean verificarCampos() {
        if (txtRFC.getText().isEmpty() || txtFechaNac.getText().isEmpty() || txtAmaterno.getText().isEmpty() || txtApaterno.getText().isEmpty() || txtNombre.getText().isEmpty()) {
            return true;
        }
        return false;
    }

    private void buscar() {
        if (verificarRFC()) {
            PersonaConsultableDTO personaConsultada = new PersonaConsultableDTO(txtRFC.getText());
            RegistroLicenciasBO buscar = new RegistroLicenciasBO(conexion);
            try {
                persona = buscar.buscarPersonaRfc(personaConsultada);

                if (persona == null) {
                    JOptionPane.showMessageDialog(this, "No se encontro a la persona", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                //Se establcen los valores en los labels
                txtNombre.setText(persona.getNombre());
                txtApaterno.setText(persona.getApellidopaterno());
                txtAmaterno.setText(persona.getApellidoMaterno());
                txtFechaNac.setText(persona.getCadenaNacimiento());

            } catch (PersistenciaException ex) {

                Logger.getLogger(FrmModuloLicencias.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Indique un rfc", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        LicenciaNuevaDTO licenciaNuevaDTO = new LicenciaNuevaDTO(persona, cmbVigencia.getSelectedIndex() + 1);
        lblCosto.setText("Costo: $" + licenciaNuevaDTO.getCosto().toString() + "0");
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
        JOptionPane.showMessageDialog(this, "Licencia añadida con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    
        //DlgValido on = new DlgValido(this, true);
        //on.setVisible(true);
    }
    
    private boolean mayorEdad(Calendar nacimiento){
        // Obtener la fecha actual
        Calendar fechaActual = Calendar.getInstance();

        // Calcular la edad restando el año de nacimiento al año actual
        int edad = fechaActual.get(Calendar.YEAR) - nacimiento.get(Calendar.YEAR);

        // Si aún no ha pasado el mes de nacimiento, restamos un año a la edad
        if (fechaActual.get(Calendar.MONTH) < nacimiento.get(Calendar.MONTH)) {
            edad--;
        }
        // Si están en el mismo mes pero aún no ha pasado el día de nacimiento, restamos un año a la edad
        else if (fechaActual.get(Calendar.MONTH) == nacimiento.get(Calendar.MONTH)
                && fechaActual.get(Calendar.DAY_OF_MONTH) < nacimiento.get(Calendar.DAY_OF_MONTH)) {
            edad--;
        }
        // Verificar si la persona tiene al menos 18 años
        return edad >= 18;
    }

    private void registrar() {
        try {
            if (verificarCampos()) {
                JOptionPane.showMessageDialog(this, "Primero consulte una persona", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Calendar calendarLicencia = Calendar.getInstance();

            if (!mayorEdad(persona.getNacimiento())) {
                JOptionPane.showMessageDialog(this, "No se puede agregar una licencia a un menor de edad", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //Se crea un objeto de licencia nueva
            LicenciaNuevaDTO licenciaNuevaDTO = new LicenciaNuevaDTO(calendarLicencia, persona, cmbVigencia.getSelectedIndex() + 1);
            
            IRegistroLicenciasBO registroLicenciasBO= new RegistroLicenciasBO(conexion);
            registroLicenciasBO.registrarLicencia(persona, licenciaNuevaDTO);
            
            mensajeExito();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(FrmModuloLicencias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistenciaException ex) {
            Logger.getLogger(FrmModuloLicencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        txtApaterno = new javax.swing.JTextField();
        txtAmaterno = new javax.swing.JTextField();
        txtRFC = new javax.swing.JTextField();
        cmbVigencia = new javax.swing.JComboBox<>();
        btnVolver = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtFechaNac = new javax.swing.JTextField();
        lblCosto = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setEditable(false);
        txtNombre.setOpaque(true);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 290, 30));

        txtApaterno.setEditable(false);
        txtApaterno.setOpaque(true);
        txtApaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApaternoActionPerformed(evt);
            }
        });
        getContentPane().add(txtApaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 290, 30));

        txtAmaterno.setEditable(false);
        txtAmaterno.setOpaque(true);
        txtAmaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmaternoActionPerformed(evt);
            }
        });
        getContentPane().add(txtAmaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, 290, 30));

        txtRFC.setOpaque(true);
        txtRFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRFCActionPerformed(evt);
            }
        });
        getContentPane().add(txtRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 230, 30));

        cmbVigencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        getContentPane().add(cmbVigencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 472, 200, 30));

        btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 140, 60));

        btnBuscar.setBorderPainted(false);
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 140, 60));

        txtFechaNac.setEditable(false);
        txtFechaNac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaNacActionPerformed(evt);
            }
        });
        getContentPane().add(txtFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 390, 290, 30));

        lblCosto.setBackground(new java.awt.Color(255, 255, 255));
        lblCosto.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        lblCosto.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 220, 30));

        btnConfirmar.setBorderPainted(false);
        btnConfirmar.setContentAreaFilled(false);
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, 140, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modulo de licencias.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 550));

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

    private void txtRFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRFCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRFCActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        volver();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtFechaNacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaNacActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        registrar();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbVigencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JTextField txtAmaterno;
    private javax.swing.JTextField txtApaterno;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRFC;
    // End of variables declaration//GEN-END:variables
}
