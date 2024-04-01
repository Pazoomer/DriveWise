/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import daos.conexion.IConexionDAO;
import dtos.persona.PersonaConsultableDTO;
import dtos.placa.PlacaConsultableDTO;
import dtos.placa.PlacaNuevaDTO;
import dtos.vehiculo.VehiculoConsultableDTO;
import dtos.vehiculo.VehiculoNuevoDTO;
import excepciones.PersistenciaException;
import excepciones.ValidacionException;
import java.awt.Color;
import java.awt.Component;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import negocio.licencia.RegistroLicenciasBO;
import negocio.persona.BuscarLicenciaValidaBO;
import negocio.persona.IBuscarLicenciaValidaBO;
import negocio.placa.ConsultaVehiculoBO;
import negocio.placa.IConsultaVehiculoBO;
import negocio.placa.IRegistroPlacasBO;
import negocio.placa.RegistroPlacasBO;
import validadores.Validadores;

/**
 *
 * @author JoseH
 */
public class FrmRegPlacasNuevo extends javax.swing.JFrame {

    IConexionDAO conexion;
    Validadores validadores = new Validadores();
    PersonaConsultableDTO persona;

    /**
     * Creates new form FrmRegPlacasNuevo
     */
    public FrmRegPlacasNuevo(IConexionDAO conexion) {
        this.setResizable(false);
        initComponents();
        this.conexion = conexion;
        for (Component comp : jPanel1.getComponents()) {
            if (comp instanceof JLabel || comp instanceof JTextField) {
                comp.setVisible(false);
            }
        }
        btnConfirmar.setVisible(false);
        lblLogo.setVisible(true);
        lblTitulo.setVisible(true);
        lblRfc.setVisible(true);
        txtRfc.setVisible(true);

    }
    /**
     * Método que verifica primero que el campo de textoRfc no esté vacio,
     * posteriormente verifica que el RFC sea uno registrado en la BD.
     * @return valor booleano.
     */
    private boolean verificarRfc() {

        if (!validadores.validarRfc(txtRfc.getText())) {
            JOptionPane.showMessageDialog(this, "RFC debe tener formato ABC123", "Formato inválido", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (txtRfc.getText().isEmpty() || txtRfc.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Indique un rfc", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        PersonaConsultableDTO personaConsultada = new PersonaConsultableDTO(txtRfc.getText());
        try {
            RegistroLicenciasBO buscar = new RegistroLicenciasBO(conexion);
            PersonaConsultableDTO personaux = buscar.buscarPersonaRfc(personaConsultada);
            if (personaux == null) {
                JOptionPane.showMessageDialog(this, "Persona no encontrada", "Persona desconocida", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
        } catch (PersistenciaException ex) {
            Logger.getLogger(FrmModuloReportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ValidacionException ex) {
            Logger.getLogger(FrmModuloReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    /**
     * Método que verifica que todos los campos esten llenos.
     * @return verdadero si estan llenos, falso en caso contrario.
     */
    private boolean verificarCampos() {
        lblErrorNumSerie.setForeground(Color.BLACK);
        lblErrorMarca.setVisible(false);
        lblErrorLinea.setVisible(false);
        lblErrorColor.setVisible(false);
        lblErrorModelo.setVisible(false);
        if (txtNumSerie.getText().isBlank()
                || txtNumSerie.getText().isEmpty() || txtMarca.getText().isBlank() || txtMarca.getText().isEmpty()
                || txtLinea.getText().isBlank() || txtLinea.getText().isEmpty() || txtColor.getText().isBlank()
                || txtColor.getText().isEmpty() || txtModelo.getText().isBlank() || txtModelo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!validadores.validarNumSerie(txtNumSerie.getText())) {
            lblErrorNumSerie.setForeground(Color.RED);
            return false;
        } else if (!validadores.validarString(txtMarca.getText())) {
            lblErrorMarca.setVisible(true);
            return false;
        } else if (!validadores.validarString(txtLinea.getText())) {
            lblErrorLinea.setVisible(true);
            return false;
        } else if (!validadores.validarString(txtColor.getText())) {
            lblErrorColor.setVisible(true);
            return false;
        } else if (!validadores.validarString(txtModelo.getText())) {
            lblErrorModelo.setVisible(true);
            return false;
        }
        return true;
    }
    
    /**
     * Método que nos ayuda a validar una licencia, comprueba si esta es vigente o no,
     * si no se encuentra vigente, lanzá un JOptionPane indicando dicho error.
     */
    private void validarLicencia() {
        if (verificarRfc()) {
            IBuscarLicenciaValidaBO blvBO = new BuscarLicenciaValidaBO(conexion);
            persona = new PersonaConsultableDTO(txtRfc.getText());

            try {
                if (blvBO.validarLicencia(persona)) {
                    txtRfc.setEditable(false);
                    btnValidarLicencia.setBackground(Color.GREEN);
                    btnValidarLicencia.setEnabled(false);
                    btnValidarLicencia.setText("Licencia vigente");
                    btnValidarLicencia.setForeground(Color.BLACK);
                    btnValidarLicencia.repaint();
                    for (Component comp : jPanel1.getComponents()) {
                        if (comp instanceof JLabel || comp instanceof JTextField) {
                            comp.setVisible(true);
                        }
                    }
                    lblErrorNumSerie.setVisible(false);
                    lblErrorColor.setVisible(false);
                    lblErrorMarca.setVisible(false);
                    lblErrorLinea.setVisible(false);
                    lblErrorModelo.setVisible(false);
                    btnConfirmar.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Debe tener una licencia vigente", "No autorizado", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (PersistenciaException ex) {
                Logger.getLogger(FrmModuloLicencias.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            
            return;
        }
    }

    private void registrar() {
        if (!verificarCampos()) {
            return;
        } 
        IRegistroPlacasBO rpBO = new RegistroPlacasBO(this.conexion);
        Calendar calendarPlaca = Calendar.getInstance();

        VehiculoConsultableDTO vehiculoConsulta = new VehiculoConsultableDTO(txtNumSerie.getText());
        
        IConsultaVehiculoBO cvBO = new ConsultaVehiculoBO(conexion);
        try {
            if (cvBO.consultarVehiculo(vehiculoConsulta) != null){
                JOptionPane.showMessageDialog(this, "Este vehículo ya está registrado", "No válido", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(FrmRegPlacasNuevo.class.getName()).log(Level.SEVERE, null, ex);
        }
        VehiculoNuevoDTO vehiculo = new VehiculoNuevoDTO(txtNumSerie.getText(), txtMarca.getText(), txtLinea.getText(), txtColor.getText(), txtModelo.getText());
        PlacaNuevaDTO placaNuevaDTO = new PlacaNuevaDTO(calendarPlaca, vehiculo);
        PlacaNuevaDTO placaCreada;
        try {
            placaCreada=rpBO.registrarPlacaNuevo(persona, placaNuevaDTO);
            mensajeExito();
            JOptionPane.showMessageDialog(this, "La nueva placa es "+placaCreada.getAlfanumerico(), "Exito", JOptionPane.INFORMATION_MESSAGE);

        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, "Hubo un error en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    /**
     * Muestra la pantalla de licencia agregada con exito
     */
    private void mensajeExito() {
        JOptionPane.showMessageDialog(this, "Placa añadida con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblNumSerie = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        txtNumSerie = new javax.swing.JTextField();
        btnValidarLicencia = new javax.swing.JButton();
        lblRfc = new javax.swing.JLabel();
        txtRfc = new javax.swing.JTextField();
        lblLinea = new javax.swing.JLabel();
        txtLinea = new javax.swing.JTextField();
        lblColor = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        lblMarca = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        lblModelo = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        lblErrorModelo = new javax.swing.JLabel();
        lblErrorNumSerie = new javax.swing.JLabel();
        lblErrorMarca = new javax.swing.JLabel();
        lblErrorLinea = new javax.swing.JLabel();
        lblErrorColor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(940, 550));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(940, 550));
        jPanel1.setPreferredSize(new java.awt.Dimension(940, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N
        jPanel1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setText("Placa para automovil nuevo");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 135, 321, 44));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 106, 810, 17));

        lblNumSerie.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblNumSerie.setForeground(new java.awt.Color(127, 0, 0));
        lblNumSerie.setText("Número de serie");
        jPanel1.add(lblNumSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        btnVolver.setBackground(new java.awt.Color(153, 0, 0));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 135, 40));

        txtNumSerie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtNumSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 210, -1));

        btnValidarLicencia.setBackground(new java.awt.Color(255, 108, 62));
        btnValidarLicencia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnValidarLicencia.setForeground(new java.awt.Color(255, 255, 255));
        btnValidarLicencia.setText("Validar licencia");
        btnValidarLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarLicenciaActionPerformed(evt);
            }
        });
        jPanel1.add(btnValidarLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 170, -1));

        lblRfc.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblRfc.setForeground(new java.awt.Color(127, 0, 0));
        lblRfc.setText("RFC del dueño");
        jPanel1.add(lblRfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 209, -1, -1));

        txtRfc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtRfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 210, -1));

        lblLinea.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblLinea.setForeground(new java.awt.Color(127, 0, 0));
        lblLinea.setText("Línea");
        jPanel1.add(lblLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        txtLinea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 170, -1));

        lblColor.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblColor.setForeground(new java.awt.Color(127, 0, 0));
        lblColor.setText("Color");
        jPanel1.add(lblColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, -1, -1));

        txtColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 410, 170, -1));

        lblMarca.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblMarca.setForeground(new java.awt.Color(127, 0, 0));
        lblMarca.setText("Marca");
        jPanel1.add(lblMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, -1));

        txtMarca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 170, -1));

        lblModelo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblModelo.setForeground(new java.awt.Color(127, 0, 0));
        lblModelo.setText("Modelo");
        jPanel1.add(lblModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, -1, -1));

        txtModelo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, 170, -1));

        btnConfirmar.setBackground(new java.awt.Color(153, 0, 0));
        btnConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 470, 135, 40));

        lblErrorModelo.setForeground(new java.awt.Color(255, 0, 51));
        lblErrorModelo.setText("* Incluya solo letras");
        jPanel1.add(lblErrorModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 440, 210, -1));

        lblErrorNumSerie.setText("* Formato: ABC-123");
        jPanel1.add(lblErrorNumSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 210, -1));

        lblErrorMarca.setForeground(new java.awt.Color(255, 0, 51));
        lblErrorMarca.setText("* Incluya solo letras");
        jPanel1.add(lblErrorMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 210, -1));

        lblErrorLinea.setForeground(new java.awt.Color(255, 0, 51));
        lblErrorLinea.setText("* Incluya solo letras");
        jPanel1.add(lblErrorLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 210, -1));

        lblErrorColor.setForeground(new java.awt.Color(255, 0, 51));
        lblErrorColor.setText("* Incluya solo letras");
        jPanel1.add(lblErrorColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 210, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void btnValidarLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarLicenciaActionPerformed
        validarLicencia();
    }//GEN-LAST:event_btnValidarLicenciaActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        registrar();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void volver() {
        FrmPantallaPrincipal on = new FrmPantallaPrincipal(conexion);
        on.setVisible(true);
        this.dispose();
    }

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        volver();
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnValidarLicencia;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblErrorColor;
    private javax.swing.JLabel lblErrorLinea;
    private javax.swing.JLabel lblErrorMarca;
    private javax.swing.JLabel lblErrorModelo;
    private javax.swing.JLabel lblErrorNumSerie;
    private javax.swing.JLabel lblLinea;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNumSerie;
    private javax.swing.JLabel lblRfc;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNumSerie;
    private javax.swing.JTextField txtRfc;
    // End of variables declaration//GEN-END:variables
}
