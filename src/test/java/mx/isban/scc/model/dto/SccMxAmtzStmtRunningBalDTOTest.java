package mx.isban.scc.model.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SccMxAmtzStmtRunningBalDTOTest {

	private SccMxAmtzStmtRunningBalDTO dto = new SccMxAmtzStmtRunningBalDTO();
	
	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {
		dto.setAmt("13.03");

		assertEquals("13.03", dto.getAmt());
		
	}

}
