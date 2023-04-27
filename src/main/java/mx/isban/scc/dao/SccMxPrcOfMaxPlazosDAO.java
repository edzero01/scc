package mx.isban.scc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import mx.isban.scc.model.SccMxPrcOferMaxPlzo;
import mx.isban.scc.model.dto.SccMxTablaOfMaxDTO;


/**
 * Implementacion del DAO para ofertas
 * máximas por plazo que es
 * la tabla especial para
 * las campanias del simulador
 * para apartados en front end
 * de ofertas maximas con sus
 * plazos
 * 
 * Busca plazos
 * Extrae ofertas maximas
 * para tabla de ofertas
 * maximas
 * 
 * Global Hitss
 * Mayo 2019
 * Sprint 2
 * @author baruchlw
 *
 */
@Repository
public class SccMxPrcOfMaxPlazosDAO extends AbstractDAO<SccMxPrcOferMaxPlzo> implements ISccMxPrcOfMaxPlazosDAO {

	/**
	 * Constructor vacío
	 */
	public SccMxPrcOfMaxPlazosDAO() {
		super();
	}
	
	
	@Override
	/**
	 * Método para obtener los plazos
	 * recibe el id de la tasa
	 * retorna la lista de plazos
	 * @param idTasa long id de la tasa
	 * @return List(SccMxPrcOferMaxPlzo) Lista de objetos de clase SccMxPrcOferMaxPlzo
	 */ 
	public List<SccMxPrcOferMaxPlzo> buscaPlazos(long idTasa) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(" from scc_mx_prc_ofer_max_plzo where id_ofer_max_tasa_fk = ");
		sb.append(idTasa);
		String sql = sb.toString();
		
		@SuppressWarnings("unchecked")
		Query<SccMxPrcOferMaxPlzo> query = super.getSession().createQuery(sql);
		return query.getResultList();
	}


	/**
	 * Obtiene el tipo del objeto que se usará en el dao
	 * @return el tipo del objeto  
	 */
	@Override
	protected Class<SccMxPrcOferMaxPlzo> getType() {
		return SccMxPrcOferMaxPlzo.class;
	}


	
	/** 
	 * declaracion del metodo que trae la tabla de ofertas maximas
	 * Esa lista se despliega en FE para q el usuario elija el plazo
	 * @param idTasa id de la tasa elegida por el usuario
	 * @param idOfCam id oferta maxima
	 * @return List(SccMxTablaOfMaxDTO) Lista de plazos
	 */
	@Override
	public List<SccMxTablaOfMaxDTO> getTablaOfMax(long idTasa, long idOfCam) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select plazo.can_plzo, plazo.imp_monto, tasa.por_tasa");
		sb.append(" from scc_mx_prc_ofer_max_plzo plazo, scc_mx_prc_ofer_max_tasa tasa");
		sb.append(" where");
		sb.append(" plazo.id_ofer_max_tasa_fk = tasa.id_ofer_max_tasa_pk"); 
		sb.append(" and tasa.id_ofer_cam_fk = ");
		sb.append(idOfCam);		
		sb.append(" and tasa.id_ofer_max_tasa_pk = ");
		sb.append(idTasa);
		String sql = sb.toString();
		Query<?> query = super.getSession().createSQLQuery(sql);
		@SuppressWarnings("unchecked")
		List<Object[]>  result = (List<Object[]>) query.getResultList();
		List<SccMxTablaOfMaxDTO> data = new ArrayList<>();
		for (Object [] obj : result) {
			SccMxTablaOfMaxDTO dto = new SccMxTablaOfMaxDTO();
			Object val = obj[0];
			val.getClass();
			dto.setNumPlazos( 0L );
			
			data.add(dto);
		}
		return data;
	}

}
