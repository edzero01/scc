package mx.isban.scc.utilerias.plantillas;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

import javax.annotation.ManagedBean;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import mx.isban.scc.model.SccMxMaeProducto;
import mx.isban.scc.dao.SccMxMaeProductoDAO;
import mx.isban.scc.model.dto.SccMxTablaCaratulaDTO;
import mx.isban.scc.model.dto.SccMxTablaCaratulaValorDTO;
import mx.isban.scc.utilerias.CaratulaPlantillaDef;
import mx.isban.scc.utilerias.NumeroALetras;
import mx.isban.scc.utilerias.Ries139PlantillaDef;
import mx.isban.scc.utilerias.SccMxUtileriasAmortizacionComplemento;
import pl.jsolve.templ4docx.core.Docx;
import pl.jsolve.templ4docx.core.VariablePattern;
import pl.jsolve.templ4docx.exception.OpenDocxException;
import pl.jsolve.templ4docx.variable.TextVariable;
import pl.jsolve.templ4docx.variable.Variables;

/**
 * Clase para llenar generar plantilla de carátula de crédito
 * 
 * El método principal que se encarga del llenado de la tabla es
 * 
 * public ByteArrayOutputStream docCaratula(ByteArrayOutputStream plantillaDocx,
			List<SccMxTablaCaratulaValorDTO> parametrosIn, SccMxTablaCaratulaDTO in)
 *
 * @see #docCaratula(ByteArrayOutputStream, List, SccMxTablaCaratulaDTO)
 * 
 * @author José Luis Garcia
 *
 */
@ManagedBean
public class PlantillaCaratula {

	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con la
	 * finalidar de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PlantillaCaratula.class);
	
	@Autowired
	private SccMxMaeProductoDAO sccMxMaeProductoDAO;

	/**
	 * Metodo para llenado de plantilla de carátula de crédito
	 * 
	 * @param plantillaDocx 
	 * datos del documento parametro de entrada en formatop ByteArrayOutputStream
	 * @param parametrosIn  
	 * datos de tabla en la lista List<SccMxTablaCaratulaValorDTO>
	 * @param in            
	 * datos de encabezado para mostrar provenientes de la pantalla
	 * @return ByteArrayOutputStream 
	 * datos de la plantilla llena en ByteArrayOutputStream
	 */
	public ByteArrayOutputStream docCaratula(ByteArrayOutputStream plantillaDocx,
			List<SccMxTablaCaratulaValorDTO> parametrosIn, SccMxTablaCaratulaDTO in) {

		SccMxUtileriasAmortizacionComplemento formatoCifra = new SccMxUtileriasAmortizacionComplemento();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		
		String pagoTardio = "18";
		switch (in.getPeriodicidad().toString()) {
		case "Semanal": 
			 pagoTardio= "25";
			 break;
		case "Catorcenal":
			pagoTardio= "50";
			break;
		case "Quincenal":
			pagoTardio= "50";
			break;
		case "Mensual":
			pagoTardio= "100";
			break;
			
		}
		
		
		
		String numeroAper = (in.getComisionAperturaSinIva()).toString();
		String numeroPago = pagoTardio;
		NumeroALetras aperturaLetras = new NumeroALetras();
		String aperturaEnLetras = aperturaLetras.convertir(numeroAper, "","", "", "", "", false);
		String pagoTardioEnLetras = aperturaLetras.convertir(numeroPago, "","", "", "", "", false);
		

		Variables var = new Variables();
		
		Long idProd= (in.getIdProducto());
		SccMxMaeProducto prod= sccMxMaeProductoDAO.buscaProdPorId(idProd);
		String nSeguro = prod.getDscCoberturaSeg();
		String nAseguradora = prod.getDscEntidadCrd();
		String nClausula = prod.getDscExclusionSeg();

		InputStream plantillaDocxStream = new ByteArrayInputStream(plantillaDocx.toByteArray());

		Docx template = new Docx(plantillaDocxStream);
		template.setVariablePattern(new VariablePattern("{", "}"));

		try {

			/** Asigna los valores a las variables del Word **/
			var.addTextVariable(new TextVariable(CaratulaPlantillaDef.PRODUCTO, in.getProducto()));
			var.addTextVariable(new TextVariable(CaratulaPlantillaDef.FECHA, dateFormat.format(date)));

			var.addTextVariable(new TextVariable(CaratulaPlantillaDef.CAT,
					(formatoDivisaUnDecimal(in.getCat())).toString()));

			var.addTextVariable(new TextVariable(CaratulaPlantillaDef.MONTO,
					formatoCifra.formatoDivisaDecimal(in.getValorCredito())));
			var.addTextVariable(new TextVariable(CaratulaPlantillaDef.PLAZO, in.getPlazo().toString()));
			var.addTextVariable(new TextVariable(CaratulaPlantillaDef.OFERTA, in.getTipoOferta().toString()));
			var.addTextVariable(new TextVariable(CaratulaPlantillaDef.MTOTAL,
					(formatoDivisaUnDecimal(in.getMontoPagar())).toString()));
			var.addTextVariable(new TextVariable(CaratulaPlantillaDef.DIAPAGO, in.getDiaPago()));
			var.addTextVariable(new TextVariable(CaratulaPlantillaDef.APERTURAL, aperturaEnLetras  )) ;
			var.addTextVariable(new TextVariable(CaratulaPlantillaDef.PAGOTARDIO, pagoTardio));
			var.addTextVariable(new TextVariable(CaratulaPlantillaDef.TARDIOL, pagoTardioEnLetras));
			var.addTextVariable(new TextVariable(CaratulaPlantillaDef.SEGURO, nSeguro));
			var.addTextVariable(new TextVariable(CaratulaPlantillaDef.ASEGURADORA, nAseguradora));
			var.addTextVariable(new TextVariable(CaratulaPlantillaDef.CLAUSULA, nClausula));
			var.addTextVariable(new TextVariable(Ries139PlantillaDef.PERIODICIDAD, in.getPeriodicidad()));
			if (in.getCaucion() != null && in.getPuntos() != null) {
				var.addTextVariable(new TextVariable(CaratulaPlantillaDef.CAUCION,
						formatoCifra.formatoDivisaDecimal(in.getCaucion() * 1.16)));
			}
			var.addTextVariable(new TextVariable(CaratulaPlantillaDef.TASA,
					formatoCifra.formatoPorcentajeDecimal(in.getTasaInteresAnual())));
			var.addTextVariable(new TextVariable(CaratulaPlantillaDef.APERTURA,
					formatoCifra.formatoDivisaDecimal(in.getComisionAperturaSinIva())));

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
