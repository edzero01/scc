/**
 * 
 */
package mx.isban.scc.exception;

import java.io.Serializable;

/**
 * THis exception is fired by a service unable to find an object
 * 
 * 
 */
public class ObjectNotFoundException extends RuntimeException implements Serializable {

	/**
	 * The serialization id.
	 */
	private static final long serialVersionUID = 3108253212779061633L;

	public ObjectNotFoundException() {
	}

	/**
	 * Construct the exception using a message
	 * 
	 * @param pMessage the message
	 */
	public ObjectNotFoundException(String pMessage) {
		super(pMessage);
	}
}
