package mx.isban.scc.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import mx.isban.scc.model.SccMxMaeTiie;

/**
 * Implementación de la consulta
 * para las variables obtenidas de 
 * tasa TIIE para 
 * presentarlas en front end
 * de simulador
 * Junio 2019
 * Sprint 2
 * @author Ivan Cruz Azuara
 * GlobalHitss
 * Fabrica de Software
 * Proyecto Simulador de 
 * Crédito al Consumo
 */
@Repository
public class SccMxMaeTasaTiieDAO  extends AbstractDAO<SccMxMaeTiie> implements ISccMxMaeTasaTiieDAO {

	/**
	 * Confirmando si las lineas
	 * cuentan despues del override
	 * Para mover el comentario que está arriba.
	 */
	@Override
	protected Class<SccMxMaeTiie> getType() {
	
		return SccMxMaeTiie.class;
	}

	/**
	 * Metodo para obtener la Tasa TIIE mas actual
	 */
	@Override
	public Double buscaUltimaTasaTIIE() {
		Double resulTasa = null;
		StringBuilder sb = new StringBuilder();
		sb.append("select valor from ( select t.valor from SCC_MX_MAE_TIIE  t  order by t.TCFECHFI desc) where rownum = 1  ");
		String sql = sb.toString();

		@SuppressWarnings("unchecked")
		List<BigDecimal>  result   = super.getSession().createNativeQuery(sql).getResultList();
	
		for(int i=0; i<result.size(); i++) {
			BigDecimal bd =  result.get(i); 
			resulTasa = bd.doubleValue();
		}
		
		
		return resulTasa;
	}

}
