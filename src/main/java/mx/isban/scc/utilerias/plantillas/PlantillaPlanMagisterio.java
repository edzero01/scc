package mx.isban.scc.utilerias.plantillas;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

import javax.annotation.ManagedBean;

import org.slf4j.Logger;

import mx.isban.scc.model.dto.SccMxAmtzAmortizationPeriodDataDTO;
import mx.isban.scc.model.dto.SccMxTablaAmtzInDTO;
import mx.isban.scc.model.dto.SccMxTablaMagisterioDTO;
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
 * frances con prima unica. Se llenan los campos de entrada que son: producto
 * fecha cat acreditado buc monto plazo pagos periodicidad tasa comision
 * apertura comision disposicion seguros
 * 
 * Para la tabla se llenan: nomero de pago pago fijo capital intereses iva de
 * intereses seguros pago total saldo
 * 
 * El método principal que se encarga del llenado de la tabla es
 * 
 *
 * @see #docAmortizacion(ByteArrayOutputStream, List, SccMxTablaAmtzInDTO)
 * 
 * @author Jose Luis Garcia
 *
 */
@ManagedBean
public class PlantillaPlanMagisterio {

	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con la
	 * finalidar de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PlantillaPlanMagisterio.class);

	/**
	 * Metodo para llenado de plantilla de tabla amortizacion utilizando listas para
	 * el paso de la información enter clases:
	 * 
	 * List<Variable> pagosPR = new ArrayList<>(); List<Variable> pFijoPR = new
	 * ArrayList<>(); List<Variable> capitalPR = new ArrayList<>(); List<Variable>
	 * interesesPR = new ArrayList<>(); List<Variable> ivaPR = new ArrayList<>();
	 * List<Variable> segurosPR = new ArrayList<>(); List<Variable> pTotalPR = new
	 * ArrayList<>(); List<Variable> saldoPR = new ArrayList<>();
	 * 
	 * Toma campos de tablas para el llenado del documento en word y así poder
	 * transofmarlo a portable document format
	 * 
	 *
	 * @param plantillaDocx datos del documento parametro de entrada en formatop
	 *                      ByteArrayOutputStream
	 * @param parametrosIn  datos de tabla en la lista List<SccMxTablaAmtzValorDTO>
	 * @param in            datos de encabezado para mostrar provenientes de la
	 *                      pantalla
	 * @return ByteArrayOutputStream datos de la plantilla llena en
	 *         ByteArrayOutputStream
	 */
	public ByteArrayOutputStream docAmortizacion(ByteArrayOutputStream plantillaDocx,
			List<SccMxAmtzAmortizationPeriodDataDTO> parametrosIn, SccMxTablaMagisterioDTO in) {

		SccMxUtileriasAmortizacionComplemento formatoCifra = new SccMxUtileriasAmortizacionComplemento();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();

		TableVariable tableVariable = new TableVariable();
		Variables var = new Variables();

		List<Variable> pagos = new ArrayList<>();
		List<Variable> pFijo = new ArrayList<>();
		List<Variable> capital = new ArrayList<>();
		List<Variable> intereses = new ArrayList<>();
		List<Variable> iva = new ArrayList<>();
		List<Variable> pTotal = new ArrayList<>();
		List<Variable> saldo = new ArrayList<>();

		InputStream plantillaDocxStream = new ByteArrayInputStream(plantillaDocx.toByteArray());

		Docx template = new Docx(plantillaDocxStream);
		template.setVariablePattern(new VariablePattern("{", "}"));

		try {

			/** Asigna los valores a las variables del Word **/
			var.addTextVariable(
					new TextVariable(TablaAmortizacionPlantillaDef.PRODUCTO, in.getTablaCat().getProducto()));
			var.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.FECHA, dateFormat.format(date)));

			var.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.CAT,
					(formatoDivisaUnDecimal(in.getTablaCat().getCat())).toString()));

			if (in.getTablaCat().getNombreCliente() != null) {
				var.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.ACREDITADO,
						in.getTablaCat().getNombreCliente()));
			} else {
				var.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.ACREDITADO, "-"));
			}
			if (in.getTablaCat().getCodigoCliente() != null) {
				var.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.BUC,
						in.getTablaCat().getCodigoCliente().toString()));
			} else {
				var.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.BUC, "-"));
			}
			var.addTextVariable(
					new TextVariable(TablaAmortizacionPlantillaDef.PLAZO, in.getTablaCat().getPlazo().toString()));
			var.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.PAGOS,
					in.getTablaCat().getNumeroPagos().toString()));
			var.addTextVariable(
					new TextVariable(TablaAmortizacionPlantillaDef.PERIODICIDAD, in.getTablaCat().getDescPeriodo()));
			
			Double monto =Double.parseDouble(in.getAmortizationRec().getAmortizationInfo().getInstalmentCurAmt().getAmt());
			var.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.MONTO,
					formatoCifra.formatoDivisaDecimal(monto)));
			var.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.SEGUROS, in.getTablaCat().getSeguros()));
			var.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.CAUCION, in.getCaucion().toString()));
			var.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.TASA,
					formatoCifra.formatoPorcentajeDecimal(in.getTablaCat().getTasaInteresAnual())));
			var.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.APERTURA,
					formatoCifra.formatoDivisaDecimal(in.getTablaCat().getComisionPorApertura())));
			var.addTextVariable(new TextVariable(TablaAmortizacionPlantillaDef.DISPOSICION,
					formatoCifra.formatoDivisaDecimal(in.getTablaCat().getComisionPorDisposicion())));
			template.fillTemplate(var);

			String sCapital = null;
			String sInteres = null;
			String sIva = null;
			/** Convierte los valores para desplegarlos en la tabla del PDF **/
			for (int i = 1; i < parametrosIn.size(); i++) {

				for (int a = 0; a < parametrosIn.get(i).getCompositeCurAmt().size(); a++) {
					if (parametrosIn.get(i).getCompositeCurAmt().get(a).getCompositeCurAmtType().equals("Principal")) {
						sCapital = parametrosIn.get(i).getCompositeCurAmt().get(a).getCurAmt().getAmt();
					}

					if (parametrosIn.get(i).getCompositeCurAmt().get(a).getCompositeCurAmtType().equals("Interest")) {
						sInteres = parametrosIn.get(i).getCompositeCurAmt().get(a).getCurAmt().getAmt();
					}

					if (parametrosIn.get(i).getCompositeCurAmt().get(a).getCompositeCurAmtType().equals("Tax")) {
						sIva = parametrosIn.get(i).getCompositeCurAmt().get(a).getCurAmt().getAmt();
					}
				}

				pagos.add(new TextVariable(TablaAmortizacionPlantillaDef.NOPAGOS, parametrosIn.get(i).getDueDt()));
				pFijo.add(new TextVariable(TablaAmortizacionPlantillaDef.PFIJO,
						parametrosIn.get(i).getInstalmentCurAmt().getAmt()));
				capital.add(new TextVariable(TablaAmortizacionPlantillaDef.CAPITAL, sCapital));
				intereses.add(new TextVariable(TablaAmortizacionPlantillaDef.INTERES, sInteres));
				iva.add(new TextVariable(TablaAmortizacionPlantillaDef.IVA, sIva));
				pTotal.add(new TextVariable(TablaAmortizacionPlantillaDef.PAGOT,
						parametrosIn.get(i).getTotalCurAmt().getAmt()));
				saldo.add(new TextVariable(TablaAmortizacionPlantillaDef.SALDOC,
						parametrosIn.get(i).getStmtRunningBal().getAmt()));
			}
			/**
			 * Ingresa los valores de la pantalla a los asignables al documento word para
			 * llenar la plantilla y transferir el documento
			 */
			tableVariable.addVariable(pagos);
			tableVariable.addVariable(pFijo);
			tableVariable.addVariable(capital);
			tableVariable.addVariable(intereses);
			tableVariable.addVariable(iva);
			tableVariable.addVariable(pTotal);
			tableVariable.addVariable(saldo);
			var.addTableVariable(tableVariable);
			/** asigna los valores al arraybyte y los manda al documento **/
			template.fillTemplate(var);

			ByteArrayOutputStream documentoDocxOut = new ByteArrayOutputStream();
			template.save(documentoDocxOut);
			return documentoDocxOut;

		} catch (OpenDocxException e) {
			LOGGER.error(e.getMessage(), e);
			/**
			 * En caso de no poder llenar la información del documento, regresa null que se
			 * valida en clases posteriores, es decirr en aquellas que la invocaron
			 */
			return null;
		}
	}

	/**
	 * 
	 * Metodo para formatear a MN
	 * 
	 * @author Christopher Espina Riveros
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
