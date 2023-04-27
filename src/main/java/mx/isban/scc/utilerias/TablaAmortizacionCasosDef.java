package mx.isban.scc.utilerias;
/**
 * Lista de llaves con sus definiciones para Usuario
 * para determinar caso  de tablas de amortizacion
 * @author Christopher Espina Riveros
 * 
 * Mayo 2019
 * Global Hitss
 */
public final class TablaAmortizacionCasosDef {

	/**
	 * definicion para tabla frances prima unica con recurrencia
	 */
	public static final String PFPUCG = "11true";
	/**
	 * definicion para tabla frances prima unica con gracia
	 */
	public static final String PFPUSG = "11false";
	/**
	 * definicion para tabla frances prima unica sin gracia
	 */
	public static final String PFPRCG = "12true";
	/**
	 * definicion para tabla frances prima reccurente con gracia
	 */
	public static final String PFPRSG = "12false";
	/**
	 * definicion para tabla frances prima unica sin gracia
	 */
	public static final String PFSSCG = "13true";
	/**
	 * definicion para tabla frances prima reccurente con gracia
	 */
	public static final String PFSSSG = "13false";
	/**
	 * definicion para tabla aleman prima unica con gracia
	 */
	public static final String PAPUCG = "21true";
	/**
	 * definicion para tabla aleman prima unica sin gracia
	 */
	public static final String PAPUSG = "21false";
	/**
	 * definicion para tabla aleman prima recurrente con gracia
	 */
	public static final String PAPRCG = "22true";
	/**
	 * definicion para tabla aleman prima recurrente sin gracia
	 */
	public static final String PAPRSG = "22false";
	/**
	 * definicion para tabla aleman prima unica con gracia psg
	 */
	public static final String PSGPAPUCG = "23true";
	/**
	 * definicion para tabla aleman prima unica sin gracia psg
	 */
	public static final String PSGPAPUSG = "23false";

	/**
	 * Constructor de la clase, privado para evitar se construya el objeto
	 */
	private TablaAmortizacionCasosDef() {
		//Constructor de la clase, provado para evitar se construya el objeto
		throw new IllegalStateException("Utility class");
	}

}