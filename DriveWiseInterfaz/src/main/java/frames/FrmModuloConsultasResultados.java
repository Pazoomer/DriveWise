
package frames;

import daos.conexion.IConexionDAO;
import dtos.persona.PersonaConsultableDTO;
import dtos.tramite.TramiteConsultableDTO;
import excepciones.PersistenciaException;
import excepciones.ValidacionException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.tramite.ConsultarTramitesBO;
import negocio.tramite.IConsultarTramitesBO;

/**
 *
 * @author t1pas
 */
public class FrmModuloConsultasResultados extends javax.swing.JFrame {

    IConexionDAO conexion;
    List<PersonaConsultableDTO> personas;
    String nombrePersona;
    String titulo;

    /**
     * Creates new form FrmModuloConsultasResultados
     *
     * @param conexion
     * @param personas
     */
    public FrmModuloConsultasResultados(IConexionDAO conexion, List<PersonaConsultableDTO> personas,String titulo) {
        this.setResizable(false);
        initComponents();
        this.conexion = conexion;
        this.personas = personas;
        this.titulo=titulo;
        actualizarTabla();
        actualizarTitulo();
    }
    
    private void actualizarTitulo(){
        this.lblTituloDinamico.setText("Resultados coincidentes para "+titulo);
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
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("RFC");

        // Agregar los datos de las personas
        for (PersonaConsultableDTO persona : personas) {
            Object[] fila = {persona.getNombre(), persona.getRfc()};
            modeloTabla.addRow(fila);
        }

        // Establecer el modelo de la tabla
        this.tablaPersonas.setModel(modeloTabla);
        tablaPersonas.getTableHeader().setVisible(false);

        tablaPersonas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tablaPersonas.getSelectedRow();
                if (filaSeleccionada != -1) {
                    // Obtener el RFC de la persona seleccionada
                    String nombre = (String) tablaPersonas.getValueAt(filaSeleccionada, 0); // La columna 1 contiene el RFC
                    nombrePersona=nombre;
                    String rfc = (String) tablaPersonas.getValueAt(filaSeleccionada, 1); // La columna 1 contiene el RFC

                    abrirHistorial(consultarTramitesPorRfc(rfc));
                }
            }
        });
    }
    
    /**
     * Consulta los tramites de una persona
     */
    private List<TramiteConsultableDTO> consultarTramitesPorRfc(String rfc){
        IConsultarTramitesBO consultarTramites=new ConsultarTramitesBO(conexion);
        
        PersonaConsultableDTO persona=new PersonaConsultableDTO(rfc);
        
        List<TramiteConsultableDTO> tramites;
        try {
            tramites=consultarTramites.consultarTramitePorPersona(persona);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo acceder a la base de datos", "Error en la base de datos", JOptionPane.ERROR_MESSAGE);
            return null;
        } catch (ValidacionException ex) {
            JOptionPane.showMessageDialog(this, "La persona no tiene tramites", "No hay resultados", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        return tramites;
    }

    /**
     * Abre la pantalla consultas historial y cierra esta
     */
    private void abrirHistorial(List<TramiteConsultableDTO> tramites) {

        if (tramites == null) {
            return;
        }
        FrmModuloConsultasHistorial on = new FrmModuloConsultasHistorial(conexion, tramites,nombrePersona);
        on.setVisible(true);
        this.dispose();
    }


    /**
     * Abre la pantalla principal y cierra esta
     */
    private void volver() {
        FrmModuloConsultas on = new FrmModuloConsultas(conexion);
        on.setVisible(true);
        this.dispose();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloDinamico = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblNombreEstatico = new javax.swing.JLabel();
        lblRfcEstatico = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPersonas = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTituloDinamico.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        lblTituloDinamico.setForeground(new java.awt.Color(204, 0, 0));
        lblTituloDinamico.setText("Resultados coincidentes para \"\"");

        lblNombreEstatico.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombreEstatico.setText("Nombre");

        lblRfcEstatico.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRfcEstatico.setText("RFC");

        tablaPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaPersonas);

        btnVolver.setBackground(new java.awt.Color(255, 102, 0));
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(lblNombreEstatico, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRfcEstatico, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEstatico)
                    .addComponent(lblRfcEstatico))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTituloDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(lblTituloDinamico)
                .addGap(71, 71, 71)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        volver();
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombreEstatico;
    private javax.swing.JLabel lblRfcEstatico;
    private javax.swing.JLabel lblTituloDinamico;
    private javax.swing.JTable tablaPersonas;
    // End of variables declaration//GEN-END:variables
}
