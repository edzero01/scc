package mx.isban.scc.utilerias;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

import mx.isban.scc.model.dto.SccMxBonificacionConsumoDTO;
import mx.isban.scc.model.dto.SccMxTablaPrimaConsumoDTO;

/**
 * Utileria para llevar a cabo
 * el calculo de prima devengada
 * consumo
 * @author Christopher Espina Riveros
 * 
 * Global Hitss
 * Sprint 2
 * Mayo 2019
 *
 */
public class CalculaPrimaConsumo {

	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con la
	 * finalidar de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CalculaPrimaConsumo.class);
	/**
	 * Constante final de clase para representacion string 
	 */
	 private static final String MENSUAL = "M";
	/**
	 * Metodo para calcular prima devengada
	 * @author Christopher Espina Riveros
	 * 
	 * Global Hitss
	 * Mayo 2019
	 * @param objetoPrima
	 * objeto de entrada de cartera
	 * @return primaDevengada
	 * prima devengada
	 */
	public Double calculaPrimaC(SccMxBonificacionConsumoDTO objetoPrima) {
		try {
			SccMxUtileriasAmortizacionComplemento utileria = new SccMxUtileriasAmortizacionComplemento();
			SccMxUtileriasPrimaDevengada utileriaPrima = new SccMxUtileriasPrimaDevengada();
			List<SccMxTablaPrimaConsumoDTO> tablaPrima = new ArrayList <>(10);
			SccMxTablaPrimaConsumoDTO registroTabla = new SccMxTablaPrimaConsumoDTO();

			SimpleDateFormat sdf = new SimpleDateFormat("01/MM/yyyy");
			Double saldoPrevio = 1000.00;
			Double intereses = null;
			Double capital = null;
			Double tasaConvertida = utileria.obtenTasaConvertida(MENSUAL, objetoPrima.getNumTasaInt());
			tasaConvertida = tasaConvertida / 100;
			Double pagoFijo = 1000 * (tasaConvertida/(1 - Math.pow(1 + tasaConvertida, (-1 * objetoPrima.getNumPlazo()))));
			
			registroTabla.setPagoFijo(0.00);
			registroTabla.setCapital(0.00);
			registroTabla.setSaldoMes(saldoPrevio);
			tablaPrima.add(0, registroTabla);
			
			for(int i = 1; i <= objetoPrima.getNumPlazo(); i++) {
				SccMxTablaPrimaConsumoDTO registroTablaB = new SccMxTablaPrimaConsumoDTO();
				registroTablaB.setPagoFijo(pagoFijo);
				registroTablaB.setIntereses(tasaConvertida * saldoPrevio);
				intereses = registroTablaB.getIntereses();
				registroTablaB.setCapital(pagoFijo - intereses);
				capital = registroTablaB.getCapital();
				registroTablaB.setSaldoMes(saldoPrevio - capital); 
				saldoPrevio = registroTablaB.getSaldoMes();
				tablaPrima.add(i, registroTablaB);
			}
			
			tablaPrima = utileriaPrima.llenaPrimaMensual(tablaPrima, objetoPrima.getNumMontoSeg());
			for(int i = 0; i < objetoPrima.getNumPlazo(); i++) {
				tablaPrima.get(i).setPrimaDevengar(utileriaPrima.calculaSumatoriaFinMes(tablaPrima, i+1));
			}
			tablaPrima = utileriaPrima.llenaFechaInicio(tablaPrima, objetoPrima.getFchFormal());
			tablaPrima = utileriaPrima.llenaFechaFin(tablaPrima, objetoPrima.getFchFormal());
			
			return utileriaPrima.escogePrima(tablaPrima, sdf.format(objetoPrima.getFchCancelacion()));
			
		} catch (ArithmeticException |NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
	
	}
}
