package mx.isban.scc.model.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO de Ofertas por campana
 * 
 * @author Alexis Cedillo 
 * Contiene los atributos de la entidad de ofertas por
 *         campana: SccMxMaeOferCam
 * El area de CRM Santander se encarga de subir esta informacion
 * por medio de FTP y al llegar a base de datos se extiende
 * con los Plazos y las Tasas para poder armar la tabla de 
 * ofertas por campania. 
 *
 */
public class SccMxMaeOferCamDTO extends SccMxMaeOferCamPadreDTO implements Serializable {

	/**
	 * identificador para serializar la clase SccMxMaeOferCamDTO
	 */
	private static final long serialVersionUID = -6224368785937478681L;
	
	/**
	 * Numero del crédito anterior, se ocupa en caso de Restitucion
	 */
	private Long numCredAnterior;
	/**
	 * Numero de cuenta, para desplegar los ultimos 4 digitos
	 */
	private double numCuenta;
	/**
	 * Codigo de acceso para perfil Contact Center. Si in || out = 1 entonces la oferta es visible
	 */
	private Long codVtaCcsIn;
	/**
	 * Codigo de acceso para perfil Contact center
	 */
	private Long codVtaCcsOut;
	/**
	 * Codigo de acceso para perfil venta red. Si in || out = 1 entonces la oferta es visible para este perfil
	 */
	private Long codVtaRedIn;
	/** Codigo de acceso para perfil venta red
	 */
	private Long codVtaRedOut;
	/**
	 * Codigo de acceso para perfil venta Fuerza de Ventas (que incluye al ASN por cmabios en operacion)
	 */
	private Long codVtaAsn;
	/**
	 * Codigo de acceso que se usa en conjunto con codvtaasn si cualquiera de los dos es = | entonces es visible la oferta
	 */
	private Long codVtaFve;
	
	/**
	 * Numero del contrato, num_con_tdc_ant en tabla ofer_cam. Se usa en Restitucion LINEX
	 */
	private Long numContrato;

	/**
	 * Numero de la sucursal, num_suc_tdc_ant en tabla ofer_cam. Se usa en Restitucion LINEX
	 */
	private Long numSucursal;
	
	/**
	 * Identificador del dia de pago (Magisterio)
	 */
	private Long idDiaPagoFk;

	/**
	 * Identificador del calendario (Magisterio)
	 */
	private String codCalendario;

	/**
	 * Constructor con propiedades del objeto
	 * 
	 * @param idOferCamPk      id oferta campanua
	 * @param fchIniProm       fehca inicio promocion
	 * @param fchFinProm       fecha fin promocion
	 * @param sccMxMaePeriod   objeto periodo
	 * @param sccMxMaeProducto objeto producto
	 * @param sccMxMaeSegmento objeto segmento
	 * @param idSubProdFk  objeto subproducto
	 * @param descNombreCte    nombre de cliente
	 * @param idBucCliente     buc cliente
	 * @param idTipoProducto   tipo producto
	 */
	public SccMxMaeOferCamDTO(Long idOferCamPk, Date fchIniProm, Date fchFinProm, Long sccMxMaePeriod,
			Long sccMxMaeProducto, Long sccMxMaeSegmento, Long idSubProdFk, String descNombreCte,
			String idBucCliente, Long idTipoProducto) {
		super(idOferCamPk, new Date(fchIniProm.getTime()),new Date(fchFinProm.getTime()),sccMxMaePeriod,sccMxMaeProducto,
				sccMxMaeSegmento,idSubProdFk,descNombreCte, idBucCliente,idTipoProducto);
	}
	
	

	/**
	 * @return codVtaCcsIn Codigo de acceso para perfil Venta CCS IN
	 */
	public Long getCodVtaCcsIn() {
		return codVtaCcsIn;
	}

	/**
	 * @param codVtaCcsIn Codigo de acceso para perfil Venta CCS IN
	 */
	public void setCodVtaCcsIn(Long codVtaCcsIn) {
		this.codVtaCcsIn = codVtaCcsIn;
	}
	
	/**
	 * Con este metodo se van a setear las dos banderas
	 * @param codVtaCcsIn
	 * necesarias para dar permiso
	 * @param codVtaCcsOut
	 * al usuario de contact center
	 */
	public void setFlagsCcs(Long codVtaCcsIn,Long codVtaCcsOut) {
		this.codVtaCcsIn = codVtaCcsIn;
		this.codVtaCcsOut = codVtaCcsOut;
	}

	/**
	 * Con este metodo se van a setear las dos banderas
	 * @param codVtaRedIn
	 * necesarias para dar permiso
	 * @param codVtaRedOut
	 * al usuario de red
	 */
	public void setFlagsRed(Long codVtaRedIn,Long codVtaRedOut) {
		this.codVtaRedIn = codVtaRedIn;
		this.codVtaRedOut = codVtaRedOut;
	}

	/**
	 * @return codVtaCcsOut Codigo de acceso para perfil venta CSS OUT
	 */
	public Long getCodVtaCcsOut() {
		return codVtaCcsOut;
	}

	/**
	 * @param codVtaCcsOut Codigo de acceso para perfil venta CSS OUT
	 */
	public void setCodVtaCcsOut(Long codVtaCcsOut) {
		this.codVtaCcsOut = codVtaCcsOut;
	}

	/**
	 * @return codVtaRedIn Codigo de acceso para perfil venta red IN
	 */
	public Long getCodVtaRedIn() {
		return codVtaRedIn;
	}

	/**
	 * @param codVtaRedIn Codigo de acceso para perfil venta red IN
	 */
	public void setCodVtaRedIn(Long codVtaRedIn) {
		this.codVtaRedIn = codVtaRedIn;
	}

	/**
	 * @return codVtaRedOut Codigo de acceso para perfil venta red OUT
	 */
	public Long getCodVtaRedOut() {
		return codVtaRedOut;
	}

	/**
	 * @param codVtaRedOut Codigo de acceso para perfil venta red OUT
	 */
	public void setCodVtaRedOut(Long codVtaRedOut) {
		this.codVtaRedOut = codVtaRedOut;
	}

	/**
	 * @return codVtaAsn Codigo de acceso para perfil venta ASN
	 */
	public Long getCodVtaAsn() {
		return codVtaAsn;
	}

	/**
	 * @param codVtaAsn Codigo de acceso para perfil venta ASN
	 */
	public void setCodVtaAsn(Long codVtaAsn) {
		this.codVtaAsn = codVtaAsn;
	}

	/**
	 * @return codVtaFve Codigo de acceso para perfil venta FVE
	 */
	public Long getCodVtaFve() {
		return codVtaFve;
	}

	/**
	 * @param codVtaFve Codigo de acceso para perfil venta FVE
	 */
	public void setCodVtaFve(Long codVtaFve) {
		this.codVtaFve = codVtaFve;
	}


	/**
	 * Regresa el numero de crédito anterior
	 * 
	 * @return numCredAnterior Número de crédito anterior
	 */
	public Long getNumCredAnterior() {
		return numCredAnterior;
	}

	/**
	 * Inicializa el numero del credito anterior en el objeto
	 * 
	 * @param numCredAnterior Número de crédito anterior
	 */
	public void setNumCredAnterior(Long numCredAnterior) {
		this.numCredAnterior = numCredAnterior;
	}

	/**
	 * @return double numCuenta Número de cuenta
	 */
	public double getNumCuenta() {
		return numCuenta;
	}

	/**
	 * @param numCuenta double Número de cuenta
	 */
	public void setNumCuenta(double numCuenta) {
		this.numCuenta = numCuenta;
	}

	/**
	 * @return numContrato Long
	 */
	public Long getNumContrato() {
		return numContrato;
	}

	/**
	 * @param numContrato Long
	 */
	public void setNumContrato(Long numContrato) {
		this.numContrato = numContrato;
	}

	/**
	 * @return Long SccMxMaeOferCamDTO
	 */
	public Long getNumSucursal() {
		return numSucursal;
	}

	/**
	 * @param numSucursal Long
	 */
	public void setNumSucursal(Long numSucursal) {
		this.numSucursal = numSucursal;
	}
	
	/**
	 * @return Long idDiaPagoFk
	 */
	public Long getIdDiaPagoFk() {
		return idDiaPagoFk;
	}
	
	/**
	 * 
	 * @param idDiaPagoFk Long
	 */
	public void setIdDiaPagoFk(Long idDiaPagoFk) {
		this.idDiaPagoFk = idDiaPagoFk;
	}
	
	/**
	 * @return Long idCalendarioFk
	 */
	public String getCodCalendario() {
		return codCalendario;
	}
	
	/**
	 * @param idCalendarioFk Long
	 */
	public void setCodCalendario(String codCalendario) {
		this.codCalendario = codCalendario;
	}
}
