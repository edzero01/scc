package mx.isban.scc.utilerias;

import java.util.List;

import org.springframework.data.util.Pair;

import mx.isban.scc.model.dto.SccMxTablaAmtzInDTO;
import mx.isban.scc.model.dto.SccMxTablaAmtzValorDTO;

/**
 * 
 * Funciones de apoyo (Utilerías) para la generación
 *         de las tablas de amortización Dichas funciones son accesadas por las
 *         diversos metodos implementados en la interfaz ICalculoTblAmtzService
 *         y en sus diversos metodos propios empleados para calcular las tablas
 *         de plan frances, plan aleman con sus diversas variantes
 *         
 * 
 *  * 
 * 
 * Simulador de Credito al Consumo
 * Global Hitss
 * Mayo 2019
 * 
 *
 * 
 * @author Christopher Espina 
 * 
 *         
 *
 */

public class SccMxUtileriasAmortizacion {
	
	/**
	 * integer privado para metodo de obtencion de seguro
	 */
	private Integer contadorSemanalSeguros = 2;
	/**
	 * doble privado para obtencion de seguro
	 */
	private Double seguros = 0.00;
	
		/**
		 * constructor vacio
		 */
	public SccMxUtileriasAmortizacion() {
		super();
	}
	
	/**
	 * getter contador
	 * @return
	 * contado
	 */
	public Integer getContadorSemanalSeguros() {
		return contadorSemanalSeguros;
	}
	/**
	 * setter contador
	 * @param contadorSemanalSeguros
	 * set contador
	 */
	public void setContadorSemanalSeguros(Integer contadorSemanalSeguros) {
		this.contadorSemanalSeguros = contadorSemanalSeguros;
	}
	/**
	 * getter seguros
	 * @return
	 * seguros
	 */
	public Double getSeguros() {
		return seguros;
	}
	/**
	 * setter seguros
	 * @param seguros
	 * return seguros
	 */
	public void setSeguros(Double seguros) {
		this.seguros = seguros;
	}

	
	/**
	 * 
	 * Metodo para obtener los pagos de seguro en caso
	 * de presentar prima recurrente 
	 *
	 * @param i
	 * indice del for que invoca utileria
	 * @param tablaAmtzValor
	 * lista de valores para protocolo de seguro
	 * @param tablaAmtzIn
	 * valores de entrada para obtener periodicidad
	 * @param contadorSemanalSeguros
	 * contador semanal de seguro en caso de ser semanal
	 * @return 
	 * seguro y numero semanal 
	 */
	public SccMxUtileriasAmortizacion obtenPagoSeguro(Integer i, Integer contadorSemanalSeguros, List<SccMxTablaAmtzValorDTO> tablaAmtzValor, SccMxTablaAmtzInDTO tablaAmtzIn) {
		
		Double saldoTotalCalculoInteres = 0.00;
		
		SccMxUtileriasAmortizacion objeto = new SccMxUtileriasAmortizacion();
		switch (tablaAmtzIn.getPeriodicidad()) {
		case PeriodosDef.SEMANAL:

			Pair<Double, Pair<Integer,Double>> resultSemana = calculaSaldoYSeguroSemanal(i, tablaAmtzValor, tablaAmtzIn);
			if( resultSemana != null) {
				saldoTotalCalculoInteres = resultSemana.getFirst();
				objeto.setContadorSemanalSeguros(resultSemana.getSecond().getFirst());
				objeto.setSeguros(resultSemana.getSecond().getSecond());
			}
			break;
		case PeriodosDef.CATORCENAL:
		case PeriodosDef.QUINCENAL:
			Pair<Double, Double> result = calculaSaldoYSeguroCatorcenal(i, tablaAmtzValor, tablaAmtzIn);
			saldoTotalCalculoInteres = result.getFirst();
			objeto.setSeguros(result.getSecond());
			break;
		case PeriodosDef.MENSUAL:
			saldoTotalCalculoInteres = tablaAmtzValor.get(i - 1).getSaldoDeCapital();
			Double varSeguros = (tablaAmtzIn.getFactorSeguro() * saldoTotalCalculoInteres);
			objeto.setSeguros(varSeguros);
			break;
		default:
			break;
		}
		
		return objeto;
	}
	
	
	/**
	 * Obtiene tasas convertidas, plazos convertidos y manejo de datos para las tablas de amnortización enperiodo catorcenal
	 * @param i 
	 * 	Iterador del ciclo for que lo manda llamar
	 * @param contadorSemanalSeguros 
	 * 	Dato de entrada para prima recurrente mensual
	 * @param tablaAmtzValor
	 * 	Datos de entrada de la tabla
	 * @param tablaAmtzIn
	 * 	datos de entrada del encabezado
	 * @return El pago del seguro
	 */
	private Pair<Double, Double> calculaSaldoYSeguroCatorcenal(int i, List<SccMxTablaAmtzValorDTO> tablaAmtzValor, SccMxTablaAmtzInDTO tablaAmtzIn){
		Double saldoTotalCalculoInteres = 0.00;
		Double varSeguros = 0.00;
		
		if (i % 2 == 0) {
			saldoTotalCalculoInteres = tablaAmtzValor.get(i - 2).getSaldoDeCapital();
			varSeguros = (tablaAmtzIn.getFactorSeguro() * saldoTotalCalculoInteres) / 2;
		} else {
			saldoTotalCalculoInteres = tablaAmtzValor.get(i - 1).getSaldoDeCapital();
			varSeguros = (tablaAmtzIn.getFactorSeguro() * saldoTotalCalculoInteres) / 2;
		}
		
		return Pair.of(saldoTotalCalculoInteres, varSeguros);
	}
	
	/**
	 * Obtiene tasas convertidas, plazos convertidos y manejo de datos para las tablas de amnortización en periodo semanal
	 * @param i 
	 * 	Iterador del ciclo for que lo manda llamar
	 * @param contadorSemanalSeguros 
	 * 	Dato de entrada para prima recurrente mensual
	 * @param tablaAmtzValor
	 * 	Datos de entrada de la tabla
	 * @param tablaAmtzIn
	 * 	datos de entrada del encabezado
	 * @return El pago del seguro
	 */
	private Pair<Double, Pair<Integer,Double>> calculaSaldoYSeguroSemanal(int i, List<SccMxTablaAmtzValorDTO> tablaAmtzValor, SccMxTablaAmtzInDTO tablaAmtzIn) {
		Double saldoTotalCalculoInteres = 0.00;
		Double varSeguros = 0.0;
		if (contadorSemanalSeguros == 5) {
			contadorSemanalSeguros = 1;
		}
		if (contadorSemanalSeguros <= 5) {
			saldoTotalCalculoInteres = tablaAmtzValor.get(i - contadorSemanalSeguros)
					.getSaldoDeCapital();
			varSeguros = (tablaAmtzIn.getFactorSeguro() * saldoTotalCalculoInteres) / 4;
			contadorSemanalSeguros++;
			return Pair.of(saldoTotalCalculoInteres, Pair.of(contadorSemanalSeguros, varSeguros));
		}
		return null;
		
	}



}
