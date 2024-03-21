
package forms;

import dtos.persona.PersonaConsultableDTO;
import javax.swing.table.DefaultTableModel;
import mapas.personas.Persona;

/**
 *
 * @author t1pas
 */
public final class FrmInsercionMasiva extends javax.swing.JFrame {

    PersonaConsultableDTO[] personas;
    /**
     * Creates new form FrmInsercionMasiva
     * @param personas
     */
    public FrmInsercionMasiva(PersonaConsultableDTO[] personas) {
        this.setResizable(false);
        initComponents();
        this.personas = personas;
        colocarPersonas();
    }

    /**
     * Coloca las personas en la tabla
     */
    public void colocarPersonas() {
        DefaultTableModel modelo = (DefaultTableModel) tabPersonas.getModel();
        modelo.setRowCount(0);

        for (PersonaConsultableDTO persona : personas) {
            modelo.addRow(new Object[]{persona.getNombre(), persona.getApellidopaterno(), persona.getApellidoMaterno(), persona.getRfc(),persona.getNacimiento(),persona.getDiscapacitado(),persona.getTelefono()});
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabPersonas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido Paterno", "Apellido Materno", "Rfc", "Fecha de Nacimiento", "Discapacidad", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabPersonas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabPersonas;
    // End of variables declaration//GEN-END:variables
}
