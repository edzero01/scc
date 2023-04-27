package mx.isban.scc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.isban.scc.dao.ISccMxMaeConvAutoDAO;
import mx.isban.scc.dao.ISccMxMaeMvosRechazoDAO;
import mx.isban.scc.dao.ISccMxMaeSegmentoDAO;
import mx.isban.scc.dao.ISccMxMaeTipoProdDAO;
import mx.isban.scc.model.SccMxMaeConvauto;
import mx.isban.scc.model.SccMxMaeMvosRechazo;
import mx.isban.scc.model.SccMxMaeSegmento;
import mx.isban.scc.model.SccMxMaeTipoProd;
import mx.isban.scc.model.dto.SccMxMaeCatalogosDTO;

/**
 * Implementaci_n de las b_squedas de los catálogos para el servicio de
 * catalogosRestController motivos rechazo tipo producto segmento periodicidad
 * subproducto por id prod condiciones financieras conversion auto
 * 
 * Dichas inyecciones de dependencia son unicamente para obtener valores de
 * catalogos para llenado de combos, text box y motivos informativos en front
 * end Mayo 2019 Sprint 1 Fabrica de software Proyecto Simulador Credito al
 * Consumo Santander
 * 
 * @author GlobalHitss
 *
 *
 */
@Service
public class CatalogosSimService implements ICatalogosSimService {

	/**
	 * dao para acceder al tipo de producto
	 */
	@Autowired
	private ISccMxMaeTipoProdDAO daoTipoProd;

	/**
	 * Dao para acceder a los segmentos
	 */
	@Autowired
	private ISccMxMaeSegmentoDAO daoSegmento;

	/**
	 * Dao para acceder a motivos de rechazo
	 */
	@Autowired
	private ISccMxMaeMvosRechazoDAO daoMvosRechazo;

	/**
	 * DAO para el catalogo de segmentos de conversión auto
	 */
	@Autowired
	private ISccMxMaeConvAutoDAO daoConvAuto;

	/**
	 * Busca todos los tipos de producto, los segmentos y los motivos de rechazo
	 * Mayo 2019 Sprint 1
	 * 
	 * @param modalidad recibe la modalidad a usar para el filtrado de tipos de
	 *                  productos
	 * @author GlobalHitss
	 * @return SccMxMaeCatalogosDTO objeto con las listas de productos, segmentos y
	 *         motivos de rechazo
	 */
	@Override
	public SccMxMaeCatalogosDTO findAllCatalogos(Integer... modalidad) {

		List<SccMxMaeTipoProd> ltSccMxMaeTipoProd = daoTipoProd.buscaTodos(modalidad);

		List<SccMxMaeSegmento> ltSccMxMaeSegmento = daoSegmento.buscaTodos();
		for (SccMxMaeSegmento sgmto : ltSccMxMaeSegmento) {
			SccMxMaeConvauto vo = daoConvAuto.findById(sgmto.getIdSegmentoPk());
			sgmto.setSccMxMaeConvauto(vo);
		}
		List<SccMxMaeMvosRechazo> ltSccMxMaeMvosRechazo = daoMvosRechazo.buscaTodos();
		return new SccMxMaeCatalogosDTO(ltSccMxMaeTipoProd, ltSccMxMaeSegmento, ltSccMxMaeMvosRechazo);
	}

}
