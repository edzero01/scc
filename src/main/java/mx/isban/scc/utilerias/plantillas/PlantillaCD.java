package mx.isban.scc.utilerias.plantillas;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.ManagedBean;

import org.slf4j.Logger;

import mx.isban.scc.model.dto.SccMxPlantillaDescDTO;
import mx.isban.scc.utilerias.CertificadoDescuentosPlantillaDef;
import mx.isban.scc.utilerias.ValidaNull;
import pl.jsolve.templ4docx.core.Docx;
import pl.jsolve.templ4docx.core.VariablePattern;
import pl.jsolve.templ4docx.exception.OpenDocxException;
import pl.jsolve.templ4docx.variable.TextVariable;
import pl.jsolve.templ4docx.variable.Variables;

/**
 * Clase para llenar generar plantilla del Certificado de Descuento
 * Debe funcionar para cualquier ID que el usuario genere
 * Aunque siempre tendra limitadas las variables definidas por {{}}
 * 
 *  private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PlantillaCD.class);
 *  
 *  private static final String formatoFecha = "dd/MM/yyyy";
 *  además de invocar los métodos:
 *  
 *  Certificado de descuento
 *  public ByteArrayOutputStream  
 *  docCD1(SccMxPlantillaDescDTO, ByteArrayOutputStream)
 * 
 * @author Christopher Espina Riveros
 * Modificado por Lwbaruch
 */
@ManagedBean
public final class PlantillaCD {

	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con la
	 * finalidar de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PlantillaCD.class);
	
	/**
	 * Formato de fechas tipo "dd/MM/yyyy"
	 */
	private static final String FORMATO_FECHA = "dd/MM/yyyy";


	/**
	 * Metodo para llenado de plantilla 1 de certificado de descuentos
	 * Se manda llamar
	 * cada vez que se necesita
	 * mostrar el certificado de descuentos
	 * @author Christopher Espina Riveros
	 * GlobalHitss
	 * Julio 2019
	 * @param filePath     
	 * path de file
	 * @param certDesc
	 *  datos de tabla
	 * @return sRootPath 
	 * path donde se alojo la plantilla llena
	 */
	public ByteArrayOutputStream docCD1(SccMxPlantillaDescDTO certDesc, ByteArrayOutputStream filePath) {

		DateFormat dateFormatCD = new SimpleDateFormat(FORMATO_FECHA);
		DateFormat dateFormatCDd = new SimpleDateFormat("dd");
		DateFormat dateFormatCDm = new SimpleDateFormat("MM");
		DateFormat dateFormatCDy = new SimpleDateFormat("yyyy");
		Date dateCD = new Date();
		Variables varCD = new Variables();
		PlantillasUtil fechaMesCD = new PlantillasUtil();
		ValidaNull vn = new ValidaNull();

		InputStream plantillaDocxStream = new ByteArrayInputStream(filePath.toByteArray());
		Docx templateCD = new Docx(plantillaDocxStream);
		templateCD.setVariablePattern(new VariablePattern("{", "}"));

		try {
			StringBuilder fechaLong = new StringBuilder();
			fechaLong.append(dateFormatCDd.format(dateCD));
			fechaLong.append(" de ");
			fechaLong.append(fechaMesCD.fechaMes(dateFormatCDm.format(dateCD)));
			fechaLong.append(" de ");
			fechaLong.append(dateFormatCDy.format(dateCD));
			varCD.addTextVariable(new TextVariable(CertificadoDescuentosPlantillaDef.FECHA, dateFormatCD.format(dateCD)));
			varCD.addTextVariable(new TextVariable(CertificadoDescuentosPlantillaDef.CLIENTE, vn.validaNullString(certDesc.getNomCliente())));
			varCD.addTextVariable(new TextVariable(CertificadoDescuentosPlantillaDef.NOMPROMOCION, vn.validaNullString(certDesc.getNomProm())));
			varCD.addTextVariable(new TextVariable(CertificadoDescuentosPlantillaDef.NOMCOLECTIVO, vn.validaNullString(certDesc.getNomColect())));
			varCD.addTextVariable(new TextVariable(CertificadoDescuentosPlantillaDef.NOMCOMPROM, vn.validaNullString(certDesc.getNomComProm())));
			varCD.addTextVariable(new TextVariable(CertificadoDescuentosPlantillaDef.TARJETA, vn.validaNullString(certDesc.getNomTarjeta())));
			varCD.addTextVariable(new TextVariable(CertificadoDescuentosPlantillaDef.NUMTARJETA, vn.validaNullString(certDesc.getNumtarjeta())));
			varCD.addTextVariable(new TextVariable(CertificadoDescuentosPlantillaDef.SEGURO, vn.validaNullString(certDesc.getFacAsegProm())));
			varCD.addTextVariable(new TextVariable(CertificadoDescuentosPlantillaDef.CATPROM, vn.validaNullString(certDesc.getCatProm())));
			varCD.addTextVariable(new TextVariable(CertificadoDescuentosPlantillaDef.COMPROM, vn.validaNullString(certDesc.getComProm())));
			varCD.addTextVariable(new TextVariable(CertificadoDescuentosPlantillaDef.TASA, vn.validaNullString(certDesc.getTasaIntProm())));
			varCD.addTextVariable(new TextVariable(CertificadoDescuentosPlantillaDef.ENTIDAD, vn.validaNullString(certDesc.getEntCred())));
			varCD.addTextVariable(new TextVariable(CertificadoDescuentosPlantillaDef.FECHAL, fechaLong.toString()));

			templateCD.fillTemplate(varCD);

			ByteArrayOutputStream documentoDocxOutCD1= new ByteArrayOutputStream();
			templateCD.save(documentoDocxOutCD1);
			return documentoDocxOutCD1;

		} catch (OpenDocxException e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
	}

	

}
