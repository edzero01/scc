package mx.isban.scc.model.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO de Ofertas por campana
 * 
 * @author Alexis Cedillo Contiene los atributos de la entidad de ofertas por
 *         campana: SccMxMaeOferCam
 */
public class SccMxMaeOferCamPadreDTO implements Serializable {

	/**
	 * identificador para serializar la clase SccMxMaeOferCamDTO
	 */
	private static final long serialVersionUID = -6224368785937478681L;
	/**
	 * id de ofertas por campaña
	 */
	protected Long idOferCamPk;
	/**
	 * fecha inicio de ofertas por campaña
	 */
	protected Date fchIniProm;
	/**
	 * fecha fin de ofertas por campaña
	 */
	protected Date fchFinProm;
	/**
	 * idperiodicidad de ofertas por campaña
	 */
	protected Long idSccMxMaePeriod;
	/**
	 * idproducto al que aplica la campaña
	 */
	protected Long idSccMxMaeProducto;
	/**
	 * idsegmento del cliente al que aplica la campaña
	 */
	protected Long idSccMxMaeSegmento;
	/**
	 * idSubproducto al que aplica la campaña
	 */
	protected Long idSubProdFk;
	/**
	 * nombre del cliente de ofertas por campaña
	 */
	protected String descNombreCte;
	/**
	 * Id del cliente de ofertas por campaña
	 */
	protected String idBucCliente;
	/**
	 * ID de tipo de producto de ofertas por campaña
	 */
	protected Long idTipoProducto;

	/**
	 * Constructor con propiedades del objeto
	 * 
	 * @param idOferCamPk      id oferta campanua
	 * @param fchIniProm       fehca inicio promocion
	 * @param fchFinProm       fecha fin promocion
	 * @param sccMxMaePeriod   objeto periodo
	 * @param sccMxMaeProducto objeto producto
	 * @param sccMxMaeSegmento objeto segmento
	 * @param idSubProdFk      objeto subproducto
	 * @param descNombreCte    nombre de cliente
	 * @param idBucCliente     buc cliente
	 * @param idTipoProducto   tipo producto
	 */
	public SccMxMaeOferCamPadreDTO(Long idOferCamPk, Date fchIniProm, Date fchFinProm, Long sccMxMaePeriod,
			Long sccMxMaeProducto, Long sccMxMaeSegmento, Long idSubProdFk, String descNombreCte, String idBucCliente,
			Long idTipoProducto) {
		super();
		this.idOferCamPk = idOferCamPk;
		this.fchIniProm = new Date(fchIniProm.getTime());
		this.fchFinProm = new Date(fchFinProm.getTime());
		this.idSccMxMaePeriod = sccMxMaePeriod;
		this.idSccMxMaeProducto = sccMxMaeProducto;
		this.idSccMxMaeSegmento = sccMxMaeSegmento;
		this.idSubProdFk = idSubProdFk;
		this.descNombreCte = descNombreCte;
		this.idBucCliente = idBucCliente;
		this.idTipoProducto = idTipoProducto;
	}

	/**
	 * getIdTipoProducto()
	 * 
	 * @return idTipoProducto Id de tipo de producto
	 */
	public Long getIdTipoProducto() {
		return idTipoProducto;
	}

	/**
	 * setIdTipoProducto()
	 * 
	 * @param idTipoProducto Id de tipo de producto
	 */
	public void setIdTipoProducto(Long idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}

	/**
	 * getIdBucCliente()
	 * 
	 * @return idBucCliente Id BUC del cliente
	 */
	public String getIdBucCliente() {
		return idBucCliente;
	}

	/**
	 * setIdBucCliente()
	 * 
	 * @param idBucCliente Id BUC del cliente
	 */
	public void setIdBucCliente(String idBucCliente) {
		this.idBucCliente = idBucCliente;
	}

	/**
	 * getDescNombreCte
	 * 
	 * @return descNombreCte Nombre del cliente
	 */
	public String getDescNombreCte() {
		return descNombreCte;
	}

	/**
	 * setDescNombreCte
	 * 
	 * @param descNombreCte Nombre del cliente
	 */
	public void setDescNombreCte(String descNombreCte) {
		this.descNombreCte = descNombreCte;
	}

	/**
	 * getIdOferCamPk
	 * 
	 * @return idOferCamPk Id de la oferta de campaña
	 */
	public Long getIdOferCamPk() {
		return idOferCamPk;
	}

	/**
	 * setIdOferCamPk
	 * 
	 * @param idOferCamPk Id de la oferta de campaña
	 */
	public void setIdOferCamPk(Long idOferCamPk) {
		this.idOferCamPk = idOferCamPk;
	}

	/**
	 * getFchIniProm
	 * 
	 * @return fchIniProm Fecha de inicio de la promoción
	 */
	public Date getFchIniProm() {
		return new Date(fchIniProm.getTime());
	}

	/**
	 * setFchIniProm
	 * 
	 * @param fchIniProm Fecha de inicio de la promoción
	 */
	public void setFchIniProm(Date fchIniProm) {
		this.fchIniProm = new Date(fchIniProm.getTime());
	}

	/**
	 * getFchFinProm
	 * 
	 * @return fchFinProm Fecha de fin de la promoción
	 */
	public Date getFchFinProm() {
		return new Date(fchFinProm.getTime());
	}

	/**
	 * setFchFinProm
	 * 
	 * @param fchFinProm Fecha de fin de la promoción
	 */
	public void setFchFinProm(Date fchFinProm) {
		this.fchFinProm = new Date(fchFinProm.getTime());
	}

	/**
	 * SccMxMaePeriod
	 * 
	 * @return idSccMxMaePeriod Id del periodo
	 */
	public Long getSccMxMaePeriod() {
		return idSccMxMaePeriod;
	}

	/**
	 * setSccMxMaePeriod
	 * 
	 * @param sccMxMaePeriod Id del periodo
	 */
	public void setSccMxMaePeriod(Long sccMxMaePeriod) {
		this.idSccMxMaePeriod = sccMxMaePeriod;
	}

	/**
	 * SccMxMaeProducto
	 * 
	 * @return SccMxMaeProducto ID del producto
	 */
	public Long getSccMxMaeProducto() {
		return idSccMxMaeProducto;
	}

	/**
	 * setSccMxMaeProducto
	 * 
	 * @param sccMxMaeProducto Id del producto
	 */
	public void setSccMxMaeProducto(Long sccMxMaeProducto) {
		this.idSccMxMaeProducto = sccMxMaeProducto;
	}

	/**
	 * getSccMxMaeSegmento
	 * 
	 * @return SccMxMaeSegmento Id del segmento
	 */
	public Long getSccMxMaeSegmento() {
		return idSccMxMaeSegmento;
	}

	/**
	 * setSccMxMaeSegmento
	 * 
	 * @param sccMxMaeSegmento Id del segmento
	 */
	public void setSccMxMaeSegmento(Long sccMxMaeSegmento) {
		this.idSccMxMaeSegmento = sccMxMaeSegmento;
	}

	/**
	 * getIdSubProdFk
	 * 
	 * @return idSubProdFk Id del subproducto
	 */
	public Long getIdSubProdFk() {
		return idSubProdFk;
	}

	/**
	 * setIdSubProdFk
	 * 
	 * @param idSubProdFk Id del subproducto
	 */
	public void setIdSubProdFk(Long idSubProdFk) {
		this.idSubProdFk = idSubProdFk;
	}

}
