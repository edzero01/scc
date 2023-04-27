package mx.isban.scc.model.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SccMxTablaCaratulaBaseDTOTest {

	SccMxTablaCaratulaBaseDTO dto = new SccMxTablaCaratulaBaseDTO();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {
		dto.setNombreCliente("Nombre");
		dto.setCodigoCliente(123456);
		dto.setPeriodicidadCodigo("2");
		dto.setTasaInteresPeriodo(5.0);
		dto.setNumeroPagos(12);
		
		assertEquals("Nombre", dto.getNombreCliente());
		assertEquals(123456, dto.getCodigoCliente());
		assertEquals("2", dto.getPeriodicidadCodigo());
		assertEquals(5.0, dto.getTasaInteresPeriodo());
		assertEquals(12, dto.getNumeroPagos());
	}

}
