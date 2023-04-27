package mx.isban.scc.model.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SccMxTablaRiesPadreDTOTest {
	
	private SccMxTablaRiesPadreDTO dto = new SccMxTablaRiesPadreDTO();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {
		dto.setComisionDisposicionSinIva(3.0);
		dto.setNumeroPeriodosAnio(12);
		dto.setComisionPorApertura(5.0);
		dto.setSegurosPorcentaje(7.5);
		dto.setMontoPagar(5000.0);
		dto.setComisionPorDisposicion(5.0);
		
		assertEquals(3.0, dto.getComisionDisposicionSinIva());
		assertEquals(12, dto.getNumeroPeriodosAnio());
		assertEquals(5.0, dto.getComisionPorApertura());
		assertEquals(7.5, dto.getSegurosPorcentaje());
		assertEquals(5000.0, dto.getMontoPagar());
		assertEquals(5.0, dto.getComisionPorDisposicion());
	}

}
