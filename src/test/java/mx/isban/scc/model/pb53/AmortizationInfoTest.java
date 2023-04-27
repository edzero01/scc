package mx.isban.scc.model.pb53;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AmortizationInfoTest {

	AmortizationInfo dto = new AmortizationInfo();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setInstalmentCount(5);
		dto.setInstalmentCurAmt(null);
		dto.setTotalCurAmt(null);
		dto.setAmortizationPeriodData(null);
		dto.setIntRateData(null);

		assertEquals(5, dto.getInstalmentCount());
		assertNull(dto.getInstalmentCurAmt());
		assertNull(dto.getTotalCurAmt());
		assertNull(dto.getAmortizationPeriodData());
		assertNull(dto.getIntRateData());

	}

}
