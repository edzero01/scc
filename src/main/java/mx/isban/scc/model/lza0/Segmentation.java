package mx.isban.scc.model.lza0;

import java.io.Serializable;

public class Segmentation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -635473384584550973L;

	private String segmentType;
	
	private String segmentValue;

	public String getSegmentType() {
		return segmentType;
	}

	public void setSegmentType(String segmentType) {
		this.segmentType = segmentType;
	}

	public String getSegmentValue() {
		return segmentValue;
	}

	public void setSegmentValue(String segmentValue) {
		this.segmentValue = segmentValue;
	}
}
