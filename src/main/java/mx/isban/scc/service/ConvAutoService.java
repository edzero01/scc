package mx.isban.scc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import mx.isban.scc.dao.ISccMxMaeConvAutoDAO;
import mx.isban.scc.model.SccMxMaeConvauto;
import mx.isban.scc.model.dto.SccMxMaeConvautoDTO;

/**
 * Implementaci_n de las b_squedas 
 * de los cat_logos para el servicio de
 * catalogosRestController 
 * motivos rechazo
 * tipo producto
 * segmento
 * periodicidad
 * subproducto por id prod
 * condiciones financieras
 * conversion auto
 * 
 * Dichas inyecciones de dependencia
 * son unicamente para obtener
 * valores de catalogos para llenado
 * de combos, text box y motivos
 * informativos en front end
 * Mayo 2019 
 * Sprint 1
 * Fabrica de software
 * Proyecto Simulador Credito al Consumo
 * Santander
 * @author GlobalHitss

 *
 */

@Service
public class ConvAutoService implements IConvAutoService {

	/**
	 * Dao para ocupar la info de Conversion Auto
	 * 
	 */
	@Autowired
	private ISccMxMaeConvAutoDAO daoConvAuto;
	
	

	/**
	 * Método para buscar el valor de la tasa de conversion auto
	 * considerando el valor de la LAPA
	 * @param lapa
	 * Valor de LAPA  a buscar
	 * @return double
	 * valor de tasa para conv auto
	 */
	@Override
	@Cacheable(cacheNames= "ConvAutoByLapa")
	public Double buscaConvAutoPorLapa(Long lapa) {
		return daoConvAuto.buscaTasaPorNumLapa(lapa);
	}
	
	/**
	 * Método para buscar el valor de la tasa de conversion auto
	 * considerando el Id de Segmento
	 * @param id
	 * Valor del ID del Segmento indicado en FrontEnd
	 * @return SccMxMaeConvautoDTO
	 * objeto conv auto
	 * 
	 */
	@Override
	@Cacheable(cacheNames= "CoinvAutoBySegmento")
	public SccMxMaeConvautoDTO buscaConvAutoPorSegmento(Long id) {
		
		SccMxMaeConvautoDTO conversionDTO = new SccMxMaeConvautoDTO();	
		
		SccMxMaeConvauto objConversion = daoConvAuto.buscaTasaPorSegmento(id);	
		if(objConversion!=null) {
			conversionDTO.setIdConvautoPk(objConversion.getIdConvautoPk());
			conversionDTO.setIdSubProdFk(objConversion.getIdSubProdFk());
			conversionDTO.setNumLapa(objConversion.getNumLapa());
			conversionDTO.setPorTasa(objConversion.getPorTasa());
		}
		
		
		return conversionDTO;
	}
	
}
