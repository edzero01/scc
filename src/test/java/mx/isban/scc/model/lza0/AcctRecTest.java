package mx.isban.scc.model.lza0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AcctRecTest {

	AcctRec dto = new AcctRec();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setAcctId("A123");
		dto.setAcctInfo(null);
		dto.setAcctStatus(null);

		assertEquals("A123", dto.getAcctId());
		assertNull(dto.getAcctInfo());
		assertNull(dto.getAcctStatus());

	}

}
