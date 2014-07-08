package eventmanager.processors;

import eventmanager.events.IEvent;

/**
 * @author Patrick Lebold
 * This class is a brand of IProcessor that processes events in stable-style.
 * Stable-style processors do not remove events by themselves.
 * Stack-based processors only process the last event in the stack.
 */
public class StackedStableProcessor extends AProcessor {

	public void processEvents() {
		if(super.events.size()>0){
			int index = super.events.size()-1;
			IEvent event = super.events.get(index);
			event.run();
		}
	}

}
