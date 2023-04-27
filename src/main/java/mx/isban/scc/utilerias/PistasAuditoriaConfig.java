package mx.isban.scc.utilerias;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Clase de utilería para recibir la información de configuración de los
 * servicios para pistas de auditoría
 * 
 * Configurado usando config-service
 * 
 * @author Gabriel
 *
 */
@Component

public class PistasAuditoriaConfig {

	/**
	 * Variable global que almacena la cadena de conexión con el servidor de base de
	 * datos
	 */
	@Value("${auditoria.endpoint}")
	private String endPoint;

	/**
	 * Getter de la url de conexión a base de datos
	 * 
	 * @return la url de conexión a base de datos
	 */
	public String getEndPoint() {
		return endPoint;
	}

	/**
	 * Setter de la url de conexión a base de datos
	 * 
	 * @param url la url de conexión a base de datos
	 */
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

}
