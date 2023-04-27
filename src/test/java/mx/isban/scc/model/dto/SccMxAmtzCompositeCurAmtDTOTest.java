package mx.isban.scc.model.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SccMxAmtzCompositeCurAmtDTOTest {

	private SccMxAmtzCompositeCurAmtDTO dto = new SccMxAmtzCompositeCurAmtDTO();
	
	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {
		dto.setCompositeCurAmtType("tipo");
		dto.setCurAmt(null);


		assertEquals("tipo", dto.getCompositeCurAmtType());
		assertNull(dto.getCurAmt());

		
	}

}
