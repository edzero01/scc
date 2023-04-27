package mx.isban.scc.utilerias;

import org.slf4j.Logger;

import mx.isban.scc.model.dto.SccMxTablaAmtzInDTO;
import mx.isban.scc.simulador.controller.TablaAmortizacionRestController;

/**
 * Clase para calculo cat dado tir para tabla de amortizacion dadas las reglas
 * de negocio brindadas por Santander. Se maneja el llenado de un primer
 * registro, subsecuentemente se maneja el llenado del segundo registro y el
 * mismo se replica en otro objeto el cual se ira actualizando dentro de un for
 * y cumpliendo ciertas condiciones de negocio ira llenando los registros
 * subsecuentes. Cabe destacar que esta lógica aplica tanto para perdiodos con
 * gracia, sin gracia y con o sin prima recurrente. Además, se hace uso de
 * metodos de utileria para obtener valores tales como la tasa y el plazo
 * convertido entre otros.
 * 
 * 
 * 
 * 
 *  * 
 * 
 * Simulador de Credito al Consumo
 * Global Hitss
 * Mayo 2019
 * 
 * 
 * @author Christopher Espina Riveros
 */
public class CalculoCatPorTirUtil {

	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con finalidad
	 * de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(TablaAmortizacionRestController.class);

	/**
	 * Método para obtnere cat por tir dado un plan
	 * 
	 * @author Christopher Espina Riveros
	 * @param tablaAmtzIn 
	 * parametros de entrada para calculo de cat
	 * @param plan        
	 * parametro que indica el tipo de plan para el cual se
	 * calculara el cat
	 * @exception NullPointerException  
	 * datos nulos
	 * @exception NumberFormatException 
	 * datos numericos malformados
	 * @return cat
	 * valor de cat
	 */
	public Double obtenCatViaTir(SccMxTablaAmtzInDTO tablaAmtzIn, Long plan) {

		ValidaNull oValidaNull = new ValidaNull();
		Double tasaConvertido = 0.00;
		Double plazoConvertido = 0.00;
		Double a = 0.00;
		Double b = 0.00;
		Double c = 0.00;
		Double d = 0.00;
		Double dividendo = 0.00;
		Double pagoFijo = 0.00;

		Double q9 = 0.00;
		Double r9 = 0.50;
		Double s9 = 100.00;
		Double r10 = 0.00;
		Double flujos = -1.00 * (oValidaNull.validaNullDouble(tablaAmtzIn.getValorCredito())) 
				+ oValidaNull.validaNullDouble(tablaAmtzIn.getComisionDisposicionSinIva())
				+ oValidaNull.validaNullDouble(tablaAmtzIn.getComisionAperturaSinIva()) + 
				oValidaNull.validaNullDouble(tablaAmtzIn.getSeguros()) + oValidaNull.validaNullDouble(tablaAmtzIn.getCaucion());
		Double cat = null;
		LOGGER.info("Caucion: " +tablaAmtzIn.getCaucion());
		LOGGER.info("Flujo: " + flujos);

		try {
			SccMxUtileriasAmortizacionComplemento utilerias = new SccMxUtileriasAmortizacionComplemento();
			tasaConvertido = utilerias.obtenTasaConvertida(tablaAmtzIn.getPeriodicidad(),
					tablaAmtzIn.getTasaInteresAnual());
			plazoConvertido = utilerias.obtenPlazoConvertido(tablaAmtzIn.getPeriodicidad(), tablaAmtzIn.getPlazo());
			a = (1 / tasaConvertido);
			b = (1 + (tasaConvertido / 100.00));
			b = Math.pow(b, plazoConvertido);
			c = (b * (tasaConvertido / 100.00));
			d = (1 / c);
			dividendo = ((a * 100.00) - d);
			if (1==plan) {
				pagoFijo = (tablaAmtzIn.getValorCredito() / dividendo);
			} else if (2 == plan ) {
				pagoFijo = (tablaAmtzIn.getValorCredito() * (tasaConvertido / 100.00))
						+ (tablaAmtzIn.getValorCredito() / tablaAmtzIn.getNumeroPagos());
			}

			tablaAmtzIn.setNumeroPeriodosAnio(utilerias.obtenPeriodosAnio(tablaAmtzIn.getPeriodicidad()));

			r10 = Math.pow((1.00 + (r9 / 100)), -1.00 * (tablaAmtzIn.getNumeroPagos()));
			r10 = 1.00 - r10;
			r10 = r10 / (r9 / 100.00);
			r10 = r10 * pagoFijo;
			r10 = r10 + flujos;

			do {

				if (r10 < 0) {
					s9 = r9;
				} else {
					q9 = r9;
				}

				r9 = ((q9 + s9) / 2.00);
				r10 = Math.pow((1 + (r9 / 100.00)), -1.00 * (tablaAmtzIn.getNumeroPagos()));
				r10 = 1.00 - r10;
				r10 = r10 / (r9 / 100.00);
				r10 = r10 * pagoFijo;
				r10 = r10 + flujos;

			} while (Math.abs(r10) > 0.000001);

			cat = (Math.pow((1 + (r9 / 100.00)), tablaAmtzIn.getNumeroPeriodosAnio()) - 1.00) * 100.00;
			cat = SccMxUtileriasAmortizacionComplemento.round(cat, 1);

		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
			return cat;
		}
		LOGGER.info("CAT final: " + cat);
		LOGGER.info("Tier: " + r9);
		return cat;
	}
}
