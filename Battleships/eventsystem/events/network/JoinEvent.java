package eventsystem.events.network;


public class JoinEvent implements Event {
	
	/**
	* The player that attempts to join.
	*/
	private Player player;
	
	/**
	* Constructs a new JoinEvent. This event should be called if a Client attempts to Join the Server.
	* @param player A Player.
	*/
	public JoinEvent(Player player) {
		this.player = player;
	}
	
	/**
	* Constructs a new JoinEvent. This event should be called if a Client attempts to Join the Server.
	* Initialises everything to null.
	*/
	public JoinEvent() {
		this.player = null;
	}
	
	
	@Override
	public Event copy() {
		return null;
	}
	
	@Override
	public byte[] serialize() {
		return null;
	}
	
	@Override
	public Serializable deserialize(byte[]) {
		return null;
	}
	
}