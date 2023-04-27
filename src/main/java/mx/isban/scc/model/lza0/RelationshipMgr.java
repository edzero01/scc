package mx.isban.scc.model.lza0;

import java.io.Serializable;

public class RelationshipMgr implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8342541812155664903L;

	private String relationshipMgrIdent;
	
    private String relationshipRole;

	public String getRelationshipMgrIdent() {
		return relationshipMgrIdent;
	}

	public void setRelationshipMgrIdent(String relationshipMgrIdent) {
		this.relationshipMgrIdent = relationshipMgrIdent;
	}

	public String getRelationshipRole() {
		return relationshipRole;
	}

	public void setRelationshipRole(String relationshipRole) {
		this.relationshipRole = relationshipRole;
	}
}
