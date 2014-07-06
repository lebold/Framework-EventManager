package eventmanager.processors;

public class QueuedStableProcessor extends AProcessor {

	public void processEvents() {
		if(super.events.size()>0)
			events.get(0).run();
	}

}
