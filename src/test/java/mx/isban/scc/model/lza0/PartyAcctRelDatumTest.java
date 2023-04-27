package mx.isban.scc.model.lza0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PartyAcctRelDatumTest {

	PartyAcctRelDatum dto = new PartyAcctRelDatum();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setPartyAcctRelType("PA123");

		assertEquals("PA123", dto.getPartyAcctRelType());

	}

}
