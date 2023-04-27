package mx.isban.scc.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import mx.isban.scc.dao.ISccMxMaeCondFinanDAO;
import mx.isban.scc.model.SccMxMaeCondFinan;
import mx.isban.scc.model.dto.SccMxMaeCondFinanDTO;

/**
 * Implementacion de las busquedas 
 * de los catalogos para el servicio de
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
public class CondFinService implements ICondFinService {
	/**
	 * Dao para acceder a condiciones financieras
	 */
	@Autowired
	private ISccMxMaeCondFinanDAO daoCondFin;
	
	
	/**
	 * Busca id sub producto Mayo 2019 Sprint 1
	 * 
	 * @author GlobalHitss
	 * @param id 
	 * identificador _nico del sub producto
	 * @return List(SccMxMaeCondFinanDTO) lista de condiciones financieras
	 */
	@Cacheable(cacheNames= "CondFinBySubProd")
	public List<SccMxMaeCondFinanDTO> buscaCondicionPorIdSubProd(Long id) {

		LinkedHashMap<Double, SccMxMaeCondFinanDTO> hmTmpA = new LinkedHashMap<>();
		List<SccMxMaeCondFinan> ltCondFinanA = daoCondFin.buscaCondicionPorIdSubProd(id);
		for (SccMxMaeCondFinan voA : ltCondFinanA) {
			Double llave = voA.getPorTasaIntBase();
			SccMxMaeCondFinanDTO dtoA = hmTmpA.get(llave);
			if (dtoA == null) {
				dtoA = new SccMxMaeCondFinanDTO();
			}

			dtoA.setPorTasaIntBase(llave);
			dtoA.addPlazo(voA.getNumPlazo());
			dtoA.setIdSubProdPk(voA.getIdSubProdFk());
			dtoA.setPorComApertura(voA.getPorComApertura());
			dtoA.setPorComDisposicion(voA.getPorComDisposicion());
			dtoA.setNumAnualidad(voA.getNumAnualidad());
			dtoA.setPorFactorSeg(voA.getPorFactorSeg());
			dtoA.setPorFactorIvaSeg(voA.getPorFactorIvaSeg());
			dtoA.setPorFactorIva(voA.getPorFactorIva());
			dtoA.setPorFacMontoTotal(voA.getPorFacMontoTotal());
			dtoA.setPorFacPagoMensual(voA.getPorFacPagoMensual());
			dtoA.setImpLimInfMBase(voA.getImpLimInfMBase());
			dtoA.setImpLimSupMBase(voA.getImpLimSupMBase());
			dtoA.setNumCostoCaucion(voA.getNumCostoCaucion());
			dtoA.setFlgComAperCashout(voA.getFlgComAperCashout());
			dtoA.setFlgComAperMonto(voA.getFlgComAperMonto());
			dtoA.setFlgComDispCashout(voA.getFlgComDispCashout());
			dtoA.setFlgComDispMonto(voA.getFlgComDispMonto());
			dtoA.addCat(voA.getPorCat());
				
			
			hmTmpA.put(llave, dtoA);
		}

		return new ArrayList<>(hmTmpA.values());
	}


	/**
	 * Para actualizar los factores de confinan cada vez que el usuario
	 * realice un cambio de combobox en tasa, plazo o periodicidad
	 * @param id
	 * id
	 * @param idTasa
	 * tasa
	 * @param idPlazo
	 * plazo
	 * @param idPeriod
	 * periodo
	 * @return List(SccMxMaeCondFinanDTO) lista de condiciones financieras
	 */
	@Override
	@Cacheable(cacheNames= "CondFinByTPP")
	public List<SccMxMaeCondFinanDTO> buscaCondTPP(Long id, Double idTasa, Long idPlazo, Long idPeriod) {
	
		List<SccMxMaeCondFinanDTO> ltConfin = new ArrayList<SccMxMaeCondFinanDTO>();
		List<SccMxMaeCondFinan> ltCondFinan = daoCondFin.buscaCondTPP(id, idTasa, idPlazo, idPeriod);
		for (SccMxMaeCondFinan vo : ltCondFinan) {
			Double llave = vo.getPorTasaIntBase();
			SccMxMaeCondFinanDTO dto = new SccMxMaeCondFinanDTO();

			dto.setPorComApertura(vo.getPorComApertura());
			dto.setPorTasaIntBase(llave);
			dto.setFlgComDispCashout(vo.getFlgComDispCashout());
			dto.addPlazo(vo.getNumPlazo());
			dto.setIdSubProdPk(vo.getIdSubProdFk());
			dto.setNumAnualidad(vo.getNumAnualidad());
			dto.setPorFactorSeg(vo.getPorFactorSeg());
			dto.setPorFactorIvaSeg(vo.getPorFactorIvaSeg());
			dto.setPorFactorIva(vo.getPorFactorIva());
			dto.setPorFacMontoTotal(vo.getPorFacMontoTotal());
			dto.setPorFacPagoMensual(vo.getPorFacPagoMensual());
			dto.setNumCostoCaucion(vo.getNumCostoCaucion());
			dto.setFlgComAperCashout(vo.getFlgComAperCashout());
			dto.setFlgComAperMonto(vo.getFlgComAperMonto());
			dto.setPorComDisposicion(vo.getPorComDisposicion());
			dto.setImpLimInfMBase(vo.getImpLimInfMBase());
			dto.setImpLimSupMBase(vo.getImpLimSupMBase());
			dto.setFlgComDispMonto(vo.getFlgComDispMonto());
			dto.addCat(vo.getPorCat());
			ltConfin.add(dto);
		}

		return ltConfin;
	}
	
	/**
	 * Para actualizar los factores de confinan cada vez que el usuario
	 * realice un cambio de combobox en tasa, plazo o periodicidad
	 * @param idProdPk
	 * id
	 * @param idTasa
	 * tasa
	 * @param idPlazo
	 * plazo
	 * @param idPeriod
	 * periodo
	 * @return List(SccMxMaeCondFinanDTO)
	 * lista de condiciones financieras
	 */
	@Override
	@Cacheable(cacheNames= "CondFinByTPPOfMax")
	public List<SccMxMaeCondFinanDTO> buscaCondTPPOfMax(Long idProdPk, Double idTasa, Long idPlazo, Long idPeriod) {
		return daoCondFin.buscaCondTPPOfMax(idProdPk, idTasa, idPlazo, idPeriod);
	}

		
}
