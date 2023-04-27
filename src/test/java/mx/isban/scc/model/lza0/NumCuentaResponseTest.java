package mx.isban.scc.model.lza0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumCuentaResponseTest {

	NumCuentaResponse dto = new NumCuentaResponse();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setRqUID("RQID123");
		dto.setStatus(null);
		dto.setAcctRec(null);
		dto.setRecCtrlOut(null);

		assertEquals("RQID123", dto.getRqUID());
		assertNull(dto.getStatus());
		assertNull(dto.getAcctRec());
		assertNull(dto.getRecCtrlOut());

	}

}
