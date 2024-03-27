
package frames;

import daos.conexion.IConexionDAO;
import dtos.persona.PersonaConsultableDTO;
import dtos.tramite.TramiteConsultableDTO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author t1pas
 */
public class FrmModuloConsultasHistorial extends javax.swing.JFrame {

     IConexionDAO conexion;
     List<TramiteConsultableDTO> tramites;
     String nombrePersona;
     
    /**
     * Creates new form FrmModuloConsultasHistorial
     * @param conexion
     * @param tramites
     * @param nombrePersona
     */
    public FrmModuloConsultasHistorial(IConexionDAO conexion, List<TramiteConsultableDTO> tramites,String nombrePersona) {
        this.setResizable(false);
        initComponents();
        this.conexion = conexion;
        this.tramites=tramites;
        this.nombrePersona=nombrePersona;
        actualizarTabla();
        actualizarTitulo();
    }
    
    private void actualizarTitulo(){
        this.lblTituloDinamico.setText("Historial de tramites de "+nombrePersona);
    }
    
    /**
     * Actualiza la tabla con las personas
     */
    private void actualizarTabla() {
        // Crear un modelo de tabla sin encabezados
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Esto evita que las celdas sean editables
            }
        };

        // Agregar las columnas
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Fecha de emision");
        modeloTabla.addColumn("Costo");

        // Crear un DecimalFormat para el formato de costo
        DecimalFormat df = new DecimalFormat("#,##0.00");
        // Formatear el Calendar como DD/MM/AAAA
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        // Agregar los datos de las personas
        for (TramiteConsultableDTO tramite : tramites) {

            //Formatear la fecha
            String fechaFormateada = sdf.format(tramite.getEmision().getTime());

            // Formatear el costo
            String costoFormateado = df.format(tramite.getCosto());

            Object[] fila = {tramite.getTipo(), fechaFormateada, costoFormateado};
            modeloTabla.addRow(fila);
        }

        // Establecer el modelo de la tabla
        this.tblTramites.setModel(modeloTabla);
        tblTramites.getTableHeader().setVisible(false);
    }

    /**
     * Abre la pantalla de moduloConsultas y cierra esta
     */
    private void nuevaBusqueda() {
        FrmModuloConsultas on = new FrmModuloConsultas(conexion);
        on.setVisible(true);
        this.dispose();
    }

    /**
     * Abre la pantalla principal y cierra esta
     */
    private void volver() {
        FrmPantallaPrincipal on = new FrmPantallaPrincipal(conexion);
        on.setVisible(true);
        this.dispose();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloDinamico = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTramites = new javax.swing.JTable();
        lblTipoEstatico = new javax.swing.JLabel();
        lblEmisionEstatico = new javax.swing.JLabel();
        lblCostoEstatico = new javax.swing.JLabel();
        btnNuevaBusqueda = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTituloDinamico.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTituloDinamico.setForeground(new java.awt.Color(204, 0, 0));
        lblTituloDinamico.setText("Historial de tramites de \"\"");

        tblTramites.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTramites);

        lblTipoEstatico.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTipoEstatico.setText("Tipo");

        lblEmisionEstatico.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmisionEstatico.setText("Fecha de emisión");

        lblCostoEstatico.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCostoEstatico.setText("Costo");

        btnNuevaBusqueda.setBackground(new java.awt.Color(255, 0, 0));
        btnNuevaBusqueda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNuevaBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevaBusqueda.setText("Nueva Busqueda");
        btnNuevaBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaBusquedaActionPerformed(evt);
            }
        });

        btnVolver.setBackground(new java.awt.Color(255, 153, 0));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver al menú");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(lblTipoEstatico, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(lblEmisionEstatico)
                .addGap(74, 74, 74)
                .addComponent(lblCostoEstatico, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnNuevaBusqueda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addGap(137, 137, 137))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoEstatico)
                    .addComponent(lblEmisionEstatico)
                    .addComponent(lblCostoEstatico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevaBusqueda)
                    .addComponent(btnVolver))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(lblTituloDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblTituloDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaBusquedaActionPerformed
        nuevaBusqueda();
    }//GEN-LAST:event_btnNuevaBusquedaActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        volver();
    }//GEN-LAST:event_btnVolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevaBusqueda;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCostoEstatico;
    private javax.swing.JLabel lblEmisionEstatico;
    private javax.swing.JLabel lblTipoEstatico;
    private javax.swing.JLabel lblTituloDinamico;
    private javax.swing.JTable tblTramites;
    // End of variables declaration//GEN-END:variables
}
