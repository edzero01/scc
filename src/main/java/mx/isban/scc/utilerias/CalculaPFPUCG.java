package mx.isban.scc.utilerias;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;

import mx.isban.scc.model.dto.SccMxTablaAmtzInDTO;
import mx.isban.scc.model.dto.SccMxTablaAmtzValorDTO;
import mx.isban.scc.utilerias.plantillas.PlantillaAmortizacionPR;

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
 * gracia, sin gracia y con o sin prima recurrente. 
 * 
 * Además, se hace uso de metodos de utileria para obtener valores 
 * tales como la tasa y el plazo convertido entre otros.
 * 
 * Fábrica de software GlobalHitss Mayo 2019
 * 
 * @author Christopher Espina Riveros
 */
@ManagedBean
public class CalculaPFPUCG {

	/**
	 * Constante private static final de clase, del tipo Logger con un solo espacio 
	 * de memoria e inmutable con la finalidad de registrar el log de la clase 
	 * del tipo CalculaPFPRCG
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CalculaPFPRCG.class);
	/**
	 * Dependencia de path
	 */
	@Autowired
	private PlantillaAmortizacionPR path;
	/**
	 * Método de utileria que sirve y se usa para calcular la información de la tabla 
	 * de amortizacióncon para el plan alemán en modalidad prima unica congracia
	 * 
	 * Además de lo mencionado éste método inicializa ciertas variables.
	 * 
	 * List of SccMxTablaAmtzValorDTO tblAmtzValor = new ArrayList of SccMxTablaAmtzValorDTO();
	 * SccMxTablaAmtzValorDTO valActual = new SccMxTablaAmtzValorDTO();
	 * SccMxTablaAmtzValorDTO valActualGemelo = new SccMxTablaAmtzValorDTO();
	 * SccMxTablaAmtzValorDTO valActualGemeloGracia = new SccMxTablaAmtzValorDTO();
	 * SccMxTablaAmtzValorDTO valPrevio = new SccMxTablaAmtzValorDTO();
	 * SccMxUtileriasAmortizacion utils = new SccMxUtileriasAmortizacion();
	 * 
	 * 
	 * @author Christopher Espina Riveros
	 * @param tablaAmtzIn 
	 * variable que recibe los datos de entrada para la tabla de amortización 
	 * y es un parámetro de entrada 
	 * @param plantillaDocx
	 * path origen de los datos
	 * @return tablaAmtzValor 
	 * variable que devuelve la información de la tabla de amortizacion
	 * y es un parámetro de salida
	 */
	public ByteArrayOutputStream calculaPlanFrancesPRCG(SccMxTablaAmtzInDTO tablaAmtzIn, ByteArrayOutputStream plantillaDocx) {
		List<SccMxTablaAmtzValorDTO> tblAmtzValor = new ArrayList<>();
		SccMxTablaAmtzValorDTO valActual = new SccMxTablaAmtzValorDTO();
		SccMxTablaAmtzValorDTO valActualGemelo = new SccMxTablaAmtzValorDTO();
		SccMxTablaAmtzValorDTO valActualGemeloGracia = new SccMxTablaAmtzValorDTO();
		SccMxTablaAmtzValorDTO valPrevio = new SccMxTablaAmtzValorDTO();
		SccMxUtileriasAmortizacionComplemento utils = new SccMxUtileriasAmortizacionComplemento();
		Double tasaConvertidoPFPUCG = 0.00;
		Double plazoConvertidoPFPUCG = 0.00;
		Double valA = 0.00;
		Double valB = 0.00;
		Double valC = 0.00;
		Double valD = 0.00;
		Double valDividendo = 0.00;
		Integer numeroPagos = tablaAmtzIn.getNumeroPagos();
		String flagTabla = ConstantesTablaAmtz.TRUE;
		Integer manejaGracia = 0;
		try {
			valPrevio.setSaldoDeCapital(tablaAmtzIn.getValorCredito());
			tblAmtzValor.add(0, valPrevio);
			tasaConvertidoPFPUCG = utils.obtenTasaConvertida(tablaAmtzIn.getPeriodicidad(),
					tablaAmtzIn.getTasaInteresAnual());
			plazoConvertidoPFPUCG = utils.obtenPlazoConvertido(tablaAmtzIn.getPeriodicidad(),
					(tablaAmtzIn.getPlazo() - 1));
			valA = (1 / tasaConvertidoPFPUCG);
			valB = (1 + (tasaConvertidoPFPUCG / 100));
			valB = Math.pow(valB, plazoConvertidoPFPUCG);
			valC = (valB * (tasaConvertidoPFPUCG / 100));
			valD = (1 / valC);
			valDividendo = ((valA * 100) - valD);
			
			valActual.setPagoFijo(tablaAmtzIn.getValorCredito() / valDividendo);
			valActual.setIvaDeIntereses(tablaAmtzIn.getValorCredito() * (tasaConvertidoPFPUCG / 100) * 0.16);
			valActual.setPagoTotal(valActual.getPagoFijo() + valActual.getIvaDeIntereses());
			valActual.setIntereses(tablaAmtzIn.getValorCredito() * (tasaConvertidoPFPUCG / 100));
			valActual.setCapital(valActual.getPagoFijo() - valActual.getIntereses());
			valActual.setSaldoDeCapital(valPrevio.getSaldoDeCapital() - valActual.getCapital());
			valActual.setNumeroPagos(1);
			manejaGracia = utils.calculaPeriodosGracia(tablaAmtzIn.getPeriodicidad());
			tablaAmtzIn.setNumeroPagosSinSkip(numeroPagos - manejaGracia);
			tablaAmtzIn.setPlazoMesesSinSkip(tablaAmtzIn.getPlazo() - 1);
			

			flagTabla = primerFor(manejaGracia, tasaConvertidoPFPUCG, valActual, flagTabla, tablaAmtzIn, tblAmtzValor );

			valActualGemelo.setNumeroPagos(manejaGracia + 1);
			valActualGemelo.setIvaDeIntereses(tablaAmtzIn.getValorCredito() * (tasaConvertidoPFPUCG / 100) * 0.16);
			valActualGemelo.setIntereses(valActual.getIntereses());
			valActualGemelo.setPagoFijo(utils.calculaPagoFijo(tasaConvertidoPFPUCG, tablaAmtzIn.getNumeroPagosSinSkip(),
					tablaAmtzIn.getValorCredito()));
			valActualGemelo.setPagoTotal(valActualGemelo.getPagoFijo() + valActualGemelo.getIvaDeIntereses());
			valActualGemelo.setCapital(valActualGemelo.getPagoFijo() - valActualGemelo.getIntereses());
			valActualGemelo.setSaldoDeCapital(tablaAmtzIn.getValorCredito() - valActualGemelo.getCapital());

			valActualGemeloGracia.setNumeroPagos(manejaGracia + 1);
			valActualGemeloGracia.setIvaDeIntereses(tablaAmtzIn.getValorCredito() * (tasaConvertidoPFPUCG / 100) * 0.16);
			valActualGemeloGracia.setIntereses(valActual.getIntereses());
			valActualGemeloGracia.setPagoFijo(utils.calculaPagoFijo(tasaConvertidoPFPUCG,
					tablaAmtzIn.getNumeroPagosSinSkip(), tablaAmtzIn.getValorCredito()));
			valActualGemeloGracia
					.setPagoTotal(valActualGemelo.getPagoFijo() + valActualGemelo.getIvaDeIntereses());
			valActualGemeloGracia.setCapital(valActualGemelo.getPagoFijo() - valActualGemelo.getIntereses());
			valActualGemeloGracia.setSaldoDeCapital(tablaAmtzIn.getValorCredito() - valActualGemelo.getCapital());
			tblAmtzValor.add(manejaGracia + 1, valActualGemeloGracia);

			flagTabla = segundoFor(numeroPagos, Pair.of(tasaConvertidoPFPUCG,manejaGracia), flagTabla, valActualGemelo, tblAmtzValor);
			
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
		return path.docAmortizacion(
				plantillaDocx,
				tblAmtzValor, tablaAmtzIn);	
		}
	
	/**
	 * Método de utilería que sirve para realizar cálculos para la tabla de amortización
	 * 
	 * @param numeroPagos variable que sirve para indicar el número de pagos
	 * y es un parámetro de entrada
	 * @param tasaYGracia variable de tipo Tupla parametrizada con un double
	 * y un integer y que se usa para pasar la información de la tasa y
	 * el valor de la variable maneja gracia ademas de ser
	 * un parámetro de entrada
	 * @param flagTabla variable que se usa como bandera para indicar el 
	 * estatus del proceso en cierto momento
	 * y es un parámetro de entrada
	 * @param valorActualGemelo variable que se usa para pasar el valor espejo
	 * de la variable del valor actual que además se usa
	 * como un parámetro de entrada
	 * @param tablaAmtzValor variable qie sirve para pasar la información
	 * de los datos de los valores de la tabla de amoetización
	 * y es un parámetro de entrada
	 * @return el metodo devuelve la información de la bander que se paso modificada
	 * y es un parámetro de salida
	 */
	private String segundoFor(Integer numeroPagos, Pair<Double, Integer> tasaYGracia, String flagTabla,
						SccMxTablaAmtzValorDTO valorActualGemelo, List<SccMxTablaAmtzValorDTO> tablaAmtzValor) {
		SccMxTablaAmtzValorDTO valorActualizado = new SccMxTablaAmtzValorDTO();
		Double tasaConvertido = tasaYGracia.getFirst();
		Integer manejaGracia = tasaYGracia.getSecond();
		for (int i = manejaGracia + 2; i <= numeroPagos; i++) {
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
				valorActualizado
						.setPagoTotal(valorActualizado.getPagoFijo() + valorActualizado.getIvaDeIntereses());
				flagTabla = ConstantesTablaAmtz.FALSE;
			}
			CalculosUtil.calcula(flagTabla, valorActualizado, valorActualGemelo, i, tablaAmtzValor);

		}		
		return flagTabla;
	}

	/**
	 * Este es un método de utilería que se usa para el cálulo de las ablas de amortización 
	 * y recibe varios parámetros 
	 * @param manejaGracia variable de tipo Integer que indica si se va amanejar 
	 * la gracia y es un parámetro de entrada
	 * @param tasaConvertido variable de entrda que se usa para pasar el valor de la tasa
	 * y es un parámetro de entrada
	 * @param valorActual variable que se usa para pasar el valor actual 
	 * y es un parámetro de entrada
	 * @param flagTabla variable que se usa como bandera del estatus del proceso
	 * y es un parámetro de entrada
	 * @param tablaAmtzIn variable que se usa pra pasar los datps de la tabla de amortización
	 * y es un parámetro de entrada
	 * @param tablaAmtzValor variable que se usa para pasar los valores de la tabla de amortización
	 * y es un parámetro de entrada
	 * @return devuelve el string con el valor de la bandera que se uso en el proceso
	 * y es un parámetro de salida
	 */
	private String primerFor(Integer manejaGracia, Double tasaConvertido, SccMxTablaAmtzValorDTO valorActual, String flagTabla, SccMxTablaAmtzInDTO tablaAmtzIn, List<SccMxTablaAmtzValorDTO> tablaAmtzValor) {

		SccMxTablaAmtzValorDTO valorActualGracia = new SccMxTablaAmtzValorDTO();
		for (int i = 1; i <= manejaGracia; i++) {
			if (flagTabla.equalsIgnoreCase(ConstantesTablaAmtz.TRUE)) {
				valorActualGracia.setCapital(0.00);
				valorActualGracia.setPagoFijo(valorActual.getIntereses());
				valorActualGracia.setIntereses(valorActual.getIntereses());
				valorActualGracia.setSaldoDeCapital(tablaAmtzIn.getValorCredito());
				valorActualGracia.setIvaDeIntereses(tablaAmtzIn.getValorCredito() * (tasaConvertido / 100) * 0.16);
				valorActualGracia
						.setPagoTotal(valorActualGracia.getPagoFijo() + valorActualGracia.getIvaDeIntereses());
				valorActualGracia.setNumeroPagos(i);
				flagTabla = ConstantesTablaAmtz.FALSE;
			}
			if (flagTabla.equalsIgnoreCase(ConstantesTablaAmtz.FALSE)) {
				SccMxTablaAmtzValorDTO valorActualizadoGraciaPFPUCG = new SccMxTablaAmtzValorDTO();
				valorActualizadoGraciaPFPUCG.setCapital(0.00);
				valorActualizadoGraciaPFPUCG.setPagoFijo(valorActual.getIntereses());
				valorActualizadoGraciaPFPUCG.setIntereses(valorActual.getIntereses());
				valorActualizadoGraciaPFPUCG.setSaldoDeCapital(tablaAmtzIn.getValorCredito());
				valorActualizadoGraciaPFPUCG
						.setIvaDeIntereses(tablaAmtzIn.getValorCredito() * (tasaConvertido / 100) * 0.16);
				valorActualizadoGraciaPFPUCG
						.setPagoTotal(valorActualGracia.getPagoFijo() + valorActual.getIvaDeIntereses());
				valorActualizadoGraciaPFPUCG.setNumeroPagos(i);

				valorActual.setCapital(0.00);
				valorActual.setPagoFijo(valorActualizadoGraciaPFPUCG.getPagoFijo());
				valorActual.setSaldoDeCapital(valorActualizadoGraciaPFPUCG.getSaldoDeCapital());
				valorActual.setIvaDeIntereses(valorActualizadoGraciaPFPUCG.getIvaDeIntereses());

				valorActual.setPagoTotal(valorActualizadoGraciaPFPUCG.getPagoTotal());
				tablaAmtzValor.add(i, valorActualizadoGraciaPFPUCG);
				flagTabla = ConstantesTablaAmtz.TRUE;
			}
		}
		return flagTabla;
	}

}
