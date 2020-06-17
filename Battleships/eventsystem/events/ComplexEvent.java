package eventsystem.events;

import serialization.Serializable;
import serialization.exceptions.BytesNotMatchingException;

import java.nio.ByteBuffer;

public class ComplexEvent implements Event {
	
	private int[] data;
	private BasicEvent basicEvent;
	
	public ComplexEvent(int[] data, BasicEvent basicEvent) {
		this.data = data;
		this.basicEvent = basicEvent;
	}
	
	
	public int[] getData() {
		return this.data;
	}
	
	public BasicEvent getBasicEvent() {
		return this.basicEvent;
	}
	
	
	@Override
	public Event copy() {
		ComplexEvent e = new ComplexEvent(this.data, this.basicEvent); // not how it should be, but this is only for testing...
		return e;
	}
	
	@Override
	public byte[] serialize() {
		byte[] basicEventBytes = this.basicEvent.serialize();
		int len = basicEventBytes.length + this.data.length*4 + 8;
		
		ByteBuffer bbuf = ByteBuffer.allocate(len);
		
		bbuf.putInt(this.data.length);
		
		for(int i : this.data)
			bbuf.putInt(i);
		
		bbuf.putInt(basicEventBytes.length);
		bbuf.put(basicEventBytes);
		
		bbuf.rewind();
		return bbuf.array();
	}
	
	@Override
	public Serializable deserialize(byte[] bytes) throws BytesNotMatchingException {
		
		ByteBuffer bbuf = ByteBuffer.wrap(bytes);
		BasicEvent be;
		
		int a_len, be_len;
		
		int [] arr;
		byte[] be_arr;
		
		try {
			
			a_len = bbuf.getInt();
			arr   = new int[a_len];
			
			for(int i = 0; i < a_len; i++)
				arr[i] = bbuf.getInt();
			
			be_len = bbuf.getInt();
			be_arr = new byte[be_len];
			
			for(int i = 0; i < be_len; i++)
				be_arr[i] = bbuf.get();
			
			be = new BasicEvent(null, 0);
			be.deserialize(be_arr);
		
		} catch(IndexOutOfBoundsException e1) {
			throw new BytesNotMatchingException();
		} catch(BytesNotMatchingException e2) {
			throw new BytesNotMatchingException();
		}
		
		this.data = arr;
		this.basicEvent = be;
		
		return this;
	}
	
	
}