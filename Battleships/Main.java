import eventsystem.EventHandler;
import eventsystem.EventManager;
import eventsystem.Listener;

import eventsystem.events.BasicEvent;
import eventsystem.events.ComplexEvent;

import network.Server;

import java.io.DataOutputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;

import java.nio.ByteBuffer;

import java.net.Socket;
import java.net.InetAddress;

import serialization.exceptions.BytesNotMatchingException;

import java.util.Arrays;

public class Main {

	public static Server server;

	public static void main(String[] args) throws BytesNotMatchingException {
		
		server = new Server(25565);
		
		
		
		try {
			
			while(true) {
				
				Socket s = new Socket(InetAddress.getByName("localhost"), 25565);
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				
				Thread.sleep(1000);
				
				dos.writeInt(4);
				
				for(int i = 0; i < 12; i++) {
					char c = (char)('a' + i);
					dos.writeChar(c);
				}
				
				dos.write(0x04);
				dos.flush();
				s.close();
			}
			
			
		} catch(Exception e) {
			System.exit(-1);
			return;
		}
		
		
		
		
	}
	
}