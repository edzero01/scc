package mx.isban.scc.utilerias;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import mx.isban.scc.model.dto.SccMxTablaAmtzInDTO;
import mx.isban.scc.model.dto.SccMxTablaAmtzValorDTO;
import mx.isban.scc.utilerias.plantillas.PlantillaAmortizacionPU;

/**
 * Clase para calculo de tabla de amortizacion plan aleman dadas las reglas de
 * negocio brindadas por Santander. Se maneja el llenado de un primer registro,
 * subsecuentemente se maneja el llenado del segundo registro y el mismo se
 * replica en otro objeto el cual se ira actualizando dentro de un for y
 * cumpliendo ciertas condiciones de negocio ira llenando los registros
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
@ManagedBean
public class CalculaPAPUSG {
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
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CalculaPAPUSG.class);
	/**
	 * Dependencia de path
	 */
	@Autowired
	private PlantillaAmortizacionPU path;
	/**
	 * Utileria para calcular la tabla con plan alemán en modalidad prima unica sin
	 * gracia
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
	public ByteArrayOutputStream calculaPlanAlemanPUSG(SccMxTablaAmtzInDTO tablaAmtzIn, ByteArrayOutputStream plantillaDocx) {
		List<SccMxTablaAmtzValorDTO> tablaAmtzValor = new ArrayList<>();
		SccMxTablaAmtzValorDTO valorActual = new SccMxTablaAmtzValorDTO();
		SccMxTablaAmtzValorDTO valorActualGemelo = new SccMxTablaAmtzValorDTO();
		SccMxTablaAmtzValorDTO valorPrevio = new SccMxTablaAmtzValorDTO();
		SccMxUtileriasAmortizacionComplemento utilerias = new SccMxUtileriasAmortizacionComplemento();
		Double tasaConvertido = 0.00;
		Integer numeroPagos = tablaAmtzIn.getNumeroPagos();
		String flagTabla = TRUE;
		try {
			valorPrevio.setSaldoDeCapital(tablaAmtzIn.getValorCredito());
			tablaAmtzValor.add(0, valorPrevio);
			tasaConvertido = utilerias.obtenTasaConvertida(tablaAmtzIn.getPeriodicidad(),
					tablaAmtzIn.getTasaInteresAnual());
			valorActual.setIntereses(tablaAmtzIn.getValorCredito() * (tasaConvertido / 100));
			valorActual.setCapital(tablaAmtzIn.getValorCredito() / tablaAmtzIn.getNumeroPagos());
			valorActual.setPagoFijo(valorActual.getIntereses() + valorActual.getCapital());
			valorActual.setIvaDeIntereses(valorActual.getIntereses() * 0.16);
			valorActual.setPagoTotal(valorActual.getIvaDeIntereses() + valorActual.getPagoFijo());
			valorActual.setSaldoDeCapital(tablaAmtzIn.getValorCredito() - valorActual.getCapital());
			valorActual.setNumeroPagos(1);
			tablaAmtzValor.add(1, valorActual);
			
			valorActualGemelo.setPagoFijo(valorActual.getPagoFijo());
			valorActualGemelo.setIntereses(valorActual.getIvaDeIntereses());
			valorActualGemelo.setPagoTotal(valorActual.getPagoTotal());
			valorActualGemelo.setIntereses(valorActual.getIntereses());
			valorActualGemelo.setCapital(valorActual.getCapital());
			valorActualGemelo.setSaldoDeCapital(valorActual.getSaldoDeCapital());

			SccMxTablaAmtzValorDTO valorActualizado = new SccMxTablaAmtzValorDTO();
			for (int i = 2; i <= numeroPagos; i++) {
				if (flagTabla.equalsIgnoreCase(TRUE)) {
					valorActualizado.setNumeroPagos(i);
					valorActualizado.setIntereses(valorActualGemelo.getSaldoDeCapital() * (tasaConvertido / 100));
					valorActualizado.setCapital(tablaAmtzIn.getValorCredito() / tablaAmtzIn.getNumeroPagos());
					valorActualizado
							.setSaldoDeCapital(valorActualGemelo.getSaldoDeCapital() - valorActualGemelo.getCapital());
					valorActualizado.setPagoFijo(valorActualizado.getIntereses() + valorActualizado.getCapital());
					valorActualizado.setIvaDeIntereses(valorActualizado.getIntereses() * 0.16);
					valorActualizado
							.setPagoTotal(valorActualizado.getIvaDeIntereses() + valorActualizado.getPagoFijo());
					flagTabla = FALSE;
				}
				if (flagTabla.equalsIgnoreCase(FALSE)) {
					SccMxTablaAmtzValorDTO valorActualizadoGemelo = new SccMxTablaAmtzValorDTO();
					valorActualizadoGemelo.setNumeroPagos(valorActualizado.getNumeroPagos());
					valorActualizadoGemelo.setCapital(valorActualizado.getCapital());
					valorActualizadoGemelo.setSaldoDeCapital(valorActualizado.getSaldoDeCapital());
					valorActualizadoGemelo.setIntereses(valorActualizado.getIntereses());
					valorActualizadoGemelo.setPagoFijo(valorActualizado.getPagoFijo());
					valorActualizadoGemelo.setIvaDeIntereses(valorActualizado.getIvaDeIntereses());
					valorActualizadoGemelo.setPagoTotal(valorActualizado.getPagoTotal());

					valorActualGemelo.setPagoFijo(valorActualizadoGemelo.getPagoFijo());
					valorActualGemelo.setCapital(valorActualizadoGemelo.getCapital());
					valorActualGemelo.setSaldoDeCapital(valorActualizadoGemelo.getSaldoDeCapital());
					valorActualGemelo.setIntereses(valorActualizadoGemelo.getIntereses());
					valorActualGemelo.setIvaDeIntereses(valorActualizadoGemelo.getIvaDeIntereses());
					valorActualGemelo.setPagoTotal(valorActualizadoGemelo.getPagoTotal());
					tablaAmtzValor.add(i, valorActualizadoGemelo);
					flagTabla = TRUE;
				}
			}

		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}

		return path.docAmortizacion(
				plantillaDocx,
				tablaAmtzValor, tablaAmtzIn);
	}
}
