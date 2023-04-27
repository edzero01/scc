package mx.isban.scc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.isban.scc.model.SccMxMaeSimuladorDroJpa;
import mx.isban.scc.model.dto.AuditoriaDTO;
import mx.isban.scc.repository.ISccMxMaeSimuladorDroRepository;
import mx.isban.scc.utilerias.PistasAuditoriaHelper;

/**
 * Implementacion de la interfaz que consulta los creditos del cliente en la
 * tabla de cartera
 * 
 * @author Hitss
 * 
 *         Julio 2019
 * 
 *         Sprint 3
 * 
 *
 */
@Service
public class SimulacionService implements ISimulacionService {

	@Autowired
	private ISccMxMaeSimuladorDroRepository repository;

	/**
	 * Variable para acceder a las pistas de auditoría
	 */
	@Autowired
	private PistasAuditoriaHelper auditoria;

	/**
	 * Guarda las simulaciones del sistema
	 * 
	 * @param sccMxMaeSimuladorDro objeto para guardar en la tabla
	 * @param idSessionHttp        La sesión HTTP inyectada por Spring para la
	 *                             obtención del id de sesión que se guardará en
	 *                             pistas de auditoría
	 * @return sccMxMaeSimuladorDro si se guarda exitosamente, null de otra forma
	 */
	@Override
	public SccMxMaeSimuladorDroJpa save(SccMxMaeSimuladorDroJpa sccMxMaeSimuladorDro, String idSessionHttp,
			String remoteIPaddress, String remoteHostName) {
		SccMxMaeSimuladorDroJpa saved = repository.save(sccMxMaeSimuladorDro);

		auditoria.guardaPista(getAuditoriaDto(idSessionHttp, remoteIPaddress, remoteHostName));
		return saved;
	}

	/**
	 * Obtiene el dto para guardar la pista de auditoría en el servicio de auditoria
	 * 
	 * @param idSessionHttp La sesión HTTP inyectada por Spring para la obtención
	 *                      del id de sesión que se guardará en pistas de auditoría
	 * @param remoteIPaddress      la dirección ip remote el cliente que invocó o el
	 *                             último gatewayt por el que pasó ls solicitud
	 * @param remoteHostName       el nombre completo del host remoto o el nombre dl
	 *                             último gateway por el que pasó la solicitud y si
	 *                             la maquina virtual no puede o decide no resolver
	 *                             el nombre por cuestiones de performance, se
	 *                             recibirá la dirección IP                     
	 * @return AuditoriaDTO con la información para guardar la pista de auditoría
	 */
	private AuditoriaDTO getAuditoriaDto(String idSessionHttp, String remoteIPaddress, String remoteHostName) {
		AuditoriaDTO auditoriaDto = new AuditoriaDTO();
		auditoriaDto.setAplicacion("Simulador");
		auditoriaDto.setMotivo("Guardado de simulación");
		auditoriaDto.setOperacion("Create");
		auditoriaDto.setHostName(remoteHostName);
		auditoriaDto.setIpTermninal(remoteIPaddress);
		/*
		 * La sesion http
		 */
		auditoriaDto.setSession(idSessionHttp);
		auditoriaDto.setTblAfectada("SCC_MX_MAE_SIMULADOR_DRO");
		/*
		 * Se debe obtener el token por la sesion
		 */
		auditoriaDto.setToken("N/A");
		/*
		 * Se debe obtener el token por la sesion s
		 */
		auditoriaDto.setUsr("SCC");
		/*
		 * //1=Aplicación , 2= Batch
		 */
		auditoriaDto.setIdTipoProceso(1L);

		return auditoriaDto;
	}

}
