package mx.isban.scc.utilerias;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;

import mx.isban.scc.model.dto.SccMxTablaPrimaConsumoDTO;

/**
 * 
 * Funciones de apoyo (Utilerías) para la generación
 *         de las tablas de prima devengada y el 
 *         calculo de la misma         
 *
 *   
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
public class SccMxUtileriasPrimaDevengada {
	
	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con la
	 * finalidar de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(SccMxUtileriasPrimaDevengada.class);
	
	/**
	 * Metodo para calculo de sumatoria fin de mes para tabla de prima devengada
	 * @param tablaConsumo tabla de prima devengada pseudo llena
	 * @param startCont variable usada como indice inicial para el contador.
	 * @exception NumberFormatException ArithmeticException NumberFormatException ArithmeticException
	 * @return sumatoria sumatoria de fin mes
	 */
	public Double calculaSumatoriaFinMes(List<SccMxTablaPrimaConsumoDTO> tablaConsumo, Integer startCont) {
		
		Double sumatoria = 0.00;
		try {
			for(int i = startCont; i < tablaConsumo.size(); i++) {
				sumatoria = sumatoria + tablaConsumo.get(i).getPrimaMensual();
			}
		} catch (NumberFormatException | ArithmeticException e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
		return sumatoria;
	}

	/**
	 * Metodo para calculo de sumatoria fin de mes para tabla de prima devengada
	 * @param tablaConsumo
	 * tabla de prima devengada pseudo llena
	 * @exception NumberFormatException ArithmeticException NumberFormatException ArithmeticException
	 * @return sumatoria sumatoria de fin mes
	 */
	public Double calculaSumatoriaFinMesTotal(List<SccMxTablaPrimaConsumoDTO> tablaConsumo) {
		
		Double sumatoria = 1000.00;
		try {
			for(int i = 1; i < tablaConsumo.size(); i++) {
				sumatoria = sumatoria + tablaConsumo.get(i).getSaldoMes();
			}
		} catch (NumberFormatException | ArithmeticException e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
		return sumatoria;
	}
	/**
	 * Metodo que obtiene las primas mensuales
	 * y posteriormente obtiene la prima total
	 * a devengar
	 * @param tablaConsumo datos de entrada
	 * @param monto monto de entrada
	 * @return tablaConsumo tabla llena para calculo prim
	 */
	public List<SccMxTablaPrimaConsumoDTO> llenaPrimaMensual (List<SccMxTablaPrimaConsumoDTO> tablaConsumo, Double monto){
		Double sumatoria = calculaSumatoriaFinMesTotal(tablaConsumo);
		try {
			for(int i = 1; i < tablaConsumo.size(); i++) {
				
			    double primerMultiplicador= tablaConsumo.get(i).getSaldoMes()/1000.0;
			    double segundoMultiplicador = (monto * 1000.0)/sumatoria;
				
				double primaInicial = (primerMultiplicador * segundoMultiplicador );
						
				tablaConsumo.get(i).setPrimaMensual(primaInicial);
			}
		}catch (NumberFormatException | ArithmeticException e) {
			LOGGER.error(e.getMessage(), e);
			return tablaConsumo;
		}
		return tablaConsumo;
	}
	/**
	 * Metodo para llenar las fechas de inicio de periodo
	 * @param tablaConsumo tabla de entrada 
	 * @param fecha fecha inicio
	 * @return tablaConsumo tabla consumo
	 */
	public List<SccMxTablaPrimaConsumoDTO> llenaFechaInicio (List<SccMxTablaPrimaConsumoDTO> tablaConsumo, Date fecha){
		SimpleDateFormat sdf = new SimpleDateFormat("01/MM/yyyy");
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);

		tablaConsumo.get(0).setfInicio("");
		tablaConsumo.get(1).setfInicio(sdf.format(fecha));
		
		try {
			for(int i = 2; i < tablaConsumo.size(); i++) {
				
				cal.add(Calendar.MONTH, 1);
				tablaConsumo.get(i).setfInicio(sdf.format(cal.getTime()));
			}
		}catch (DateTimeException e) {
			LOGGER.error(e.getMessage(), e);
			return tablaConsumo;
		}
		return tablaConsumo;
	}
	
	/**
	 * Metodo para llenar las fechas de fin de periodo
	 * @param tablaConsumo tabla de entrada 
	 * @param fecha fecha inicio
	 * @return tablaConsumo tabla consumo
	 */
	public List<SccMxTablaPrimaConsumoDTO> llenaFechaFin(List<SccMxTablaPrimaConsumoDTO> tablaConsumo, Date fecha){
		SimpleDateFormat sdf = new SimpleDateFormat("01/MM/yyyy");
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		cal.add(Calendar.MONTH, 1);
		tablaConsumo.get(0).setfFin(sdf.format(fecha));
		
		try {
			for(int i = 1; i < tablaConsumo.size(); i++) {
				
				cal.add(Calendar.MONTH, 1);
				tablaConsumo.get(i).setfFin(sdf.format(cal.getTime()));
			}
		}catch (DateTimeException e) {
			LOGGER.error(e.getMessage(), e);
			return tablaConsumo;
		}
		return tablaConsumo;
	}
	
	/**
	 * Metodo para escoger prima dada la fecha final
	 * @param tablaConsumo tabla de entrada 
	 * @param fecha fecha final
	 * @return tablaConsumo tabla consumo
	 */
	public Double escogePrima(List<SccMxTablaPrimaConsumoDTO> tablaConsumo, String fecha){
		
		Double prima = null;
		
		try {
			
			for(int i = 1; i < tablaConsumo.size(); i++) {
				if(tablaConsumo.get(i).getfFin().equals(fecha)) {
					prima = tablaConsumo.get(i).getPrimaDevengar();
				}
			
			}
		}catch (DateTimeException e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
		return prima;
	}
	
	/**
	 * Metodo para pasar de date a calendar
	 * @param date date de entrada
	 * @return cal calendar object
	 */
	public static Calendar toCalendar(Date date){ 
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  return cal;
	}
	
}
