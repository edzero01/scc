package mx.isban.scc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import mx.isban.scc.model.SccMxMaeSegmento;

/**
 * Implementación de las consultas de Segmento
 * que es el identificador que trae la tabla de campañas en relacion
 * al usuario.
 * de acuerdo al segmento del usuario se obtiene la informacion
 * de conversion auto en la simulacion
 * Mayo 2019
 * Sprint 1
 * @author GlobalHitss
 *
 */
@Repository
public class SccMxMaeSegmentoDAO extends AbstractDAO<SccMxMaeSegmento> implements ISccMxMaeSegmentoDAO {

	/**
	 * Constructor de la clase
     * Mayo 2019
     * Sprint 1
	 * @author GlobalHitss
	 */
	public SccMxMaeSegmentoDAO() {
		super();
	}
	
	/**
	 * Metodo para que regresa el segmento
 	 * @return SccMxMaeSegmento.class Clase SccMxMaeSegmento
	 */
	@Override
	protected Class<SccMxMaeSegmento> getType() {
		return SccMxMaeSegmento.class;
	}
	
	/**
	 * Método para buscar todos los segmentos
	 * Mayo 2019
     * Sprint 1
	 * @author GlobalHitss
	 * @return Lista con todos los objetos SccMxMaeSegmento encontrados.
	 */
	@Override
	public List<SccMxMaeSegmento> buscaTodos() {
		
		String sql = " select distinct c.id_convauto_pk, c.dsc_segmento_consolidado " + 
				"from SCC_MX_MAE_SEGMENTO s right outer join SCC_MX_MAE_CONVAUTO c " + 
				"on s.id_convauto_fk = c.id_convauto_pk "
				+ "order by c.dsc_segmento_consolidado asc";
		@SuppressWarnings("rawtypes")
	NativeQuery query = getSession().createNativeQuery(sql);
		@SuppressWarnings("unchecked")
		List<Object[]> data = query.list();
		List<SccMxMaeSegmento> result = new ArrayList<>();
		for (Object[] elem : data) {
			SccMxMaeSegmento vo = new SccMxMaeSegmento();
			vo.setIdSegmentoPk( Long.parseLong(elem[0].toString()));
			vo.setDscSegmento(String.valueOf(elem[1]));
			result.add(vo);
		}
		return result;
	}

	/**
	 * Método para buscar segmento por id
	 * Mayo 2019
     * Sprint 1
	 * @author GlobalHitss
	 * @param id identificador único del segmento.
	 * @return Objeto segmento encontrado.
	 */
	@Override
	public SccMxMaeSegmento buscaSegPorId(long id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" from SccMxMaeSegmento where ID_SEGMENTO_PK = ");
		sb.append(id);
		String sql = sb.toString();
		@SuppressWarnings("unchecked")
		Query<SccMxMaeSegmento> query = super.getSession().createQuery(sql);
		List<SccMxMaeSegmento>  result = query.list(); 
		return result.get(0);
	}

}
