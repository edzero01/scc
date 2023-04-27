package mx.isban.scc.model.dto;
import java.io.Serializable;
import java.util.Date;

/**
 * DTO de Ofertas Promocionales por Mercado Abierto
 * @author Alexis Cedillo
 * Contiene los atributos de la entidad de mercado abierto:
 * SccMxMaeOferPromMa
 * Se relaciona con cliente pero puede ser null este dato
 * en cuyo caso se relaciona con idprod idsubprod
 */
public class SccMxMaeOferPromMaDTO implements Serializable{
	
	/**
	 * Serial version id de la clase
	 */
	private static final long serialVersionUID = 8129866114714976582L;
	/**
	 * id de ofertas promocionales por mercado abierto
	 */
	private Long idOferPromPk;
	/**
	 * comision de ofertas promocionales por mercado abierto
	 */
	private Long idComision;
	/**
	 * Producto al que aplica la oferta promocional en mercado abierto
	 */
	private Long idProducto; 
	/**
	 * SubProducto al que aplica la oferta promocional en mercado abierto
	 */
	private Long idSubProducto;
	/**
	 * id del cliente de ofertas promocionales por mercado abierto
	 */
	private Long idBucClte;
	/**
	 * fecha de inicio de ofertas promocionales por mercado abierto
	 */
	private Date fchIniProm;
	/**
	 * fecha fin de ofertas promocionales por mercado abierto
	 */
	private Date fchFinProm;
	/**
	 * descripcion del cliente de ofertas promocionales por mercado abierto
	 */
	private String dscNomClte;
	/**
	 * descripcion de la promocion de ofertas promocionales por mercado abierto
	 */
	private String dscNomProm;
	
	/**
	 * Constructor con propiedades del objeto
	 * @param idOferPromPk
	 * oferta promocion
	 * @param idComision
	 * objeto comision
	 * @param idProducto
	 * objeto producto
	 * @param idSubProducto
	 * objeto subproducto
	 * @param idBucClte
	 * buc cliente
	 * @param fchIniProm
	 * fecha inicion promocion
	 * @param fchFinProm
	 * fecha fin promocion
	 * @param dscNomClte
	 * nombre cliente
	 * @param dscNomProm
	 * nombre promocion
	 * @param idProducto
	 * id del porducto
	 * @param idSubProducto
	 * id del subproducto
	 */
	public SccMxMaeOferPromMaDTO(Long idOferPromPk, Long idComision, Long idProducto,
			Long idSubProducto, Long idBucClte, Date fchIniProm, Date fchFinProm, String dscNomClte,
			String dscNomProm) {
		super();
		this.idOferPromPk = idOferPromPk;
		this.idComision = idComision;
		this.idProducto = idProducto;
		this.idSubProducto = idSubProducto;
		this.idBucClte = idBucClte;
		this.fchIniProm = new Date(fchIniProm.getTime());
		this.fchFinProm = new Date(fchFinProm.getTime());
		this.dscNomClte = dscNomClte;
		this.dscNomProm = dscNomProm;
	}
	/**
	 * 
	 * @return idOferPromPk Id de la oferta promocional
	 */
	public Long getIdOferPromPk() {
		return idOferPromPk;
	}
	/**
	 * 
	 * @param idOferPromPk Id de la oferta promocional
	 */
	public void setIdOferPromPk(Long idOferPromPk) {
		this.idOferPromPk = idOferPromPk;
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
	public void setSccMxMaeComision(Long idComision) {
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
	public Long getIdSubProducto() {
		return idSubProducto;
	}
	/**
	 * 
	 * @param idSubProducto Id del subproducto
	 */
	public void setIdSubProducto(Long idSubProducto) {
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
	/**
	 * 
	 * @return dscNomClte Nombre del cliente
	 */
	public String getDscNomClte() {
		return dscNomClte;
	}
	/**
	 * 
	 * @param dscNomClte Nombre del cliente
	 */
	public void setDscNomClte(String dscNomClte) {
		this.dscNomClte = dscNomClte;
	}
	/**
	 * 
	 * @return dscNomProm Nombre de la promoción
	 */
	public String getDscNomProm() {
		return dscNomProm;
	}
	/**
	 * 
	 * @param dscNomProm Nombre de la promoción
	 */
	public void setDscNomProm(String dscNomProm) {
		this.dscNomProm = dscNomProm;
	}
	
}
