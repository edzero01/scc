package mx.isban.scc.model.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SccMxTablaCatDTOTest {

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {
		SccMxTablaCatDTO dto = new SccMxTablaCatDTO(1L, "Gracia", "Recurrencia", null, null, null);
		dto.setCaucion(5.0);
		dto.setGracia("Gracia2");
		dto.setPlan(2L);
		dto.setPlantilla(1L);
		dto.setRecurrencia("Recurrencia2");
		dto.setTablaCaratula(null);
		dto.setTablaCat(null);
		dto.setTablaRies(null);
		
		assertEquals(5.0, dto.getCaucion());
		assertEquals("Gracia2", dto.getGracia());
		assertEquals(2L, dto.getPlan());
		assertEquals(1L, dto.getPlantilla());
		assertEquals("Recurrencia2", dto.getRecurrencia());
		assertNull(dto.getTablaCaratula());
		assertNull(dto.getTablaCat());
		assertNull(dto.getTablaRies());
		
	}

}
