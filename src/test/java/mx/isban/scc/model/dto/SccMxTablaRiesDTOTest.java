package mx.isban.scc.model.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SccMxTablaRiesDTOTest {
	
	private SccMxTablaRiesDTO dto = new SccMxTablaRiesDTO();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {
		dto.setNumeroPagosSinSkip(12);
		dto.setPlazoMesesSinSkip(12);
		dto.setFactorSeguro(7.0);
		dto.setTipoOferta(2);
		dto.setDescPeriodo("Descripcion");
		dto.setProducto("Producto");
		
		assertEquals(12, dto.getNumeroPagosSinSkip());
		assertEquals(12, dto.getPlazoMesesSinSkip());
		assertEquals(7.0, dto.getFactorSeguro());
		assertEquals(2, dto.getTipoOferta());
		assertEquals("Descripcion", dto.getDescPeriodo());
		assertEquals("Producto", dto.getProducto());		
	}

}
