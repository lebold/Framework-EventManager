package eventmanager.processors;

/**
 * @author Patrick Lebold
 * This class is a brand of IProcessor that processes events in stable-style.
 * Stable-style processors do not remove events by themselves.
 * Queue-based processors only process the first event in the queue.
 */
public class QueuedStableProcessor extends AProcessor {

	public void processEvents() {
		if(super.events.size()>0)
			events.get(0).run();
	}

}
