package mx.isban.scc.service;
import java.io.ByteArrayOutputStream;

/**
 * 
 * Interfaz que define las consultas 
 * que se realizaran para la obtencion 
 * de los distintos tipos de plantillas
 * @author Octavio Cruz Rosas
 *
 */
public interface IPlantillasService {

	
	/**
	 * Metodo para obtener plantillas por SFTP
	 * @param tipoPlantilla
	 * tipo de plantilla
	 * @return ByteArrayOutputStream Contenido de archivo de plantilla
	 */
	ByteArrayOutputStream obtenerPlantillaTablaAmortiz(String tipoPlantilla);
	
	/**
	 * Metodo para obtener plantillas por SFTP
	 * @param tipoPlantilla
	 * tipo de plantilla
	 * @return ByteArrayOutputStream Contenido de archivo de plantilla
	 */
	ByteArrayOutputStream obtenerPlantillaCertDescSftp(String tipoPlantilla);
	/**
	 * Metodo para obtener plantillas por SFTP
	 * @param tipoPlantilla
	 * tipo de plantilla
	 * @return ByteArrayOutputStream Contenido de archivo de plantilla
	 */
	ByteArrayOutputStream obtenerPlantillaComPagoSftp(Integer tipoPlantilla);
	/**
	 * Metodo para obtener plantillas por SFTP
	 * @param tipoPlantilla
	 * tipo de plantilla
	 * @return ByteArrayOutputStream Contenido de archivo de plantilla
	 */
	ByteArrayOutputStream obtenerPlantillaNoAdeudSftp(String tipoPlantilla);
	
	/**
	 * Metodo para obtener plantillas RIES por SFTP
	 * @param tipoPlantilla
	 * tipo de plantilla
	 * @return ByteArrayOutputStream Contenido de archivo de plantilla
	 */
	ByteArrayOutputStream obtenerPlantillaRies139Sftp(String tipoPlantilla);
	
	/**
	 * Metodo para obtener plantillas carátula de crédito por SFTP
	 * @param tipoPlantilla
	 * tipo de plantilla
	 * @return ByteArrayOutputStream Contenido de archivo de plantilla
	 */
	ByteArrayOutputStream obtenerPlantillaCaratulaSftp(String tipoPlantilla);

	
}
