package mx.isban.scc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import mx.isban.scc.dao.ISccMxMaeOferPromCamDAO;
import mx.isban.scc.dao.ISccMxMaeOferPromMaDAO;
import mx.isban.scc.model.SccMxMaeOferPromCam;
import mx.isban.scc.model.SccMxMaeOferPromMa;
import mx.isban.scc.utilerias.ValidaNull;

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
public class OfertaPromocionalService implements IOfertaPromocionalService {

	/**
	 * Dao para ocupar la info de oferta campania
	 * 
	 */
	@Autowired
	private ISccMxMaeOferPromCamDAO daoOfertaCamp;
	/**
	 * Dao para ocupar la info de oferta ma
	 * 
	 */
	@Autowired
	private ISccMxMaeOferPromMaDAO daoOfertaMA;
	
	/**
	 * Método para buscar el valor de la tasa de oferta promocional
	 * considerando el valor de producto y subproducto
	 * @param idModalidad
	 * Valor ma o camp
	 * @param idSubProd
	 * Valor de subprod
	 * @param buc
	 * buc de cliente
	 * @return String
	 * valor de datos
	 */
	@Override
	@Cacheable(cacheNames= "OfertaPromByModSubProdBuc")
	public String buscaOfertaPromocional(Long idModalidad, String idSubProd, Long buc, Long tipoPerfilSeleccionado)  {
		
		SccMxMaeOferPromCam ofertaCam = new SccMxMaeOferPromCam();
		SccMxMaeOferPromMa oferMA = new SccMxMaeOferPromMa();
		String data = "";
		ValidaNull oValidaNull = new ValidaNull();
		if ( idModalidad == 1 ) {
			List<SccMxMaeOferPromCam> ofertaCamlt = daoOfertaCamp.buscaOferPromCamByBucClte(buc,idSubProd,tipoPerfilSeleccionado);
			if(!ofertaCamlt.isEmpty()) {
				ofertaCam = ofertaCamlt.get(0);
				data = oValidaNull.validaNullString(ofertaCam.getPorTasaIntProm()).concat("|").concat(oValidaNull.validaNullString(ofertaCam.getPorTasaIntBase()))
						.concat("|").concat(ofertaCam.getIdSubProd().toString()).
						concat("|").concat(oValidaNull.validaNullString(ofertaCam.getPorCatProm())).concat("|").concat(oValidaNull.validaNullString(ofertaCam.getPorComPromo())).concat("|")
						.concat(oValidaNull.validaNullString(ofertaCam.getIdPlnCertifDscto())).concat("|").concat(oValidaNull.validaNullString(ofertaCam.getIdComision()))
						.concat("|").concat(oValidaNull.validaNullString(ofertaCam.getNumLapa())).concat("|").concat(oValidaNull.validaNullString(ofertaCam.getTxtNomColectivo())).concat("|")
						.concat(oValidaNull.validaNullString(ofertaCam.getDscNomClte())).concat("|").concat(oValidaNull.validaNullString(ofertaCam.getDscComPromo()))
						.concat("|").concat(oValidaNull.validaNullString(ofertaCam.getDscEntidadCrd())).concat("|").concat(oValidaNull.validaNullString(ofertaCam.getDscNomProm()))
						.concat("|").concat(oValidaNull.validaNullString(ofertaCam.getTxtNomTarjeta())).concat("|").concat(oValidaNull.validaNullString(ofertaCam.getTxtNumTarjeta()))
						.concat("|").concat(oValidaNull.validaNullString(ofertaCam.getPorFacAsegPromo())).concat("|").concat(oValidaNull.validaNullString(ofertaCam.getIdPlanMandatorio()));
			 return data;
			}
		} else if ( idModalidad == 2 ) {
				List<SccMxMaeOferPromMa> oferMAlt = daoOfertaMA.buscaOferPromByBucClte(buc,idSubProd,tipoPerfilSeleccionado);
				if (!oferMAlt.isEmpty()) {
					oferMA = oferMAlt.get(0);
					data = oValidaNull.validaNullString(oferMA.getPorTasaIntPromMin()).concat("|").concat(oValidaNull.validaNullString(oferMA.getPorTasaIntBaseResta())
							.concat("|").concat(oferMA.getIdSubProd().toString()).
							concat("|").concat(oValidaNull.validaNullString(oferMA.getPorCatProm())).concat("|")
							.concat(oValidaNull.validaNullString(oferMA.getPorComPromo())).concat("|")
							.concat(oValidaNull.validaNullString(oferMA.getIdPlnCertifDscto())).concat("|").concat(oValidaNull.validaNullString(oferMA.getIdComision())).concat("|").concat(oValidaNull.validaNullString(oferMA.getTxtNomColec()))
							.concat("|").concat(oValidaNull.validaNullString(oferMA.getDscNomClte())).concat("|").concat(oValidaNull.validaNullString(oferMA.getDscComPromo()))
							.concat("|").concat(oValidaNull.validaNullString(oferMA.getDscEntiCrd())).concat("|").concat(oValidaNull.validaNullString(oferMA.getDscNomProm())).concat("|").concat(oValidaNull.
									validaNullString(oferMA.getIdPlanMandatorio())));
					return data;
				}
			
		}
		return "";
	}
	
	
	
}
