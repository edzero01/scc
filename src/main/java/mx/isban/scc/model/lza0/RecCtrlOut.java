package mx.isban.scc.model.lza0;

import java.io.Serializable;

public class RecCtrlOut implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5662322498944627411L;

	private boolean subseqRec;
	
    private Cursor cursor;

	public boolean isSubseqRec() {
		return subseqRec;
	}

	public void setSubseqRec(boolean subseqRec) {
		this.subseqRec = subseqRec;
	}

	public Cursor getCursor() {
		return cursor;
	}

	public void setCursor(Cursor cursor) {
		this.cursor = cursor;
	}
}
