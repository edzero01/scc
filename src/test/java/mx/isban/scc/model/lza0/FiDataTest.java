package mx.isban.scc.model.lza0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FiDataTest {

	FiData dto = new FiData();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setBranchIdent("M123");
		dto.setFiIdent("FI123");

		assertEquals("M123", dto.getBranchIdent());
		assertEquals("FI123", dto.getFiIdent());

	}

}
