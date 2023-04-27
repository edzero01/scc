package mx.isban.scc.model.lza0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AcctPackageDataTest {

	AcctPackageData dto = new AcctPackageData();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setProductIdent("producto 1");
		dto.setSubProductIdent("subproducto 2");

		assertEquals("producto 1", dto.getProductIdent());
		assertEquals("subproducto 2", dto.getSubProductIdent());

	}

}
