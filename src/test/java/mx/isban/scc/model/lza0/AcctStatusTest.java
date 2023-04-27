package mx.isban.scc.model.lza0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AcctStatusTest {

	AcctStatus dto = new AcctStatus();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {
		
		
		dto.setAcctStatusCode("ASC123");
		dto.setBlockedInd(true);
		
		
		assertEquals("ASC123", dto.getAcctStatusCode());
		
		
		
		
		
		
	}

}
