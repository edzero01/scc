package mx.isban.scc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import mx.isban.scc.dao.ISccMxMaeTasaTiieDAO;

/**
 * Se crea interfaz para la consulta de tasa tiie
 * para consumirse como servicio
 * desde el controler correspondiente
 * @author Ivan Cruz Azuara
 *
 */
@Service
public class TasaTiieService implements ITasaTiieService {

	/**
	 * Dao para ocupar la info de Conversion Auto
	 * 
	 */
	@Autowired
	private ISccMxMaeTasaTiieDAO daoTasaTiie;
	
	/**
	 * Junio 2019 Sprint 2 
	 * Metodo para consultar la ultima tasa tiie
	 * @author GlobalHitss
	 * @return tasa tiie
	 */
	@Override
	@Cacheable(cacheNames= "TasaTIIE")
	public Double obtenTasaTiie() {
		return daoTasaTiie.buscaUltimaTasaTIIE();
	}

}
