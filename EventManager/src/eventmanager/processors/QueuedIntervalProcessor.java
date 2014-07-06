package eventmanager.processors;

import eventmanager.events.IEvent;

public class QueuedIntervalProcessor extends AIntervalProcessor {

	public void processEvents() {
		if(super.events.size()>0){
			IEvent event = super.events.get(0);
			event.run();
			int interval = super.intervalMap.get(event.pullID());
			interval--;
			if(interval<=0){
				super.unregisterEvent(event.pullID());
			}
			else
				super.intervalMap.put(event.pullID(), interval);
		}
	}

}
