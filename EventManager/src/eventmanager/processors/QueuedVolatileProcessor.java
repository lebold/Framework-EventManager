package eventmanager.processors;

import eventmanager.events.IEvent;

/**
 * @author Patrick Lebold
 * This class is a brand of IProcessor that processes events in volatile-style.
 * Volatile-style processors remove events after being processed
 * Queue-based processors only process the first event in the queue.
 */
public class QueuedVolatileProcessor extends AProcessor {

	public void processEvents() {
		if(super.events.size()>0){
			IEvent event = super.events.get(0);
			event.run();
			super.unregisterEvent(event.pullID());
		}
	}

}
