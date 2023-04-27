package mx.isban.scc.service;

import mx.isban.scc.model.SccMxMaeSimuladorDroJpa;

/**
 * Interfaz para guardar simulaciones
 * 
 * @author Hitss
 * 
 *         Julio 2019 Sprint 3
 */
public interface ISimulacionService {

	/**
	 * Guarda las simulaciones del sistema
	 * 
	 * @param sccMxMaeSimuladorDro objeto para guardar en la tabla
	 * @param idSessionHttp        La sesión HTTP inyectada por Spring para la
	 *                             obtención del id de sesión que se guardará en
	 *                             pistas de auditoría
	 * @param remoteIPaddress      la dirección ip remote el cliente que invocó o el
	 *                             último gatewayt por el que pasó ls solicitud
	 * @param remoteHostName       el nombre completo del host remoto o el nombre dl
	 *                             último gateway por el que pasó la solicitud y si
	 *                             la maquina virtual no puede o decide no resolver
	 *                             el nombre por cuestiones de performance, se
	 *                             recibirá la dirección IP
	 * @return true si es guarda exitosamente, false de otra forma
	 */
	SccMxMaeSimuladorDroJpa save(SccMxMaeSimuladorDroJpa sccMxMaeSimuladorDro, String idSessionHttp,
			String remoteIPaddress, String remoteHostName);

}
