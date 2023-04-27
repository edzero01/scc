package mx.isban.scc.utilerias;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * Clase para obtener los valores provenientes
 * del config server relacionados con el 
 * login y obtiene usuario y contraseña
 * la contraseña no viene encriptada 
 * 
 * @author Hitss
 *
 */
@Component

public class LoginConfig {
	
	/**
	 * El nombre del usuario
	 */
	@Value("${login.usr}")
	private String usr;

	/**
	 * La contraseña del usuario
	 */
	@Value("${login.pwd}")
	private String pwd;

	/**
	 * Getter del nombre del usuario
	 * @return El nombre del usuario
	 */
	public String getUsr() {
		return usr;
	}

	/**
	 * Setter del nombre del usuario
	 * @param usr El nombre del usuario
	 */
	public void setUsr(String usr) {
		this.usr = usr;
	}

	/**
	 * Getter de La contraseña del usuario
	 * @return La contraseña del usuario
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * Setter de La contraseña del usuario
	 * @param pwd La contraseña del usuario
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	
	



}
