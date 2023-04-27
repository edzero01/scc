package mx.isban.scc.utilerias;

import java.util.Formatter;
import java.util.Locale;

import org.slf4j.Logger;
/**
 * 
 * Funciones de apoyo (Utilerías) para la generación
 *         de las tablas de amortización Dichas funciones son accesadas por las
 *         diversos metodos implementados en la interfaz ICalculoTblAmtzService
 *         y en sus diversos metodos propios empleados para calcular las tablas
 *         de plan frances, plan aleman con sus diversas variantes
 *         
 * 
 *  * 
 * 
 * Simulador de Credito al Consumo
 * Global Hitss
 * Mayo 2019
 * 
 *
 * 
 * @author Christopher Espina 
 * 
 *         
 *
 */
public class SccMxUtileriasAmortizacionComplemento {

	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con la
	 * finalidar de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(SccMxUtileriasAmortizacion.class);
	
	/**
	 * Método para determinar gracia
	 * 
	 * @author Christopher Espina Riveros
	 * @param periodicidad 
	 * obtiene periodicidad
	 * @param codigoPeriodicidad       
	 * Periodicidad obtiene codigo periodicidad
	 * @return String
	 * Cadena que indica el período de gracia deduce si hay periodo de
	 *         gracia
	 */
	public String determinaGracia(String periodicidad, String codigoPeriodicidad) {

		if ((periodicidad == null) || (codigoPeriodicidad == null)) {
			return "Error en determinar si existe periodo de gracia";
		}

		periodicidad = periodicidad.toUpperCase();
		codigoPeriodicidad = codigoPeriodicidad.toUpperCase();

		switch (periodicidad) {
		case PeriodosDef.SEMANAL:
			codigoPeriodicidad = codigoPeriodicidad.substring(codigoPeriodicidad.indexOf("S:") + 2,
					codigoPeriodicidad.indexOf("S:") + 3);
			break;
		case PeriodosDef.CATORCENAL:
			codigoPeriodicidad = codigoPeriodicidad.substring(codigoPeriodicidad.indexOf("C:") + 2,
					codigoPeriodicidad.indexOf("C:") + 3);
			break;
		case PeriodosDef.QUINCENAL:
			codigoPeriodicidad = codigoPeriodicidad.substring(codigoPeriodicidad.indexOf("Q:") + 2,
					codigoPeriodicidad.indexOf("Q:") + 3);
			break;
		case PeriodosDef.MENSUAL:
			codigoPeriodicidad = codigoPeriodicidad.substring(codigoPeriodicidad.indexOf("M:") + 2,
					codigoPeriodicidad.indexOf("M:") + 3);
			break;
		default:
			codigoPeriodicidad = "1";
			break;
		}

		if ("0".equalsIgnoreCase(codigoPeriodicidad)) {
			return "false";
		} else {
			return "true";
		}
	}

	/**
	 * 
	 * metodo para obtener tasa convertida
	 * 
	 * @author Christopher Espina Riveros
	 * @param periodicidad
	 * obtiene periodicidad
	 * @param tasaInteresOrdinario 
	 * obtiene tasa de interes ordinario
	 * @exception NumberFormatException
	 * formato de datos numerico
	 * @return tasaConvertida 
	 * entrega tasa convertida
	 */
	public Double obtenTasaConvertida(String periodicidad, Double tasaInteresOrdinario) {
		Double tasaConvertida = 0.00;
		periodicidad = periodicidad.toUpperCase();
		try {
			switch (periodicidad) {
			case PeriodosDef.SEMANAL:
				tasaConvertida = (tasaInteresOrdinario / 360) * 7;
				break;
			case PeriodosDef.CATORCENAL:
				tasaConvertida = (tasaInteresOrdinario / 360) * 14;
				break;
			case PeriodosDef.QUINCENAL:
				tasaConvertida = (tasaInteresOrdinario / 360) * 15;
				break;
			case PeriodosDef.MENSUAL:
				tasaConvertida = (tasaInteresOrdinario / 12);
				break;
			default:
				break;
			}

		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return tasaConvertida;
	}

	/**
	 * metodo para obtener plazon convertido
	 * 
	 * @author Christopher Espina Riveros
	 * @param periodicidad 
	 * obtiene periodicidad
	 * @param plazo        
	 * obtiene plazo
	 * @exception NumberFormatException
	 * datos malformados
	 * @return plazoconvertido 
	 * entrega plazo convertido
	 */
	public Double obtenPlazoConvertido(String periodicidad, Integer plazo) {
		Double plazoConvertido = 0.00;

		try {
			switch (periodicidad) {
			case PeriodosDef.SEMANAL:
				plazoConvertido = (plazo / 12.0) * 52;
				break;
			case PeriodosDef.CATORCENAL:
				plazoConvertido = (plazo / 12.0) * 26;
				break;
			case PeriodosDef.QUINCENAL:
				plazoConvertido = (plazo * 2.0);
				break;
			case PeriodosDef.MENSUAL:
				plazoConvertido = (plazo * 1.0);
				break;
			default:
				break;
			}

		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
		}

		return plazoConvertido;
	}

	/**
	 * metodo para calcular periodos de gracia
	 * 
	 * @author Christopher Espina Riveros
	 * @param periodicidad 
	 * obtiene periodicidad
	 * @return pagos de gracia 
	 * entrega numero de pagos de gracia
	 */
	public Integer calculaPeriodosGracia(String periodicidad) {

		if (periodicidad == null) {
			return null;
		}

		Integer pagosDeGracia = 0;

		switch (periodicidad) {
		case PeriodosDef.SEMANAL:
			pagosDeGracia = 4;
			break;
		case PeriodosDef.CATORCENAL:
			pagosDeGracia = 2;
			break;
		case PeriodosDef.QUINCENAL:
			pagosDeGracia = 2;
			break;
		case PeriodosDef.MENSUAL:
			pagosDeGracia = 1;
			break;
		default:
			break;
		}

		return pagosDeGracia;
	}

	/**
	 * metodo para obtener pago fijo
	 * 
	 * @author Christopher Espina Riveros
	 * @param tasa  
	 * obtiene tasa
	 * @param pagos 
	 * obtiene pagos
	 * @param saldo 
	 * obtiene saldo
	 * @exception NumberFormatException
	 * formato de datos invalido
	 * @return valor de pago 
	 * fijo regresa pago fijo
	 */
	public Double calculaPagoFijo(Double tasa, Integer pagos, Double saldo) {

		Double pago = 0.00;
		Double dividendo = 0.00;
		Double divisor = 0.00;

		try {

			dividendo = ((tasa / 100) * (Math.pow(1 + (tasa / 100), pagos)));
			divisor = (Math.pow((1 + (tasa / 100)), pagos)) - 1;

			pago = saldo * (dividendo / divisor);

		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
		}

		return pago;
	}

	/**
	 * metodo para redondear
	 * 
	 * @author Christopher Espina Riveros
	 * @param value  
	 * obtiene valor a redondear
	 * @param places 
	 * obtiene decimales
	 * @return valor de redondeo 
	 * regresa cifra redondeada
	 */
	public static double round(double value, int places) {
		if (places < 0) {
			throw new IllegalArgumentException();
		}
		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

	/**
	 * metodo para obtener periodos del anio
	 * 
	 * @author Christopher Espina Riveros
	 * @param periodicidad 
	 * periodicidad para determinar periodos
	 * @exception NullPointerException
	 * datos nulos
	 * @return numero de 
	 * periodos por anio
	 */
	public Integer obtenPeriodosAnio(String periodicidad) {
		Integer periodos = 0;

			periodicidad = periodicidad.toUpperCase();

			switch (periodicidad) {
			case PeriodosDef.SEMANAL:
				periodos = 52;
				break;
			case PeriodosDef.CATORCENAL:
				periodos = 26;
				break;
			case PeriodosDef.QUINCENAL:
				periodos = 24;
				break;
			case PeriodosDef.MENSUAL:
				periodos = 12;
				break;
			default:
				break;
			}

		return periodos;
	}

	/**
	 * metodo para obtener pago de seguro
	 * 
	 * @author Christopher Espina Riveros
	 * @param periodicidad 
	 * obtiene periodicidad
	 * @param factorSeguro 
	 * obtiene factor seguro
	 * @param valorCredito 
	 * obtiene valorcredito
	 * @exception NumberFormatException
	 * formato de datos
	 * @return valor de seguros 
	 * regresa el seguro
	 */
	public Double obtenSeguros(String periodicidad, Double factorSeguro, Double valorCredito) {

		if ((periodicidad == null) || (factorSeguro == null) || (valorCredito == null)) {
			return null;
		}

		periodicidad = periodicidad.toUpperCase();
		Double varSeguros = 0.00;
		try {
			switch (periodicidad) {
			case PeriodosDef.SEMANAL:
				varSeguros = (factorSeguro) * valorCredito / 4;

				break;
			case PeriodosDef.CATORCENAL:
				varSeguros = (factorSeguro) * valorCredito / 2;

				break;
			case PeriodosDef.QUINCENAL:
				varSeguros = (factorSeguro) * valorCredito / 2;

				break;
			case PeriodosDef.MENSUAL:
				varSeguros = (factorSeguro) * valorCredito;

				break;
			default:
				break;
			}
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
			varSeguros = null;
		}
		return varSeguros;
	}
	/**
	 * 
	 * Metodo para formatear a MN
	 * 
	 * @author Christopher Espina Riveros
	 * @param cifra
	 * cifra a formatear
	 * @exception NumberFormatException
	 * formato de datos erroneo
	 * @return
	 * cifra formateada
	 */
	public String formatoDivisaDecimal(Double cifra) {

		Double cantidadC = cifra;
		StringBuilder sb = new StringBuilder();

		
		try(Formatter formatter = new Formatter(sb,Locale.US)) {
			
			formatter.format("$ %(,.2f", cantidadC);
			sb.toString();

		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return sb.toString();
	}
	/**
	 * 
	 * Metodo para formato a porcentajes
	 * 
	 * @author Christopher Espina Riveros
	 * @param cifra
	 * cifra a formatear
	 * @exception NumberFormatException
	 * formato de datos erroneo
	 * @return 
	 * dato formateado
	 */
	public String formatoPorcentajeDecimal(Double cifra) {

		String cantidadS = "";
		StringBuilder sb = new StringBuilder();

		try {
			cantidadS = cifra.toString();
			if ((cantidadS.substring(cantidadS.indexOf('.') + 1, cantidadS.length())).length() == 1) {
				sb.append(cantidadS);
				sb.append("0");
			} else {
				sb.append(cantidadS);
			}
			sb.append("%");

		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return sb.toString();
	}
}
