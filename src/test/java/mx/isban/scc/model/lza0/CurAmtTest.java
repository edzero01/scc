package mx.isban.scc.model.lza0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CurAmtTest {

	CurAmt dto = new CurAmt();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setAmt(5);
		dto.setCurCode(null);

		assertEquals(5, dto.getAmt());
		assertNull(dto.getCurCode());

	}

}
