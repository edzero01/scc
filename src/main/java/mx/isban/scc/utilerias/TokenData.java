package mx.isban.scc.utilerias;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

import mx.isban.scc.model.dto.TokenDTO;

/**
 * Clase que se usa para hacer login 
 * basado en la portalizacion de Santander
 * Obtiene datos de un token que viene en el URL y una cookie. 
 * Los datos se completan con llamadas a servicios y 
 * se controla y extiende la vigencia del
 * token
 * 
 * @author Hitss
 * 
 *         Julio 2019
 *
 *         Sprint
 * 
 */
@Component
public class TokenData implements Serializable {
	/**
	 * Variable para identificar la clase con su "serial version"
	 */
	private static final long serialVersionUID = 9025780854461555604L;

	/**
	 * El Token en formato string para la validación de la sesión del cliente
	 */
	private String token;

	/**
	 * Información del token proveniente del cliente 
	 * que almacena la información de
	 * inicio de sesión del usuario
	 */
	private TokenDTO tokenDTO;

	/**
	 * indica si es valido el token pasado como parámetro
	 */
	private boolean valid;

	/**
	 * Fecha/Hora de ultima validacion del token 
	 * realizada por el servidor
	 */
	private Date lastValidated;

	/**
	 * Fecha/Hora de ultima renovacion del token 
	 * realizada en el servidor
	 */
	private Date lastRenewed;

	/**
	 * Identificador del "Centro de Costos" del usuario
	 */
	private Integer costCenter;

	/**
	 * Estatus de la ultima actualizacion del token de inicio de sesión
	 */
	private boolean updateStatus;
	
	
	/**
	 * Inicia la sección de Getters y Setters de las propiedades descritas arriba
	 */

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getLastValidated() {
		return (Date) lastValidated.clone();
	}

	public void setLastValidated(Date lastValidated) {
		this.lastValidated = (Date) lastValidated.clone();
	}

	public Date getLastRenewed() {
		return (Date) lastRenewed.clone();
	}

	public void setLastRenewed(Date lastRenewed) {
		this.lastRenewed = (Date) lastRenewed.clone();
	}

	public Integer getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(Integer costCenter) {
		this.costCenter = costCenter;
	}

	public boolean isUpdateStatus() {
		return updateStatus;
	}

	public void setUpdateStatus(boolean updateStatus) {
		this.updateStatus = updateStatus;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public TokenDTO getTokenDTO() {
		return tokenDTO;
	}

	public void setTokenDTO(TokenDTO tokenDTO) {
		this.tokenDTO = tokenDTO;
	}
	
	/**
	 * Fin de la sección de Getters y Setters de las propiedades del objeto
	 */


}
