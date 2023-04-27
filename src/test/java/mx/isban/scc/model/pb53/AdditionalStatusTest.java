package mx.isban.scc.model.pb53;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdditionalStatusTest {

	AdditionalStatus dto = new AdditionalStatus();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setAddStatusCode("SC123");
		dto.setAddServerStatusCode("SSC123");
		dto.setAddSeverity("add gravedad");
		dto.setAddStatusDesc("descripcion");

		assertEquals("SC123", dto.getAddStatusCode());
		assertEquals("SSC123", dto.getAddServerStatusCode());
		assertEquals("add gravedad", dto.getAddSeverity());
		assertEquals("descripcion", dto.getAddStatusDesc());

	}

}
