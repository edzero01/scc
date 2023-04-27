package mx.isban.scc.service;

import java.io.IOException;
import java.util.List;

import mx.isban.scc.model.dto.ReportesDTO;
import mx.isban.scc.model.dto.SccMxMaeSimuladorDroDTO;

/**
 * 
 * Interfaz que define los reportes 
 * que se realizaran para la obtencion 
 * de los distintos tipos de plantillas
 * @author Carlos RB
 *
 */
public interface ISimuladorReportesService  {
	
	/**
	 * Obtiene el catalogo de reportes 2019 Sprint 3.2
	 * 
	 * @author GlobalHitss
	 * @param sccMxMaeSimuladorDroDTO
	 * Dto auxiliar 
	 * @return lista de reportes
	 */
	List<ReportesDTO> consultaReporte(SccMxMaeSimuladorDroDTO sccMxMaeSimuladorDroDTO);

	/**
	 * Obtiene el CSV
	 * 
	 * @author GlobalHitss
	 * @param ltsReportes
	 * lista de dto de reportes
	 * @return lista de reportes
	 * @throws IOException Error
	 */
	byte[] obtieneCSV(List<ReportesDTO> ltsReportes) throws IOException;

}
