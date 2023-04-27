package mx.isban.scc.model.lza0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PartyKeysTest {

	PartyKeys dto = new PartyKeys();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setPartyId("PK123");

		assertEquals("PK123", dto.getPartyId());

	}

}
