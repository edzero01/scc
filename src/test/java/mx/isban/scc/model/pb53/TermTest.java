package mx.isban.scc.model.pb53;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TermTest {

	Term dto = new Term();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setCount(5);
		dto.setTermUnits("TU123");

		assertEquals(5, dto.getCount());
		assertEquals("TU123", dto.getTermUnits());

	}

}
