package mx.isban.scc.utilerias;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import mx.isban.scc.model.dto.SccMxTablaCaratulaDTO;
import mx.isban.scc.model.dto.SccMxTablaCaratulaValorDTO;
import mx.isban.scc.utilerias.plantillas.PlantillaCaratula;

/**
 * Clase para Carátula de Crédito
 * 
 * @author José Luis Garcia
 * 
 */
@ManagedBean
public class CalculaCaratula {
	/**
	 * Constante private static final del tipo Logger, de  clase CalculaPFPUSG, con un solo espacio de memoria e inmutable con la
	 * finalidar de llevar el registro del log
	 */
	/**
	 * Dependencia de path
	 */
	@Autowired
	private PlantillaCaratula path;
	/**
	 * Método de clase y de utileria para calcular la información de la 
	 * carátula de crédito
	 * 
	 */
	public ByteArrayOutputStream calculaCaratula(SccMxTablaCaratulaDTO tablaCar, ByteArrayOutputStream plantillaDocx) {
		List<SccMxTablaCaratulaValorDTO> tablaCaratulaValor = new ArrayList<>();
		return path.docCaratula(
				plantillaDocx,
				tablaCaratulaValor, tablaCar);
	}
}
