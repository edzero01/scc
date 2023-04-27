package mx.isban.scc.model.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SccMxTablaCaratulaDTOTest {

	private SccMxTablaCaratulaDTO dto = new SccMxTablaCaratulaDTO();
	
	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {
		dto.setNumeroPagosSinSkip(12);
		dto.setPlazoMesesSinSkip(12);
		dto.setFactorSeguro(7.0);
		dto.setDescPeriodo("Descripcion");
		dto.setAperturaL("Apertura");
		dto.setPagoTardio(500.0);
		dto.setSeguro("Seguro");
		dto.setAseguradora("Aseguradora");
		dto.setClausula("Clausula");
		dto.setTardioL("Tardio");
		
		assertEquals(12, dto.getNumeroPagosSinSkip());
		assertEquals(12, dto.getPlazoMesesSinSkip());
		assertEquals(7.0, dto.getFactorSeguro());
		assertEquals("Descripcion", dto.getDescPeriodo());
		assertEquals("Apertura", dto.getAperturaL());
		assertEquals(500.0, dto.getPagoTardio());
		assertEquals("Seguro", dto.getSeguro());
		assertEquals("Aseguradora", dto.getAseguradora());
		assertEquals("Clausula", dto.getClausula());
		assertEquals("Tardio", dto.getTardioL());
	}

}
