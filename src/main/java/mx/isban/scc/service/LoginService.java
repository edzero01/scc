package mx.isban.scc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.isban.scc.utilerias.LoginConfig;

/**
 * Implementacion de la interfaz que consulta los creditos del cliente en la tabla de cartera
 * @author Hitss
 * 
 * Julio 2019 
 * 
 * Sprint 3 
 * 
 *
 */
@Service
public class LoginService implements ILoginService {
	
	/**
	 * Variable de configuración de los parámetros de usuario y contraseña
	 */
	@Autowired
	private LoginConfig config;
	
	/**
	 * Valida si el usuario es un administrador declarado en el server config
	 * 
	 * @param userName clave de usaurio a validar
	 * @param pwd      contraseña de usaurio a validar
	 * @return true si es administrador, false de otra forma
	 */
	@Override
	public boolean isAdministrador(String userName, String pwd) {
		String cUserName = config.getUsr();
		String cPwd = config.getPwd();
		return userName.equals(cUserName) && pwd.equals(cPwd);
	}

}
