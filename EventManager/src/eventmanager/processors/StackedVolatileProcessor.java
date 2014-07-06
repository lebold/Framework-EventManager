package eventmanager.processors;

import eventmanager.events.IEvent;

public class StackedVolatileProcessor extends AProcessor {

	public void processEvents() {
		if(super.events.size()>0){
			int index = super.events.size()-1;
			IEvent event = super.events.get(index);
			event.run();
			super.unregisterEvent(event.pullID());
		}
	}

}
