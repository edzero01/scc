package mx.isban.scc.utilerias.plantillas;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.ManagedBean;

import org.slf4j.Logger;

import mx.isban.scc.model.dto.SccMxPlantillaCPagoNAdeudosDTO;
import mx.isban.scc.utilerias.CartaCompromisoPlantillaDef;
import mx.isban.scc.utilerias.SccMxUtileriasAmortizacionComplemento;
import mx.isban.scc.utilerias.ValidaNull;
import pl.jsolve.templ4docx.core.Docx;
import pl.jsolve.templ4docx.core.VariablePattern;
import pl.jsolve.templ4docx.exception.OpenDocxException;
import pl.jsolve.templ4docx.variable.TextVariable;
import pl.jsolve.templ4docx.variable.Variables;

/**
 * Clase para llenar generar plantilla de tabla de amortizacion plan aleman o
 * frances con prima recurrente. Se llenan los campos de entrada que son:
 * producto fecha cat acreditado buc monto plazo pagos periodicidad tasa
 * comision apertura comision disposicion seguros
 * 
 * Para la tabla se llenan: nomero de pago pago fijo capital intereses iva de
 * intereses seguros pago total saldo
 *  
 *  y Tiene las variables 
 *  private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PlantillaCD.class);
 *  
 *  private static final String formatoFecha = "dd/MM/yyyy";
 *  además de invocar los métodos:
 *  
 *  public ByteArrayOutputStream  
 *  docCD1(SccMxPlantillaDescDTO, ByteArrayOutputStream)
 *  
 *  public ByteArrayOutputStream  
 *  docCD2(SccMxPlantillaDescDTO, ByteArrayOutputStream)
 *
 * @author Christopher Espina Riveros
 *
 */
@ManagedBean
public final class PlantillaCPNA {

	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con la
	 * finalidar de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PlantillaCPNA.class);
	
	/**
	 * variable de apoyo para no enviar nulls
	 */
	private ValidaNull vn = new ValidaNull();

	/**
	 * Metodo para llenado de plantilla 1 de Carta Compromiso Pago
	 * Se manda llamar
	 * cada vez que se necesita
	 * mostrar la carta compromiso
	 * @author Christopher Espina Riveros
	 * GlobalHitss
	 * Julio 2019
	 * @param filePath     
	 * path de file 
	 * @param comPago
	 *  datos de plantilla
	 * @return sRootPath 
	 * path donde se alojo la plantilla llena
	 */
	public ByteArrayOutputStream docCP(SccMxPlantillaCPagoNAdeudosDTO comPago, ByteArrayOutputStream filePath) {

		DateFormat dateFormatCPd = new SimpleDateFormat("dd");
		DateFormat dateFormatCPm = new SimpleDateFormat("MM");
		DateFormat dateFormatCPy = new SimpleDateFormat("yyyy");
		Date dateCP = new Date();
		Variables varCP = new Variables();
		SccMxUtileriasAmortizacionComplemento formatoCifra = new SccMxUtileriasAmortizacionComplemento();
		InputStream plantillaDocxStream = new ByteArrayInputStream(filePath.toByteArray());
		Docx templateCD = new Docx(plantillaDocxStream);
		templateCD.setVariablePattern(new VariablePattern("{", "}"));
		PlantillasUtil fechaMesCP = new PlantillasUtil();
		try {
			StringBuilder fechaLong = new StringBuilder();
			fechaLong.append(dateFormatCPd.format(dateCP));
			fechaLong.append(" de ");
			fechaLong.append(fechaMesCP.fechaMes(dateFormatCPm.format(dateCP)));
			fechaLong.append(" de ");
			fechaLong.append(dateFormatCPy.format(dateCP));
			varCP.addTextVariable(new TextVariable(CartaCompromisoPlantillaDef.CLIENTE, vn.validaNullString(comPago.getNomCliente())));
			varCP.addTextVariable(new TextVariable(CartaCompromisoPlantillaDef.TARJETA, vn.validaNullString(comPago.getNumtarjeta())));
			varCP.addTextVariable(new TextVariable(CartaCompromisoPlantillaDef.MONTO, formatoCifra.formatoDivisaDecimal(comPago.getMonto())));
			varCP.addTextVariable(new TextVariable(CartaCompromisoPlantillaDef.FECHA, fechaLong.toString()));


			templateCD.fillTemplate(varCP);

			ByteArrayOutputStream documentoDocxOutCP= new ByteArrayOutputStream();
			templateCD.save(documentoDocxOutCP);
			return documentoDocxOutCP;

		} catch (OpenDocxException e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Metodo para llenado de plantilla tipo 3 
	 * Se manda llamar
	 * cada vez que se necesita
	 * mostrar el Manifiesto de No Adeudos
	 * @author Christopher Espina Riveros
	 * GlobalHitss
	 * Julio 2019
	 * @param filePath     
	 * path de file
	 * @param noAdeud
	 *  datos de plantilla
	 * @return sRootPath 
	 * path donde se alojo la plantilla llena
	 */
	public ByteArrayOutputStream docNA(SccMxPlantillaCPagoNAdeudosDTO noAdeud, ByteArrayOutputStream filePath) {

		DateFormat dateFormatNAd = new SimpleDateFormat("dd");
		DateFormat dateFormatNAm = new SimpleDateFormat("MM");
		DateFormat dateFormatNAy = new SimpleDateFormat("yyyy");
		Date dateNA = new Date();
		Variables varNA = new Variables();
		PlantillasUtil fechaMesNA = new PlantillasUtil();
		
		InputStream plantillaDocxStream = new ByteArrayInputStream(filePath.toByteArray());
		Docx templateNA = new Docx(plantillaDocxStream);
		templateNA.setVariablePattern(new VariablePattern("{", "}"));

		try {
			StringBuilder fechaLong = new StringBuilder();
			fechaLong.append(dateFormatNAd.format(dateNA));
			fechaLong.append(" de ");
			fechaLong.append(fechaMesNA.fechaMes(dateFormatNAm.format(dateNA)));
			fechaLong.append(" de ");
			fechaLong.append(dateFormatNAy.format(dateNA));
			varNA.addTextVariable(new TextVariable(CartaCompromisoPlantillaDef.CLIENTE, vn.validaNullString(noAdeud.getNomCliente())));
			varNA.addTextVariable(new TextVariable(CartaCompromisoPlantillaDef.FECHA, fechaLong.toString()));


			templateNA.fillTemplate(varNA);

			ByteArrayOutputStream documentoDocxOutNA= new ByteArrayOutputStream();
			templateNA.save(documentoDocxOutNA);
			return documentoDocxOutNA;

		} catch (OpenDocxException e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
	}
	
}
