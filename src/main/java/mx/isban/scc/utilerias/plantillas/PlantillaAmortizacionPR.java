package mx.isban.scc.utilerias.plantillas;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;

import org.slf4j.Logger;

import mx.isban.scc.model.dto.SccMxTablaAmtzInDTO;
import mx.isban.scc.model.dto.SccMxTablaAmtzValorDTO;
import mx.isban.scc.utilerias.SccMxUtileriasAmortizacionComplemento;
import mx.isban.scc.utilerias.TablaAmortizacionPlantillaDef;
import pl.jsolve.templ4docx.core.Docx;
import pl.jsolve.templ4docx.core.VariablePattern;
import pl.jsolve.templ4docx.exception.OpenDocxException;
import pl.jsolve.templ4docx.variable.TableVariable;
import pl.jsolve.templ4docx.variable.TextVariable;
import pl.jsolve.templ4docx.variable.Variable;
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
 * El método principal que se encarga del llenado de la tabla es
 * 
 * public ByteArrayOutputStream docAmortizacion(ByteArrayOutputStream plantillaDocx,
			List<SccMxTablaAmtzValorDTO> parametrosIn, SccMxTablaAmtzInDTO in)
 *
 * @see #docAmortizacion(ByteArrayOutputStream, List, SccMxTablaAmtzInDTO)
 * 
 * @author Christopher Espina Riveros
 *
 */
@ManagedBean
public final class PlantillaAmortizacionPR {

	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con la
	 * finalidar de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PlantillaAmortizacionPR.class);

	/**
	 * Metodo para llenado de plantilla de tabla amortizacion utilizando listas para 
	 * el paso de la información enter clases:
	 * 
	 * 	List<Variable> pagosPR = new ArrayList<>();
	 *  List<Variable> pFijoPR = new ArrayList<>();
	 *  List<Variable> capitalPR = new ArrayList<>();
	 *  List<Variable> interesesPR = new ArrayList<>();
	 *  List<Variable> ivaPR = new ArrayList<>();
	 *  List<Variable> segurosPR = new ArrayList<>();
	 *  List<Variable> pTotalPR = new ArrayList<>();
	 *  List<Variable> saldoPR = new ArrayList<>();
	 *  
	 *  Toma campos de tablas para el llenado del documento
	 *  en word y así poder transofmarlo a portable document format
	 * 
	 * @author Christopher Espina Riveros
	 * @param plantillaDocx 
	 * datos del documento parametro de entrada en formatop ByteArrayOutputStream
	 * @param parametrosIn  
	 * datos de tabla en la lista List<SccMxTablaAmtzValorDTO>
	 * @param in            
	 * datos de encabezado para mostrar provenientes de la pantalla
	 * @return ByteArrayOutputStream 
	 * datos de la plantilla llena en ByteArrayOutputStream
	 */
	public ByteArrayOutputStream docAmortizacion(ByteArrayOutputStream plantillaDocx,
			List<SccMxTablaAmtzValorDTO> parametrosIn, SccMxTablaAmtzInDTO in) {

		SccMxUtileriasAmortizacionComplemento formatoCifra = new SccMxUtileriasAmortizacionComplemento();
		DateFormat dateFormatPR = new SimpleDateFormat("dd/MM/yyyy");
		Date datePR = new Date();

		TableVariable tableVariablePR = new TableVariable();
		Variables varPR = new Variables();

		List<Variable> pagosPR = new ArrayList<>();
		List<Variable> pFijoPR = new ArrayList<>();
		List<Variable> capitalPR = new ArrayList<>();
		List<Variable> interesesPR = new ArrayList<>();
		List<Variable> ivaPR = new ArrayList<>();
		List<Variable> segurosPR = new ArrayList<>();
		List<Variable> pTotalPR = new ArrayList<>();
		List<Variable> saldoPR = new ArrayList<>();

		InputStream plantillaDocxStream = new ByteArrayInputStream(plantillaDocx.toByteArray());

		Docx templatePR = new Docx(plantillaDocxStream);
		templatePR.setVariablePattern(new VariablePattern("{", "}"));

		try {
			
			varPR = PlantillasUtil.inicializaLeyendaTipoOferta(varPR, in);
			/** Asigna los valores a las variables del Word **/
			varPR.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.PRODUCTO, in.getProducto()));
			varPR.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.FECHA, dateFormatPR.format(datePR)));
			varPR.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.CAT, in.getCat().toString()));
			if (in.getNombreCliente() != null && in.getCodigoCliente() != null) {
				varPR.addTextVariable(
						new TextVariable(TablaAmortizacionPlantillaDef.ACREDITADO, in.getNombreCliente()));
				varPR.addTextVariable(
						new TextVariable(TablaAmortizacionPlantillaDef.BUC, in.getCodigoCliente().toString()));
			} else {
				varPR.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.ACREDITADO, "-"));
				varPR.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.BUC, "-"));
			}
			varPR.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.MONTO,
					formatoCifra.formatoDivisaDecimal(in.getValorCredito())));
			varPR.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.PLAZO, in.getPlazo().toString()));
			varPR.addTextVariable(
					new TextVariable(TablaAmortizacionPlantillaDef.PAGOS, in.getNumeroPagos().toString()));
			varPR.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.PERIODICIDAD, in.getDescPeriodo()));
			varPR.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.TASA,
					formatoCifra.formatoPorcentajeDecimal(in.getTasaInteresAnual())));
			varPR.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.APERTURA,
					formatoCifra.formatoDivisaDecimal(in.getComisionAperturaSinIva())));
			varPR.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.DISPOSICION,
					formatoCifra.formatoDivisaDecimal(in.getComisionDisposicionSinIva())));
			varPR.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.SEGUROS,
					formatoCifra.formatoDivisaDecimal(in.getSeguros())));
			
			templatePR.fillTemplate(varPR);
			pagosPR.add(new TextVariable(TablaAmortizacionPlantillaDef.NOPAGOS, ""));
			pFijoPR.add(new TextVariable(TablaAmortizacionPlantillaDef.PFIJO, ""));
			capitalPR.add(new TextVariable(TablaAmortizacionPlantillaDef.CAPITAL, ""));
			interesesPR.add(new TextVariable(TablaAmortizacionPlantillaDef.INTERES, ""));
			ivaPR.add(new TextVariable(TablaAmortizacionPlantillaDef.IVA, ""));
			segurosPR.add(new TextVariable(TablaAmortizacionPlantillaDef.SEGUROSTABLA, ""));
			pTotalPR.add(new TextVariable(TablaAmortizacionPlantillaDef.PAGOT, ""));
			saldoPR.add(new TextVariable(TablaAmortizacionPlantillaDef.SALDOC,
					formatoCifra.formatoDivisaDecimal(in.getValorCredito())));
			/** Convierte los valores para desplegarlos en la tabla del PDF**/
			for (int i = 1; i < parametrosIn.size(); i++) {
				pagosPR.add(new TextVariable(TablaAmortizacionPlantillaDef.NOPAGOS,
						parametrosIn.get(i).getNumeroPagos().toString()));
				pFijoPR.add(new TextVariable(TablaAmortizacionPlantillaDef.PFIJO,
						formatoCifra.formatoDivisaDecimal(parametrosIn.get(i).getPagoFijo())));
				capitalPR.add(new TextVariable(TablaAmortizacionPlantillaDef.CAPITAL,
						formatoCifra.formatoDivisaDecimal(parametrosIn.get(i).getCapital())));
				interesesPR.add(new TextVariable(TablaAmortizacionPlantillaDef.INTERES,
						formatoCifra.formatoDivisaDecimal(parametrosIn.get(i).getIntereses())));
				ivaPR.add(new TextVariable(TablaAmortizacionPlantillaDef.IVA,
						formatoCifra.formatoDivisaDecimal(parametrosIn.get(i).getIvaDeIntereses())));
				segurosPR.add(new TextVariable(TablaAmortizacionPlantillaDef.SEGUROSTABLA,
						formatoCifra.formatoDivisaDecimal(parametrosIn.get(i).getSeguros())));
				pTotalPR.add(new TextVariable(TablaAmortizacionPlantillaDef.PAGOT,
						formatoCifra.formatoDivisaDecimal(parametrosIn.get(i).getPagoTotal())));
				saldoPR.add(new TextVariable(TablaAmortizacionPlantillaDef.SALDOC,
						formatoCifra.formatoDivisaDecimal(parametrosIn.get(i).getSaldoDeCapital())));
			}
			/**
			 * Ingresa los valores de la pantalla a los asignables al documento word
			 * para llenar la plantilla y transferir el documento
			 */
			tableVariablePR.addVariable(pagosPR);
			tableVariablePR.addVariable(pFijoPR);
			tableVariablePR.addVariable(capitalPR);
			tableVariablePR.addVariable(interesesPR);
			tableVariablePR.addVariable(ivaPR);
			tableVariablePR.addVariable(segurosPR);
			tableVariablePR.addVariable(pTotalPR);
			tableVariablePR.addVariable(saldoPR);
			varPR.addTableVariable(tableVariablePR);
			/** asigna los valores al arraybyte y los manda al documento **/
			templatePR.fillTemplate(varPR);
			ByteArrayOutputStream documentoDocxOut = new ByteArrayOutputStream();
			templatePR.save(documentoDocxOut);
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

	
}
