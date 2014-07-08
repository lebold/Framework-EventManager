package eventmanager.processors;

import eventmanager.events.IEvent;

/**
 * @author Patrick Lebold
 * This class is a brand of IProcessor that processes events in volatile-style.
 * Volatile-style processors remove events after being processed
 * Stack-based processors only process the last event in the stack.
 */
public class StackedVolatileProcessor extends AProcessor {

	public void processEvents() {
		if(super.events.size()>0){
			int index = super.events.size()-1;
			IEvent event = super.events.get(index);
			event.run();
			super.unregisterEvent(event.pullID());
		}
	}

}
