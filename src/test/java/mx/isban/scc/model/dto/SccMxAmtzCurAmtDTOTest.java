package mx.isban.scc.model.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SccMxAmtzCurAmtDTOTest {

	private SccMxAmtzCurAmtDTO dto = new SccMxAmtzCurAmtDTO();
	
	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {
		dto.setAmt("14.01");

		assertEquals("14.01", dto.getAmt());
		
	}

}
