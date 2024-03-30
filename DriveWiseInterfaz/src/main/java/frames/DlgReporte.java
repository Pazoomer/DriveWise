
package frames;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import daos.conexion.IConexionDAO;
import dtos.persona.PersonaConsultableDTO;
import dtos.tramite.TramiteConsultableDTO;
import excepciones.PersistenciaException;
import excepciones.ValidacionException;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import negocio.licencia.RegistroLicenciasBO;
import negocio.tramite.ConsultarTramitesBO;
import negocio.tramite.IConsultarTramitesBO;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import java.text.SimpleDateFormat;
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
    
    /**
     * Constructor de la clase DlgReporte que inicializa los atributos de la clase
     * a los establecidos en los parametros.
     * 
     * @param conexion conexion
     * @param persona persona
     * @param filtro filtro
     * @param fechaDesde fechaDesde
     * @param fechaHasta fechaHasta
     */
    public DlgReporte(IConexionDAO conexion, PersonaConsultableDTO persona, int filtro, Calendar fechaDesde, Calendar fechaHasta) {
        initComponents();
        this.conexion = conexion;
        this.persona = persona;
        this.filtro = filtro;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        obtenerFechaYFormato();
        establecerNombre();
        llenarTabla();
    }
    
    /**
     * Método para establecer la fecha en el dlg actual.
     */
    private void obtenerFechaYFormato() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = formatoFecha.format(calendar.getTime());
        this.lblFecha.setText(fechaFormateada);
    }
    
    /**
     * Método para establecer el nombre de la persona quien posee los tramites
     * mostrados.
     */
    private void establecerNombre(){
        RegistroLicenciasBO buscar = new RegistroLicenciasBO(conexion);
        try {
            PersonaConsultableDTO personaux = buscar.buscarPersonaRfc(persona);
            this.lblNombre.setText("Visualizando tramites de: " + personaux.getNombre() + " " + personaux.getApellidopaterno() + " " + personaux.getApellidoMaterno());
        } catch (PersistenciaException ex) {
            Logger.getLogger(DlgReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ValidacionException ex) {
            Logger.getLogger(DlgReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    /**
     * Método para convertir a pdf.
     */
    private void convertir() {
        try {
            String rutaArchivoPDF = obtenerRutaDescargas() + File.separator + "informe.pdf";
            exportarPDF(rutaArchivoPDF);
            abrirPDF(rutaArchivoPDF);
            JOptionPane.showMessageDialog(this, "Se agrego a descargas el pdf", "PDF Exportado", JOptionPane.INFORMATION_MESSAGE);
            return;
        } catch (IOException | DocumentException ex) {
            ex.printStackTrace();
        }
    }                                        

    
    /**
     * Método para acceder a la ruta de descargas del usuario.
     * @return 
     */
    public static String obtenerRutaDescargas() {
        String rutaDescargas = System.getProperty("user.home") + File.separator + "Downloads";
        return rutaDescargas;
    }
    
    public void abrirPDF(String rutaArchivoPDF) {
        try {
            File archivoPDF = new File(rutaArchivoPDF);
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(archivoPDF);
            } else {
                System.out.println("El sistema no soporta la apertura automática de archivos.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Método para exportar un pdf.
     * @param rutaArchivoPDF
     * @throws IOException
     * @throws DocumentException 
     */
    public void exportarPDF(String rutaArchivoPDF) throws IOException, DocumentException {
        // Crear un documento PDF
        Document documento = new Document();
        PdfWriter escritor = null;
        try {
            escritor = PdfWriter.getInstance(documento, new FileOutputStream(rutaArchivoPDF));

            // Añadir un evento de página para manejar el número de página
            escritor.setPageEvent(new NumeracionPaginas());

            // Abrir el documento
            documento.open();

            // Agregar lblFecha en la esquina izquierda
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            String fechaFormateada = formatoFecha.format(calendar.getTime());
            Font fontFecha = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
            Paragraph parrafoFecha = new Paragraph(fechaFormateada, fontFecha);
            parrafoFecha.setAlignment(Element.ALIGN_LEFT);
            documento.add(parrafoFecha);

            // Agregar título
            Font fontTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24, BaseColor.BLACK);
            Paragraph titulo = new Paragraph("REPORTE DE TRÁMITES REALIZADOS", fontTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);
            
            // Agregar un espacio en blanco para separación
            Paragraph espacioEnBlanco = new Paragraph("\n");
            documento.add(espacioEnBlanco);

            // Agregar tabla
            PdfPTable tabla = new PdfPTable(4); // 4 columnas
            tabla.setWidthPercentage(100);
            PdfPCell celda;

            // Agregar encabezados de columna
            String[] encabezados = {"Nombre", "Trámite", "Fecha Emisión", "Costo"};
            for (String encabezado : encabezados) {
                celda = new PdfPCell(new Phrase(encabezado));
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla.addCell(celda);
            }

            // Agregar contenido de la tabla
            for (int i = 0; i < tblTramites.getRowCount(); i++) {
                for (int j = 0; j < tblTramites.getColumnCount(); j++) {
                    celda = new PdfPCell(new Phrase(tblTramites.getModel().getValueAt(i, j).toString()));
                    celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla.addCell(celda);
                }
            }

            documento.add(tabla);

        } finally {
            if (documento != null) {
                // Cerrar el documento
                documento.close();
            }
            if (escritor != null) {
                // Cerrar el escritor PDF
                escritor.close();

            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTramites = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnPdf = new javax.swing.JButton();
        lblFecha = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();

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

        btnPdf.setBackground(new java.awt.Color(255, 102, 51));
        btnPdf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPdf.setForeground(new java.awt.Color(255, 255, 255));
        btnPdf.setText("Exportar PDF");
        btnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfActionPerformed(evt);
            }
        });

        lblFecha.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lblFecha.setText("Calendario");

        lblNombre.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lblNombre.setText("Calendario");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139)
                        .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 57, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFecha, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1))
                .addGap(21, 21, 21)
                .addComponent(lblNombre)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
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

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
        convertir();
        
    }//GEN-LAST:event_btnPdfActionPerformed
    /**
     * Método para llenar la tabla a partir de los tramites que tenga una persona.
     */
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
            tblTramites.setEnabled(false);

        } catch (PersistenciaException ex) {
            Logger.getLogger(DlgReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ValidacionException ex) {
            Logger.getLogger(DlgReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPdf;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tblTramites;
    // End of variables declaration//GEN-END:variables

// Clase interna para manejar el evento de página y agregar el número de página
    class NumeracionPaginas extends PdfPageEventHelper {
        // Método llamado cuando se inicia una nueva página
        @Override
        public void onStartPage(PdfWriter escritor, Document documento) {
            // Obtener el número de página actual
            int numeroPagina = escritor.getPageNumber();

            // Crear un pie de página con el número de página
            PdfPTable piePagina = new PdfPTable(1);
            piePagina.setWidthPercentage(100);
            PdfPCell celda = new PdfPCell(new Phrase(String.format("Página %d", numeroPagina)));
            celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
            celda.setBorder(Rectangle.NO_BORDER);
            piePagina.addCell(celda);

            try {
                // Agregar el pie de página al documento
                documento.add(piePagina);
            } catch (DocumentException ex) {
                ex.printStackTrace();
            }
        }
    }
}
