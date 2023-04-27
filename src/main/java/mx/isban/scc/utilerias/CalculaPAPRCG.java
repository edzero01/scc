package mx.isban.scc.utilerias;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import mx.isban.scc.model.dto.SccMxTablaAmtzInDTO;
import mx.isban.scc.model.dto.SccMxTablaAmtzValorDTO;
import mx.isban.scc.utilerias.plantillas.PlantillaAmortizacionPR;

/**
 * Clase para calculo de tabla de amortizacion plan aleman dadas las reglas de
 * negocio brindadas por Santander. Se maneja el llenado de un primer registro,
 * subsecuentemente se maneja el llenado del segundo registro y el mismo se
 * replica en otro objeto el cual se ira actualizando dentro de un for y
 * cumpliendo ciertas condiciones de negocio ira llenando los registros
 * subsecuentes. Cabe destacar que esta lógica aplica tanto para periodos con
 * gracia, sin gracia y con o sin prima recurrente. Además, se hace uso de
 * metodos de utileria para obtener valores tales como la tasa y el plazo
 * convertido entre otros.
 *
 *
 * 
 * 
 * Simulador de Credito al Consumo
 * Global Hitss
 * Mayo 2019
 * 
 * 
 * @author Christopher Espina Riveros
 */
@ManagedBean
public class CalculaPAPRCG {

	/**
	 * Constante de clase, con un solo espacio de memoria dedicado a calculo de
	 * prima.
	 */
	private static final String FALSE = "false";
	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable para
	 * comparaciones en true
	 */
	private static final String TRUE = "true";
	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con la
	 * finalidar de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CalculaPAPRCG.class);
	/**
	 * Dependencia de path
	 */
	@Autowired
	private PlantillaAmortizacionPR path;
	/**
	 * Utileria para calcular la tabla con plan alemán. En modalidad recurrente y
	 * con gracia
	 * 
	 * @author Christopher Espina Riveros
	 * @param tablaAmtzIn 
	 * recibe datos de entrada para la tabla
	 * @param plantillaDocx
	 * path origen de los datos
	 * @return tablaAmtzValor 
	 * devuelve la tabla de amortizacion
	 * @throws NumberFormatException 
	 * excepcion de formato numerico
	 */
	public ByteArrayOutputStream calculaPlanAlemanPRCG(SccMxTablaAmtzInDTO tablaAmtzIn, ByteArrayOutputStream plantillaDocx) {
		List<SccMxTablaAmtzValorDTO> tablaAmtzValor = new ArrayList<>();
		SccMxTablaAmtzValorDTO valorActual = new SccMxTablaAmtzValorDTO();
		SccMxTablaAmtzValorDTO valorActualGemelo = new SccMxTablaAmtzValorDTO();
		SccMxTablaAmtzValorDTO valorActualGemeloGracia = new SccMxTablaAmtzValorDTO();
		SccMxTablaAmtzValorDTO valor = new SccMxTablaAmtzValorDTO();
		SccMxTablaAmtzValorDTO valorPrevio = new SccMxTablaAmtzValorDTO();
		SccMxUtileriasAmortizacionComplemento utilerias = new SccMxUtileriasAmortizacionComplemento();
		Double tasaConvertido = 0.00;

		Integer numeroPagos = tablaAmtzIn.getNumeroPagos();
		String flagTabla = TRUE;
		Integer manejaGracia = 0;
		Integer contadorSemanalSeguros = 0;
		try {
			valorPrevio.setSaldoDeCapital(tablaAmtzIn.getValorCredito());
			tablaAmtzValor.add(0, valorPrevio);
			tasaConvertido = utilerias.obtenTasaConvertida(tablaAmtzIn.getPeriodicidad(),
					tablaAmtzIn.getTasaInteresAnual());
			valorActual.setIntereses(tablaAmtzIn.getValorCredito() * (tasaConvertido / 100));
			valorActual.setPagoFijo(valorActual.getIntereses());
			valorActual.setIvaDeIntereses(valorActual.getIntereses() * 0.16);
			valorActual.setSeguros(utilerias.obtenSeguros(tablaAmtzIn.getPeriodicidad(), tablaAmtzIn.getFactorSeguro(),
					tablaAmtzIn.getValorCredito()));
			valorActual.setPagoTotal(
					valorActual.getPagoFijo() + valorActual.getIvaDeIntereses() + valorActual.getSeguros());
			valorActual.setCapital(valorActual.getPagoFijo() - valorActual.getIntereses());
			valorActual.setSaldoDeCapital(valorPrevio.getSaldoDeCapital() - valorActual.getCapital());
			valorActual.setNumeroPagos(1);
			manejaGracia = utilerias.calculaPeriodosGracia(tablaAmtzIn.getPeriodicidad());
			tablaAmtzIn.setNumeroPagosSinSkip(numeroPagos - manejaGracia);
			tablaAmtzIn.setPlazoMesesSinSkip(tablaAmtzIn.getPlazo() - 1);
			SccMxTablaAmtzValorDTO valorActualGracia = new SccMxTablaAmtzValorDTO();

			tablaAmtzValor = llenaForGracia(manejaGracia, flagTabla, valorActualGracia, valorActual, 
					tablaAmtzIn, tasaConvertido, tablaAmtzValor);

			valorActualGemelo.setNumeroPagos(manejaGracia + 1);
			valorActualGemelo.setIntereses(valorActual.getIntereses());
			valorActualGemelo.setCapital(tablaAmtzIn.getValorCredito() / tablaAmtzIn.getNumeroPagosSinSkip());
			valorActualGemelo.setPagoFijo(valorActualGemelo.getIntereses() + valorActualGemelo.getCapital());
			valorActualGemelo.setIvaDeIntereses(valorActualGemelo.getIntereses() * 0.16);
			valorActualGemelo.setSeguros(valorActual.getSeguros());
			valorActualGemelo.setPagoTotal(
					valorActualGemelo.getPagoFijo() + valorActualGemelo.getIvaDeIntereses() + valorActual.getSeguros());
			valorActualGemelo.setSaldoDeCapital(tablaAmtzIn.getValorCredito() - valorActualGemelo.getCapital());
			
			valor.setNumeroPagos(manejaGracia + 1);
			valor.setIntereses(valorActual.getIntereses());
			valor.setCapital(tablaAmtzIn.getValorCredito() / tablaAmtzIn.getNumeroPagosSinSkip());
			valor.setPagoFijo(valorActualGemelo.getIntereses() + valorActualGemelo.getCapital());
			valor.setIvaDeIntereses(valorActualGemelo.getIntereses() * 0.16);
			valor.setSeguros(valorActual.getSeguros());
			valor.setPagoTotal(
					valor.getPagoFijo() + valorActualGemelo.getIvaDeIntereses() + valorActual.getSeguros());
			valor.setSaldoDeCapital(tablaAmtzIn.getValorCredito() - valorActualGemelo.getCapital());

			valorActualGemeloGracia.setNumeroPagos(manejaGracia + 1);
			valorActualGemeloGracia.setIntereses(valorActual.getIntereses());
			valorActualGemeloGracia.setCapital(tablaAmtzIn.getValorCredito() / tablaAmtzIn.getNumeroPagosSinSkip());
			valorActualGemeloGracia.setPagoFijo(valorActualGemelo.getIntereses() + valorActualGemelo.getCapital());
			valorActualGemeloGracia.setIvaDeIntereses(valorActualGemelo.getIntereses() * 0.16);
			valorActualGemeloGracia.setSeguros(valorActual.getSeguros());
			valorActualGemeloGracia.setPagoTotal(
					valorActualGemelo.getPagoFijo() + valorActualGemelo.getIvaDeIntereses() + valorActual.getSeguros());
			valorActualGemeloGracia.setSaldoDeCapital(tablaAmtzIn.getValorCredito() - valorActualGemelo.getCapital());

			tablaAmtzValor.add(manejaGracia + 1, valor);
			contadorSemanalSeguros = 2;
			
			tablaAmtzValor = llenaTablaFor(manejaGracia, numeroPagos, flagTabla, tablaAmtzIn, valorActualGemeloGracia, 
					tablaAmtzValor, tasaConvertido, contadorSemanalSeguros, valorActualGracia);

		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
		return path.docAmortizacion(
				plantillaDocx,
				tablaAmtzValor, tablaAmtzIn);
	}
	/**
	 * Metodo privado para obtener los parametros
	 * dentro de el periodo de gracia
	 * @param manejaGracia
	 * periodo de gracia
	 * @param flagTabla
	 * indicador de creacion de registro
	 * @param valorActualGracia
	 * valor de objeto actual gracia
	 * @param valorActual
	 * valor de objeto actual
	 * @param tablaAmtzIn
	 * datos de entrada
	 * @param tasaConvertido
	 * tasa convertida
	 * @param tablaAmtzValor
	 * tabka de amortizacion
	 * @return tablaAmtzValor
	 * tabla llena
	 */
	private List<SccMxTablaAmtzValorDTO> llenaForGracia(Integer manejaGracia, String flagTabla, SccMxTablaAmtzValorDTO valorActualGracia,
			SccMxTablaAmtzValorDTO valorActual, SccMxTablaAmtzInDTO tablaAmtzIn, Double tasaConvertido, List<SccMxTablaAmtzValorDTO> tablaAmtzValor){
		for (int i = 1; i <= manejaGracia; i++) {

			if (flagTabla.equalsIgnoreCase(TRUE)) {
				valorActualGracia.setCapital(0.00);
				valorActualGracia.setPagoFijo(valorActual.getIntereses());
				valorActualGracia.setIntereses(valorActual.getIntereses());
				valorActualGracia.setSaldoDeCapital(tablaAmtzIn.getValorCredito());
				valorActualGracia.setIvaDeIntereses(tablaAmtzIn.getValorCredito() * (tasaConvertido / 100) * 0.16);
				valorActualGracia.setSeguros(valorActual.getSeguros() * 1000);
				valorActualGracia.setPagoTotal(valorActualGracia.getPagoFijo()
						+ valorActualGracia.getIvaDeIntereses() + valorActualGracia.getSeguros());
				valorActualGracia.setNumeroPagos(i);
				flagTabla = FALSE;
			}
			if (flagTabla.equalsIgnoreCase(FALSE)) {
				SccMxTablaAmtzValorDTO valorActualizadoGracia = new SccMxTablaAmtzValorDTO();
				valorActualizadoGracia.setCapital(0.00);
				valorActualizadoGracia.setPagoFijo(valorActual.getIntereses());
				valorActualizadoGracia.setIntereses(valorActual.getIntereses());
				valorActualizadoGracia.setSaldoDeCapital(tablaAmtzIn.getValorCredito());
				valorActualizadoGracia
						.setIvaDeIntereses(tablaAmtzIn.getValorCredito() * (tasaConvertido / 100) * 0.16);
				valorActualizadoGracia.setSeguros(valorActual.getSeguros() * 1000);
				valorActualizadoGracia.setPagoTotal(valorActualGracia.getPagoFijo()
						+ valorActual.getIvaDeIntereses() + valorActual.getSeguros());
				valorActualizadoGracia.setNumeroPagos(i);

				valorActual.setCapital(0.00);
				valorActual.setPagoFijo(valorActualizadoGracia.getPagoFijo());
				valorActual.setSaldoDeCapital(valorActualizadoGracia.getSaldoDeCapital());
				valorActual.setIvaDeIntereses(valorActualizadoGracia.getIvaDeIntereses());
				valorActual.setSeguros(valorActual.getSeguros() * 1000);

				valorActual.setPagoTotal(valorActualizadoGracia.getPagoTotal());
				tablaAmtzValor.add(i, valorActualizadoGracia);
				flagTabla = TRUE;
			}
		}
		return tablaAmtzValor;
	}
	/**
	 * Metodo privado para obtener los periodos
	 * comunes de tabla de amortizacion
	 * @param manejaGracia
	 * indicador de numero de pagos de gracia
	 * @param numeroPagos
	 * numero de pagos total
	 * @param flagTabla
	 * indicador de creacion de registro
	 * @param tablaAmtzIn
	 * valores de entrada
	 * @param valorActualGemelo
	 * valor actual copia
	 * @param tablaAmtzValor
	 * tabla de amortizacion 
	 * @param tasaConvertido
	 * tasa convertida
	 * @param contadorSemanalSeguros
	 * contador semanal
	 * @param utilerias
	 * utilerias de amortizacion
	 * @param valorActual
	 * valor actual
	 * @return tablaAmtzValor}
	 * tabla de amortizacion llena
	 */
	private List<SccMxTablaAmtzValorDTO> llenaTablaFor(Integer manejaGracia, Integer numeroPagos, String flagTabla,
			SccMxTablaAmtzInDTO tablaAmtzIn, SccMxTablaAmtzValorDTO valorActualGemelo,
			List<SccMxTablaAmtzValorDTO> tablaAmtzValor, Double tasaConvertido, Integer contadorSemanalSeguros,
			SccMxTablaAmtzValorDTO valorActual) {
		SccMxTablaAmtzValorDTO valorActualizado = new SccMxTablaAmtzValorDTO();
		SccMxUtileriasAmortizacion utileriasSeguro = new SccMxUtileriasAmortizacion();
		for (int i = manejaGracia + 2; i <= numeroPagos; i++) {
			if (contadorSemanalSeguros == 5) {
				contadorSemanalSeguros = 1;
			}
			if (flagTabla.equalsIgnoreCase(TRUE)) {
				valorActualizado.setNumeroPagos(i);
				valorActualizado.setIntereses(valorActualGemelo.getSaldoDeCapital() * (tasaConvertido / 100));
				valorActualizado.setCapital(tablaAmtzIn.getValorCredito() / tablaAmtzIn.getNumeroPagosSinSkip());
				valorActualizado.setPagoFijo(valorActualizado.getIntereses() + valorActualizado.getCapital());
				valorActualizado.setIvaDeIntereses(valorActualizado.getIntereses() * 0.16);
				valorActualizado
						.setSaldoDeCapital(valorActualGemelo.getSaldoDeCapital() - valorActualizado.getCapital());

				valorActualizado.setSeguros(
						utileriasSeguro.obtenPagoSeguro(i, contadorSemanalSeguros, tablaAmtzValor, tablaAmtzIn).getSeguros());
				contadorSemanalSeguros = utileriasSeguro.getContadorSemanalSeguros();

				valorActualizado.setPagoTotal(valorActualizado.getPagoFijo() + valorActualizado.getIvaDeIntereses()
						+ valorActualizado.getSeguros());
				flagTabla = FALSE;
			}
			if (flagTabla.equalsIgnoreCase(FALSE)) {
				SccMxTablaAmtzValorDTO valorActualizadoGemeloPAPRCG = new SccMxTablaAmtzValorDTO();
				valorActualizadoGemeloPAPRCG.setNumeroPagos(valorActualizado.getNumeroPagos());
				valorActualizadoGemeloPAPRCG.setCapital(valorActualizado.getCapital());
				valorActualizadoGemeloPAPRCG.setSaldoDeCapital(valorActualizado.getSaldoDeCapital());
				valorActualizadoGemeloPAPRCG.setIntereses(valorActualizado.getIntereses());
				valorActualizadoGemeloPAPRCG.setPagoFijo(valorActualizado.getPagoFijo());
				valorActualizadoGemeloPAPRCG.setIvaDeIntereses(valorActualizado.getIvaDeIntereses());
				valorActualizadoGemeloPAPRCG.setSeguros(valorActualizado.getSeguros());
				valorActualizadoGemeloPAPRCG.setPagoTotal(valorActualizado.getPagoTotal());

				valorActualGemelo.setPagoFijo(valorActualizadoGemeloPAPRCG.getPagoFijo());
				valorActualGemelo.setCapital(valorActualizadoGemeloPAPRCG.getCapital());
				valorActualGemelo.setSaldoDeCapital(valorActualizadoGemeloPAPRCG.getSaldoDeCapital());
				valorActualGemelo.setIntereses(valorActualizadoGemeloPAPRCG.getIntereses());
				valorActualGemelo.setIvaDeIntereses(valorActualizadoGemeloPAPRCG.getIvaDeIntereses());
				valorActualGemelo.setPagoTotal(valorActualizadoGemeloPAPRCG.getPagoTotal());
				valorActual.setSeguros(valorActualizadoGemeloPAPRCG.getSeguros());
				tablaAmtzValor.add(i, valorActualizadoGemeloPAPRCG);
				flagTabla = TRUE;
			}
		}
		return tablaAmtzValor;
	}

}
