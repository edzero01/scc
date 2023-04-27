package mx.isban.scc.model.pb53;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntRateDataTest {

	IntRateData dto = new IntRateData();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setRateMatrixTier(null);

		assertNull(dto.getRateMatrixTier());

	}

}
