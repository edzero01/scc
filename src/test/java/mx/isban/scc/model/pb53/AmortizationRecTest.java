package mx.isban.scc.model.pb53;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AmortizationRecTest {

	AmortizationRec dto = new AmortizationRec();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setAmortizationInfo(null);

		assertNull(dto.getAmortizationInfo());

	}

}
