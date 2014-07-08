package eventmanager.processors;

import eventmanager.events.IEvent;

/**
 * @author Patrick Lebold
 * This interface outlines what methods need to be present for all processors.
 */
public interface IProcessor {
	
	public void processEvents();
	public void registerEvent(IEvent e);
	public void unregisterEvent(Object id);
	
}
