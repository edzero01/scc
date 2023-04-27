package mx.isban.scc.utilerias;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import mx.isban.scc.model.dto.SccMxMaeCondFinanDTO;
import mx.isban.scc.service.ICondFinService;

/**
 * DTO para obtener datos necesarios para SccMxUtileriasOferMaxPlazo se
 * obtendran los atributos de esta entidad
 * 
 * @author Octavio DTO que se le regresa al cliente Global Hitss Mayo 2019
 *
 */
@Component
public class SccMxUtileriasOferMaxPlazo {


	/**
	 * Método para calcular el monto de pago de acuerddo a la tasa de interes, el
	 * plazo y el monto de credito
	 * 
	 * @param tasa         interes tasa anual
	 * @param plazo        plazo del monto de credito
	 * @param factorIvaSeg factor iva seguro
	 * @param factorIva    multiplicador para obtener el iva
	 * @param montoCredito Monto de crédito de la oferta máxima.
	 * @param codPeriod    Código del periodo
	 * @param idPeriodo    id del periodo
	 * @param idPagoSeguro id del pago seguro
	 * @param factorSeguro factor del seguro
	 * @return el pago mensual correspondiente al monto de la oferta.
	 * 
	 */
	public Double calculaMontoPago(Double tasa, Long plazo, Double factorSeguro, Double factorIva, Double factorIvaSeg,
			Double montoCredito, String codPeriod, Long idPeriodo, Long idPagoSeguro) {

		Double tasaConvertida = 0.0;
		Double costoSeguro = 0.0;
		Double vPlazo = 0.0;
		Double varA = 0.0;
		Double varB = 0.0;
		Double varC = 0.0;
		Double varD = 0.0;
		Double dividendo = 0.0;
		Double interesesIva = 0.0;
		Double pago = 0.0;

		tasaConvertida = convierteTasa(tasa, codPeriod);
		if (tasaConvertida <= 0) {
			tasaConvertida = 1.0;
		}
		vPlazo = conviertePlazo(codPeriod, plazo.doubleValue());
		varA = (1 / (tasaConvertida / 100));
		varB = (1 + (tasaConvertida / 100));
		varB = Math.pow(varB, vPlazo);
		varC = (varB * (tasaConvertida / 100));
		varD = (1 / varC);

		dividendo = (varA - varD);

		interesesIva = (montoCredito * (tasaConvertida / 100)) * (factorIva);
		pago = (montoCredito / dividendo) + interesesIva;

		costoSeguro = (factorSeguro * montoCredito) * (1 + factorIvaSeg);

		if (idPagoSeguro == 2) {

			pago = pago + costoSeguro;
		}

		return pago;

	}

	/**
	 * Método para obtener la tasa de interes mensual en base a la tasa mensual y el
	 * codigo del periodo
	 * 
	 * @param tasa      interes tasa anual
	 * @param codPeriod codigo del periodo
	 * @return la tasa de interes ya sea mensual, quincenal, catorcenal o semenal
	 * 
	 */
	private Double convierteTasa(Double tasa, String codPeriod) {
		Double tasaConvertida = 0.0;

		switch (codPeriod) {
		case "S":
			tasaConvertida = (tasa / 360) * 7;
			break;
		case "C":
			tasaConvertida = (tasa / 360) * 14;
			break;
		case "Q":
			tasaConvertida = (tasa / 360) * 15;
			break;
		case "M":
			tasaConvertida = tasa / 12;
			break;
		default:
			tasaConvertida = 1.0;
		}
		return tasaConvertida;
	}

	/**
	 * Método para obtener el plazo convertido en base al idPeriodo, el codigo del
	 * periodo y el plazo
	 * 
	 * @param codPeriod codigo del periodo relacionado con la oferta promocional de
	 *                  campaña
	 * @return el plazo convertido
	 * 
	 */
	private Double conviertePlazo(String codPeriod, Double plazo) {

		Double plazoConvertido = 12.0;

		switch (codPeriod) {
		case "S":
			plazoConvertido = (plazo / 12) * 52;
			break;
		case "C":
			plazoConvertido = (plazo / 12) * 26;
			break;
		case "Q":
			plazoConvertido = plazo * 2;
			break;
		case "M":
			plazoConvertido = plazo;
			break;
		default:
			plazoConvertido = 12.0;
		}

		return plazoConvertido;
	}

	/**
	 * Metodo para calcular los montos para la tabla de ofertas maximas por plazo
	 * Sprint 2
	 * 
	 * @param tasa            de interes del monto de credito
	 * @param listaPlazos     lista que trae los plazos maximos para la oferta de
	 *                        campaña
	 * @param listaMontos     lista de los motos para la oferta de campaña.
	 * @param codPeriod       Se agrego este param para pasar el sonar
	 * @param idProducto      Se agrego este param para pasar el sonar
	 * @param idPeriodo       Se agrego este param para pasar el sonar
	 * @param idPagoSeguro    Se agrego este param para pasar el sonar
	 * @param condFinancieras Se agrego este param para pasar el sonar Se agrego
	 *                        este param para pasar el sonar
	 * @return Lista Regresa la lsita de montos y pagos mensuales
	 */
	public List<Double> calculaMontosMensuales(Double tasa, List<Long> listaPlazos, List<Double> listaMontos,
			Long idProducto, Long idPeriodo, String codPeriod, Long idPagoSeguro, ICondFinService condFinancieras) {
		List<Double> listaPagos = new ArrayList<>();
		for (int i = 0; i < listaMontos.size(); i++) {

			Double montoCredito = listaMontos.get(i);

			Long plazo = listaPlazos.get(i);

			List<SccMxMaeCondFinanDTO> listaCondiciones = condFinancieras.buscaCondTPPOfMax(idProducto, tasa, plazo,
					idPeriodo);

			Double montoPago = 0.0;
			if (!listaCondiciones.isEmpty()) {
				SccMxMaeCondFinanDTO condFinan = listaCondiciones.get(0);

				montoPago = this.calculaMontoPago(tasa, plazo, condFinan.getPorFactorSeg(), condFinan.getPorFactorIva(),
						condFinan.getPorFactorIvaSeg(), montoCredito, codPeriod, idPeriodo, idPagoSeguro);
			}

			listaPagos.add(montoPago);

		}
		return listaPagos;
	}

}
