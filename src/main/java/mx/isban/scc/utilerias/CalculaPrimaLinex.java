package mx.isban.scc.utilerias;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;

import mx.isban.scc.model.dto.SccMxPrimaLinexDTO;
/**
 * Utileria para llevar a cabo
 * el calculo de prima devengada
 * linex que hace uso a su 
 * vez de utilerias adicionales para 
 * reducir complejidad de codigo
 * @author Christopher Espina Riveros
 * 
 * Global Hitss
 * Mayo 2019
 *
 */
public class CalculaPrimaLinex {

	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con la
	 * finalidar de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CalculaPrimaLinex.class);
	/**
	 * Metodo para calculo de prima devengada linex
	 * @param objetoPrima
	 * obtiene datos de entrada sobre prima 
	 * @return primaDevengada
	 * prima devengada
	 */
	public Double calculaPrimaLinex(SccMxPrimaLinexDTO objetoPrima) {
		
		SimpleDateFormat sdfDia = new SimpleDateFormat("dd");
		SimpleDateFormat sdfMes = new SimpleDateFormat("MM");
		SimpleDateFormat sdfAnio = new SimpleDateFormat("yyyy");
		SccMxUtileriasPrimaDevengadaLinex util = new SccMxUtileriasPrimaDevengadaLinex();
		Double primaDevengada = null;
		
		try {
			
			Double primaNeta = objetoPrima.getPc();
			
			String fInicialDia = sdfDia.format(objetoPrima.getFechaI());
			String fInicialMes = sdfMes.format(objetoPrima.getFechaI());
			String fInicialAnio = sdfAnio.format(objetoPrima.getFechaI());
			
			String fFinalAnio = sdfAnio.format(objetoPrima.getFechaF());
			
			String fCancelDia = sdfDia.format(objetoPrima.getFechaC());
			String fCancelMes = sdfMes.format(objetoPrima.getFechaC());
			String fCancelAnio = sdfAnio.format(objetoPrima.getFechaC());

			Integer vigencia = util.obtenVigenciaLinex(fInicialAnio, fFinalAnio);
			Integer anioCancelacion = util.obtenAnioCancelacionLinex(fInicialAnio, fCancelAnio);
			if (Integer.parseInt(fCancelMes) > Integer.parseInt(fInicialMes)) {
				anioCancelacion++;
			} else {
				if ((Integer.parseInt(fCancelMes) == Integer.parseInt(fInicialMes)) && 
					(Integer.parseInt(fCancelDia) >= Integer.parseInt(fInicialDia))) {
						anioCancelacion++;
				}
			}

			Integer mesCancelacion = util.obtenMesCancelacionLinex(fInicialMes, fCancelMes);
			
			if (Integer.parseInt(fCancelDia) >= Integer.parseInt(fInicialDia)) {
				mesCancelacion++;
			}

			Double factor = util.obtenFactor(mesCancelacion);
			primaDevengada = util.obtenMesesPorDevengarLinex(vigencia, anioCancelacion, primaNeta, factor);
			
		} catch (ArithmeticException |NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
		
		return primaDevengada;
	}

}
