package network;

import serialization.Serializable;
import network.threads.ConnectionAcceptThread;
import network.threads.ConnectionInputThread;

import java.net.ServerSocket;
import java.net.Socket;

import java.io.IOException;
import java.util.ArrayList;

public class Server {
	
	public static final int MAX_PLAYERS = 2;
	public static final int MIN_PLAYER  = 2;
	
	private Thread connectionAcceptThread;
	private Thread connectionInputThread;
	
	private ArrayList<Connection> connections;
	
	private ServerSocket ss;
	private int port; 
	
	public Server(int port) {
		
		try {
			this.ss   = new ServerSocket(port);
		} catch(IOException e) {
			System.exit(-1);
			return;
		}
		
		this.port = port;
		
		this.connections = new ArrayList<>();
		
		this.connectionAcceptThread = new ConnectionAcceptThread(this, this.ss);
		this.connectionInputThread  = new ConnectionInputThread(this);
		
		this.connectionAcceptThread.start();
		this.connectionInputThread.start();
	}
	
	public void addConnection(Connection con) {
		if(this.connections.size() < Server.MAX_PLAYERS)
			this.connections.add(con);
		else
			return; // new ConnectionRefuesedEvent();
	}
	
	public void removeConnection(Connection con) {
		if(this.connections.contains(con))
			this.connections.remove(con);
		else
			return; // new PlayerNotConnectedEvent();
	}
	
	public ArrayList<Connection> getConnections() {
		return this.connections;
	}
	
}