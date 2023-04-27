package mx.isban.scc.service;

/**
 * Interfaz para la consulta y validación de login del usuario
 * 
 * @author Hitss
 * 
 *         Julio 2019 Sprint 3
 */
public interface ILoginService {

	/**
	 * Valida si el usuario es un administrador declarado en el server config
	 * 
	 * @param userName clave de usaurio a validar
	 * @param pwd      contraseña de usaurio a validar
	 * @return true si es administrador, false de otra forma
	 */
	boolean isAdministrador(String userName, String pwd);

}
