package eventsystem;

import eventsystem.events.Event;
import eventsystem.Listener;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
* The EventManager sends called Events to all of the registered Listeners. The EventManager targets all Methods in a class that are
* annotated by the {@link eventsystem.EventHandler EventHandler} annotation. These Methods must have exaclty one Argument which has to be
* a subclass of the {@link eventsystem.events.Event Event} class.
* @author Cedric Wellhausen
* @version June 12 2020
*/
public class EventManager {
	
	/**
	* A list that contains all registered Listeners.
	*/
	private ArrayList<Listener> managedListeners;
	
	/**
	* Construct new EventManager.
	*/
	public EventManager() {
		this.managedListeners = new ArrayList<>();
	}
	
	/**
	* Unregisters all attached Listeners. Do not attempt to call this method from another Thread.
	*/
	public void unregisterAll() {
		this.managedListeners.clear();
	}
	
	/**
	* Unregisters specific listeners. Do not attempt to call this method from another Thread.
	* @param listeners Listeners that should be unregistered.
	*/
	public void unregisterListeners(Listener... listeners) {
		for(Listener listener : listeners)
			this.managedListeners.remove(listener);
	}
	
	/**
	* Registers listeners. Do not attempt to call this method from another Thread.
	* @param listeners Listeners that should be registered.
	*/
	public void registerListeners(Listener... listeners) {
		for(Listener listener : listeners)
			this.managedListeners.add(listener);
	}
	
	/**
	* Calls all Listeners that subscribed to the called event and sends a reference of the Event to these Listeners.
	* 
	* @param e An Event to call.
	* @return Amount of called Listeners.
	*/
	public int call(Event e) {
			int calls = 0;
		
			for(Listener listener : this.managedListeners) {
				Class<?> listenerClass = listener.getClass();
				Method[] methods       = listenerClass.getMethods();
				
				for(Method method : methods)
					if(method.getAnnotation(EventHandler.class) != null && method.getParameterCount() == 1 && this.isSameEventParameter(e, method, 0)) {
						try {
							method.invoke(listener, e);
							calls++;
						} catch(Exception ex) {}
					}
		
			}
		return calls;
	}
	
	/**
	* Checks whether the parameter of the Method at the given index is the same Class type as the given Event.
	* @param e An Event.
	* @param m A Method.
	* @param parameterIndex Index of the Parameter.
	*/
	private boolean isSameEventParameter(Event e, Method m, int parameterIndex) {
		
		Type[] types = m.getGenericParameterTypes();
		
		try {
		
			if(parameterIndex >= 0 && parameterIndex < types.length) {
				String className = m.getGenericParameterTypes()[parameterIndex].getTypeName();
				
				if(Class.forName(className) == e.getClass()) {
					return true;
				}
			}
		} catch(Exception ex) {}
		
		return false;
	}
}
