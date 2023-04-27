package mx.isban.scc.model.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SccMxAmtzIntRateDataDTOTest {

	private SccMxAmtzIntRateDataDTO dto = new SccMxAmtzIntRateDataDTO();
	
	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {
		dto.setRateMatrixTier(null);

		assertNull(dto.getRateMatrixTier());
		
	}

}
