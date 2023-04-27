package mx.isban.scc.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import mx.isban.scc.model.SccMxPrcGstVariables;
import mx.isban.scc.utilerias.ValidaNull;
/**
 * Implementacion de interfaz de datos para obtencion de 
 * informacion de SccMxPrcGstVariables para consultar
 * las variables visibles y ocultas
 * @author Christopher Espina Riveros
 *
 */
@Repository
public class SccMxGestionVariablesGstDAO extends AbstractDAO<SccMxPrcGstVariables> implements ISccMxGestionVariablesGstDAO{


	/**
	 * Sobreescritura de metodo de clase abstracta 
	 */
	@Override
	protected Class<SccMxPrcGstVariables> getType() {
		return SccMxPrcGstVariables.class;
	}
	/**
	 * Implementacion de busqueda de variables 
	 * donde se lee el id de subproducto a filtrar variables
	 * y se retorna la lista de vairables ocultas y 
	 * visibles
	 * @author Christopher Espina Riveros
	 * @param idSubProd
	 * id del subproducto 
	 * @return result
	 * retorna lista de variables
	 */
	@Override
	public List<SccMxPrcGstVariables>  buscaVariables(long idSubProd) {
		StringBuilder sb = new StringBuilder();
		SccMxPrcGstVariables gstVarObj = null;
		ValidaNull oValidaNull = new ValidaNull();
		List<SccMxPrcGstVariables> lista = new ArrayList<SccMxPrcGstVariables>();
		sb.append("select p, t.txtTtp from SccMxPrcGstVariables p LEFT JOIN SccMxMaeTtp t on t.idVarFk=p.idGstVariablesPk where p.idSubProdFk = ");
		sb.append(idSubProd);
		String sql = sb.toString();
		List<?>  result = super.getSession().createQuery(sql).list();
		for(int i=0; i<result.size(); i++) {
			Object[] row = (Object[]) result.get(i);
			gstVarObj = new SccMxPrcGstVariables();
			gstVarObj = (SccMxPrcGstVariables)row[0];
			gstVarObj.setTtp(oValidaNull.validaNullString(row[1]).toString());
			lista.add(gstVarObj);
		}

		return lista;
	}

}
