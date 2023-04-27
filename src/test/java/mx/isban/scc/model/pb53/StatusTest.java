package mx.isban.scc.model.pb53;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StatusTest {

	Status dto = new Status();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setStatusCode(123L);
		dto.setServerStatusCode("SSC123");
		dto.setSeverity("gravedad");
		dto.setStatusDesc("descripcion");
		dto.setAdditionalStatus(null);

		assertEquals(123L, dto.getStatusCode());
		assertEquals("SSC123", dto.getServerStatusCode());
		assertEquals("gravedad", dto.getSeverity());
		assertEquals("descripcion", dto.getStatusDesc());
		assertNull(dto.getAdditionalStatus());

	}

}
