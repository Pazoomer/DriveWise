/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import com.itextpdf.text.pdf.PdfWriter;
import daos.conexion.IConexionDAO;
import dtos.persona.PersonaConsultableDTO;
import dtos.tramite.TramiteConsultableDTO;
import excepciones.PersistenciaException;
import excepciones.ValidacionException;
import java.awt.Graphics2D;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.text.DocumentException;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import negocio.licencia.RegistroLicenciasBO;
import negocio.tramite.ConsultarTramitesBO;
import negocio.tramite.IConsultarTramitesBO;

/**
 *
 * @author Enrique Rodriguez
 */
public class DlgReporte extends javax.swing.JFrame {

    IConexionDAO conexion;
    PersonaConsultableDTO persona;
    private int filtro;
    Calendar fechaDesde;
    Calendar fechaHasta;

    public DlgReporte(IConexionDAO conexion, PersonaConsultableDTO persona, int filtro, Calendar fechaDesde, Calendar fechaHasta) {
        initComponents();
        this.conexion = conexion;
        this.persona = persona;
        this.filtro = filtro;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        llenarTabla();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTramites = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblTramites.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblTramites);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("REPORTE DE TRAMITES REALIZADOS");

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 102, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Exportar PDF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(203, 203, 203))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 57, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    private void llenarTabla() {
        IConsultarTramitesBO consultarTramitesBO = new ConsultarTramitesBO(conexion);
        List<TramiteConsultableDTO> tramites = new LinkedList<>();
        try {
            //Buscar persona
            RegistroLicenciasBO buscar = new RegistroLicenciasBO(conexion);
            PersonaConsultableDTO personaux = buscar.buscarPersonaRfc(persona);

            //Buscar tramites de la persona
            tramites = consultarTramitesBO.consultarTramitePorPersona(persona);

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Nombre");
            modelo.addColumn("Trámite");
            modelo.addColumn("Fecha Emisión");
            modelo.addColumn("Costo");

            for (TramiteConsultableDTO tramite : tramites) {
                int mes = tramite.getEmision().get(Calendar.MONTH) +1;
                Object[] fila = {
                    personaux.getNombre() + " "
                    + personaux.getApellidopaterno() + " "
                    + personaux.getApellidoMaterno(),
                    tramite.getTipo(),
                    tramite.getEmision().get(Calendar.DATE) + "/0"
                    + mes + "/"
                    + tramite.getEmision().get(Calendar.YEAR),
                     "$" + tramite.getCosto() + "0"
                };

                Calendar fechaTramite = Calendar.getInstance();
                fechaTramite.set(tramite.getEmision().get(Calendar.YEAR),
                        tramite.getEmision().get(Calendar.MONTH),
                        tramite.getEmision().get(Calendar.DATE), 0, 0);
               
                if ((fechaTramite.after(fechaDesde) || fechaTramite.equals(fechaDesde))
                        && (fechaTramite.before(fechaHasta) || fechaTramite.equals(fechaHasta))) {

                    if (filtro == 1 && tramite.getTipo().equalsIgnoreCase("LICENCIA")) {
                        modelo.addRow(fila);

                    } else if (filtro == 2 && tramite.getTipo().equalsIgnoreCase("PLACA")) {
                        modelo.addRow(fila);

                    } else if (filtro == 0) {
                        modelo.addRow(fila);

                    }
                }
            }
            tblTramites.setModel(modelo);
            TableColumnModel columnModel = tblTramites.getColumnModel();

        } catch (PersistenciaException ex) {
            Logger.getLogger(DlgReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ValidacionException ex) {
            Logger.getLogger(DlgReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void convertirJFrameAPDF(JFrame frame, String rutaArchivoPDF) throws IOException {
        // Capturar la imagen del JFrame
        BufferedImage imagen = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = imagen.createGraphics();
        frame.paint(graphics2D);
        graphics2D.dispose();

        try {
            PdfWriter writer = PdfWriter.getInstance(new com.itextpdf.text.Document(), new FileOutputStream("ReportePDF"));
        } catch (DocumentException ex) {
            Logger.getLogger(DlgReporte.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Convertir la imagen a un objeto iText Image y agregarla al documento PDF
        //com.itextpdf.layout.element.Image imagenPDF = new com.itextpdf.layout.element.Image(ImageDataFactory.create(imagen, null));
        //pdf.add(imagenPDF);

        // Cerrar el documento
        //pdf.close();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTramites;
    // End of variables declaration//GEN-END:variables
}
