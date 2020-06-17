package network;

import java.util.Arrays;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;

public class Connection {

	private Player player;
	private Socket socket;
	private BufferedInputStream bis;
	
	public Connection(Player player, Socket socket) {
		this.player = player;
		this.socket = socket;
		
		try {
			this.bis = new BufferedInputStream(socket.getInputStream());
		} catch(IOException e) {
			this.bis = null;
			// Event ?
		}
	}
	
	public Socket getSocket() {
		return this.socket;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public BufferedInputStream getBufferedInputStream() {
		return this.bis;
	}
	
	public byte[] getNextData(int buffer) {
		try {
			byte[] data = new byte[buffer];
			int    read = this.bis.read(data, 0, buffer);
			return Arrays.copyOfRange(data, 0, read);
		} catch(IOException e) {
			return null;
		}
	}
	
	public boolean hasNextData() {
		try {
			return this.bis.available() > 1;
		} catch(Exception e) {
			return false;
		}
	}
}