package mx.isban.scc.model.pb53;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StmtRunningBalTest {

	StmtRunningBal dto = new StmtRunningBal();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setAmt(5);

		assertEquals(5, dto.getAmt());

	}

}
