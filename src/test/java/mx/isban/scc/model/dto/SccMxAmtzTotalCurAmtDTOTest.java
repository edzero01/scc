package mx.isban.scc.model.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SccMxAmtzTotalCurAmtDTOTest {

	private SccMxAmtzTotalCurAmtDTO dto = new SccMxAmtzTotalCurAmtDTO();
	
	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {
		dto.setAmt("12.86");

		assertEquals("12.86", dto.getAmt());
		
	}

}
