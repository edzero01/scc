package mx.isban.scc.model.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SccMxTablaMagisterioDTOTest {

	private SccMxTablaMagisterioDTO dto = new SccMxTablaMagisterioDTO();
	
	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {
		dto.setCaucion(0L);
		dto.setGracia("Gracia");
		dto.setPlan(3L);
		dto.setPlantilla("4");
		dto.setRecurrencia("Recurrencia");
		dto.setRqUID("RqUID");
		dto.setAmortizationRec(null);
		dto.setTablaCat(null);

		
		assertEquals(0L, dto.getCaucion());
		assertEquals("Gracia", dto.getGracia());
		assertEquals(3L, dto.getPlan());
		assertEquals("4", dto.getPlantilla());
		assertEquals("Recurrencia", dto.getRecurrencia());
		assertEquals("RqUID", dto.getRqUID());
		assertNull(dto.getTablaCat());
		assertNull(dto.getAmortizationRec());
		
	}

}
