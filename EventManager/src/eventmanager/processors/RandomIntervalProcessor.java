package eventmanager.processors;

import eventmanager.events.IEvent;

public class RandomIntervalProcessor extends AIntervalProcessor {

	public void processEvents() {
		if(super.events.size()>0){
			int size = super.events.size();
			int index = (int)(size*Math.random());
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
