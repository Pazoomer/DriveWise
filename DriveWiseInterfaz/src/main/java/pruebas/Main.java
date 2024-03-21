/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import daos.conexion.ConexionDAO;
import daos.conexion.IConexionDAO;
import daos.licencia.ILicenciasDAO;
import daos.licencia.LicenciasDAO;
import daos.persona.IPersonasDAO;
import daos.persona.PersonasDAO;

/**
 *
 * @author Enrique Rodriguez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IConexionDAO conexion=new ConexionDAO();
        IPersonasDAO personasDAO=new PersonasDAO(conexion);
        ILicenciasDAO licenciasDAO=new LicenciasDAO(conexion);
    }
    
}
