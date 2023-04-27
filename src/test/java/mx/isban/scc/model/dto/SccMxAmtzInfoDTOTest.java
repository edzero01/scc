package mx.isban.scc.model.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SccMxAmtzInfoDTOTest {

	private SccMxAmtzInfoDTO dto = new SccMxAmtzInfoDTO();
	
	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {
		dto.setInstalmentCount("48");
		dto.setAmortizationPeriodData(null);
		dto.setInstalmentCurAmt(null);
		dto.setIntRateData(null);
		dto.setTotalCurAmt(null);

		assertEquals("48", dto.getInstalmentCount());
		assertNull(dto.getAmortizationPeriodData());
		assertNull(dto.getInstalmentCurAmt());
		assertNull(dto.getIntRateData());
		assertNull(dto.getTotalCurAmt());
		
	}

}
