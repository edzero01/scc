package mx.isban.scc.utilerias;

/**
 * Lista de Períodos con sus definiciones para Usuario
 * 
 *  * 
 * 
 * Simulador de Credito al Consumo
 * Global Hitss
 * Mayo 2019
 * 
 *
 * 
 * 
 * @author GlobalHitss
 * 
 */

public final class PeriodosDef {
	/**
	 *  Constante, con un solo espacio de memoria e inmutable para comparaciones en semanal
	 */
	public static final String SEMANAL = "S";
	/**
	 *  Constante , con un solo espacio de memoria e inmutable para comparaciones en catorcenal
	 */
	public static final String CATORCENAL = "C";
	/**
	 *  Constante, con un solo espacio de memoria e inmutable para comparaciones en quincenal
	 */
	public static final String QUINCENAL = "Q";
	/**
	 *  Constante, con un solo espacio de memoria e inmutable para comparaciones en mensual
	 */
	public static final String MENSUAL = "M";
	
	
	/**
	 *  Constante, con un solo espacio de memoria e inmutable para comparaciones en valores de periodo mensual en valor entero
	 */
	public static final int MENSUAL_VALUE = 1;

	/**
	 * Constructor de la clase, provado para evitar se construya el objeto
	 */
	private PeriodosDef() {
	}
	
}
