package mx.isban.scc.service;

import java.io.ByteArrayOutputStream;

import mx.isban.scc.model.dto.SccMxCatPSGDTO;
import mx.isban.scc.model.dto.SccMxTablaAmtzInDTO;
/**
 * Interfaz para la obtención de las tablas de amortización
 * Dos interfaces, una para obtener tabla de plan frances
 * otra para obtener tabla de plan aleman.
 * Ambos casos abarcan con y sin recurrencia y 
 * con y sin periodos de gracia
 *  
 * 
 * Simulador de Credito al Consumo
 * Global Hitss
 * Mayo 2019
 * 
 *
 * 
 * 
 * @author Christopher Espina
 * 
 */


public interface ICalculoTblAmtzService {

	/**
	 * Metodo abstracto para tabla plan frances
	 * @param tablaAmtzIn
	 * recibe datos de entrada para la tabla 
	 * @param plantillaDocx
	 * Plantilla sin datos a ser llenado
	 * @return lista de tabla plan frances
	 */
	ByteArrayOutputStream obtenTablaPlanFrancesPUCG(SccMxTablaAmtzInDTO tablaAmtzIn, ByteArrayOutputStream plantillaDocx);
	
	/**
	 * Metodo abstracto para tabla plan frances
	 * @param tablaAmtzIn
	 * recibe datos de entrada para la tabla
	 * @param plantillaDocx
	 * Plantilla sin datos a ser llenado
	 * @return Plantilla con los datos del  Plan Frances
	 */
	ByteArrayOutputStream obtenTablaPlanFrancesPUSG(SccMxTablaAmtzInDTO tablaAmtzIn, ByteArrayOutputStream plantillaDocx);
	/**
	 * Metodo abstracto para tabla plan frances
	 * @param tablaAmtzIn
	 * recibe datos de entrada para la tabla
	 * @param plantillaDocx
	 * Plantilla sin datos a ser llenado
	 * @return Plantilla con los datos del  Plan Frances
	 */
	ByteArrayOutputStream obtenTablaPlanFrancesPRCG(SccMxTablaAmtzInDTO tablaAmtzIn, 
			                                        ByteArrayOutputStream plantillaDocx);
	/**
	 * Metodo abstracto para tabla plan aleman
	 * @param tablaAmtzIn
	 * recibe datos de entrada para la tabla
	 * @param plantillaDocx
	 * Plantilla sin datos a ser llenado
	 * @return lista de tabla plan aleman
	 */
	ByteArrayOutputStream obtenTablaPlanFrancesPRSG(SccMxTablaAmtzInDTO tablaAmtzIn, 
			                                        ByteArrayOutputStream plantillaDocx);
	
	/**
	 * Metodo abstracto para tabla plan aleman
	 * @param tablaAmtzIn
	 * recibe datos de entrada para la tabla
	 * @param plantillaDocx
	 * Plantilla sin datos a ser llenada
	 * @return lista de tabla plan aleman
	 */
	ByteArrayOutputStream obtenTablaPlanAlemanPUCG(SccMxTablaAmtzInDTO tablaAmtzIn, 
			                                       ByteArrayOutputStream plantillaDocx);
	
	/**
	 * Metodo abstracto para tabla plan aleman
	 * @param tablaAmtzIn
	 * recibe datos de entrada para la tabla
      * @param plantillaDocx
	 * Plantilla sin datos a ser llenada
	 * @return lista de tabla plan aleman
	 */
	ByteArrayOutputStream obtenTablaPlanAlemanPUSG(SccMxTablaAmtzInDTO tablaAmtzIn, 
			                                       ByteArrayOutputStream plantillaDocx);
	
	/**
	 * Metodo abstracto para tabla plan aleman
	 * @param tablaAmtzIn
	 * recibe datos de entrada para la tabla
	 * @param plantillaDocx
	 * Plantilla sin datos a ser llenada
	 * @return lista de tabla plan aleman
	 */
	ByteArrayOutputStream obtenTablaPlanAlemanPRCG(SccMxTablaAmtzInDTO tablaAmtzIn, 
			                                       ByteArrayOutputStream plantillaDocx);
	
	/**
	 * Metodo abstracto para tabla plan aleman
	 * @param tablaAmtzIn
	 * recibe datos de entrada para la tabla
	 * @param plantillaDocx
	 * Plantilla sin datos a ser llenada
	 * @return lista de tabla plan aleman
	 */
	ByteArrayOutputStream obtenTablaPlanAlemanPRSG(SccMxTablaAmtzInDTO tablaAmtzIn, 
			                                       ByteArrayOutputStream plantillaDocx);
	
	/**
	 * Metodo abstracto para tabla plan aleman
	 * @param tablaAmtzIn
	 * recibe datos de entrada para la tabla
	 * @param plan
	 * recibe tipo plan
	 * @return lista de tabla plan aleman
	 */
	Double obtenCatViaTir (SccMxTablaAmtzInDTO tablaAmtzIn, Long plan);
	
	/**
	 * Metodo abstracto para obtener el CAT de Personal Select Garantía
	 * @param datosCAT
	 * Recibe un conjunto de datos para calcular el cat
	 * @return CAT
	 * regresa el valor del CAT calculado
	 */
	Double obtenCatPSG (SccMxCatPSGDTO datosCAT);	
}
