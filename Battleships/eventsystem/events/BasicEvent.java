package eventsystem.events;

import serialization.Serializable;
import serialization.exceptions.BytesNotMatchingException;

import java.nio.ByteBuffer;

/**
* This is a Basic Event. Mostly designed for demonstration purposed. This Event will not be called in the final Version of the Program.
* 
* @author Cedric Wellhausen
* @version June 12 2020
*/
public class BasicEvent implements Event {
	
	private String text;
	private int number;
	
	/**
	* Constructs Basic Event with some text and a number.
	* @param text Some text
	* @param number A number
	*/
	public BasicEvent(String text, int number) {
		super();
		this.text   = text;
		this.number = number;
	}
	
	
	public String getText() {
		return this.text;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	@Override
	public Event copy() {
		BasicEvent e = new BasicEvent(this.getText(), this.getNumber());
		return e;
	}
	
	@Override
	public byte[] serialize() {
		int        len  = this.getText().length()*2 + 8;
		ByteBuffer bbuf = ByteBuffer.allocate(len);
		bbuf.rewind();
		
		bbuf.putInt(this.getText().length());
		
		for(char c : this.getText().toCharArray())
			bbuf.putChar(c);
		
		bbuf.putInt(this.getNumber());
		
		bbuf.rewind();
		return bbuf.array();
	}
	
	@Override
	public Serializable deserialize(byte[] bytes) throws BytesNotMatchingException {
		ByteBuffer bbuf = ByteBuffer.wrap(bytes);
		bbuf.rewind();
		
		int s_len, num;
		StringBuilder sb = new StringBuilder();
		
		try {
			s_len = bbuf.getInt();
		
			for(int i = 0; i < s_len; i++)
				sb.append(bbuf.getChar());
			
			num = bbuf.getInt();
			
		} catch(IndexOutOfBoundsException e) {
			throw new BytesNotMatchingException();
		}
	
		this.number = num;
		this.text   = sb.toString();
		
		return this;
	}
	
}