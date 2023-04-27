package mx.isban.scc.utilerias;

import java.util.ArrayList;
import java.util.List;

import mx.isban.scc.model.dto.SccMxCatPSGDTO;

/**
 * Con esta clase se calcula el CAT 
 * para el producto Personal Select Garantía
 * Siguiento el nuevo Algoritmo entregado por Usuario
 * @author Lorena Baruch
 *
 */

public class CalculoCatPSG {

	/**
	 * Obtiene el CAT para Personal Select Garantia
	 * Se saca la lista de los pagos 
	 * Se calcula el VAN, y se mete en el dowhile hasta que sea CERO
	 * en ese momento ya tenemos el valor de TIR
	 * con ese valor se calcula el CAT
	 * @param datosCAT
	 * Datos que se reciben de Front End. Periodicidad, numero de pagos, monto crédito, tasa
	 * La tasa ya es la TIIE mas los puntos porcentuales
	 * @return Double
	 * Regresa el valor del CAT
	 */
	public Double obtenCatPSG(SccMxCatPSGDTO datosCAT) {
		SccMxUtileriasAmortizacionComplemento utilerias = new SccMxUtileriasAmortizacionComplemento();
		List<Double> listaFlujos = new ArrayList<>();
		Double montoCredFlujo = -1 * datosCAT.getMontoCred();
		Double pagoCapital = datosCAT.getMontoCred() / datosCAT.getNumPagos();
		Double tasaConvertida = utilerias.obtenTasaConvertida(datosCAT.getPeriodicidad(), datosCAT.getTasaTIIE()/100);
		Integer numPeriodos = utilerias.obtenPeriodosAnio(datosCAT.getPeriodicidad());

		Double saldoCapital = datosCAT.getMontoCred();
		Double pagoTotal = 0.0;
		Double q9 = 0.00;
		Double r9 = 0.50;
		Double s9 = 100.00;
		Double sumVAN = 0.00;
		Double valorCAT = 0.00;
		
		montoCredFlujo = montoCredFlujo + (datosCAT.getCaucion() + datosCAT.getComApertura() + datosCAT.getComDisposicion() + datosCAT.getCostoSeguro());
		
		for(int i =0; i< datosCAT.getNumPagos(); i++) {
			pagoTotal = pagoCapital + saldoCapital*tasaConvertida;
			listaFlujos.add(pagoTotal); 
			saldoCapital = saldoCapital - pagoCapital;
		}
		
		sumVAN = montoCredFlujo + getSUMAFlujosSinTasa(listaFlujos);
		
		do {
			if (sumVAN < 0) {
				s9 = r9;
			} else {
				q9 = r9;
			}

			r9 = ((q9 + s9) / 2.00);
			sumVAN = montoCredFlujo + getSUMAFlujos(listaFlujos, r9/100.0);
		} while (Math.abs(sumVAN) > 0.000001);

		valorCAT = (Math.pow((1 + (r9 / 100.00)), numPeriodos) - 1.00) * 100.00;
		return valorCAT;
	
	}
	
	/**
	 * Obtiene la suma de los datos que estén en la lista
	 * @param listaFlujos
	 * Contiene los pagos por período
	 * @param tasa
	 * Tasa a la que se va a elevar cada pago antes de sumarlo
	 * @return suma
	 * Regresa la sumatoria de la lista
	 */
	Double getSUMAFlujos(List<Double> listaFlujos, Double tasa){
		Double total = 0.0;
		int i = 1;
		for (Double valorFlujo : listaFlujos) {
			total += (valorFlujo /  Math.pow( 1 + tasa, i));
			i++;
		}
		return total;
	}

	/**
	 * Obtiene la suma de los datos que estén en la lista
	 * @param listaFlujos
	 * Contiene los pagos por período
	 * @return suma
	 * Regresa la sumatoria de la lista
	 */
	Double getSUMAFlujosSinTasa(List<Double> listaFlujos){
		Double total = 0.0;
		for (Double valorFlujo : listaFlujos) {
			total += valorFlujo ;
		}
		return total;
	}

	
}
