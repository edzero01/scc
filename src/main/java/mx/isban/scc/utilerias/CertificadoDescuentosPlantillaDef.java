package mx.isban.scc.utilerias;
/**
 * Lista de llaves con sus definiciones para Usuario
 * para el llenado de plantillas de Certificados de Descuento
 * @author Christopher Espina Riveros
 * 
 * Mayo 2019
 * Global Hitss
 */
public final class CertificadoDescuentosPlantillaDef {


	/**
	 * definicion para llave nombre promocion
	 */
	public static final String NOMPROMOCION = "{{nomProm}}";
	/**
	 * definicion para llave nombre colectivo
	 */
	public static final String NOMCOLECTIVO = "{{nomColect}}";
	/**
	 * definicion para llave nombre cliente
	 */
	public static final String CLIENTE = "{{nomCliente}}";
	/**
	 * definicion para llave nombre com promocion
	 */
	public static final String NOMCOMPROM = "{{nomComProm}}";
	/**
	 * definicion para llave com promocion
	 */
	public static final String COMPROM = "{{comProm}}";
	/**
	 * definicion para llave cat promocional
	 */
	public static final String CATPROM = "{{catProm}}";
	/**
	 * definicion para llave entidad crediticia
	 */
	public static final String ENTIDAD = "{{entCred}}";
	/**
	 * definicion para llave tasaInteres
	 */
	public static final String TASA = "{{tasaInteresProm}}";
	/**
	 * definicion para llave tarjeta
	 */
	public static final String TARJETA = "{{nomTarjeta}}";
	/**
	 * definicion para llave numero tarjeta
	 */
	public static final String NUMTARJETA = "{{numtarjeta}}";
	/**
	 * definicion para llave factor aseguramiento promocional
	 */
	public static final String SEGURO = "{{facAsegProm}}";
	/**
	 * definicion para llave fechaL
	 */
	public static final String FECHAL = "{{fechaL}}";
	/**
	 * definicion para llave fecha
	 */
	public static final String FECHA = "{{fecha}}";
	
	/**
	 * Constructor de la clase, provado para evitar se construya el objeto
	 */
	private CertificadoDescuentosPlantillaDef() {
		// Constructor de la clase, provado para evitar se construya el objeto
		throw new IllegalStateException("Utility class");
	}
	
}
