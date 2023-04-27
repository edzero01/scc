package mx.isban.scc.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.isban.scc.dao.ISccMxMaeSimuladorDroDAO;
import mx.isban.scc.model.SccMxMaeSimuladorDro;
import mx.isban.scc.model.dto.ReportesDTO;
import mx.isban.scc.model.dto.SccMxMaeSimuladorDroDTO;
import mx.isban.scc.utilerias.ValidaNull;

/**
 * Clase Servicio para buscar los reportes
 * Se filtran reportes y se genera DTO de salida de datos
 * Fecha Septiembre 2019
 * Global Hitss
 * Sprint 4.1 
 * 
 * @author Juan Carlos Romero Benítez
 *
 */
@Service
public class SimuladorReportesService implements ISimuladorReportesService{

	//DAO de Reportes
	@Autowired
	private ISccMxMaeSimuladorDroDAO reportesDroDAO;
	
	/**
	 * Método que busca la información de los reportes
	 * mediante filtros se crea un DTO auxiliar
	 * para enviar la información a un archivo CSV
	 * @param sccMxMaeSimuladorDroDTO SimuladorReportesService
	 * @return List(ReportesDTO) con los datos de los reportes
	 */
	@Override
	public List<ReportesDTO> consultaReporte(SccMxMaeSimuladorDroDTO sccMxMaeSimuladorDroDTO) {
		//Lista de simulaciones
		List<SccMxMaeSimuladorDro> sccMxMaeSimuladorDro = reportesDroDAO.consultaSimuladorDro(sccMxMaeSimuladorDroDTO); 
		//Lista de reportes
		List<ReportesDTO> listaReporte = new ArrayList<ReportesDTO>();
		String dscMvoRechazo = "";
		for (SccMxMaeSimuladorDro simuladorDro : sccMxMaeSimuladorDro) {
			if (simuladorDro.getIdMvoRechazoFk() != null) {
				dscMvoRechazo = simuladorDro.getIdMvoRechazoFk().getDscMvoRechazo();
			}
			
//			public ReportesDTO(String descPerfilComercial, String descUsuarioComercial, Long codigoCliente,
//					String nombreCliente, Double montoCredito, String causaRechazo, Date fechaSimulacion, String subProducto,
//					Long convAuto, Double tasaInteresOrdAnual, Double tiie, Double bonificacionSeguros,
//					Double saldoCreditoRestituir, String periodicidad, Double pago, String fondoGarantia, Double cat)
			//Por cada simulación. genera un objeto DTO de reporte
			ReportesDTO reporte = new ReportesDTO();
			reporte.setDescPerfilComercial(simuladorDro.getIdPerfilFk().getDscPerfil());
			reporte.setDescUsuarioComercial(simuladorDro.getIdUsrFk().getDscTipo());
			reporte.setCodigoCliente(simuladorDro.getIdBucClte());
			reporte.setNombreCliente(simuladorDro.getDscNumClte());
			reporte.setMontoCredito(simuladorDro.getImpCred());
			reporte.setCausaRechazo(dscMvoRechazo);
			reporte.setFechaSimulacion(simuladorDro.getFchSimul());
			reporte.setSubProducto(simuladorDro.getIdSubProdFk().getSccMxMaeProducto().getCodProd().toString() + '-' + simuladorDro.getIdSubProdFk().getCodSubProd().toString());
			reporte.setConvAuto(simuladorDro.getFlgConvAuto());
			reporte.setTasaInteresOrdAnual(simuladorDro.getPorTasOrdAnual());
			reporte.setTiie(simuladorDro.getPorTiie());
			reporte.setBonificacionSeguros(simuladorDro.getImpBonifSgros());
			reporte.setSaldoCreditoRestituir(simuladorDro.getImpSaldoCredRest());
			reporte.setPeriodicidad(simuladorDro.getIdPeriodFk().getDscPeriod());
			reporte.setPago(simuladorDro.getImpPago());
			reporte.setFondoGarantia(simuladorDro.getTxtFondoGarantia());
			reporte.setCat(simuladorDro.getPorCatPromSinIva());
			//Y lo añade a la lista de reportes
			listaReporte.add(reporte);
		}
		//Regresa la lista de reportes
		return listaReporte;
		
	}

	/**
	 * Método que busca la información de los reportes CSV
	 * la informacion obtenida se 
	 * maneja para un formato especifico
	 * en archivo de exportacion CSV
	 * que puede ser abierto como hoja de excel
	 * @param ltsReportes List(ReportesDTO) 
	 * @return byte[] con los datos de los reportes CSV
	 */
	@Override
	public byte[] obtieneCSV(List<ReportesDTO> ltsReportes) throws IOException {
		//Clase de utilería para atrapar valores nulos
		//y pasar defaults.
		ValidaNull oValidaNull = new ValidaNull();
		//Se usa rompimiento de línea tipo UNIX
		final String NEXT_LINE = "\n";
		final String delim = ",";
		StringBuilder fw = new StringBuilder();

		//Se construye la primera línea con el nombre de las columnas
		//Es posible remover los espacios
		//Y sustituírlos por guiones bajos.
		fw.append("Perfil comercial").append(delim);
		fw.append("Usuario comercial").append(delim);
		fw.append("Codigo de cliente").append(delim);
		fw.append("Nombre del cliente").append(delim);
		fw.append("Monto del credito").append(delim);
		fw.append("Causa de Rechazo ").append(delim);
		fw.append("Fecha y hora de Simulacion ").append(delim);
		fw.append("Subproducto ").append(delim);
		fw.append("Conversion Auto").append(delim);
		fw.append("CAT promedio sin IVA").append(delim);
		fw.append("Tasa de interes ordinaria anual").append(delim);
		fw.append("TIIE").append(delim);
		fw.append("Bonificacion de los seguros").append(delim);
		fw.append("Saldo del credito a restituir").append(delim);
		fw.append("Periodicidad").append(delim);
		fw.append("Pago").append(delim);
		fw.append("Fondo en garantia").append(delim);
		fw.append(NEXT_LINE);
		
		//Líneas de datos subsecuentes
		for (ReportesDTO reporte : ltsReportes) {
			fw.append(reporte.getDescPerfilComercial());
			fw.append(delim);
			fw.append(reporte.getDescUsuarioComercial());
			fw.append(delim);
			fw.append(reporte.getCodigoCliente());
			fw.append(delim);
			fw.append(reporte.getNombreCliente());
			fw.append(delim);
			fw.append(Double.toString(reporte.getMontoCredito()));
			fw.append(delim);
			fw.append(reporte.getCausaRechazo());
			fw.append(delim);
			fw.append(String.valueOf(reporte.getFechaSimulacion()));
			fw.append(delim);
			fw.append(reporte.getSubProducto());
			fw.append(delim);
			fw.append(reporte.getConvAuto());
			fw.append(delim);
			fw.append(Double.toString(reporte.getCat()));
			fw.append(delim);
			fw.append(reporte.getTasaInteresOrdAnual());
			fw.append(delim);
			fw.append(reporte.getTiie());
			fw.append(delim);
			fw.append(oValidaNull.validaNullDouble(reporte.getBonificacionSeguros()));
			fw.append(delim);
			fw.append(reporte.getSaldoCreditoRestituir());
			fw.append(delim);
			fw.append(reporte.getPeriodicidad());
			fw.append(delim);
			fw.append(reporte.getPago());
			fw.append(delim);
			fw.append(reporte.getFondoGarantia());
			fw.append(NEXT_LINE);
		}
		
		//Se usa el método de getbytes con
		//uso explícito de CharsetName
		//Esto para evitar la incidencia de SonarQube
		//"Reliance on default encoding"
		return fw.toString().getBytes("UTF-8");
	}

}
