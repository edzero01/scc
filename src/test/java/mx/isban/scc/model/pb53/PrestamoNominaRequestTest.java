package mx.isban.scc.model.pb53;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrestamoNominaRequestTest {

	PrestamoNominaRequest dto = new PrestamoNominaRequest();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setRqUID("RQID123");
		dto.setAmortizationSel(null);

		assertEquals("RQID123", dto.getRqUID());
		assertNull(dto.getAmortizationSel());

	}

}
