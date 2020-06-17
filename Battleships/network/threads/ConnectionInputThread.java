package network.threads;

import java.util.List;
import java.util.Arrays;

import network.Server;
import network.Connection;

public class ConnectionInputThread extends Thread {
	
	private Server server;
	
	public ConnectionInputThread(Server server) {
		this.server = server;
	}
	
	@Override
	public void run() {
		while(true) {
			for(Connection con : this.server.getConnections()) {
				if(con.hasNextData()) {
					System.out.println(Arrays.toString(con.getNextData(100)));
				}
			}
		
			try {
				Thread.sleep(2);
			}
			catch(Exception e) {}
		}
	}
	
}