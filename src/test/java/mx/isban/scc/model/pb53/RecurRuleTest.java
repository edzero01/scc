package mx.isban.scc.model.pb53;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecurRuleTest {

	RecurRule dto = new RecurRule();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setRecurType("RT123");
		dto.setDayOfMonth(3);

		assertEquals("RT123", dto.getRecurType());
		assertEquals(3, dto.getDayOfMonth());

	}

}
