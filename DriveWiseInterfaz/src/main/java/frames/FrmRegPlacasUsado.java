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
import excepciones.PersistenciaException;
import java.awt.Color;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import negocio.persona.BuscarLicenciaValidaBO;
import negocio.persona.IBuscarLicenciaValidaBO;
import negocio.placa.ConsultaVehiculoBO;
import negocio.placa.IConsultaVehiculoBO;
import negocio.placa.IRegistroPlacasBO;
import negocio.placa.RegistroPlacasBO;
import validadores.Validadores;

/**
 *
 * @author Enrique Rodriguez
 */
public class FrmRegPlacasUsado extends javax.swing.JFrame {

    VehiculoConsultableDTO vehiculoDTO;
    IConexionDAO conexion;
    Validadores validadores = new Validadores();
    PersonaConsultableDTO persona;
    
    /**
     * Creates new form FrmRegPlacasUsadas
     */
    public FrmRegPlacasUsado(IConexionDAO conexion) {
        this.setResizable(false);
        initComponents();
        this.conexion = conexion;
        lblPlacasAnteriores.setVisible(false);
        txtPlacasAntiguas.setVisible(false);
        lblAutoEncontrado.setVisible(false);
        lblNumSerie.setVisible(false);
        lblMarca.setVisible(false);
        lblModelo.setVisible(false);
        lblLinea.setVisible(false);
        btnConfirmar.setVisible(false);
        btnBuscarAuto.setVisible(false);
    }
    
    private boolean verificarRfc(){
        if (txtRfc.getText().isBlank() || txtRfc.getText().isEmpty()){
            return false;
        }
        return true;
    }

    private void validarLicencia(){
        if (verificarRfc()) {
            IBuscarLicenciaValidaBO blvBO = new BuscarLicenciaValidaBO(conexion);
            persona = new PersonaConsultableDTO(txtRfc.getText());
            
            try {
                if (blvBO.validarLicencia(persona)){
                    txtRfc.setEditable(false);
                    btnValidarLicencia.setBackground(Color.GREEN);
                    btnValidarLicencia.setEnabled(false);
                    btnValidarLicencia.setText("Licencia vigente");
                    btnValidarLicencia.setForeground(Color.BLACK);
                    lblPlacasAnteriores.setVisible(true);
                    txtPlacasAntiguas.setVisible(true);
                    btnBuscarAuto.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Debe tener una licencia vigente", "No autorizado", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (PersistenciaException ex){
                Logger.getLogger(FrmModuloLicencias.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Indique un rfc", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    private void buscarAuto(){
        PlacaConsultableDTO placaDTO = new PlacaConsultableDTO(txtPlacasAntiguas.getText());
        IConsultaVehiculoBO cvBO = new ConsultaVehiculoBO(this.conexion);
        try {
            vehiculoDTO = cvBO.consultarVehiculo(placaDTO);
            if (vehiculoDTO == null){
                JOptionPane.showMessageDialog(this, "Estas placas no han sido registradas", "No autorizado", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                lblAutoEncontrado.setVisible(true);
                lblNumSerie.setVisible(true);
                lblMarca.setVisible(true);
                lblModelo.setVisible(true);
                lblLinea.setVisible(true);
                btnConfirmar.setVisible(true);
                txtNumSerie.setText(vehiculoDTO.getNumSerie());
                txtModelo.setText(vehiculoDTO.getModelo());
                txtMarca.setText(vehiculoDTO.getMarca());
                txtLinea.setText(vehiculoDTO.getLinea());
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(FrmRegPlacasUsado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Muestra la pantalla de licencia agregada con exito
     */
    private void mensajeExito() {
        JOptionPane.showMessageDialog(this, "Placa añadida con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void registrar(){
        IRegistroPlacasBO rpBO = new RegistroPlacasBO(this.conexion);
        Calendar calendarPlaca = Calendar.getInstance();
                
        PlacaConsultableDTO placaDTO = new PlacaConsultableDTO(txtPlacasAntiguas.getText());
        try {
            rpBO.registrarPlacasUsado(persona, placaDTO);
            mensajeExito();
        } catch (PersistenciaException ex) {
            Logger.getLogger(FrmRegPlacasNuevo.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        lblPlacasAnteriores = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblRfc = new javax.swing.JLabel();
        lblAutoEncontrado = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        txtRfc = new javax.swing.JTextField();
        txtPlacasAntiguas = new javax.swing.JTextField();
        lblNumSerie = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblLinea = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        btnBuscarAuto = new javax.swing.JButton();
        btnValidarLicencia = new javax.swing.JButton();
        lblModelo = new javax.swing.JLabel();
        txtLinea = new javax.swing.JTextField();
        txtNumSerie = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(940, 550));
        setPreferredSize(new java.awt.Dimension(940, 550));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(940, 550));
        jPanel1.setPreferredSize(new java.awt.Dimension(940, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPlacasAnteriores.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPlacasAnteriores.setForeground(new java.awt.Color(127, 0, 0));
        lblPlacasAnteriores.setText("Número de placas anteriores");
        jPanel1.add(lblPlacasAnteriores, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 26, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Placa para automovil usado");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 135, 321, 44));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 106, 810, 17));

        lblRfc.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblRfc.setForeground(new java.awt.Color(127, 0, 0));
        lblRfc.setText("RFC del dueño");
        jPanel1.add(lblRfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 209, -1, -1));

        lblAutoEncontrado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAutoEncontrado.setText("Auto encontrado");
        jPanel1.add(lblAutoEncontrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 373, -1, -1));

        btnVolver.setBackground(new java.awt.Color(153, 0, 0));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 449, 135, 47));

        txtRfc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtRfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 242, 33));

        txtPlacasAntiguas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtPlacasAntiguas, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 245, 33));

        lblNumSerie.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNumSerie.setText("Núm. de serie");
        jPanel1.add(lblNumSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, -1, -1));

        lblMarca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMarca.setText("Marca");
        jPanel1.add(lblMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, -1, -1));

        lblLinea.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLinea.setText("Linea");
        jPanel1.add(lblLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 340, -1, -1));

        btnConfirmar.setBackground(new java.awt.Color(153, 0, 0));
        btnConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 450, 135, 47));

        btnBuscarAuto.setBackground(new java.awt.Color(255, 108, 62));
        btnBuscarAuto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscarAuto.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarAuto.setText("Buscar automóvil");
        btnBuscarAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAutoActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, 170, -1));

        btnValidarLicencia.setBackground(new java.awt.Color(255, 108, 62));
        btnValidarLicencia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnValidarLicencia.setForeground(new java.awt.Color(255, 255, 255));
        btnValidarLicencia.setText("Validar licencia");
        btnValidarLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarLicenciaActionPerformed(evt);
            }
        });
        jPanel1.add(btnValidarLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 170, -1));

        lblModelo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblModelo.setText("Modelo");
        jPanel1.add(lblModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, -1, -1));

        txtLinea.setBorder(null);
        jPanel1.add(txtLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 380, 130, -1));

        txtNumSerie.setBorder(null);
        jPanel1.add(txtNumSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 130, -1));

        txtModelo.setBorder(null);
        jPanel1.add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, 130, -1));

        txtMarca.setBorder(null);
        jPanel1.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, 120, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAutoActionPerformed
        buscarAuto();
    }//GEN-LAST:event_btnBuscarAutoActionPerformed

    private void btnValidarLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarLicenciaActionPerformed
        validarLicencia();
    }//GEN-LAST:event_btnValidarLicenciaActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        registrar();
    }//GEN-LAST:event_btnConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarAuto;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnValidarLicencia;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAutoEncontrado;
    private javax.swing.JLabel lblLinea;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNumSerie;
    private javax.swing.JLabel lblPlacasAnteriores;
    private javax.swing.JLabel lblRfc;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNumSerie;
    private javax.swing.JTextField txtPlacasAntiguas;
    private javax.swing.JTextField txtRfc;
    // End of variables declaration//GEN-END:variables
}
