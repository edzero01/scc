package mx.isban.scc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import mx.isban.scc.dao.ISccMxMaeFondoGarantiaDAO;
import mx.isban.scc.model.SccMxMaeFondoGarId;
import mx.isban.scc.model.dto.SccMxMaeFondoGarantiaDTO;



/**
 * Implementacion del servicio de busqueda proporcionado al controler
 * para la consulta del catalogo de fondos de garantia
 * 
 * Junio 2019 
 * Sprint 2
 * 
 * @author HITSSS
 *
 */
@Service
public class CatalogosFondoGarantService implements ICatalogosFondoGarantService {

	/**
	 * Dao para acceder a los fondos de garantia
	 */
	@Autowired
	private ISccMxMaeFondoGarantiaDAO daoFondoGarantia;
	
	/**
	 * Junio 2019 Sprint 2 
	 * Metodo para consultar los fondos de garantia y guardarlos en DTO
	 * este sera mostrado por el service 
	 * 
	 * @author GlobalHitss
	 * 
	 * @return List(SccMxMaeFondoGarantiaDTO) lista de Fondos de garntia
	 * 
	 */
	@Override
	@Cacheable(cacheNames= "FondosGarantia")
	public List<SccMxMaeFondoGarantiaDTO> buscaFondosGarantia() {
		List<SccMxMaeFondoGarantiaDTO> listaFondosGarantia = new ArrayList<SccMxMaeFondoGarantiaDTO>();
		List<SccMxMaeFondoGarId> ltFondGarant = daoFondoGarantia.buscaFondosGarantia();
		for (SccMxMaeFondoGarId vo : ltFondGarant) {
			SccMxMaeFondoGarantiaDTO dto = new SccMxMaeFondoGarantiaDTO(vo.getIdFondGarPk(),vo.getDscFondGar(),vo.getPorComFondGar());
			listaFondosGarantia.add(dto);
		}

		return listaFondosGarantia;

	}

}
