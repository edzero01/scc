package mx.isban.scc.utilerias.plantillas;

import mx.isban.scc.model.dto.SccMxTablaAmtzInDTO;
import mx.isban.scc.model.dto.SccMxTablaMagisterioDTO;
import mx.isban.scc.utilerias.TablaAmortizacionPlantillaDef;
import pl.jsolve.templ4docx.variable.TextVariable;
import pl.jsolve.templ4docx.variable.Variables;

/**
 * Clase de utilerias adicionales para
 * llenado de plantillas.
 * 
 * Plantillas:
 * Tabla de amortizacion
 * Certificado de descuentos
 * Manifiesto de no adeudos
 * Carta compromiso de pago
 * Mandatorios
 * 
 * Dichas utilidades serán usadas
 * basicamente para formatos de
 * fechas.
 * 
 * @author Hitss
 * Sprint 4
 * Julio 2019
 *
 */
public class PlantillasUtil {
	
	/**
	 * constante privada mes enero
	 */
	private static final String ENERO = "Enero";
	/**
	 * constante privada mes febrero
	 */
	private static final String FEBRERO = "Febrero";
	/**
	 * constante privada mes marzo
	 */
	private static final String MARZO = "Marzo";
	/**
	 * constante privada mes abril
	 */
	private static final String ABRIL = "Abril";
	/**
	 * constante privada mes mayo
	 */
	private static final String MAYO = "Mayo";
	/**
	 * constante privada mes Junio
	 */
	private static final String JUNIO = "Junio";
	/**
	 * constante privada mes julio
	 */
	private static final String JULIO = "Julio";
	/**
	 * constante privada mes Agosto
	 */
	private static final String AGOSTO = "Agosto";
	/**
	 * constante privada mes sept
	 */
	private static final String SEPTIEMBRE = "Septiembre";
	/**
	 * constante privada mes enero
	 */
	private static final String OCTUBRE = "Octubre";
	/**
	 * constante privada mes noviembre
	 */
	private static final String NOVIEMBRE = "Noviembre";
	/**
	 * constante privada mes Dic
	 */
	private static final String DICIEMBRE = "Diciembre";
	
	/**
	 * metodo para obtener mes completo
	 * @param fecha
	 * fecha de entrada formato numerico
	 * @return mes
	 * mes de salida formato latino
	 */
	public String fechaMes(String fecha) {
		String mes = "";
		switch (fecha) {
			case "01":
				mes = ENERO;
				break;
			case "02":
				mes = FEBRERO;
				break;
			case "03":
				mes = MARZO;
				break;
			case "04":
				mes = ABRIL;
				break;
			case "05":
				mes = MAYO;
				break;
			case "06":
				mes = JUNIO;
				break;
			case "07":
				mes = JULIO;
				break;
			case "08":
				mes = AGOSTO;
				break;
			case "09":
				mes = SEPTIEMBRE;
				break;
			case "10":
				mes = OCTUBRE;
				break;
			case "11":
				mes = NOVIEMBRE;
				break;
			case "12":
				mes = DICIEMBRE;
				break;
			default:
				break;
		}
		return mes;
	}
	
	/**
	 * Inicializa la leyenda del tipo de oferta para ofertta promocional
	 * y para conversión auto
	 * @param varPR la variable en la que se inicilliza la leyenda
	 * @param in el dto con la información de los datos de la tabla de amorti¡zación
	 * @return la variable en la que se inicilliza la leyenda
	 */
	public static final  Variables inicializaLeyendaTipoOferta(Variables varPR, SccMxTablaAmtzInDTO in) {
		switch (in.getTipoOferta()) {
		case 1:
			varPR.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.OFERTA_LEYENDA, "Oferta promocional" ));
			break;
		case 2:
			varPR.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.OFERTA_LEYENDA, "Conversión auto"));
			break;
		default:
			break;
		}
		return varPR;
	}
	

	

}
