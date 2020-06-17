package network.threads;

import java.net.ServerSocket;
import java.net.Socket;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.IOException;

import java.nio.ByteBuffer;
import java.nio.BufferUnderflowException;

import network.Player;
import network.Server;
import network.Connection;
import network.CommunicationConstants;

import java.util.Arrays;

public class ConnectionAcceptThread extends Thread {
	
	public static final int BUFFER_SIZE = 1024;
	public static final int TIMEOUT_MS  = 5000;
	
	private Server server;
	private ServerSocket serverSocket;
	
	public ConnectionAcceptThread(Server server, ServerSocket serverSocket) {
		this.server       = server;
		this.serverSocket = serverSocket;
	}
	
	@Override
	public void run() {
		
		Socket               sock;
		InputStream          is;
		ByteBuffer           bbuf;
		byte[]               raw_bytes;
		int                  read_bytes;
		
		while(true) {
			
			try {
				sock = this.serverSocket.accept();
				sock.setSoTimeout(TIMEOUT_MS);
				is   = sock.getInputStream();
			} catch(IOException e) {
				System.exit(-1);
				return;
			}
			
			StringBuilder usernameBuilder = new StringBuilder();
			long t_start                  = System.currentTimeMillis();
			
			raw_bytes   = new byte[BUFFER_SIZE];
			int bytes_w = 0;
			
			while(System.currentTimeMillis() - t_start < TIMEOUT_MS) {
				try {
					int b = is.read();
					
					if(b == -1)
						break;
					
					if(bytes_w < BUFFER_SIZE)
						raw_bytes[bytes_w++] = (byte) b;
					
					
				} catch(Exception e) {
					System.out.println("Client lost connection " + sock.getInetAddress());
					break;
				}
			}
			
			bbuf = ByteBuffer.wrap(raw_bytes);
			bbuf.rewind();
			
			/** Get the random int */
			bbuf.getInt();
			
			try {
				/** Get the username */
				for(int i = 0; i < bytes_w; i++) {
					usernameBuilder.append(bbuf.getChar());
				}
			} catch(Exception e) {e.printStackTrace();}
			
			//System.out.println(Arrays.toString(raw_bytes));
			
			System.out.println(Arrays.toString(Arrays.copyOfRange(bbuf.array(), 0, bytes_w)));
			System.out.println(usernameBuilder.toString());
			
			
			
			/***
			
			try {
				read_bytes = dis.read(raw_bytes);
			} catch(Exception e) {
				// EVENT ?
				continue;
			}
			
			bbuf = ByteBuffer.wrap(raw_bytes);
			
			try {
				

				bbuf.getInt();
				

				for(int i = bbuf.position(); i < read_bytes; i++)
					usernameBuilder.append(bbuf.getChar());
				
				
			} catch(BufferUnderflowException e) {
				// EVENT ?
				continue;
			}
			
			Connection con = new Connection(new Player(usernameBuilder.toString()), sock);
			this.server.addConnection(con);
			System.out.println("Name: " + usernameBuilder.toString());
			*/
		}
	}
	
}