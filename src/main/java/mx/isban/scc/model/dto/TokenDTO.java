package mx.isban.scc.model.dto;

import java.io.Serializable;

/**
 * Clase DTO (Data Transfer Object) 
 * para contener los datos del token de acceso.
 * Este DTO no tiene relación con una entidad del modelo
 * ya que no existe como tabla, sino que es recibido
 * del URL o cookie al firmarse a la intranet
 * de Santander
 * 
 * @author GlobalHitss
 * Octubre 2019
 * Sprint 6
 * Estructura del token:
 * ID#IP#FC#XML#TC#VT#ET#XML_CIFRADO#TF#FIRMA
*/
public class TokenDTO implements Serializable {

	/**
	 * Generated serialVersionUID para la interfaz serializable 
	 */
	private static final long serialVersionUID = -6007302050515222287L;

	/**
	 * sessionId Identificador único de sesión en BKS (TS) 
	 */
	private String sessionId;

	/**
	 * ipAddress Dirección IP de la estación de trabajo origen de la autenticación (IP)
	 * (es la misma que se encuentra dentro de la cookie) 
	 */
	private String ipAddress;

	/**
	 * epochCaducidad Fecha y hora de caducidad en milisegundos (FC)
	 * La comparación "hora actual en milisegundos < hora de caducidad" 
	 * permite confirmar si el token está caducado.
	 */
	private long epochCaducidad;
	
	/**
	 * UserDataXML xml con los datos de usuario (XML)
	 */
	private String userDataXML;
	
	/**
	 * cipherType Tipo de cifrado usado para el cipherXML (TC) 
	 */
	private String cipherType;

	/**
	 * tokenVersion Versión del token (VT) 
	 */
	private String tokenVersion;

	/**
	 * tokenIssuer Emisor del token (ET) 
	 */
	private String tokenIssuer;

	/**
	 * cipherXML XML Cifrado (XML_CIFRADO) 
	 */
	private String cipherXML;
	
	/**
	 * digitalSignatureType Tipo de firma digital usada par firmar el token (TF) 
	 */
	private String digitalSignatureType;
	
	/**
	 * digitalSignature firma digital (FIRMA) 
	 */
	private String digitalSignature;

	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * @return the epochCaducidad
	 */
	public long getEpochCaducidad() {
		return epochCaducidad;
	}

	/**
	 * @param epochCaducidad the epochCaducidad to set
	 */
	public void setEpochCaducidad(long epochCaducidad) {
		this.epochCaducidad = epochCaducidad;
	}

	/**
	 * @return the userDataXML
	 */
	public String getUserDataXML() {
		return userDataXML;
	}

	/**
	 * @param userDataXML the userDataXML to set
	 */
	public void setUserDataXML(String userDataXML) {
		this.userDataXML = userDataXML;
	}

	/**
	 * @return the cipherType
	 */
	public String getCipherType() {
		return cipherType;
	}

	/**
	 * @param cipherType the cipherType to set
	 */
	public void setCipherType(String cipherType) {
		this.cipherType = cipherType;
	}

	/**
	 * @return the tokenVersion
	 */
	public String getTokenVersion() {
		return tokenVersion;
	}

	/**
	 * @param tokenVersion the tokenVersion to set
	 */
	public void setTokenVersion(String tokenVersion) {
		this.tokenVersion = tokenVersion;
	}

	/**
	 * @return the tokenIssuer
	 */
	public String getTokenIssuer() {
		return tokenIssuer;
	}

	/**
	 * @param tokenIssuer the tokenIssuer to set
	 */
	public void setTokenIssuer(String tokenIssuer) {
		this.tokenIssuer = tokenIssuer;
	}

	/**
	 * @return the cipherXML
	 */
	public String getCipherXML() {
		return cipherXML;
	}

	/**
	 * @param cipherXML the cipherXML to set
	 */
	public void setCipherXML(String cipherXML) {
		this.cipherXML = cipherXML;
	}

	/**
	 * @return the digitalSignatureType
	 */
	public String getDigitalSignatureType() {
		return digitalSignatureType;
	}

	/**
	 * @param digitalSignatureType the digitalSignatureType to set
	 */
	public void setDigitalSignatureType(String digitalSignatureType) {
		this.digitalSignatureType = digitalSignatureType;
	}

	/**
	 * @return the digitalSignature
	 */
	public String getDigitalSignature() {
		return digitalSignature;
	}

	/**
	 * @param digitalSignature the digitalSignature to set
	 */
	public void setDigitalSignature(String digitalSignature) {
		this.digitalSignature = digitalSignature;
	}

}
