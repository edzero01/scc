
package mx.isban.scc.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.isban.scc.dao.ISccMxPrcOferMazPlazoDAO;
import mx.isban.scc.model.BuscaOfertasCampaniaVO;
import mx.isban.scc.model.SccMxPrcOferMaxPlzo;
import mx.isban.scc.model.SccMxPrcOferMaxTasa;
import mx.isban.scc.model.dto.SccMxMaeOferCamDTO;
import mx.isban.scc.model.dto.SccMxMaeOferCampMaDTO;
import mx.isban.scc.model.dto.SccMxMaeOferPromCamDTO;
import mx.isban.scc.model.dto.SccMxMaeOferPromMaDTO;
import mx.isban.scc.model.dto.SccMxPrcOferMaxPlazoDTO;
import mx.isban.scc.model.dto.SccMxPrcOferMaxTasaDTO;
import mx.isban.scc.utilerias.BuscaOfertasCampania;
import mx.isban.scc.utilerias.SccMxUtileriasOferMaxPlazo;

/**
 * Clase de negocio para ipmlementar interfaz de cliente para obtener datos del
 * mismo si es que existe y llenar seccion de info de cliente y campania de
 * existir una siempre y cuando dicho cliente tenga como antes mencionado una
 * oferta de campania asignada a su usuario. Si no se cumple con esta regla o si
 * no se encuentra el cliente dentro de el repositorio de santander, el
 * simulador llevara en automatico a las pantallas de simulacion de creditos en
 * modalidad de mercado abierto.
 * 
 * Coonsiderar las siguientes instancias para 
 * inyeccion de dependecias en spring
 * 
 * ofertapromcam ofercam oferpromma prcofermaxplazo
 * 
 * Esta clase de servicio inyecta dependencias de 
 * las clases previamente
 * mencionadas
 * 
 * GlobalHitss Mayo 2019 Sprint 2
 * 
 * @author Hitss
 *
 * 11 de Septiembre
 * 2 am
 * Se quito el metodo que calcula montos mensuales 
 * porque necesitamos el logger
 * para resolver el tema de los ceros en campaña
 * que no se visualiza en hitss pero sí en santander
 */
@Service
public class ClienteService implements IClienteService {
	
	/**
	 *  instancia para la implemantacion de la interfaz daoPrcOferMaxPlazo
	 */
	@Autowired
	private ISccMxPrcOferMazPlazoDAO daoPrcOferMaxPlazo;
	/**
	 *  instancia para la implemantacion de la interfaz ICatalogosServiceCondFin
	 */
	@Autowired
	private ICondFinService condFinancieras;
	
	
	/**
	 * Variable global que busca las ofertas de campaña
	 */
	@Autowired
	public BuscaOfertasCampania buscaOfertasCampania;

	/**
	 * Implementación del service para obtener las ofertas promocionales
	 * Necesita el perfil porque algunas ofertas no son visibles para todos los perfiles
	 * @param id
	 * Identifica el BUC del Cliente
	 * @param perfil
	 * Identifica el perfil con el que ingreso el usuario
	 * @return SccMxMaeOferCampMaDTO
	 * Objeto con la información de campañas. 
	 * Importante la revision de null o undefined
	 * Actualizacion por Lorena Baruch 21 de Oct
	 * se trae la información para LINEX para buscar en PAMPA por Sucursal y Contrato
	 */
	@Override
	public SccMxMaeOferCampMaDTO obtenerOferCamMa(long id, long perfil) {
		
		
		//Obtiene las ofertas aplicables
		BuscaOfertasCampaniaVO data = buscaOfertasCampania.buscaOfertas( id, perfil );
		
		//Se crean los objetos lista que se usarán.
		List<SccMxMaeOferCamDTO> ltSccMxMaeOferCamDTO = new ArrayList<SccMxMaeOferCamDTO>();
		List<SccMxMaeOferPromCamDTO> ltSccMxMaeOferPromCamDTO = new ArrayList<SccMxMaeOferPromCamDTO>();
		List<SccMxMaeOferPromMaDTO> ltSccMxMaeOferPromMaDTO = new ArrayList<SccMxMaeOferPromMaDTO>();
		List<SccMxPrcOferMaxTasa> ltSccMxPrcOferMaxTasa = null;
		List<SccMxPrcOferMaxPlzo> ltSccMxPrcOferMaxPlzo = null;
		List<SccMxPrcOferMaxTasaDTO> ltSccMxPrcOferMaxTasaDTO = new ArrayList<SccMxPrcOferMaxTasaDTO>();
		SccMxPrcOferMaxPlazoDTO ltSccMxPrcOferMaxPlazoDTO = null;
		Long idProducto = 0L; 
		Long idPeriodo = 0L; 
		Long idPagoSeguro = 0L; 
		String codPeriod = ""; 
		String desPeriodo = "";
		
		//Si hay ofertas de campaña
		if (!data.getLtSccMxMaeOferCam().isEmpty()) {
			idProducto = data.getLtSccMxMaeOferCam().get(0).getSccMxMaeProducto().getIdProdPk();
			idPagoSeguro = data.getLtSccMxMaeOferCam().get(0).getSccMxMaeProducto().getSccMxMaePagoSeguro().getIdPagSegPk();
			idPeriodo = data.getLtSccMxMaeOferCam().get(0).getSccMxMaePeriod().getIdPeriodPk();
			desPeriodo = data.getLtSccMxMaeOferCam().get(0).getSccMxMaePeriod().getDscPeriod();
			codPeriod = data.getLtSccMxMaeOferCam().get(0).getSccMxMaePeriod().getCodPeriod();
			//Obtiene las ofertas tasa máxima
			ltSccMxPrcOferMaxTasa = daoPrcOferMaxPlazo.buscaTasas(data.getLtSccMxMaeOferCam().get(0).getIdOferCamPk());
			//Obtiene las ofertas plazo máxima
			ltSccMxPrcOferMaxPlzo = daoPrcOferMaxPlazo.buscaOfertasMaximasPlazo(data.getLtSccMxMaeOferCam().get(0).getIdOferCamPk());
			//Genera un DTO de Ofertas de tasa máxima y lo añade a la lista
			ltSccMxPrcOferMaxTasa.stream().forEach(objTasas -> {
				SccMxPrcOferMaxTasaDTO objTasasDTO = new SccMxPrcOferMaxTasaDTO(objTasas.getIdOferMaxTasaPk(),
						objTasas.getSccMxMaeOferCam().getIdOferCamPk(), objTasas.getCodTasa(), objTasas.getPorTasa());
				ltSccMxPrcOferMaxTasaDTO.add(objTasasDTO);
			});
			List<Double> listaMontos = new ArrayList<>(); 
			List<Long> listaPlazos = new ArrayList<>(); 
			List<Double> listaPagos = new ArrayList<>();
			//Por cada oferta de plazo máximo 
			//obtiene lista de montos y plazos
			//y los añade a la lista correspondiente
			for (int i = 0; i < ltSccMxPrcOferMaxPlzo.size(); i++) {
				SccMxPrcOferMaxPlzo obj = ltSccMxPrcOferMaxPlzo.get(i);
				listaMontos.add(obj.getImpMonto());
				listaPlazos.add(obj.getCanPlzo());

			}
			//Obtiene la tasa base de la lista de ofertas de tasa máxima
			Double tasa = getTasaBase(ltSccMxPrcOferMaxTasa);
			SccMxUtileriasOferMaxPlazo utilerias = new SccMxUtileriasOferMaxPlazo();
			//Calcula los pagos mensuales
			listaPagos = utilerias.calculaMontosMensuales(tasa, listaPlazos, listaMontos, idProducto,
					idPeriodo, codPeriod, idPagoSeguro,  condFinancieras);
			
			//Obtiene los datos de la lista final
			ltSccMxPrcOferMaxPlazoDTO = new SccMxPrcOferMaxPlazoDTO(listaPlazos, listaMontos, listaPagos);
			ltSccMxPrcOferMaxPlazoDTO.setMatriz(armaMatrizTabla(listaMontos, listaPlazos, listaPagos, desPeriodo));

		}
		
		//Por cada oferta de campaña genera un objeto DTO
		//Y lo agrega a la lista ltSccMxMaeOferCamDTO
		data.getLtSccMxMaeOferCam().stream().forEach(objOferCam -> {
			SccMxMaeOferCamDTO objofercamDTO = new SccMxMaeOferCamDTO(objOferCam.getIdOferCamPk(),objOferCam.getFchIniProm(), objOferCam.getFchFinProm(), objOferCam.getSccMxMaePeriod().getIdPeriodPk(), objOferCam.getSccMxMaeProducto().getIdProdPk(),
					                                                  0L, objOferCam.getIdSubProd(), objOferCam.getDescNombreCte(),objOferCam.getIdBucClte().toString(),objOferCam.getSccMxMaeProducto().getIdTipoProd());
			if (objOferCam.getSccMxMaeSegmento() != null) {
				objofercamDTO.setSccMxMaeSegmento(objOferCam.getSccMxMaeSegmento().getIdSegmentoPk());
			}
			objofercamDTO.setNumCredAnterior(objOferCam.getNumCredAnt());
			objofercamDTO.setSccMxMaePeriod(objOferCam.getIdOferCamPk());
			objofercamDTO.setSccMxMaePeriod(objOferCam.getSccMxMaePeriod().getIdPeriodPk());
			if (objOferCam.getNumCuenta() != null) {
				objofercamDTO.setNumCuenta(objOferCam.getNumCuenta());
			}
			objofercamDTO.setFlagsCcs(objOferCam.getCodVtaCcsIn(), objOferCam.getCodVtaCcsOut());
			objofercamDTO.setFlagsRed(objOferCam.getCodVtaRedIn(), objOferCam.getCodVtaRedOut());
			objofercamDTO.setCodVtaAsn(objOferCam.getCodVtaAsn());
			objofercamDTO.setCodVtaFve(objOferCam.getCodVtaFve());
			objofercamDTO.setNumSucursal(objOferCam.getNumSucTdcAnt());
			objofercamDTO.setNumContrato(objOferCam.getNumConTdcAnt());
			objofercamDTO.setIdDiaPagoFk(objOferCam.getIdDiaPagoFk());
			objofercamDTO.setCodCalendario(objOferCam.getCodCalendario());
			ltSccMxMaeOferCamDTO.add(objofercamDTO);			
		});
		//Por cada oferta promocional genera un objeto DTO
		//Y lo agrega a la lista ltSccMxMaeOferPromMaDTO
		data.getLtSccMxMaeOferPromCam().stream().forEach(objOferPromCam -> {
			SccMxMaeOferPromCamDTO objOferPromCamDTO = new SccMxMaeOferPromCamDTO(objOferPromCam.getIdOferPreCamPk(),
					objOferPromCam.getIdComision(), objOferPromCam.getIdProducto(),
					objOferPromCam.getIdSubProd(), objOferPromCam.getIdBucClte(), objOferPromCam.getFchIniProm(),
					objOferPromCam.getFchFinProm(), objOferPromCam.getDscNomProm(), objOferPromCam.getDscNomClte());
			ltSccMxMaeOferPromCamDTO.add(objOferPromCamDTO);
		});
		data.getLtSccMxMaeOferPromMa().stream().forEach(objOferPromMa -> {
			SccMxMaeOferPromMaDTO objOferPromMaDTO = new SccMxMaeOferPromMaDTO(objOferPromMa.getIdOferPromPk(),
					objOferPromMa.getIdComision(), objOferPromMa.getIdProducto(),
					objOferPromMa.getIdSubProd(), objOferPromMa.getIdBucClte(), objOferPromMa.getFchIniProm(),
					objOferPromMa.getFchFinProm(), objOferPromMa.getDscNomClte(), objOferPromMa.getDscNomProm());
			ltSccMxMaeOferPromMaDTO.add(objOferPromMaDTO);
		});
		return new SccMxMaeOferCampMaDTO(ltSccMxMaeOferCamDTO, ltSccMxMaeOferPromCamDTO, ltSccMxMaeOferPromMaDTO,
				ltSccMxPrcOferMaxTasaDTO, ltSccMxPrcOferMaxPlazoDTO);
	}


	
	/**
	 * Método para obtener la tasa de credito base para las ofertas maximas dee
	 * credito Sprint 2 Mayo 2019
	 * 
	 * @param ltSccMxPrcOferMaxTasa lista con las tasas para
	 * @return
	 */
	private Double getTasaBase(List<SccMxPrcOferMaxTasa> ltSccMxPrcOferMaxTasa) {

		Double tasaBase = 0.0;
		if (ltSccMxPrcOferMaxTasa != null && !ltSccMxPrcOferMaxTasa.isEmpty()) {
			for (int i = 0; i < ltSccMxPrcOferMaxTasa.size(); i++) {

				SccMxPrcOferMaxTasa base = ltSccMxPrcOferMaxTasa.get(i);
				if ("BASE".equals(base.getCodTasa())) {
					tasaBase = base.getPorTasa();
				}
			}
		}
		return tasaBase;
	}

	
	/**
	 * Inicializa los datos que se usarán en la pantalla mediante una matriz de información
	 * @param listaMontos lista de montos de crédito
	 * @param listaPlazos lista de plazos de pago del crédito
	 * @param listaPagos lista de pagos unitarios por crédito
	 * @param descPeriodo Periodo
	 * @return la matriz armada de información
	 */
	private List<List<Serializable>> armaMatrizTabla(List<Double> listaMontos, List<Long> listaPlazos,
			List<Double> listaPagos, String descPeriodo) {
		List<List<Serializable>> matriz = new ArrayList<>();
		ArrayList<Serializable> montos = new ArrayList<>();
		ArrayList<Serializable> plazos = new ArrayList<>();
		ArrayList<Serializable> pagos = new ArrayList<>();

		for (int col = 0; col < listaMontos.size(); col++) {

			montos.add(listaMontos.get(col));
			plazos.add(listaPlazos.get(col));
			pagos.add(listaPagos.get(col));
		}

		montos.add(0, "Monto del crédito:");
		matriz.add(montos);
		plazos.add(0, "Plazo (meses):");
		matriz.add(plazos);
		pagos.add(0, "Pagos ".concat(descPeriodo).concat(" (IVA incluido)"));
		matriz.add(pagos);
		return matriz;
	}


	
	/**
	 * Implementación del service para obetner tabla ofertas maximas por plazo
	 * 
	 * @param idCampania identificador unico de la campaña
	 * @param idTasa identificador unico de la tasa
	 * @param idProducto identificador unico del producto
	 * @param codPeriod codigo del periodo
	 * @param idPeriodicidad identificador unico de la periodicidad
	 * @param idPagoSeguro identificador unico del pago seguro
	 * @return SccMxMaeOferCampMaDTO
	 */
	@Override
	public SccMxMaeOferCampMaDTO obtenerOferMaxPlazo(Long idCampania, Long idTasa, Long idProducto, String codPeriod,
			Long idPeriodicidad, Long idPagoSeguro) {
 
		List<SccMxPrcOferMaxTasa> listaMxPrcOferMaxTasa = daoPrcOferMaxPlazo.buscaTasas( idCampania );
		List<SccMxPrcOferMaxPlzo> listaMxPrcOferMaxPlzo = daoPrcOferMaxPlazo.buscaOfertasMaximasPlazoTasa( idCampania , idTasa);		
		List<SccMxPrcOferMaxTasaDTO> listaMxPrcOferMaxTasaDTO = new ArrayList<SccMxPrcOferMaxTasaDTO>();
		
		for (int i = 0; i < listaMxPrcOferMaxTasa.size(); i++) {
			SccMxPrcOferMaxTasa objTasasDTO =  listaMxPrcOferMaxTasa.get(i);
			objTasasDTO.setCodTasa(objTasasDTO.getCodTasa());
			objTasasDTO.setIdOferMaxTasaPk(objTasasDTO.getIdOferMaxTasaPk());
			objTasasDTO.setPorTasa(objTasasDTO.getPorTasa());
			objTasasDTO.setSccMxMaeOferCam(objTasasDTO.getSccMxMaeOferCam());
			
		}
		

		List<Double> listaMontosPeriodo = new ArrayList<>();
		List<Long> listaPlazosPeriodo = new ArrayList<>();
		List<Double> listPagosPeriodo = new ArrayList<>();

		for (int i = 0; i < listaMxPrcOferMaxPlzo.size(); i++) {
			SccMxPrcOferMaxPlzo obj = listaMxPrcOferMaxPlzo.get(i);
			listaMontosPeriodo.add(obj.getImpMonto());
			listaPlazosPeriodo.add(obj.getCanPlzo());

		}

		Double tasa = getTasaPorId(idTasa, listaMxPrcOferMaxTasa);

		SccMxUtileriasOferMaxPlazo utilerias = new SccMxUtileriasOferMaxPlazo();
		listPagosPeriodo = utilerias.calculaMontosMensuales(tasa, listaPlazosPeriodo, listaMontosPeriodo, 
				idProducto, idPeriodicidad, codPeriod, idPagoSeguro,condFinancieras);

		SccMxPrcOferMaxPlazoDTO  ltSccMxPrcOferMaxPlazoDTO = new SccMxPrcOferMaxPlazoDTO(listaPlazosPeriodo, listaMontosPeriodo, listPagosPeriodo);
		String descripPeriodo = "";

		ltSccMxPrcOferMaxPlazoDTO.setMatriz(armaMatrizTabla(listaMontosPeriodo, listaPlazosPeriodo, listPagosPeriodo, descripPeriodo));

		SccMxMaeOferCampMaDTO sccMxMaeOferCampMaDTO = new SccMxMaeOferCampMaDTO();
		sccMxMaeOferCampMaDTO.setLtSccMxPrcOferMaxPlazos(ltSccMxPrcOferMaxPlazoDTO);
		sccMxMaeOferCampMaDTO.setLtSccMxPrcOferMaxTasas(listaMxPrcOferMaxTasaDTO);
		sccMxMaeOferCampMaDTO.setLtSccMxMaeOferCam(new ArrayList<>());
		sccMxMaeOferCampMaDTO.setLtSccMxMaeOferPromCam(new ArrayList<>());
		sccMxMaeOferCampMaDTO.setLtSccMxMaeOferPromMa(new ArrayList<>());
		
		return sccMxMaeOferCampMaDTO;
	}

	/**
	 * Obtiene la tasa el valor de la tasa por id
	 * @param idTasa identificador unico de la tasa 
	 * @param ltSccMxPrcOferMaxTasa lista con las tasas encontradas
	 * @return valor de tasa en porcentaje
	 */
	private Double getTasaPorId(Long idTasa, List<SccMxPrcOferMaxTasa> ltSccMxPrcOferMaxTasa) {
		Double tasa = 0.0;
		if (ltSccMxPrcOferMaxTasa != null && !ltSccMxPrcOferMaxTasa.isEmpty()) {
			for (int i = 0; i < ltSccMxPrcOferMaxTasa.size(); i++) {

				SccMxPrcOferMaxTasa base = ltSccMxPrcOferMaxTasa.get(i);
				if (idTasa.longValue()  == base.getIdOferMaxTasaPk().longValue()) {
					tasa = base.getPorTasa();
				}
			}
		}
		return tasa;
	}



}
