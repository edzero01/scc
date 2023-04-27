package mx.isban.scc.model.lza0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EstatusAdicionalTest {

	EstatusAdicional dto = new EstatusAdicional();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setAddStatusCode("SC123");
		dto.setAddServerStatusCode("SSC123");
		dto.setAddSeverity("gravedad");
		dto.setAddStatusDesc("descripcion");

		assertEquals("SC123", dto.getAddStatusCode());
		assertEquals("SSC123", dto.getAddServerStatusCode());
		assertEquals("gravedad", dto.getAddSeverity());
		assertEquals("descripcion", dto.getAddStatusDesc());

	}

}
