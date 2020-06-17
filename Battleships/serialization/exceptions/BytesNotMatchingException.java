package serialization.exceptions;

/**
* This Exception is thrown when an error occures while deserialization of an byte-Array.
* @author Cedric Wellhausen
* @version June 12 2020
*/
public class BytesNotMatchingException extends Exception {
	public BytesNotMatchingException() {
		super("Bytes do not Match as expected!");
	}
}