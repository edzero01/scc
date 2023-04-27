package mx.isban.scc.dao;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import mx.isban.scc.model.SccMxMaeVariables;
/**
 * Implementacion de interfaz de datos para gestión de variables
 * @author Christopher Espina Riveros
 *
 */
@Repository
public class SccMxGestionVariablesDAO extends AbstractDAO<SccMxMaeVariables> implements ISccMxGestionVariablesDAO{


	/**
	 * Sobreescritura de metodo de clase abstracta 
	 */
	@Override
	protected Class<SccMxMaeVariables> getType() {
		return SccMxMaeVariables.class;
	}
	/**
	 * Implementacion de busqueda de variables 
	 * @author Christopher Espina Riveros
	 * @param idVar Id de la varialbe a buscar
	 * @return SccMxMaeVariables lista de variables
	 */
	@Override
	public SccMxMaeVariables  buscaVariables(long idVar) {
		StringBuilder sb = new StringBuilder();
		sb.append("from SccMxMaeVariables where ID_MAE_VARIABLES_PK = ");
		sb.append(idVar);
		String sql = sb.toString();
		@SuppressWarnings("unchecked")
		Query<SccMxMaeVariables> query = super.getSession().createQuery(sql);
		return query.uniqueResult();
	}

}
