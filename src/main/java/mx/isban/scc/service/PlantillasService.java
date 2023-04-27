package mx.isban.scc.service;

import java.io.ByteArrayOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.isban.scc.utilerias.plantillas.helper.IPlantillaLookupStrategy;

/**
 * Implementacion de la interfaz plantillaService la cual nos devuelve las
 * diferentes plantillas utilizadas como son: Tabla amortización, manifestación
 * de adeudo, mandatorio, certificado descuentos y carta compromiso Mayo 2019
 * Sprint 2
 * 
 * @author Octavio Cruz
 * 
 *
 */

@Service
public class PlantillasService implements IPlantillasService {

	/**
	 * Variable para buscar las plantillas en base de datos mediante el patrón
	 * de diseño Strategy
	 */
	@Autowired
	private IPlantillaLookupStrategy strategy;
	
	/**
	 * Método que nos devuelve plantillas 
	 * de tabla de amortizacion
	 * 
	 * @author Christopher Espina
	 * @param tipoPlantilla
	 * dentificador del tipo de plantilla
	 * @return representacion del objeto plantilla en un objeto
	 *         ByteArrayOutputStream
	 */
	@Override
	public ByteArrayOutputStream obtenerPlantillaTablaAmortiz(String tipoPlantilla) {
		return strategy.lookup(5).lookup(5, Integer.parseInt(tipoPlantilla));
	}
	/**
	 * Método que nos devuelve plantillas de 
	 * certificados de descuento
	 * @author Christopher Espina
	 * @param tipoPlantilla
	 * dentificador del tipo de plantilla
	 * @return representacion del objeto plantilla en un objeto
	 *         ByteArrayOutputStream
	 */
	@Override
	public ByteArrayOutputStream obtenerPlantillaCertDescSftp(String tipoPlantilla) {
		return strategy.lookup(2).lookup(2, Integer.parseInt(tipoPlantilla));		
	}
	/**
	 * Método que nos devuelve plantillas 
	 * de carta compromiso
	 * @author Christopher Espina
	 * @param idPlantilla
	 * dentificador de la plantilla 
	 * para Carta Compromiso
	 * @return representacion del objeto plantilla en un objeto
	 *         ByteArrayOutputStream
	 */
	public ByteArrayOutputStream obtenerPlantillaComPagoSftp(Integer idPlantilla) {
		return strategy.lookup(1).lookup(1, idPlantilla);
	}
	/**
	 * Método que nos devuelve plantillas
	 * de no adeudo
	 * @author Christopher Espina
	 * @param tipoPlantilla
	 * dentificador del tipo de plantilla
	 * @return representacion del objeto plantilla en un objeto
	 *         ByteArrayOutputStream
	 */
	@Override
	public ByteArrayOutputStream obtenerPlantillaNoAdeudSftp(String tipoPlantilla) {
		return strategy.lookup(3).lookup(3, Integer.parseInt(tipoPlantilla));
	}
	
	/**
	 * Método que nos devuelve plantillas
	 * de RIES139
	 * @author Jose Luis Garcia
	 * @param tipoPlantilla
	 * dentificador del tipo de plantilla
	 * @return representacion del objeto plantilla en un objeto
	 *         ByteArrayOutputStream
	 */
	@Override
	public ByteArrayOutputStream obtenerPlantillaRies139Sftp(String tipoPlantilla) {
		return strategy.lookup(6).lookup(6, Integer.parseInt(tipoPlantilla));
	}
	
	/**
	 * Método que nos devuelve plantillas
	 * de Caratula de credito
	 * @author Jose Luis Garcia
	 * @param tipoPlantilla
	 * dentificador del tipo de plantilla
	 * @return representacion del objeto plantilla en un objeto
	 *         ByteArrayOutputStream
	 */
	@Override
	public ByteArrayOutputStream obtenerPlantillaCaratulaSftp(String tipoPlantilla) {
		return strategy.lookup(6).lookup(6, Integer.parseInt(tipoPlantilla));
	}
}
