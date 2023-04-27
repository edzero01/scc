package mx.isban.scc.model.lza0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BalTypeTest {

	BalType dto = new BalType();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setBalTypeValues("BT123");

		assertEquals("BT123", dto.getBalTypeValues());

	}

}
