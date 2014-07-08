package eventmanager.processors;

import eventmanager.events.IEvent;

/**
 * @author Patrick Lebold
 * This class is a brand of IProcessor that processes events in stable-style.
 * Stable-style processors do not remove events by themselves.
 * Random-based processors only process one registered event per cycle.
 */
public class RandomStableProcessor extends AProcessor {

	public void processEvents() {
		if(super.events.size()>0){
			int size = super.events.size();
			int index = (int)(size*Math.random());
			IEvent event = super.events.get(index);
			event.run();
		}
	}

}
