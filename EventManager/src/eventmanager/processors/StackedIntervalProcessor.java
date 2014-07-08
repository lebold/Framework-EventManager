package eventmanager.processors;

import eventmanager.events.IEvent;

/**
 * @author Patrick Lebold
 * This class is a brand of IProcessor that processes events in interval-style.
 * See class-AIntervalProcessor for info on interval-style.
 * Stack-based processors only process the last event in the stack.
 */
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
