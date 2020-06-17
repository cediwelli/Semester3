package eventsystem;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
/**
* This is the Tag that needs to be applied to every Method in a Listener, that wants to be addressed by the EventManager.
* @author Cedric Wellhausen
* @version June 12 2020
*/
public @interface EventHandler {}