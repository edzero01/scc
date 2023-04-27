package mx.isban.scc.model.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SccMxTablaCaratulaValorDTOTest {

	private SccMxTablaCaratulaValorDTO dto = new SccMxTablaCaratulaValorDTO();
	
	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {
		dto.setSaldoDeCapital(5000.0);
		dto.setPagoAnticipado(200.0);
		dto.setCuota(500.0);
		dto.setFlujos(200.0);
		dto.setSeguros(20.0);
		
		assertEquals(5000.0, dto.getSaldoDeCapital());
		assertEquals(200.0, dto.getPagoAnticipado());
		assertEquals(500.0, dto.getCuota());
		assertEquals(200.0, dto.getFlujos());
		assertEquals(20.0, dto.getSeguros());
	}

}
