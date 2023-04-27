package mx.isban.scc.service;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.isban.scc.dao.ISccMxMaeCondFinanDAO;
import mx.isban.scc.dao.ISccMxMaeConvAutoDAO;
import mx.isban.scc.model.SccMxMaeCondFinan;
import mx.isban.scc.model.dto.SccMxConvAutoLinexDTO;
import mx.isban.scc.model.dto.SccMxLinexCondFinanAuxDTO;
import mx.isban.scc.model.dto.SccMxMaeCondFinanDTO;
import mx.isban.scc.model.dto.SccMxMaeCondFinanLinexDTO;
import mx.isban.scc.utilerias.SccMxUtileriasOferMaxPlazo;

/**
 * Implementacion de los metodos de interfaz para obtencion de variables para calculo
 * dado producto linex
 * 
 * Con estos calculos se puede generar la tabla de amortizaicon
 * que es el resultado y objetivo principal del simulador
 * ya que el cliente obtiene el plan de pagos por mes o periodo elegido
 * con sus montos e intereses
 * 
 * Simulador de Credito al Consumo
 * Global Hitss
 * Junio 2019
 * 
 *
 * 
 * 
 * @author Christopher Espina 
 */
@Service
public class LinexService implements ILinexService {

	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con finalidad
	 * de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(LinexService.class);
	/**
	 * Variable global de clase con finalidad de inyeccion de dependencias
	 */
	@Autowired
	private ISccMxMaeCondFinanDAO condFinanDao;
	
	/**
	 * Dao para ocupar la info de Conversion Auto
	 * 
	 */
	@Autowired
	private ISccMxMaeConvAutoDAO daoConvAuto;
	
	
	/**
	 * Método para obtener todas las condiciones financieras
	 * de una oferta promocional para productos linez
	 * 
	 * @author Christopher Espina
	 * @param idProd
	 * id producto
	 * @param idSubProd
	 * id sub producto
	 * @param lapa
	 * numero de lapa
	 * @param plazo
	 * plazo
	 * @return Double tasa interes base
	 */
	@Override
	public SccMxMaeCondFinanDTO obtenCondicionesFinancieras(Long idProd, Long idSubProd, Long lapa, Long plazo) {
		SccMxMaeCondFinan condFinan = new SccMxMaeCondFinan();
		SccMxMaeCondFinanDTO rcondFinan = null;
		try {
			condFinan = condFinanDao.obtenTasa(idProd, idSubProd, lapa, plazo);
			List<Double > porCats = new ArrayList();
			if (condFinan != null) {
				rcondFinan = new SccMxMaeCondFinanDTO();
				porCats.add( condFinan.getPorCat());
				rcondFinan.setPorCat( porCats);
				rcondFinan.setPorComApertura(condFinan.getPorComApertura());
				rcondFinan.setPorComDisposicion(condFinan.getPorComDisposicion());
				rcondFinan.setPorFacMontoTotal(condFinan.getPorFacMontoTotal());
				rcondFinan.setPorFactorIva(condFinan.getPorFactorIva());
				rcondFinan.setPorFactorIvaSeg(condFinan.getPorFactorIvaSeg());
				rcondFinan.setPorFactorSeg(condFinan.getPorFactorSeg());
				rcondFinan.setPorTasaIntBase(condFinan.getPorTasaIntBase());
				rcondFinan.setPlazo(new ArrayList());
			}
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return rcondFinan;
	}
	
	/**
	 * Para actualizar los factores de confinan cada vez que el usuario
	 * realice un cambio de combobox en tasa, plazo o periodicidad
	 * @param idProd
	 * id
	 * @param idSubProd
	 * tasa
	 * @param idCteBuc
	 * plazo
	 * @return List(SccMxMaeCondFinanDTO)
	 * lista de condiciones financieras
	 * Considerar la LAPA desde la busqueda de condfinan
	 */
	@Override
	public SccMxLinexCondFinanAuxDTO buscaCondTPPLinex(Long idProd, Long idSubProd, Long idCteBuc) {
		Long lapa = null;
		List<Double> listaMontosPeriodo = new ArrayList<>();
		List<Long> listaPlazosPeriodo = new ArrayList<>();
		List<Double> listPagosPeriodo = new ArrayList<>();
		List<Double> listaTasasPeriodo = new ArrayList<>();
		List<SccMxMaeCondFinanDTO> ltConfin = new ArrayList<SccMxMaeCondFinanDTO>();
		List<SccMxMaeCondFinanLinexDTO> ltConfinLinex = new ArrayList<SccMxMaeCondFinanLinexDTO>();
		List<SccMxMaeCondFinan> ltCondFinanc = condFinanDao.buscaCondTPPLinex(idProd, idSubProd, idCteBuc);
		for (SccMxMaeCondFinan voTmp : ltCondFinanc) {
			Double llave = voTmp.getPorTasaIntBase();
			lapa = voTmp.getNumLapa();
			SccMxMaeCondFinanDTO dto = new SccMxMaeCondFinanDTO();
			dto.setPorTasaIntBase(llave);
			dto.addPlazo(voTmp.getNumPlazo());
			dto.setIdSubProdPk(voTmp.getIdSubProdFk());
			dto.setPorComApertura(voTmp.getPorComApertura());
			dto.setPorComDisposicion(voTmp.getPorComDisposicion());
			dto.setNumAnualidad(voTmp.getNumAnualidad());
			dto.setPorFactorSeg(voTmp.getPorFactorSeg());
			dto.setPorFactorIvaSeg(voTmp.getPorFactorIvaSeg());
			dto.setPorFactorIva(voTmp.getPorFactorIva());
			dto.setPorFacMontoTotal(voTmp.getPorFacMontoTotal());
			dto.setPorFacPagoMensual(voTmp.getPorFacPagoMensual());
			dto.setImpLimInfMBase(voTmp.getImpLimInfMBase());
			dto.setImpLimSupMBase(voTmp.getImpLimSupMBase());
			dto.setNumCostoCaucion(voTmp.getNumCostoCaucion());
			dto.setFlgComDispCashout(voTmp.getFlgComDispCashout());
			dto.setFlgComAperCashout(voTmp.getFlgComAperCashout());
			dto.setFlgComAperMonto(voTmp.getFlgComAperMonto());
			dto.setFlgComDispMonto(voTmp.getFlgComDispMonto());
			dto.addCat(voTmp.getPorCat());
			listaTasasPeriodo.add(voTmp.getPorTasaIntBase());
			listaMontosPeriodo.add(voTmp.getMontoLinex());
			listaPlazosPeriodo.add(voTmp.getNumPlazo());
			ltConfin.add(dto);
		}
		SccMxMaeCondFinanLinexDTO dtoLinex = new SccMxMaeCondFinanLinexDTO();
		
		listPagosPeriodo = calculaMontosMensualesLinex(ltConfin, listaPlazosPeriodo, listaMontosPeriodo, Long.valueOf("3"));
		
		dtoLinex.setListaMontosLinex(listaMontosPeriodo);
		dtoLinex.setListaPagosLinex(listPagosPeriodo);
		dtoLinex.setListaPlazosLinex(listaPlazosPeriodo);
		dtoLinex.setMatriz(armaMatrizTablaLinex(listaMontosPeriodo, listaPlazosPeriodo, listPagosPeriodo));
		dtoLinex.setListaTasasLinex(listaTasasPeriodo);
		dtoLinex.setNumLapaLinex(lapa);
		ltConfinLinex.add(dtoLinex);
		
		return  new SccMxLinexCondFinanAuxDTO(ltConfin, ltConfinLinex);
	}
	

	/**
	 * Metodo para calcular los montos para la tabla de ofertas maximas por plazo
	 * Sprint 3.2
	 * 
	 * @param listaCondiciones      Contiene las condiciones financieras de Linex
	 * @param listaPlazos lista que trae los plazos maximos para la oferta de
	 *                    campaña
	 * @param listaMontos lista de los motos para la oferta de campaña.
	 * @param idPagoSeguro  id pago de seguro
	 * @return List(Double) Lista de montos mensuales
	 */
	private List<Double> calculaMontosMensualesLinex(List<SccMxMaeCondFinanDTO> listaCondiciones,List<Long> listaPlazos, List<Double> listaMontos, Long idPagoSeguro) {
		List<Double> listaPagos = new ArrayList<>();
		DecimalFormat df = new DecimalFormat("#.00");
		for (int i = 0; i < listaMontos.size(); i++) {

			Double montoCredito = listaMontos.get(i);
			Long plazo = listaPlazos.get(i);
			
			Double montoPago = 0.0;
			if(!listaCondiciones.isEmpty()) {
				SccMxMaeCondFinanDTO condFinan = listaCondiciones.get(i);
				SccMxUtileriasOferMaxPlazo utileria = new SccMxUtileriasOferMaxPlazo();
				montoPago = utileria.calculaMontoPago(condFinan.getPorTasaIntBase(), plazo, condFinan.getPorFactorSeg(), 
						condFinan.getPorFactorIva(), condFinan.getPorFactorIvaSeg(), montoCredito, 
						"M", Long.valueOf("1"), idPagoSeguro);
				montoPago = Double.valueOf(df.format(montoPago));
			}


			listaPagos.add(montoPago);

		}
		return listaPagos;
	}
	
	/**
	 * Inicializa los datos que se usarán en la pantalla mediante una matriz de información
	 * @param lstMontos lista de montos de crédito
	 * @param lstPlazos lista de plazos de pago del crédito
	 * @param lstPagos lista de pagos unitarios por crédito
	 * @return List(List(Serializable)) la matriz armada de información
	 */
	private List<List<Serializable>> armaMatrizTablaLinex(List<Double> lstMontos, List<Long> lstPlazos,
			List<Double> lstPagos) {
		List<List<Serializable>> matrizLnx = new ArrayList<>();
		ArrayList<Serializable> montosLnx = new ArrayList<>();
		ArrayList<Serializable> plazosLnx = new ArrayList<>();
		ArrayList<Serializable> pagosLnx = new ArrayList<>();

		for (int col = 0; col < lstMontos.size(); col++) {

			montosLnx.add(lstMontos.get(col));
			plazosLnx.add(lstPlazos.get(col));
			pagosLnx.add(lstPagos.get(col));
		}

		montosLnx.add(0, "Monto del crédito:");
		matrizLnx.add(montosLnx);
		plazosLnx.add(0, "Plazo (meses):");
		matrizLnx.add(plazosLnx);
		pagosLnx.add(0, "Pagos (IVA incluido)");
		matrizLnx.add(pagosLnx);
		return matrizLnx;
	}

	
	/**
	 * Metodo para obtener las condiciones financieras 
	 * promocionales segun el numero de LAPA obtenido
	 * en la tabla de ofertas de campana promocionales
	 * Los datos de esta condicones financieras 
	 * se utilizaran en lugar de conversion auto 
	 * en caso de que aplique
	 * @param idProd
	 * id del producto (no id del tipo de producto)
	 * @param idSubProd
	 * id del subproducto
	 * @param idCteBuc
	 * id del cliente para buscar el lapa
	 * @return List(SccMxMaeCondFinanDTO)
	 * lista de condiciones financieras
	 */
	@Override
	public List<SccMxMaeCondFinanDTO> buscaCondFinancierasLinexPromocional(Long idProd, Long idSubProd, Long idCteBuc) {
		
		List<SccMxMaeCondFinanDTO> ltConfin = new ArrayList<SccMxMaeCondFinanDTO>();
		List<SccMxMaeCondFinan> ltCondFinan = condFinanDao.buscaCondPromoLinex(idProd, idSubProd, idCteBuc);
		for (SccMxMaeCondFinan vo : ltCondFinan) {
			Double llave = vo.getPorTasaIntBase();
			SccMxMaeCondFinanDTO dto = new SccMxMaeCondFinanDTO();
			dto.setPorTasaIntBase(llave);
			dto.addPlazo(vo.getNumPlazo());
			dto.setIdSubProdPk(vo.getIdSubProdFk());
			dto.setPorComApertura(vo.getPorComApertura());
			dto.setPorComDisposicion(vo.getPorComDisposicion());
			dto.setNumAnualidad(vo.getNumAnualidad());
			dto.setPorFactorSeg(vo.getPorFactorSeg());
			dto.setPorFactorIvaSeg(vo.getPorFactorIvaSeg());
			dto.setPorFactorIva(vo.getPorFactorIva());
			dto.setPorFacMontoTotal(vo.getPorFacMontoTotal());
			dto.setPorFacPagoMensual(vo.getPorFacPagoMensual());
			dto.setImpLimInfMBase(vo.getImpLimInfMBase());
			dto.setImpLimSupMBase(vo.getImpLimSupMBase());
			dto.setNumCostoCaucion(vo.getNumCostoCaucion());
			dto.setFlgComDispCashout(vo.getFlgComDispCashout());
			dto.setFlgComAperCashout(vo.getFlgComAperCashout());
			dto.setFlgComAperMonto(vo.getFlgComAperMonto());
			dto.setFlgComDispMonto(vo.getFlgComDispMonto());
			dto.addCat(vo.getPorCat());
			ltConfin.add(dto);
		}
		
		return ltConfin;
	}
	
	/**
	 * Metodo para buscar la conversión auto LINEX 
	 * @param idSegmento Id del segmento
	 * @param idPeriodicidad
	 * Id de la periodicidad
	 * @param plazo
	 * Plazo
	 * @return SccMxConvAutoLinexDTO  
	 * lista de condiciones financieras
	 */
	@Override
	public SccMxConvAutoLinexDTO buscaConvAutoLinex(Long idSegmento, 
			                                        Long idPeriodicidad, 
			                                        Long plazo) {
		
		SccMxConvAutoLinexDTO dto = new SccMxConvAutoLinexDTO();
		dto= daoConvAuto.buscaConvAutoLinexData(idSegmento, idPeriodicidad, plazo);
		return dto;
	}

}
