package mx.isban.scc.dao;


import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import mx.isban.scc.model.SccMxMaeConvauto;
import mx.isban.scc.model.dto.SccMxConvAutoLinexDTO;


/**
 * Implementación de las consultas para la sección de 
 * Conversión Auto
 * Proyecto Simulador Santander
 * Sólo tiene que traerse la Tasa 
 * las busca por ID de Segmento o por LAPA
 * @author baruchlw
 *
 */

@Repository
public class SccMxMaeConvAutoDAO extends AbstractDAO<SccMxMaeConvauto> implements ISccMxMaeConvAutoDAO {

	/**
	 * Constructor Vacío
	 */
	public SccMxMaeConvAutoDAO() {
		super();
	}
	
	/**
	 * Metodo para buscar la tasa por numero de LAPA
	 * @param numLapa
	 * Recibe la Lapa
	 * @return Double
	 * regresa el porcentaje de tasa a aplicar en el 
	 * apartado de conversión auto
	 */
	@Override
	public Double buscaTasaPorNumLapa(long numLapa) {
		
		
		StringBuilder sb = new StringBuilder();
		sb.append(" from SccMxMaeConvauto ca  where NUM_LAPA = ");
		sb.append(numLapa);
		String sql = sb.toString();

		@SuppressWarnings("unchecked")
		Query<SccMxMaeConvauto> query = super.getSession().createQuery(sql);
		SccMxMaeConvauto  result = query.uniqueResult();
		return result.getPorTasa();

	}

	/**
	 * Metodo para buscar la tasa por numero de Segmento
	 * @param idSegmento
	 * Recibe el Id del Segmento elegido
	 * @return Double
	 * regresa el porcentaje de tasa a aplicar en el 
	 * apartado de conversión auto
	 */
	@Override
	public SccMxMaeConvauto buscaTasaPorSegmento(long idSegmento) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(" from SccMxMaeConvauto ca  where ID_CONVAUTO_PK = ");
		sb.append(idSegmento);
		String sql = sb.toString();

		@SuppressWarnings("unchecked")
		Query<SccMxMaeConvauto> query = super.getSession().createQuery(sql);

		return query.uniqueResult();
	}

	/**
	 * Metodo para que  regresaa el tipo
	 * @return SccMxMaeConvauto.class Clase SccMxMaeConvauto
	 */
	@Override
	protected Class<SccMxMaeConvauto> getType() {
		return SccMxMaeConvauto.class;
	}
	
	/**
	 * Metodo para obtener tasa conv auto
	 * por segmento 
	 * @param idSegmento
	 * segmento de conversion auto
	 * @param idPeriodicidad
	 * id de la periodicidad a filtrar
	 * @param plazo
	 * numero de plazo en dias
	 * @return 
	 * DTO Linex de datos para conversion auto
	 */
	public SccMxConvAutoLinexDTO buscaConvAutoLinexData(Long idSegmento, Long idPeriodicidad, Long plazo) {
		
		StringBuilder sr = new StringBuilder();
		sr.append(" select CF.NUM_PLAZO, CF.POR_FAC_MONTO_TOTAL, CF.POR_TASA_INT_BASE, CF.NUM_LAPA "
				+ " from SCC_MX_MAE_CONVAUTO CA, scc_mx_mae_cond_finan CF "
				+ " where CA.NUM_LAPA = CF.NUM_LAPA "
				+ " and CF.NUM_PLAZO = ");
		sr.append(plazo);
		sr.append(" and cf.id_period_fk = " ); 
		sr.append(idPeriodicidad);
		sr.append(" and CA.id_convauto_pk = ");
		sr.append(idSegmento);
		
		String sql = sr.toString();
		List<?>  result = super.getSession().createSQLQuery(sql).list();
		SccMxConvAutoLinexDTO dtoConvAuto = new SccMxConvAutoLinexDTO();
		
		for(int i=0; i<result.size(); i++) {
			Object[] row = (Object[]) result.get(i);
			dtoConvAuto.setPlazo(new Long(row[0].toString()));
			dtoConvAuto.setFactorMontoTotal(new Double(row[1].toString()));
			dtoConvAuto.setTasaInteresBase(new Double(row[2].toString()));
			dtoConvAuto.setNumLapa(new Long(row[3].toString()));
		}
		
		return dtoConvAuto;
		
	}
	

}
