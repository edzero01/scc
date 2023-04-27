package mx.isban.scc.model.dto;

import java.io.Serializable;

/**
 * Clase que se usa para pasar los datos del login del cliente al servicio
 * 
 * @author Hitss
 * 
 * Julio 2019
 *
 */
public class LoginParamsDTO implements Serializable {

	/**
	 * Serializacion de la clase
	 */
	private static final long serialVersionUID = 170674159330763114L;

	/**
	 * User name del usuario
	 */
	private String userName;
	
	/**
	 * Contraseña del usuario
	 */
	private String pwd;

	/**
	 * getter del User name del usuario
	 * @return User name del usuario
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Setter del User name del usuario
	 * @param userName el User name del usuario
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Getter de la Contraseña del usuario
	 * @return la Contraseña del usuario
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * Setter de la Contraseña del usuario
	 * @param pwd la Contraseña del usuario
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
