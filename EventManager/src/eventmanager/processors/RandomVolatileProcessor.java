package eventmanager.processors;

import eventmanager.events.IEvent;

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
