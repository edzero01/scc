package mx.isban.scc.model.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SccMxAmtzCatMagisterioDTOTest {

	private SccMxAmtzCatMagisterioDTO dto = new SccMxAmtzCatMagisterioDTO();
	
	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {
		dto.setCat(1.0);
		dto.setCodigoCliente(12345L);
		dto.setComisionPorApertura(2.0);
		dto.setComisionPorDisposicion(3.0);
		dto.setDescPeriodo("Periodo");
		dto.setImporteNetoCredito(4567.89);
		dto.setNombreCliente("Nombre");
		dto.setNumeroPagos(10L);
		dto.setPlazo(11L);
		dto.setProducto("Producto");
		dto.setSeguros("Seguros");
		dto.setTasaInteresAnual(4.0);
		
		assertEquals(1.0, dto.getCat());
		assertEquals(12345, dto.getCodigoCliente());
		assertEquals(2.0, dto.getComisionPorApertura());
		assertEquals(3.0, dto.getComisionPorDisposicion());
		assertEquals("Periodo", dto.getDescPeriodo());
		assertEquals(4567.89, dto.getImporteNetoCredito());
		assertEquals("Nombre", dto.getNombreCliente());
		assertEquals(10, dto.getNumeroPagos());
		assertEquals(11, dto.getPlazo());
		assertEquals("Producto", dto.getProducto());
		assertEquals("Seguros", dto.getSeguros());
		assertEquals(4.0, dto.getTasaInteresAnual());
		
		
	}

}
