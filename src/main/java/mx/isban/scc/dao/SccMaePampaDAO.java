package mx.isban.scc.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import mx.isban.scc.model.SccMxMaePampa;

/**
 * Implementacion de interfaz de datos para obtencion de 
 * informacion de SccMxMaePampa
 * @author Christopher Espina Riveros
 * Modificado por Lorena baruch
 * 21 de Oct 2019
 */

@Repository
public class SccMaePampaDAO extends AbstractDAO<SccMxMaePampa> implements ISccMxMaePampaDAO{


	/**
	 * Sobreescritura de metodo de clase abstracta 
	 */
	@Override
	protected Class<SccMxMaePampa> getType() {
		return SccMxMaePampa.class;
	}
	/**
	 * Implementacion de busqueda de pampa 
	 * @author Christopher Espina Riveros
	 * Modificado por Lorena Baruch
	 * @param idCliente
	 * id de cliente
	 * @param credito
	 * Numero de Contrato obtenido de Campaña
	 * @param sucursal
	 * ID de la sucursal que viene en campaña
	 * @return List<SccMxMaePampa>
	 * Lista de los registros de pampa, ya que puede haber más de uno con el mismo crédito y sucursal y se debe considerar
	 * los datos para el cálculo de la prima devengada
	 */
	@Override
	public List<SccMxMaePampa> obtenPampa(long credito, long sucursal) {
		StringBuilder sb = new StringBuilder();
		sb.append(" from SccMxMaePampa p where ");
		sb.append(" TXT_CNTO_TDC = ");
		sb.append(credito);
		sb.append(" and ID_CNTR_ALTA = ");
		sb.append(sucursal);
		sb.append(" ORDER BY ID_PAMPA_PK DESC ");
		
		String sql = sb.toString();
		@SuppressWarnings("unchecked")
		Query<SccMxMaePampa> query = super.getSession().createQuery(sql);
			
		return  query.list();
	}

}
