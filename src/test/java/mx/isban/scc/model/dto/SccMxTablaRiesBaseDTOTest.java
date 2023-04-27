package mx.isban.scc.model.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SccMxTablaRiesBaseDTOTest {

	SccMxTablaRiesBaseDTO dto = new SccMxTablaRiesBaseDTO();
	
	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {
		dto.setPeriodicidadCodigo("2");
		dto.setTasaInteresPeriodo(5.0);
		
		assertEquals("2", dto.getPeriodicidadCodigo());
		assertEquals(5.0, dto.getTasaInteresPeriodo());
	}

}
