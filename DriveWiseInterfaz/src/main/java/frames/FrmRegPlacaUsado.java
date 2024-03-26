
package frames;

import daos.conexion.IConexionDAO;
import dtos.persona.PersonaConsultableDTO;
import excepciones.PersistenciaException;
import excepciones.ValidacionException;
import javax.swing.JOptionPane;
import negocio.placa.IRegistroPlacasBO;
import negocio.placa.RegistroPlacasBO;

/**
 *
 * @author JoseH
 */
public class FrmRegPlacaUsado extends javax.swing.JFrame {

    IConexionDAO conexion;
    /**
     * Creates new form FrmCambioPlacas
     * @param conexion Conexion con la base de datos
     */
    public FrmRegPlacaUsado(IConexionDAO conexion) {
        this.setResizable(false);
        initComponents();
        this.conexion = conexion;
    }
    
    /**
     * Valida que los campos de texto no esten vacios
     * @return Verdadero si no hay campos vacios
     */
    private boolean validarCampos(){
        if (this.txfRfc.getText().isBlank()||this.txfPlacasAnteriores.getText().isBlank()) {
            return false;
        }
        return true;
    }
    
    /**
     * Valida que la persona que le corresponde el rfc exista en la base de
     * datos y tenga una licencia vigente
     *
     * @return Verdadero si existe y tiene una licencia vigente, falso en caso
     * contrario
     */
    private boolean validarLicencia() {
        IRegistroPlacasBO registroPlacasBO = new RegistroPlacasBO(conexion);

        PersonaConsultableDTO personaDTO = new PersonaConsultableDTO(this.txfRfc.getText());

        try {
            return registroPlacasBO.validarLicencia(personaDTO);

        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, "El RFC no pertenece a ninguna persona", "RFC invalido", JOptionPane.INFORMATION_MESSAGE);

        } catch (ValidacionException ex) {
            JOptionPane.showMessageDialog(this, "La persona no tiene ninguna licencia vigente", "RFC invalido", JOptionPane.INFORMATION_MESSAGE);

        }
        return false;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblVehiculoDinamico = new javax.swing.JLabel();
        lblLogoEstatico = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblTituloEstatico = new javax.swing.JLabel();
        lblRfcEstatico = new javax.swing.JLabel();
        txfRfc = new javax.swing.JTextField();
        lnlPlacasEstatico = new javax.swing.JLabel();
        txfPlacasAnteriores = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblVehiculoEstatico = new javax.swing.JLabel();
        lblModeloEstatico = new javax.swing.JLabel();
        lblMarcaEstatica = new javax.swing.JLabel();
        lblLineaEstatico = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(960, 540));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblVehiculoDinamico.setBackground(new java.awt.Color(127, 0, 0));
        lblVehiculoDinamico.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        lblLogoEstatico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        lblTituloEstatico.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTituloEstatico.setText("Placa para automóvil usado");

        lblRfcEstatico.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblRfcEstatico.setForeground(new java.awt.Color(127, 0, 0));
        lblRfcEstatico.setText("RFC del dueño");

        txfRfc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lnlPlacasEstatico.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lnlPlacasEstatico.setForeground(new java.awt.Color(127, 0, 0));
        lnlPlacasEstatico.setText("Número de placas anteriores");

        txfPlacasAnteriores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnConfirmar.setBackground(new java.awt.Color(127, 0, 0));
        btnConfirmar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnVolver.setBackground(new java.awt.Color(127, 0, 0));
        btnVolver.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        lblVehiculoEstatico.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblVehiculoEstatico.setText("Vehículo encontrado");

        lblModeloEstatico.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblModeloEstatico.setText("Modelo");

        lblMarcaEstatica.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMarcaEstatica.setText("Marca");

        lblLineaEstatico.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblLineaEstatico.setText("Línea");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLogoEstatico)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTituloEstatico, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txfRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblRfcEstatico))
                                        .addGap(71, 71, 71)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lnlPlacasEstatico, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                                            .addComponent(txfPlacasAnteriores, javax.swing.GroupLayout.Alignment.LEADING))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblVehiculoEstatico, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(106, 106, 106)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblVehiculoDinamico, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblModeloEstatico)
                                                .addGap(111, 111, 111)
                                                .addComponent(lblMarcaEstatica)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblLineaEstatico)))
                                        .addGap(199, 199, 199)))))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblLogoEstatico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTituloEstatico, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblRfcEstatico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txfRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lnlPlacasEstatico)
                                .addGap(18, 18, 18)
                                .addComponent(txfPlacasAnteriores, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addComponent(lblVehiculoEstatico, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLineaEstatico, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMarcaEstatica, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblModeloEstatico, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblVehiculoDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if (validarCampos()) {
            if (validarLicencia()) {
                
            }
        }

    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblLineaEstatico;
    private javax.swing.JLabel lblLogoEstatico;
    private javax.swing.JLabel lblMarcaEstatica;
    private javax.swing.JLabel lblModeloEstatico;
    private javax.swing.JLabel lblRfcEstatico;
    private javax.swing.JLabel lblTituloEstatico;
    private javax.swing.JLabel lblVehiculoDinamico;
    private javax.swing.JLabel lblVehiculoEstatico;
    private javax.swing.JLabel lnlPlacasEstatico;
    private javax.swing.JTextField txfPlacasAnteriores;
    private javax.swing.JTextField txfRfc;
    // End of variables declaration//GEN-END:variables
}
