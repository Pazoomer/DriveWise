
package frames;

import calendario.JGoodDatePicker;
import daos.conexion.IConexionDAO;
import dtos.persona.PersonaConsultableDTO;
import excepciones.PersistenciaException;
import excepciones.ValidacionException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import negocio.consulta.ConsultarHistorialBO;
import negocio.consulta.IConsultarHistorialBO;

/**
 *
 * @author t1pas
 */
public class FrmModuloConsultas extends javax.swing.JFrame {

    IConexionDAO conexion;
    String titulo;

    /**
     * Creates new form FrmModuloConsultas
     *
     * @param conexion
     */
    public FrmModuloConsultas(IConexionDAO conexion) {
        this.setResizable(false);
        initComponents();
        this.conexion = conexion;
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
     * Busca y despliega una lista de personas con los parametros ingresado
     */
    private void buscar() {
        String campo = this.txfCentral.getText();

        PersonaConsultableDTO personaConsultable = new PersonaConsultableDTO();

        if (this.btnRfc.isSelected()) {
            personaConsultable.setRfc(campo);
            titulo=" RFC: ";
        } else if (this.btnNombre.isSelected()) {
            personaConsultable.setNombre(campo);
            titulo=" Nombre: ";
        } else if (this.btnNacimiento.isSelected()) {
            // Realizar la conversión de String a Date
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaNacimiento = dateFormat.parse(campo);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(fechaNacimiento);
                personaConsultable.setNacimiento(calendar);
            } catch (java.text.ParseException e) {
                JOptionPane.showMessageDialog(this, "La fecha ingresada no es valida", "Error en el campo de texto", JOptionPane.ERROR_MESSAGE);
                return;
            }
            titulo=" Año de nacimiento: ";
        }

        List<PersonaConsultableDTO> personas;
        IConsultarHistorialBO consultarHistorial = new ConsultarHistorialBO(conexion);
        try {
            personas=consultarHistorial.consultarPersonaPorFiltros(personaConsultable);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo conectar con la base de datos", "Error en la ejecucion", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (ValidacionException ex) {
            JOptionPane.showMessageDialog(this, "No hay resultados para la busqueda", "No hay resultados", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        titulo=titulo.concat(campo);
        abrirResultados(personas);
    }
    
    /**
     * Abre un nuevo frame y cierra este, este nuevo frame contendrá una tabla
     * con las personas coincidentes.
     * @param personas lista de personas coincidentes
     */
    private void abrirResultados(List<PersonaConsultableDTO> personas) {
        FrmModuloConsultasResultados on = new FrmModuloConsultasResultados(conexion, personas,titulo);
        on.setVisible(true);
        this.dispose();
    }

    /**
     * Abre un JGoodCalendar para que el usuario selecciona la fecha
     */
    private void abrirCalendario() {
        JGoodDatePicker calendario = new JGoodDatePicker(this, true);
        calendario.setVisible(true);

        if (calendario.confirmar == true) {

            if (calendario.devolverFecha() != null) {

                // Crear un objeto SimpleDateFormat para el formato deseado
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                // Formatear la fecha utilizando SimpleDateFormat
                String fechaFormateada = sdf.format(calendario.devolverFecha().getTime());

                this.txfCentral.setText(fechaFormateada);
            }
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogo = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        btnBuscar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        pnlCentral = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        txfCentral = new javax.swing.JTextField();
        lblFiltroEstatico = new javax.swing.JLabel();
        btnCalendario = new javax.swing.JButton();
        btnNacimiento = new javax.swing.JToggleButton();
        btnNombre = new javax.swing.JToggleButton();
        btnRfc = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        btnBuscar.setBackground(new java.awt.Color(255, 51, 51));
        btnBuscar.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnVolver.setBackground(new java.awt.Color(153, 51, 0));
        btnVolver.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
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
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnlCentral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTitulo.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(204, 102, 0));
        lblTitulo.setText("Consulta de historial");

        lblFiltroEstatico.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        lblFiltroEstatico.setForeground(new java.awt.Color(204, 0, 0));
        lblFiltroEstatico.setText("Filtros");

        btnCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalendarioActionPerformed(evt);
            }
        });

        btnNacimiento.setBackground(new java.awt.Color(204, 102, 0));
        btnNacimiento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNacimiento.setForeground(new java.awt.Color(255, 255, 255));
        btnNacimiento.setText("Año de nacimiento");
        btnNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNacimientoActionPerformed(evt);
            }
        });

        btnNombre.setBackground(new java.awt.Color(255, 102, 0));
        btnNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNombre.setForeground(new java.awt.Color(255, 255, 255));
        btnNombre.setText("Nombre");
        btnNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNombreActionPerformed(evt);
            }
        });

        btnRfc.setBackground(new java.awt.Color(255, 0, 0));
        btnRfc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRfc.setForeground(new java.awt.Color(255, 255, 255));
        btnRfc.setText("RFC");
        btnRfc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRfcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCentralLayout = new javax.swing.GroupLayout(pnlCentral);
        pnlCentral.setLayout(pnlCentralLayout);
        pnlCentralLayout.setHorizontalGroup(
            pnlCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCentralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(194, 194, 194))
            .addGroup(pnlCentralLayout.createSequentialGroup()
                .addGroup(pnlCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCentralLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnNacimiento))
                    .addGroup(pnlCentralLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(txfCentral, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCentralLayout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(lblFiltroEstatico)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        pnlCentralLayout.setVerticalGroup(
            pnlCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentralLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblTitulo)
                .addGap(48, 48, 48)
                .addGroup(pnlCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCalendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txfCentral, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFiltroEstatico)
                .addGap(18, 18, 18)
                .addGroup(pnlCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(lblLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        volver();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalendarioActionPerformed
      abrirCalendario();
    }//GEN-LAST:event_btnCalendarioActionPerformed

    private void btnRfcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRfcActionPerformed
        this.btnNacimiento.setSelected(false);
        this.btnNombre.setSelected(false);
    }//GEN-LAST:event_btnRfcActionPerformed

    private void btnNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNombreActionPerformed
        this.btnNacimiento.setSelected(false);
        this.btnRfc.setSelected(false);
    }//GEN-LAST:event_btnNombreActionPerformed

    private void btnNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNacimientoActionPerformed
        this.btnRfc.setSelected(false);
        this.btnNombre.setSelected(false);
    }//GEN-LAST:event_btnNacimientoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCalendario;
    private javax.swing.JToggleButton btnNacimiento;
    private javax.swing.JToggleButton btnNombre;
    private javax.swing.JToggleButton btnRfc;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFiltroEstatico;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlCentral;
    private javax.swing.JSeparator separador;
    private javax.swing.JTextField txfCentral;
    // End of variables declaration//GEN-END:variables
}
