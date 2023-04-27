package mx.isban.scc.model.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SccMxAmtzAmortizationPeriodDataDTOTest {

	private SccMxAmtzAmortizationPeriodDataDTO dto = new SccMxAmtzAmortizationPeriodDataDTO();
	
	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {
		
		dto.setDueDt("17-12-95");
		dto.setCompositeCurAmt(null);
		dto.setInstalmentCurAmt(null);
		dto.setStmtRunningBal(null);
		dto.setTotalCurAmt(null);

		assertEquals("17-12-95", dto.getDueDt());
		assertNull(dto.getCompositeCurAmt());
		assertNull(dto.getInstalmentCurAmt());
		assertNull(dto.getStmtRunningBal());
		assertNull(dto.getTotalCurAmt());
		
	}

}
