package mx.isban.scc.model.pb53;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TotalCurAmtTest {

	TotalCurAmt dto = new TotalCurAmt();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setAmt("AMT123");

		assertEquals("AMT123", dto.getAmt());

	}

}
