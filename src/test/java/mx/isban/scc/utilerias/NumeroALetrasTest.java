package mx.isban.scc.utilerias;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class NumeroALetrasTest {
	
	private NumeroALetras conversor = new NumeroALetras();
	
	@Test
	void convertirNumeroInvalido() {
		String result = conversor.convertir("1328.132", "", "", "", "", "", false);
		assertEquals(null, result);
	}
	
	@Test
	void convertirEnteroSinDecimal() {
		String result = conversor.convertir("45", "", "", "", "", "", false);
		assertEquals("cuarenta y cinco", result);
	}
	
	@Test
	void convertirEnteroConDosDecimales() {
		String result = conversor.convertir("1100128322.29", "", "", "", "", "punto", false);
		assertEquals("un billon  cien millones ciento veintiocho mil trescientos veintidos punto veintinueve", result);
	}
	
	@Test
	void convertirEnteroConUnDecimal() {
		String result = conversor.convertir("3923.5", "", "", "", "", "punto", false);
		assertEquals("tres mil novecientos veintitres punto cincuenta", result);
	}
	
	@Test
	void convetirEnteroSinDecimalConEtiquetas() {
		String result = conversor.convertir("100.15", "peso", "pesos", "centavo", "centavos", "con", false);
		assertEquals("cien pesos con quince centavos", result);
	}
	
	@Test
	void convertirEnteroConDecimalConEtiquetas() {
		String result = conversor.convertir("1.24", "peso", "pesos", "centavo", "centavos", "con", false);
		assertEquals("un peso con veinticuatro centavos", result); 
	}
	
	@Test
	void convertirEnteroConDecimalMayusculas() {
		String result = conversor.convertir("1200325.01", "peso", "pesos", "centavo", "centavos", "con", true);
		assertEquals("UN MILLON DOSCIENTOS MIL TRESCIENTOS VEINTICINCO PESOS CON UN CENTAVO", result);
	}
	
	@Test
	void convertirBillon() {
		String result = conversor.convertir("3900010326.01", "peso", "pesos", "centavo", "centavos", "con", true);
		assertEquals("TRES BILLONES NOVECIENTOS MILLONES DIEZ MIL TRESCIENTOS VEINTISEIS PESOS CON UN CENTAVO", result);
	}
	
	@Test
	void convertirMillon() {
		String result = conversor.convertir("1001332.27", "peso", "pesos", "centavo", "centavos", "con", false);
		assertEquals("un millon un mil trescientos treinta y dos pesos con veintisiete centavos", result);
	}
	
	@Test
	void convertirCero() {
		String result = conversor.convertir("0.27", "peso", "pesos", "centavo", "centavos", "con", true);
		assertEquals("CERO PESOS CON VEINTISIETE CENTAVOS", result);
	}
}
