
package mx.isban.scc.model.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO de Ofertas Promocionales por campana
 * @author Alexis Cedillo
 * Contiene los atributos de la entidad de ofertas promocionales por campana:
 * SccMxMaeOferPromCam
 * Se relaciona con la tabla sccmxmaeofercam por idbuc, idprod , idsubprod
 * y vigencia
 */
public class SccMxMaeOferPromCamDTO  implements Serializable {

	
	/**
	 * Serial version id de la clase
	 */
	private static final long serialVersionUID = -4302161781478746131L;
	/**
	 * Llave principal para las ofertas promocionales de  campaña
	 */
	private Long idOferPreCamPk;
	/**
	 * comision de ofertas promocionales por  campaña
	 */
	private Long idComision;
	/**
	 * producto de ofertas promocionales por  campaña
	 */
	private Long idProducto;
	/**
	 * subproducto de ofertas promocionales por  campaña
	 */
	private Long idSubProducto;
	/**
	 * id cliente de ofertas promocionales por campaña
	 */
	private Long idBucClte;
	/**
	 * fecha de inicio de ofertas promocionales por  campaña
	 */
	private Date fchIniProm;
	/**
	 * fecha fin de ofertas promocionales por campaña
	 */  
	private Date fchFinProm;
	/**
	 * descripcion de nombre promocion de ofertas promocionales por  campaña
	 */
	private String dscNomProm;
	/**
	 * nombre del CLIENTE de ofertas promocionales por  campaña
	 */
	private String dscNomClte;

	
	/**
	 * constructor con propiedades del objeto
	 * @param idOferPreCamPk
	 * oferta precam
	 * @param idComision
	 * objeto comision
	 * @param idProducto
	 * objeto producto
	 * @param idSubProducto
	 * objeto subproducto
	 * @param idBucClte
	 * buc cliente
	 * @param fchIniProm
	 * fecha inicio promocion
	 * @param fchFinProm
	 * fecha fin promocion
	 * @param dscNomProm
	 * nombre promocion
	 * @param dscNomClte
	 * nombre cliente
	 */
	public SccMxMaeOferPromCamDTO(Long idOferPreCamPk, Long idComision,
			Long idProducto, Long idSubProducto, Long idBucClte, Date fchIniProm,
			Date fchFinProm, String dscNomProm, String dscNomClte) {
		super();
		this.idOferPreCamPk = idOferPreCamPk;
		this.idComision = idComision;
		this.idProducto = idProducto;
		this.idSubProducto = idSubProducto;
		this.idBucClte = idBucClte;
		this.fchIniProm = new Date(fchIniProm.getTime());
		this.fchFinProm = new Date(fchFinProm.getTime());
		this.dscNomProm = dscNomProm;
		this.dscNomClte = dscNomClte;
	}


	/**
	 * 
	 * @return String dscNomProm nombre del la promocion de ofertas promocionales por por campaña
	 */
	public String getDscNomProm() {
		return dscNomProm;
	}


	/**
	 * 
	 * @param dscNomProm nombre del la promocion de ofertas promocionales por por campaña
	 */
	public void setDscNomProm(String dscNomProm) {
		this.dscNomProm = dscNomProm;
	}


	/**
	 * 
	 * @return String dscNomClte Nombre del cliente de ofertas promocionales de campaña
	 */
	public String getDscNomClte() {
		return dscNomClte;
	}

	/**
	 * 
	 * @param dscNomClte Nombre del cliente de ofertas promocionales de campaña
	 */
	public void setDscNomClte(String dscNomClte) {
		this.dscNomClte = dscNomClte;
	}

	/**
	 * 
	 * @return idOferPreCamPk Id de la oferta de campaña
	 */
	public Long getIdOferPreCamPk() {
		return idOferPreCamPk;
	}
	/**
	 * 
	 * @param idOferPreCamPk Id de la oferta de campaña
	 */
	public void setIdOferPreCamPk(Long idOferPreCamPk) {
		this.idOferPreCamPk = idOferPreCamPk;
	}
	/**
	 * 
	 * @return idComision Id de la comisión
	 */
	public Long getIdComision() {
		return idComision;
	}
	/**
	 * 
	 * @param idComision Id de la comisión
	 */
	public void setIdComision(Long idComision) {
		this.idComision = idComision;
	}
	/**
	 * 
	 * @return idProducto Id del producto
	 */
	public Long getSccMxMaeProducto() {
		return idProducto;
	}
	/**
	 * 
	 * @param idProducto Id del producto
	 */
	public void setSccMxMaeProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	/**
	 * 
	 * @return idSubProducto Id del subproducto
	 */
	public Long getSccMxMaeSubProd() {
		return idSubProducto;
	}
	/**
	 * 
	 * @param idSubProducto Id del subproducto
	 */
	public void setSccMxMaeSubProd(Long idSubProducto) {
		this.idSubProducto = idSubProducto;
	}
	/**
	 * 
	 * @return idBucClte Id BUC del cliente
	 */
	public Long getIdBucClte() {
		return idBucClte;
	}
	/**
	 * 
	 * @param idBucClte Id BUC del cliente
	 */
	public void setIdBucClte(Long idBucClte) {
		this.idBucClte = idBucClte;
	}
	/**
	 * 
	 * @return fchIniProm Fecha de inicio de la promoción
	 */
	public Date getFchIniProm() {
		return new Date(fchIniProm.getTime());
	}
	/**
	 * 
	 * @param fchIniProm Fecha de inicio de la promoción
	 */
	public void setFchIniProm(Date fchIniProm) {
		this.fchIniProm = new Date(fchIniProm.getTime());
	}
	/**
	 * 
	 * @return fchFinProm Fecha de fin de la promoción
	 */
	public Date getFchFinProm() {
		return new Date(fchFinProm.getTime());
	}
	/**
	 * 
	 * @param fchFinProm Fecha de fin de la promoción
	 */
	public void setFchFinProm(Date fchFinProm) {
		this.fchFinProm = new Date(fchFinProm.getTime());
	}
	
	
}
