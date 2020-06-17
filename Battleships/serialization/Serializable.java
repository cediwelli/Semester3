package serialization;

import serialization.exceptions.BytesNotMatchingException;

/**
* This interface defines the serialization Methods. Everything that needs to be send at some point in time over the network has to implement
* this class for it to work. As well as every Object inside an object that is serializable needs to be serializable too.
* @author Cedric Wellhausen
* @version June 12 2020
*/
public interface Serializable {
	
	/**
	* Serialize the Object as a byte Array. This Method may return different outputs for different usecases. I encourage the user to look up the
	* documentation of the implementation. It is the implementers duty and responsibility to document any differences. The implementer doesn't need to document
	* their method if no differences occur.
	* @return The bytes of the serialized Object. May return different outputs for different usecases.
	*/
	public byte[] serialize();
	
	/**
	* Deserialize a byte Array that was serialized by the corresponing serializer. May return null. Please check the implementations Documentation for more info.
	* @param bytes The bytes from the output of the Serializer.
	* @return A refrence to itself but it is now a copy of the once serialized object that was passed as parameter.
	* @throws May throw a BytesNotMatchingException if the given byte-Array does not match in size.
	*/
	public Serializable deserialize(byte[] bytes) throws BytesNotMatchingException;
	
}