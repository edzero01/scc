package mx.isban.scc.dao;


import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import mx.isban.scc.model.SccMxMaeSimuladorDro;
import mx.isban.scc.model.dto.SccMxMaeSimuladorDroDTO;


/**
 *Implementacion de la interfaz 
 *del DAO de la entidad
 *SccMxMaeSimuladorDroDAO 
 *para realizar la consulta
 *del historico de simulaciones
 *Sprint 4.1
 *Fecha Sptiembre 2019
 *@author Hitss
 */
@Repository
public class SccMxMaeSimuladorDroDAO extends AbstractDAO<SccMxMaeSimuladorDro> implements ISccMxMaeSimuladorDroDAO{

	/**
	 * Metodo para consultar historico de simulaciones 
	 * mediante filtros de lista de ids recopilados
	 * desde el front 
	 * @param  sccMxMaeSimuladorDroDTO es un DTO con los datos
	 * de consulta que contiene lista de subproductos y filtros del front
	 *  
	 * */
	@Override
	public List<SccMxMaeSimuladorDro> consultaSimuladorDro(SccMxMaeSimuladorDroDTO sccMxMaeSimuladorDroDTO) {
		StringBuilder sb = new StringBuilder();
		sb.append("select simu ");
		sb.append("from SccMxMaeSimuladorDro simu ");
		sb.append("where ");
		sb.append("simu.idPerfilFk in( ");
		sb.append(generaQueryListLong(sccMxMaeSimuladorDroDTO.getListaIdTipoPerfil()));
		sb.append(" ) ");
		if(!sccMxMaeSimuladorDroDTO.getListaMotivosRechazo().isEmpty()) {
			sb.append("and simu.idMvoRechazoFk in( ");
			sb.append(generaQueryListLong(sccMxMaeSimuladorDroDTO.getListaMotivosRechazo()));		
			sb.append(" )");
		} else {
			 sb.append(" and simu.idMvoRechazoFk is null ");
		}
		if(!sccMxMaeSimuladorDroDTO.getListaIdSubProds().isEmpty()) {
			sb.append("and simu.idSubProdFk in( ");
			sb.append(generaQueryListLong(sccMxMaeSimuladorDroDTO.getListaIdSubProds()));		
			sb.append(" ) ");
		}
		if(sccMxMaeSimuladorDroDTO.getConvAuto() == 2) {
			sb.append(" and simu.flgConvAuto =  0 ");
		
		} else 	if(sccMxMaeSimuladorDroDTO.getConvAuto() == 1) {
			sb.append(" and simu.flgConvAuto =  1 ");
		}
		sb.append(" and trunc(simu.fchSimul) BETWEEN TO_TIMESTAMP('");
		sb.append(sccMxMaeSimuladorDroDTO.getFechaIni());
		sb.append("' ,'YYYY/MM/DD')  AND TO_TIMESTAMP('");
		sb.append(sccMxMaeSimuladorDroDTO.getFechaFin());
		sb.append("','YYYY/MM/DD')");
		
		String sql = sb.toString();
		@SuppressWarnings("unchecked")
		Query<SccMxMaeSimuladorDro> query = super.getSession().createQuery(sql);
		return query.list();
		
		
	}

	
	/**
	 * Sobrescritura metodo de abstract dao
	 */
	@Override
	protected Class<SccMxMaeSimuladorDro> getType() {
		return SccMxMaeSimuladorDro.class;
	}
	
	/**
	 * Metodo para generar la lista de ids a filtrar
	 * regresa la lista de numeros id para ser ingresados
	 * al query de filtrado
	 * @param listaIds
	 * Lista de Ids para generar cadena a concatenar en el query
	 * @return
	 */
	protected String generaQueryListLong(List<Long> listaIds) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <  listaIds.size() ; i++) {
			
			sb.append(listaIds.get(i));
			if(i+1<listaIds.size()) {
				sb.append(" , ");
			}
	    }
		return sb.toString();
	}	

}
