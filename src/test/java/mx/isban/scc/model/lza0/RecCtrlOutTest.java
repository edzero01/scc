package mx.isban.scc.model.lza0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecCtrlOutTest {

	RecCtrlOut dto = new RecCtrlOut();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setCursor(null);
		dto.setSubseqRec(true);

		assertNull(dto.getCursor());

	}

}
