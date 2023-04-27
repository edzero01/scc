package mx.isban.scc.utilerias;

import java.util.List;

import mx.isban.scc.model.dto.SccMxTablaAmtzValorDTO;

/**
 * Clase de utileria para calculos de tablas de amortización
 * @author Hitss
 *
 */
public final class CalculosUtil {
	/**
	 * Constructor privado de la clase
	 */
	private CalculosUtil() {
		throw new IllegalStateException("Utility class");
	}
	
	/**
	 * Realiza calculos y verifica valores para las tablas de amortización
	 * @param flagTabla la bandera para verificar estatus
	 * @param valorActualizado el valor actualizado como parametro
	 * @param valorActualGemeloA el valor actual de la tabla espejo de amoritzación
	 * @param i el indice procesado acrualmente
	 * @param tablaAmtzValor  La tabla de amortización
	 * @return la bandera modificada
	 */
	public static String calcula(String flagTabla,SccMxTablaAmtzValorDTO valorActualizado,
			SccMxTablaAmtzValorDTO valorActualGemeloA, int i, List<SccMxTablaAmtzValorDTO> tablaAmtzValor ) {
		
		if (flagTabla.equalsIgnoreCase(ConstantesTablaAmtz.FALSE)) {
			SccMxTablaAmtzValorDTO valorActualizadoGemeloA = new SccMxTablaAmtzValorDTO();
			valorActualizadoGemeloA.setNumeroPagos(valorActualizado.getNumeroPagos());
			valorActualizadoGemeloA.setCapital(valorActualizado.getCapital());
			valorActualizadoGemeloA.setSaldoDeCapital(valorActualizado.getSaldoDeCapital());
			valorActualizadoGemeloA.setIntereses(valorActualizado.getIntereses());
			valorActualizadoGemeloA.setPagoFijo(valorActualizado.getPagoFijo());
			valorActualizadoGemeloA.setIvaDeIntereses(valorActualizado.getIvaDeIntereses());
			valorActualizadoGemeloA.setPagoTotal(valorActualizado.getPagoTotal());

			valorActualGemeloA.setPagoFijo(valorActualizadoGemeloA.getPagoFijo());
			valorActualGemeloA.setCapital(valorActualizadoGemeloA.getCapital());
			valorActualGemeloA.setSaldoDeCapital(valorActualizadoGemeloA.getSaldoDeCapital());
			valorActualGemeloA.setIntereses(valorActualizadoGemeloA.getIntereses());
			valorActualGemeloA.setIvaDeIntereses(valorActualizadoGemeloA.getIvaDeIntereses());
			valorActualGemeloA.setPagoTotal(valorActualizadoGemeloA.getPagoTotal());
			tablaAmtzValor.add(i, valorActualizadoGemeloA);
			flagTabla = ConstantesTablaAmtz.TRUE;
		}
		return flagTabla;
	}

}
