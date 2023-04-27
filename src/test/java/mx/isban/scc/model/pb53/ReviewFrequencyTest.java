package mx.isban.scc.model.pb53;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReviewFrequencyTest {

	ReviewFrequency dto = new ReviewFrequency();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setRecurTypeCode("RTC123");

		assertEquals("RTC123", dto.getRecurTypeCode());

	}

}
