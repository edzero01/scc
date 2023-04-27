package mx.isban.scc.model.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SccMxAmtzRateMatrixTierDTOTest {

	private SccMxAmtzRateMatrixTierDTO dto = new SccMxAmtzRateMatrixTierDTO();
	
	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {
		dto.setIntAPR("12.88");

		assertEquals("12.88", dto.getIntAPR());
		
	}

}
