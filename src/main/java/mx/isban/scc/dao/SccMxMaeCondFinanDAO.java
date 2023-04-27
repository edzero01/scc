package mx.isban.scc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import mx.isban.scc.model.SccMxMaeCondFinan;
import mx.isban.scc.model.dto.SccMxMaeCondFinanDTO;
import mx.isban.scc.utilerias.ValidaNull;

/**
 * Implementación de las consultas 
 * para las variables obtenidas de 
 * condiciones financieras para 
 * presentarlas en front end
 * de simulador
 * Mayo 2019
 * Sprint 1
 * @author Alexis Cedillo
 * GlobalHitss
 * Fabrica de Software
 * Proyecto Simulador de 
 * Crédito al Consumo
 */

@Repository
public class SccMxMaeCondFinanDAO extends AbstractDAO<SccMxMaeCondFinan>implements ISccMxMaeCondFinanDAO {

	
	
	/**
	 * Método para buscar condiciones financieras por id sub producto
     * Mayo 2019
     * Sprint 1
	 * @author Alexis Cedillo
	 * @param id 
	 * identificador único  del sub producto
	 * @return List<SccMxMaeCondFinan> 
	 * lista las condiciones financieras.
	 */
	@Override
	/**
	 * Confirmando si las lineas
	 * cuentan despues del override
	 * Para mover el comentario que está arriba.
	 */
	protected Class<SccMxMaeCondFinan> getType() {
	
		return SccMxMaeCondFinan.class;
	}
	
	
	/**
	 * Método para buscar las condiciones financieras por id de subproducto.
     * Mayo 2019
     * Sprint 1
	 * @author Alexis Cedillo
	 * @param id 
	 * identificador único del sub producto
	 * @return SccMxMaeCondFinan
	 * lista las condiciones financieras.
	 */
	@Override
	public List<SccMxMaeCondFinan> buscaCondicionPorIdSubProd(Long id) {
		StringBuilder srA = new StringBuilder();
		List<SccMxMaeCondFinan> ltCondFinans = new ArrayList<>();
		ValidaNull oValidaNull = new ValidaNull();

		
			srA.append("select SCC_MX_MAE_COND_FINAN.ID_SUB_PROD_FK,\r\n" + 
					"        SCC_MX_MAE_COND_FINAN.NUM_PLAZO,\r\n" + 
					"        SCC_MX_MAE_COND_FINAN.POR_TASA_INT_BASE,\r\n" + 
					"        SCC_MX_MAE_COND_FINAN.POR_COM_APERTURA,\r\n" + 
					"        SCC_MX_MAE_COND_FINAN.POR_COM_DISPOSICION,\r\n" + 
					"        SCC_MX_MAE_COND_FINAN.NUM_ANUALIDAD,\r\n" + 
					"        SCC_MX_MAE_COND_FINAN.POR_FACTOR_SEG,\r\n" + 
					"        SCC_MX_MAE_COND_FINAN.POR_FACTOR_IVA_SEG,\r\n" + 
					"        SCC_MX_MAE_COND_FINAN.POR_FACTOR_IVA,\r\n" + 
					"        SCC_MX_MAE_COND_FINAN.POR_CAT,\r\n" + 
					"        SCC_MX_MAE_COND_FINAN.POR_FAC_MONTO_TOTAL,\r\n" + 
					"        SCC_MX_MAE_COND_FINAN.POR_FAC_PAGO_MENSUAL,\r\n" + 
					"        SCC_MX_MAE_COND_FINAN.IMP_LIM_INF_M_BASE,\r\n" +
					"        SCC_MX_MAE_COND_FINAN.IMP_LIM_SUP_M_BASE,\r\n  " +
					"        SCC_MX_MAE_COND_FINAN.NUM_COSTO_CAUCION,   " +
					"        SCC_MX_MAE_COND_FINAN.FLG_COM_APER_CASHOUT,\r\n " +
					"        SCC_MX_MAE_COND_FINAN.FLG_COM_APER_MONTO,\r\n " +
					"        SCC_MX_MAE_COND_FINAN.FLG_COM_DISP_CASHOUT,\r\n " +
					"        SCC_MX_MAE_COND_FINAN.FLG_COM_DISP_MONTO " +
					"from SCC_MX_MAE_COND_FINAN where SCC_MX_MAE_COND_FINAN.ID_SUB_PROD_FK=");
			srA.append(id);
			srA.append(" ORDER BY SCC_MX_MAE_COND_FINAN.POR_TASA_INT_BASE, SCC_MX_MAE_COND_FINAN.NUM_PLAZO ");
			String sqlA = srA.toString();
			List<?>  result = super.getSession().createSQLQuery(sqlA).list();
			
			for(int i=0; i<result.size(); i++) {
				SccMxMaeCondFinan objCondFinanA = new SccMxMaeCondFinan();
				Object[] rowA = (Object[]) result.get(i);
				objCondFinanA.setIdSubProdFk(new Long(rowA[0].toString()));
				objCondFinanA.setNumPlazo(new Long(rowA[1].toString()));
				objCondFinanA.setPorTasaIntBase(new Double(rowA[2].toString()));
				objCondFinanA.setPorComApertura(new Double(rowA[3].toString()));
				objCondFinanA.setPorComDisposicion(new Double(rowA[4].toString()));
				objCondFinanA.setNumAnualidad(new Long(rowA[5].toString()));
				objCondFinanA.setPorFactorSeg(new Double(rowA[6].toString()));
				objCondFinanA.setPorFactorIvaSeg(new Double(rowA[7].toString()));
				objCondFinanA.setPorFactorIva(new Double(rowA[8].toString()));
				objCondFinanA.setPorCat(oValidaNull.validaNullDouble(rowA[9]));
				objCondFinanA.setPorFacMontoTotal(oValidaNull.validaNullDouble(rowA[10]));
				objCondFinanA.setPorFacPagoMensual(oValidaNull.validaNullDouble(rowA[11]));
				objCondFinanA.setImpLimInfMBase(new Double(rowA[12].toString()));
				objCondFinanA.setImpLimSupMBase(new Double(rowA[13].toString()));
				objCondFinanA.setNumCostoCaucion(new Long(rowA[14].toString()));
				objCondFinanA.setFlgComAperCashout(new Long(rowA[15].toString()));
				objCondFinanA.setFlgComAperMonto(new Long(rowA[16].toString()));
				objCondFinanA.setFlgComDispCashout(new Long(rowA[17].toString()));
				objCondFinanA.setFlgComDispMonto(new Long(rowA[18].toString()));
				
				ltCondFinans.add(objCondFinanA);
			}
		
		
		return ltCondFinans;
	}

	/**
	 * Método para buscar las condiciones financieras por
	 * id de Subproducto, el id de la tasa, el id del plazo
	 * y el perior para buscar en la tabla correspondiente
	 * filtrando por los datos dados
     * Mayo 2019
     * Sprint 1
	 * @author Alexis Cedillo
	 * @param id 
	 * identificador único del sub producto
	 * @return SccMxMaeCondFinan
	 * lista las condiciones financieras.
	 */
	@Override
	public List<SccMxMaeCondFinan> buscaCondTPP(Long id, Double idTasa, Long idPlazo, Long idPeriod){

		
		StringBuilder sr = new StringBuilder();
		sr.append(" select CF.ID_SUB_PROD_FK, CF.NUM_PLAZO, CF.POR_TASA_INT_BASE, CF.POR_COM_APERTURA, CF.POR_COM_DISPOSICION,  \r\n" +
		" CF.NUM_ANUALIDAD, CF.POR_FACTOR_SEG, CF.POR_FACTOR_IVA_SEG, CF.POR_FACTOR_IVA, CF.POR_CAT, CF.POR_FAC_MONTO_TOTAL,  \r\n" +
		" CF.POR_FAC_PAGO_MENSUAL, CF.IMP_LIM_INF_M_BASE, CF.IMP_LIM_SUP_M_BASE, CF.NUM_COSTO_CAUCION, "+
		"        CF.FLG_COM_APER_CASHOUT,  CF.FLG_COM_APER_MONTO,\r\n " +
		"        CF.FLG_COM_DISP_CASHOUT,\r\n " +
		"        CF.FLG_COM_DISP_MONTO " +
		" from scc_mx_mae_cond_finan cf \r\n" + 
		" where \r\n" + 
		" cf.id_sub_prod_fk  = ");
		sr.append(id);
		sr.append(" and por_tasa_int_base =  ");
		sr.append(idTasa);
		sr.append(" and num_plazo = ");
		sr.append(idPlazo);
		sr.append(" and id_period_fk =  ");
		sr.append(idPeriod);
		sr.append(" order by por_tasa_int_base asc, num_plazo");
		String sqlCondf = sr.toString();
		List<?>  rs = super.getSession().createSQLQuery(sqlCondf).list();
		List<SccMxMaeCondFinan> ltCondFinansA = new ArrayList<>();
		ValidaNull oValidaNull = new ValidaNull();
		for(int i=0; i<rs.size(); i++) {
			SccMxMaeCondFinan voCondFinan = new SccMxMaeCondFinan();
			Object[] row = (Object[]) rs.get(i);
			voCondFinan.setIdSubProdFk(new Long(row[0].toString()));
			voCondFinan.setNumPlazo(new Long(row[1].toString()));
			voCondFinan.setPorTasaIntBase(new Double(row[2].toString()));
			voCondFinan.setPorComApertura(new Double(row[3].toString()));
			voCondFinan.setPorComDisposicion(new Double(row[4].toString()));
			voCondFinan.setPorFactorSeg(new Double(row[6].toString()));
			voCondFinan.setPorFactorIvaSeg(new Double(row[7].toString()));
			voCondFinan.setPorFactorIva(new Double(row[8].toString()));
			voCondFinan.setNumAnualidad(new Long(row[5].toString()));
			voCondFinan.setPorCat(oValidaNull.validaNullDouble(row[9]));
			voCondFinan.setPorFacMontoTotal(oValidaNull.validaNullDouble(row[10]));
			voCondFinan.setPorFacPagoMensual(oValidaNull.validaNullDouble(row[11]));
			voCondFinan.setImpLimInfMBase(new Double(row[12].toString()));
			voCondFinan.setFlgComDispCashout(new Long(row[17].toString()));
			voCondFinan.setImpLimSupMBase(new Double(row[13].toString()));
			voCondFinan.setFlgComAperCashout(new Long(row[15].toString()));
			voCondFinan.setNumCostoCaucion(new Long(row[14].toString()));
			voCondFinan.setFlgComAperMonto(new Long(row[16].toString()));
			voCondFinan.setFlgComDispMonto(new Long(row[18].toString()));
			
			ltCondFinansA.add(voCondFinan);
		}
		
		return ltCondFinansA;
	}
	
	
	/**
	 * Método para buscar las condiciones financieras por
	 * id de Subproducto, el id de la tasa, el id del plazo
	 * y el perior para buscar en la tabla correspondiente
	 * filtrando por los datos dados
     * Mayo 2019
     * Sprint 1
	 * @author Alexis Cedillo
	 * @param idProdPk 
	 * identificador único del sub producto
	 * @return SccMxMaeCondFinan
	 * lista las condiciones financieras.
	 */
	@Override
	public List<SccMxMaeCondFinanDTO> buscaCondTPPOfMax(Long idProdPk, Double idTasa, Long idPlazo, Long idPeriod){

		
		StringBuilder sr = new StringBuilder();
		sr.append(" select CF.POR_FACTOR_SEG, CF.POR_FACTOR_IVA_SEG, CF.POR_FACTOR_IVA " +
		" from scc_mx_mae_cond_finan cf " + 
		" where " + 
		" cf.id_prod_fk  = ");
		sr.append(idProdPk);
		sr.append(" and por_tasa_int_base =  ");
		sr.append(idTasa);
		sr.append(" and num_plazo = ");
		sr.append(idPlazo);
		sr.append(" and id_period_fk =  ");
		sr.append(idPeriod);
		String sqlCondf = sr.toString();
		List<?>  rs = super.getSession().createSQLQuery(sqlCondf).list();
		List<SccMxMaeCondFinanDTO> ltCondFinansA = new ArrayList<>();
		ValidaNull oValidaNull = new ValidaNull();
		for(int i=0; i<rs.size(); i++) {
			SccMxMaeCondFinanDTO voCondFinan = new SccMxMaeCondFinanDTO();
			Object[] row = (Object[]) rs.get(i);
			voCondFinan.setPorFactorSeg( oValidaNull.validaNullDouble(row[0]) );
			voCondFinan.setPorFactorIvaSeg(oValidaNull.validaNullDouble(row[1]));
			voCondFinan.setPorFactorIva( oValidaNull.validaNullDouble(row[2]));
			
			ltCondFinansA.add(voCondFinan);
		}
		
		return ltCondFinansA;
	}


	/**
	 * Metodo para obtener objeto 
	 * cond finan  para tasa dado:
	 * @param idProd
	 * producto
	 * @param idSubProd
	 * subproducto
	 * @param lapa
	 * numero lapa
	 * @param plazo
	 * plazo
	 * @return tasa
	 * tasa de interes base
	 */
	@Override
	public SccMxMaeCondFinan obtenTasa(Long idProd, Long idSubProd, Long lapa, Long plazo) {
		StringBuilder sb = new StringBuilder();
		sb.append("from SccMxMaeCondFinan where sccMxMaeProducto.idProdPk = ");
		sb.append(idProd);
		sb.append(" and idSubProdFk = ");
		sb.append(idSubProd);
		sb.append(" and numLapa = ");
		sb.append(lapa);
		sb.append(" and numPlazo = ");
		sb.append(plazo);
		String sql = sb.toString();
		@SuppressWarnings("unchecked")
		Query<SccMxMaeCondFinan> query = super.getSession().createQuery(sql);
		List<SccMxMaeCondFinan> datos = query.getResultList();
		if( datos.isEmpty() ) {
			return null;
		}
		return datos.get(0);
	}


	/**
	 *  Método para buscar las condiciones financieras
	 *  por id de subproducto para LinEx
	 *  El cual incluye el monto desde la tabla 
	 *  Se requiere el id del producto, subproducto y buc cliente
	 *  se busca la lapa correspondiente en la tabla de Ofertas de campana
	 *  para obtener la relacion entre las tablas de tasas
	 *  plazos y montos para obtener el monto que le correspondan
	 *  Se obtiene un objeto del tipo cond financieras 
	 *  plus el campo del monto obtenido para Linex
	 * 
	 *  Junio 2019
     * Sprint 3.2
	 * @author Ivan Cruz A. Global hitss
	 * @param idProd
	 * id del producto(no es el tipo de producto)
	 * @param idSubProd
	 * idSubproducto que corresponde al id de la tabla sccmxmaesubprod
	 * @param idBucCte
	 * BUC  id del cliente del que se requiere buscar las condiciones financieras
	 * @return SccMxMaeCondFinan
	 * lista las condiciones financieras.
	 * SE AGREGO EL IDOFERCAMPK EN EL SELECT DEL QUERY PARA QUE DISTINGA CUANDO HAY 
	 * CAMPAÑAS EMPALMADAS LINEX
	 * SE AGREGAN  TAMBIEN LAS FECHAS PARA EL FILTRO DE CAMPAÑAS YA QUE ESTABA TRAYENDO
	 * LAS CAMPAÑAS ADELANTADAS
	 */
	@Override
	public List<SccMxMaeCondFinan> buscaCondTPPLinex(Long idProd, Long idSubProd, Long idBucCte){

		
		StringBuilder sr = new StringBuilder();
		sr.append(" select UNIQUE CF.ID_SUB_PROD_FK, CF.NUM_PLAZO, CF.POR_TASA_INT_BASE, CF.POR_COM_APERTURA, \r\n"
				+ " CF.POR_COM_DISPOSICION, CF.NUM_ANUALIDAD, CF.POR_FACTOR_SEG, CF.POR_FACTOR_IVA_SEG, \r\n"
				+ " CF.POR_FACTOR_IVA, CF.POR_CAT, CF.POR_FAC_MONTO_TOTAL, CF.POR_FAC_PAGO_MENSUAL, \r\n"
				+ " CF.IMP_LIM_INF_M_BASE, CF.IMP_LIM_SUP_M_BASE, CF.NUM_COSTO_CAUCION, \r\n "+
		"        CF.FLG_COM_APER_CASHOUT, CF.FLG_COM_APER_MONTO,\r\n " +
		"        CF.FLG_COM_DISP_CASHOUT, CF.FLG_COM_DISP_MONTO,\r\n " +
		"        opm.imp_monto, CAM.NUM_LAPA "+
		" from scc_mx_mae_cond_finan CF, \r\n" +
		" scc_mx_mae_ofer_cam cam, scc_mx_mae_producto p, scc_mx_mae_sub_prod sp, \r\n" + 
		" scc_mx_mae_tipo_prod tp, scc_mx_prc_ofer_max_tasa ot, scc_mx_prc_ofer_max_plzo opm  \r\n" + 
		" where cam.id_prod_fk = p.Id_prod_pk and sp.id_prod_fk = p.id_prod_pk \r\n" + 
		" and  p.id_tipo_producto_fk = tp.id_tipo_producto_pk and tp.id_tipo_producto_pk in (7, 8) \r\n" + 
		" and cf.num_lapa = cam.num_lapa\r\n" + 
		" and ot.id_ofer_cam_fk = cam.id_ofer_cam_pk \r\n" + 
		" and opm.id_ofer_cam_fk = cam.id_ofer_cam_pk \r\n" + 
		" and opm.id_ofer_max_tasa_fk = ot.id_ofer_max_tasa_pk \r\n" + 
		" and cam.id_ofer_cam_pk = (select max(id_ofer_cam_pk) from scc_mx_mae_ofer_cam where id_buc_clte = " );
		sr.append(idBucCte);
		sr.append(" and TRUNC(FCH_ini_PROM) <= TRUNC(current_date) and TRUNC(FCH_FIN_PROM) >= TRUNC(current_date) ) " ); 		
		sr.append(" and cam.id_buc_clte = ");
		sr.append(idBucCte);
		sr.append(" and cf.id_prod_fk = " ); 
		sr.append(idProd);
		sr.append(" and cf.id_sub_prod_fk = "); 
		sr.append(idSubProd);
		sr.append(" order by cf.num_plazo ");
		String sqlCtpp = sr.toString();
		List<?>  resultCtpp = super.getSession().createSQLQuery(sqlCtpp).list();
		List<SccMxMaeCondFinan> ltCondFinansA = new ArrayList<>();
		
		for(int i=0; i<resultCtpp.size(); i++) {
			SccMxMaeCondFinan condFinanLnx = new SccMxMaeCondFinan();
			Object[] row = (Object[]) resultCtpp.get(i);
			condFinanLnx.setIdSubProdFk(new Long(row[0].toString()));
			condFinanLnx.setNumPlazo(new Long(row[1].toString()));
			condFinanLnx.setPorTasaIntBase(new Double(row[2].toString()));
			condFinanLnx.setPorComApertura(new Double(row[3].toString()));
			condFinanLnx.setPorComDisposicion(new Double(row[4].toString()));
			condFinanLnx.setNumAnualidad(new Long(row[5].toString()));
			condFinanLnx.setPorFactorSeg(new Double(row[6].toString()));
			condFinanLnx.setPorFactorIvaSeg(new Double(row[7].toString()));
			condFinanLnx.setPorFactorIva(new Double(row[8].toString()));
			condFinanLnx.setPorCat(new Double(row[9].toString()));
			condFinanLnx.setPorFacMontoTotal(new Double(row[10].toString()));
			condFinanLnx.setPorFacPagoMensual(new Double(row[11].toString()));
			condFinanLnx.setImpLimInfMBase(new Double(row[12].toString()));
			condFinanLnx.setImpLimSupMBase(new Double(row[13].toString()));
			condFinanLnx.setNumCostoCaucion(new Long(row[14].toString()));
			condFinanLnx.setFlgComAperCashout(new Long(row[15].toString()));
			condFinanLnx.setFlgComAperMonto(new Long(row[16].toString()));
			condFinanLnx.setFlgComDispCashout(new Long(row[17].toString()));
			condFinanLnx.setFlgComDispMonto(new Long(row[18].toString()));
			condFinanLnx.setMontoLinex(new Double(row[19].toString()));
			condFinanLnx.setNumLapa(new Long(row[20].toString()));
			ltCondFinansA.add(condFinanLnx);
		}
		
		return ltCondFinansA;
	}

	
	/**
	 *  Método para buscar las condiciones financieras
	 *  por id de subproducto para LinEx
	 *  El cual incluye el monto desde la tabla 
	 *  Se requiere el id del producto, subproducto y buc cliente
	 *  se busca la lapa correspondiente en la tabla de Ofertas de campana
	 *  para obtener la relacion entre las tablas de tasas
	 *  plazos y montos para obtener el monto que le correspondan
	 *  Se obtiene un objeto del tipo cond financieras 
	 *  plus el campo del monto obtenido para Linex
	 * 
	 *  Junio 2019
     * Sprint 3.2
	 * @author Ivan Cruz A. Global hitss
	 * @param idProd
	 * id del producto(no es el tipo de producto)
	 * @param idSubProd
	 * idSubproducto que corresponde al id de la tabla sccmxmaesubprod
	 * @param idBucCte
	 * BUC  id del cliente del que se requiere buscar las condiciones financieras
	 * @return SccMxMaeCondFinan
	 * lista las condiciones financieras.
	 */
	@Override
	public List<SccMxMaeCondFinan> buscaCondPromoLinex(Long idProd, Long idSubProd, Long idBucCte){

		
		StringBuilder sr = new StringBuilder();
		sr.append(" select CF.ID_SUB_PROD_FK, CF.NUM_PLAZO, CF.POR_TASA_INT_BASE, CF.POR_COM_APERTURA, \r\n"
				+ " CF.POR_COM_DISPOSICION, CF.NUM_ANUALIDAD, CF.POR_FACTOR_SEG, CF.POR_FACTOR_IVA_SEG, \r\n"
				+ " CF.POR_FACTOR_IVA, CF.POR_CAT, CF.POR_FAC_MONTO_TOTAL, CF.POR_FAC_PAGO_MENSUAL, \r\n"
				+ " CF.IMP_LIM_INF_M_BASE, CF.IMP_LIM_SUP_M_BASE, CF.NUM_COSTO_CAUCION, \r\n "+
		"        CF.FLG_COM_APER_CASHOUT, CF.FLG_COM_APER_MONTO,\r\n " +
		"        CF.FLG_COM_DISP_CASHOUT, CF.FLG_COM_DISP_MONTO\r\n " +
		" from scc_mx_mae_cond_finan CF, \r\n" +
		" SCC_MX_MAE_OFER_PROM_CAM promo, scc_mx_mae_producto p, scc_mx_mae_sub_prod sp, \r\n" + 
		" scc_mx_mae_tipo_prod tp  \r\n" + 
		" where promo.id_prod_fk = p.Id_prod_pk and sp.id_prod_fk = p.id_prod_pk \r\n" + 
		" and  p.id_tipo_producto_fk = tp.id_tipo_producto_pk and tp.id_tipo_producto_pk in (7, 8) \r\n" + 
		" and cf.num_lapa = promo.num_lapa\r\n" + 
		" and cf.id_prod_fk =  promo.id_prod_fk	and cf.id_sub_prod_fk = promo.id_sub_prod_fk \r\n "+
		" and promo.id_buc_clte = ");
		sr.append(idBucCte);
		sr.append(" and promo.id_prod_fk = " ); 
		sr.append(idProd);
		sr.append(" and promo.id_sub_prod_fk = "); 
		sr.append(idSubProd);
		sr.append(" and SYSTIMESTAMP <= promo.FCH_FIN_PROM ");
		String sql = sr.toString();
		List<?>  result = super.getSession().createSQLQuery(sql).list();
		List<SccMxMaeCondFinan> ltCondFinansA = new ArrayList<>();
		
		for(int i=0; i<result.size(); i++) {
			SccMxMaeCondFinan objCondFinan = new SccMxMaeCondFinan();

			Object[] row = (Object[]) result.get(i);
			objCondFinan.setIdSubProdFk(new Long(row[0].toString()));
			objCondFinan.setNumPlazo(new Long(row[1].toString()));
			objCondFinan.setPorTasaIntBase(new Double(row[2].toString()));
			objCondFinan.setPorComApertura(new Double(row[3].toString()));
			objCondFinan.setPorComDisposicion(new Double(row[4].toString()));
			objCondFinan.setNumAnualidad(new Long(row[5].toString()));
			objCondFinan.setPorFactorSeg(new Double(row[6].toString()));
			objCondFinan.setPorFactorIvaSeg(new Double(row[7].toString()));
			objCondFinan.setPorFactorIva(new Double(row[8].toString()));
			objCondFinan.setPorCat(new Double(row[9].toString()));
			objCondFinan.setPorFacMontoTotal(new Double(row[10].toString()));
			objCondFinan.setPorFacPagoMensual(new Double(row[11].toString()));
			objCondFinan.setImpLimInfMBase(new Double(row[12].toString()));
			objCondFinan.setImpLimSupMBase(new Double(row[13].toString()));
			objCondFinan.setNumCostoCaucion(new Long(row[14].toString()));
			objCondFinan.setFlgComAperCashout(new Long(row[15].toString()));
			objCondFinan.setFlgComAperMonto(new Long(row[16].toString()));
			objCondFinan.setFlgComDispCashout(new Long(row[17].toString()));
			objCondFinan.setFlgComDispMonto(new Long(row[18].toString()));
			ltCondFinansA.add(objCondFinan);
		}
		
		return ltCondFinansA;
	}
	
}
