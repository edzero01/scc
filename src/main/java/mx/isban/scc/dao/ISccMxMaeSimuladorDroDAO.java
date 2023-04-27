package mx.isban.scc.dao;

import java.util.List;

import mx.isban.scc.model.SccMxMaeSimuladorDro;
import mx.isban.scc.model.dto.SccMxMaeSimuladorDroDTO;


/**
 * Interfaz del DAO para metodos de consulta de registros 
 * guardados del historico de simulaciones realizadas
 * en el sistema de Santander Simulador 
 * @author Hitss
 *
 */
public interface ISccMxMaeSimuladorDroDAO extends IAbstractDAO<SccMxMaeSimuladorDro>{ 
	
	
	/**
	 *Metodo para consulta historico de simulaciones
	 *mediante interfaz grafica
	 *donde obtenemos un DTO intermediario con la lista de datos
	 *para filtrar la informacion
	 * @param sccMxMaeSimuladorDroDTO
	 * parametro con el DTO de datos de consulta de historico de simulaciones
	 * @return Lista de Entidades de la tabla SccMXMaeSimuladorDro
	 */
	List<SccMxMaeSimuladorDro> consultaSimuladorDro(SccMxMaeSimuladorDroDTO sccMxMaeSimuladorDroDTO); 
	
}
