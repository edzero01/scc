package mx.isban.scc.model.lza0;

import java.io.Serializable;

public class CurCode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5049892614270084651L;

	private String curCodeValue;
	
	private String curCodeType;

	public String getCurCodeValue() {
		return curCodeValue;
	}

	public void setCurCodeValue(String curCodeValue) {
		this.curCodeValue = curCodeValue;
	}

	public String getCurCodeType() {
		return curCodeType;
	}

	public void setCurCodeType(String curCodeType) {
		this.curCodeType = curCodeType;
	}
}
