package eventsystem.events;

import serialization.Serializable;

/**
* Represents the interface for any Event.
* 
* @author Cedric Wellhausen
* @version June 12 2020
*/
public interface Event extends Serializable {
	Event copy();
}