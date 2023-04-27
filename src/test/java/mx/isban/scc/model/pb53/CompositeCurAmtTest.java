package mx.isban.scc.model.pb53;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CompositeCurAmtTest {

	CompositeCurAmt dto = new CompositeCurAmt();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setCompositeCurAmtType("CAT123");
		dto.setCurAmt(null);

		assertEquals("CAT123", dto.getCompositeCurAmtType());
		assertNull(dto.getCurAmt());

	}

}
