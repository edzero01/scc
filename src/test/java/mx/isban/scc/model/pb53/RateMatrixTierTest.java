package mx.isban.scc.model.pb53;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RateMatrixTierTest {

	RateMatrixTier dto = new RateMatrixTier();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setRate("R12345");
		dto.setTier("T12345");
		dto.setIntAPR("APR123");

		assertEquals("R12345", dto.getRate());
		assertEquals("T12345", dto.getTier());
		assertEquals("APR123", dto.getIntAPR());

	}

}
