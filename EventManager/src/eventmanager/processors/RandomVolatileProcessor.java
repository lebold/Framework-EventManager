package eventmanager.processors;

import eventmanager.events.IEvent;

/**
 * @author Patrick Lebold
 * This class is a brand of IProcessor that processes events in volatile-style.
 * Volatile-style processors remove events after being processed
 * Random-based processors only process one registered event per cycle.
 */
public class RandomVolatileProcessor extends AProcessor {

	public void processEvents() {
		if(super.events.size()>0){
			int size = super.events.size();
			int index = (int)(size*Math.random());
			IEvent event = super.events.get(index);
			event.run();
			super.unregisterEvent(event.pullID());
		}
	}

}
