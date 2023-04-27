package mx.isban.scc.utilerias;
/**
 * Lista de llaves con sus definiciones para Usuario
 * para el llenado de plantillas de tablas de amortizacion
 * @author Christopher Espina Riveros
 * 
 * Mayo 2019
 * Global Hitss
 */
public final class Ries139PlantillaDef {


	/**
	 * definicion para llave producto
	 */
	public static final String SUBPRODUCTO = "{{subtipo}}";
	/**
	 * definicion para llave acreditado
	 */
	public static final String ACREDITADO = "{{acreditado}}";
	/**
	 * definicion para llave buc
	 */
	public static final String BUC = "{{buc}}";
	/**
	 * definicion para llave montoCredito
	 */
	public static final String MONTO = "{{valorCredito}}";
	/**
	 * definicion para llave plazoMeses
	 */
	public static final String PLAZO = "{{plazoMeses}}";
	/**
	 * definicion para llave numeroPagos
	 */
	public static final String CUENTA = "{{noCuenta}}";
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
	 * definicion para llave comisionDispo
	 */
	public static final String DISPOSICION = "{{comisiónDispo}}";
	/**
	 * definicion para llave esquemaSeguro
	 */
	public static final String SEGUROS = "{{seguros}}";
	/**
	 * definicion para llave cat
	 */
	public static final String CAT = "{{cat}}";
	/**
	 * definicion para llave F
	 */
	public static final String FECHA = "{{fecha}}";
	/**
	 * definicion para llave no pagos
	 */
	public static final String PAGOS = "{{pagos}}";
	/**
	 * definicion para llave pago fijo
	 */
	public static final String MODALIDAD = "{{modalidad}}";
	/**
	 * definicion para llave capital
	 */
	public static final String SUBTIPO = "{{subtipos}}";
	/**
	 * definicion para llave interes
	 */
	public static final String SUCURSAL = "{{sucursal}}";
	/**
	 * definicion para llave iva de interes
	 */
	//public static final String IVA = "{{iva}}";
	/**
	 * definicion para llave seguros de tabla
	 */
	public static final String FORMAPAGO = "{{formadepago}}";
	/**
	 * definicion para llave pago total
	 */
	public static final String PAGOSEGURO = "{{pagoSeguros}}";
	/**
	 * definicion para llave saldo credito
	 */
	public static final String SALDOC = "{{saldoRes}}";
	/**
	 * definicion para llave caucion
	 */
	public static final String CAUCION = "{{caucion}}";
	/**
	 * definicion para llave tiie
	 */
	public static final String CUOTA = "{{cuota}}";
	/**
	 * definicion para llave puntos tiie
	 */
	public static final String IMPORTE = "{{importe}}";
	/**
	 * Plantilla 1 TA
	 */
	public static final String TA4 = "plantillasTA\\4.docx";
	/**
	 * Plantilla 2 TA
	 */
	//public static final String TA2 = "plantillasTA\\2.docx";
	/**
	 * Plantilla 3 TA
	 */
	//public static final String TA3 = "plantillasTA\\3.docx";
	
	
	/**
	 * definicion para llave de oferta promocional
	 */
	public static final String OFERTA_LEYENDA = "{{ofertaLeyenda}}";
	
	
	/**
	 * Constructor de la clase, provado para evitar se construya el objeto
	 */
	private Ries139PlantillaDef() {
		// Constructor de la clase, provado para evitar se construya el objeto
		throw new IllegalStateException("Utility class");
	}
	
}
