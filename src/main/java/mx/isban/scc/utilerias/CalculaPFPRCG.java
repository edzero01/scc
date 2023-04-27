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
 * Subsecuentemente se maneja el llenado del segundo registro y el mismo, se replica
 * 
 * Y en otro objeto el cual se ira actualizando dentro de un for y
 * cumpliendo con ciertas condiciones de negocio ira llenando los registros
 * subsecuentes. 
 * 
 * 
 * Cabe destacar que esta lógica aplica tanto para perdiodos con
 * gracia, sin gracia y con o sin prima recurrente. 
 * 
 * Además, se hace uso de metodos de utileria para obtener valores tales 
 * como la tasa y el plazo convertido entre otros.
 * 
 * Además que se ha ido modificando para cuplir con las reglas de sonar en cuanto a 
 * la complejidad ciclómatica y así evitar métodos muy largos
 * 
 * Fábrica de software de GlobalHitss Mayo 2019
 * 
 * @author Christopher Espina Riveros
 */
@ManagedBean
public class CalculaPFPRCG {

	/**
	 * Constante de clase, con un solo espacio de memoria dedicado a calculo de
	 * prima.
	 */
	
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CalculaPFPRCG.class);
	/**
	 * Dependencia de path
	 */
	@Autowired
	private PlantillaAmortizacionPR path;
	/**
	 * Utileria para calcular la tabla con plan alemán en modalidad prima recurrente
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
	public ByteArrayOutputStream calculaPlanFrancesPRCG(SccMxTablaAmtzInDTO tablaAmtzIn, ByteArrayOutputStream plantillaDocx) {
		List<SccMxTablaAmtzValorDTO> tablaAmtzValor = new ArrayList<>();
		SccMxTablaAmtzValorDTO valorActual = new SccMxTablaAmtzValorDTO();
		SccMxTablaAmtzValorDTO valorActualGemelo = new SccMxTablaAmtzValorDTO();
		SccMxTablaAmtzValorDTO valorActualGemeloGracia = new SccMxTablaAmtzValorDTO();
		SccMxTablaAmtzValorDTO valorPrevio = new SccMxTablaAmtzValorDTO();
		SccMxUtileriasAmortizacionComplemento utilerias = new SccMxUtileriasAmortizacionComplemento();
		Double tasaConvertido = 0.00;
		Double plazoConvertido = 0.00;
		Double a = 0.00;
		Double b = 0.00;
		Double c = 0.00;
		Double d = 0.00;
		Double dividendo = 0.00;
		Integer numeroPagos = tablaAmtzIn.getNumeroPagos();
		String flagTabla = ConstantesTablaAmtz.TRUE;
		Integer manejaGracia = 0;
		Integer contadorSemanalSeguros = 0;
		try {
			valorPrevio.setSaldoDeCapital(tablaAmtzIn.getValorCredito());
			tablaAmtzValor.add(0, valorPrevio);
			tasaConvertido = utilerias.obtenTasaConvertida(tablaAmtzIn.getPeriodicidad(),
					tablaAmtzIn.getTasaInteresAnual());
			plazoConvertido = utilerias.obtenPlazoConvertido(tablaAmtzIn.getPeriodicidad(), tablaAmtzIn.getPlazo());
			a = (1 / tasaConvertido);
			b = (1 + (tasaConvertido / 100));
			b = Math.pow(b, plazoConvertido);
			c = (b * (tasaConvertido / 100));
			d = (1 / c);
			dividendo = ((a * 100) - d);
			valorActual.setPagoFijo(tablaAmtzIn.getValorCredito() / dividendo);
			valorActual.setIvaDeIntereses(tablaAmtzIn.getValorCredito() * (tasaConvertido / 100) * 0.16);
			valorActual.setSeguros(utilerias.obtenSeguros(tablaAmtzIn.getPeriodicidad(), tablaAmtzIn.getFactorSeguro(),
					tablaAmtzIn.getValorCredito()));
			valorActual.setPagoTotal(
					valorActual.getPagoFijo() + valorActual.getIvaDeIntereses() + valorActual.getSeguros());
			valorActual.setIntereses(tablaAmtzIn.getValorCredito() * (tasaConvertido / 100));
			valorActual.setCapital(valorActual.getPagoFijo() - valorActual.getIntereses());
			valorActual.setSaldoDeCapital(valorPrevio.getSaldoDeCapital() - valorActual.getCapital());
			valorActual.setNumeroPagos(1);
			manejaGracia = utilerias.calculaPeriodosGracia(tablaAmtzIn.getPeriodicidad());
			tablaAmtzIn.setNumeroPagosSinSkip(numeroPagos - manejaGracia);
			tablaAmtzIn.setPlazoMesesSinSkip(tablaAmtzIn.getPlazo() - 1);

						flagTabla = primerFor(flagTabla, valorActual, tablaAmtzIn, tablaAmtzValor, tasaConvertido, manejaGracia);

						valorActualGemelo.setNumeroPagos(manejaGracia + 1);
						valorActualGemelo.setIvaDeIntereses(tablaAmtzIn.getValorCredito() * (tasaConvertido / 100) * 0.16);
						valorActualGemelo.setIntereses(valorActual.getIntereses());
						valorActualGemelo.setSeguros(valorActual.getSeguros());
						valorActualGemelo.setPagoFijo(utilerias.calculaPagoFijo(tasaConvertido, tablaAmtzIn.getNumeroPagosSinSkip(),
								tablaAmtzIn.getValorCredito()));
						valorActualGemelo.setPagoTotal(
								valorActualGemelo.getPagoFijo() + valorActualGemelo.getIvaDeIntereses() + valorActual.getSeguros());
						valorActualGemelo.setCapital(valorActualGemelo.getPagoFijo() - valorActualGemelo.getIntereses());
						valorActualGemelo.setSaldoDeCapital(tablaAmtzIn.getValorCredito() - valorActualGemelo.getCapital());

						valorActualGemeloGracia.setNumeroPagos(manejaGracia + 1);
						valorActualGemeloGracia.setIvaDeIntereses(tablaAmtzIn.getValorCredito() * (tasaConvertido / 100) * 0.16);
						valorActualGemeloGracia.setIntereses(valorActual.getIntereses());
						valorActualGemeloGracia.setSeguros(valorActualGemelo.getSeguros());
						valorActualGemeloGracia.setPagoFijo(utilerias.calculaPagoFijo(tasaConvertido,
								tablaAmtzIn.getNumeroPagosSinSkip(), tablaAmtzIn.getValorCredito()));
						valorActualGemeloGracia.setPagoTotal(valorActualGemelo.getPagoFijo() + valorActualGemelo.getIvaDeIntereses()
								+ valorActualGemeloGracia.getSeguros());
						valorActualGemeloGracia.setCapital(valorActualGemelo.getPagoFijo() - valorActualGemelo.getIntereses());
						valorActualGemeloGracia.setSaldoDeCapital(tablaAmtzIn.getValorCredito() - valorActualGemelo.getCapital());

						tablaAmtzValor.add(manejaGracia + 1, valorActualGemeloGracia);

						SccMxTablaAmtzValorDTO valorActualizado = new SccMxTablaAmtzValorDTO();
						contadorSemanalSeguros = 2;

						
						flagTabla = segundoFor( contadorSemanalSeguros, numeroPagos, valorActualizado, valorActualGemelo,
								flagTabla, Pair.of(tasaConvertido,manejaGracia), tablaAmtzIn, tablaAmtzValor, valorActual );

					} catch (NumberFormatException e) {
						LOGGER.error(e.getMessage(), e);
						return null;
					}
					
					return path.docAmortizacion(
							plantillaDocx,
							tablaAmtzValor, tablaAmtzIn);
				}
	

	/**
	 * Metodo privado de utilería que sirve para generar los cálculos adicionales de las 
	 * tablas de amortización y que se usa dentro de ésta misma clase
	 * 
	 * @param contadorSemanalSeguros Variable que se usa como el contador semanal de seguros 
	 * y que se usa como parámetro de entrada al método 
	 * @param numeroPagos variable que se usa para indicar el número de pagos  
	 * y que se usa como parámetro de entrada al método
	 * @param valorActualizado variable que se usa para pasar al método el valor actualizado  
	 * y que se usa como parámetro de entrada al método
	 * @param valorActualGemelo variable que se usa para pasar al método la información espejo 
	 * del valor actual  y que se usa como parámetro de entrada al método
	 * @param flagTabla variable de entrada y salida que se usa para verificar la bandera del proceso  
	 * y que se usa como parámetro de entrada al método
	 * @param tasaYGracia variable de tipo tupla parametrizada con Double e integer que se usa
	 * para pasar parámetros al método de la tasa y manejar gracia, y se usa como tupla para cumplir con 
	 * la regla de no pasar mas pa´rametro de los permitidos
	 * @param tablaAmtzIn variable de entrada que pasa los datos de SccMxTablaAmtzValorDTO  
	 * y que se usa como parámetro de entrada al método
	 * @param tablaAmtzValor variable de entrada que trae la información en un listdo de los
	 * tipos de dato SccMxTablaAmtzValorDTO y que se usa como parámetro de entrada al método
	 * @param utilerias variable de utileria que se pasa al  método  y que se usa como parámetro de entrada al método
	 * @param valorActual variable que almacena la información del valor actual
	 *  y que se usa como parámetro de entrada al método
	 * @return devuelve el string con el valor de la variable flag que se paso como parámetro al método 
	 * y que es una variable de salida
	 */
	private String segundoFor(Integer contadorSemanalSeguros, Integer numeroPagos, SccMxTablaAmtzValorDTO valorActualizado,
			SccMxTablaAmtzValorDTO valorActualGemelo, String flagTabla, Pair<Double,Integer> tasaYGracia, 
			SccMxTablaAmtzInDTO tablaAmtzIn, List<SccMxTablaAmtzValorDTO> tablaAmtzValor, SccMxTablaAmtzValorDTO valorActual) {
		SccMxUtileriasAmortizacion utileriasExtra = new SccMxUtileriasAmortizacion();
		Double tasaConvertido = tasaYGracia.getFirst();
		Integer manejaGracia = tasaYGracia.getSecond();
		for (int i = manejaGracia + 2; i <= numeroPagos; i++) {
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
				
				valorActualizado.setSeguros(utileriasExtra.obtenPagoSeguro(i, contadorSemanalSeguros, tablaAmtzValor, tablaAmtzIn).getSeguros());
				contadorSemanalSeguros = utileriasExtra.getContadorSemanalSeguros();
				
				valorActualizado
						.setIvaDeIntereses(valorActualGemelo.getSaldoDeCapital() * (tasaConvertido / 100) * 0.16);
				valorActualizado.setPagoTotal(valorActualizado.getPagoFijo() + valorActualizado.getIvaDeIntereses()
						+ valorActualizado.getSeguros());
				flagTabla = ConstantesTablaAmtz.FALSE;
			}
			if (flagTabla.equalsIgnoreCase(ConstantesTablaAmtz.FALSE)) {
				SccMxTablaAmtzValorDTO valActualizadoGemelo = new SccMxTablaAmtzValorDTO();
				valActualizadoGemelo.setNumeroPagos(valorActualizado.getNumeroPagos());
				valActualizadoGemelo.setCapital(valorActualizado.getCapital());
				valActualizadoGemelo.setSaldoDeCapital(valorActualizado.getSaldoDeCapital());
				valActualizadoGemelo.setIntereses(valorActualizado.getIntereses());
				valActualizadoGemelo.setPagoFijo(valorActualizado.getPagoFijo());
				valActualizadoGemelo.setIvaDeIntereses(valorActualizado.getIvaDeIntereses());
				valActualizadoGemelo.setSeguros(valorActualizado.getSeguros());
				valActualizadoGemelo.setPagoTotal(valorActualizado.getPagoTotal());

				valorActualGemelo.setPagoFijo(valActualizadoGemelo.getPagoFijo());
				valorActualGemelo.setCapital(valActualizadoGemelo.getCapital());
				valorActualGemelo.setSaldoDeCapital(valActualizadoGemelo.getSaldoDeCapital());
				valorActualGemelo.setIntereses(valActualizadoGemelo.getIntereses());
				valorActualGemelo.setIvaDeIntereses(valActualizadoGemelo.getIvaDeIntereses());
				valorActualGemelo.setPagoTotal(valActualizadoGemelo.getPagoTotal());
				valorActual.setSeguros(valActualizadoGemelo.getSeguros());
				tablaAmtzValor.add(i, valActualizadoGemelo);
				flagTabla = ConstantesTablaAmtz.TRUE;
			}

		}	
		return flagTabla;
	}


	/**
	 * Metodo privado de utilería que sirve para generar los cálculos adicionales de las 
	 * tablas de amortización y que se usa dentro de ésta misma clase
	 * 
	 * @param flagTabla variable que se usa como bandera para verificar el estatus 
	 * del proceso y que es un parámetro de entrada
	 * @param valorActual variable que se usa para identificar el valor actual 
	 *  y que es un parámetro de entrada
	 * @param tablaAmtzIn variable que se usa para pasar al método la información de la 
	 * tabla e amortización  y que es un parámetro de entrada
	 * @param tablaAmtzValor variable que se usa como parametro para manejar la información
	 * de los valores de la tabla de amortización  y que es un parámetro de entrada
	 * @param tasaConvertido variable que se usa para pasar el valor de la tasa 
	 * convertido a double  y que es un parámetro de entrada 
	 * @param manejaGracia variable que indica si se maneja gracia
	 *  y que es un parámetro de entrada
	 * @return devuelve la variable de tipo bandera del proceso  y que es un parámetro de salida
	 */
	private String primerFor(String flagTabla, SccMxTablaAmtzValorDTO valorActual, SccMxTablaAmtzInDTO tablaAmtzIn, 
						List<SccMxTablaAmtzValorDTO> tablaAmtzValor, Double tasaConvertido, Integer manejaGracia) {
		SccMxTablaAmtzValorDTO valorActualGracia = new SccMxTablaAmtzValorDTO();
		for (int i = 1; i <= manejaGracia; i++) {

			if (flagTabla.equalsIgnoreCase(ConstantesTablaAmtz.TRUE)) {
				valorActualGracia.setCapital(0.00);
				valorActualGracia.setPagoFijo(valorActual.getIntereses());
				valorActualGracia.setIntereses(valorActual.getIntereses());
				valorActualGracia.setSaldoDeCapital(tablaAmtzIn.getValorCredito());
				valorActualGracia.setIvaDeIntereses(tablaAmtzIn.getValorCredito() * (tasaConvertido / 100) * 0.16);
				valorActualGracia.setSeguros(valorActual.getSeguros());
				valorActualGracia.setPagoTotal(valorActualGracia.getPagoFijo()
						+ valorActualGracia.getIvaDeIntereses() + valorActualGracia.getSeguros());
				valorActualGracia.setNumeroPagos(i);
				flagTabla = ConstantesTablaAmtz.FALSE;
			}
			if (flagTabla.equalsIgnoreCase(ConstantesTablaAmtz.FALSE)) {
				SccMxTablaAmtzValorDTO valorActualizadoGracia = new SccMxTablaAmtzValorDTO();
				valorActualizadoGracia.setCapital(0.00);
				valorActualizadoGracia.setPagoFijo(valorActual.getIntereses());
				valorActualizadoGracia.setIntereses(valorActual.getIntereses());
				valorActualizadoGracia.setSaldoDeCapital(tablaAmtzIn.getValorCredito());
				valorActualizadoGracia
						.setIvaDeIntereses(tablaAmtzIn.getValorCredito() * (tasaConvertido / 100) * 0.16);
				valorActualizadoGracia.setSeguros(valorActual.getSeguros());
				valorActualizadoGracia.setPagoTotal(valorActualGracia.getPagoFijo()
						+ valorActual.getIvaDeIntereses() + valorActual.getSeguros());
				valorActualizadoGracia.setNumeroPagos(i);

				valorActual.setCapital(0.00);
				valorActual.setPagoFijo(valorActualizadoGracia.getPagoFijo());
				valorActual.setSaldoDeCapital(valorActualizadoGracia.getSaldoDeCapital());
				valorActual.setIvaDeIntereses(valorActualizadoGracia.getIvaDeIntereses());
				valorActual.setSeguros(valorActual.getSeguros());
				valorActual.setPagoTotal(valorActualizadoGracia.getPagoTotal());
				tablaAmtzValor.add(i, valorActualizadoGracia);
				flagTabla = ConstantesTablaAmtz.TRUE;
			}
			
		}
		return flagTabla;
	}
}
