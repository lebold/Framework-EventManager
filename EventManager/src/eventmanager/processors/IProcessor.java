package eventmanager.processors;

import eventmanager.events.IEvent;

public interface IProcessor {
	
	public void processEvents();
	public void registerEvent(IEvent e);
	public void unregisterEvent(Object id);
	
}
