package mx.isban.scc.utilerias;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import mx.isban.scc.model.dto.SccMxAmtzAmortizationPeriodDataDTO;
import mx.isban.scc.model.dto.SccMxTablaMagisterioDTO;
import mx.isban.scc.utilerias.plantillas.PlantillaPlanMagisterio;

/**
 * Clase para Amortizacion Magisterio
 * 
 * @author José Luis Garcia
 * 
 */
@ManagedBean
public class CalculaPlanMagisterio {
	/**
	 * Constante private static final del tipo Logger, con un solo espacio de memoria e inmutable con la
	 * finalidar de llevar el registro del log
	 */
	/**
	 * Dependencia de path
	 */
	@Autowired
	private PlantillaPlanMagisterio path;
	/**
	 * Método de clase y de utileria para calcular la información de la tabla amortizacion plan magisterio
	 * 
	 * 
	 */
	public ByteArrayOutputStream calculaPlanMagisterio(SccMxTablaMagisterioDTO tablaAmtzMagisterio, ByteArrayOutputStream plantillaDocx) {
		List<SccMxAmtzAmortizationPeriodDataDTO> tablaPlanMagisterioValor = new ArrayList<>();
		
		for (int i = 0; i < tablaAmtzMagisterio.getAmortizationRec().getAmortizationInfo().getAmortizationPeriodData().size(); i++) {
			SccMxAmtzAmortizationPeriodDataDTO tablaMagisValor = new SccMxAmtzAmortizationPeriodDataDTO();
			tablaMagisValor = tablaAmtzMagisterio.getAmortizationRec().getAmortizationInfo().getAmortizationPeriodData().get(i);
			
			tablaPlanMagisterioValor.add(tablaMagisValor);
		}
		
		return path.docAmortizacion(
				plantillaDocx,
				tablaPlanMagisterioValor, tablaAmtzMagisterio);
	}
}
