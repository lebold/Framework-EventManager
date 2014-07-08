package eventmanager.events;

/**
 * @author Patrick Lebold
 * This interface outlines what defines a processable event.
 */
public interface IEvent{
	public void registerID(Object id);
	public Object pullID();
	public boolean validate(Object id);
	public void run();
}
