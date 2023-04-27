package mx.isban.scc.service;

import java.util.List;

import mx.isban.scc.model.SccMxMaeOferCam;
import mx.isban.scc.model.SccMxMaeOferPromCam;
import mx.isban.scc.model.SccMxMaeOferPromMa;

/**
 * interfaz del cliente
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
public interface IComplementoService {
	
	/**
	 * Interface del service para obetner ofertas promocionales
	 * @param id 
	 * buc cliente
	 * @param perfil
	 * perfil del usuario
	 * @return SccMxMaeOferCam
	 * SccMxMaeOferCam
	 */
	List<SccMxMaeOferCam> ltSccMxMaeOferCam(long id, long perfil);
	/**
	 * Interface del service para obetner ofertas promocionales
	 * @param id 
	 * buc cliente
	 * @return SccMxMaeOferPromCam
	 * SccMxMaeOferPromCam
	 */
	List<SccMxMaeOferPromCam> ltSccMxMaeOferPromCam(long id);
	/**
	 * Interface del service para obetner ofertas promocionales
	 * @param id
	 * buc cliente 
	 * @return SccMxMaeOferPromMa
	 * SccMxMaeOferPromMa
	 */
	List<SccMxMaeOferPromMa> ltSccMxMaeOferPromMa(long id);

}
