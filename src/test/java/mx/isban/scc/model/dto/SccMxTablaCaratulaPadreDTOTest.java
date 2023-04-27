package mx.isban.scc.model.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SccMxTablaCaratulaPadreDTOTest {
	
	private SccMxTablaCaratulaPadreDTO dto = new SccMxTablaCaratulaPadreDTO();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {
		dto.setComisionDisposicionSinIva(3.0);
		dto.setSeguros(2.0);
		dto.setImporteNetoCredito(2325.25);
		dto.setNumeroPeriodosAnio(12);
		dto.setComisionPorDisposicion(12.0);
		dto.setComisionPorApertura(5.0);
		dto.setSegurosPorcentaje(7.5);
		
		assertEquals(3.0, dto.getComisionDisposicionSinIva());
		assertEquals(2.0, dto.getSeguros());
		assertEquals(2325.25, dto.getImporteNetoCredito());
		assertEquals(12, dto.getNumeroPeriodosAnio());
		assertEquals(12.0, dto.getComisionPorDisposicion());
		assertEquals(5.0, dto.getComisionPorApertura());
		assertEquals(7.5, dto.getSegurosPorcentaje());
		
	}

}
