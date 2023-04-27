package mx.isban.scc.model.lza0;

import java.io.Serializable;

public class AdditionalCursor implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2430856579558617932L;
	
	private String cursorValue;

	public String getCursorValue() {
		return cursorValue;
	}

	public void setCursorValue(String cursorValue) {
		this.cursorValue = cursorValue;
	}
}
