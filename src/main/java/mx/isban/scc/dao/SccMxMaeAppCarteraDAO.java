package mx.isban.scc.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import mx.isban.scc.model.SccMxMaeAppCartera;

/**
 * Implementacion de interfaz de datos para obtencion de 
 * informacion de SccMxMaeAppCartera
 * @author Christopher Espina Riveros
 *
 */
@Repository
public class SccMxMaeAppCarteraDAO extends AbstractDAO<SccMxMaeAppCartera> implements ISccMxMaeAppCarteraDAO {


	/**
	 * Sobreescritura de metodo de clase abstracta 
	 */
	@Override
	protected Class<SccMxMaeAppCartera> getType() {
		return SccMxMaeAppCartera.class;
	}

	/**
	 * Implementacion de busqueda de cartera 
	 * @author Christopher Espina Riveros
	 * @param idCliente
	 * id del cliente 
	 * @param credito
	 * credito a sustituir
	 * @param codProducto
	 * id de producto 
	 * @return result
	 * retorna dato unico de cartera
	 */
	@Override
	public SccMxMaeAppCartera obtenDtoCartera(long idCliente, long credito, long codProducto) {
		StringBuilder sb = new StringBuilder();
		sb.append("from SccMxMaeAppCartera where NUM_CLTE = ");
		sb.append(idCliente);
		sb.append(" and NUM_CDTO = ");
		sb.append(credito);
		sb.append(" and COD_PROD IN (SELECT codProd FROM SccMxMaeTipoCartera WHERE flgCartera = 1)");
		
		String sql = sb.toString();
		@SuppressWarnings("unchecked")
		Query<SccMxMaeAppCartera> query = super.getSession().createQuery(sql);
		return query.uniqueResult();
	}

	/**
	 * Implementacion del método  obtenCreditosClientePorProducto
	 * @author Octavio Cruz Rosas
	 * @param idCliente
	 * id del cliente 
	 * 
	 * @return List(SccMxMaeAppCartera)
	 * regresa lista con los créditos de cartera
	 */
	@Override
	public List<SccMxMaeAppCartera> obtenCreditosClientePorProducto(Long idCliente) {
		StringBuilder sb = new StringBuilder();
		sb.append("from SccMxMaeAppCartera where COD_PROD IN (SELECT codProd FROM SccMxMaeTipoCartera WHERE flgCartera = 1) AND NUM_CLTE = ");
		sb.append(idCliente);
		String sql = sb.toString();
		@SuppressWarnings("unchecked")
		Query<SccMxMaeAppCartera> query = super.getSession().createQuery(sql);
		return query.list();
	}

}
