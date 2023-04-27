package mx.isban.scc.model.lza0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdditionalCursorTest {

	AdditionalCursor dto = new AdditionalCursor();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setCursorValue("CV123");

		assertEquals("CV123", dto.getCursorValue());

	}

}
