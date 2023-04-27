package mx.isban.scc.model.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SccMxTablaRiesValorPadreDTOTest {

	private SccMxTablaRiesValorPadreDTO dto = new SccMxTablaRiesValorPadreDTO();
	
	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {
		dto.setCapital(200.0);
		dto.setIntereses(70.0);
		dto.setIvaDeIntereses(16.0);
		dto.setNumeroPagos(24);
		dto.setPagoFijo(500.0);
		dto.setPagoTotal(800.0);
		
		assertEquals(200.0, dto.getCapital());
		assertEquals(70.0, dto.getIntereses());
		assertEquals(16.0, dto.getIvaDeIntereses());
		assertEquals(24, dto.getNumeroPagos());
		assertEquals(500.0, dto.getPagoFijo());
		assertEquals(800.0, dto.getPagoTotal());
	}

}
