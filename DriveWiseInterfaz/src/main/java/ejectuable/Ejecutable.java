
package ejectuable;

import daos.conexion.ConexionDAO;
import daos.conexion.IConexionDAO;
import forms.FrmPantallaPrincipal;

/**
 *
 * @author t1pas
 */
public class Ejecutable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IConexionDAO conexion=new ConexionDAO();
        conexion.crearConexion();
        FrmPantallaPrincipal on =new FrmPantallaPrincipal(conexion);
        on.setVisible(true);
    }
    
}
