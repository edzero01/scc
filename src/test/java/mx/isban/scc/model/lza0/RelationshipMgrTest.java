package mx.isban.scc.model.lza0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RelationshipMgrTest {

	RelationshipMgr dto = new RelationshipMgr();

	/**
	 * Test: Valida que los getters obtengan el valor asignado por los setters
	 */
	@Test
	void test() {

		dto.setRelationshipMgrIdent("RID123");
		dto.setRelationshipRole("ROL123");

		assertEquals("RID123", dto.getRelationshipMgrIdent());
		assertEquals("ROL123", dto.getRelationshipRole());

	}

}
