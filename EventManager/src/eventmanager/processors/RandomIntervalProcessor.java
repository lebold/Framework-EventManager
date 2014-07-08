package eventmanager.processors;

import eventmanager.events.IEvent;

/**
 * @author Patrick Lebold
 * This class is a brand of IProcessor that processes events in interval-style.
 * See class-AIntervalProcessor for info on interval-style.
 * Random-based processors only process one registered event per cycle.
 */
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
