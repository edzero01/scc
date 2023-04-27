package mx.isban.scc.service;

import mx.isban.scc.utilerias.TokenData;

/**
 * Interfaz para la consulta y validación de login del usuario
 * 
 * @author Hitss
 * 
 *         Octubre 2019 Sprint 5
 */
public interface ITokenService {

	/**
	 * Valida si el token es valido
	 * 
	 * @param tokenData TokenData
	 * @return true si es valido, de lo contrario false 
	 */
	TokenData isValid(TokenData tokenData);
	
	/**
	 * Extiende la vida de la sesion (token)
	 * 
	 * @param tokenData TokenData
	 * @return TokenData el valor de lastRenewed se actualizará con datetime de la última renovación  
	 */
	TokenData extendTokenLife(TokenData tokenData);
	
	/**
	 * Otbtiene la estructura GetLocationfromCorpID
	 * 
	 * @param tokenData TokenData
	 * @return TokenData  El valor de la propiedad costCenter se actualizará con el valor del centro de costos
	 */
	TokenData costCenter(TokenData tokenData);

	/**
	 * Otbtiene la estructura GetLocationfromCorpID
	 * 
	 * @param strToken la cadena completa del token (Base64 Hashed)
	 * @return TokenData  El valor de la propiedad costCenter se actualizará con el valor del centro de costos
	 */
	TokenData parseToken(String strToken);
	 
}
