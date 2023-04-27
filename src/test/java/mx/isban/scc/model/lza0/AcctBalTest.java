package mx.isban.scc.model.lza0;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class AcctBalTest {

	AcctBal dto = new AcctBal();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {
		
		dto.setCurAmt(null);
		dto.setLastOcurranceDt(new Date(2022-10-14));
		dto.setBalType(null);
		
		assertNull(dto.getCurAmt());
		assertEquals(new Date(2022-10-14), dto.getLastOcurranceDt());
		assertNull(dto.getBalType());
		
	}

}
