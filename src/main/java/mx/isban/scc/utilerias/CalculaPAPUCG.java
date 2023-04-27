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
public class CalculaPAPUCG {
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
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CalculaPAPUCG.class);
	/**
	 * Dependencia de path
	 */
	@Autowired
	private PlantillaAmortizacionPU path;
	/**
	 * Utileria para calcular la tabla con plan alemán en modalidad prima unica con
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
	public ByteArrayOutputStream calculaPlanAlemanPUCG(SccMxTablaAmtzInDTO tablaAmtzIn, ByteArrayOutputStream plantillaDocx) {
		List<SccMxTablaAmtzValorDTO> tablaAmtzValorPAPUCG = new ArrayList<>();
		SccMxTablaAmtzValorDTO valorActualPAPUCG = new SccMxTablaAmtzValorDTO();
		SccMxTablaAmtzValorDTO valorActualGemeloPAPUCG = new SccMxTablaAmtzValorDTO();
		SccMxTablaAmtzValorDTO valorPAPUCG = new SccMxTablaAmtzValorDTO();
		SccMxTablaAmtzValorDTO valorPrevioPAPUCG = new SccMxTablaAmtzValorDTO();
		SccMxUtileriasAmortizacionComplemento utileriasPAPUCG= new SccMxUtileriasAmortizacionComplemento();
		Double tasaConvertidoPAPUCG = 0.00;
		Integer numeroPagosPAPUCG = tablaAmtzIn.getNumeroPagos();
		String flagTablaPAPUCG = TRUE;
		Integer manejaGraciaPAPUCG = 0;
		try {
			valorPrevioPAPUCG.setSaldoDeCapital(tablaAmtzIn.getValorCredito());
			tablaAmtzValorPAPUCG.add(0, valorPrevioPAPUCG);
			tasaConvertidoPAPUCG = utileriasPAPUCG.obtenTasaConvertida(tablaAmtzIn.getPeriodicidad(),
					tablaAmtzIn.getTasaInteresAnual());
			valorActualPAPUCG.setIntereses(tablaAmtzIn.getValorCredito() * (tasaConvertidoPAPUCG / 100));
			valorActualPAPUCG.setCapital(tablaAmtzIn.getValorCredito() / tablaAmtzIn.getNumeroPagos());
			valorActualPAPUCG.setPagoFijo(valorActualPAPUCG.getIntereses() + valorActualPAPUCG.getCapital());
			valorActualPAPUCG.setIvaDeIntereses(valorActualPAPUCG.getIntereses() * 0.16);
			valorActualPAPUCG.setPagoTotal(valorActualPAPUCG.getIvaDeIntereses() + valorActualPAPUCG.getPagoFijo());
			valorActualPAPUCG.setSaldoDeCapital(tablaAmtzIn.getValorCredito() - valorActualPAPUCG.getCapital());
			valorActualPAPUCG.setNumeroPagos(1);
			manejaGraciaPAPUCG = utileriasPAPUCG.calculaPeriodosGracia(tablaAmtzIn.getPeriodicidad());
			tablaAmtzIn.setNumeroPagosSinSkip(numeroPagosPAPUCG - manejaGraciaPAPUCG);
			tablaAmtzIn.setPlazoMesesSinSkip(tablaAmtzIn.getPlazo() - 1);
			SccMxTablaAmtzValorDTO valorActualGracia = new SccMxTablaAmtzValorDTO();

			for (int i = 1; i <= manejaGraciaPAPUCG; i++) {

				if (flagTablaPAPUCG.equalsIgnoreCase(TRUE)) {
					valorActualGracia.setCapital(0.00);
					valorActualGracia.setPagoFijo(valorActualPAPUCG.getIntereses());
					valorActualGracia.setIntereses(valorActualPAPUCG.getIntereses());
					valorActualGracia.setSaldoDeCapital(tablaAmtzIn.getValorCredito());
					valorActualGracia.setIvaDeIntereses(tablaAmtzIn.getValorCredito() * (tasaConvertidoPAPUCG / 100) * 0.16);
					valorActualGracia
							.setPagoTotal(valorActualGracia.getPagoFijo() + valorActualGracia.getIvaDeIntereses());
					valorActualGracia.setNumeroPagos(i);
					flagTablaPAPUCG = FALSE;
				}
				if (flagTablaPAPUCG.equalsIgnoreCase(FALSE)) {
					SccMxTablaAmtzValorDTO valorActualizadoGracia = new SccMxTablaAmtzValorDTO();
					valorActualizadoGracia.setCapital(0.00);
					valorActualizadoGracia.setPagoFijo(valorActualPAPUCG.getIntereses());
					valorActualizadoGracia.setIntereses(valorActualPAPUCG.getIntereses());
					valorActualizadoGracia.setSaldoDeCapital(tablaAmtzIn.getValorCredito());
					valorActualizadoGracia
							.setIvaDeIntereses(tablaAmtzIn.getValorCredito() * (tasaConvertidoPAPUCG / 100) * 0.16);
					valorActualizadoGracia
							.setPagoTotal(valorActualGracia.getPagoFijo() + valorActualPAPUCG.getIvaDeIntereses());
					valorActualizadoGracia.setNumeroPagos(i);

					valorActualPAPUCG.setCapital(0.00);
					valorActualPAPUCG.setPagoFijo(valorActualizadoGracia.getPagoFijo());
					valorActualPAPUCG.setSaldoDeCapital(valorActualizadoGracia.getSaldoDeCapital());
					valorActualPAPUCG.setIvaDeIntereses(valorActualizadoGracia.getIvaDeIntereses());

					valorActualPAPUCG.setPagoTotal(valorActualizadoGracia.getPagoTotal());
					tablaAmtzValorPAPUCG.add(i, valorActualizadoGracia);
					flagTablaPAPUCG = TRUE;
				}
			}

			valorActualGemeloPAPUCG.setNumeroPagos(manejaGraciaPAPUCG + 1);
			valorActualGemeloPAPUCG.setIntereses(valorActualPAPUCG.getIntereses());
			valorActualGemeloPAPUCG.setCapital(tablaAmtzIn.getValorCredito() / tablaAmtzIn.getNumeroPagosSinSkip());
			valorActualGemeloPAPUCG.setPagoFijo(valorActualGemeloPAPUCG.getIntereses() + valorActualGemeloPAPUCG.getCapital());
			valorActualGemeloPAPUCG.setIvaDeIntereses(valorActualPAPUCG.getIvaDeIntereses());
			valorActualGemeloPAPUCG.setPagoTotal(valorActualPAPUCG.getIvaDeIntereses() + valorActualGemeloPAPUCG.getPagoFijo());
			valorActualGemeloPAPUCG.setSaldoDeCapital(tablaAmtzIn.getValorCredito() - valorActualGemeloPAPUCG.getCapital());
			
			valorPAPUCG.setNumeroPagos(manejaGraciaPAPUCG + 1);
			valorPAPUCG.setIntereses(valorActualPAPUCG.getIntereses());
			valorPAPUCG.setCapital(tablaAmtzIn.getValorCredito() / tablaAmtzIn.getNumeroPagosSinSkip());
			valorPAPUCG.setPagoFijo(valorActualGemeloPAPUCG.getIntereses() + valorActualGemeloPAPUCG.getCapital());
			valorPAPUCG.setIvaDeIntereses(valorActualPAPUCG.getIvaDeIntereses());
			valorPAPUCG.setPagoTotal(valorActualPAPUCG.getIvaDeIntereses() + valorActualGemeloPAPUCG.getPagoFijo());
			valorPAPUCG.setSaldoDeCapital(tablaAmtzIn.getValorCredito() - valorActualGemeloPAPUCG.getCapital());
			

			tablaAmtzValorPAPUCG.add(manejaGraciaPAPUCG + 1, valorPAPUCG);
			tablaAmtzValorPAPUCG = llenaTabla(manejaGraciaPAPUCG, numeroPagosPAPUCG, flagTablaPAPUCG, valorActualGemeloPAPUCG, tablaAmtzIn,
					tasaConvertidoPAPUCG, tablaAmtzValorPAPUCG);

			
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
		return path.docAmortizacion(
				plantillaDocx,
				tablaAmtzValorPAPUCG, tablaAmtzIn);
	}
	/**
	 * Metodo privado para llenar registros comunes
	 * @param manejaGracia
	 * indicador pagos gracia
	 * @param numeroPagos
	 * numero de pagos
	 * @param flagTabla
	 * indicador registro nuevo
	 * @param valorActualGemelo
	 * valor actual copia
	 * @param tablaAmtzIn
	 * valores de entrada
	 * @param tasaConvertido
	 * tasa convertida
	 * @param tablaAmtzValor
	 * tabla de amortizacion
	 * @return tablaAmtzValor
	 * tabla de amortizacion
	 */
	private List<SccMxTablaAmtzValorDTO> llenaTabla(Integer manejaGracia, Integer numeroPagos, String flagTabla, 
			SccMxTablaAmtzValorDTO valorActualGemelo, SccMxTablaAmtzInDTO tablaAmtzIn, Double tasaConvertido ,List<SccMxTablaAmtzValorDTO> tablaAmtzValor) {
		SccMxTablaAmtzValorDTO valorActualizadoPAPUCG = new SccMxTablaAmtzValorDTO();
		for (int i = manejaGracia + 2; i <= numeroPagos; i++) {

			if (flagTabla.equalsIgnoreCase(TRUE)) {
				valorActualizadoPAPUCG.setNumeroPagos(i);
				valorActualizadoPAPUCG.setIntereses(valorActualGemelo.getSaldoDeCapital() * (tasaConvertido / 100));
				valorActualizadoPAPUCG
						.setSaldoDeCapital(valorActualGemelo.getSaldoDeCapital() - valorActualGemelo.getCapital());
				valorActualizadoPAPUCG.setCapital(tablaAmtzIn.getValorCredito() / tablaAmtzIn.getNumeroPagosSinSkip());
				valorActualizadoPAPUCG.setPagoFijo(valorActualizadoPAPUCG.getIntereses() + valorActualGemelo.getCapital());
				valorActualizadoPAPUCG.setIvaDeIntereses(valorActualizadoPAPUCG.getIntereses() * 0.16);
				valorActualizadoPAPUCG
						.setPagoTotal(valorActualizadoPAPUCG.getIvaDeIntereses() + valorActualizadoPAPUCG.getPagoFijo());
				flagTabla = FALSE;
			}
			if (flagTabla.equalsIgnoreCase(FALSE)) {
				SccMxTablaAmtzValorDTO valorActualizadoGemelo = new SccMxTablaAmtzValorDTO();
				valorActualizadoGemelo.setNumeroPagos(valorActualizadoPAPUCG.getNumeroPagos());
				valorActualizadoGemelo.setCapital(valorActualizadoPAPUCG.getCapital());
				valorActualizadoGemelo.setSaldoDeCapital(valorActualizadoPAPUCG.getSaldoDeCapital());
				valorActualizadoGemelo.setIntereses(valorActualizadoPAPUCG.getIntereses());
				valorActualizadoGemelo.setPagoFijo(valorActualizadoPAPUCG.getPagoFijo());
				valorActualizadoGemelo.setIvaDeIntereses(valorActualizadoPAPUCG.getIvaDeIntereses());
				valorActualizadoGemelo.setPagoTotal(valorActualizadoPAPUCG.getPagoTotal());

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
		return tablaAmtzValor;
	}
}
