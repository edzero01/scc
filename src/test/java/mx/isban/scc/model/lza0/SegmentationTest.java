package mx.isban.scc.model.lza0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SegmentationTest {

	Segmentation dto = new Segmentation();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setSegmentType("ST123");
		dto.setSegmentValue("SV123");

		assertEquals("ST123", dto.getSegmentType());
		assertEquals("SV123", dto.getSegmentValue());

	}

}
