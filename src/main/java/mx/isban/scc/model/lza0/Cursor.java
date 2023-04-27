package mx.isban.scc.model.lza0;

import java.io.Serializable;
import java.util.List;

public class Cursor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1510992629718681167L;

	private String cursorValue;
	
    private List<AdditionalCursor> additionalCursor;

	public String getCursorValue() {
		return cursorValue;
	}

	public void setCursorValue(String cursorValue) {
		this.cursorValue = cursorValue;
	}

	public List<AdditionalCursor> getAdditionalCursor() {
		return additionalCursor;
	}

	public void setAdditionalCursor(List<AdditionalCursor> additionalCursor) {
		this.additionalCursor = additionalCursor;
	}
}
