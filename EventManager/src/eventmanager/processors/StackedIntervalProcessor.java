package eventmanager.processors;

import eventmanager.events.IEvent;

public class StackedIntervalProcessor extends AIntervalProcessor {

	public void processEvents() {
		if(super.events.size()>0){
			int index = super.events.size()-1;
			IEvent event = super.events.get(index);
			event.run();
			int interval = super.intervalMap.get(event.pullID());
			interval--;
			if(interval<=0)
				super.unregisterEvent(event.pullID());
			else
				super.intervalMap.put(event.pullID(),interval);
		}
	}

}
