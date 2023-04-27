package mx.isban.scc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.isban.scc.dao.ISccMxMaeAppCarteraDAO;
import mx.isban.scc.model.SccMxMaeAppCartera;
import mx.isban.scc.model.dto.SccMxMaeAppCarteraDTO;

/**
 * Implementacion de la interfaz que consulta los creditos del cliente en la tabla de cartera
 * @author Hitss
 * 
 * Julio 2019 
 * 
 * Sprint 3 * 
 * 
 *
 */
@Service
public class CarteraService implements ICarteraService {
	
	/**
	 * dao para acceder al la cartera
	 */
	@Autowired
	private ISccMxMaeAppCarteraDAO carteraDao;

	
	/**
	 * Método que implementa la consulta y manejo de datos de la tabla cartera para manejar
	 * los crédito del cliente 
	 * @author Hitss 
	 * Julio 2019
	 * Sprint 3
	 * 
	 * @param idCliente 
	 * identificador del cliente
	 *
	 * @return List(SccMxMaeAppCarteraDTO) 
	 * lista con los créditos del relacionados el cliente por por producto
	 * 
	 */
	@Override
	public List<SccMxMaeAppCarteraDTO> buscaCreditosCarteraPorIdClienteIdProd(Long idCliente) {
		
		List<SccMxMaeAppCartera> listaCreditos = carteraDao.obtenCreditosClientePorProducto(idCliente);
		
		List<SccMxMaeAppCarteraDTO> listaCreditosDTO = null;
		
		for (SccMxMaeAppCartera sccMxMaeAppCartera : listaCreditos) {
			SccMxMaeAppCarteraDTO creditoDto = new SccMxMaeAppCarteraDTO();
			creditoDto.setFchFormal(sccMxMaeAppCartera.getFchFormal());
			creditoDto.setIdCdto(sccMxMaeAppCartera.getIdCdto());
			creditoDto.setNumCdto(sccMxMaeAppCartera.getNumCdto());
			creditoDto.setNumClte(sccMxMaeAppCartera.getNumClte());
			creditoDto.setNumDeudaTotal(sccMxMaeAppCartera.getNumDeudaTotal());
			creditoDto.setNumMontoSeg(sccMxMaeAppCartera.getNumMontoSeg());
			creditoDto.setNumPlazo(sccMxMaeAppCartera.getNumPlazo());
			creditoDto.setNumPrdoPagos(sccMxMaeAppCartera.getNumPrdoPagos());
			creditoDto.setNumTasaInt(sccMxMaeAppCartera.getNumTasaInt());
			creditoDto.setTxtNomClte(sccMxMaeAppCartera.getTxtNomClte());
			creditoDto.setCodProd(sccMxMaeAppCartera.getCodigoProducto());
			
			if(listaCreditosDTO == null) {
				listaCreditosDTO = new ArrayList<SccMxMaeAppCarteraDTO>();
			}
			listaCreditosDTO.add(creditoDto);
		}
		
		return listaCreditosDTO;
	}

}
