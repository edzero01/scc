package mx.isban.scc.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import mx.isban.scc.model.SccMxPrcGstVariables;
/**
 * DTO auxiliar para la gestion 
 * y mantenimiento de variables
 * @author Chris Espina
 * 
 * Junio 2019
 * Sprint 3
 */
public class SccMxVariablesDTO implements Serializable {
	/**
	 * lista de entidad de variables con su info de gestion
	 */
	private List <SccMxPrcGstVariables> variablesGst;
	/**
	 * identificador para serializar la clase SccMxVariablesDTO
	 */
	private static final long serialVersionUID = 8891123910256078173L;
	
	/**
	 * @return List(SccMxPrcGstVariables) variablesGst
	 */
	public List<SccMxPrcGstVariables> getVariablesGst() {
		return new ArrayList<>(variablesGst);
	}
	/**
	 * @param variablesGst List(SccMxPrcGstVariables)
	 */
	public void setVariablesGst(List<SccMxPrcGstVariables> variablesGst) {
		this.variablesGst = new ArrayList<>(variablesGst);
	}

	
	
}
