package mx.isban.scc.utilerias;
/**
 * Lista de valores mensuales para calculo
 * de prima devengada linex
 * @author Christopher Espina Riveros
 * 
 * Mayo 2019
 * Global Hitss
 */
public final class CalculoPrimaDef {


	/**
	 * Definicion primer mes
	 */
	public static final Double UNO = 0.92;
	/**
	 * definicion para segundo mes
	 */
	public static final Double DOS = 0.83;
	/**
	 * definicion para tercer mes
	 */
	public static final Double TRES = 0.75;
	/**
	 * definicion para cuarto mes
	 */
	public static final Double CUATRO = 0.67;
	/**
	 * definicion para quinto mes
	 */
	public static final Double CINCO = 0.58;
	/**
	 * definicion para sexto mes
	 */
	public static final Double SEIS = 0.50;
	/**
	 * definicion para septimo mes
	 */
	public static final Double SIETE = 0.42;
	/**
	 * definicion para octavo mes
	 */
	public static final Double OCHO = 0.33;
	/**
	 * definicion para noveno mes
	 */
	public static final Double NUEVE = 0.25;
	/**
	 * definicion para decimo mes
	 */
	public static final Double DIEZ = 0.17;
	/**
	 * definicion para onceavo mes
	 */
	public static final Double ONCE = 0.08;
	/**
	 * definicion para doceavo mes
	 */
	public static final Double DOCE = 0.00;
	
	/**
	 * Constructor de la clase, provado para evitar se construya el objeto
	 */
	private CalculoPrimaDef() {
		//Constructor de la clase, provado para evitar se construya el objeto
		throw new IllegalStateException("Utility class");
	}
}
