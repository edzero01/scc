package mx.isban.scc.utilerias;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;

import mx.isban.scc.model.dto.SccMxTablaRiesDTO;
import mx.isban.scc.model.dto.SccMxTablaRiesValorDTO;
import mx.isban.scc.utilerias.plantillas.PlantillaRies;

/**
 * Clase para plantilla Ries139
 * 
 * @author José Luis Garcia
 * 
 */
@ManagedBean
public class CalculaRies {
	/**
	 * Constante private static final del tipo Logger, de  clase CalculaPFPUSG, con un solo espacio de memoria e inmutable con la
	 * finalidar de llevar el registro del log
	 */
	/**
	 * Dependencia de path
	 */
	@Autowired
	private PlantillaRies path;
	/**
	 * Método de clase para tabla Ries139
	 */
	public ByteArrayOutputStream calculaRies(SccMxTablaRiesDTO tablaRies139, ByteArrayOutputStream plantillaDocx) {
		List<SccMxTablaRiesValorDTO> tablaRiesValor = new ArrayList<>();

		return path.docRies(
				plantillaDocx,
				tablaRiesValor, tablaRies139);
	}
}
