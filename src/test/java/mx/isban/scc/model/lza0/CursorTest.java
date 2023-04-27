package mx.isban.scc.model.lza0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CursorTest {

	Cursor dto = new Cursor();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setCursorValue("CV123");
		dto.setAdditionalCursor(null);

		assertEquals("CV123", dto.getCursorValue());
		assertNull( dto.getAdditionalCursor());

	}

}
