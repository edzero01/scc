package mx.isban.scc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.isban.scc.dao.ISccMxGestionVariablesGstDAO;
import mx.isban.scc.model.SccMxPrcGstVariables;
import mx.isban.scc.model.dto.SccMxVariablesCustomDTO;
import mx.isban.scc.model.dto.SccMxVariablesDTO;

/**
 * Implementacion de interfaz para la
 * gestion y mantenimietno de variables
 * 
 * @author Christopher Espina Riveros
 *
 * Global Hitss
 * Junio 2019
 * Sprint 3
 */
@Service
public class GestionVariablesService implements IGestionVariablesService {
	/**
	 *  instancia para la implemantacion 
	 *  de la interfaz IGestionVariablesService
	 */
	@Autowired 
	private ISccMxGestionVariablesGstDAO daoVariables;
	

	/**
	 * Implementacion de metodo de interfaz
	 * para obtencion y mantenimiento de 
	 * variables
	 * 
	 * @author Christopher Espina Riveros
	 * 
	 * @param idSubProd Id del producto
	 * 
	 * @return List(SccMxVariablesCustomDTO) lista variables 
	 * gestion
	 */
	@Override
	public List<SccMxVariablesCustomDTO> obtenInfoVariables(long idSubProd) {
		List<SccMxPrcGstVariables> entidadVariablesGst = new ArrayList<>();
		List<SccMxVariablesCustomDTO> variablesFinal = new ArrayList<>();
		SccMxVariablesDTO variables = new SccMxVariablesDTO();
		entidadVariablesGst = daoVariables.buscaVariables(idSubProd);
		variables.setVariablesGst(entidadVariablesGst);
		
		for(int i = 0; i < variables.getVariablesGst().size(); i++) {
			SccMxVariablesCustomDTO variableFinal = new SccMxVariablesCustomDTO();
			variableFinal.setIdMaeVariablesPk(variables.getVariablesGst().get(i).getSccMxMaeVariables().getIdMaeVariablesPk());
			variableFinal.setCodTipoVar(variables.getVariablesGst().get(i).getSccMxMaeVariables().getCodTipoVar());
			variableFinal.setDscVar(variables.getVariablesGst().get(i).getSccMxMaeVariables().getDscVar());
			variableFinal.setTxtVar(variables.getVariablesGst().get(i).getSccMxMaeVariables().getTxtVar());
			variableFinal.setTxtTooltip(variables.getVariablesGst().get(i).getTtp()); 
			variableFinal.setFlgHblVar(variables.getVariablesGst().get(i).getFlgHblVar() != 0);
			variableFinal.setFlgNti(variables.getVariablesGst().get(i).getFlgNti() !=0);
			variableFinal.setFlgTtp(variables.getVariablesGst().get(i).getFlgTtp() !=0);
			variableFinal.setFlgVsbVar(variables.getVariablesGst().get(i).getFlgVsbVar() !=0 );
			variableFinal.setIdGstVariablesPk(variables.getVariablesGst().get(i).getIdGstVariablesPk());
			variablesFinal.add(variableFinal);
		}

		return variablesFinal;
	}
	
	
}
