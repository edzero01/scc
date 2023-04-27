package mx.isban.scc.utilerias;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import mx.isban.scc.model.BuscaOfertasCampaniaVO;
import mx.isban.scc.service.IComplementoService;


/**
 * Clase de apoyo que consulta las ofertas de campaña,
 * las ofertas de campaña promocionales y las
 * ofertas de campaña promocionales de mercado abierto
 * Sprint 2
 * Junio 2019
 * 
 * @author Hitss
 *
 */

@ManagedBean
public class BuscaOfertasCampania {
	
	/**
	 *  instancia para la implemantacion de la interfaz IClienteServiceComplemento
	 */
	@Autowired
	private IComplementoService serviceComplemento;
	
	

	/**
	 * Método que ejecuta las consultas de las ofertas de campaña,
	 * las ofertas promocionales de campaña y las ofertas promocionales
	 * de campaña de mercado abierto
	 * @param idBucCliente id del cliente para la búsqueda de ofertas
	 * @param perfil
	 * Identifica al perfil del cliente para validar las banderas ccs_in, fve, asn, etc de 
	 * la campaña de acuerdo al usuario que consulta
	 * @return regresa un objeto del tipo BuscaOfertasCampaniaDatos con la información
	 * encontrada por la búsqueda de ofertas
	 */
	public BuscaOfertasCampaniaVO buscaOfertas(Long idBucCliente, Long perfil ) {
		
		BuscaOfertasCampaniaVO data = new BuscaOfertasCampaniaVO();
		
		data.setLtSccMxMaeOferCam( serviceComplemento.ltSccMxMaeOferCam(idBucCliente, perfil) );
		data.setLtSccMxMaeOferPromCam( serviceComplemento.ltSccMxMaeOferPromCam(idBucCliente) );
		data.setLtSccMxMaeOferPromMa( serviceComplemento.ltSccMxMaeOferPromMa(idBucCliente) );
		return data;
		
	}
	
	
}
