package mx.isban.scc.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import mx.isban.scc.model.SccMxMaeFondoGarId;

/**
 * Implementación de la consulta
 * para las variables obtenidas de 
 * fondos de garantia para 
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
public class SccMxMaeFondoGarantiaDAO extends AbstractDAO<SccMxMaeFondoGarId> implements ISccMxMaeFondoGarantiaDAO {

	/**
	 * Confirmando si las lineas
	 * cuentan despues del override
	 * Para mover el comentario que está arriba.
	 */
	@Override
	protected Class<SccMxMaeFondoGarId> getType() {
	
		return SccMxMaeFondoGarId.class;
	}
	
	/**
	 * Método para obtener los fondos de garantia
     * Junio 2019
     * Sprint 2
	 * @author Ivan Cruz Azuara
	 * @return SccMxMaeFondoGarId
	 * lista de los fondos de garantia
	 */
	@Override
	public List<SccMxMaeFondoGarId> buscaFondosGarantia() {
		StringBuilder sr = new StringBuilder();
		sr.append(" select FG.ID_FOND_GAR_PK, FG.DSC_FOND_GAR, FG.POR_COM_FOND_GAR "+
		" from SCC_MX_MAE_FONDO_GAR FG ");
		String sql = sr.toString();
		List<?>  result = super.getSession().createSQLQuery(sql).list();
		List<SccMxMaeFondoGarId> ltFondosGaantia = new ArrayList<>();
		
		for(int i=0; i<result.size(); i++) {
			SccMxMaeFondoGarId objFondoGarantia = new SccMxMaeFondoGarId();
			Object[] row = (Object[]) result.get(i);
			objFondoGarantia.setIdFondGarPk(new Long(row[0].toString()));
			objFondoGarantia.setDscFondGar(row[1].toString());
			objFondoGarantia.setPorComFondGar(new Double(row[2].toString()));
			ltFondosGaantia.add(objFondoGarantia);
		}
		
		return ltFondosGaantia;
	}

}
