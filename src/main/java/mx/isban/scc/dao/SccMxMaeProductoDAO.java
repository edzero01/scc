package mx.isban.scc.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import mx.isban.scc.model.SccMxMaeProducto;

/**
 * Implementación de consultas para el Producto
 * Mayo 2019
 * Sprint 1
 * @author GlobalHitss
 *
 */
@Repository
public class SccMxMaeProductoDAO extends AbstractDAO<SccMxMaeProducto> implements ISccMxMaeProductoDAO {

	
	/**
	 * Constructor de la clase
	 * Mayo 2019
	 * Sprint 1
	 * @author GlobalHitss
	 * 
	 */
	public SccMxMaeProductoDAO() {
		super();
	}
	@Override
	protected Class<SccMxMaeProducto> getType() {
		return SccMxMaeProducto.class;
	}
	
	/**
	 * Método para buscar todos los productos
	 * Mayo 2019
	 * Sprint 1
	 * @author GlobalHitss
	 * @return Lista con todos los productos encontrados.
	 */
	@Override
	public List<SccMxMaeProducto> buscaTodos() {
		String sql = " from SccMxMaeProducto ";
		@SuppressWarnings("unchecked")
		Query<SccMxMaeProducto> query = super.getSession().createQuery(sql);
		return query.list();
	}

	/**
	 * Método para buscar producto por id
	 * Mayo 2019
	 * Sprint 1
	 * @author GlobalHitss
	 * @param id identificador único del producto.
	 * @return Regresa el objeto producto encontrado.
	 */
	@Override
	public SccMxMaeProducto buscaProdPorId(long id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" from SccMxMaeProducto where ID_PROD_PK = ");
		sb.append(id);
		String sql = sb.toString();
		@SuppressWarnings("unchecked")
		Query<SccMxMaeProducto> query = super.getSession().createQuery(sql);
		List<SccMxMaeProducto>  result = query.list();
		return result.get(0);
	}

}
