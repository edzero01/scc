package mx.isban.scc.model.dto;

import java.io.Serializable;


/**
 * 
 * 
 *         Se crea DTO para guardar los datos
 * 
 *         que se necesitan para generar los archivos de los reportes
 * 
 *         Agosto 2019
 * 
 *         GlobalHitss
 * 
 *         Clase DTO para los generar los reportes
 * 
 *         la clase se ecarga de encapsular los datos
 * 
 *         para generar los archivos de los reportes
 * 
 *         se agregan comentarios para filtros de sonar
 * 
 *         SprLong 4
 *         @author Jesus Elygyo Reyes Hurtado
 */
public class ReportesDTO extends ReportesPadreDTO implements Serializable {

	/**
	 * Serializar de la clase
	 */
	private static final long serialVersionUID = 3910255904173060999L;

	/**
	 * Variable tipo Long para guardar la conversion auto
	 */
	private Long convAuto;
	/**
	 * Variable tipo Long para guardar la tasa de interes ordinaria anual
	 */
	private Double tasaInteresOrdAnual;
	/**
	 * Variable tipo Long para guardar la tiie
	 */
	private Double tiie;
	/**
	 * Variable tipo Double para guardar  la bonificacion de los seguros
	 */
	private Double bonificacionSeguros;
	/**
	 * Variable tipo Double para guardar el saldo del credito a restituir
	 */
	private Double saldoCreditoRestituir;
	/**
	 * Variable tipo string para guardar la periodicidad
	 */
	private String periodicidad;
	/**
	 * Variable tipo Double para guardar pago
	 */
	private Double pago;
	/**
	 * Variable tipo string para guardar fondoGarantia
	 */
	private String fondoGarantia;
	/**
	 * Variable Double   para guardar  el cat 
	 */
	private Double cat;

	

	/**
	 * Regresa si existe o no conversion auto
	 * 
	 * @return convAuto indicador de conversion auto
	 */
	public Long getConvAuto() {
		return convAuto;
	}

	/**
	 * Inicializa la conversion auto
	 * 
	 * @param convAuto indicador de conversion auto
	 */
	public void setConvAuto(Long convAuto) {
		this.convAuto = convAuto;
	}

	/**
	 * Regresa la tasa de Longeres ordinaria anual
	 * 
	 * @return tasaInteresOrdAnual tasa de Longeres ordinaria anual
	 */
	public Double getTasaInteresOrdAnual() {
		return tasaInteresOrdAnual;
	}

	/**
	 * Inicializa la tasa de Longeres ordinaria anual
	 * 
	 * @param tasaInteresOrdAnual tasa de Longeres ordinaria anual
	 */
	public void setTasaInteresOrdAnual(Double tasaInteresOrdAnual) {
		this.tasaInteresOrdAnual = tasaInteresOrdAnual;
	}

	/**
	 * Regresa la tiie
	 * 
	 * @return tiie tiie
	 */
	public Double getTiie() {
		return tiie;
	}

	/**
	 * Inicializa la tiie
	 * 
	 * @param tiie tiie
	 */
	public void setTiie(Double tiie) {
		this.tiie = tiie;
	}

	/**
	 * Regresa la bonificacion de los seguros
	 * 
	 * @return bonificacionSeguros bonificacion de los seguros
	 */
	public Double getBonificacionSeguros() {
		return bonificacionSeguros;
	}

	/**
	 * Inicializa la bonificacion de los Seguros
	 * 
	 * @param bonificacionSeguros bonificacion de los seguros
	 */
	public void setBonificacionSeguros(Double bonificacionSeguros) {
		this.bonificacionSeguros = bonificacionSeguros;
	}

	/**
	 * Regresa el saldo del credito a restituir
	 * 
	 * @return saldoCreditoRestituir saldo del credito a restituir
	 */
	public Double getSaldoCreditoRestituir() {
		return saldoCreditoRestituir;
	}

	/**
	 * Inicializa el saldo del credito a restituir
	 * 
	 * @param saldoCreditoRestituir saldo del credito a restituir
	 */
	public void setSaldoCreditoRestituir(Double saldoCreditoRestituir) {
		this.saldoCreditoRestituir = oValidaNull.validaNullDouble(saldoCreditoRestituir);
	}

	/**
	 * Regresa la periodicidad
	 * 
	 * @return periodicidad periodicidad
	 */
	public String getPeriodicidad() {
		return periodicidad;
	}

	/**
	 * Inicializa la periodicidad
	 * 
	 * @param periodicidad periodicidad
	 */
	public void setPeriodicidad(String periodicidad) {
		this.periodicidad = periodicidad;
	}

	/**
	 * Regresa el pago
	 * 
	 * @return pago pago
	 */
	public Double getPago() {
		return pago;
	}

	/**
	 * Inicializa el pago
	 * 
	 * @param pago pago
	 */
	public void setPago(Double pago) {
		this.pago = pago;
	}

	/**
	 * Regresa el fondo de garantia
	 * 
	 * @return fondoGarantia fondo de garantia
	 */
	public String getFondoGarantia() {
		return fondoGarantia;
	}

	/**
	 * Inicializa el fondo de garantia
	 * 
	 * @param fondoGarantia fondo de garantia
	 */
	public void setFondoGarantia(String fondoGarantia) {
		this.fondoGarantia = oValidaNull.validaNullString(fondoGarantia);
	}

	/**
	 * Regresa el cat
	 * 
	 * @return cat costo anual total
	 */
	public Double getCat() {
		return cat;
	}

	/**
	 * Inicializa el cat
	 * 
	 * @param cat costo anual total
	 */
	public void setCat(Double cat) {
		this.cat = cat;
	}

	
	
}
