package mx.isban.scc.utilerias;
/**
 * Lista de llaves con sus definiciones para Usuario
 * para el llenado de plantillas de Cartas Compromiso
 * @author Christopher Espina Riveros
 * 
 * Mayo 2019
 * Global Hitss
 */
public final class CartaCompromisoPlantillaDef {

	/**
	 * definicion para llave nombre cliente
	 */
	public static final String CLIENTE = "{{nomCliente}}";
	/**
	 * definicion para llave monto
	 */
	public static final String MONTO = "{{monto}}";
	/**
	 * definicion para llave tarjeta
	 */
	public static final String TARJETA = "{{nomTarjeta}}";
	/**
	 * definicion para llave fechaL
	 */
	public static final String FECHAL = "{{fechaL}}";
	/**
	 * definicion para llave fecha
	 */
	public static final String FECHA = "{{fecha}}";
	/**
	 * Plantilla 4 CD
	 */
	public static final String CD1 = "plantillasCP\\1.docx";
	/**
	 * Plantilla 5 CD
	 */
	public static final String CD2 = "plantillasCP\\2.docx";
	/**
	 * Plantilla 1 NA
	 */
	public static final String NA1 = "plantillasNA\\1.docx";
	
	/**
	 * Constructor de la clase, privado para evitar se construya el objeto
	 */
	private CartaCompromisoPlantillaDef() {
		// Constructor de la clase, provado para evitar se construya el objeto
		throw new IllegalStateException("Utility class");
	}
	
}
