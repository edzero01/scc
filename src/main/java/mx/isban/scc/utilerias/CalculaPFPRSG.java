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
 * Clase para calculo de tabla de amortizacion plan frances dadas las reglas de
 * negocio brindadas por Santander. Se maneja el llenado de un primer registro,
 * 
 * subsecuentemente se maneja el llenado del segundo registro y el mismo se
 * replica en otro objeto el cual se ira actualizando dentro de un for y
 * cumpliendo ciertas condiciones de negocio ira llenando los registros
 * subsecuentes. 
 * 
 * Cabe destacar que esta lógica aplica tanto para perdiodos con
 * gracia, sin gracia y con o sin prima recurrente. Además, se hace uso de
 * metodos de utileria para obtener valores tales como la tasa y el plazo
 * convertido entre otros.
 * 
 * Fábrica de software GlobalHitss Mayo 2019
 * 
 * @author Christopher Espina Riveros
 */
@ManagedBean
public class CalculaPFPRSG {
	
	/**
	 * Constante private static final de clase del tipo Logger, con un solo espacio
	 * de memoria e inmutable con la finalidar de generar registros de log del
	 * tipo CalculaPFPRCG dentro de ésta clase
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CalculaPFPRCG.class);

	/**
	 * Dependencia de path
	 */
	@Autowired
	private PlantillaAmortizacionPR path;
	/**
	 * Método de Utileria que sirve y se usa para calcular la información de la tabla de
	 * amortización con plan alemán en modalidad prima recurrente y sin gracia
	 * 
	 * Este método se entrega en Sprint uno por solicitud del usuario
	 * hace uso de las variable siguiente.
	 * 
	 * List of SccMxTablaAmtzValorDTO tablaAmtzValor = new ArrayList of SccMxTablaAmtzValorDTO();
	 * SccMxTablaAmtzValorDTO valorActual = new SccMxTablaAmtzValorDTO();
	 * SccMxTablaAmtzValorDTO valorActualGemelo = new SccMxTablaAmtzValorDTO();
	 * SccMxTablaAmtzValorDTO valorPrevio = new SccMxTablaAmtzValorDTO();
	 * SccMxUtileriasAmortizacion utilerias = new SccMxUtileriasAmortizacion();
	 * 
	 * Además de realizar las asignaciones siguientes.
	 * 
	 * Double tasaConvertido = 0.00;
	 * Integer numeroPagos = tablaAmtzIn.getNumeroPagos();
	 * String flagTabla = ConstantesTablaAmtz.TRUE;
	 * Integer contadorSemanalSeguros = 0;
	 * 
	 * @author Christopher Espina Riveros
	 * @param tablaAmtzIn 
	 * variable de entrada que recibe datos de entrada para la tabla y es un parámetro de entrada
	 * @param plantillaDocx
	 * path origen de los datos
	 * @return tablaAmtzValor 
	 * devuelve el valor de la tabla de amortizacion  y es un parámetro de salida
	 */
	public ByteArrayOutputStream calculaPlanFrancesPRSG(SccMxTablaAmtzInDTO tablaAmtzIn, ByteArrayOutputStream plantillaDocx) {
		List<SccMxTablaAmtzValorDTO> tablaAmtzValor = new ArrayList<>();
		SccMxTablaAmtzValorDTO valorActual = new SccMxTablaAmtzValorDTO();
		SccMxTablaAmtzValorDTO valorActualGemelo = new SccMxTablaAmtzValorDTO();
		SccMxTablaAmtzValorDTO valorPrevio = new SccMxTablaAmtzValorDTO();
		SccMxUtileriasAmortizacionComplemento utilerias = new SccMxUtileriasAmortizacionComplemento();
		SccMxUtileriasAmortizacion utileriasExtra = new SccMxUtileriasAmortizacion();
		Double tasaConvertido = 0.00;
		Integer numeroPagos = tablaAmtzIn.getNumeroPagos();
		String flagTabla = ConstantesTablaAmtz.TRUE;
		Integer contadorSemanalSeguros = 0;
		try {
			valorPrevio.setSaldoDeCapital(tablaAmtzIn.getValorCredito());
			tablaAmtzValor.add(0, valorPrevio);
			tasaConvertido = utilerias.obtenTasaConvertida(tablaAmtzIn.getPeriodicidad(),
					tablaAmtzIn.getTasaInteresAnual());
			valorActual.setPagoFijo(
					(utilerias.calculaPagoFijo(tasaConvertido, numeroPagos, valorPrevio.getSaldoDeCapital())));
			valorActual.setIvaDeIntereses(tablaAmtzIn.getValorCredito() * (tasaConvertido / 100) * 0.16);
			valorActual.setSeguros(utilerias.obtenSeguros(tablaAmtzIn.getPeriodicidad(), tablaAmtzIn.getFactorSeguro(),
					tablaAmtzIn.getValorCredito()));
			valorActual.setPagoTotal(
					valorActual.getPagoFijo() + valorActual.getIvaDeIntereses() + valorActual.getSeguros());
			valorActual.setIntereses(tablaAmtzIn.getValorCredito() * (tasaConvertido / 100));
			valorActual.setCapital(valorActual.getPagoFijo() - valorActual.getIntereses());
			valorActual.setSaldoDeCapital(valorPrevio.getSaldoDeCapital() - valorActual.getCapital());
			valorActual.setNumeroPagos(1);
			tablaAmtzValor.add(1, valorActual);

			valorActualGemelo.setPagoFijo(valorActual.getPagoFijo());
			valorActualGemelo.setIntereses(valorActual.getIvaDeIntereses());
			valorActualGemelo.setPagoTotal(valorActual.getPagoTotal());
			valorActualGemelo.setIntereses(valorActual.getIntereses());
			valorActualGemelo.setCapital(valorActual.getCapital());
			valorActualGemelo.setSaldoDeCapital(valorActual.getSaldoDeCapital());

			SccMxTablaAmtzValorDTO valorActualizado = new SccMxTablaAmtzValorDTO();
			contadorSemanalSeguros = 2;

			for (int i = 2; i <= numeroPagos; i++) {
				if (contadorSemanalSeguros == 5) {
					contadorSemanalSeguros = 1;
				}
				if (flagTabla.equalsIgnoreCase(ConstantesTablaAmtz.TRUE)) {
					valorActualizado.setNumeroPagos(i);
					valorActualizado.setPagoFijo(valorActualGemelo.getPagoFijo());
					valorActualizado.setCapital(valorActualizado.getPagoFijo()
							- (tasaConvertido / 100) * valorActualGemelo.getSaldoDeCapital());
					valorActualizado
							.setSaldoDeCapital(valorActualGemelo.getSaldoDeCapital() - valorActualizado.getCapital());
					valorActualizado.setIntereses(valorActualGemelo.getSaldoDeCapital() * (tasaConvertido / 100));
					valorActualizado
							.setIvaDeIntereses(valorActualGemelo.getSaldoDeCapital() * (tasaConvertido / 100) * 0.16);
					
					valorActualizado.setSeguros(utileriasExtra.obtenPagoSeguro(i, contadorSemanalSeguros, tablaAmtzValor, tablaAmtzIn).getSeguros());
					contadorSemanalSeguros = utileriasExtra.getContadorSemanalSeguros();

					valorActualizado.setPagoTotal(valorActualizado.getPagoFijo() + valorActualizado.getIvaDeIntereses()
							+ valorActualizado.getSeguros());
					flagTabla = ConstantesTablaAmtz.FALSE;
				}
				if (flagTabla.equalsIgnoreCase(ConstantesTablaAmtz.FALSE)) {
					SccMxTablaAmtzValorDTO valorActualizadoGemelo = new SccMxTablaAmtzValorDTO();
					valorActualizadoGemelo.setNumeroPagos(valorActualizado.getNumeroPagos());
					valorActualizadoGemelo.setCapital(valorActualizado.getCapital());
					valorActualizadoGemelo.setSaldoDeCapital(valorActualizado.getSaldoDeCapital());
					valorActualizadoGemelo.setIntereses(valorActualizado.getIntereses());
					valorActualizadoGemelo.setPagoFijo(valorActualizado.getPagoFijo());
					valorActualizadoGemelo.setIvaDeIntereses(valorActualizado.getIvaDeIntereses());
					valorActualizadoGemelo.setSeguros(valorActualizado.getSeguros());
					valorActualizadoGemelo.setPagoTotal(valorActualizado.getPagoTotal());

					valorActualGemelo.setPagoFijo(valorActualizadoGemelo.getPagoFijo());
					valorActualGemelo.setCapital(valorActualizadoGemelo.getCapital());
					valorActualGemelo.setSaldoDeCapital(valorActualizadoGemelo.getSaldoDeCapital());
					valorActualGemelo.setIntereses(valorActualizadoGemelo.getIntereses());
					valorActualGemelo.setIvaDeIntereses(valorActualizadoGemelo.getIvaDeIntereses());
					valorActualGemelo.setPagoTotal(valorActualizadoGemelo.getPagoTotal());
					valorActualGemelo.setSeguros(valorActualizadoGemelo.getSeguros());
					tablaAmtzValor.add(i, valorActualizadoGemelo);
					flagTabla = ConstantesTablaAmtz.TRUE;
				}

			}

		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
		return  path.docAmortizacion(
				plantillaDocx,
				tablaAmtzValor, tablaAmtzIn);
	}
}
