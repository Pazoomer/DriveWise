/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import daos.conexion.IConexionDAO;

/**
 *
 * @author Enrique Rodriguez
 */
public class FrmRegPlacasUsado extends javax.swing.JFrame {

    IConexionDAO conexion;
    
    /**
     * Creates new form FrmRegPlacasUsadas
     */
    public FrmRegPlacasUsado(IConexionDAO conexion) {
        this.setResizable(false);
        initComponents();
        this.conexion = conexion;
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
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        txtRFC = new javax.swing.JTextField();
        txtPlacasAntiguas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(940, 550));
        setPreferredSize(new java.awt.Dimension(940, 550));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(940, 550));
        jPanel1.setPreferredSize(new java.awt.Dimension(940, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(127, 0, 0));
        jLabel4.setText("Número de placas anteriores");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 209, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 26, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Placa para automovil usado");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 135, 321, 44));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 106, 810, 17));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(127, 0, 0));
        jLabel5.setText("RFC del dueño");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 209, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Vehículo encontrado");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 373, -1, -1));

        btnVolver.setBackground(new java.awt.Color(153, 0, 0));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 449, 135, 47));

        txtRFC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 263, 242, 33));

        txtPlacasAntiguas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtPlacasAntiguas, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 263, 245, 33));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Modelo");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 343, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Marca");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 343, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Linea");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 343, -1, -1));

        btnConfirmar.setBackground(new java.awt.Color(153, 0, 0));
        btnConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setText("Confirmar");
        jPanel1.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 450, 135, 47));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtPlacasAntiguas;
    private javax.swing.JTextField txtRFC;
    // End of variables declaration//GEN-END:variables
}
