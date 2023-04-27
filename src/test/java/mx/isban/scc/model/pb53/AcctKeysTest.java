package mx.isban.scc.model.pb53;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AcctKeysTest {

	AcctKeys dto = new AcctKeys();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setProductIdent("producto 1");
		dto.setSubProductIdent("subproducto 2");
		dto.setCurCode(null);

		assertEquals("producto 1", dto.getProductIdent());
		assertEquals("subproducto 2", dto.getSubProductIdent());
		assertNull(dto.getCurCode());

	}

}
