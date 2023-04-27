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
 * Clase para calculo de tabla de amortizacion plan frances dadas las reglas de
 * negocio brindadas por Santander. 
 * 
 * Se maneja el llenado de un primer registro,
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
 * Fábrica de Software GlobalHitss Mayo 2019
 * 
 * @author Christopher Espina Riveros
 * 
 */
@ManagedBean
public class CalculaPFPUSG {
	/**
	 * Constante private static final del tipo Logger, de  clase CalculaPFPUSG, con un solo espacio de memoria e inmutable con la
	 * finalidar de llevar el registro del log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CalculaPFPUSG.class);
	/**
	 * Dependencia de path
	 */
	@Autowired
	private PlantillaAmortizacionPU path;
	/**
	 * Método de clase y de utileria para calcular la información de la 
	 * tabla de amortización con plan alemán en modalidad prima unica sin
	 * gracia
	 * 
	 * Además de definir dentro las variables siguientes:
	 * 
	 * List of SccMxTablaAmtzValorDTO tablaAmtzValorPFPUSG = new ArrayList of SccMxTablaAmtzValorDTO();
	 * SccMxTablaAmtzValorDTO valorActualPFPUSG = new SccMxTablaAmtzValorDTO();
	 * SccMxTablaAmtzValorDTO valorActualGemeloPFPUSG = new SccMxTablaAmtzValorDTO();
	 * SccMxTablaAmtzValorDTO valorPrevioPFPUSG = new SccMxTablaAmtzValorDTO();
	 * SccMxUtileriasAmortizacion utilerias = new SccMxUtileriasAmortizacion();
	 * 
	 * E inicializar los valores de:
	 * 
	 * Double dividendoPFPUSG = 0.00;
	 * Integer numeroPagosPFPUSG = tablaAmtzIn.getNumeroPagos();
	 * String flagTablaPFPUSG = ConstantesTablaAmtz.TRUE;
	 * 
	 * 
	 * @author Christopher Espina Riveros
	 * @param tablaAmtzIn 
	 * variable que sirve y se usa para recibir los datos que se usarán para la tabla
	 * y que es un parámetro de entrada
	 * @param plantillaDocx
	 * path origen de los datos
	 * @return ByteArrayOutputStream 
	 * variable que devuelve la plantilla con datos de la tabla de amortizacion
	 */
	public ByteArrayOutputStream calculaPlanFrancesPUSG(SccMxTablaAmtzInDTO tablaAmtzIn, ByteArrayOutputStream plantillaDocx) {
		List<SccMxTablaAmtzValorDTO> tablaAmtzValorPFPUSG = new ArrayList<>();
		SccMxTablaAmtzValorDTO valorActualPFPUSG = new SccMxTablaAmtzValorDTO();
		SccMxTablaAmtzValorDTO valorActualGemeloPFPUSG = new SccMxTablaAmtzValorDTO();
		SccMxTablaAmtzValorDTO valorPrevioPFPUSG = new SccMxTablaAmtzValorDTO();
		SccMxUtileriasAmortizacionComplemento utilerias = new SccMxUtileriasAmortizacionComplemento();
		Double tasaConvertidoPFPUSG = 0.00;
		Double plazoConvertidoPFPUSG = 0.00;
		Double valAPFPUSG = 0.00;
		Double valBPFPUSG = 0.00;
		Double valCPFPUSG = 0.00;
		Double valDPFPUSG = 0.00;
		Double dividendoPFPUSG = 0.00;
		Integer numeroPagosPFPUSG = tablaAmtzIn.getNumeroPagos();
		String flagTablaPFPUSG = ConstantesTablaAmtz.TRUE;
		
		try {
			valorPrevioPFPUSG.setSaldoDeCapital(tablaAmtzIn.getValorCredito());
			tablaAmtzValorPFPUSG.add(0, valorPrevioPFPUSG);
			tasaConvertidoPFPUSG = utilerias.obtenTasaConvertida(tablaAmtzIn.getPeriodicidad(),
					tablaAmtzIn.getTasaInteresAnual());
			plazoConvertidoPFPUSG = utilerias.obtenPlazoConvertido(tablaAmtzIn.getPeriodicidad(), tablaAmtzIn.getPlazo());
			valAPFPUSG = (1 / tasaConvertidoPFPUSG);
			valBPFPUSG = (1 + (tasaConvertidoPFPUSG / 100));
			valBPFPUSG = Math.pow(valBPFPUSG, plazoConvertidoPFPUSG);
			valCPFPUSG = (valBPFPUSG * (tasaConvertidoPFPUSG / 100));
			valDPFPUSG = (1 / valCPFPUSG);
			dividendoPFPUSG = ((valAPFPUSG * 100) - valDPFPUSG);

			valorActualPFPUSG.setPagoFijo(tablaAmtzIn.getValorCredito() / dividendoPFPUSG);
			valorActualPFPUSG.setIvaDeIntereses(tablaAmtzIn.getValorCredito() * (tasaConvertidoPFPUSG / 100) * 0.16);
			valorActualPFPUSG.setPagoTotal(valorActualPFPUSG.getPagoFijo() + valorActualPFPUSG.getIvaDeIntereses());
			valorActualPFPUSG.setIntereses(tablaAmtzIn.getValorCredito() * (tasaConvertidoPFPUSG / 100));
			valorActualPFPUSG.setCapital(valorActualPFPUSG.getPagoFijo() - valorActualPFPUSG.getIntereses());
			valorActualPFPUSG.setSaldoDeCapital(valorPrevioPFPUSG.getSaldoDeCapital() - valorActualPFPUSG.getCapital());
			valorActualPFPUSG.setNumeroPagos(1);
			tablaAmtzValorPFPUSG.add(1, valorActualPFPUSG);

			valorActualGemeloPFPUSG.setPagoFijo(valorActualPFPUSG.getPagoFijo());
			valorActualGemeloPFPUSG.setIntereses(valorActualPFPUSG.getIvaDeIntereses());
			valorActualGemeloPFPUSG.setPagoTotal(valorActualPFPUSG.getPagoTotal());
			valorActualGemeloPFPUSG.setIntereses(valorActualPFPUSG.getIntereses());
			valorActualGemeloPFPUSG.setCapital(valorActualPFPUSG.getCapital());
			valorActualGemeloPFPUSG.setSaldoDeCapital(valorActualPFPUSG.getSaldoDeCapital());
			SccMxTablaAmtzValorDTO valorActualizado = new SccMxTablaAmtzValorDTO();

			for (int i = 2; i <= numeroPagosPFPUSG; i++) {
				if (flagTablaPFPUSG.equalsIgnoreCase(ConstantesTablaAmtz.TRUE)) {
					valorActualizado.setNumeroPagos(i);
					valorActualizado.setPagoFijo(valorActualGemeloPFPUSG.getPagoFijo());
					valorActualizado.setCapital(valorActualizado.getPagoFijo()
							- (tasaConvertidoPFPUSG / 100) * valorActualGemeloPFPUSG.getSaldoDeCapital());
					valorActualizado
							.setSaldoDeCapital(valorActualGemeloPFPUSG.getSaldoDeCapital() - valorActualizado.getCapital());
					valorActualizado.setIntereses(valorActualGemeloPFPUSG.getSaldoDeCapital() * (tasaConvertidoPFPUSG / 100));
					valorActualizado
							.setIvaDeIntereses(valorActualGemeloPFPUSG.getSaldoDeCapital() * (tasaConvertidoPFPUSG / 100) * 0.16);
					valorActualizado
							.setPagoTotal(valorActualizado.getPagoFijo() + valorActualizado.getIvaDeIntereses());
					flagTablaPFPUSG = ConstantesTablaAmtz.FALSE;
				}
				if (flagTablaPFPUSG.equalsIgnoreCase(ConstantesTablaAmtz.FALSE)) {
					SccMxTablaAmtzValorDTO valorActualizadoGemelo = new SccMxTablaAmtzValorDTO();
					valorActualizadoGemelo.setNumeroPagos(valorActualizado.getNumeroPagos());
					valorActualizadoGemelo.setCapital(valorActualizado.getCapital());
					valorActualizadoGemelo.setSaldoDeCapital(valorActualizado.getSaldoDeCapital());
					valorActualizadoGemelo.setIntereses(valorActualizado.getIntereses());
					valorActualizadoGemelo.setPagoFijo(valorActualizado.getPagoFijo());
					valorActualizadoGemelo.setIvaDeIntereses(valorActualizado.getIvaDeIntereses());
					valorActualizadoGemelo.setPagoTotal(valorActualizado.getPagoTotal());

					valorActualGemeloPFPUSG.setPagoFijo(valorActualizadoGemelo.getPagoFijo());
					valorActualGemeloPFPUSG.setCapital(valorActualizadoGemelo.getCapital());
					valorActualGemeloPFPUSG.setSaldoDeCapital(valorActualizadoGemelo.getSaldoDeCapital());
					valorActualGemeloPFPUSG.setIntereses(valorActualizadoGemelo.getIntereses());
					valorActualGemeloPFPUSG.setIvaDeIntereses(valorActualizadoGemelo.getIvaDeIntereses());
					valorActualGemeloPFPUSG.setPagoTotal(valorActualizadoGemelo.getPagoTotal());
					tablaAmtzValorPFPUSG.add(i, valorActualizadoGemelo);
					flagTablaPFPUSG = ConstantesTablaAmtz.TRUE;
				}
			}


		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
		return path.docAmortizacion(
				plantillaDocx,
				tablaAmtzValorPFPUSG, tablaAmtzIn);
	}
}
