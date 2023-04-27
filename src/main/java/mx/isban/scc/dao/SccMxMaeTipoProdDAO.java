package mx.isban.scc.dao;

import java.util.List;

import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import mx.isban.scc.model.SccMxMaeTipoProd;

/**
 * Implementación de la obtención de la lista de tipo de producto para la
 * simulación Mayo 2019 Sprint 1
 * Actualización Noviembre 2019
 * Producto Final
 * @author Gabriel Dolores Garcia
 *
 */
@Repository
public class SccMxMaeTipoProdDAO extends AbstractDAO<SccMxMaeTipoProd> implements ISccMxMaeTipoProdDAO {

	/**
	 * Constructor de la clase Mayo 2019 Sprint 1
	 * Actualizacion Noviembre 2019
	 * Producto Final
	 * @author Gabriel Dolores Garcia
	 */
	public SccMxMaeTipoProdDAO() {
		super();
	}

	/**
	 * Metodo para que regresa el tipo de producto
 	 * @return SccMxMaeTipoProd.class Clase SccMxMaeTipoProd
	 */
	@Override
	protected Class<SccMxMaeTipoProd> getType() {
		return SccMxMaeTipoProd.class;
	}

	/**
	 * Método abstracto para buscar todos los tipos de producto por modalidad
	 * Noviembre 2019 Sprint 1
	 * 
	 * @param modalidad recibe la modalidad a usar para el filtrado de tipos de
	 *                  productos
	 * @return lista todos los tipos de productos.
	 */

	@Override
	public List<SccMxMaeTipoProd> buscaTodos(Integer... modalidad) {

		if ((modalidad == null) || (modalidad.length == 0)) {
			String sql = " from SccMxMaeTipoProd order by dscTipoProducto asc, idTipoProductoPk desc ";
			@SuppressWarnings("unchecked")
			Query<SccMxMaeTipoProd> qry = getSession().createQuery(sql);
			return qry.list();
		}

		StringBuilder sql = new StringBuilder();
		sql.append("select id_tipo_producto_pk, dsc_tipo_producto, id_agrupado_consumo_fk, id_modalidad_fk");
		sql.append(" from scc_mx_mae_tipo_prod");
		sql.append(" where id_modalidad_fk in (:modalidad, :ambas)");
		sql.append(" order by dsc_tipo_producto asc");

		@SuppressWarnings("unchecked")
		NativeQuery<SccMxMaeTipoProd> qry = super.getSession().createNativeQuery(sql.toString());
		qry.setParameter("modalidad", modalidad[0]);
		qry.setParameter("ambas", 3);
		qry.addEntity(SccMxMaeTipoProd.class);
		return qry.list();
	}

}
