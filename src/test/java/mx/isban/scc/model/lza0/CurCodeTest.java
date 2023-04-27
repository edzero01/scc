package mx.isban.scc.model.lza0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CurCodeTest {

	CurCode dto = new CurCode();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setCurCodeType("CCT123");
		dto.setCurCodeValue("CCV123");

		assertEquals("CCT123", dto.getCurCodeType());
		assertEquals("CCV123", dto.getCurCodeValue());

	}

}
