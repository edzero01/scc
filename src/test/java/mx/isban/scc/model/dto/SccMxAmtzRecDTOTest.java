package mx.isban.scc.model.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SccMxAmtzRecDTOTest {

	private SccMxAmtzRecDTO dto = new SccMxAmtzRecDTO();
	
	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {
		dto.setAmortizationInfo(null);

		assertNull(dto.getAmortizationInfo());
		
	}

}
