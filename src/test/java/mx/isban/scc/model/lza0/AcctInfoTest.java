package mx.isban.scc.model.lza0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AcctInfoTest {

	AcctInfo dto = new AcctInfo();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setAcctPackageData(null);
		dto.setComments("comentarios");
		dto.setOwnership("propiedad");
		dto.setAcctType("tipo de cuenta");
		dto.setBban("bban");
		dto.setSalesChannelCode("C0123");
		dto.setFiData(null);
		dto.setRelationshipMgr(null);
		dto.setCurCode(null);
		dto.setPartyKeys(null);
		dto.setSegmentation(null);
		dto.setProductIdent("producto 1");
		dto.setSubProductIdent("subproducto 2");
		dto.setClabe("A123");
		dto.setAcctBal(null);
		dto.setPartyAcctRelData(null);

		assertNull(dto.getAcctPackageData());
		assertEquals("comentarios", dto.getComments());
		assertEquals("propiedad", dto.getOwnership());
		assertEquals("tipo de cuenta", dto.getAcctType());
		assertEquals("bban", dto.getBban());
		assertEquals("C0123", dto.getSalesChannelCode());
		assertNull(dto.getFiData());
		assertNull(dto.getRelationshipMgr());
		assertNull(dto.getCurCode());
		assertNull(dto.getPartyKeys());
		assertNull(dto.getSegmentation());
		assertEquals("producto 1", dto.getProductIdent());
		assertEquals("subproducto 2", dto.getSubProductIdent());
		assertEquals("A123", dto.getClabe());
		assertNull(dto.getAcctBal());
		assertNull(dto.getPartyAcctRelData());

	}

}
