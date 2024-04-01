/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio.placa;

import dtos.placa.PlacaConsultableDTO;
import dtos.vehiculo.VehiculoConsultableDTO;
import excepciones.PersistenciaException;

/**
 *
 * @author JoseH
 */
public interface IConsultaVehiculoBO {
    /**
     * Busca un vehiculo que tenga la placa recibida en el parámetro.
     * @param placaDTO Placa
     * @return Vehículo coincidente con la placa o null si no se encuentra ningún vehículo
     * @throws PersistenciaException 
     */
    public VehiculoConsultableDTO consultarVehiculoPlaca(PlacaConsultableDTO placaDTO) throws PersistenciaException;
    
    /**
     * Se bBusca el vehículo basándose en los criterios especificados en el
     * objeto VehiculoConsultableDTO y devuelve su información completa.
     *
     * @param vehiculoDTO Objeto que contiene los criterios de búsqueda del
     * vehículo.
     * @return VehiculoConsultableDTO con la información completa del vehículo
     * encontrado, o null si no se encuentra un vehículo que coincida con los
     * criterios.
     * @throws PersistenciaException Si hay un problema de conexión con la base
     * de datos, o si la consulta SQL falla por algún motivo.
     */
    public VehiculoConsultableDTO consultarVehiculo(VehiculoConsultableDTO vehiculoDTO) throws PersistenciaException;
}
