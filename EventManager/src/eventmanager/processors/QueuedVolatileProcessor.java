package eventmanager.processors;

import eventmanager.events.IEvent;

public class QueuedVolatileProcessor extends AProcessor {

	public void processEvents() {
		if(super.events.size()>0){
			IEvent event = super.events.get(0);
			event.run();
			super.unregisterEvent(event.pullID());
		}
	}

}
