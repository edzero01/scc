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
 * replica en otro objeto el cual se ira actualizando 
 * dentro de un for y
 * cumpliendo ciertas condiciones de negocio ira 
 * llenando los registros
 * subsecuentes. Cabe destacar que esta lógica aplica 
 * tanto para perdiodos con
 * gracia, sin gracia y con o sin prima recurrente. 
 * Además, se hace uso de
 * metodos de utileria para obtener valores tales
 *  como la tasa y el plazo
 * convertido entre otros.
 *
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
public class CalculaPAPRSG {

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
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CalculaPFPRCG.class);
	/**
	 * Dependencia de path
	 */
	@Autowired
	private PlantillaAmortizacionPR path;
	/**
	 * Utileria para calcular la tabla con plan alemán. en modalidad recurrente sin
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
	public ByteArrayOutputStream calculaPlanAlemanPRSG(SccMxTablaAmtzInDTO tablaAmtzIn, ByteArrayOutputStream plantillaDocx) {
		List<SccMxTablaAmtzValorDTO> tablaAmtzValorPAPRSG = new ArrayList<>();
		SccMxTablaAmtzValorDTO valorActualPAPRSG = new SccMxTablaAmtzValorDTO();
		SccMxTablaAmtzValorDTO valorActualGemeloPAPRSG = new SccMxTablaAmtzValorDTO();
		SccMxTablaAmtzValorDTO valorPrevioPAPRSG = new SccMxTablaAmtzValorDTO();
		SccMxUtileriasAmortizacion utileriasPAPRSG = new SccMxUtileriasAmortizacion();
		SccMxUtileriasAmortizacionComplemento utileriasSeguro = new SccMxUtileriasAmortizacionComplemento();
		Double tasaConvertidoPAPRSG = 0.00;
		Integer numeroPagosPAPRSG = tablaAmtzIn.getNumeroPagos();
		String flagTablaPAPRSG = TRUE;
		Integer contadorSemanalSegurosPAPRSG = 0;
		try {
			valorPrevioPAPRSG.setSaldoDeCapital(tablaAmtzIn.getValorCredito());
			tablaAmtzValorPAPRSG.add(0, valorPrevioPAPRSG);
			tasaConvertidoPAPRSG = utileriasSeguro.obtenTasaConvertida(tablaAmtzIn.getPeriodicidad(),
					tablaAmtzIn.getTasaInteresAnual());
			valorActualPAPRSG.setIntereses(tablaAmtzIn.getValorCredito() * (tasaConvertidoPAPRSG / 100));
			valorActualPAPRSG.setCapital(tablaAmtzIn.getValorCredito() / tablaAmtzIn.getNumeroPagos());
			valorActualPAPRSG.setPagoFijo(valorActualPAPRSG.getIntereses() + valorActualPAPRSG.getCapital());
			valorActualPAPRSG.setIvaDeIntereses(valorActualPAPRSG.getIntereses() * 0.16);
			valorActualPAPRSG.setSaldoDeCapital(tablaAmtzIn.getValorCredito() - valorActualPAPRSG.getCapital());
			valorActualPAPRSG.setSeguros(utileriasSeguro.obtenSeguros(tablaAmtzIn.getPeriodicidad(), tablaAmtzIn.getFactorSeguro(),
					tablaAmtzIn.getValorCredito()));
			valorActualPAPRSG.setPagoTotal(
					valorActualPAPRSG.getIvaDeIntereses() + valorActualPAPRSG.getPagoFijo() + valorActualPAPRSG.getSeguros());
			valorActualPAPRSG.setNumeroPagos(1);
			tablaAmtzValorPAPRSG.add(1, valorActualPAPRSG);

			valorActualGemeloPAPRSG.setPagoFijo(valorActualPAPRSG.getPagoFijo());
			valorActualGemeloPAPRSG.setIntereses(valorActualPAPRSG.getIvaDeIntereses());
			valorActualGemeloPAPRSG.setPagoTotal(valorActualPAPRSG.getPagoTotal());
			valorActualGemeloPAPRSG.setIntereses(valorActualPAPRSG.getIntereses());
			valorActualGemeloPAPRSG.setCapital(valorActualPAPRSG.getCapital());
			valorActualGemeloPAPRSG.setSaldoDeCapital(valorActualPAPRSG.getSaldoDeCapital());

			SccMxTablaAmtzValorDTO valorActualizado = new SccMxTablaAmtzValorDTO();
			contadorSemanalSegurosPAPRSG = 2;

			for (int i = 2; i <= numeroPagosPAPRSG; i++) {
				if (contadorSemanalSegurosPAPRSG == 5) {
					contadorSemanalSegurosPAPRSG = 1;
				}
				if (flagTablaPAPRSG.equalsIgnoreCase(TRUE)) {
					valorActualizado.setNumeroPagos(i);
					valorActualizado.setCapital(tablaAmtzIn.getValorCredito() / tablaAmtzIn.getNumeroPagos());
					valorActualizado
							.setSaldoDeCapital(valorActualGemeloPAPRSG.getSaldoDeCapital() - valorActualizado.getCapital());
					valorActualizado.setIntereses(valorActualGemeloPAPRSG.getSaldoDeCapital() * (tasaConvertidoPAPRSG / 100));
					valorActualizado
							.setIvaDeIntereses(valorActualGemeloPAPRSG.getSaldoDeCapital() * (tasaConvertidoPAPRSG / 100) * 0.16);
					valorActualizado.setPagoFijo(valorActualizado.getIntereses() + valorActualizado.getCapital());
					
					valorActualizado.setSeguros(utileriasPAPRSG.obtenPagoSeguro(i, contadorSemanalSegurosPAPRSG, tablaAmtzValorPAPRSG, tablaAmtzIn).getSeguros());
					contadorSemanalSegurosPAPRSG = utileriasPAPRSG.getContadorSemanalSeguros();
					
					valorActualizado.setPagoTotal(valorActualizado.getPagoFijo() + valorActualizado.getIvaDeIntereses()
							+ valorActualizado.getSeguros());
					flagTablaPAPRSG = FALSE;
				}
				if (flagTablaPAPRSG.equalsIgnoreCase(FALSE)) {
					SccMxTablaAmtzValorDTO valorActualizadoGemelo = new SccMxTablaAmtzValorDTO();
					valorActualizadoGemelo.setNumeroPagos(valorActualizado.getNumeroPagos());
					valorActualizadoGemelo.setCapital(valorActualizado.getCapital());
					valorActualizadoGemelo.setSaldoDeCapital(valorActualizado.getSaldoDeCapital());
					valorActualizadoGemelo.setIntereses(valorActualizado.getIntereses());
					valorActualizadoGemelo.setPagoFijo(valorActualizado.getPagoFijo());
					valorActualizadoGemelo.setIvaDeIntereses(valorActualizado.getIvaDeIntereses());
					valorActualizadoGemelo.setSeguros(valorActualizado.getSeguros());
					valorActualizadoGemelo.setPagoTotal(valorActualizado.getPagoTotal());

					valorActualGemeloPAPRSG.setPagoFijo(valorActualizadoGemelo.getPagoFijo());
					valorActualGemeloPAPRSG.setCapital(valorActualizadoGemelo.getCapital());
					valorActualGemeloPAPRSG.setSaldoDeCapital(valorActualizadoGemelo.getSaldoDeCapital());
					valorActualGemeloPAPRSG.setIntereses(valorActualizadoGemelo.getIntereses());
					valorActualGemeloPAPRSG.setIvaDeIntereses(valorActualizadoGemelo.getIvaDeIntereses());
					valorActualGemeloPAPRSG.setPagoTotal(valorActualizadoGemelo.getPagoTotal());
					valorActualGemeloPAPRSG.setSeguros(valorActualizadoGemelo.getSeguros());
					tablaAmtzValorPAPRSG.add(i, valorActualizadoGemelo);
					flagTablaPAPRSG = TRUE;
				}
			}

		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
		
		return path.docAmortizacion(
				plantillaDocx,
				tablaAmtzValorPAPRSG, tablaAmtzIn);
	}

}
