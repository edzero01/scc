package mx.isban.scc.model.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SccMxAmtzInstalmentCurAmtDTOTest {

	private SccMxAmtzInstalmentCurAmtDTO dto = new SccMxAmtzInstalmentCurAmtDTO();
	
	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {
		dto.setAmt("12.85");

		assertEquals("12.85", dto.getAmt());
		
	}

}
