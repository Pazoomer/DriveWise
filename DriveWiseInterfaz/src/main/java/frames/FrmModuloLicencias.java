package frames;

import daos.conexion.IConexionDAO;
import dtos.licencia.LicenciaNuevaDTO;
import dtos.persona.PersonaConsultableDTO;
import excepciones.PersistenciaException;
import excepciones.ValidacionException;
import java.awt.Color;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
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
        cmbVigencia.setVisible(false);
        this.lblTelefonoEstatico.setBackground(new Color(0,0,0,0));

    }
    
    /**
     * Verifica que los campos no esten vacios
     *
     * @return true si ningun campo esta vacio, false en caso contrario
     */
    private boolean verificarRFC() {
//        if (!validadores.validarRfc(txtRFC.getText())) {
//            JOptionPane.showMessageDialog(this, "RFC debe tener formato ABC123", "Formato inválido", JOptionPane.ERROR_MESSAGE);
//            return false;
//        } else 
        if (txtRFC.getText().isEmpty() || txtRFC.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Indique un rfc", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Método para comprobar que los campos no esten vacios o en blanco.
     * @return valor booleano.
     */
    private boolean verificarCampos() {
        if (txtFechaNac.getText().isEmpty() || txtAmaterno.getText().isEmpty() || txtApaterno.getText().isEmpty() || txtNombre.getText().isEmpty()) {
            return true;
        }
        return false;
    }
    
    /**
     * Este metodo ayuda a buscar a una persona en base a su RFC, ademas de validar
     * si esta persona realmente existe en la base de datos.
     */
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
                this.txtTelefono.setText(persona.getTelefono());
                cmbVigencia.setVisible(true);

            } catch (PersistenciaException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);

            } catch (ValidacionException ex) {
                JOptionPane.showMessageDialog(this, "La version no es compatible, actualize a una version más reciente", "Error", JOptionPane.ERROR_MESSAGE);

            }

        } else {

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
        JOptionPane.showMessageDialog(this, "Licencia añadida con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    /**
     * Método para registrar una nueva licencia
     */
    private void registrar() {
        try {
            if (verificarCampos()) {
                JOptionPane.showMessageDialog(this, "Primero consulte una persona", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (cmbVigencia.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Selecciona una vigencia válida", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            IRegistroLicenciasBO registroLicenciasBO= new RegistroLicenciasBO(conexion);
            Calendar calendarLicencia = Calendar.getInstance();

            if (!registroLicenciasBO.mayorEdad(persona.getNacimiento())) {
                JOptionPane.showMessageDialog(this, "No se puede agregar una licencia a un menor de edad", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //Se crea un objeto de licencia nueva
            LicenciaNuevaDTO licencia = new LicenciaNuevaDTO(calendarLicencia, persona, cmbVigencia.getSelectedIndex());
            
            registroLicenciasBO.registrarLicencia(licencia);

            mensajeExito();
        } catch (NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(this, "La version no es compatible, actualize a una versiona más reciente", "Error", JOptionPane.ERROR_MESSAGE);

        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTelefonoEstatico = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
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
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTelefonoEstatico.setBackground(new java.awt.Color(51, 51, 51));
        lblTelefonoEstatico.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTelefonoEstatico.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefonoEstatico.setText("Telefono");
        lblTelefonoEstatico.setOpaque(true);
        getContentPane().add(lblTelefonoEstatico, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, -1, -1));

        txtTelefono.setEditable(false);
        txtTelefono.setOpaque(true);
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 210, -1));

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

        cmbVigencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar años", "1", "2", "3" }));
        cmbVigencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVigenciaActionPerformed(evt);
            }
        });
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
        getContentPane().add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, 150, 60));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modulo de licencias.jpg"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 550));

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

    private void cmbVigenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVigenciaActionPerformed
        IRegistroLicenciasBO registroLicenciasBO = new RegistroLicenciasBO(conexion);
        float costo = registroLicenciasBO.calcularCosto(cmbVigencia.getSelectedIndex(), persona.getDiscapacitado());
        lblCosto.setText("Costo: $" + costo);  
    }//GEN-LAST:event_cmbVigenciaActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbVigencia;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblTelefonoEstatico;
    private javax.swing.JTextField txtAmaterno;
    private javax.swing.JTextField txtApaterno;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRFC;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
