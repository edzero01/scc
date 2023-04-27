package mx.isban.scc.model.pb53;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AmortizationSelTest {

	AmortizationSel dto = new AmortizationSel();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setRequestDt("solicitud");
		dto.setAcctKeys(null);
		dto.setTotalCurAmt(null);
		dto.setTerm(null);
		dto.setRecurRule(null);
		dto.setReviewFrequency(null);
		dto.setRateMatrixTier(null);

		assertEquals("solicitud", dto.getRequestDt());
		assertNull(dto.getAcctKeys());
		assertNull(dto.getTotalCurAmt());
		assertNull(dto.getTerm());
		assertNull(dto.getRecurRule());
		assertNull(dto.getReviewFrequency());
		assertNull(dto.getRateMatrixTier());

	}

}
