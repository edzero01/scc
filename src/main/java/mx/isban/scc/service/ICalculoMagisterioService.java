package mx.isban.scc.service;

import java.io.ByteArrayOutputStream;

import mx.isban.scc.model.dto.SccMxTablaCaratulaDTO;
import mx.isban.scc.model.dto.SccMxTablaMagisterioDTO;
import mx.isban.scc.model.dto.SccMxTablaRiesDTO;

/**
 * Interfaz para la obtención de la tablas para 
 * los formatos Ries139 y Carátula de Crédito
 * 
 * Simulador de Crédito Magisterio
 * NTT Data
 * Enero 2022
 * 
 * @author José Luis García
 *
 */
public interface ICalculoMagisterioService {
	
	/**
	 * Metodo abstracto para obtener la tabla Ries 139
	 * @param tablaRies139
	 * recibe datos de entrada para la tabla
	 * @param plantillaDocx
	 * Plantilla sin datos a ser llenada
	 * @return
	 * lista de tabla Ries139
	 */
	ByteArrayOutputStream obtenTablaRies(SccMxTablaRiesDTO tablaRies139, ByteArrayOutputStream plantillaDocx);
	
	/**
	 * Metodo abstracto para obtener tabla de Caratula de Credito
	 * @param tablaCar
	 * recibe datos de entrada para la tabla
	 * @param plantillaDocx
	 * Plantilla sin datos a ser llenada
	 * @return
	 * lista de tabla Caratula de Credito
	 */
	ByteArrayOutputStream obtenTablaCaratula(SccMxTablaCaratulaDTO tablaCar, ByteArrayOutputStream plantillaDocx);
	
	/**
	 * Metodo abstracto para tabla amortizacion Magisterio
	 * @param tablaAmtzIn
	 * recibe datos de entrada para la tabla 
	 * @param plantillaDocx
	 * Plantilla sin datos a ser llenado
	 * @return lista de tabla plan Magisterio
	 */
	ByteArrayOutputStream obtenTablaPlanMagisterio(SccMxTablaMagisterioDTO tablaAmtzMagisterio, ByteArrayOutputStream plantillaDocx);

}
