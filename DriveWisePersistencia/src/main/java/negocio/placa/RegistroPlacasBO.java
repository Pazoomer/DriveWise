/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.placa;

import daos.conexion.IConexionDAO;
import daos.persona.IPersonasDAO;
import daos.persona.PersonasDAO;
import dtos.persona.PersonaConsultableDTO;
import dtos.placa.PlacaConsultableDTO;
import dtos.vehiculo.VehiculoConsultableDTO;
import excepciones.PersistenciaException;
import java.util.logging.Logger;
import mapas.personas.Persona;
import mapas.tramites.Placa;
import mapas.vehiculos.Vehiculo;

/**
 *
 * @author JoseH
 */
public class RegistroPlacasBO {
    
    private final IConexionDAO conexion;
    private static final Logger LOG = Logger.getLogger(PersonasDAO.class.getName());

    public RegistroPlacasBO(IConexionDAO conexion) {
        this.conexion = conexion;
    }
    
    public Vehiculo buscarVehiculo(PersonaConsultableDTO personaDTO, PlacaConsultableDTO placaDTO) throws PersistenciaException {
        IPersonasDAO personasDAO = new PersonasDAO(conexion);

        Persona persona = new Persona(personaDTO.getRfc());
        Persona personaEncontrada = personasDAO.consultarPersonaPorRfc(persona);
        
        
        Placa placa = new Placa(placaDTO.getAlfanumerico());
        
        
    }
    
    public void registrarPlaca(VehiculoConsultableDTO vehiculoDTO){
        
    }
    
    
}
