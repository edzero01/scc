package mx.isban.scc.model.pb53;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AmortizationPeriodDatumTest {

	AmortizationPeriodDatum dto = new AmortizationPeriodDatum();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setDueDt("adeudo");
		dto.setInstalmentCurAmt(null);
		dto.setCompositeCurAmt(null);
		dto.setTotalCurAmt(null);
		dto.setStmtRunningBal(null);

		assertEquals("adeudo", dto.getDueDt());
		assertNull(dto.getInstalmentCurAmt());
		assertNull(dto.getCompositeCurAmt());
		assertNull(dto.getTotalCurAmt());
		assertNull(dto.getStmtRunningBal());

	}

}
