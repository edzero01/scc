package mx.isban.scc.utilerias.plantillas;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

import javax.annotation.ManagedBean;

import org.slf4j.Logger;

import mx.isban.scc.model.dto.SccMxTablaRiesDTO;
import mx.isban.scc.model.dto.SccMxTablaRiesValorDTO;
import mx.isban.scc.utilerias.Ries139PlantillaDef;
import mx.isban.scc.utilerias.SccMxUtileriasAmortizacionComplemento;
import pl.jsolve.templ4docx.core.Docx;
import pl.jsolve.templ4docx.core.VariablePattern;
import pl.jsolve.templ4docx.exception.OpenDocxException;
import pl.jsolve.templ4docx.variable.TextVariable;
import pl.jsolve.templ4docx.variable.Variables;

/**
 * Clase para llenar generar plantilla Ries139
 * 
 * 
 * El método principal que se encarga del llenado de la tabla es
 * 
 * public ByteArrayOutputStream docRies(ByteArrayOutputStream plantillaDocx,
			List<SccMxTablaRiesValorDTO> parametrosIn, SccMxTablaRiesDTO in)
 *
 * @see #docRies(ByteArrayOutputStream, List, SccMxTablaRiesDTO)
 * 
 * @author José Luis Garcia
 *
 */
@ManagedBean
public class PlantillaRies {

	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con la
	 * finalidar de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PlantillaRies.class);

	/**
	 *  
	 *  Toma campos de tablas para el llenado del documento
	 *  en word y así poder transofmarlo a portable document format
	 * 
	 * @author José Luis Garcia
	 * @param plantillaDocx 
	 * datos del documento parametro de entrada en formatop ByteArrayOutputStream
	 * @param parametrosIn  
	 * datos de tabla en la lista List<SccMxTablaRiesValorDTO>
	 * @param in            
	 * datos de encabezado para mostrar provenientes de la pantalla
	 * @return ByteArrayOutputStream 
	 * datos de la plantilla llena en ByteArrayOutputStream
	 */
	public ByteArrayOutputStream docRies(ByteArrayOutputStream plantillaDocx,
			List<SccMxTablaRiesValorDTO> parametrosIn, SccMxTablaRiesDTO in) {

		SccMxUtileriasAmortizacionComplemento formatoCifra = new SccMxUtileriasAmortizacionComplemento();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();

		Variables var = new Variables();
		/*
		 * InputStream targetStream = null;
		 * 
		 * File initialFile = new
		 * File("C:\\Users\\egarcser\\Desktop\\Maqueta Ries 139 v9.docx"); try {
		 * targetStream = new FileInputStream(initialFile); } catch
		 * (FileNotFoundException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); }
		 */
		InputStream plantillaDocxStream = new ByteArrayInputStream(plantillaDocx.toByteArray());
		//InputStream plantillaDocxStream = targetStream;
		Docx template = new Docx(plantillaDocxStream);
		template.setVariablePattern(new VariablePattern("{{", "}}"));

		try {

			//var = PlantillasUtil.inicializaLeyendaTipoOfertaRies(var, in);
			/** Asigna los valores a las variables del Word **/
			var.addTextVariable(new TextVariable(Ries139PlantillaDef.SUBPRODUCTO, in.getSubproducto()));
			var.addTextVariable(new TextVariable(Ries139PlantillaDef.FECHA, dateFormat.format(date)));

			var.addTextVariable(new TextVariable(Ries139PlantillaDef.CAT,
					(formatoDivisaUnDecimal(in.getCat())).toString()));

			if (in.getNombreCliente() != null ) {
				var.addTextVariable(new TextVariable(Ries139PlantillaDef.ACREDITADO, in.getNombreCliente()));
			} else {
				var.addTextVariable(new TextVariable(Ries139PlantillaDef.ACREDITADO, "-"));
			}
			if (in.getCodigoCliente() != null) {
				var.addTextVariable(
						new TextVariable(Ries139PlantillaDef.BUC, in.getCodigoCliente().toString()));
			} else {
				var.addTextVariable(new TextVariable(Ries139PlantillaDef.BUC, "-"));
			}

			var.addTextVariable(new TextVariable(Ries139PlantillaDef.MONTO,
					formatoCifra.formatoDivisaDecimal(in.getValorCredito())));
			var.addTextVariable(new TextVariable(Ries139PlantillaDef.PLAZO, in.getPlazo().toString()));
			var.addTextVariable(new TextVariable(Ries139PlantillaDef.SUCURSAL, in.getSucursal().toString()));
			var.addTextVariable(new TextVariable(Ries139PlantillaDef.CUENTA, in.getNoCuenta().toString()));
			var.addTextVariable(new TextVariable(Ries139PlantillaDef.MODALIDAD, in.getModalidad().toString()));
			var.addTextVariable(new TextVariable(Ries139PlantillaDef.FORMAPAGO, in.getFormaPago().toString()));
			var.addTextVariable(new TextVariable(Ries139PlantillaDef.SALDOC, in.getSaldoRes().toString()));
			var.addTextVariable(new TextVariable(Ries139PlantillaDef.IMPORTE, in.getImporteNetoCredito().toString()));
			var.addTextVariable(new TextVariable(Ries139PlantillaDef.CUOTA, in.getCuota().toString()));
			var.addTextVariable(new TextVariable(Ries139PlantillaDef.PAGOS, in.getNumeroPagos().toString()));
			var.addTextVariable(new TextVariable(Ries139PlantillaDef.PERIODICIDAD, in.getPeriodicidad()));
			if (in.getCaucion() != null && in.getPuntos() != null) {
				var.addTextVariable(new TextVariable(Ries139PlantillaDef.CAUCION,
						formatoCifra.formatoDivisaDecimal(in.getCaucion() * 1.16)));
			}
			var.addTextVariable(new TextVariable(Ries139PlantillaDef.TASA,
					formatoCifra.formatoPorcentajeDecimal(in.getTasaInteresAnual())));
			var.addTextVariable(new TextVariable(Ries139PlantillaDef.APERTURA,
					formatoCifra.formatoDivisaDecimal(in.getComisionAperturaSinIva())));
			var.addTextVariable(new TextVariable(Ries139PlantillaDef.DISPOSICION,
					formatoCifra.formatoDivisaDecimal(in.getComisionDisposicionSinIva())));
			var.addTextVariable(new TextVariable(Ries139PlantillaDef.SEGUROS,
					formatoCifra.formatoDivisaDecimal(in.getSeguros())));
			template.fillTemplate(var);


			ByteArrayOutputStream documentoDocxOut = new ByteArrayOutputStream();
			template.save(documentoDocxOut);
			return documentoDocxOut;

		} catch (OpenDocxException e) {
			LOGGER.error(e.getMessage(), e);
			/**
			 * En caso de no poder llenar la información del documento, regresa null
			 * que se valida en clases posteriores, es decirr
			 * en aquellas que la invocaron
			 */
			return null;
		}
	}

	/**
	 * 
	 * Metodo para formatear a MN
	 * 
	 * @param cifra cifra a formatear
	 * @exception NumberFormatException formato de datos erroneo
	 * @return cifra formateada
	 */
	public String formatoDivisaUnDecimal(Double cifra) {

		Double cantidadC = cifra;
		StringBuilder sb = new StringBuilder();

		try (Formatter formatter = new Formatter(sb, Locale.US)) {

			formatter.format(" %(,.1f", cantidadC);
			sb.toString();

		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return sb.toString();
	}

}
