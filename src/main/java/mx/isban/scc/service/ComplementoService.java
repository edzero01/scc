package mx.isban.scc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.isban.scc.dao.ISccMxMaeOferCamDAO;
import mx.isban.scc.dao.ISccMxMaeOferPromMaDAO;
import mx.isban.scc.model.SccMxMaeOferCam;
import mx.isban.scc.model.SccMxMaeOferPromCam;
import mx.isban.scc.model.SccMxMaeOferPromMa;

/**
 * Clase de negocio para 
 * ipmlementar interfaz de cliente
 * para obtener datos 
 * del mismo si es que existe
 * y llenar seccion de info 
 * de cliente y campania de existir una
 * siempre y cuando dicho cliente tenga 
 * como antes mencionado una oferta de
 * campania asignada a su usuario. 
 * Si no se cumple con esta regla o si no 
 * se encuentra el cliente dentro de el 
 * repositorio de santander, el simulador
 * llevara en automatico a las pantallas
 * de simulacion de creditos en modalidad
 *  de mercado abierto.
 *  
 *  Coonsiderar las siguientes instancias
 *  para inyeccion de dependecias en
 *  spring
 * 
 * ofertapromcam
 * ofercam
 * oferpromma
 * prcofermaxplazo
 * 
 * Esta clase de servicio 
 * inyecta dependencias de las 
 * clases previamente mencionadas 
 * 
 * GlobalHitss
 * Mayo 2019
 * Sprint 2
 * 
 * @author Hitss
 *
 */
@Service
public class ComplementoService implements IComplementoService{
	
	/**
	 *  instancia para la implemantacion de la interfaz ISccMxMaeOferCamDAO
	 */
	@Autowired
	private ISccMxMaeOferCamDAO daoOferCam;
	/**
	 *  instancia para la implemantacion de la interfaz ISccMxMaeOferPromMaDAO
	 */
	@Autowired
	private ISccMxMaeOferPromMaDAO daoOferPromMa;
	
	
	/**
	 * Implementación del service para obetner ofertas de campaña
	 * @param id 
	 * buc cliente
	 * @return SccMxMaeOferCam
	 * SccMxMaeOferCam
	 */
	public List<SccMxMaeOferCam> ltSccMxMaeOferCam(long id, long perfil) {

		return daoOferCam.buscaOferCamByBucClte(id, perfil);

	}
	/**
	 * Implementación del service para obetner ofertas promocionales de campaña
	 * @param id 
	 * buc cliente
	 * @return SccMxMaeOferPromCam
	 * SccMxMaeOferPromCam
	 */
	public List<SccMxMaeOferPromCam> ltSccMxMaeOferPromCam(long id) {
		return new ArrayList<SccMxMaeOferPromCam>();

	}
	/**
	 * Implementación del service para obetner ofertas promocionales
	 * @param id
	 * buc cliente 
	 * @return SccMxMaeOferPromMa
	 * SccMxMaeOferPromMa
	 */
	public List<SccMxMaeOferPromMa> ltSccMxMaeOferPromMa(long id) {

		return daoOferPromMa.buscaOferPromByBucClte(id);
	}
	
}
