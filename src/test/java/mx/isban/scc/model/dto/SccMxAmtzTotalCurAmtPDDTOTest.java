package mx.isban.scc.model.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SccMxAmtzTotalCurAmtPDDTOTest {

	private SccMxAmtzTotalCurAmtPDDTO dto = new SccMxAmtzTotalCurAmtPDDTO();
	
	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {
		dto.setAmt("13.02");

		assertEquals("13.02", dto.getAmt());
		
	}

}
