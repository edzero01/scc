package mx.isban.scc.utilerias;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Clase de utilería para recibir la información de configuración de los
 * servicios para consultar las plantillas FTP
 * 
 * Configurado usando config-server
 * 
 * @author gabedg
 *
 */
@Component

public class PlantillasConfig {

	/**
	 * Variable global que almacena la dirección IP del servidor FTP ejemplo: 10 165
	 * 139 36;
	 */
	@Value("${ftp.ip}")
	private String ip;

	/**
	 * Variable global que almacena el password para conexión al servidor FTP
	 */
	@Value("${ftp.usuario}")
	private String usuario;

	/**
	 * Variable global que almacena el password para conexión al servidor FTP
	 */
	@Value("${ftp.cred}")
	private String credencial;

	/**
	 * Variable global que almacena la ruta donde se almacenara de manera temporal
	 * la plantilla el el servidor local
	 */
	@Value("${ftp.ruta}")
	private String rutaTemporal;

	/**
	 * Variable global que almacena el nombre del tipo de plantilla ubicada en el
	 * servidor FTP
	 */
	@Value("${ftp.dirbase}")
	private String plantillas = "Plantillas";

	/**
	 * Variable global que almacena el NOMBRE UNICO que tienen todas las plantillas
	 * en el filesystem servidor FTP
	 */
	@Value("${ftp.nomplantilla}")
	private String nombrePlantilla = "1.docx";
	
	/**
	 * Variable global que almacena el nombre de la llave para conexión al servidor FTP
	 */
	@Value("${ftp.key}")
	private String key;

	/**
	 * Getter para la direcciónip del seridor ftp
	 * 
	 * @return cadena con la ip del ftp
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * Inicial la dirección del ftp
	 * 
	 * @param ip el parámetro de la dirección del servidor ftp
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * regresa el usuario que accede al servidor ftp
	 * @return String con el nombre del usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Inicializa el valor del usuario que se conecta al servidor ftp
	 * @param usuario nombre del usuario del servidor ftp
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Regresa la ruta temporal del servidor  en la que se almacenan los archivos 
	 * @return cadena con la ruta 
	 */
	public String getRutaTemporal() {
		return rutaTemporal;
	}

	/**
	 * Inicializa la ruta temporal del servidor  en la que se almacenan los archivos
	 * @param rutaTemporal cadena con la ruta
	 */
	public void setRutaTemporal(String rutaTemporal) {
		this.rutaTemporal = rutaTemporal;
	}

	/**
	 * Regresa las credenciales del usuario que se conectará al servidor FTP
	 * @return cadena con las credenciales
	 */
	public String getCredencial() {
		return credencial;
	}

	/**
	 * Inicializa las credenciales del usuario que se conectará al servidor FTP
	 * @param credencial cadena con las credenciales
	 */
	public void setCredencial(String credencial) {
		this.credencial = credencial;
	}

	/**
	 * Obtiene el nombre del directorio base donde se almacenarán las plantillas en 
	 * el servidor ftp
	 * @return la cadena con el nombre del directorio base
	 */
	public String getPlantillas() {
		return plantillas;
	}

	/**
	 * Inicializa el nombre del directorio base donde se almacenarán las plantillas en 
	 * el servidor ftp
	 * @param plantillas la cadena con el nombre del directorio base
	 */
	public void setPlantillas(String plantillas) {
		this.plantillas = plantillas;
	}

	/**
	 * Obtiene el nombre de la plantilla a buscar en el servidor ftp
	 * @return cadena con el nombre y extensión de la plantilla
	 */
	public String getNombrePlantilla() {
		return nombrePlantilla;
	}

	/**
	 * Inicializa el nombre de la plantilla a buscar en el servidor ftp
	 * @param nombrePlantilla cadena con el nombre y extensión de la plantilla
	 */
	public void setNombrePlantilla(String nombrePlantilla) {
		this.nombrePlantilla = nombrePlantilla;
	}
	
	/**
	 * Obtiene el nombre del archivo de llave 
	 * @return el nombre del archivo de la llave
	 */
	public String getKey() {
		return key;
	}
	
	/**
	 * Inicializa el nombre del archivo de la llave
	 * @param key el nombre del archivo de la llave
	 */
	public void setKey(String key) {
		this.key = key;
	}

}
