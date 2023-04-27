package mx.isban.scc.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.isban.scc.dao.ISccMxPrcOfMaxPlazosDAO;
import mx.isban.scc.dao.ISccMxPrcOfMaxTasaDAO;
import mx.isban.scc.exception.ObjectNotFoundException;
import mx.isban.scc.model.SccMxPrcOferMaxPlzo;
import mx.isban.scc.model.SccMxPrcOferMaxTasa;
import mx.isban.scc.model.dto.SccMxTablaOfMaxDTO;

/**
 * Implementacion de la interfaz para el servicio que trae la informacion de la
 * tabla de ofertas maximas
 * 
 * Global Hitss Mayo 2019 Sprint 2
 * 
 * @author baruchlw
 *
 */
@Service
public class TblOfMaxService implements ITblOfMaxService {

	/**
	 * clase Logger
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(TblOfMaxService.class);
	
	/*
	 * DAO (Data Access Object) de tasas máximas
	 */
	@Autowired
	private ISccMxPrcOfMaxTasaDAO daoOfMaxTasa;

	/*
	 * DAO (Data Access Object) de plazos máximos
	 */
	@Autowired
	private ISccMxPrcOfMaxPlazosDAO daoOfMaxPlazos;

	/**
	 * Obtiene la tasa de acuerdo a la oferta indicada retorna la lista de tasas
	 * 
	 * @param idOf Id de la tasa
	 * @return List(SccMxPrcOferMaxTasa) Lista de tasas máximas para la oferta
	 */
	@Override
	public List<SccMxPrcOferMaxTasa> getTasaporOferta(long idOf) {

		List<SccMxPrcOferMaxTasa> lTasasOfMax = new ArrayList<>();

		try {
			lTasasOfMax = daoOfMaxTasa.buscaTasas(idOf);
		} catch (ObjectNotFoundException e) {
			LOGGER.error(e.getMessage(), e);
			return lTasasOfMax;
		}

		return lTasasOfMax;
	}

	/**
	 * Obtiene la lista de plazo por tasa
	 * 
	 * @param idTasa Id de la tasa
	 * @return List(SccMxPrcOferMaxPlzo) Lista de plazos retorna la lista de plazos
	 */
	@Override
	public List<SccMxPrcOferMaxPlzo> getPlazosporTasa(long idTasa) {

		List<SccMxPrcOferMaxPlzo> lPlazosOfMax = new ArrayList<>();

		try {
			lPlazosOfMax = daoOfMaxPlazos.buscaPlazos(idTasa);
		} catch (ObjectNotFoundException e) {
			LOGGER.error(e.getMessage(), e);
			return lPlazosOfMax;
		}

		return lPlazosOfMax;
	}

	/**
	 * Se trae la tabla de ofertas maximas completa 
	 * con el id de la tasa y de la campaña
	 * 
	 * @param idTasa  Long Id de la tasa
	 * @param idOfCam Long Id de la oferta de campaña
	 * @return List(SccMxTablaOfMaxDTO) Lista de tablas de oferta máxima
	 */
	@Override
	public List<SccMxTablaOfMaxDTO> getTablaOfMax(long idTasa, long idOfCam) {

		List<SccMxTablaOfMaxDTO> lTablaOfMax = new ArrayList<>();

		try {
			lTablaOfMax = daoOfMaxPlazos.getTablaOfMax(idTasa, idOfCam);
		} catch (ObjectNotFoundException e) {
			LOGGER.error(e.getMessage(), e);
			return lTablaOfMax;
		}

		return lTablaOfMax;
	}

}
