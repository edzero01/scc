package mx.isban.scc.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import mx.isban.scc.model.SccMxMaePeriod;
import mx.isban.scc.model.SccMxMaeProducto;


/**
 * Implementación de la consulta en base de datos  de periodicidades
 * Mayo 2019
 * Sprint 1
 * @author GlobalHitss
 *
 */
@Repository
public class SccMxMaePeriodicidadDAO extends AbstractDAO<SccMxMaePeriod> implements ISccMxMaePeriodicidadDAO {

	/**
	 * Constructor de la clase
     * Mayo 2019
     * Sprint 1
	 * @author GlobalHitss
	 */
	public SccMxMaePeriodicidadDAO() {
		super();
	}

	/**
	 * Metodo para que regresa el tipo de periodo
	 * @return SccMxMaePeriod.class Clase SccMxMaePeriod
	 */
@Override
	protected Class<SccMxMaePeriod> getType() {
		return SccMxMaePeriod.class;
	}
	
	/**
	 * Método para buscar todos los los períodos
	 * Mayo 2019
     * Sprint 1
	 * @author GlobalHitss
	 * @return List(SccMxMaePeriod) Lista con los períodos encontrados.
	 */
	@Override
	public List<SccMxMaePeriod> buscaTodos() {
		String sql = " from SccMxMaePeriod order by numDiasPeriod asc ";
		@SuppressWarnings("unchecked")
		Query<SccMxMaePeriod> query = super.getSession().createQuery(sql);
		return query.list();
	}
	
	/**
	 * Método abstracto para buscar todos los períodos ordenados por hash
     * Mayo 2019
     * Sprint 1
	 * @author GlobalHitss
	 * @return hash con  todos los períodos encontrados cuya llave es codPeriod
	 */
	@Override
	public HashMap<String, SccMxMaePeriod> buscaTodosHash() {
		List<SccMxMaePeriod> periodos = this.buscaTodos();
		LinkedHashMap<String, SccMxMaePeriod> hash = new LinkedHashMap<>();
		for (SccMxMaePeriod p : periodos) {
			hash.put(p.getCodPeriod(), p);
		}
		return hash;
	}

	/**
	 * Método para buscar período por id
	 * Mayo 2019
     * Sprint 1
	 * @author GlobalHitss
	 * @param dscPeriod descriocion unico del período.
	 * @return SccMxMaePeriod Regresa período encontrado.
	 */
	@Override
	public SccMxMaePeriod buscaPeriodPorId(String dscPeriod) {
		StringBuilder sb = new StringBuilder();
		sb.append(" from SccMxMaePeriod where DSC_PERIOD = '");
		sb.append(dscPeriod);
		sb.append("'");
		String sql = sb.toString();
		@SuppressWarnings("unchecked")
		Query<SccMxMaePeriod> query = super.getSession().createQuery(sql);
		List<SccMxMaePeriod>  result = query.list();
		return result.get(0);
	}

	/**
	 * Método para buscar período por id de producto
	 * Mayo 2019
     * Sprint 1
	 * @author GlobalHitss
	 * @param id identificador unico del producto.
	 * @return Query(SccMxMaeProducto) query
	 */
	@Override
	public List<SccMxMaeProducto> buscaPeriodPorIdProd(long id) {
		StringBuilder sb = new StringBuilder();
		sb.append("from SccMxMaeProducto where ID_PROD_PK = ");
		sb.append(id);
		String sql = sb.toString();
		@SuppressWarnings("unchecked")
		Query<SccMxMaeProducto> query = super.getSession().createQuery(sql);
		return query.list();
		
	}
}
