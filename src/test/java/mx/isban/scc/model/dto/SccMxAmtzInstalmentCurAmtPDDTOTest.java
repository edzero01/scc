package mx.isban.scc.model.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SccMxAmtzInstalmentCurAmtPDDTOTest {

	private SccMxAmtzInstalmentCurAmtPDDTO dto = new SccMxAmtzInstalmentCurAmtPDDTO();
	
	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {
		dto.setAmt("13.01");

		assertEquals("13.01", dto.getAmt());
		
	}

}
