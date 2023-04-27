package mx.isban.scc.utilerias;
/**
 * Lista de llaves con sus definiciones para Usuario
 * para el llenado de plantillas de Carátuyla de crédito
 * @author José Luis Garcia
 * 
 */
public final class CaratulaPlantillaDef {


	/**
	 * definicion para llave producto
	 */
	public static final String PRODUCTO = "{{producto}}";
	/**
	 * definicion para llave tipoOferta
	 */
	public static final String OFERTA = "{{oferta}}";
	/**
	 * definicion para llave montoCredito
	 */
	public static final String MONTO = "{{montoCredito}}";
	/**
	 * definicion para llave plazoMeses
	 */
	public static final String PLAZO = "{{plazoMeses}}";
	/**
	 * definicion para llave montoTotal
	 */
	public static final String MTOTAL = "{{mTotal}}";
	/**
	 * definicion para llave periodicidad
	 */
	public static final String PERIODICIDAD = "{{periodicidad}}";
	/**
	 * definicion para llave tasaInteres
	 */
	public static final String TASA = "{{tasaInteres}}";
	/**
	 * definicion para llave comisionAper
	 */
	public static final String APERTURA = "{{comisionAper}}";
	/**
	 * definicion para llave comision por apertura en letra
	 */
	public static final String APERTURAL = "{{aperturaL}}";
	/**
	 * definicion para llave seguro
	 */
	public static final String SEGURO = "{{seguro}}";
	/**
	 * definicion para llave cat
	 */
	public static final String CAT = "{{cat}}";
	/**
	 * definicion para llave aseguradora
	 */
	public static final String ASEGURADORA = "{{aseguradora}}";
	/**
	 * definicion para llave fecha
	 */
	public static final String FECHA = "{{fecha}}";
	/**
	 * definicion para llave dia de pago
	 */
	public static final String DIAPAGO = "{{diaPago}}";
	/**
	 * definicion para llave pago tardio
	 */
	public static final String PAGOTARDIO = "{{pagoTardio}}";
	/**
	 * definicion para llave iclausula
	 */
	public static final String CLAUSULA = "{{clausula}}";
	/**
	 * definicion para llave pago tardio en letra
	 */
	public static final String TARDIOL = "{{tardioL}}";
	/**
	 * definicion para llave caucion
	 */
	public static final String CAUCION = "{{caucion}}";
	/**
	 * Plantilla 5 TA
	 */
	public static final String TA5 = "plantillasTA\\5.docx";
	
	/**
	 * definicion para llave de oferta promocional
	 */
	public static final String OFERTA_LEYENDA = "{{ofertaLeyenda}}";
	
	
	/**
	 * Constructor de la clase, provado para evitar se construya el objeto
	 */
	private CaratulaPlantillaDef() {
		// Constructor de la clase, provado para evitar se construya el objeto
		throw new IllegalStateException("Utility class");
	}
	
}
